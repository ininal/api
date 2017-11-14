package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 12.11.2017.
 */
public class LoadBalanceResponse
{
    public String transactionId;
    public String barcodeNumber;
    public String amount;

    public String getTransactionId()
    {
        return transactionId;
    }

    public void setTransactionId(String transactionId)
    {
        this.transactionId = transactionId;
    }

    public String getBarcodeNumber()
    {
        return barcodeNumber;
    }

    public void setBarcodeNumber(String barcodeNumber)
    {
        this.barcodeNumber = barcodeNumber;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }
}
