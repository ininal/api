package com.ininal.example.api;

import com.ininal.example.api.data.*;

/**
 * Created by cihanozdemir on 11.11.2017.
 */
public interface ApiIF
{
    /**
     * Authentication
     */
    public AccessTokenResponse getAccessToken();

    /**
     * User - create
     */
    public CreateUserResponse createUser(String accessToken, CreateUserRequest createUserRequest);

    /**
     * verify user via send OTP to user's gsm number
     */
    public SendOtpResponse sendOtpToVerifyUser(String accessToken, String userToken);

    /**
     * verify sent OTP
     */
    public Result verifyOTP(String accessToken, String userToken, VerifyOTPRequest verifyOTPRequest);

    /**
     * create virtual card to user
     */
    public CreateVirtualCardToUserResponse createVirtualCardToUser(String accessToken, String userToken, CreateVirtualCardRequest createVirtualCardRequest);

    /**
     * load balance to card
     */
    public LoadBalanceResponse loadBalance(String accessToken, String userToken, LoadBalanceRequest loadBalanceRequest);

    /**
     * get card info
     */
    public GetCardInfoResponse getCardInfo(String accessToken, String cardToken);
}
