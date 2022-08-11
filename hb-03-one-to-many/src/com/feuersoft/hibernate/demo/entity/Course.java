package com.feuersoft.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
  
  // Define our fields
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", updatable = false, nullable = false)
  private long id;
  
  @Column(name="title", updatable = false, nullable = false)
  private String title;
  
  @ManyToOne( 
      cascade= {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.PERSIST,
          CascadeType.REFRESH
        })
  @JoinColumn(name="instructor_id")
  private Instructor instructor;
 
  // Define constructors
  public Course() { }

  public Course(String title) {
    this.title = title;
  }
  
  // Define getter and setter's
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Instructor getInstructor() {
    return instructor;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  // Define toString
  @Override
  public String toString() {
    return "Course [id=" + id + ", title=" + title + "]";
  }
}
