package az.grp.model.web.bankofbaku;

/**
 * Created by BakuParking on 11/5/2015.
 */
public class GetPayBindingResponse {


//    Value Description
//    0 Success
//    1 It is necessary to specify CVC2/CVV2, since the merchant does not have a permission to provide payments without CVC.
//    1 Incorrect CVC format
//    1 Invalid language
//    2 No binding found
//    2 No order found
//    5 User must change his password
//    5 Access denied
//    7 System error

    String redirect;

    String info;

    int errorCode;

    String error;

    String acsUrl;

    String paReq;

    int success;


    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAcsUrl() {
        return acsUrl;
    }

    public void setAcsUrl(String acsUrl) {
        this.acsUrl = acsUrl;
    }

    public String getPaReq() {
        return paReq;
    }

    public void setPaReq(String paReq) {
        this.paReq = paReq;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "GetPayBindingResponse{" +
                "redirect='" + redirect + '\'' +
                ", info='" + info + '\'' +
                ", errorCode=" + errorCode +
                ", error='" + error + '\'' +
                ", acsUrl='" + acsUrl + '\'' +
                ", paReq='" + paReq + '\'' +
                ", success=" + success +
                '}';
    }
}
