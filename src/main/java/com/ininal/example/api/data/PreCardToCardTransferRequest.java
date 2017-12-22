package com.ininal.example.api.data;

import java.math.BigDecimal;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class PreCardToCardTransferRequest
{
    //Card token information to be loaded
    private String targetBarcodeNumber;

    /*
     * Balance is used to indicate from which side the interruption will be cut in the transfer operation.
     * Please send S to cut from the weld side, T parameter to cut from the target side.
     * Valid values : "SOURCE" "TARGET"
     */
    private String feeResource;

    //Transfer amount information
    private BigDecimal amount;

    //Additional information required to be entered for transfer.
    private String description;

    public String getTargetBarcodeNumber()
    {
        return targetBarcodeNumber;
    }

    public void setTargetBarcodeNumber(String targetBarcodeNumber)
    {
        this.targetBarcodeNumber = targetBarcodeNumber;
    }

    public String getFeeResource()
    {
        return feeResource;
    }

    public void setFeeResource(String feeResource)
    {
        this.feeResource = feeResource;
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
