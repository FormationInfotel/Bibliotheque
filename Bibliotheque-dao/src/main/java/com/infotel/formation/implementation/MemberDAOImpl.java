package com.infotel.formation.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Member;
import com.infotel.formation.interfaces.MemberDAO;

@Repository
@Transactional
public class MemberDAOImpl extends _GenericDAOImpl<Member> implements MemberDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertMember(Member member) {
		sessionFactory.getCurrentSession().save(member);
	}

	@Override
	public Member getMemberById(int memberId) {
		Member memberById = null;

		for (Member member : getMembers()) {
			if (member != null && member.getMember_id() > 0) {
				memberById = member;
				break;
			}
		}

		if (memberById == null) {
			throw new IllegalArgumentException("No member found with the id : " + memberId);
		}
		return memberById;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Member getMember(String memberFirstName, String memberLastName) {
		Query<Member> query = sessionFactory.getCurrentSession().createQuery(
				"from Member where member_firstname = :memberFirstName AND member_lastname = :memberLastName");
		query.setParameter("firstName", memberFirstName);
		query.setParameter("lastName", memberLastName);
		return (Member) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> getMembers() {
		List<Member> result = (List<Member>) sessionFactory.getCurrentSession().createQuery("from Member").list();
		return result;
	}

	@Override
	public Member getUserByMail(String memberMail) {
		@SuppressWarnings("unchecked")
		Query<Member> query = sessionFactory.getCurrentSession()
				.createQuery("from Member where member_email = :memberMail");
		query.setParameter("memberMail", memberMail);
		return (Member) query.list().get(0);
	}

	@Override
	public boolean isMailAlreadyExist(String memberMail) {
		@SuppressWarnings("unchecked")
		Query<Member> query = sessionFactory.getCurrentSession()
				.createQuery("from Member where member_email = :memberMail");
		query.setParameter("memberMail", memberMail);

		if (query.list() != null) {
			return true;
		} else
			return false;

	}

	@Override
	public boolean isAccountExist(Member member) {
		Query<Member> query = sessionFactory.getCurrentSession()
				.createQuery("from Member where member_email = :email AND member_password = :pw");
		query.setParameter("email", member.getMember_email());
		query.setParameter("pw", member.getMember_password());

		if (query.list() != null) {
			return true;
		} else
			return false;
	}

}