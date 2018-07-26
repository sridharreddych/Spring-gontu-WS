package com.gontuseries.studentadmissioncontroller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		
		
		//************Updating a Student Record ******************
		//public ResponseEntity<Void> updateStudent(@PathVariable("name") String studentName, @RequestBody Student student) {
		@RequestMapping(value="/students/{name}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_XML_VALUE)
		public ResponseEntity<Boolean> updateStudent(@PathVariable("name") String studentName, @RequestBody Student student) {
			
			System.out.println("Student Name: "+studentName);
			System.out.println("Student Name: "+student.getStudentName()+"Student Hobby: "+student.getStudentHobby());
			
			//find the matching student record using "studentName" from the DB
			//update the matching student record with the information of student sent by the client
			
			//return true if the update is successfully done and return false if the update is not done successfully
			//return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			//return new ResponseEntity<Void>(HttpStatus.OK);
			
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("key1", "value1");
			httpHeaders.add("key2", "value2");
			
			return new ResponseEntity<Boolean>(true,httpHeaders,HttpStatus.OK);
		}
		
		//*********************Posting a Student Record ******************
		@RequestMapping(value="/students", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Boolean> postStudent(@RequestBody Student student) {
			
		
			System.out.println("Student Name: "+student.getStudentName()+"Student Hobby: "+student.getStudentHobby());
			
			// insert the studen record into the database
			
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add(
					"Location",
					ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{name}")
					.buildAndExpand(student.getStudentName()).toUri()
					.toString());
			
			return new ResponseEntity<Boolean>(true,httpHeaders,HttpStatus.OK);
			
}
		
	//*****************Deleting a student record ***************8
		
		@RequestMapping(value="/students/{name}", method=RequestMethod.DELETE)
	    public ResponseEntity<Boolean> deleteStudent(@PathVariable("name") String studentName) {
	    

			System.out.println("Student Name: "+studentName);
	    
			//delet the student record from DB
	    	
	    	return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	    }
		
		//*****************Deleting all student record ***************8
		
				@RequestMapping(value="/students", method=RequestMethod.DELETE)
			    public ResponseEntity<Boolean> deleteallStudents() {
			    

					//delete all the student record from DB
			    	
			    	return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			    }
		
}

