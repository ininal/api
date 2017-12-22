package com.ininal.example.api.data;

import java.math.BigDecimal;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class CancelLoadBalanceRequest
{
    //The code number stored in the ininal system of the channel making the transactions.
    private int cashOfficeId;

    //ininal card barcode number
    private String barcodeNumber;

    //Unique transaction ID. Can be 11 digits maximum. Code of the original transaction should be sent.
    private String transactionId;

    //Free-text load amount information.
    private BigDecimal amount;

    public int getCashOfficeId()
    {
        return cashOfficeId;
    }

    public void setCashOfficeId(int cashOfficeId)
    {
        this.cashOfficeId = cashOfficeId;
    }

    public String getBarcodeNumber()
    {
        return barcodeNumber;
    }

    public void setBarcodeNumber(String barcodeNumber)
    {
        this.barcodeNumber = barcodeNumber;
    }

    public String getTransactionId()
    {
        return transactionId;
    }

    public void setTransactionId(String transactionId)
    {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }
}
