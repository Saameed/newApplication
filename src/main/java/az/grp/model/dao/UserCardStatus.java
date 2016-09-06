package az.grp.model.dao;

import javax.persistence.*;

/**
 * Created by Seymur on 14-Oct-15.
 */

@Entity
@Table(name = "usercardstatus")
public class UserCardStatus implements  IEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
