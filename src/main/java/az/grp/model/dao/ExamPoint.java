package az.grp.model.dao;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Seymur on 11.06.2016.
 */
@Entity
@Table(name = "exampoint")
public class ExamPoint implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne
    private Student student;
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    @ManyToOne
    private Lesson lesson;
    @Column(name = "afterPoint")
    private int afterPoint;
    @Column(name = "beforePoint")
    private int beforePoint;
    @Column(name = "mark")
    private String mark;
    @Column(name = "sumPoint")
    private int sumPoint;
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

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public int getAfterPoint() {
        return afterPoint;
    }

    public void setAfterPoint(int afterPoint) {
        this.afterPoint = afterPoint;
    }

    public int getBeforePoint() {
        return beforePoint;
    }

    public void setBeforePoint(int beforePoint) {
        this.beforePoint = beforePoint;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getSumPoint() {
        return sumPoint;
    }

    public void setSumPoint(int sumPoint) {
        this.sumPoint = sumPoint;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "student=" + student +
                ", lesson=" + lesson +
                ", afterPoint=" + afterPoint +
                ", beforePoint=" + beforePoint +
                ", mark='" + mark + '\'' +
                ", sumPoint=" + sumPoint +
                ", created=" + created +
                '}';
    }
}
