package com.feuersoft.hibernate.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.feuersoft.hibernate.demo.entity.Student;
   
public class Utils {
     
  // The date formatter
  // - dd:   day in month (number)
  // - MM:   month in year (number)
  // - yyyy: year
  //
  // See this link for details: https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
  //
  //
  private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
   
  // read a date string and parse/convert to a date
  public static Date parseDate(String dateStr) throws ParseException {
    return formatter.parse(dateStr);        
  }
   
  // read a date and format/convert to a string
  public static String formatDate(Date theDate) {
        
    String result = null;
        
    if (null != theDate) {
        result = formatter.format(theDate);
    }
    
    return result;
  }

  public static void displayStudents(List<Student> theStudents) {
    for (Student tempStudent : theStudents) {
      System.out.println(tempStudent);
    }
  }  
  
  public static void main(String[] args) {
    // Add some tests here.
  }
  
}
