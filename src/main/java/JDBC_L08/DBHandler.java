package JDBC_L08;


import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {

    private final String PATH_TO_DB="jdbc:sqlite:C:\\Users\\APr\\IdeaProjects\\JavaCoreQAwithMaven\\src\\main\\resources\\University.db";
    private Connection connection;

    public DBHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection =DriverManager.getConnection(PATH_TO_DB);
    }

    public void addStudent(Student student){

        try(PreparedStatement statement=this.connection.prepareStatement(
                "INSERT INTO Students('name','faculty','age')"+
                        "VALUES(?,?,?)")){
            statement.setObject(1,student.getName());
            statement.setObject(2,student.getFaculty());
            statement.setObject(3,student.getAge());
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteStudent(Student student){

        try(PreparedStatement statement=this.connection.prepareStatement(
                "DELETE FROM Students where name = ?")){
            statement.setObject(1,student.getName());
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteAllStudent(){

        try(PreparedStatement statement=this.connection.prepareStatement(
                "DELETE FROM Students")){
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents(){

        List<Student>students=new ArrayList<>();

        try(Statement statement=this.connection.createStatement()){

            ResultSet resultSet= statement.executeQuery(
                    "SELECT name, faculty, age FROM Students");

            while (resultSet.next()){
                students.add(new Student(
                        resultSet.getString("name"),
                        resultSet.getString("faculty"),
                        resultSet.getInt("age")
                ));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }


    public List<Student> getAllStudentsFromFacultyLit(){

        List<Student>students=new ArrayList<>();

        try(Statement statement=this.connection.createStatement()){

            ResultSet resultSet= statement.executeQuery(
                    "SELECT name, faculty, age FROM Students WHERE faculty = 'Lit'");

            while (resultSet.next()){
                students.add(new Student(
                        resultSet.getString("name"),
                        resultSet.getString("faculty"),
                        resultSet.getInt("age")
                ));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }


}

