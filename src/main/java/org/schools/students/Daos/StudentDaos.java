package org.schools.students.Daos;

import org.schools.students.models.Students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.schools.students.utils.*;
public class StudentDaos {

    private   String INSERT_STUDENT_SQL =  "INSERT INTO schoolmgmt.students(studentNumber, fname, lname, dob,grade,address,parentsContacts) VALUES (?, ?, ?, ?, ?,?,?)";


    private   String SELECT_STUDENTS_BY_Number = "select studentNumber,fname,lname,dob,grade,address,parentsContacts from users where schoolmgmt.students.studentNumber =?";
    private   String SELECT_ALL_STUDENTS = "select * from schoolmgmt.students";
    private   String DELETE_STUDENTS_SQL = "delete from schoolmgmt.students where studentNumber = ?;";
    private   String UPDATE_STUDENTS_SQL = "update schoolmgmt.students set fname = ?,lname= ?, grade =? where studentNumber = ?;";
    public StudentDaos() {}

    public void insertStudents(Students students) throws SQLException {
        System.out.println("INSERT_STUDENT_SQL");
        // try-with-resource statement will auto close the connection.
        DbUtil dbutils=new DbUtil();
        try {

           Connection connection = dbutils.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL) ;
                String str=students.getDob();
                Date date=Date.valueOf(str);
                preparedStatement.setInt(1,students.getStudentNumber());
                preparedStatement.setString(2, students.getFname());
                preparedStatement.setString(3,students.getLname());
                preparedStatement.setDate(4, date);
                preparedStatement.setString(5, students.getGrade());
                preparedStatement.setString(6, students.getAddress());
                preparedStatement.setString(7, students.getParentContacts());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Students selectStudentsByNumber(int studemtNumber) {
        Students students = null;
        // Ste 1: Establishing a Connection
        try {
            DbUtil dbutils=new DbUtil();
            Connection connection = dbutils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTS_BY_Number);
            preparedStatement.setInt(1, studemtNumber);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int number=rs.getInt("studentNumber");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                Date dob = rs.getDate("dob");
                String grade = rs.getString("grade");
                String address = rs.getString("address");
                String parentsContacts = rs.getString("parentsContacts");
                students = new Students(number,fname,lname,dob.toString(),grade,address,parentsContacts);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return students;
    }


    public List < Students > selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Students > students = new ArrayList <Students > ();
        // Step 1: Establishing a Connection
        try {
                DbUtil dbutils=new DbUtil();
              Connection connection = dbutils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int number=rs.getInt("studentNumber");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                Date dob = rs.getDate("dob");
                String grade = rs.getString("grade");
                String address = rs.getString("address");
                String parentsContacts = rs.getString("parentsContacts");
                students.add(new Students(number,fname,lname,dob.toString(),grade,address,parentsContacts));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            DbUtil dbutils=new DbUtil();
            Connection connection = dbutils.getConnection();

         PreparedStatement statement = connection.prepareStatement(DELETE_STUDENTS_SQL);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updateStudenst(Students student) throws SQLException {
        boolean rowUpdated=false;
        try {
            DbUtil dbutils=new DbUtil();
             Connection connection = dbutils.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTS_SQL);


             statement.setString(1, student.getFname());
            statement.setString(2, student.getLname());
            statement.setString(3, student.getGrade());
            statement.setInt(4, student.getStudentNumber());

            rowUpdated = statement.executeUpdate() > 0;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return rowUpdated;
    }








}
