package com.gontuseries.studentadmissioncontroller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {


	@RequestMapping(value="/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {

		ModelAndView model1 = new ModelAndView("AdmissionForm");
		
		return model1;
	}

	@ModelAttribute
    public void addingCommonObjects(Model model1) {
		
		model1.addAttribute("headerMessage", "Gontu College of Engineering, India");
	}

		@RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1") Student student) {
		

		ModelAndView model1 = new ModelAndView("AdmissionSuccess");
		return model1;
	}
	
	
	
	 
/*@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
public ModelAndView submitAdmissionForm(@RequestParam("studentName") String name,
@RequestParam("studentHobby") String hobby,
@RequestParam("studentMobile") String mobileNo,
@RequestParam("studentDOB") String DOB,
@RequestParam("studentSkills") String[] skillsSet) {

 Student student1 = new Student();
 
 try {
  student1.setStudentName(name);
  student1.setStudentHobby(hobby);
 
  SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
  
  student1.setStudentDOB(format.parse(DOB));
  student1.setStudentMobile(Long.parseLong(mobileNo));
  
  ArrayList<String> skillsSetList = new ArrayList<String>();
  
  for(int i=0; i<skillsSet.length; i++) {
     skillsSetList.add(skillsSet[i]);
	 }
	 student1.setStudentSkills(skillsSetList);
	 }catch(Exception e) {
	 }
	 ModelAndView model1 = new ModelAndView("AdmissionSuccess");
	 model1.addObject("student1",student1);
	 
	 return model1;
	}*/
	 }

  
	  
	 
	 
	


