package com.mkyong.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mkyong.common.model.Employee;
import com.mkyong.common.model.Shop;

@Controller
@RequestMapping("/kfc/brands")
public class EmployeeController {

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public @ResponseBody Shop getShopInJSON(@PathVariable String name) {

		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[] { "mkyong1", "mkyong2" });
		return shop;

	}

	// Map to store details of employees
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

	@RequestMapping(value = EmpUriConstants.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployee() {

		Employee emp = new Employee();
		emp.setEmpName("Varnika");
		emp.setEmpId(1);
		emp.setEmpSkill("Java");
		empData.put(1, emp);
		return emp;
	}

	@RequestMapping(value = EmpUriConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {

		return empData.get(empId);

	}

	@RequestMapping(value = EmpUriConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees() {

		List<Employee> emps = new ArrayList<Employee>();
		Set<Integer> empIdKeys = empData.keySet();
		for (Integer i : empIdKeys) {
			emps.add(empData.get(i));
		}
		return emps;
	}

	@RequestMapping(value = EmpUriConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {

		empData.put(emp.getEmpId(), emp);
		return emp;
	}

	@RequestMapping(value = EmpUriConstants.DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {

		Employee emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}

}