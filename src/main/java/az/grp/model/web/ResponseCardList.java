package az.grp.model.web;

import java.util.List;

/**
 * Created by Seymur on 1/25/2016.
 */
public class ResponseCardList {

    private String error;
    private String success;


    private List<CardInformation> cardInfo;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<CardInformation> getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(List<CardInformation> cardInfo) {
        this.cardInfo = cardInfo;
    }

    @Override
    public String toString() {
        return "ResponseCardList{" +
                "error='" + error + '\'' +
                ", success='" + success + '\'' +
                ", cardInfo=" + cardInfo +
                '}';
    }
}
