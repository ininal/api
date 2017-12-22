package com.ininal.example.api.data;

import java.util.List;

/**
 * Created by yaseminbakir on 21.12.2017.
 */
public class UserCardsInformation
{
    //list of card token information
    private List<CardTokenInformation> list;

    public List<CardTokenInformation> getList()
    {
        return list;
    }

    public void setList(List<CardTokenInformation> list)
    {
        this.list = list;
    }
}
