package org.schools.students.models;

public class Students {

    private int studentNumber;
    private String fname;
    private String lname;
    private String dob;
    private String grade;
    private String address;



    private String parentContacts;

      public Students() {}

    public Students(int studentNumber,String fname,String lname,String dob,String grade,String address,String parentContacts ) {
        super();
        this.studentNumber=studentNumber;
        this.fname=fname;
        this.lname=lname;
        this.dob=dob;
        this.grade=grade;
        this.address=address;
        this.parentContacts=parentContacts;
    }



    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParentContacts() {
        return parentContacts;
    }

    public void setParentContacts(String parentContacts) {
        this.parentContacts = parentContacts;
    }




}
