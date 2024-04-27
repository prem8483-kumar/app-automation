package co.huru.constants;

public class AppConstant {

    public final static String PHONE_NUMBER_SCREEN_HEADER = "Mobile number";
    public final static String OTP_SCREEN_HEADER = "Enter OTP";
    public final static String PIN_SCREEN_HEADER = "Please enter your PIN";
    public final static String SIGN_UP_PIN_SCREEN_HEADER = "Create login PIN";
    public final static String CONFIRM_PIN_SCREEN_HEADER = "Confirm PIN";
    public final static String NAME_SCREEN_HEADER = "Your name";
    public final static String EMAIL_SCREEN_HEADER = "Email address";

    public final static String PHONE_NUMBER_ERROR_MESSAGE = "Enter a valid mobile number, 9 digits & starting with 50, 52, 54, 55, 56, 58";
    public final static String PIN_ERROR_MESSAGE = "PIN is invalid";
    public final static String OTP_ERROR_MESSAGE = "Invalid otp";

    public final static String SAME_PIN_AS_PREVIOUS_ERROR_MESSAGE = "PIN should not match with previous PINs";

    public final static String SET_PIN_ERROR_MESSAGE = "Invalid PIN. Please try again.";
    public final static String PIN_NOT_MATCH_ERROR_MESSAGE = "Your PIN do not match. Please try again.";

    public final static String EMAIL_ERROR_MESSAGE = "Must be a valid Email";
    public final static String EMAIL_REQUIRED_ERROR_MESSAGE = "Field is required.";

    public final static String PAYMENT_PROCESS_TITLE = "Processing Payment ";
    public final static String PAYMENT_PROCESS_SUBTITLE = "This should take only few seconds";

    public final static String PAYMENT_PENDING_TITLE = "Money Transfer Pending";
    public final static String PAYMENT_PENDING_SUBTITLE = "We are processing your payment. We will inform you once it's done. ";

    public final static String TRANSACTIONS_SCREEN_HEADER = "All transactions";

    public final static String SETUP_TRANSFER_SCREEN_HEADER = "Send money";
    public final static String EXCHANGE_QUOTE_BREAKDOWN_MODEL_HEADER ="Quote breakdown";

    public final static String CREATE_ACCOUNT_SCREEN_HEADER = "Create account";
    public final static String CREATE_ACCOUNT_TNC_SCREEN_HEADER = "Create account";
    public final static String CREATE_ACCOUNT_TNC_SCREEN_DESC = "Create account";

    public final static String SELECT_RECIPIENT_SCREEN_HEADER = "Select recipient";
    public final static String ADD_RECIPIENT_SCREEN_HEADER = "Add recipient details";
    public final static String REVIEW_TRANSFER_SCREEN_HEADER = "Review transfer";

    public final static String SELECT_PAYMENT_SCREEN_HEADER = "Select payment method";
    public final static String ADD_BANK_ACCOUNT_SCREEN_HEADER = "Add bank account";
    public final static String SELECT_BANK_SCREEN_HEADER = "Select your bank";
    public final static String PAYMENT_METHOD_MODEL_HEADER ="Payment method";
    public final static String PAYMENT_SCREEN_HEADER = "Payment Details";

    public final static String BANK_ACCOUNT_USER_NAME_ERROR_MESSAGE = "Please enter a Username";
    public final static String BANK_ACCOUNT_PASSWORD_ERROR_MESSAGE = "Please enter a Password";
    public final static String BANK_ACCOUNT_NOT_FOUND_ERROR_MESSAGE = "We couldn't find an account matching these credentials";
    public final static String BANK_ACCOUNT_OTP_ERROR_MESSAGE = "The One Time Password entered is incorrect, please check it and try again";

    public final static String RECIPIENT_FIRST_NAME_ERROR_MESSAGE = "First name can only have a-z alphabets and max 30 chars";
    public final static String RECIPIENT_LAST_NAME_ERROR_MESSAGE = "Last name can only have a-z alphabets and max 30 chars";
    public final static String RECIPIENT_MOBILE_NUMBER_ERROR_MESSAGE = "Enter a valid mobile number";
    public final static String RECIPIENT_RELATIONSHIP_ERROR_MESSAGE = "This field is mandatory";

    public final static String RECIPIENT_ACCOUNT_NUMBER_ERROR_MESSAGE = "Enter a valid account number";
    public final static String RECIPIENT_IFSC_CODE_ERROR_MESSAGE = "Enter a valid 11 digit IFSC code Eg. HDFC0000139, SBIN0015293";

    public final static String RECIPIENT_ADDRESS_ERROR_MESSAGE = "Please enter receiver's Address, <= 35 Char, no special char";
    public final static String RECIPIENT_CITY_ERROR_MESSAGE = "Please enter receiver's City";

    public final static String RECIPIENT_SECTIONS_ERROR_MESSAGE = "Incomplete details";

    public final static String MINIMUM_SENDER_AMOUNT_ERROR_MESSAGE = "Min single transaction amount AED 50";
    public final static String MAXIMUM_SENDER_AMOUNT_ERROR_MESSAGE = "Max single transaction amount AED 15000";

    public final static String MINIMUM_INDIA_RECEIVER_AMOUNT_ERROR_MESSAGE = "Invalid minimum receiving amount. It should be greater than: 1200";
    public final static String MAXIMUM_INDIA_RECEIVER_AMOUNT_ERROR_MESSAGE = "Invalid maximum receiving amount. It should be less than: 340000";

    public final static String MINIMUM_PAKISTAN_RECEIVER_AMOUNT_ERROR_MESSAGE = "Invalid minimum receiving amount. It should be greater than: 3800";
    public final static String MAXIMUM_PAKISTAN_RECEIVER_AMOUNT_ERROR_MESSAGE = "Invalid maximum receiving amount. It should be less than: 1140000";


    public final static String INVALID_PROMO_CODE_ERROR_MESSAGE = "Promocode is not valid. Please try another code";

}
