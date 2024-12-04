package dto;


//Dto, Entity, Bean
public class Member {
	private String username;
	private String userpw;
	private String name;
	private String gender;
	
	public Member(String username, String userpw, String name, String gender) {
		this.username = username;
		this.userpw = userpw;
		this.name = name;
		this.gender = gender;
	}
	


	public void setUsername(String username) {
		this.username = username;
	}
	public void getUsername(){
	 	return username;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getIrum() {
		return irum;
	}
	public void setIrum(String irum) {
		this.irum = irum;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
