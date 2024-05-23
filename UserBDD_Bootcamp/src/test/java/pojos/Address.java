package pojos;

public class Address {
	
	private String plotnumber;
	private String street;
	private String state;
	private String country;
	private Integer zipcode;
	private int addressId;
	
	
	public String getPlotnumber() {
		return plotnumber;
	}
	public void setPlotnumber(String plotnumber) {
		this.plotnumber = plotnumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

}
