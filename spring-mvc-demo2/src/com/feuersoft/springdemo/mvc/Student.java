package com.feuersoft.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
  private String firstName;
  private String lastName;
  private String country;
  private String favoriteLanguage;
  private LinkedHashMap<String, String> favoriteLanguageOptions;
  private LinkedHashMap<String, String> countryOptions;
//  private LinkedHashMap<String, String> operatingSystems;
  private String[] operatingSystems;
  
  public Student() {
    
    // populate country options: used ISO country code
    
    countryOptions = new LinkedHashMap<>();
    
    countryOptions.put("AR", "Argentina");
    countryOptions.put("FR", "France");
    countryOptions.put("DE", "Germany");
    countryOptions.put("IN", "India");
    countryOptions.put("US", "United States of America");
    
    // populate favorite language options
    favoriteLanguageOptions = new LinkedHashMap<>();
    
    favoriteLanguageOptions.put("Java", "Java");
    favoriteLanguageOptions.put("C#", "C#");
    favoriteLanguageOptions.put("C++", "C++");
    favoriteLanguageOptions.put("JavaScript", "JavaScript");
    
    // populate favorite operating systems
//    operatingSystems = new LinkedHashMap<>();
//    operatingSystems.put("Linux", "Linux");
//    operatingSystems.put("Mac OS", "Mac OS");
//    operatingSystems.put("MS Windows", "MS Windows");
   
    
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

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
  
  public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
    return favoriteLanguageOptions;
  }  

  public void setFavoriteLanguage(String favoriteLanguage) {
    this.favoriteLanguage = favoriteLanguage;
  }

  public LinkedHashMap<String, String> getCountryOptions() {
    return countryOptions;
  }
  
  public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
    this.countryOptions = countryOptions;
  }

  public String getFavoriteLanguage() {
    return favoriteLanguage;
  }

  public String[] getOperatingSystems() {
    return operatingSystems;
  }

  public void setOperatingSystems(String[] operatingSystems) {
    this.operatingSystems = operatingSystems;
  }


  
}

