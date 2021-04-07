package com.casestudy.caseStudy.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;


import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
import com.casestudy.caseStudy.entityModels.Doctor;
import com.casestudy.caseStudy.entityModels.User;
import com.casestudy.caseStudy.services.AddressServiceImp;
import com.casestudy.caseStudy.services.DoctorService;
import com.casestudy.caseStudy.services.DoctorServiceImp;
import com.casestudy.caseStudy.services.UserServiceImp;





@Controller
public class DoctorsController {
	
	//create file to store uploaded files
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	@Autowired
	DoctorServiceImp ds;
	@Autowired
	UserServiceImp us;
	@Autowired
	AddressServiceImp as;
	
	//display doctors page
		@RequestMapping("/doctors")
		public ModelAndView showDoctorsList() {
			ModelAndView mav = new ModelAndView("doctors");
			List<Doctor> doctorsList = ds.getAllDoctors();
			mav.addObject("doctorsList", doctorsList);
			return mav;
		}
		//display new doctor form
		@GetMapping("/newDoctor")
		public ModelAndView showDoctorForm() {
			ModelAndView mav = new ModelAndView("doctor_form");
			return mav;
		}
		//insert new doctor to the database 
		@PostMapping("/addDoctor")
		public @ResponseBody  ModelAndView createDoctor(@ModelAttribute @Valid Doctor doctor,
				@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName, @RequestParam("speciality") String speciality,
				@RequestParam("userName")  String userName,@RequestParam("email")  String email,
				@RequestParam("password")  String password,@RequestParam("dateOfBirth")  String dateOfBirth,
				@RequestParam("gender")  String gender,@RequestParam("street")  String street,
				@RequestParam("apt")  String apt,@RequestParam("city")  String city,
				@RequestParam("state")  String state,@RequestParam("zip")  Integer zip,
				@RequestParam("phone")  Long phone,final @RequestParam("file") MultipartFile file, BindingResult bindingResult) {
			    ModelAndView mav = new ModelAndView("doctor_form");
			    //check if there is any errors related to fields format
			    if (bindingResult.hasErrors()) {
			    	mav = new ModelAndView("doctor_form");
					return mav;
					
				}else {
					try {
						HttpHeaders headers = new HttpHeaders();
						
						//extract file properties
						String fileName = file.getOriginalFilename();
						String filePath = Paths.get(uploadDirectory, fileName).toString();
						String fileType = file.getContentType();
						long size = file.getSize();
						String fileSize = String.valueOf(size);
		
						
						// Save the file locally
						BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
						stream.write(file.getBytes());
						stream.close();
						
						
						//set new doctor
						doctor.setFirstName(firstName);
						doctor.setLastName(lastName);
						doctor.setSpeciality(speciality);
						doctor.setDateOfBirth(dateOfBirth);
						doctor.setGender(gender);
						doctor.setPhone(phone);
						doctor.setFileName(fileName);
						doctor.setFilePath(filePath);
						doctor.setFileType(fileType);
						doctor.setFileSize(fileSize);
						
						//set new user and address object 
						User newUser = new User(userName,email,password,true,"DOCTOR");
						Address newAddress = new Address(street,apt,city,state,zip);
						as.addNewAddress(newAddress);
						us.addNewUser(newUser);
						doctor.setAccount(newUser);
						doctor.setAddress(newAddress);
						
						
						//save doctor to the database
						boolean status = ds.addNewDoctor(doctor);
						//check if it has been saved successfully
						if (status) {
							
							headers.add("Employe Saved With Image - ", fileName);
							mav =  new ModelAndView("doctor_form");
							String message = "new doctor registered successfully";
							mav.addObject("message", message);
							
						}
					} catch (Exception e) {
						mav = new ModelAndView("doctor_form");
						String message = "new doctor register failed";
						mav.addObject("message", message);
					}
			}
			return mav;
		}
		
		//delete an existing doctor from the database
		@RequestMapping(value = "/deleteDoctor{docId}", method = RequestMethod.GET)
		public ModelAndView delete(@PathVariable("docId") Integer docId) {
			ModelAndView mav = new ModelAndView("doctors");
			ds.deleteDoctorById(docId);
			List<Doctor> doctorsList = ds.getAllDoctors();
			mav.addObject("doctorsList", doctorsList);
			return mav;
		}
	
		//show edit form
		@RequestMapping(value = "/editDoctor{docId}", method = RequestMethod.GET)
		public ModelAndView edit(@PathVariable("docId") Integer docId) {
			ModelAndView mav = new ModelAndView("doctor_form");
				Doctor doctorToUpdate = ds.getDoctorById(docId);
				mav.addObject("doctor", doctorToUpdate);
			
			return mav;
		}
		
		//register new updated doctor information
		@RequestMapping(value = "/editDoctor", method = RequestMethod.POST)
		public ModelAndView editDoctor(@RequestParam("docId") Integer docId,@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName, @RequestParam("speciality") String speciality,
				@RequestParam("userName")  String userName,@RequestParam("email")  String email,
				@RequestParam("password")  String password,@RequestParam("dateOfBirth")  String dateOfBirth,
				@RequestParam("gender")  String gender,@RequestParam("street")  String street,
				@RequestParam("apt")  String apt,@RequestParam("city")  String city,
				@RequestParam("state")  String state,@RequestParam("zip")  Integer zip,
				@RequestParam("phone")  Long phone) {
			ModelAndView mav = new ModelAndView("doctor_form");
			Doctor doctor = new Doctor();
			doctor.setDocId(docId);
			doctor.setFirstName(firstName);
			doctor.setLastName(lastName);
			doctor.setSpeciality(speciality);
			doctor.setDateOfBirth(dateOfBirth);
			doctor.setGender(gender);
			doctor.setPhone(phone);
			
			User newUser = new User(userName,email,password,true,"DOCTOR");
			Address newAddress = new Address(street,apt,city,state,zip);
			doctor.setAccount(newUser);
			doctor.setAddress(newAddress);
			ds.updateDoctorById(doctor.getDocId(), doctor);
			String message = "Doctor updated successfully";
			mav.addObject("message", message);
			return mav;
		}
}
