package com.example.urlog.model.photo;

import java.util.List;

public interface PhotoDAO {
	void delete(int p_idx, String userid);
	void update(PhotoDTO dto);
	void insert(PhotoDTO dto);
	List<PhotoDTO> list();
	String file_info(int p_idx, String userid);
	int getidx();
	Object detailfm(int p_idx, String userid);
	PhotoDTO detail(int p_idx);
}
