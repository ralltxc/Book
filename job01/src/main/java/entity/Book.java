package entity;

/**
 * 实体类:
 *   用于存放从数据库中查询出来的记录中的信息。
 *   该类与数据库中的表的结构要保存一致。
 *   
 */
public class Book {
	private String isbn;
	private int typeid;
	private String bookname;
	private String author;
	private String publish;
	private String publishdate;
	private int publishtime;
	private double unitprice;
	
	
	
	@Override
	public String toString() {
		return "User [isbn=" + isbn + ", typeid=" + typeid + ", bookname=" + bookname + ", author=" + author
				+ ", publish=" + publish + ", publishdate=" + publishdate + ", publishtime=" + publishtime
				+ ", unitprice=" + unitprice + "]";
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	public int getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(int publishtime) {
		this.publishtime = publishtime;
	}
	public double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	

	
}

