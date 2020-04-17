package model;

import java.sql.Date;

public class StudentBean {

    private int id;
    private String fullName;
    private Date dateBirth;
    private int sex;
    private String classId;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public StudentBean(int id, String fullName, Date dateBirth, int sex, String classId) {
        this.id = id;
        this.fullName = fullName;
        this.dateBirth = dateBirth;
        this.sex = sex;
        this.classId = classId;
    }

    public StudentBean(String fullName, Date dateBirth, int sex, String classId) {
        this.fullName = fullName;
        this.dateBirth = dateBirth;
        this.sex = sex;
        this.classId = classId;
    }

    public StudentBean() {
        
    }
       
}
