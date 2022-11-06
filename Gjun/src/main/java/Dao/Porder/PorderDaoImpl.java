package Dao.Porder;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Dao.DbConnection;
import Model.Porder;

public class PorderDaoImpl implements PorderDao{

	public static void main(String[] args) {
		
		//c
		//Porder p = new Porder("C桌", 2, 1, 1);
		//new PorderDaoImpl().add(p);
		
		//r
		//System.out.println(new PorderDaoImpl().queryAll());
		//System.out.println(new PorderDaoImpl().querySum(500, 600));
		
		//u
		//Porder p = new PorderDaoImpl().queryId(1);
		//p.setA(2);
		//p.setC(2);
		//p.getSum();
		//new PorderDaoImpl().update(p);
		
		//d
		//new PorderDaoImpl().delete(2);
	}

	//c
	@Override
	public void add(Porder p) {
		EntityManager em = DbConnection.getDb();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}

	//r
	@Override
	public List<Porder> queryAll() {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select p from Porder p";
		Query q = em.createQuery(JPQL);
		List<Porder> l = q.getResultList();
		return l;
	}
	@Override
	public List<Porder> querySum(int start, int end) {
		EntityManager em = DbConnection.getDb();
		String JPQL = "select p from Porder p where p.sum>=?1 and p.sum<=?2";
		Query q = em.createQuery(JPQL);
		q.setParameter(1, start);
		q.setParameter(2, end);
		List<Porder> l = q.getResultList();
		return l;
	}
	@Override
	public Porder queryId(int id) {
		EntityManager em = DbConnection.getDb();
		//String JPQL = "select p from Porder p where p.id=?1";
		//Query q = em.createQuery(JPQL);
		//q.setParameter(1, id);
		//List<Porder> l = q.getResultList();
		//Porder[] p = l.toArray(new Porder[l.size()]);
		//return p[0];
		return em.find(Porder.class, id);
	}

	//u
	@Override
	public void update(Porder p) {
		EntityManager em = DbConnection.getDb();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
	}

	//d
	@Override
	public void delete(int id) {
		EntityManager em = DbConnection.getDb();
		Porder p = em.find(Porder.class, id);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}

}
