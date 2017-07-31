package com.javaex.vo;

public class UserVo {
	private int no;
	private String email;
	private String password;
	private String name;
	private String gender;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserVo() {

	}
	
	
	

	public UserVo(int no, String email, String name, String gender) {
		this.no = no;
		this.email = email;
		this.name = name;
		this.gender = gender;
	}

	public UserVo(String email, String password, String name, String gender) {
		
		this.email = email;
		this.password = password;
		this.name = name;
		this.gender = gender;
	}

	public UserVo(int no, String email, String password, String name, String gender) {

		this.no = no;
		this.email = email;
		this.password = password;
		this.name = name;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "UserVo [no=" + no + ", email=" + email + ", password=" + password + ", name=" + name + ", gender="
				+ gender + "]";
	}
	

}
