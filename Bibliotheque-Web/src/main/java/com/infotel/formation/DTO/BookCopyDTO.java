package com.infotel.formation.DTO;

public class BookCopyDTO {
	private long copy_id;
	private long ISBN;
	private String copy_title;
	private boolean isBorrowed;

	private long bookcopy_borrowId;

	private long bookcopy_parentId;

	private long bookcopy_bookbasketId;

	public BookCopyDTO(long iSBN, String copy_title, long bookcopy_parentId) {
		ISBN = iSBN;
		this.copy_title = copy_title;
		this.bookcopy_parentId = bookcopy_parentId;
	}

	public BookCopyDTO() {
	}

	public long getCopy_id() {
		return copy_id;
	}

	public void setCopy_id(long copy_id) {
		this.copy_id = copy_id;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public String getCopy_title() {
		return copy_title;
	}

	public void setCopy_title(String copy_title) {
		this.copy_title = copy_title;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	public long getBookcopy_borrowId() {
		return bookcopy_borrowId;
	}

	public void setBookcopy_borrowId(long bookcopy_borrowId) {
		this.bookcopy_borrowId = bookcopy_borrowId;
	}

	public long getBookcopy_parentId() {
		return bookcopy_parentId;
	}

	public void setBookcopy_parentId(long bookcopy_parentId) {
		this.bookcopy_parentId = bookcopy_parentId;
	}

	public long getBookcopy_bookbasketId() {
		return bookcopy_bookbasketId;
	}

	public void setBookcopy_bookbasketId(long bookcopy_bookbasketId) {
		this.bookcopy_bookbasketId = bookcopy_bookbasketId;
	}

}
