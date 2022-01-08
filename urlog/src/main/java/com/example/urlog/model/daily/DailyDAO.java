package com.example.urlog.model.daily;

import java.util.List;

public interface DailyDAO {

	void delete(int d_idx, String userid);
	void update(DailyDTO dto);
	void insert(DailyDTO dto);
	List<DailyDTO> list();
	DailyDTO detail(int d_idx);
	String file_info(int d_idx, String userid);
	int getidx();
	Object detailfm(int d_idx, String userid);
	void readcount(int d_idx);

}
