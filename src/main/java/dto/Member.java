package dto;




//bean : Dto, Entity, Vo
public class Member {
	private String username;
	private String userpw;
	private String name;
	private String gender;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getname() {
		return name;
	}
	public void setIrum(String name) {
		this.name = name;

	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
