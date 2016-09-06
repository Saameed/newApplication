package az.grp.model.dao;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Seymur on 14.07.2016.
 */

@Entity
@Table(name = "laboratory")
public class Laboratory implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Groups groups;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student students;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private SummaryStatus laboratoryStatus;

    @Column(name = "deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "number")
    private Integer number;

    @Column(name = "name")
    private String labName;

    @Column(name = "doc_path")
    private String docPath;

    public String getDocPath() {
        return docPath;
    }

    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public SummaryStatus getLaboratoryStatus() {
        return laboratoryStatus;
    }

    public void setLaboratoryStatus(SummaryStatus laboratoryStatus) {
        this.laboratoryStatus = laboratoryStatus;
    }
}
