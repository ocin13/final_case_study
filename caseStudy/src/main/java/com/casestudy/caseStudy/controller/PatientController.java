package com.casestudy.caseStudy.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.caseStudy.entityModels.Address;
import com.casestudy.caseStudy.entityModels.Patient;
import com.casestudy.caseStudy.entityModels.User;
import com.casestudy.caseStudy.services.AddressServiceImp;
import com.casestudy.caseStudy.services.PatientServiceImp;
import com.casestudy.caseStudy.services.UserServiceImp;



@Controller
public class PatientController {
	
	@Autowired
	PatientServiceImp ps;
	@Autowired
	UserServiceImp us;
	@Autowired
	AddressServiceImp as;
	
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	//display patients list
	@RequestMapping("/patients")
	public ModelAndView showPatientsList() {
		ModelAndView mav = new ModelAndView("patients");
		List<Patient> patientsList = ps.getAllPatients();
		mav.addObject("patientsList", patientsList);
		return mav;
	}
	
	//display patient form
	@GetMapping("/newPatient")
	public ModelAndView showPatientForm() {
		ModelAndView mav = new ModelAndView("patient_form");
		return mav;
	}
	//insert new doctor to the database 
			@PostMapping("/addPatient")
			public @ResponseBody ModelAndView createPatient(@Valid Patient patient,
					@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName,
					@RequestParam("userName")  String userName,@RequestParam("email")  String email,
					@RequestParam("password")  String password,@RequestParam("dateOfBirth")  String dateOfBirth,
					@RequestParam("gender")  String gender,@RequestParam("street")  String street,
					@RequestParam("apt")  String apt,@RequestParam("city")  String city,
					@RequestParam("state")  String state,@RequestParam("zip")  Integer zip,
					@RequestParam("phone")  Long phone,final @RequestParam("file") MultipartFile file) {
				    ModelAndView mav = new ModelAndView("patient_form");
				try {
					HttpHeaders headers = new HttpHeaders();
					if (patient == null) {
						mav =  new ModelAndView("patient_form");
						
					}
					
					String fileName = file.getOriginalFilename();
					String filePath = Paths.get(uploadDirectory, fileName).toString();
					String fileType = file.getContentType();
					long size = file.getSize();
					String fileSize = String.valueOf(size);

					
					// Save the file locally
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
					stream.write(file.getBytes());
					stream.close();

					patient.setFirstName(firstName);
					patient.setLastName(lastName);
					patient.setDateOfBirth(dateOfBirth);
					patient.setGender(gender);
					patient.setPhone(phone);
					patient.setFileName(fileName);
					patient.setFilePath(filePath);
					patient.setFileType(fileType);
					patient.setFileSize(fileSize);
					User newUser = new User(userName,email,password,true,"PATIENT");
					Address newAddress = new Address(street,apt,city,state,zip);
					as.addNewAddress(newAddress);
					us.addNewUser(newUser);
					
					
					patient.setAddress(as.getAddressById(newAddress.getId()));
					patient.setAccount(us.getUserById(newUser.getId()));
					
					boolean status = ps.addNewPatient(patient);
					if (status) {
						mav =  new ModelAndView("patient_form");
						String message = "new patient registered successfully";
						mav.addObject("message", message);
						
					}
				} catch (Exception e) {
					e.printStackTrace();
					mav = new ModelAndView("patient_form");
					String message = "new patient register failed";
					mav.addObject("message", message);
				}
				return mav;
			}
			
			//delete an existing patient from the database
			@RequestMapping(value = "/deletePatient{pId}", method = RequestMethod.GET)
			public ModelAndView delete(@PathVariable("pId") Integer pId) {
				ModelAndView mav = new ModelAndView("patients");
				ps.deletePatientById(pId);
				List<Patient> patientsList = ps.getAllPatients();
				mav.addObject("patientsList", patientsList);
				return mav;
			}
		
			//show edit form
			@RequestMapping(value = "/editPatient{pId}", method = RequestMethod.GET)
			public ModelAndView edit(@PathVariable("pId") Integer pId) {
				ModelAndView mav = new ModelAndView("patient_form");
					Patient patientToUpdate = ps.getPatientById(pId);
					mav.addObject("patient", patientToUpdate);
				
				return mav;
			}
			
			//register new updated patient information
			@RequestMapping(value = "/editPatient", method = RequestMethod.POST)
			public ModelAndView editPatient(@RequestParam("pId") Integer pId,@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName,
					@RequestParam("userName")  String userName,@RequestParam("email")  String email,
					@RequestParam("password")  String password,@RequestParam("dateOfBirth")  String dateOfBirth,
					@RequestParam("gender")  String gender,@RequestParam("street")  String street,
					@RequestParam("apt")  String apt,@RequestParam("city")  String city,
					@RequestParam("state")  String state,@RequestParam("zip")  Integer zip,
					@RequestParam("phone")  Long phone) {
				ModelAndView mav = new ModelAndView("patient_form");
				Patient patient = new Patient();
				patient.setpId(pId);
				patient.setFirstName(firstName);
				patient.setLastName(lastName);
				patient.setDateOfBirth(dateOfBirth);
				patient.setGender(gender);
				patient.setPhone(phone);
				User newUser = new User(userName,email,password,true,"PATIENT");
				Address newAddress = new Address(street,apt,city,state,zip);
				patient.setAccount(newUser);
				patient.setAddress(newAddress);
				ps.updatePatientById(patient.getpId(), patient);
				String message = "patient updated successfully";
				mav.addObject("message", message);
				return mav;
			}
			
}
