package com.feuersoft.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.feuersoft.hibernate.demo.Utils;

@Entity
@Table(name="student")
public class Student {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", updatable = false, nullable = false)
  private Long id;
  
  @Column(name="first_name")
  private String firstName;
  
  @Column(name="last_name")
  private String lastName;
  
  @Column(name="email")
  private String email;
  
  @ManyToMany( 
      fetch=FetchType.LAZY,
      cascade= {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.PERSIST,
          CascadeType.REFRESH
        }
  )
  @JoinTable(
      name="course_student",
      joinColumns=@JoinColumn(name="student_id"),
      inverseJoinColumns=@JoinColumn(name="course_id")
  )
  private List<Course> courses = new ArrayList<Course>();  
  
  // Add the date column using this query:
  // ALTER TABLE `hb_student_tracker`.`student` 
  // ADD COLUMN `date_of_birth` DATETIME NULL AFTER `last_name`;
  //  @Column(name="date_of_birth")
  //  @Temporal(TemporalType.TIMESTAMP)
  //  private Date dateOfBirth;
    
  public Student() {}
  
  public Student(String firstName, String lastName, String email) {
    super();
    this.id = null;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
//    this.dateOfBirth = dateOfBirth;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  
  
//  public Date getDateOfBirth() {
//    return dateOfBirth;
//  }
//
//  public void setDateOfBirth(Date dateOfBirth) {
//    this.dateOfBirth = dateOfBirth;
//  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  @Override
  public String toString() {
    return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
  }

}
