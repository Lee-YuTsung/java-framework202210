package Dao.Member;

import java.util.List;

import Model.Member;

public interface MemberDao {
	//c
	void add(Member m);
	
	//r
	List<Member> queryAll();
	Member queryMember(String userName, String password);
	Member queryMember(int id);
	boolean queryUser(String userName);
	
	//u
	void update(Member m);
	
	//d
	void delete(int id);
}
