package az.grp.model.dao;



import javax.persistence.*;
import java.util.Date;

/**
 * Created by Seymur on 1/4/2016.
 */
@Entity
@Table(name = "finalgroup")
public class FinalGroup implements IEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "group_id",referencedColumnName = "id")
    private Groups groups;
    @Column(name = "final_point")
    private int finalPoint;
    @Column(name = "created")
    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public int getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(int finalPoint) {
        this.finalPoint = finalPoint;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "FinalGroup{" +
                "id=" + id +
                ", groups=" + groups +
                ", finalPoint=" + finalPoint +
                ", created=" + created +
                '}';
    }
}
