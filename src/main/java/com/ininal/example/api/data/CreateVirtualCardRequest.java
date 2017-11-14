package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 11.11.2017.
 */
public class CreateVirtualCardRequest
{
    private String virtualCardChannel;
    private String productCode;

    public String getVirtualCardChannel()
    {
        return virtualCardChannel;
    }

    public void setVirtualCardChannel(String virtualCardChannel)
    {
        this.virtualCardChannel = virtualCardChannel;
    }

    public String getProductCode()
    {
        return productCode;
    }

    public void setProductCode(String productCode)
    {
        this.productCode = productCode;
    }
}
