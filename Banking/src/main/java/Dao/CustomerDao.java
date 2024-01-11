package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.sql.Select;

import Dto.Customer;
 

public class CustomerDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void save(Customer customer) {
	entityTransaction.begin();
	entityManager.persist(customer);
	entityTransaction.commit();
	}
	
	public List<Customer>  fetch(long mob) {
		 List<Customer> list=entityManager.createQuery("select x from Customer x where mob=?1").setParameter(1, mob).getResultList();
		return list;
	}
	
	public List<Customer>  fetch(String email) {
		 List<Customer> list=entityManager.createQuery("select x from Customer x where email=?1").setParameter(1, email).getResultList();
		return list;
	}
	public Customer findById(long id) {
		Customer customer=entityManager.find(Customer.class, id);
		return customer;
	}

	public void update(Customer customer) {
		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
		
	}
	
}
