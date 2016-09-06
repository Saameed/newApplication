package az.grp.model.web;

import java.math.BigDecimal;

/**
 * Created by Seymur on 12/21/2015.
 */
public class GetPaymentUrlWO {

    private String paymentCheckBox;
    private String typesCheckBox;
    private String monthlyInp;
    private String regKey;
    private BigDecimal amount;
    private String user_code;
    private Boolean bind;
    private String transaction_type;
    private String bindId;
    private Integer studentTicketNo;
    private Integer count;
    private Integer[] types;

    public String getPaymentCheckBox() {
        return paymentCheckBox;
    }

    public void setPaymentCheckBox(String paymentCheckBox) {
        this.paymentCheckBox = paymentCheckBox;
    }

    public String getTypesCheckBox() {
        return typesCheckBox;
    }

    public void setTypesCheckBox(String typesCheckBox) {
        this.typesCheckBox = typesCheckBox;
    }

    public String getMonthlyInp() {
        return monthlyInp;
    }

    public void setMonthlyInp(String monthlyInp) {
        this.monthlyInp = monthlyInp;
    }

    public String getRegKey() {
        return regKey;
    }

    public void setRegKey(String regKey) {
        this.regKey = regKey;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public Boolean getBind() {
        return bind;
    }

    public void setBind(Boolean bind) {
        this.bind = bind;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getBindId() {
        return bindId;
    }

    public void setBindId(String bindId) {
        this.bindId = bindId;
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
}
