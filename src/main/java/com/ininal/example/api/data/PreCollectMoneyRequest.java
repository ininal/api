package com.ininal.example.api.data;

import java.math.BigDecimal;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class PreCollectMoneyRequest
{
    //Unique token of ininal card.
    private String cardToken;

    //Requested amount for the collect money
    private BigDecimal amount;

    //Transaction description
    private String description;

    public String getCardToken()
    {
        return cardToken;
    }

    public void setCardToken(String cardToken)
    {
        this.cardToken = cardToken;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
