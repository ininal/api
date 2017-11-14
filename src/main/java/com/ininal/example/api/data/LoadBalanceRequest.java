package com.ininal.example.api.data;

import java.math.BigDecimal;

/**
 * Created by yaseminbakir on 11.11.2017.
 */
public class LoadBalanceRequest
{
    private int cashOfficeId;
    private String barcodeNumber;
    private String transactionId;
    private BigDecimal amount;

    public LoadBalanceRequest()
    {
        cashOfficeId = 1401;
    }

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
