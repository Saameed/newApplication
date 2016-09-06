package az.grp.model.dao;

import javax.persistence.*;

/**
 * Created by Seymur on 14.07.2016.
 */

@Entity
@Table(name = "summarystatus")
public class SummaryStatus implements IEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
