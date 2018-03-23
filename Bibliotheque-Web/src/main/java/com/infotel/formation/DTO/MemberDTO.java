package com.infotel.formation.DTO;

import java.io.Serializable;

public class MemberDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long member_id;
	private String member_lastname;
	private String member_firstname;
	private String member_email;
	private String member_address;
	private String member_password;
	private boolean isMemberAdmin;

	private long member_LibraryId;

	private String library_name;

	public MemberDTO() {
	}

	public MemberDTO(String member_lastname, String member_firstname, String member_email, String member_address,
			String member_password, boolean isMemberAdmin,String library_name) {
		this.member_lastname = member_lastname;
		this.member_firstname = member_firstname;
		this.member_email = member_email;
		this.member_address = member_address;
		this.member_password = member_password;
		this.isMemberAdmin = isMemberAdmin;
		this.library_name = library_name;
	}

	public long getMember_id() {
		return member_id;
	}

	public String getMember_lastname() {
		return member_lastname;
	}

	public void setMember_lastname(String member_lastname) {
		this.member_lastname = member_lastname;
	}

	public String getMember_firstname() {
		return member_firstname;
	}

	public void setMember_firstname(String member_firstname) {
		this.member_firstname = member_firstname;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_address() {
		return member_address;
	}

	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

	public String getMember_password() {
		return member_password;
	}

	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}

	public long getMember_LibraryId() {
		return member_LibraryId;
	}

	public void setMember_LibraryId(long member_LibraryId) {
		this.member_LibraryId = member_LibraryId;
	}

	public boolean isMemberAdmin() {
		return isMemberAdmin;
	}

	public void setMemberAdmin(boolean isMemberAdmin) {
		this.isMemberAdmin = isMemberAdmin;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}

	public String getLibrary_name() {
		return library_name;
	}

	public void setLibrary_name(String library_name) {
		this.library_name = library_name;
	}

}
