package az.grp.model.web.bankofbaku;


import java.io.Serializable;

/**
 * Created by Seymur on 13-Oct-15.
 */

public class RespGetPaymentKey implements Serializable {

    private static final long serialVersionUID = -6743805087826323443L;

    private String orderId;
    private String formUrl;


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
}
