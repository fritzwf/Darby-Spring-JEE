package com.feuersoft.jdbc;

//import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

  public static void main(String[] args) {
    
    
    String dbName = "hb_student_tracker";
    String jdbcUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
    String user = "hbstudent";
    String password = "hbstudent";
    
    try {
      
      System.out.println("Connecting to database: " + jdbcUrl);
      
      // Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);

      DriverManager.getConnection(jdbcUrl, user, password);
      
      System.out.println("Successfully connected to the " + dbName + " database!!!");
      
    } catch (Exception err) {
      err.printStackTrace();
    }

  }

}
