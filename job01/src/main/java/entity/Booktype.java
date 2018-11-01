package entity;

public class Booktype {
	private Integer typeid;
	private String typename;
	
	@Override
	public String toString(){
		return "User[typeid="+typeid+",typename="+typename+"]";
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}
	
}
