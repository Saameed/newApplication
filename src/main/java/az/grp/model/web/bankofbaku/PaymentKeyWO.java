package az.grp.model.web.bankofbaku;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Seymur on 09-Oct-15.
 */
public class PaymentKeyWO implements Serializable{

    private String key;

    private boolean success;

    private Map<String, String> errors;

    private String url;

    public PaymentKeyWO() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PaymentKeyWO{" +
                "key='" + key + '\'' +
                ", success=" + success +
                ", errors=" + errors +
                ", url='" + url + '\'' +
                '}';
    }
}
