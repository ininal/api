package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class PreCardToCardTransferResponse
{
    /*
     * Tranfer token info can be taken from Pre Card to Card Transfer service.
     * To complete card to card process, user have to call this service with PUT.
     */
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
