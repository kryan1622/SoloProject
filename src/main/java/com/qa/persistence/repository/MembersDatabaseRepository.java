package com.qa.persistence.repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import com.qa.util.JSONUtil;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import javax.enterprise.inject.Default;
import javax.inject.Inject;


@Transactional(SUPPORTS)
@Default
public class MembersDatabaseRepository implements MembersRepository{

	public String deleteMember(int memberid) {
		return null;
	}


	public String updateMember(int memberid, String Member) {
		return null;
	}

	public String findAccount(int memberid) {
		return null;
	}


	public String getAllMembers() {
		return null;
	}


	public String createMember(String Members) {
		return null;
	}

}
