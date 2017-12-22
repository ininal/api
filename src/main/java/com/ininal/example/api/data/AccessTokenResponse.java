package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 11.11.2017.
 */
public class AccessTokenResponse
{
    //Authorized unique token to be used in service calls.
    private String accessToken;

    //Type information of the unique key
    private String expiresIn;

    //The expression time of a single key. In milliseconds
    private String tokenType;

    public String getAccessToken()
    {
        return accessToken;
    }

    public void setAccessToken(String accessToken)
    {
        this.accessToken = accessToken;
    }

    public String getExpiresIn()
    {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn)
    {
        this.expiresIn = expiresIn;
    }

    public String getTokenType()
    {
        return tokenType;
    }

    public void setTokenType(String tokenType)
    {
        this.tokenType = tokenType;
    }
}
