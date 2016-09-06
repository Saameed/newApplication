package az.grp.model.dao.enums;

/**
 * Created by Seymur on 12/11/2015.
 */
public enum TransactionTypeEnum {
    ADD_BALANCE("a"),
    DIRECT_PAYMENT("d"),
    UPGRADE("u"),
    BONUS("bb"),
    BINDING("b"),
    TRANSACTION_REVERSED("tr"),
    NULL("null"),
    PAY_WITH_BINDING("p"),
    CURRENCTY("c"),
    REVERSE("r");

    private String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }

    TransactionTypeEnum(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static TransactionTypeEnum find(String abbreviation){
        for(TransactionTypeEnum type: TransactionTypeEnum.values()){
            if (type.getAbbreviation().equals(abbreviation))
                return type;
        }
        return NULL;
    }
}
