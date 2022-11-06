package Dao.Porder;

import java.util.List;

import Model.Porder;

public interface PorderDao {
	//c
	void add(Porder p);
	
	//r
	List<Porder> queryAll();
	List<Porder> querySum(int start, int end);
	Porder queryId(int id);
	
	//u
	void update(Porder p);
	
	//d
	void delete(int id);
}
