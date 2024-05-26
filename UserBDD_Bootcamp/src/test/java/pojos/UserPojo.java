package pojos;



//@JsonIgnoreProperties(ignoreUnknown=true)
public class UserPojo {
	
	private String user_first_name;
	private String user_last_name;
	private Integer user_contact_number;
	private String user_email_id;
	private Integer user_id;
	private String creation_time;
	private String last_mod_time;
	private Address userAddress;
	
	public String getCreation_time() {
		return creation_time;
	}
	public void setCreation_time(String creation_time) {
		this.creation_time = creation_time;
	}
	public String getLast_mod_time() {
		return last_mod_time;
	}
	public void setLast_mod_time(String last_mod_time) {
		this.last_mod_time = last_mod_time;
	}
	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	public Integer getUser_contact_number() {
		return user_contact_number;
	}
	public void setUser_contact_number(Integer user_contact_number) {
		this.user_contact_number = user_contact_number;
	}
	public String getUser_email_id() {
		return user_email_id;
	}
	public void setUser_email_id(String user_email_id) {
		this.user_email_id = user_email_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "UserPojo [user_first_name=" + user_first_name + ", user_last_name=" + user_last_name
				+ ", user_contact_number=" + user_contact_number + ", user_email_id=" + user_email_id + ", user_id="
				+ user_id + ", address=" + userAddress + "]";
	}
	
	
	
	
	

	
	

}
