package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class UserGsmNumberUpdateRequest
{
    //User mobile phone number. 10 digits 5xxxxxxxxx format
    private String gsmNumber;

    public String getGsmNumber()
    {
        return gsmNumber;
    }

    public void setGsmNumber(String gsmNumber)
    {
        this.gsmNumber = gsmNumber;
    }
}
