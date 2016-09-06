package az.grp.model.dao;

/**
 * Created by Seymur on 14.07.2016.
 */

import javax.persistence.*;
import java.util.Date;

/**
 * @author Seymur
 */
@Entity
@Table(name = "sub_lesson")
public class SubLesson implements IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "hours")
    private String hours;
    @Column(name = "credit")
    private int credit;
    // meshgele laboratoriya
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private SubLessonType subLessonType;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;
    @ManyToOne
    @JoinColumn(name = "parent_lesson_id", referencedColumnName = "id")
    private Lesson parentLesson;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;
    @Column(name = "status")
    private Integer status;


    public SubLesson() {
    }

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

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public SubLessonType getSubLessonType() {
        return subLessonType;
    }

    public void setSubLessonType(SubLessonType subLessonType) {
        this.subLessonType = subLessonType;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Lesson getParentLesson() {
        return parentLesson;
    }

    public void setParentLesson(Lesson parentLesson) {
        this.parentLesson = parentLesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SubLesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hours='" + hours + '\'' +
                ", credit=" + credit +
                ", created=" + created +
                ", parentLesson=" + parentLesson +
                ", teacher=" + teacher +
                ", status=" + status +
                '}';
    }
}

