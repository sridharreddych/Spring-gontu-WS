package com.gontuseries.studentadmissioncontroller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		//binder.setDisallowedFields(new String[] {"studentMobile"});
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy****MM****dd");
		//binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}

	@RequestMapping(value="/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() throws Exception {

		//String exceptionOccured = "NULL_POINTER";
		//String exceptionOccured = "IO_EXCEPTION";
		String exceptionOccured = "ARITHMETIC_EXCEPTION";
		
		if(exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
			
			throw new NullPointerException("Null Pointer Exception");
		} else if(exceptionOccured.equalsIgnoreCase("IO_EXCEPTION")) {
			throw new IOException("IO Exception");
		} else if(exceptionOccured.equalsIgnoreCase("ARITHMETIC_EXCEPTION")){
			throw new ArithmeticException("Arithmetic Exception");
		}
		
				
		
		ModelAndView model1 = new ModelAndView("AdmissionForm");
		
		return model1;
	}

	@ModelAttribute
    public void addingCommonObjects(Model model1) {
		
		model1.addAttribute("headerMessage", "Gontu College of Engineering, India");
	}

	@RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student student, BindingResult result) {

		 if (result.hasErrors()) {
			 	
				ModelAndView model1 = new ModelAndView("AdmissionForm");
				return model1;
		 }

		ModelAndView model1 = new ModelAndView("AdmissionSuccess");
		return model1;
	}
	
	@ResponseBody
	@RequestMapping(value="/students", method = RequestMethod.GET)
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
	
}

