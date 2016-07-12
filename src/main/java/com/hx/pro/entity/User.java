package com.hx.pro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = -7773682657154340743L;
	@Id
	@GeneratedValue(generator="hibernate-uuid")
	@GenericGenerator(name="hibernate-uuid", strategy="uuid")
	private String id;
	private String name_wd;
	private String email;
	private String phone;
	private String pass_wd;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName_wd() {
		return name_wd;
	}
	public void setName_wd(String name_wd) {
		this.name_wd = name_wd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPass_wd() {
		return pass_wd;
	}
	public void setPass_wd(String pass_wd) {
		this.pass_wd = pass_wd;
	}
	
}
