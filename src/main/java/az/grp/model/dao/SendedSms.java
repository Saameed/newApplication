package az.grp.model.dao;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Seymur on 11.06.2016.
 */
@Entity
@Table(name = "sendedsms")
public class SendedSms {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne
    private Student student;
    @Column(name = "text")
    private String text;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
