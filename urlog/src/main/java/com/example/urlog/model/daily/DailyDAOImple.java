package com.example.urlog.model.daily;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class DailyDAOImple implements DailyDAO {
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public void delete(int d_idx, String userid) {
		Map<String, String> map = new HashMap<>();
		String iidx = String.valueOf(d_idx);
		map.put("userid", userid);
		map.put("d_idx", iidx);
		
		sqlSession.delete("daily.delete", map);
		
	}

	@Override
	public void update(DailyDTO dto) {
		sqlSession.update("daily.update", dto);
		
	}

	@Override
	public void insert(DailyDTO dto) {
		sqlSession.insert("daily.insert", dto);
		
	}

	@Override
	public List<DailyDTO> list() {
		
		return sqlSession.selectList("daily.list");
	}

	@Override
	public DailyDTO detail(int d_idx) {
				
		return sqlSession.selectOne("daily.detail", d_idx);
	}

	@Override
	public String file_info(int d_idx, String userid) {
		
		Map<String, String> map = new HashMap<>();
		String iidx = String.valueOf(d_idx);
		map.put("userid", userid);
		map.put("d_idx", iidx);
		
		return sqlSession.selectOne("daily.file_info", map);
	}

	@Override
	public int getidx() {
		return sqlSession.selectOne("daily.getidx");
		
	}

	@Override
	public Object detailfm(int d_idx, String userid) {
		Map<String, String> map = new HashMap<>();
		String iidx = String.valueOf(d_idx);
		map.put("userid", userid);
		map.put("d_idx", iidx);
		
		return sqlSession.selectOne("daily.detailfm", map);
	}

	@Override
	public void readcount(int d_idx) {
		sqlSession.update("daily.readcount", d_idx);
		
	}

	

}
