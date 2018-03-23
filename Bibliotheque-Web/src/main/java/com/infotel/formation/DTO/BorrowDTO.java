package com.infotel.formation.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BorrowDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long borrow_id;
	private String borrow_date;
	private String return_date;
	private boolean isValidated;

	private String member_firstname;
	private String member_lastname;

	private long borrow_memberId;

	private List<Long> borrow_listCopyId;

	public BorrowDTO() {
	}

	public BorrowDTO(long borrow_id, String borrow_date, String return_date, boolean isValidated,
			String member_firstname, String member_lastname, long borrow_memberId) {
		super();
		this.borrow_id = borrow_id;
		this.borrow_date = borrow_date;
		this.return_date = return_date;
		this.isValidated = isValidated;
		this.member_firstname = member_firstname;
		this.member_lastname = member_lastname;
		this.borrow_memberId = borrow_memberId;
		borrow_listCopyId = new ArrayList<Long>();
	}

	public String getMember_firstname() {
		return member_firstname;
	}

	public void setMember_firstname(String member_firstname) {
		this.member_firstname = member_firstname;
	}

	public String getMember_lastname() {
		return member_lastname;
	}

	public void setMember_lastname(String member_lastname) {
		this.member_lastname = member_lastname;
	}

	public long getBorrow_id() {
		return borrow_id;
	}

	public void setBorrow_id(long borrow_id) {
		this.borrow_id = borrow_id;
	}

	public String getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}

	public long getBorrow_memberId() {
		return borrow_memberId;
	}

	public void setBorrow_memberId(long borrow_memberId) {
		this.borrow_memberId = borrow_memberId;
	}

	public List<Long> getBorrow_listCopyId() {
		return borrow_listCopyId;
	}

	public void setBorrow_listCopyId(List<Long> borrow_listCopyId) {
		this.borrow_listCopyId = borrow_listCopyId;
	}

}
