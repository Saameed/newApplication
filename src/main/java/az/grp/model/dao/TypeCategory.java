package az.grp.model.dao;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Seymur on 12/23/2015.
 */
@Entity
@Table(name = "typecategory")
public class TypeCategory implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "selfwork")
    private Integer selfWork;
    @Column(name = "kollekvum")
    private Integer kollekvum;
    @Column(name = "daily")
    private Integer daily;
    @Column(name = "laboratory")
    private Integer laboratory;
    @Column(name = "attendance")
    private Integer attendance;
    @Column(name = "final")
    private Integer finalPoint;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date last_modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSelfWork() {
        return selfWork;
    }

    public void setSelfWork(Integer selfWork) {
        this.selfWork = selfWork;
    }

    public Integer getKollekvum() {
        return kollekvum;
    }

    public void setKollekvum(Integer kollekvum) {
        this.kollekvum = kollekvum;
    }

    public Integer getDaily() {
        return daily;
    }

    public void setDaily(Integer daily) {
        this.daily = daily;
    }

    public Integer getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Integer laboratory) {
        this.laboratory = laboratory;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Date last_modified) {
        this.last_modified = last_modified;
    }

    public Integer getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(Integer finalPoint) {
        this.finalPoint = finalPoint;
    }

    public TypeCategory() {
    }

    @Override
    public String toString() {
        return "TypeCategory{" +
                "id=" + id +
                ", selfWork=" + selfWork +
                ", kollekvum=" + kollekvum +
                ", daily=" + daily +
                ", laboratory=" + laboratory +
                ", attendance=" + attendance +
                ", created=" + created +
                ", finalPoint=" + finalPoint +
                '}';
    }
}
