package com.example.cursoSpring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.cursoSpring.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tb_order")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	private Integer orderStatus;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	@ManyToMany
	@JoinColumn(name = "item_id")
	private List<Product> items = new ArrayList<>();
	
	public Order() {
	
	}

	public Order(Object object, Instant moment, OrderStatus orderStatus, User client, Product item) {
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.setClient(client);
		items.add(item);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Instant getInstant() {
		return moment;
	}

	public void setInstant(Instant instant) {
		this.moment = instant;
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}
	
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus.getCode();
	}
	
	public User getClient() {
		return client;
	}
	
	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, moment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return id == other.id && Objects.equals(moment, other.moment);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", instant=" + moment + "]";
	}


	
}