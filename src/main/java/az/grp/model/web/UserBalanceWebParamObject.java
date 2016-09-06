package az.grp.model.web;


/**
 * Created by jr on 10/5/2014.
 */
public class UserBalanceWebParamObject implements WebParamObject {

    private Integer amount;

    private String user_code;

    private boolean valid;

    private String error;

    private String language;

    public UserBalanceWebParamObject() {

    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    @Override
    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "UserBalanceWebParamObject{" +
                "amount=" + amount +
                ", user_code='" + user_code + '\'' +
                ", valid=" + valid +
                ", error='" + error + '\'' +
                '}';
    }
}
