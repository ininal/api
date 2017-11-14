package com.ininal.example.api.data;

import java.math.BigDecimal;

/**
 * Created by yaseminbakir on 12.11.2017.
 */
public class GetCardInfoResponse
{
    public String name;
    public String surname;
    public String cardStatusCode;
    public String cardReasonCode;
    public String isVirtualCard;
    public String barcodeNo;
    public String cardNumber;
    public String productCode;
    public boolean registered;
    public BigDecimal availableLimit;
    public BigDecimal loadableLimit;
    public BigDecimal monthlyLoadableLimit;
    public String expDate;
    public String cvv;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getCardStatusCode()
    {
        return cardStatusCode;
    }

    public void setCardStatusCode(String cardStatusCode)
    {
        this.cardStatusCode = cardStatusCode;
    }

    public String getCardReasonCode()
    {
        return cardReasonCode;
    }

    public void setCardReasonCode(String cardReasonCode)
    {
        this.cardReasonCode = cardReasonCode;
    }

    public String getIsVirtualCard()
    {
        return isVirtualCard;
    }

    public void setIsVirtualCard(String isVirtualCard)
    {
        this.isVirtualCard = isVirtualCard;
    }

    public String getBarcodeNo()
    {
        return barcodeNo;
    }

    public void setBarcodeNo(String barcodeNo)
    {
        this.barcodeNo = barcodeNo;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }

    public String getProductCode()
    {
        return productCode;
    }

    public void setProductCode(String productCode)
    {
        this.productCode = productCode;
    }

    public boolean isRegistered()
    {
        return registered;
    }

    public void setRegistered(boolean registered)
    {
        this.registered = registered;
    }

    public BigDecimal getAvailableLimit()
    {
        return availableLimit;
    }

    public void setAvailableLimit(BigDecimal availableLimit)
    {
        this.availableLimit = availableLimit;
    }

    public BigDecimal getLoadableLimit()
    {
        return loadableLimit;
    }

    public void setLoadableLimit(BigDecimal loadableLimit)
    {
        this.loadableLimit = loadableLimit;
    }

    public BigDecimal getMonthlyLoadableLimit()
    {
        return monthlyLoadableLimit;
    }

    public void setMonthlyLoadableLimit(BigDecimal monthlyLoadableLimit)
    {
        this.monthlyLoadableLimit = monthlyLoadableLimit;
    }

    public String getExpDate()
    {
        return expDate;
    }

    public void setExpDate(String expDate)
    {
        this.expDate = expDate;
    }

    public String getCvv()
    {
        return cvv;
    }

    public void setCvv(String cvv)
    {
        this.cvv = cvv;
    }
}
