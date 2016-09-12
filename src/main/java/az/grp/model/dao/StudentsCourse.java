package az.grp.model.dao;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Hp on 2016-09-12.
 */
@Entity
@Table(name = "student_course")
public class StudentsCourse implements IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String userName;
    @Column(name = "fullname")
    private String fullName;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Groups groups;
    @Column(name = "specialty_code")
    private Integer specialtyCode;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "img_path")
    private String imgPath;
    @Column(name = "dob")
    private Calendar dob;

    @Column(name = "cours_id")
    private long  cours;

    @Column(name = "status")
    private int  status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public Integer getSpecialtyCode() {
        return specialtyCode;
    }

    public void setSpecialtyCode(Integer specialtyCode) {
        this.specialtyCode = specialtyCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Calendar getDob() {
        return dob;
    }

    public void setDob(Calendar dob) {
        this.dob = dob;
    }

    public long getCours() {
        return cours;
    }

    public void setCours(long cours) {
        this.cours = cours;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
