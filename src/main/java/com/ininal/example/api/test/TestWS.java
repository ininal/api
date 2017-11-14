package com.ininal.example.api.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ininal.example.api.data.AccessTokenResponse;
import com.ininal.example.api.data.Result;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Date;

/**
 * Created by yaseminbakir on 11.11.2017.
 */
public class TestWS
{
    public static void main(String[] args)
    {
        String TOKEN = "NlhYTE5MTViNzIyM2QyYjE2YWQzZDQxYmFjYTAyYTY2ZDRiOTBkYWMxOWQ3NjJhNTk4MTI0MTdjODJmZjJiZTozYzg4MDM5NjEzNjIzMDE2NWVjZGZmODQ4Y2NlNjZiMzMzMjY5MDljMjE0MGRiZjVjN2M1YmM4MWE0ZmU0NzQxMDVlMzczOTE4ODdjNjgyNTI0ODUzODA2NGU5ZTlmNmIwNjM5OGUzMDBkYTY4YzAzY2QwZTlhNGEzNDVlOTRmMQ==";

        HttpPost post = new HttpPost("https://sandbox-api.ininal.com/v2/oauth/accesstoken");
        post.addHeader(new BasicHeader("Date", new Date().toString()));
        post.addHeader("Content-Type","application/json");
        post.addHeader("Language","TR");
        post.addHeader("Authorication","Basic " + TOKEN);

        CloseableHttpClient client = HttpClientBuilder.create().build();

        String response = null;
        AccessTokenResponse accessTokenResponse =null;
        try
        {
            HttpResponse httpResponse = client.execute(post);
            HttpEntity httpEntity = httpResponse.getEntity();
            response = EntityUtils.toString(httpEntity, "UTF-8");

            ObjectMapper mapper = new ObjectMapper();
            Result result = mapper.readValue(response, Result.class);
            accessTokenResponse = (AccessTokenResponse) result.getResponse();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println(new Gson().toJson(accessTokenResponse));
    }
}
