package utilities;

public enum APIpath {
	
	CreateUserAPI("/createusers"),
	GetallUsersAPI("/users"),
	GetUserbyIdAPI("/user/{{userId}}"),
	GetUserbyNameAPI("/users/username/{{firstname}}"),
	UpdateUserbyIdAPI("/updateuser/{{userId}}"),
	DeleteUserbyIdAPI("/deleteuser/{{userId}}"),
	DeleteUserbyNameAPI("/deleteuser/username/{{firstname}}");

	private String path;

	APIpath(String path) {
		
		this.path = path;
		
	}
	
	public String getPath() {
		
		return path;
	}
	

}
