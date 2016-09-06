package az.grp.model.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by Seymur on 1/28/2016.
 */
public class GeneralPayWO implements Serializable {

    private String user_code;
    private BigDecimal amount;
    private String transaction_type;
    private String currency;
    private Boolean bind;
    private String bindingId;
    private String cvc;
    private Integer studentTicketNo;
    private Integer count;
    private Integer[] types;

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getBind() {
        return bind;
    }

    public void setBind(Boolean bind) {
        this.bind = bind;
    }

    public String getBindingId() {
        return bindingId;
    }

    public void setBindingId(String bindingId) {
        this.bindingId = bindingId;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public Integer getStudentTicketNo() {
        return studentTicketNo;
    }

    public void setStudentTicketNo(Integer studentTicketNo) {
        this.studentTicketNo = studentTicketNo;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer[] getTypes() {
        return types;
    }

    public void setTypes(Integer[] types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "GeneralPayWO{" +
                "user_code='" + user_code + '\'' +
                ", amount=" + amount +
                ", transaction_type='" + transaction_type + '\'' +
                ", currency='" + currency + '\'' +
                ", bind=" + bind +
                ", bindingId='" + bindingId + '\'' +
                ", cvc='" + cvc + '\'' +
                ", studentTicketNo=" + studentTicketNo +
                ", count=" + count +
                ", types=" + Arrays.toString(types) +
                '}';
    }
}

