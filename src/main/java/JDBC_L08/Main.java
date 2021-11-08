package JDBC_L08;


import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Student student1=new Student("Her","Lit",19);
        Student student2=new Student("L","Math",18);
        Student student3=new Student("Jo","CS",19);
        Student student4=new Student("Kate","Herbology",18);
        Student student5=new Student("Y","Lit",19);

        DBHandler dbHandler=new DBHandler();

        dbHandler.addStudent(student1);
        dbHandler.addStudent(student2);
        dbHandler.addStudent(student3);
        dbHandler.addStudent(student4);
        dbHandler.addStudent(student5);
        System.out.println(dbHandler.getAllStudents());

        System.out.println(dbHandler.getAllStudentsFromFacultyLit());

        dbHandler.deleteAllStudent();
        System.out.println(dbHandler.getAllStudents());



        /*
        dbHandler.deleteStudent(student1);
        dbHandler.deleteStudent(student2);
        dbHandler.deleteStudent(student3);
        dbHandler.deleteStudent(student4);
        dbHandler.deleteStudent(student5);
        System.out.println(dbHandler.getAllStudents());


        dbHandler.addStudent(student1);
        System.out.println(dbHandler.getAllStudents());
        dbHandler.addStudent(student3);
        System.out.println(dbHandler.getAllStudents());
         */


    }
}
