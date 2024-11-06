package in.quastech.bean;

public class Employees {
	private int Empid;
	private String Empname;
	private double Empsalary;
	private String department;
	private String location;
	public int getEmpid() {
		return Empid;
	}
	public void setEmpid(int empid) {
		Empid = empid;
	}
	public String getEmpname() {
		return Empname;
	}
	public void setEmpname(String empname) {
		Empname = empname;
	}
	public double getEmpsalary() {
		return Empsalary;
	}
	public void setEmpsalary(double empsalary) {
		Empsalary = empsalary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void display() {
		System.out.println("Id:"+Empid);
		System.out.println("Name:"+Empname);
		System.out.println("Salary:"+Empsalary);
		System.out.println("Department:"+department);
		System.out.println("Location:"+location);
	}
}
