package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.BankAccount;

public class BankDao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public void save(BankAccount bankAccount) {
		entityTransaction.begin();
		entityManager.persist(bankAccount);
		entityTransaction.commit();
	}
	
	public  List<BankAccount> fetch_all_Bank_details() {
		List<BankAccount> list=entityManager.createQuery("select x from BankAccount x").getResultList();
		return list;
		
	}
	
	public BankAccount fetch_By_Accno(long acno) {
		
		BankAccount bankAccount=entityManager.find(BankAccount.class, acno);
		return bankAccount;
	}
	
	public void update(BankAccount bankAccount) {
		entityTransaction.begin();
		entityManager.merge(bankAccount);
		entityTransaction.commit();
	}
	
	
}
