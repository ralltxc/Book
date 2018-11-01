package entity;

public class Reader {
	private String readerid;
	private String name;
	private int type;
	private int age;
	private String sex;
	private String phone;
	private String dept;
	private String regedate;
	
	@Override
	public String toString(){
		return "User[readerid="+readerid+",name="+name+",type="+type+","
				+ "age="+age+",sex="+sex+",phone="+phone+",dept="+dept+","
						+ "regedate="+regedate+"]";
	}

	public String getReaderid() {
		return readerid;
	}

	public void setReaderid(String readerid) {
		this.readerid = readerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getRegedate() {
		return regedate;
	}

	public void setRegedate(String regedate) {
		this.regedate = regedate;
	}
	
	
	
}
