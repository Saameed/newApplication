package az.grp.model.web.bankofbaku;

import java.util.List;

/**
 * Created by Seymur on 11/20/2015.
 */
public class GetBindings {

    private String errorCode;
    private String errorMessage;
    private List<Bindings> bindings;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<Bindings> getBindings() {
        return bindings;
    }

    public void setBindings(List<Bindings> bindings) {
        this.bindings = bindings;
    }

    @Override
    public String toString() {
        return "GetBindings{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", bindings=" + bindings +
                '}';
    }
}
