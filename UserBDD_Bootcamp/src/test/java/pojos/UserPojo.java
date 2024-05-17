package pojos;

public class UserPojo {
	
	private String firstname;
	private String lastname;
	private String contactnumber;
	private String emailid;
	private int userId;
	private Address address;
	
	public UserPojo() {
		
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "UserPojo [firstname=" + firstname + ", lastname=" + lastname + ", contactnumber=" + contactnumber
				+ ", emailid=" + emailid + ", userId=" + userId + ", address=" + address + "]";
	}
	
	
	

}
