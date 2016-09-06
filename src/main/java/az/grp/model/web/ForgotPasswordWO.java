package az.grp.model.web;

/**
 * Created by Gudrat Hasanli on 08.05.2015.
 */
public class ForgotPasswordWO {

    private String phone_number;
    private String new_password;

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
