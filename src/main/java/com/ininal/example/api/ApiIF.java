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
    AccessTokenResponse getAccessToken();

    /********************* USER SERVICES *********************/

    /**
     * User - create
     * a new user can be created.
     * The returned User Token value when the user is successfully created is used for all other services that require User information.
     * In order to create a user successfully,
     * the mobile phone and e-mail addresses entered must not previously be registered in ININAL.
     * In addition, identification information (TC ID, first name, surname, date of birth) must be verifiable by MERNIS in the production environment.
     */
    CreateUserResponse createUser(String accessToken, CreateUserRequest createUserRequest);

    /**
     * User - information
     */
    GetUserResponse userInformation(String accessToken, String userToken);

    /**
     * User - gsm number update
     * the mobile phone information of a registered in-home user is updated.
     * When the mobile phone information is successfully updated,
     * the mobile phone information of all active cards added to the user account is also updated.
     */
    Result userGsmNumberUpdate(String accessToken, String userToken, UserGsmNumberUpdateRequest userGsmNumberUpdateRequest);

    /**
     * User - card assign
     * an ininal card can be assigned to a registered ininal user.
     * An ininal user can have up to 3 active cards at the same time.
     * When the card is successfully added, the returned Card Token value is used for all other services that require card information.
     * You can get the required card information for this service from /v2/cards/virtual service
     */
    AssignCardToUserResponse assignCardToUser(String accessToken, String userToken, AssignCardToUserRequest assignCardToUserRequest);

    /**
     * User - card information
     * all ininal cards and card statuses registered to an ininal user can be accessed..
     */
    UserCardsInformation userCardsInformation(String accessToken, String userToken);

    /**
     * User - send OTP
     * one-time password (OTP) can be sent to the registered mobile phone of an ininal user.
     * This is used to verify the registered mobile phone information of the service user.
     */
    SendOtpResponse sendOtpToVerifyUser(String accessToken, String userToken);

    /**
     * User - verify OTP
     * one-time password (OTP) can be verified for the registered mobile phone.
     * This is used to verify the registered mobile phone information of the service user.
     */
    Result verifyOTP(String accessToken, String userToken, VerifyOTPRequest verifyOTPRequest);

    /**
     * User - create virtual card
     * an ininal virtual card can be created and assigned to a registered ininal user.
     */
    CreateVirtualCardToUserResponse createVirtualCardToUser(String accessToken, String userToken, CreateVirtualCardRequest createVirtualCardRequest);


    /********************* CARDS SERVICES *********************/


    /**
     * Cards - Card Information
     * all physical and virtual cards’ user information, card information, current card status and card type can be accessed.
     * In addition to this information, cvv and expiration date information can also be accessed if the accessed card is virtual.
     */
    GetCardInfoResponse getCardInfo(String accessToken, String cardToken);

    /**
     * Cards - Create Anonymous Virtual Card
     * create a virtual card that is assigned to an ininal user.
     * You can assign this virtual card using the Card Assign service for an ininal user and make it ready for use.
     * Non-assigned cards can only be loaded once. The card information can be accessed using the Card Information service.
     */
    CreateAnonymousVirtualCardResponse createAnonymousVirtualCard(String accessToken);

    /**
     * Cards - Update Card Status
     * the status code of an assigned card can be updated.
     * An ininal card can be brought from the open position to the closed position,
     * or from the closed position to the open position.
     * A closed card does not make a difference about adding 3 cards that the user has.
     * For example; If the user has 2 cards and brings one of them off,
     * there will be no change to the user's ability to add cards.
     * Likewise, if the card in the closed position is brought to the open position,
     * there is no change to the card that the user has.
     */
    Result cardStatusUpdate(String accessToken, UpdateCardStatusRequest updateCardStatusRequest);

    /**
     * Cards - Query Card Balance
     * access the current balance information of an ininal card and the total monthly load limit information.
     */
    CardBalanceResponse queryCardBalance(String accessToken, String cardToken);

    /**
     * Cards - Card PIN Operations
     * the password of a card can be reset or the existing password can be reminded.
     * The card PIN is sent to the card holder via SMS.
     */
    Result cardPinOperations(String accessToken, String cardToken, CardPinOperationsRequest cardPinOperationsRequest);

    /**
     * Cards - Card Transactions Query
     * create no name virtual card
     */
    CardTransactionResponse queryCardTransactions(String accessToken, String cardToken, String start_date, String end_date);

    /**
     * card to card transfer begin with this service
     */
    PreCardToCardTransferResponse preCardToCardTransfer(String accessToken, String sourceCardToken, PreCardToCardTransferRequest preCardToCardTransferRequest);

    /**
     * card to card transfer complete with this service
     */
    Result completeCardToCardTransfer(String accessToken, String sourceCardToken, CompleteCardToCardTransferRequest completeCardToCardTransferRequest);


    /********************* TRANSACTIONS SERVICES *********************/

    /**
     * Transactions - Load Balance
     * a load balance operation can be performed on an ininal card.
     * In order for the balance to be loaded on the card,
     * the loading channel limit must be greater than the amount to be loaded.
     * A non-personalized card can only be loaded once, and a card must be personalized to load balance more than once.
     */
    LoadBalanceResponse loadBalance(String accessToken, LoadBalanceRequest loadBalanceRequest);

    /**
     * Transactions - Cancel Load Balance
     * a load balance transaction can be canceled.
     * Cancellation is only valid for the day of loading.
     * In order for the cancellation to be successful, the card balance must be bigger than the cancellation amount.
     */
    Result cancelLoadBalance(String accessToken, CancelLoadBalanceRequest cancelLoadBalanceRequest);

    /**
     * Transactions - Initiate Collect Money
     * user can start to collect money from ininal card.
     */
    PreCollectMoneyResponse preCollectMoney(String accessToken, PreCollectMoneyRequest preCollectMoneyRequest);

    /**
     * Transactions - Complete Collect Money
     * user can complete collect money from ininal card.
     */
    CompleteCollectMoneyResponse completeCollectMoney(String accessToken, String provision_code, CompleteCollectMoneyRequest completeCollectMoneyRequest);

    /**
     * Transactions - Cancel Collect Money
     * user can cancel collected money from ininal card.
     */
    Result cancelCollectMoney(String accessToken, CancelCollectMoneyRequest cancelCollectMoneyRequest);

    /**
     * Transactions - Nearest Locations
     * user can find nearest ininal card sale and load Locations.
     */
    NearestLocationsResponse nearestLocations(String accessToken, String coordinateX, String coordinateY);
}
