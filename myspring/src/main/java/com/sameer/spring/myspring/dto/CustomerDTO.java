package com.sameer.spring.myspring.dto;

public class CustomerDTO {

	private int cid ;
	private String cname ;
	private String email ;
	private long phone ;
	private String city ;
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDTO(int cid, String cname, String email, long phone, String city) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.phone = phone;
		this.city = city;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "CustomerDTO [cid=" + cid + ", cname=" + cname + ", email=" + email + ", phone=" + phone + ", city="
				+ city + "]";
	}
	
}
