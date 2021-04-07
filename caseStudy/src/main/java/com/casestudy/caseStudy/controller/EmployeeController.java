package com.casestudy.caseStudy.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

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
import com.casestudy.caseStudy.entityModels.Employee;
import com.casestudy.caseStudy.entityModels.User;
import com.casestudy.caseStudy.services.AddressServiceImp;
import com.casestudy.caseStudy.services.EmployeeService;
import com.casestudy.caseStudy.services.EmployeeServiceImp;
import com.casestudy.caseStudy.services.UserServiceImp;


@Controller
public class EmployeeController {
	

	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	@Autowired
	EmployeeServiceImp es;
	@Autowired
	UserServiceImp us;
	@Autowired
	AddressServiceImp as;
	
	//display Employees on employees page
		@RequestMapping("/employees")
		public ModelAndView showEmployeesList() {
			ModelAndView mav = new ModelAndView("employees");
			List<Employee> employeesList = es.getAllEmployees();
			mav.addObject("employeesList", employeesList);
			return mav;
		}
		//display new Employee form
		@GetMapping("/newEmployee")
		public ModelAndView showEmployeeForm() {
			ModelAndView mav = new ModelAndView("employee_form");
			return mav;
		}
		//insert new Employee to the database 
		@PostMapping("/addEmployee")
		public @ResponseBody ModelAndView createDoctor(@Valid Employee employee,
				@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName, @RequestParam("occupation") String occupation,
				@RequestParam("userName")  String userName,@RequestParam("email")  String email,
				@RequestParam("password")  String password,@RequestParam("dateOfBirth")  String dateOfBirth,
				@RequestParam("gender")  String gender,@RequestParam("street")  String street,
				@RequestParam("apt")  String apt,@RequestParam("city")  String city,
				@RequestParam("state")  String state,@RequestParam("zip")  Integer zip,
				@RequestParam("phone")  Long phone,final @RequestParam("file") MultipartFile file) {
			    ModelAndView mav = new ModelAndView("employee_form");
			try {
				HttpHeaders headers = new HttpHeaders();
				if (employee == null) {
					mav =  new ModelAndView("employee_form");
					String message = "add employee failed";
					mav.addObject("message", message);
					
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

				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setOccupation(occupation);
				employee.setDateOfBirth(dateOfBirth);
				employee.setGender(gender);
				employee.setPhone(phone);
				employee.setFileName(fileName);
				employee.setFilePath(filePath);
				employee.setFileType(fileType);
				employee.setFileSize(fileSize);
				
				User newUser = new User(userName,email,password,true,"EMPLOYEE");
				Address newAddress = new Address(street,apt,city,state,zip);
				as.addNewAddress(newAddress);
				us.addNewUser(newUser);
				
				employee.setAccount(newUser);
				employee.setAddress(newAddress);
				boolean status = es.addNewEmployee(employee);
				if (status) {
					
					headers.add("Employe Saved With Image - ", fileName);
					mav =  new ModelAndView("employee_form");
					String message = "new employee registered successfully";
					mav.addObject("message", message);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				mav = new ModelAndView("employee_form");
				String message = "new employee register failed";
				mav.addObject("message", message);
			}
			return mav;
		}
		
		//delete an existing employee from the database
		@RequestMapping(value = "/deleteEmployee{empId}", method = RequestMethod.GET)
		public ModelAndView delete(@PathVariable("empId") Integer empId) {
			ModelAndView mav = new ModelAndView("employees");
			es.deleteEmployeeById(empId);
			List<Employee> employeesList = es.getAllEmployees();
			mav.addObject("employeesList", employeesList);
			return mav;
		}
	
		//show edit form
		@RequestMapping(value = "/editEmployee{empId}", method = RequestMethod.GET)
		public ModelAndView edit(@PathVariable("empId") Integer empId) {
			ModelAndView mav = new ModelAndView("employee_form");
				try {
					Employee employeeToUpdate = es.getEmployeeById(empId);
					mav.addObject("employee", employeeToUpdate);
				}catch(Exception e) {
					System.out.print("emplyee not found");
				}
			
			return mav;
		}
		
		//register new updated employee information
		@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
		public ModelAndView editDoctor(@RequestParam("empId") Integer empId, @RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName, @RequestParam("occupation") String occupation,
				@RequestParam("userName")  String userName,@RequestParam("email")  String email,
				@RequestParam("password")  String password,@RequestParam("dateOfBirth")  String dateOfBirth,
				@RequestParam("gender")  String gender,@RequestParam("street")  String street,
				@RequestParam("apt")  String apt,@RequestParam("city")  String city,
				@RequestParam("state")  String state,@RequestParam("zip")  Integer zip,
				@RequestParam("phone")  Long phone) {
			ModelAndView mav = new ModelAndView("employee_form");
			try {
				Employee employee = new Employee();
				employee.setEmpId(empId);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setOccupation(occupation);
				employee.setDateOfBirth(dateOfBirth);
				employee.setGender(gender);
				employee.setPhone(phone);
				
				User newUser = new User(userName,email,password,true,"EMPLOYEE");
				Address newAddress = new Address(street,apt,city,state,zip);
				employee.setAccount(newUser);
				employee.setAddress(newAddress);
				es.updateEmployeeById(employee.getEmpId(), employee);
				String message = "employee updated successfully";
				mav.addObject("message", message);
			}catch(Exception e) {
				System.out.print("emplyee not found");
				String message = "employee updated failed";
				mav.addObject("message", message);
			}
			return mav;
		}

}
