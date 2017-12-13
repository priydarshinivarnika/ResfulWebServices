package com.mkyong.common;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.mkyong.common.controller.EmpUriConstants;
import com.mkyong.common.model.Employee;

public class TestSpringRest {
	public static final String SERVER_URI = "http://localhost:8082/SpringMVC/rest/kfc/brands";

	public static void main(String args[]) {

		testGetDummyEmployee();
		System.out.println("*****");
		testCreateEmployee();
		System.out.println("*****");
		// testGetEmployee();
		System.out.println("*****");
		testGetAllEmployee();
	}

	private static void testGetDummyEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject(SERVER_URI + EmpUriConstants.DUMMY_EMP, Employee.class);
		printEmpData(emp);
	}

	private static void testCreateEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = new Employee();
		emp.setEmpId(4);
		emp.setEmpName("Dipesh");
		emp.setEmpSkill("Hadoop");
		Employee response = restTemplate.postForObject(SERVER_URI + EmpUriConstants.CREATE_EMP, emp, Employee.class);
		printEmpData(response);
	}

	private static void testGetEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject(SERVER_URI + "/rest/emp/1", Employee.class);
		printEmpData(emp);
	}

	private static void testGetAllEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI + EmpUriConstants.GET_ALL_EMP, List.class);
		System.out.println(emps.size());
		for (LinkedHashMap map : emps) {
			System.out.println(
					"ID=" + map.get("empId") + ",Name=" + map.get("empName") + ", Skill=" + map.get("empSkill"));
			;
		}
	}

	public static void printEmpData(Employee emp) {
		System.out.println("ID=" + emp.getEmpId() + ",Name=" + emp.getEmpName() + ", Skill=" + emp.getEmpSkill());
	}

}
