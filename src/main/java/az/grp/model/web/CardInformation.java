package az.grp.model.web;


import az.grp.model.dao.IEntity;

/**
 * Created by Seymur on 1/25/2016.
 */
public class CardInformation implements IEntity {

    private String BindId;
    private String pan;

    public String getBindId() {
        return BindId;
    }

    public void setBindId(String bindId) {
        BindId = bindId;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    @Override
    public String toString() {
        return "CardInformation{" +
                "BindId='" + BindId + '\'' +
                ", pan='" + pan + '\'' +
                '}';
    }
}
