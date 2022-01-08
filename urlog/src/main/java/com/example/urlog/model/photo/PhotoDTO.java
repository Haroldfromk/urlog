package com.example.urlog.model.photo;

import org.springframework.web.multipart.MultipartFile;

public class PhotoDTO {
	private String userid;
	private String p_filename;
	private String p_title;
	private int p_idx;
	private MultipartFile file1;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getP_filename() {
		return p_filename;
	}
	public void setP_filename(String p_filename) {
		this.p_filename = p_filename;
	}
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	public int getP_idx() {
		return p_idx;
	}
	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	@Override
	public String toString() {
		return "PhotoDTO [userid=" + userid + ", p_filename=" + p_filename + ", p_title=" + p_title + ", p_idx=" + p_idx
				+ ", file1=" + file1 + "]";
	}
	
	
	
	
	
}
