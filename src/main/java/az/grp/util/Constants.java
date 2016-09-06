package az.grp.util;

import java.math.BigDecimal;

/**
 * Created by jr on 9/4/2014.
 */

public class Constants {

    public static final String USER_CODE_IDX = "user_code_index";
    public static final String USER_CODE_TEMPLATE = "USERSM";


    public static final String SUCCESS = "success";
    public static final String ERROR_MSG = "error";

    public static final Character VISA = '4';
    public static final Character MASTER_CARD = '5';
    public static final BigDecimal AMOUNT_MULTIPLIER = new BigDecimal(100);

    public static final String MD5 = "MD5";

    public static final String JSON_TAG_FOR_HTTP_REQUEST = "application/json; charset=utf-8";
    public static final String ACCEPT = "application/json";
    public static final String UTF = "UTF-8";

    public static final String GOLDENPAY_PAYMENT_LINK_TEMPLATE = "https://rest.goldenpay.az/ecomm/getmoney";
    public static final String GOLDENPAY_STAT_LINK_TEMPLATE = "https://rest.goldenpay.az/ecomm/getstat";


    public static final String GOLDENPAY_MERCHANT = "bakuparking";
    public static final String GOLDENPAY_AUTH_KEY = "3333b4d041164f5c6fe52d4ace3d1cbd";
    public static final String GOLDENPAY_PAYMENT_LINK = "https://rest.goldenpay.az/test/checkout.jsp";
    public static final String GOLDENPAY_GET_PAYMENT_KEY = "https://rest.goldenpay.az/web/service/merchant/getPaymentKey";
    public static final String GOLDENPAY_GATEWAY_LINK = "https://rest.goldenpay.az/web/paypage?payment_key=";
    public static final String GOLDENPAY_GET_PAYMENT_RESULT = "https://rest.goldenpay.az/web/service/merchant/getPaymentResult";

    public static final String SOFTLINE_USERNAME = "alumsmartapi";
    public static final String SOFTLINE_PASSWORD = "2DhfsIad";
    public static final String SOFTLINE_API_URL = "https://gw.soft-line.az/sendsms";
    public static final String SOFTLINE_SENDER_NAME = "GRP";
    public static final String SOFTLINE_SENDER_NAME2 = "Alum Smart";

    public static final String BANKOFBAKU_USERNAME = "bakuparking-api";
    public static final String BANKOFBAKU_PASSWORD = "BakuParking1";
    public static final String BANKOFBAKU_RETURNURL = "http://localhost:8080/bankofbaku/callback";
    public static final String BANKOFBAKU_RETURNURL_FORCARDPAYMENT = "http://localhost:8081/bankofbaku/callbackforcardpayment";
    public static final String BANKOFBAKU_GETPAYMENTURL = "https://3ds.bankofbaku.com/newpayment/rest/register.do";
    public static final String BANKOFBAKU_GETORDERSTATUSURL = "https://3ds.bankofbaku.com/newpayment/rest/getOrderStatus.do";
    public static final String BANKOFBAKU_UNBINDING = "https://3ds.bankofbaku.com/newpayment/rest/unBindCard.do";
    public static final String BANKOFBAKU_BINDING_STATUS = "https://3ds.bankofbaku.com/newpayment/rest/bindCard.do";
    public static final String BANKOFBAKU_PAY_WITH_BINDING = "https://3ds.bankofbaku.com/newpayment/rest/paymentOrderBinding.do";
    public static final String BANKOFBAKU_GET_BINDING = "https://3ds.bankofbaku.com/newpayment/rest/getBindings.do";
    public static final String BANKOFBAKU_GATEWAY_LINK = "https://3ds.bankofbaku.com/newpayment/merchants/bakuparking/payment_en.html?mdOrder=";

    public static final String GOLDEN_PAY_MERCHANT_NAME = "bakuparking";
    public static final String GOLDEN_PAY_PASS = "TvuckttmQm";
    public static final String MERCHAT_SYMBOL = "m";
    public static final String LANG_SYMBOL = "lang";
    public static final String AMOUNT_SYMBOL = "amount";
    public static final String DESC_SYMBOL = "desc";

    public static final String AND = "&";
    public static final String EQ = "=";
    public static final String KEY_NOT_YET_DEFINED = "N/A";

    public static final String PARKING_ID_NOT_YET_DEFINED = "0";

    public static final String GREEN_PARKING_WI_TEMPLATE_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            + System.getProperty("line.separator")
            + "<!DOCTYPE GPReservation SYSTEM \"reservation.dtd\">"
            + System.getProperty("line.separator")
            + "<GPReservation>"
            + System.getProperty("line.separator");
    public static final String GREEN_PARKING_WI_TEMPLATE_FOOTER = "</GPReservation>";

}