package az.grp.model.web.bankofbaku;

/**
 * Created by Seymur on 11/20/2015.
 */
public class Bindings {

    private String bindingId;
    private String maskedPan;
    private String expiryDate;

    public String getBindingId() {

        return bindingId;
    }

    public void setBindingId(String bindingId) {
        this.bindingId = bindingId;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Bindings{" +
                "bindingId='" + bindingId + '\'' +
                ", maskedPan='" + maskedPan + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }
}
