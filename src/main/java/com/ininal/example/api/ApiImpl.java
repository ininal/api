package com.ininal.example.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ininal.example.api.constant.WorkshopConstant;
import com.ininal.example.api.data.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * Created by cihanozdemir on 11.11.2017.
 */
@Repository("apiIf")
public class ApiImpl implements ApiIF
{

    public AccessTokenResponse accessToken()
    {
        //encoded api credentials-> base64(apiKey:secretKey)
        String token = "NzlhYTE5MTViNzIyM2QyYjE2YWQzZDQxYmFjYTAyYTY2ZDRiOTBkYWMxOWQ3NjJhNTk4MTI0MTdjODJmZjJiZTozYzg4MDM5NjEzNjIzMDE2NWVjZGZmODQ4Y2NlNjZiMzMzMjY5MDljMjE0MGRiZjVjN2M1YmM4MWE0ZmU0NzQxMDVlMzczOTE4ODdjNjgyNTI0ODUzODA2NGU5ZTlmNmIwNjM5OGUzMDBkYTY4YzAzY2QwZTlhNGEzNDVlOTRmMQ==";

        //create http post request with headers
        HttpPost httpPost = new HttpPost("https://sandbox-api.ininal.com/v2/oauth/accesstoken");
        httpPost.addHeader("Date",new Date().toString());
        httpPost.addHeader("Language","TR");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Authorization","Basic " + token);

        //create client for request
        CloseableHttpClient client = HttpClientBuilder.create().build();

        String response = null;
        try
        {
            //execute post request and take response
            HttpResponse httpResponse = client.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            response = EntityUtils.toString(httpEntity,"UTF-8");

            //response parameters from json and map to related object
            ObjectMapper mapper = new ObjectMapper();
            Result result = mapper.readValue(response, Result.class);

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_OK)
                return null;

            return mapper.convertValue(result.getResponse(), AccessTokenResponse.class);

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public AccessTokenResponse getAccessToken()
    {
        //apikey:secretkey base64 encoded token
        String TOKEN = "NzlhYTE5MTViNzIyM2QyYjE2YWQzZDQxYmFjYTAyYTY2ZDRiOTBkYWMxOWQ3NjJhNTk4MTI0MTdjODJmZjJiZTozYzg4MDM5NjEzNjIzMDE2NWVjZGZmODQ4Y2NlNjZiMzMzMjY5MDljMjE0MGRiZjVjN2M1YmM4MWE0ZmU0NzQxMDVlMzczOTE4ODdjNjgyNTI0ODUzODA2NGU5ZTlmNmIwNjM5OGUzMDBkYTY4YzAzY2QwZTlhNGEzNDVlOTRmMQ==";

        //create HttpPost request with headers
        HttpPost httpPost = new HttpPost("https://sandbox-api.ininal.com/v2/oauth/accesstoken");
        httpPost.addHeader("Date", new Date().toString());
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Language", "TR");
        httpPost.addHeader("Authorization", "Basic " + TOKEN);

        //create client to make request
        CloseableHttpClient client = HttpClientBuilder.create().build();

        String response = null;
        try
        {
            //execute post request and take response
            HttpResponse httpResponse = client.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            response = EntityUtils.toString(entity,"UTF-8");

            //use objectMapper to get Json response
            ObjectMapper mapper = new ObjectMapper();
            Result result = mapper.readValue(response,Result.class);

            return mapper.convertValue(result.getResponse(), AccessTokenResponse.class);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private Result httpPost(String url, String accessToken, String data)
    {
        Result result = new Result();
        //create HttpPost with headers
        HttpPost postRequest = new HttpPost(url);
        StringEntity serializedData = new StringEntity(data, StandardCharsets.UTF_8.displayName());
        postRequest.addHeader(new BasicHeader(WorkshopConstant.DATE, new Date().toString()));
        postRequest.addHeader(new BasicHeader(WorkshopConstant.AUTHORIZATION, WorkshopConstant.BEARER + accessToken));
        postRequest.addHeader(new BasicHeader(WorkshopConstant.CONTENT_TYPE, WorkshopConstant.APPLICATION_JSON));
        postRequest.addHeader(new BasicHeader(WorkshopConstant.LANGUAGE,WorkshopConstant.TR));

        //set request data to httpPost
        postRequest.setEntity(serializedData);

        //create client to make request
        CloseableHttpClient client = HttpClientBuilder.create().build();

        try
        {
            String responseStr;
            //HttpResponse from client and cast to String
            HttpResponse e = client.execute(postRequest);
            HttpEntity httpEntity = e.getEntity();
            responseStr = EntityUtils.toString(httpEntity, WorkshopConstant.UTF8);

            //use objectMapper to get Json response
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseStr, Result.class);

        }
        catch (Exception var6)
        {
            return result;
        }
    }

    private Result httpGet(String url, String accessToken)
    {
        Result result = new Result();
        //create HttpGet with headers
        HttpGet getRequest = new HttpGet(url);
        getRequest.addHeader(new BasicHeader(WorkshopConstant.DATE, new Date().toString()));
        getRequest.addHeader(new BasicHeader(WorkshopConstant.AUTHORIZATION, WorkshopConstant.BEARER + accessToken));
        getRequest.addHeader(new BasicHeader(WorkshopConstant.CONTENT_TYPE, WorkshopConstant.APPLICATION_JSON));
        getRequest.addHeader(new BasicHeader(WorkshopConstant.LANGUAGE, WorkshopConstant.TR));

        //create client to make request
        CloseableHttpClient client = HttpClientBuilder.create().build();

        try
        {
            //HttpResponse from client and cast to String
            HttpResponse e = client.execute(getRequest);
            HttpEntity httpEntity = e.getEntity();
            String responseStr = EntityUtils.toString(httpEntity, WorkshopConstant.UTF8);

            //use objectMapper to get Json response
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseStr, Result.class);

        }
        catch (Exception var6)
        {
            return result;
        }
    }

    private Result httpPut(String url, String accessToken, String data)
    {
        Result result = new Result();
        //create HttpPut with headers
        HttpPut putRequest = new HttpPut(url);
        StringEntity serializedData = new StringEntity(data, StandardCharsets.UTF_8.displayName());
        putRequest.addHeader(new BasicHeader(WorkshopConstant.DATE, new Date().toString()));
        putRequest.addHeader(new BasicHeader(WorkshopConstant.AUTHORIZATION, WorkshopConstant.BEARER + accessToken));
        putRequest.addHeader(new BasicHeader(WorkshopConstant.CONTENT_TYPE, WorkshopConstant.APPLICATION_JSON));
        putRequest.addHeader(new BasicHeader(WorkshopConstant.LANGUAGE,WorkshopConstant.TR));

        //set request data to httpPut
        putRequest.setEntity(serializedData);

        //create client to make request
        CloseableHttpClient client = HttpClientBuilder.create().build();

        try
        {
            //HttpResponse from client and cast to String
            HttpResponse e = client.execute(putRequest);
            HttpEntity httpEntity = e.getEntity();
            String responseStr = EntityUtils.toString(httpEntity, WorkshopConstant.UTF8);

            //use objectMapper to get Json response
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseStr, Result.class);

        }
        catch (Exception var6)
        {
            return result;
        }
    }

