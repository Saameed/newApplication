package az.grp.model.dao;

import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Hp on 2016-08-24.
 */
@Entity
@Table(name = "blog_question")
public class BlogQuestion  implements IEntity{


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "fullName")
    @NotNull
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private int status;
   /* @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private int owner;*/

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

   /* public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }*/

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
