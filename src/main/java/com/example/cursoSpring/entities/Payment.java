package com.example.cursoSpring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_payment")
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private Instant moment;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Order order;
	
	public Payment() {
		
	}

	public Payment(Instant moment, Order order) {
		super();
		this.moment = moment;
		this.order = order;
	}
	
	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
