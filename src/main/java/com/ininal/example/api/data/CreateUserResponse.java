package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 11.11.2017.
 */
public class CreateUserResponse
{
    //Unique identifier of the user
    private String userToken;

    public String getUserToken()
    {
        return userToken;
    }

    public void setUserToken(String userToken)
    {
        this.userToken = userToken;
    }
}
