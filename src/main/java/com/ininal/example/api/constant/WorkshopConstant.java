package com.ininal.example.api.constant;

/**
 * Created by yaseminbakir on 14.11.2017.
 */
public class WorkshopConstant
{
    // Header constant parameters
    public static String DATE = "Date";
    public static String AUTHORIZATION = "Authorization";
    public static String BEARER = "Bearer ";
    public static String CONTENT_TYPE = "Content-Type";
    public static String APPLICATION_JSON = "application/json";
    public static String LANGUAGE = "Languge";
    public static String TR = "TR";
    public static String UTF8 = "UTF-8";

    //Base url
    public static String BASE_URL = "https://sandbox-api.ininal.com";

    //USERS uri list
    public static String CREATE_USER_URI = "/v2/users";
    public static String GET_USER_INFORMATION_URI = "/v2/users/";
    public static String GET_USER_CARDS_INFORMATION_URI = "/v2/users/{user_token}/cards";
    public static String SEND_OTP_TO_VERIFY_USER_URI = "/v2/users/{user_token}/send/otp";
    public static String VERIFY_OTP_URI= "/v2/users/$userToken/verify/otp";
    public static String CREATE_VIRTUAL_CARD_TO_USER_URI = "/v2/users/{user_token}/cards/virtual";
    public static String ASSIGN_CARD_TO_USER_URI = "/v2/users/{user_token}/cards/attach";
    public static String UPDATE_USER_GSMNUMBER_URI = "/v2/users/{user_token}/gsmnumber";

    //CARDS uri list
    public static String GET_CARD_INFO_URI = "/v2/cards/";
    public static String CREATE_ANONYMOUS_VIRTUAL_CARD_URI = "/v2/cards/virtual";
    public static String CARD_STATUS_UPDATE_URI = "/v2/cards/{card_token}/status";
    public static String CARD_BALANCE_URI = "/v2/cards/{card_token}/balance";
    public static String CARD_PIN_URI = "/v2/cards/{card_token}/pin";
    public static String CARD_TRANSACTIONS_URI = "/v2/cards/{card_token}/transactions/{start_date}/{end_date}";
    public static String CARD_TO_CARD_TRANSFER_URI = "/v2/cards/{sourceCardToken}/transfer";

    //TRANSACTIONS uri list
    public static String TRANSACTIONS_IN_URI = "/v2/transactions/in";
    public static String TRANSACTIONS_IN_CANCEL_URI = "/v2/transactions/in/cancel";
    public static String TRANSACTIONS_OUT_URI = "/v2/transactions/out";
    public static String TRANSACTIONS_OUT_VERIFY_URI = "/v2/transactions/{provision_code}/out";
    public static String TRANSACTIONS_OUT_CANCEL_URI = "/v2/transactions/out/cancel";
    public static String TRANSACTIONS_LOCATIONS_URI = "/v2/transactions/locations/{coordinateY}/{coordinateX}";

    //constant parameters
    public static String USER_TOKEN_PARAMETER = "{user_token}";
    public static String PROVISION_CODE_PARAMETER = "{provision_code}";
    public static String CARD_TOKEN_PARAMETER = "{card_token}";
    public static String SOURCE_CARD_TOKEN_PARAMETER = "{sourceCardToken}";
    public static String START_DATE = "{start_date}";
    public static String END_DATE = "{end_date}";
    public static String WHITESPACE = " ";
    public static String URL_WHITESPACE_REPLACE = "%20";
    public static String COORDINATE_Y = "{coordinateY}";
    public static String COORDINATE_X = "{coordinateX}";
}
