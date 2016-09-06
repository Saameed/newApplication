/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.grp.model.dao;

import javax.persistence.*;

/**
 * @author Seymur
 */
@Entity
@Table(name = "studentpoints")
public class StudentPoints implements IEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne
    private Student student;
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    @ManyToOne
    private Lesson lesson;
    @Column(name = "created")
    //  @Temporal(TemporalType.TIMESTAMP)
    private String created;
    @Column(name = "daily")
    private String daily;
    @Column(name = "selfwork")
    private int selfwork;
    @Column(name = "attendance")
    private int attendance;
    @Column(name = "laboratory")
    private int laboratory;
    @Column(name = "kollekvum")
    private int kollekvum;




    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentPoints)) {
            return false;
        }
        StudentPoints other = (StudentPoints) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public int getSelfwork() {
        return selfwork;
    }

    public void setSelfwork(int selfwork) {
        this.selfwork = selfwork;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(int laboratory) {
        this.laboratory = laboratory;
    }

    public int getKollekvum() {
        return kollekvum;
    }

    public void setKollekvum(int kollekvum) {
        this.kollekvum = kollekvum;
    }

    @Override
    public String toString() {
        return "StudentPoints{" +
                "id=" + id +
                ", student=" + student +
                ", lesson=" + lesson +
                ", created='" + created + '\'' +
                ", daily='" + daily + '\'' +
                ", selfwork='" + selfwork + '\'' +
                ", attendance='" + attendance + '\'' +
                ", laboratory='" + laboratory + '\'' +
                ", kollekvum='" + kollekvum + '\'' +
                '}';
    }
}