    @Override
    public CreateUserResponse createUser(String accessToken, CreateUserRequest createUserRequest)
    {
        try {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.CREATE_USER_URI;

            //get result from httpPost
            Result result = httpPost(url, accessToken, new Gson().toJson(createUserRequest));

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_CREATED)
                return null;

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), CreateUserResponse.class);

        } catch (Exception var6) {
            return null;
        }
    }

    @Override
    public GetUserResponse userInformation(String accessToken, String userToken)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.GET_USER_INFORMATION_URI + userToken;

            //get result from httpPost
            Result result = httpGet(url, accessToken);

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_OK)
                return null;

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), GetUserResponse.class);

        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public Result userGsmNumberUpdate(String accessToken, String userToken, UserGsmNumberUpdateRequest userGsmNumberUpdateRequest)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.UPDATE_USER_GSMNUMBER_URI.replace(WorkshopConstant.USER_TOKEN_PARAMETER, userToken);

            //get result from httpPost
            return httpPost(url, accessToken, new Gson().toJson(userGsmNumberUpdateRequest));

        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public AssignCardToUserResponse assignCardToUser(String accessToken, String userToken, AssignCardToUserRequest assignCardToUserRequest)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.ASSIGN_CARD_TO_USER_URI.replace(WorkshopConstant.USER_TOKEN_PARAMETER,userToken);

            //get result from httpPost
            Result result = httpPost(url, accessToken, new Gson().toJson(assignCardToUserRequest));

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_CREATED)
                return null;

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), AssignCardToUserResponse.class);

        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public UserCardsInformation userCardsInformation(String accessToken, String userToken)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.GET_USER_CARDS_INFORMATION_URI + userToken;

            //get result from httpPost
            Result result = httpGet(url, accessToken);

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_OK)
                return null;

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), UserCardsInformation.class);

        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public SendOtpResponse sendOtpToVerifyUser(String accessToken, String userToken)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.SEND_OTP_TO_VERIFY_USER_URI.replace(WorkshopConstant.USER_TOKEN_PARAMETER,userToken);
            //get result from httpPost
            Result result = httpPost(url, accessToken, new Gson().toJson(null));

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_OK)
                return null;

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), SendOtpResponse.class);
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public Result verifyOTP(String accessToken, String userToken, VerifyOTPRequest verifyOTPRequest)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.VERIFY_OTP_URI.replace(WorkshopConstant.USER_TOKEN_PARAMETER, userToken);

            //get result from httpPost and return result
            return httpPost(url, accessToken, new Gson().toJson(verifyOTPRequest));

        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public CreateVirtualCardToUserResponse createVirtualCardToUser(String accessToken, String userToken, CreateVirtualCardRequest createVirtualCardRequest)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.CREATE_VIRTUAL_CARD_TO_USER_URI.replace(WorkshopConstant.USER_TOKEN_PARAMETER, userToken);

            //get result from httpPost
            Result result = httpPost(url, accessToken, new Gson().toJson(createVirtualCardRequest));

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_OK)
                return null;

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), CreateVirtualCardToUserResponse.class);
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public GetCardInfoResponse getCardInfo(String accessToken, String cardToken)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.GET_CARD_INFO_URI + cardToken;

            //get result from httpGet
            Result result = httpGet(url, accessToken);

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_OK)
                return null;

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), GetCardInfoResponse.class);
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public CreateAnonymousVirtualCardResponse createAnonymousVirtualCard(String accessToken)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.CREATE_ANONYMOUS_VIRTUAL_CARD_URI;

            //get result from httpPost
            Result result = httpPost(url, accessToken, new Gson().toJson(null));

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_CREATED)
                return null;

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), CreateAnonymousVirtualCardResponse.class);
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public Result cardStatusUpdate(String accessToken, UpdateCardStatusRequest updateCardStatusRequest)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.CARD_STATUS_UPDATE_URI;

            //get result from httpPut
            return httpPut(url, accessToken, new Gson().toJson(updateCardStatusRequest));
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public CardBalanceResponse queryCardBalance(String accessToken, String cardToken)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.CARD_BALANCE_URI.replace(WorkshopConstant.CARD_TOKEN_PARAMETER,cardToken);

            //get result from httpGet
            Result result = httpGet(url, accessToken);

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_OK)
                return null;

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), CardBalanceResponse.class);
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public Result cardPinOperations(String accessToken, String cardToken, CardPinOperationsRequest cardPinOperationsRequest)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.CARD_STATUS_UPDATE_URI;

            //get result from httpPut
            return httpPut(url, accessToken, new Gson().toJson(cardPinOperationsRequest));
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public CardTransactionResponse queryCardTransactions(String accessToken, String cardToken, String start_date, String end_date)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.CARD_TRANSACTIONS_URI.replace(WorkshopConstant.CARD_TOKEN_PARAMETER, cardToken);
            url = url.replace(WorkshopConstant.START_DATE, start_date);
            url = url.replace(WorkshopConstant.END_DATE, end_date);

            // to send date as parameter in url, we need to replace whitespaces with %20
            url = url.replace(WorkshopConstant.WHITESPACE, WorkshopConstant.URL_WHITESPACE_REPLACE);

            //get result from httpGet
            Result result = httpGet(url, accessToken);

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_OK)
                return null;

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), CardTransactionResponse.class);
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public PreCardToCardTransferResponse preCardToCardTransfer(String accessToken, String sourceCardToken, PreCardToCardTransferRequest preCardToCardTransferRequest)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.CARD_TO_CARD_TRANSFER_URI.replace(WorkshopConstant.SOURCE_CARD_TOKEN_PARAMETER, sourceCardToken);

            //get result from httpPost
            Result result = httpPost(url, accessToken, new Gson().toJson(preCardToCardTransferRequest));

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_OK)
                return null;

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), PreCardToCardTransferResponse.class);
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public Result completeCardToCardTransfer(String accessToken, String sourceCardToken, CompleteCardToCardTransferRequest completeCardToCardTransferRequest)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.CARD_TO_CARD_TRANSFER_URI.replace(WorkshopConstant.SOURCE_CARD_TOKEN_PARAMETER, sourceCardToken);

            //get result from httpPost
            return httpPut(url, accessToken, new Gson().toJson(completeCardToCardTransferRequest));
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public LoadBalanceResponse loadBalance(String accessToken, LoadBalanceRequest loadBalanceRequest)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.TRANSACTIONS_IN_URI;

            //get result from httpPost
            Result result = httpPost(url, accessToken, new Gson().toJson(loadBalanceRequest));

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_OK)
                return null;

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), LoadBalanceResponse.class);
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public Result cancelLoadBalance(String accessToken, CancelLoadBalanceRequest cancelLoadBalanceRequest)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.TRANSACTIONS_IN_CANCEL_URI;

            //get result from httpPost
            return httpPost(url, accessToken, new Gson().toJson(cancelLoadBalanceRequest));
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public PreCollectMoneyResponse preCollectMoney(String accessToken, PreCollectMoneyRequest preCollectMoneyRequest)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.TRANSACTIONS_OUT_URI;

            //get result from httpPost
            Result result = httpPost(url, accessToken, new Gson().toJson(preCollectMoneyRequest));

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_OK)
                return null;

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), PreCollectMoneyResponse.class);
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public CompleteCollectMoneyResponse completeCollectMoney(String accessToken, String provision_code, CompleteCollectMoneyRequest completeCollectMoneyRequest)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.TRANSACTIONS_OUT_VERIFY_URI.replace(WorkshopConstant.PROVISION_CODE_PARAMETER,provision_code);

            //get result from httpPost
            Result result = httpPost(url, accessToken, new Gson().toJson(completeCollectMoneyRequest));

            //check if return success or not
            if(result.getHttpCode() != HttpStatus.SC_OK)
                return null;

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), CompleteCollectMoneyResponse.class);
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public Result cancelCollectMoney(String accessToken, CancelCollectMoneyRequest cancelCollectMoneyRequest)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.TRANSACTIONS_OUT_CANCEL_URI;

            //get result from httpPost
            return httpPost(url, accessToken, new Gson().toJson(cancelCollectMoneyRequest));
        }
        catch (Exception var6)
        {
            return null;
        }
    }

    @Override
    public NearestLocationsResponse nearestLocations(String accessToken, String coordinateX, String coordinateY)
    {
        try
        {
            String url = WorkshopConstant.BASE_URL + WorkshopConstant.TRANSACTIONS_LOCATIONS_URI;
            url = url.replace(WorkshopConstant.COORDINATE_X, coordinateX);
            url = url.replace(WorkshopConstant.COORDINATE_Y, coordinateY);

            //get result from httpPost
            Result result = httpGet(url, accessToken);

            //cast response from result to related response object
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(result.getResponse(), NearestLocationsResponse.class);
        }
        catch (Exception var6)
        {
            return null;
        }
    }
}
