package vo;

public class StudentVO {
	private String usn;
	private String fname;
	private String lname;
	private int age;
	private String address;
	private String department;
	
	public StudentVO(String usn, String fname, String lname, int age, String address, String department) {
		super();
		this.usn = usn;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.address = address;
		this.department = department;
	}
	
	

	/*public Student(String fname) {
		super();
		this.fname = fname;
	}*/

	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	@Override
	public String toString() {
		return "Student [usn=" + usn + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", address=" + address
				+ ", department=" + department + "]";
	}
	/*public static void insertStudentToDB() {
		// TODO Auto-generated method stub
		
	}*/
	

}
