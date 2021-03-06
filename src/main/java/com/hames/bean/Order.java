package com.hames.bean;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.hames.enums.OrderType;

public class Order extends Audit{

	@Id
	private String orderId;
	private String partyId;
	private DateTime deliveryDate;
	private DateTime orderDate;
	private OrderType orderType;
	
	private Payment payment; 
	
	@Transient
	private Party party;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public DateTime getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(DateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public DateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(DateTime orderDate) {
		this.orderDate = orderDate;
	}
	public OrderType getOrderType() {
		return orderType;
	}
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Party getParty() {
		return party;
	}
	public void setParty(Party party) {
		this.party = party;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", partyId=" + partyId
				+ ", deliveryDate=" + deliveryDate + ", orderDate=" + orderDate
				+ ", orderType=" + orderType + ", payment=" + payment + "]";
	}
	
}
