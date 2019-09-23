package jspServlet.vo;

public class ShoppingCart {
	private String sc_id;
	private String cs_id;
	private String me_name;
	private int me_price;
	private int me_number;
	private int sum_price;
	public int getMe_price() {
		return me_price;
	}
	public void setMe_price(int me_price) {
		this.me_price = me_price;
	}
	public String getMe_name() {
		return me_name;
	}
	public void setMe_name(String me_name) {
		this.me_name = me_name;
	}
	public String getCs_id() {
		return cs_id;
	}
	public void setCs_id(String cs_id) {
		this.cs_id = cs_id;
	}
	public String getSc_id() {
		return sc_id;
	}
	public void setSc_id(String sc_id) {
		this.sc_id = sc_id;
	}
	public int getMe_number() {
		return me_number;
	}
	public void setMe_number(int me_number) {
		this.me_number = me_number;
	}
	public float getSum_price() {
		return sum_price;
	}
	public void setSum_price(int sum_price) {
		this.sum_price = sum_price;
	}
}
