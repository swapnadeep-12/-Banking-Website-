package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.AdminDetails;
import Dto.Customer;

public class AdminDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();

	public void save(AdminDetails adminDetails) {
		entityTransaction.begin();
		entityManager.merge(adminDetails);
		entityTransaction.commit();
	}

	public List<AdminDetails> fetch(String email) {
		 List<AdminDetails> list=entityManager.createQuery("select x from AdminDetails x where email=?1").setParameter(1, email).getResultList();
			return list;
	}
}
