package az.grp.model.web;

import java.math.BigDecimal;

/**
 * Created by Seymur on 11/5/2015.
 */
public class BindingPaymentWO {

    private String user_code;
    private BigDecimal amount;
    private BigDecimal invoice;
    private String location;
    private String barcode;
    private String card_number;
    private String already_payed_to;
    private String leave_till;
    private String price;
    private String vat_charge;
    private String vat_value;
    private String currency;
    private String orderId;
    private String bindingId;
    private String cvc;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


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

    public BigDecimal getInvoice() {
        return invoice;
    }

    public void setInvoice(BigDecimal invoice) {
        this.invoice = invoice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getAlready_payed_to() {
        return already_payed_to;
    }

    public void setAlready_payed_to(String already_payed_to) {
        this.already_payed_to = already_payed_to;
    }

    public String getLeave_till() {
        return leave_till;
    }

    public void setLeave_till(String leave_till) {
        this.leave_till = leave_till;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVat_charge() {
        return vat_charge;
    }

    public void setVat_charge(String vat_charge) {
        this.vat_charge = vat_charge;
    }

    public String getVat_value() {
        return vat_value;
    }

    public void setVat_value(String vat_value) {
        this.vat_value = vat_value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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
}
