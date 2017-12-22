package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class TransactionResponse
{
    //Transaction time information
    private String transactionDate;

    //Transaction company information.
    private String merchant;

    //Transaction reference number.
    private String referenceNo;

    //Transaction type information.
    private String transactionType;

    //Transaction amount information.
    private String amount;

    //Transaction currency information.
    private String currency;

    //Transaction company category code.
    private String merchantCategory;

    public String getTransactionDate()
    {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate)
    {
        this.transactionDate = transactionDate;
    }

    public String getMerchant()
    {
        return merchant;
    }

    public void setMerchant(String merchant)
    {
        this.merchant = merchant;
    }

    public String getReferenceNo()
    {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo)
    {
        this.referenceNo = referenceNo;
    }

    public String getTransactionType()
    {
        return transactionType;
    }

    public void setTransactionType(String transactionType)
    {
        this.transactionType = transactionType;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public String getMerchantCategory()
    {
        return merchantCategory;
    }

    public void setMerchantCategory(String merchantCategory)
    {
        this.merchantCategory = merchantCategory;
    }
}
