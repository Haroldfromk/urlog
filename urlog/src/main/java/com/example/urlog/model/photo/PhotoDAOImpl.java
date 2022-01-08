package com.example.urlog.model.photo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PhotoDAOImpl implements PhotoDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public void delete(int p_idx, String userid) {
		Map<String, String> map = new HashMap<>();
		String iidx = String.valueOf(p_idx);
		map.put("userid", userid);
		map.put("p_idx", iidx);
		
		sqlSession.delete("photo.delete", map);
		
	}

	@Override
	public void update(PhotoDTO dto) {
		sqlSession.update("photo.update", dto);
		
	}

	@Override
	public void insert(PhotoDTO dto) {
		sqlSession.insert("photo.insert",dto);
		
	}

	@Override
	public List<PhotoDTO> list() {
		
		return sqlSession.selectList("photo.list");
	}

	@Override
	public String file_info(int p_idx, String userid) {
		Map<String, String> map = new HashMap<>();
		String iidx = String.valueOf(p_idx);
		map.put("userid", userid);
		map.put("p_idx", iidx);
			
		
		return sqlSession.selectOne("photo.file_info", map);
	}

	@Override
	public int getidx() {
		
		return sqlSession.selectOne("photo.getidx");
	}

	@Override
	public Object detailfm(int p_idx, String userid) {
		Map<String, String> map = new HashMap<>();
		String iidx = String.valueOf(p_idx);
		map.put("userid", userid);
		map.put("p_idx", iidx);
		
		return sqlSession.selectOne("photo.detailfm",map);
	}

	@Override
	public PhotoDTO detail(int p_idx) {
		
		return sqlSession.selectOne("photo.detail", p_idx);
		
	}

}
