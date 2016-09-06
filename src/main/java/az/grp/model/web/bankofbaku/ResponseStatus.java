package az.grp.model.web.bankofbaku;

/**
 * Created by Seymur on 15-Oct-15.
 */
public class ResponseStatus{


    public static final Integer SUCCESS_CODE = 2;
    public static final Integer Order_registered_but_not_paid_off = 0;
    public static final Integer Pre_authorisation_amount_was_hel = 1;
    public static final Integer Authorization_reversed = 3;
    public static final Integer Transaction_was_refunded = 4;
    public static final Integer Authorization_through_the_issuer_ACS_initiated = 5;
    public static final Integer Authorization_declined = 6;


    public String find(Integer errorCode){
            ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.getClass().getMethods();
        return   "";
    }

}
