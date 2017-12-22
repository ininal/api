package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class CancelCollectMoneyRequest
{
    //unique ininal card token
    private String cardToken;

    //Unique reference number for collect money process
    private String referenceNumber;

    public String getCardToken()
    {
        return cardToken;
    }

    public void setCardToken(String cardToken)
    {
        this.cardToken = cardToken;
    }

    public String getReferenceNumber()
    {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber)
    {
        this.referenceNumber = referenceNumber;
    }
}
