package com.abc.vegetable.dto;

import java.util.Objects;

public class VegetableAdminResponseDTOClient 
{
	private int vegetableId;
	private String userName;
	private String phoneNumber;
	private String userAddress;
	private String emailId;
	private String vegetableName;
	private boolean vegetablestatus;	
	private int vegetableAmount;
	public VegetableAdminResponseDTOClient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VegetableAdminResponseDTOClient(int vegetableId, String userName, String phoneNumber, String userAddress,
			String emailId, String vegetableName, boolean vegetablestatus, int vegetableAmount) {
		super();
		this.vegetableId = vegetableId;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.userAddress = userAddress;
		this.emailId = emailId;
		this.vegetableName =vegetableName;
		this.vegetablestatus = vegetablestatus;
		this.vegetableAmount = vegetableAmount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(emailId, phoneNumber,vegetableAmount,vegetableId, vegetableName, vegetablestatus, userAddress, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VegetableAdminResponseDTOClient other = (VegetableAdminResponseDTOClient) obj;
		return Objects.equals(emailId, other.emailId) && Objects.equals(phoneNumber, other.phoneNumber)
				&& vegetableAmount == other.vegetableAmount && vegetableId == other.vegetableId
				&& Objects.equals(vegetableName, other.vegetableName) && vegetablestatus == other.vegetablestatus
				&& Objects.equals(userAddress, other.userAddress) && Objects.equals(userName, other.userName);
	}
	
}
