package jspServlet.vo;

public class Product {
	private String prdname;
	private Long prdprice;
	private String prdclass;
	private String prdimages;
	
	public String getPrdimages() {
		return prdimages;
	}
	public void setPrdimages(String prdimages) {
		this.prdimages = prdimages;
	}
	public String getPrdname() {
		return prdname;
	}
	public void setPrdname(String prdname) {
		this.prdname = prdname;
	}
	public Long getPrdprice() {
		return prdprice;
	}
	public void setPrdprice(Long prdprice) {
		this.prdprice = prdprice;
	}
	public String getPrdclass() {
		return prdclass;
	}
	public void setPrdclass(String prdclass) {
		this.prdclass = prdclass;
	}
	
}
