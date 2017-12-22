package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 21.12.2017.
 */
public class GetUserResponse
{
    //Unique identifier of the user
    private String userToken;

    //Name of user
    private String name;

    //Surname of user
    private String surname;

    //E-mail address of user
    private String email;

    //User mobile phone number. Should be 10 digits and 5xxxxxxxxx format
    private String gsmNumber;

    //User TC Identification number. Should be number only and 11 digits
    private String tckn;

    //Birthdate of user. Should be on YYYY-MM-DD format
    private String birthdate;

    //User status information
    private String status;

    public String getUserToken()
    {
        return userToken;
    }

    public void setUserToken(String userToken)
    {
        this.userToken = userToken;
    }

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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getGsmNumber()
    {
        return gsmNumber;
    }

    public void setGsmNumber(String gsmNumber)
    {
        this.gsmNumber = gsmNumber;
    }

    public String getTckn()
    {
        return tckn;
    }

    public void setTckn(String tckn)
    {
        this.tckn = tckn;
    }

    public String getBirthdate()
    {
        return birthdate;
    }

    public void setBirthdate(String birthdate)
    {
        this.birthdate = birthdate;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
