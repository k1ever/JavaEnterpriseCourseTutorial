package com.klever.test.JdbcRowSetsObjects;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by svoitenko on 14 Oct 2015.
 */
public class JdbcRowSetsObjectsTest {

    public static void main(String[] args) throws SQLException {

        CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
//        rowSet.setUrl("jdbc:mysql://localhost:3306/students");
//        rowSet.setUsername("root");
//        rowSet.setPassword("admin");


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "admin");
        conn.setAutoCommit(false);

        rowSet.setCommand("select * from students");
        rowSet.execute(conn);

//        RowSetOperations operation = new RowSetOperations(rowSet);
//
//        operation.showStudentsInfo();
//
////        operation.insertIntoStudents("Sergei","Voitenko", 27);
////        operation.showStudentsInfo();
//
//        operation.updateStudentAge(1, 20);
//        operation.showStudentsInfo();
//
//
//        operation.removeLastStudentRecord();
//        operation.showStudentsInfo();


        rowSet.setReadOnly(false);
        showData(rowSet);
        insertRecord(rowSet);
    }

    public static void showData(CachedRowSet rowSet) throws SQLException {


        while (rowSet.next()) {
            System.out.println(rowSet.getString(1) +
                    " " + rowSet.getString(2) +
                    " " + rowSet.getString(3) +
                    " " + rowSet.getInt(4) + " years old");
        }
    }

    public static void insertRecord(CachedRowSet rowSet) throws SQLException {
        rowSet.moveToInsertRow();
        rowSet.updateNull("id");
        rowSet.updateString("firstname", "John");
        rowSet.updateString("lastname", "Smith");
        rowSet.updateInt("age", 21);
        rowSet.insertRow();
        rowSet.moveToCurrentRow();

        rowSet.acceptChanges();
    }

    public static void updateRecord(CachedRowSet rowSet) throws SQLException {
        rowSet.absolute(2);
        rowSet.updateInt(4, 21);
        rowSet.updateRow();
        rowSet.acceptChanges();
    }
}

