package com.qa.MapTests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import com.qa.persistence.domain.Members;
import com.qa.persistence.repository.MembersMapRepository;

public class MembersMapsTest{
	
	private MembersMapRepository mmr;
	private Members mem1;
	private Members mem2;
	
	@Before
	public void setup() {
	mmr = new MembersMapRepository();
	mem1 = new Members("Krystal", "Ryan");
	mem2= new Members("Jack", "Ryan");
}

	@Test
	public void addMemberTest() {
		mmr.createMember("{\"memberid\":1,\"firstname\":\"Krystal\",\"lastname\":\"Ryan\"}");
		assertEquals(1, mmr.getmembersMap().size());
		assertEquals("Krystal", mmr.getmembersMap().get(1).getFirstname());
	}	
	
	@Test
	public void add2MembersTest() {
		mmr.createMember("{\"memberid\":1,\"firstname\":\"Krystal\",\"lastname\":\"Ryan\"}");
		mmr.createMember("{\"memberid\":2,\"firstname\":\"Jack\",\"lastname\":\"Ryan\"}");
		assertEquals(2, mmr.getmembersMap().size());
		assertEquals("Jack", mmr.getmembersMap().get(2).getFirstname());
	}

	
	@Test
	public void updateMember() {
		mmr.getmembersMap().put(1, mem1);
		mmr.updateMember(1, "{\"memberid\":1,\"firstname\":\"Jack\",\"lastname\":\"Ryan\"}");
		assertEquals("Jack", mmr.getmembersMap().get(1).getFirstname());
	}
	
	@Ignore
	@Test
	public void updateMemberThatDoesntExist() {
		mmr.getmembersMap().put(1, mem1);
		String b =mmr.updateMember(3, "{\"memberid\":1,\"firstname\":\"John\",\"lastname\":\"Ryan\"}");
		assertEquals("Account failed to update", b);
	}	
	
	
	@Test
	public void removeMemberTest() {

		mmr.getmembersMap().put(1, mem1);

		mmr.deleteMember(1);
		assertEquals(0, mmr.getmembersMap().size());
	}
	
	@Test
	public void remove2MembersTest() {
		mmr.getmembersMap().put(1, mem1);
		mmr.getmembersMap().put(2, mem2);
		mmr.deleteMember(1);
		mmr.deleteMember(2);
		assertEquals(0, mmr.getmembersMap().size());
	}
	
	@Test
	public void remove2MembersAnd1ThatDoesntExistTest() {
		mmr.getmembersMap().put(1, mem1);
		mmr.getmembersMap().put(2, mem2);
		mmr.deleteMember(1);
		mmr.deleteMember(2);
		mmr.deleteMember(3);
		assertEquals(0, mmr.getmembersMap().size());
	}
	
}