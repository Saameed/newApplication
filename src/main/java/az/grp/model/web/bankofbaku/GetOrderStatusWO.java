package az.grp.model.web.bankofbaku;

import az.grp.model.dao.UserCardStatus;

import java.math.BigDecimal;

/**
 * Created by Seymur on 15-Oct-15.
 */

public class GetOrderStatusWO  {


    private String bindingId;

    private String cardholderName;

    private String Pan;

    private String clientId;

    private UserCardStatus statusId;

    private String expiration;

    private BigDecimal depositAmount;

    private BigDecimal Amount;

    private String currency;

    private String approvalCode;

    private int authCode;

    private String ErrorCode;

    private String ErrorMessage;

    private String OrderNumber;

    private int OrderStatus;

    private String Ip;

    public String getBindingId() {
        return bindingId;
    }

    public void setBindingId(String bindingId) {
        this.bindingId = bindingId;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getPan() {
        return Pan;
    }

    public void setPan(String pan) {
        Pan = pan;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public UserCardStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(UserCardStatus statusId) {
        this.statusId = statusId;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public int getAuthCode() {
        return authCode;
    }

    public void setAuthCode(int authCode) {
        this.authCode = authCode;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public int getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        OrderStatus = orderStatus;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    @Override
    public String toString() {
        return "GetOrderStatusWO{" +
                "bindingId='" + bindingId + '\'' +
                ", cardholderName='" + cardholderName + '\'' +
                ", Pan='" + Pan + '\'' +
                ", clientId='" + clientId + '\'' +
                ", statusId=" + statusId +
                ", expiration='" + expiration + '\'' +
                ", depositAmount=" + depositAmount +
                ", Amount=" + Amount +
                ", currency='" + currency + '\'' +
                ", approvalCode='" + approvalCode + '\'' +
                ", authCode=" + authCode +
                ", ErrorCode='" + ErrorCode + '\'' +
                ", ErrorMessage='" + ErrorMessage + '\'' +
                ", OrderNumber='" + OrderNumber + '\'' +
                ", OrderStatus=" + OrderStatus +
                ", Ip='" + Ip + '\'' +
                '}';
    }
}


