package com.coderhouse.entidades;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="Clients")
public class Cliente {
	@Id
	@Column(name="dni")
	private Integer dni;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="clientAddress")
	private String clientAddress;
	@Column(name="clientPhone")
	private Integer clientPhone;
	@Column(name="clientEmail")
	private String clientEmail;

//	@ManyToOne
//	@JoinColumn(name="SKU")
//	private Producto product;
//	private Integer idProduct;

	@ManyToMany
	@JoinTable(name="Sales"
			,joinColumns = @JoinColumn(name="user_id")
			,inverseJoinColumns = @JoinColumn(name="product_id")
	)
	private Set<Producto> product;

	public Set<Producto> getProduct() {
		return product;
	}

	public void setProduct(Set<Producto> product) {
		this.product = product;
	}

	public Cliente() {
	}
	
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public Integer getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(Integer clientPhone) {
		this.clientPhone = clientPhone;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	@Override
	public int hashCode() {
		return Objects.hash(clientEmail);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(clientEmail, other.clientEmail);
	}
	
	
	
}
