package com.ininal.example.api.data;

/**
 * Created by yaseminbakir on 11.11.2017.
 */
public class VerifyOTPRequest
{
    //OTP token
    public String otp;

    //OTP information sent to the user.
    public String token;

    public String getOtp()
    {
        return otp;
    }

    public void setOtp(String otp)
    {
        this.otp = otp;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }
}
