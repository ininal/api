package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class CreateAnonymousVirtualCardResponse
{
    //16-digit ininal card number information.
    private String cardNumber;

    //ininal card barcode information.
    private String barcodeNumber;

    //ininal card CVV information. This information only returns for virtual cards.
    private String cvv;

    //ininal card expire date information. This information only returns for virtual cards.
    private String expDate;

    public String getCardNumber()
    {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }

    public String getBarcodeNumber()
    {
        return barcodeNumber;
    }

    public void setBarcodeNumber(String barcodeNumber)
    {
        this.barcodeNumber = barcodeNumber;
    }

    public String getCvv()
    {
        return cvv;
    }

    public void setCvv(String cvv)
    {
        this.cvv = cvv;
    }

    public String getExpDate()
    {
        return expDate;
    }

    public void setExpDate(String expDate)
    {
        this.expDate = expDate;
    }
}
