package az.grp.model.web;

import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Created by Seymur on 12/12/2015.
 */


public class RegisterWO {


    private int studentTicketNo;
    private String studentMobileNumber;
    private String password;
    private String repeatPassword;
    private String checkboxs;
    private String name;
    private String surname;
    private String email;
    private String userMobileNumber;


    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getCheckboxs() {
        return checkboxs;
    }

    public void setCheckboxs(String checkboxs) {
        this.checkboxs = checkboxs;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStudentTicketNo() {
        return studentTicketNo;
    }

    public void setStudentTicketNo(int studentTicketNo) {
        this.studentTicketNo = studentTicketNo;
    }

    public String getStudentMobileNumber() {
        return studentMobileNumber;
    }

    public void setStudentMobileNumber(String studentMobileNumber) {
        this.studentMobileNumber = studentMobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    @Override
    public String toString() {
        return "RegisterWO{" +
                "studentTicketNo=" + studentTicketNo +
                ", studentMobileNumber='" + studentMobileNumber + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                ", checkboxs='" + checkboxs + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", userMobileNumber='" + userMobileNumber + '\'' +
                '}';
    }


}
