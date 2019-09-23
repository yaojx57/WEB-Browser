package jspServlet.vo;

public class User {
	private String cs_id;
	private String cs_name;
	private String password;
	private String cs_gender;
	private String cs_phonenumber;
	private String cs_address;
	
	public String getCs_id() {
		return cs_id;
	}
	public void setCs_id(String cs_id) {
		this.cs_id = cs_id;
	}
	public String getCs_name() {
		return cs_name;
	}
	public void setCs_name(String cs_name) {
		this.cs_name = cs_name;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getCs_gender() {
		return cs_gender;
	}
	public void setCs_gender(String cs_gender) {
		this.cs_gender = cs_gender;
	}
	public String getCs_phonenumber() {
		return cs_phonenumber;
	}
	public void setCs_phonenumber(String cs_phonenumber) {
		this.cs_phonenumber = cs_phonenumber;
	}
	public String getCs_address() {
		return cs_address;
	}
	public void setCs_address(String cs_address) {
		this.cs_address = cs_address;
	}
	
}
