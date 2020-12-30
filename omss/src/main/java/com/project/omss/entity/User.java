package com.project.omss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
	@Id
	@Column(name="userId")
	private int userId;
	@Column(name="firstName")
	private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="password")
    private String password;
    @Column(name="mailId")
    private String mailId;
    @Column(name="mobileNo")
    private Long mobileNo;
    @Column(name="address")
	private String address;
	public User() {
		super();
	}
	public User(int userId, String firstName, String lastName, String password, String mailId, Long mobileNo,
			String address) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.mailId = mailId;
		this.mobileNo = mobileNo;
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", mailId=" + mailId + ", mobileNo=" + mobileNo + ", address=" + address + "]";
	}
	
    
    
}
