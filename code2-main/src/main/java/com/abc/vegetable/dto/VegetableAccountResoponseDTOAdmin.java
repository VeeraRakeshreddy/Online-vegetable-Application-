package com.abc.vegetable.dto;

import java.util.Objects;

public class VegetableAccountResoponseDTOAdmin 
{
	private int vegetableId;
	private String vegetableName;
	private int vegetableAmount;
	private boolean vegetableStatus;
	private String userName;
	private String MobileNumber;
	private String emailId;
	public String location;
	public VegetableAccountResoponseDTOAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VegetableAccountResoponseDTOAdmin(int pizzaId, String pizzaName, int pizzaAmount, boolean pizzaStatus,
			String userName, String mobileNumber, String emailId, String location) {
		super();
		this.vegetableId = pizzaId;
		this.vegetableName = pizzaName;
		this.vegetableAmount = pizzaAmount;
		this.vegetableStatus = pizzaStatus;
		this.userName = userName;
		MobileNumber = mobileNumber;
		this.emailId = emailId;
		this.location = location;
	}
	public int getPizzaId() {
		return vegetableId;
	}
	public void setvegetableId(int vegetableId) {
		this.vegetableId = vegetableId;
	}
	public String getvegetableName() {
		return vegetableName;
	}
	public void setvegetableName(String vegetableName) {
		this.vegetableName = vegetableName;
	}
	public int getvegetableAmount() {
		return vegetableAmount;
	}
	public void setPizzaAmount(int vegetableAmount) {
		this.vegetableAmount = vegetableAmount;
	}
	public boolean isvegetableStatus() {
		return vegetableStatus;
	}
	public void setvegetableStatus(boolean vegetableStatus) {
		this.vegetableStatus = vegetableStatus;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public int hashCode() {
		return Objects.hash(MobileNumber, emailId, location, vegetableAmount, vegetableId, vegetableName, vegetableStatus, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VegetableAccountResoponseDTOAdmin other = (VegetableAccountResoponseDTOAdmin) obj;
		return Objects.equals(MobileNumber, other.MobileNumber) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(location, other.location) && vegetableAmount == other.vegetableAmount
				&& vegetableId == other.vegetableId && Objects.equals(vegetableName, other.vegetableName)
				&& vegetableStatus == other.vegetableStatus && Objects.equals(userName, other.userName);
	}
	
	
}
