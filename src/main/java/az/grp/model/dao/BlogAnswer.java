package az.grp.model.dao;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Hp on 2016-08-24.
 */
@Entity
@Table(name = "blog_answer")
public class BlogAnswer implements IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userEmail")
    private String email;

    @Column(name = "status")
    private int status;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private BlogQuestion question;

    /*@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BlogQuestion getQuestion() {
        return question;
    }

    public void setQuestion(BlogQuestion question) {
        this.question = question;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
