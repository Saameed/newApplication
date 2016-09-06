package az.grp.model.web.bankofbaku;

/**
 * Created by Seymur on 09-Oct-15.
 */
public class GetPaymentKeyBOB {


    private String orderId;

    private String formUrl;

    private String mdOrder;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFormUrl() {
        return formUrl;
    }

    public void setFormUrl(String formUrl) {
        this.formUrl = formUrl;
    }

    public String getMdOrder() {
        return mdOrder;
    }

    public void setMdOrder(String mdOrder) {
        this.mdOrder = mdOrder;
    }
}
