package com.example.urlog.model.daily;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class DailyDTO {

		private String userid;
		private String d_filename;
		private String d_content;
		private String d_title;
		private int d_idx;
		private int d_readcount;
		private Date d_post_date;
		private MultipartFile file1;
		
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getD_filename() {
			return d_filename;
		}
		public void setD_filename(String d_filename) {
			this.d_filename = d_filename;
		}
		public String getD_content() {
			return d_content;
		}
		public void setD_content(String d_content) {
			this.d_content = d_content;
		}
		public String getD_title() {
			return d_title;
		}
		public void setD_title(String d_title) {
			this.d_title = d_title;
		}
		public int getD_idx() {
			return d_idx;
		}
		public void setD_idx(int d_idx) {
			this.d_idx = d_idx;
		}
		public int getD_readcount() {
			return d_readcount;
		}
		public void setD_readcount(int d_readcount) {
			this.d_readcount = d_readcount;
		}
		public Date getD_post_date() {
			return d_post_date;
		}
		public void setD_post_date(Date d_post_date) {
			this.d_post_date = d_post_date;
		}
		public MultipartFile getFile1() {
			return file1;
		}
		public void setFile1(MultipartFile file1) {
			this.file1 = file1;
		}
		@Override
		public String toString() {
			return "DailyDTO [userid=" + userid + ", d_filename=" + d_filename + ", d_content=" + d_content
					+ ", d_title=" + d_title + ", d_idx=" + d_idx + ", d_readcount=" + d_readcount + ", d_post_date="
					+ d_post_date + ", file1=" + file1 + "]";
		}
		
		
		
		
		
		
		
		
}
