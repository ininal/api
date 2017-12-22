package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class AssignCardToUserRequest
{
    //ininal card last 4-digit
    private String lastDigits;

    //ininal card barcode information
    private String barcodeNumber;

    public String getLastDigits()
    {
        return lastDigits;
    }

    public void setLastDigits(String lastDigits)
    {
        this.lastDigits = lastDigits;
    }

    public String getBarcodeNumber()
    {
        return barcodeNumber;
    }

    public void setBarcodeNumber(String barcodeNumber)
    {
        this.barcodeNumber = barcodeNumber;
    }
}
