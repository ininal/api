package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class CompleteCardToCardTransferRequest
{
    //Transfer token information required to complete the transfer.
    private String transferToken;

    public String getTransferToken()
    {
        return transferToken;
    }

    public void setTransferToken(String transferToken)
    {
        this.transferToken = transferToken;
    }
}
