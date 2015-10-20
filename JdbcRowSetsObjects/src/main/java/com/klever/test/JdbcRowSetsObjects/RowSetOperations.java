package com.klever.test.JdbcRowSetsObjects;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;

/**
 * Created by svoitenko on 14 Oct 2015.
 */
public class RowSetOperations {

    CachedRowSet rowSet = null;

    public RowSetOperations(CachedRowSet rowSet) {
        this.rowSet = rowSet;
    }

    public void showStudentsInfo() throws SQLException {
        rowSet.setCommand("select * from students");
        rowSet.execute();

        while (rowSet.next()) {
            System.out.println(rowSet.getInt(1) +
                    " " + rowSet.getString(2) +
                    " " + rowSet.getString(3) +
                    " " + rowSet.getInt(4) + " years old");
        }
        System.out.println();
    }

    public void insertIntoStudents(String firstName,String lastName,int age) throws SQLException {
        rowSet.moveToInsertRow();
        rowSet.updateString("firstname", firstName);
        rowSet.updateString("lastname", lastName);
        rowSet.updateInt("age", age);
        rowSet.insertRow();
        rowSet.acceptChanges();

    }


    public void updateStudentAge(int studentId, int newAgeValue) throws SQLException {
        rowSet.absolute(studentId);
        rowSet.updateInt(4, newAgeValue);
        rowSet.updateRow();
        rowSet.acceptChanges();

    }

    public void removeLastStudentRecord() throws SQLException {
        rowSet.last();
        rowSet.deleteRow();
    }

}
