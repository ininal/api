package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 11.11.2017.
 */
public class Result
{
    private int httpCode;
    private String description;
    private Object response;
    private String validationErrors;

    public int getHttpCode()
    {
        return httpCode;
    }

    public void setHttpCode(int httpCode)
    {
        this.httpCode = httpCode;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Object getResponse()
    {
        return response;
    }

    public void setResponse(Object response)
    {
        this.response = response;
    }

    public String getValidationErrors()
    {
        return validationErrors;
    }

    public void setValidationErrors(String validationErrors)
    {
        this.validationErrors = validationErrors;
    }
}
