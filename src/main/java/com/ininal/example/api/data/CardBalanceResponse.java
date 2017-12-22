package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class CardBalanceResponse
{
    //16-digit ininal card number information.
    private String cardNumber;

    //ininal card balance information.
    private String availableLimit;

    //ininal card loadable limit information.
    private String loadableLimit;

    //ininal card monthly limit information.
    private String monthlyLoadableLimit;

    public String getCardNumber()
    {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }

    public String getAvailableLimit()
    {
        return availableLimit;
    }

    public void setAvailableLimit(String availableLimit)
    {
        this.availableLimit = availableLimit;
    }

    public String getLoadableLimit()
    {
        return loadableLimit;
    }

    public void setLoadableLimit(String loadableLimit)
    {
        this.loadableLimit = loadableLimit;
    }

    public String getMonthlyLoadableLimit()
    {
        return monthlyLoadableLimit;
    }

    public void setMonthlyLoadableLimit(String monthlyLoadableLimit)
    {
        this.monthlyLoadableLimit = monthlyLoadableLimit;
    }
}
