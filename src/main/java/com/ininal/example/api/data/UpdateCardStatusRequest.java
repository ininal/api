package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class UpdateCardStatusRequest
{
    //User's unique token
    private String userToken;

    //User's card status
    private String cardSstatus;

    public String getUserToken()
    {
        return userToken;
    }

    public void setUserToken(String userToken)
    {
        this.userToken = userToken;
    }

    public String getCardSstatus()
    {
        return cardSstatus;
    }

    public void setCardSstatus(String cardSstatus)
    {
        this.cardSstatus = cardSstatus;
    }
}
