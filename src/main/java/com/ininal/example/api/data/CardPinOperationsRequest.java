package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 22.12.2017.
 */
public class CardPinOperationsRequest
{
    /*
     * ininal card 4-digit PIN information.
     * 'OLD' represents old 4-digit PIN, 'NEW' represents new 4-digit random PIN.
     */
    private String issuingType;

    public String getIssuingType()
    {
        return issuingType;
    }

    public void setIssuingType(String issuingType)
    {
        this.issuingType = issuingType;
    }
}
