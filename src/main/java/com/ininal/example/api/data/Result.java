package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 11.11.2017.
 */
public class Result
{
    //HTTP response code of the request.
    private int httpCode;

    //Description of the httpCode
    private String description;

    //response object
    private Object response;

    //Validation errors
    private Object validationErrors;

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

    public Object getValidationErrors()
    {
        return validationErrors;
    }

    public void setValidationErrors(Object validationErrors)
    {
        this.validationErrors = validationErrors;
    }
}
