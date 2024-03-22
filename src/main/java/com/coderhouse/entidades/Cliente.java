package com.coderhouse.entidades;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
