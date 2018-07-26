package com.gontuseries.studentadmissioncontroller;

import java.text.SimpleDateFormat;
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

		String exceptionOccured = "ARITHMETIC_EXCEPTION";
		
		if(exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
			
			throw new NullPointerException("Null Pointer Exception");
		} /*else if(exceptionOccured.equalsIgnoreCase("IO_EXCEPTION")) {
			throw new IOException("IO Exception");
		}*/ else if(exceptionOccured.equalsIgnoreCase("ARITHMETIC_EXCEPTION")){
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
	

	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e){
		//logging null pointer exception
		System.out.println("Null Pointer Exception Occured: "+e );
		return "NullPointerException";
	}
	
	/*@ExceptionHandler(value = IOException.class)
	public String handleIOException(Exception e){
		//logging IO Exception
		System.out.println("IO Exception Occured: "+e );
		return "IOException";
	}*/
	
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e){
		//logging IO Exception
		System.out.println("Unknown Exception Occured: "+e );
		return "Exception";
	}
}

