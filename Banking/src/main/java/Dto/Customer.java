package Dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



@Entity
public class Customer {

		@Id
		@SequenceGenerator(initialValue = 11234586,allocationSize = 1,sequenceName = "custid",name = "custid")
		@GeneratedValue(generator = "custid")
		long custid;
		
		@Column(nullable = false)
		String name;
		
		@Column(nullable = false, unique = true)
		String email;
		
		@Column(nullable = false, unique = true)
		long mob;
		
		@Column(nullable = false)
		Date dob;
		
		@Column(nullable = false)
		String gender;
		
		@Column()
		String pwd;

		@OneToMany
		List<BankAccount> list;
		

		public List<BankAccount> getList() {
			return list;
		}

		public void setList(List<BankAccount> list) {
			this.list = list;
		}

		public long getCustid() {
			return custid;
		}

		public void setCustid(long custid) {
			this.custid = custid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public long getMob() {
			return mob;
		}

		public void setMob(long mob) {
			this.mob = mob;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}

		
		
		
}
