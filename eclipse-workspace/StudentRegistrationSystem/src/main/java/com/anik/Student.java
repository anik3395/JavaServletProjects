package com.anik;

public class Student {
	
	//instance variable for Student class...
	private String name;
    private String email;
    private String course;
    
    
    // for initialize the student variable i used constructor..
	public Student(String name, String email, String course) {
	
		this.name = name;
		this.email = email;
		this.course = course;
	}

	//Getter method used for get and return those 3 variable's value:
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCourse() {
		return course;
	}

	//Setter method used for set(i wish) and return those 3 variable's value:
	
	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCourse(String course) {
		this.course = course;
	}


	
	
	
	
	
    
    

}
