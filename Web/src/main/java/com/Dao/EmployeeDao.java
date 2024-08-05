package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Model.Employee;

public class EmployeeDao {
	
	public void addEmp(Employee e,Session s) {
		Transaction t = s.beginTransaction();
		s.save(e);
		t.commit();

	}
	
	public void updateEmp(Employee e,Session s) {
		String hql = "update Employee set name=:n,salary=:s where id=:i";
		
		Query<Employee> q = s.createQuery(hql);
		q.setParameter("i", e.getId());
		q.setParameter("n", e.getName());
		q.setParameter("s", e.getSalary());
		Transaction t = s.beginTransaction();
		q.executeUpdate();
		t.commit();
		t.begin();
		
	}
	
	public void deleteEmp(Employee e,Session s) {
		String hql = "delete from Employee where id=:i";
		
		Query<Employee> q = s.createQuery(hql);
		q.setParameter("i", e.getId());
		Transaction t = s.beginTransaction();
		q.executeUpdate();
		t.commit();
	}
	
	public List<Employee> readAll(Session s,int count){
		Criteria cr = s.createCriteria(Employee.class);
		cr.setFirstResult(count);
		cr.setMaxResults(4);
		List<Employee> l =  cr.list();
		return l;
		
	}
	

}
