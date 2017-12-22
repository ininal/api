package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 21.12.2017.
 */
public class CardTokenInformation
{
    //Unique identifier of the ininal card
    private String cardToken;

    //Card Status
    private String status;

    public String getCardToken()
    {
        return cardToken;
    }

    public void setCardToken(String cardToken)
    {
        this.cardToken = cardToken;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
