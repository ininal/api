package com.ininal.example.api.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ininal.example.api.constant.WorkshopConstant;
import com.ininal.example.api.data.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * Created by yaseminbakir on 11.11.2017.
 */
public class TestWS
{

    public static void main(String[] args)
    {
        String TOKEN = "MWQ1NmViZjg5OTUzZTBkMThhMzFkZTFmMDA2ZWRiMzIxMWZhNjA2NWU0ZWY5NTkzOjM1NjUzMjMyMzc2NTM2MzEyZDYzMzY2NTMyMmQzNDYzNjI2MTJkNjE2NTY1MzQyZDMzMzIzMzY2NjYzODMxNjU2MjMzMzUzNw==";

        HttpPost post = new HttpPost("https://sandbox-api.ininal.com/v2/oauth/accesstoken");
        post.addHeader(new BasicHeader("Date", new Date().toString()));
        post.addHeader("Content-Type","application/json");
        post.addHeader("Language","TR");
        post.addHeader("Authorization", "Basic " + TOKEN);

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
            accessTokenResponse = mapper.convertValue(result.getResponse(), AccessTokenResponse.class);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println(new Gson().toJson(accessTokenResponse));

    }
}
