package entity;

public class ReaderType {
	private int id;
	private String typename;
	private int maxborrownum;
	private int limit;
	 
	@Override
	public String toString(){
		return "User[id="+id+",typename="+typename+","
				+ "maxborrownum="+maxborrownum+",limit="+limit+"]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public int getMaxborrownum() {
		return maxborrownum;
	}

	public void setMaxborrownum(int maxborrownum) {
		this.maxborrownum = maxborrownum;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}
