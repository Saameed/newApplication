package az.grp.model.dao;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Seymur on 14.07.2016.
 */
@Entity
@Table(name = "summary")
public class Summary implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private Lesson lesson;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student students;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private SummaryStatus summaryStatus;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "doc_path")
    private String docPath;




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

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }

    public SummaryStatus getSummaryStatus() {
        return summaryStatus;
    }

    public void setSummaryStatus(SummaryStatus summaryStatus) {
        this.summaryStatus = summaryStatus;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDocPath() {
        return docPath;
    }

    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lesson=" + lesson +
                ", students=" + students +
                ", summaryStatus=" + summaryStatus +
                ", created=" + created +
                ", docPath='" + docPath + '\'' +
                '}';
    }
}
