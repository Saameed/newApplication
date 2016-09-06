package az.grp.model.dao;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Seymur on 14-Oct-15.
 */

@Entity
@Table(name = "usercardinfo")
public class  UserCardInfo implements IEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "cardbindingid")
    private String cardBindingId;

    @Column(name = "cardholder_name")
    private String cardholderName;

    @Column(name = "pan")
    private String pan;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private UserCardStatus statusId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;
    @Column(name = "expiry_date")
    private String expiryDate;

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public UserCardInfo() {
    }

    public UserCardInfo(User user, String cardBindingId, String cardholderName, String pan, UserCardStatus statusId, Date createdDate, Date modifiedDate) {
        this.user = user;
        this.cardBindingId = cardBindingId;
        this.cardholderName = cardholderName;
        this.pan = pan;
        this.statusId = statusId;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCardBindingId() {
        return cardBindingId;
    }

    public void setCardBindingId(String cardBindingId) {
        this.cardBindingId = cardBindingId;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public UserCardStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(UserCardStatus statusId) {
        this.statusId = statusId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "UserCardInfo{" +
                "id=" + id +
                ", user=" + user +
                ", cardBindingId='" + cardBindingId + '\'' +
                ", cardholderName='" + cardholderName + '\'' +
                ", pan='" + pan + '\'' +
                ", statusId=" + statusId +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
