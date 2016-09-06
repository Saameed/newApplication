package az.grp.model.dao;

/**
 * Created by Seymur on 14.07.2016.
 */

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exam")
public class Exam implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne
    private Groups groups;
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    @ManyToOne
    private Lesson lesson;
    @Column(name = "room")
    private String room;
    // with minute
    @Column(name = "hour")
    private int hour;
    @Column(name = "status")
    private ExamStatus status;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public ExamStatus getStatus() {
        return status;
    }

    public void setStatus(ExamStatus status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", groups=" + groups +
                ", lesson=" + lesson +
                ", room='" + room + '\'' +
                ", hour=" + hour +
                ", status=" + status +
                ", date=" + date +
                ", created=" + created +
                '}';
    }
}
