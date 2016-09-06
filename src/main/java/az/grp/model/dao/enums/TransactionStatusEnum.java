package az.grp.model.dao.enums;

/**
 * Created by Seymur on 12/11/2015.
 */
public enum TransactionStatusEnum {
    INIT,
    IN_PROGRESS,
    SUCCESS,
    FAILURE,
    MONEY_RECEIVED_BUT_TICKET_NOT_PAID,
    FAILED_TO_PAY_MONEY_ADDED_TO_BALANCE,
    TRANSACTION_REVERSED,
    REVERSE
}
