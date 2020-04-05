
public class Student{
	private String name;
	private String ssn;
	private String userID;
	private String email;
	private static final int id = 1231;
	
	Student(String name, String ssn){
		this.name = name;
		this.ssn = ssn;
		email = name.replaceAll(" ",".") + "@newbieuni.edu";
	}

	public String getName() {
		return name;
	}

	public String getSsn() {
		return ssn;
	}

	public String getUserID() {
		return userID;
	}

	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "Name:"+ name + ",eMail:" + email + ",SSN:" + ssn;
	}
	
	
}

