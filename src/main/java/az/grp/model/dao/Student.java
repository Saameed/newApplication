/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.grp.model.dao;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Seymur
 */
@Entity
@Table(name = "student")
public class Student implements IEntity {
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
    @Column(name = "student_ticket_no")
    private Integer studentTicketNo;
    @ManyToOne
    @JoinColumn(name = "group_id",referencedColumnName = "id")
    private Groups groups;
    @Column(name = "specialty_code")
    private Integer specialtyCode;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "img_path")
    private String imgPath;
    @Column(name = "dob")
    private Calendar dob;
    @Column(name = "created")
    private Date created;
    @Column(name = "last_modified")
    private Date lastModified;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id",name = "privilege_id",nullable = false)
    private Privilege privilege;
    @Transient
    private long dayBrithdayCount;
   /* @Column(name = "status")
    private Integer status;*/


  /*  @OneToMany(mappedBy = "studentId",fetch = FetchType.EAGER)
    private Collection<RegisterTransaction> registertransactionCollection;
    @OneToMany(mappedBy = "studentId")
    private Collection<UserTypeActivity> useractivityCollection;*/

    public Student() {
    }

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

    public Integer getStudentTicketNo() {
        return studentTicketNo;
    }

    public void setStudentTicketNo(Integer studentTicketNo) {
        this.studentTicketNo = studentTicketNo;
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

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public long getDayBrithdayCount() {
        return dayBrithdayCount;
    }

    public void setDayBrithdayCount(long dayBrithdayCount) {
        this.dayBrithdayCount = dayBrithdayCount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", studentTicketNo=" + studentTicketNo +
                ", groups=" + groups +
                ", specialtyCode=" + specialtyCode +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", dob=" + dob +
                ", created=" + created +
                ", lastModified=" + lastModified +
                ", privilege=" + privilege +
                ", dayBrithdayCount=" + dayBrithdayCount +
                '}';
    }
}
