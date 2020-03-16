package com.hiber.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hiber.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory SessionFactory;
	
	@Override
	public Optional<List<Employee>> getAllemp() {
	
		return Optional.of(SessionFactory.getCurrentSession().createQuery("from Employee",Employee.class).getResultList());
	}

	@Override
	public Optional<Employee> getempById(Long eid) {
		//return Optional.of(SessionFactory.getCurrentSession().get(Employee.class, eid));
		System.out.println("emp id: "+eid);
		Session session=SessionFactory.getCurrentSession();
		Employee emp=session.get(Employee.class, eid);
		return Optional.of(emp);
		
		
		
	}

}
