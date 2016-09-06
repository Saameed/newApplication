/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.grp.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Seymur
 */
@Entity
@Table(name = "useractivity")
public class UserActivity implements IEntity {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "transaction_id", unique = true, nullable = false)
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "userTransaction"))
    private Integer transaction_id;

    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    @OneToOne
    @JsonIgnore
    private UserTransaction userTransaction;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne
    private Student student;
    @JoinColumn(name = "register_status_id", referencedColumnName = "id")
    @ManyToOne
    private RegisterStatus registerStatus;

    @OneToMany(mappedBy = "userActivity", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<UserTypeActivity> userTypeActivities = new ArrayList<UserTypeActivity>();


    public UserActivity() {
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public UserTransaction getUserTransaction() {
        return userTransaction;
    }

    public void setUserTransaction(UserTransaction userTransaction) {
        this.userTransaction = userTransaction;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public RegisterStatus getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(RegisterStatus registerStatus) {
        this.registerStatus = registerStatus;
    }

    public List<UserTypeActivity> getUserTypeActivities() {
        return userTypeActivities;
    }

    public void setUserTypeActivities(List<UserTypeActivity> userTypeActivities) {
        this.userTypeActivities = userTypeActivities;
    }

    @Override
    public String toString() {
        return "UserActivity{" +
                "transaction_id=" + transaction_id +
                ", created=" + created +
                ", lastModified=" + lastModified +
                ", user=" + user +
                ", student=" + student +
                ", registerStatus=" + registerStatus +
                '}';
    }
}
