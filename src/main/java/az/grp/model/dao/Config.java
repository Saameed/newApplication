package az.grp.model.dao;

import org.slf4j.Logger;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Seymur on 9/5/2014.
 */

@Entity
@Table(name = "config")
public class Config implements IEntity {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(Config.class);

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @Column(name = "created")
    private Date created;

    public Config() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}