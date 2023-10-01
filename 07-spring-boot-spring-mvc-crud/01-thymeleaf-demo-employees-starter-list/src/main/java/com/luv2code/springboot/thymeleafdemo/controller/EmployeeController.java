package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	// @Autowired is optional since we only have one constructor
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd (Model theModel) {
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		// save the employee
		employeeService.save(theEmployee);

		// An example of post redirect get pattern
		// use a redirect to prevent duplicate submission
		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {

		// get the employee from the service
		Employee employee = employeeService.findById(theId);

		// set employee in the model to prepopulate the form
		model.addAttribute(employee);

		// send over to our form

		return "employees/employee-form";
	}

	@GetMapping("/delete")
	public String saveEmployee(@RequestParam("employeeId") int theId) {
		// delete the employee
		employeeService.deleteById(theId);

		// redirect to the /employees/list
		return "redirect:/employees/list";
	}
}









