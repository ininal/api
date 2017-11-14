package com.ininal.example.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ininal.example.api.constant.WorkshopConstant;
import com.ininal.example.api.data.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
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
    //apikey:secretkey base64 encoded token
    public static final String TOKEN = "NzlhYTE5MTViNzIyM2QyYjE2YWQzZDQxYmFjYTAyYTY2ZDRiOTBkYWMxOWQ3NjJhNTk4MTI0MTdjODJmZjJiZTozYzg4MDM5NjEzNjIzMDE2NWVjZGZmODQ4Y2NlNjZiMzMzMjY5MDljMjE0MGRiZjVjN2M1YmM4MWE0ZmU0NzQxMDVlMzczOTE4ODdjNjgyNTI0ODUzODA2NGU5ZTlmNmIwNjM5OGUzMDBkYTY4YzAzY2QwZTlhNGEzNDVlOTRmMQ==";

    @Override
    public AccessTokenResponse getAccessToken()
    {
        //create HttpPost with headers
        HttpPost httpPost = new HttpPost("https://sandbox-api.ininal.com/v2/oauth/accesstoken");
        httpPost.addHeader("Date", new Date().toString());
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Language", "TR");
        httpPost.addHeader("Authorization","Basic " + TOKEN);

        //create client to make request
        CloseableHttpClient client = HttpClientBuilder.create().build();

        String response = null;
        try
        {
            //HttpResponse from client and cast to String
            HttpResponse httpResponse = client.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            response = EntityUtils.toString(entity,"UTF-8");

            //use objectMapper to get Json response
            ObjectMapper mapper = new ObjectMapper();
            Result result = mapper.readValue(response,Result.class);

            AccessTokenResponse accessTokenResponse = (AccessTokenResponse) result.getResponse();
            return  accessTokenResponse;
        } catch (IOException e)
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
        StringEntity serializedDate = new StringEntity(data, StandardCharsets.UTF_8.displayName());
        postRequest.addHeader(new BasicHeader(WorkshopConstant.DATE, new Date().toString()));
        postRequest.addHeader(new BasicHeader(WorkshopConstant.AUTHORIZATION, WorkshopConstant.BEARER + accessToken));
        postRequest.addHeader(new BasicHeader(WorkshopConstant.CONTENT_TYPE, WorkshopConstant.APPLICATION_JSON));
        postRequest.addHeader(new BasicHeader(WorkshopConstant.LANGUAGE,WorkshopConstant.TR));

        //set request data to httpPost
        postRequest.setEntity(serializedDate);

        //create client to make request
        CloseableHttpClient client = HttpClientBuilder.create().build();

        try {
            String responseStr;
            //HttpResponse from client and cast to String
            HttpResponse e = client.execute(postRequest);
            HttpEntity httpEntity = e.getEntity();
            responseStr = EntityUtils.toString(httpEntity, WorkshopConstant.UTF8);

            //use objectMapper to get Json response
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseStr, Result.class);

        } catch (Exception var6) {
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
        getRequest.addHeader(new BasicHeader(WorkshopConstant.LANGUAGE,WorkshopConstant.TR));

        //create client to make request
        CloseableHttpClient client = HttpClientBuilder.create().build();

        try {
            //HttpResponse from client and cast to String
            HttpResponse e = client.execute(getRequest);
            HttpEntity httpEntity = e.getEntity();
            String responseStr = EntityUtils.toString(httpEntity, WorkshopConstant.UTF8);

            //use objectMapper to get Json response
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseStr, Result.class);

        } catch (Exception var6) {
            return result;
        }
    }

    @Override
    public CreateUserResponse createUser(String accessToken, CreateUserRequest createUserRequest)
    {
        try {
            //get result from httpPost
            Result result = httpPost(WorkshopConstant.CREATE_USER_URL, accessToken, new Gson().toJson(createUserRequest));

            //cast response from result to related response object
            return (CreateUserResponse) result.getResponse();

        } catch (Exception var6) {
            return null;
        }
    }

    @Override
    public SendOtpResponse sendOtpToVerifyUser(String accessToken, String userToken)
    {
        try {
            String url = WorkshopConstant.SEND_OTP_TO_VERIFY_USER_URL_PART_1 + userToken + WorkshopConstant.SEND_OTP_TO_VERIFY_USER_URL_PART_2;
            //get result from httpPost
            Result result = httpPost(url, accessToken, new Gson().toJson(null));

            //cast response from result to related response object
            return  (SendOtpResponse) result.getResponse();
        } catch (Exception var6) {
            return null;
        }
    }

    @Override
    public Result verifyOTP(String accessToken, String userToken, VerifyOTPRequest verifyOTPRequest)
    {
        try {
            String url = WorkshopConstant.VERIFY_OTP_URL_PART_1 + userToken + WorkshopConstant.VERIFY_OTP_URL_PART_2;

            //get result from httpPost and return result
            return httpPost(url, accessToken, new Gson().toJson(verifyOTPRequest));

        } catch (Exception var6) {
            return null;
        }
    }

    @Override
    public CreateVirtualCardToUserResponse createVirtualCardToUser(String accessToken, String userToken, CreateVirtualCardRequest createVirtualCardRequest)
    {
        try {
            String url = WorkshopConstant.CREATE_VIRTUAL_CARD_TO_USER_URL_PART1 + userToken + WorkshopConstant.CREATE_VIRTUAL_CARD_TO_USER_URL_PART1 ;

            //get result from httpPost
            Result result = httpPost(url, accessToken, new Gson().toJson(createVirtualCardRequest));

            //cast response from result to related response object
            return  (CreateVirtualCardToUserResponse) result.getResponse();
        } catch (Exception var6) {
            return null;
        }
    }

    @Override
    public LoadBalanceResponse loadBalance(String accessToken,String userToken, LoadBalanceRequest loadBalanceRequest)
    {
        try {
            String url = WorkshopConstant.LOAD_BALANCE_URL ;

            //get result from httpPost
            Result result = httpPost(url, accessToken, new Gson().toJson(loadBalanceRequest));

            //cast response from result to related response object
            return (LoadBalanceResponse) result.getResponse();
        } catch (Exception var6) {
            return null;
        }
    }

    @Override
    public GetCardInfoResponse getCardInfo(String accessToken, String cardToken)
    {
        try {
            String url = WorkshopConstant.GET_CARD_INFO_URL  + cardToken;

            //get result from httpGet
            Result result = httpGet(url, accessToken);

            //cast response from result to related response object
            return  (GetCardInfoResponse) result.getResponse();
        } catch (Exception var6) {
            return null;
        }
    }
}
