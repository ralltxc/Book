package entity;

import java.util.Date;

public class BorrowBook {
	private String readerid;
	private String ISBN;
	private Date borrowdate;
	private Date returndate;
	private int fine;
	
	@Override
	public String toString(){
		return "User[readerid="+readerid+",ISBN="+ISBN+",borrowdate="+borrowdate+","
				+ "returndate="+returndate+",fine="+fine+"]";
	}

	public String getReaderid() {
		return readerid;
	}

	public void setReaderid(String readerid) {
		this.readerid = readerid;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public Date getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}

	public Date getReturndate() {
		return returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}
	
}
