package Dao.Member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Dao.DbConnection;
import Model.Member;

public class MemberDaoImpl implements MemberDao{
	//test
	public static void main(String[] args) {
		
		//Member m = new Member("mary", "mmm", "sss", "台南", "222", "333");
		//new MemberDaoImpl().add(m);
		
		/*List<Member> l = new MemberDaoImpl().queryAll();
		for(Member m : l) {
			System.out.println(m.getId() + "\t" + m.getName());
		}*/
		
		Member m = new MemberDaoImpl().queryMember("mmm", "sss");
		System.out.println(m.getName());
		
		//System.out.println(new MemberDaoImpl().queryUser("mmm"));
		
		//System.out.println(new MemberDaoImpl().queryMember(4));
		
		/*Member m = new MemberDaoImpl().queryMember(3);
		m.setName("Tom");
		m.setMobile("123");
		new MemberDaoImpl().update(m);
		System.out.println(new MemberDaoImpl().queryMember(3).getName());*/
		
		//new MemberDaoImpl().delete(1);
		//System.out.println(new MemberDaoImpl().queryMember(1));
	}

	//c
	@Override
	public void add(Member m) {
		EntityManager em = DbConnection.getDb();
		em.getTransaction().begin();//使用交易模式.開啟
		em.persist(m);//新增
		em.getTransaction().commit();//結束
		em.close();//關閉
	}
	
	//r
	@Override
	public List<Member> queryAll() {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select m from Member m";
		/* JPQL與SQL不一樣
		 * SQL  : select * from table
		 * JPQL : select o from class o(alias)
		 * 其class需@Entity@Table(name="table_name")作為指標
		 */
		Query q = em.createQuery(JPQL);//查詢，回傳類型javax.persistence.Query
		List<Member> l = q.getResultList();//Query轉型List
		return l;
	}
	@Override
	public Member queryMember(String userName, String password) {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select m from Member m where username=?1 and password=?2";
		//String JPQL = "select m from Member m where m.userName=?1 and m.password=?2";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, userName);
		q.setParameter(2, password);
		List<Member> l = q.getResultList();
		Member[] m = l.toArray(new Member[l.size()]);
		if(m.length != 0) {
			return m[0];
		}else {
			return null;
		}
	}
	@Override
	public Member queryMember(int id) {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select m from Member m where m.id=?1";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, id);
		List<Member> l = q.getResultList();
		Member[] m = l.toArray(new Member[l.size()]);
		return m.length != 0 ? m[0] : null;
	}
	@Override
	public boolean queryUser(String userName) {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select m from Member m where m.userName=?1";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, userName);
		List<Member> l = q.getResultList();
		boolean b = l.size() != 0 ? true : false;
		return b;
	}
	
	//u
	@Override
	public void update(Member m) {
		EntityManager em = DbConnection.getDb();
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		em.close();
	}
	
	//d
	@Override
	public void delete(int id) {
		EntityManager em = DbConnection.getDb();
		Member m = em.find(Member.class, id);
		em.getTransaction().begin();
		em.remove(m);
		em.getTransaction().commit();
		em.close();
	}

}
