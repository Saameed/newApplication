package az.grp.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Seymur on 2/25/2016.
 */

@Entity
@Table(name = "usertypeactivity")
public class UserTypeActivity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "useractivity_id", referencedColumnName = "transaction_id")
    @JsonIgnore
    private UserActivity userActivity;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Types types;

    @Column(name = "count")
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserActivity getUserActivity() {
        return userActivity;
    }

    public void setUserActivity(UserActivity userActivity) {
        this.userActivity = userActivity;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "UserTypeActivity{" +
                "id=" + id +
                ", types=" + types +
                ", count=" + count +
                '}';
    }
}
