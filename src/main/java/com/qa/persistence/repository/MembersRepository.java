package com.qa.persistence.repository;

public interface MembersRepository {
	
	public String deleteMember(int memberid);
	public String updateMember(int memberid, String Member);
	public String findAccount(int memberid);
	public String getAllMembers();
	public String createMember(String Members);
}
