package utilities;

public enum APIpath {
	
	CreateUserAPI("/createusers"),
	GetallUsersAPI("/users"),
	GetUserbyIdAPI("/user/"),
	GetUserbyNameAPI("/users/username/"),
	UpdateUserbyIdAPI("/updateuser/"),
	DeleteUserbyIdAPI("/deleteuser/"),
	DeleteUserbyNameAPI("/deleteuser/username/");

	private String path;

	APIpath(String path) {
		
		this.path = path;
		
	}
	
	public String getPath() {
		
		return path;
	}
	

}
