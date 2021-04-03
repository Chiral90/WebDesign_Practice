package member;
// Model
//import java.util.Date;
public class MemberBean {
	//private : 캡슐화
	private String id;
	private String pw;
	private String name;
	private String birth;
	//private Date birth;
	private int age;
	private String gender;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	// 결과를 콘솔로 확인
	/*@Override
	public String toString() {
		return "MemberBean [id=" + id + ", pw=" + pw + ", name=" + name + ", birth=" + birth + ", age=" + age
				+ ", gender=" + gender + ", email=" + email + "]";
	}*/
	
	

}
