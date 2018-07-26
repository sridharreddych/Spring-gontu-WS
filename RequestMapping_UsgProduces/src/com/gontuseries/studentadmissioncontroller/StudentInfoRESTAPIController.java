package com.gontuseries.studentadmissioncontroller;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentInfoRESTAPIController {

	//***********Retrieving all student records ***************
	//Controller class if annotated with Just @Controller then you have to include @Response
	//Body, if you use @RestController then no need to include @ResponseBody, choice is yours
		
		@RequestMapping(value="/students", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
		public ArrayList<Student> getStudentsList() {
			
			Student student1 = new Student();
			student1.setStudentName("The Great Khali");
			
			Student student2=  new Student();
			student2.setStudentName("The Undertaker");
			
			Student student3=  new Student();
			student3.setStudentName("John Cena");
			
			ArrayList<Student> studentsList = new ArrayList<Student>();
			
			studentsList.add(student1);
			studentsList.add(student2);
			studentsList.add(student3);
			
			return studentsList;
			
			
		}
		
		//*****************Retrieving a student record ***************8
		
		@RequestMapping(value="/students/{name}", method=RequestMethod.GET)
	    public Student getStudent(@PathVariable("name") String studentName) {
	    	
	    	//fetch the student's record using "studentName" from DB
	    	Student student = new Student();
	    	student.setStudentName(studentName);
	    	student.setStudentHobby("WWE");
	    	return student;
	    }
}
