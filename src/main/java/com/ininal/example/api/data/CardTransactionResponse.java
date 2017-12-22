package com.ininal.example.api.data;

import java.util.List;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class CardTransactionResponse
{
    //List of card transactions
    private List<TransactionResponse> list;

    public void setList(List<TransactionResponse> list)
    {
        this.list = list;
    }
}
