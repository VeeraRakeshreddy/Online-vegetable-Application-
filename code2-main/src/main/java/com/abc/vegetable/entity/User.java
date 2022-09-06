package com.abc.vegetable.entity;

import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int userId;
	private String username;
	private String password;
	private String emailId;
	private long mobileNumber;
	private long DebitCardNo;
	private int TotalPurchase;

	private String role;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String userName, String password,long DebitCardNo,int TotalPurchase, String emailId, long mobileNumber,
			String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.DebitCardNo=DebitCardNo;
		this.TotalPurchase=TotalPurchase;
		
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getmobileNumber() {
		return mobileNumber;
	}
	
	public void setmobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getrole() {
		return role;
	}
	public void setrole(String role) {
		this.role = role;
	}
	public long getDebitCardNo() {
		return DebitCardNo;
	}








	public void setDebitCardNo(long DebitCardNo) {
		DebitCardNo = DebitCardNo;
	}








	public int getTotalPurchase() {
		return TotalPurchase;
	}








	public void setTotalPurchase(int TotalPurchase) {
		TotalPurchase = TotalPurchase;
	}


	@Override
	public int hashCode() {
		return Objects.hash(emailId, mobileNumber, password, role,TotalPurchase,DebitCardNo, userId, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(emailId, other.emailId) && mobileNumber == other.mobileNumber
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role)
	&& userId == other.userId
				&& Objects.equals(username, other.username) && Objects.equals(DebitCardNo, other.DebitCardNo)&& Objects.equals(TotalPurchase, other.TotalPurchase );
	}
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}