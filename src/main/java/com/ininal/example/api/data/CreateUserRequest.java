package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 11.11.2017.
 */
public class CreateUserRequest
{
    private String name;
    private String surname;
    private String email;
    private String gsmNumber;
    private String tcIdentificationNumber;
    private String password;
    private String birthDate;
    private String motherMaidenName;

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

    public String getTcIdentificationNumber()
    {
        return tcIdentificationNumber;
    }

    public void setTcIdentificationNumber(String tcIdentificationNumber)
    {
        this.tcIdentificationNumber = tcIdentificationNumber;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(String birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getMotherMaidenName()
    {
        return motherMaidenName;
    }

    public void setMotherMaidenName(String motherMaidenName)
    {
        this.motherMaidenName = motherMaidenName;
    }
}
