package com.abc.vegetable.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
public class OrderTransactions {
	
	
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name = "orderId")
		private int orderId;
	
		@Column(nullable = false)
		private int vegetableId;
		
		@Column(nullable = false)
		private int customerId;
		@UpdateTimestamp
		@Column(nullable = false)
		private LocalDate orderDate;
		
		@Column(name="amount",nullable = false)
		private int orderAmount;
		
		@ManyToOne
		public VegetableAccount VegetableAccount;
		

		public OrderTransactions() {
			super();
			// TODO Auto-generated constructor stub
		}

		public OrderTransactions(int pId, VegetableAccount VegetableAccountegetableAccount,int customerId, LocalDate orderDate, int orderAmount) {
			super();
			this.vegetableId = pId;
			this.customerId = customerId;
			this.orderDate = orderDate;
			this.orderAmount = orderAmount;
			VegetableAccount= VegetableAccount;
		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public VegetableAccount getVegetableAccount() {
			return VegetableAccount;
		}

		public void setVegetableAccount(VegetableAccount VegetableAccount) {
			this.VegetableAccount = VegetableAccount;
		}

		public int getpId() {
			return vegetableId;
		}

		public void setpId(int pId) {
			this.vegetableId = pId;
		}

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public LocalDate getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}

		public int getOrderAmount() {
			return orderAmount;
		}

		public void setOrderAmount(int orderAmount) {
			this.orderAmount = orderAmount;
		}

		@Override
		public int hashCode() {
			return Objects.hash(VegetableAccount, customerId, orderAmount, orderDate, orderId, vegetableId);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OrderTransactions other = (OrderTransactions) obj;
			return Objects.equals(VegetableAccount, other.VegetableAccount) && customerId == other.customerId
					&& orderAmount == other.orderAmount && Objects.equals(orderDate, other.orderDate)
					&& orderId == other.orderId && vegetableId == other.vegetableId;
		}

		@Override
		public String toString() {
			return "OrderTransactions [orderId=" + orderId + ", vegetableId=" + vegetableId + ", customerId="
					+ customerId + ", orderDate=" + orderDate + ", orderAmount=" + orderAmount + ", VegetableAccount="
					+ VegetableAccount + "]";
		}
		
		
		
		
}
