package dto;

//Dto, Entity, Bean
public class Member {
	private String username;
	private String userPW;
	private String name;
	private String gender;
	
	public Member(String username, String userPW, String name, String gender) {
		this.username = username;
		this.userPW = userPW;
		this.name = name;
		this.gender = gender;
	}
}
