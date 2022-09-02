package com.book.pojo;

public class Customer {
	
    private Integer custId;
    private String fname;
    private String lname;
    private String caddress;
    private String contact;
    private String email;
    private String password;
	
    
    public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(Integer custId, String fname, String lname, String caddress, String contact, String email,
			String password) {
		super();
		this.custId = custId;
		this.fname = fname;
		this.lname = lname;
		this.caddress = caddress;
		this.contact = contact;
		this.email = email;
		this.password = password;
	}


	@Override
	public String toString() {
		return "\nCustomer=> \ncustId=" + custId + "\nFname=" + fname + "\nLname=" + lname + "\nAddress=" + caddress
				+ "\nContact=" + contact + "\nEmail=" + email + "\nPassword=" + password;
	}


	public Integer getCustId() {
		return custId;
	}


	public void setCustId(Integer custId) {
		this.custId = custId;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getCaddress() {
		return caddress;
	}


	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
    
   
    
	

 }
