package com.he.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Students {
	
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	private int sid;
	private String studentName;
	
	@OneToMany
	@JoinTable(name="student_course" , joinColumns = @JoinColumn( name = "sid"), 
								inverseJoinColumns =@JoinColumn(name= "course_id"))
	private Collection<Course> course = new ArrayList<>();	
	
	
	
	public Collection<Course> getCourse() {
		return course;
	}
	public void setCourse(Collection<Course> course) {
		this.course = course;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	

}
