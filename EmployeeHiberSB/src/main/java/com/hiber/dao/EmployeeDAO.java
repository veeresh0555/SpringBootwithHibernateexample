package com.hiber.dao;

import java.util.List;
import java.util.Optional;

import com.hiber.model.Employee;

public interface EmployeeDAO {

	Optional<List<Employee>> getAllemp();

	Optional<Employee> getempById(Long eid);

}
