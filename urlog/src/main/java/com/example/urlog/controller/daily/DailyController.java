package com.example.urlog.controller.daily;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.urlog.model.daily.DailyDAO;
import com.example.urlog.model.daily.DailyDTO;

@Controller
@RequestMapping("/daily/*")
public class DailyController {
	
	@Inject
	DailyDAO dailyDao;
	
	@SuppressWarnings("unused")
	@RequestMapping("insert.do")
	public String insert(DailyDTO dto, HttpSession session, HttpServletRequest request) {
		String filename = "-";
		if(!dto.getFile1().isEmpty()) {
			filename = dto.getFile1().getOriginalFilename();
			try {
				ServletContext application = request.getSession().getServletContext();
				String path = application.getRealPath("/WEB-INF/views/images/");
				new File(path).mkdir();
				dto.getFile1().transferTo(new File(path + filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dto.setUserid((String)session.getAttribute("userid"));
		dto.setD_idx(dailyDao.getidx());
		
		if((Integer)dto.getD_idx() == null) {
			dto.setD_idx(1);
		}else {
			dto.setD_idx(dto.getD_idx()+1);
		}
				
		dto.setD_filename(filename);
		dailyDao.insert(dto);
		return "redirect:/daily/list.do";
	}
	
	@RequestMapping("write.do")
	public String write() {
		return "daily/write";
		
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("/daily/list");
		mav.addObject("list", dailyDao.list());
		return mav;
	}

	
	@RequestMapping("edit/{d_idx}")
	public ModelAndView edit(@PathVariable int d_idx, HttpSession session, String userid, ModelAndView mav) {
			
			mav.setViewName("/daily/edit");
			mav.addObject("dto", dailyDao.detailfm(d_idx, (String)session.getAttribute("userid")));
			
		return mav;
	}
	
	 @RequestMapping("detail/{d_idx}")
	   public ModelAndView detail(@PathVariable int d_idx, ModelAndView mav) {
		 dailyDao.readcount(d_idx);
		 mav.setViewName("/daily/detail"); //페이지의 이름
	      mav.addObject("dto", dailyDao.detail(d_idx)); //데이터 저장
	      return mav;
	   }
	
	@RequestMapping("update.do")
	public String update(DailyDTO dto, HttpSession session, HttpServletRequest request) {
		String filename = "-";
	      if (!dto.getFile1().isEmpty()) { 
	         filename = dto.getFile1().getOriginalFilename();
	         try {
	            ServletContext application = request.getSession().getServletContext();
	            String path = application.getRealPath("/WEB-INF/views/images/");
	            new File(path).mkdir();
	            dto.getFile1().transferTo(new File(path + filename));
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	         dto.setD_filename(filename);
	      } else { 
	         DailyDTO dto2 = dailyDao.detail(dto.getD_idx());
	         dto.setD_filename(dto2.getD_filename());
	      }
	      dto.setUserid((String)session.getAttribute("userid"));
	      dailyDao.update(dto);
	      System.out.println(dto.getD_idx() + dto.getUserid());
	      return "redirect:/daily/list.do";
	}
	
	@RequestMapping("delete.do")
	public String delete(int d_idx, HttpSession session, String userid, HttpServletRequest request) {
		String filename = dailyDao.file_info(d_idx, (String)session.getAttribute("userid"));
		if (filename != null && !filename.equals("-")) {
			ServletContext application = request.getSession().getServletContext();
			String path = application.getRealPath("/WEB-INF/views/images/");
			File f = new File(path + filename);
			if (f.exists()) {
				f.delete();
			}
		} 
		
		dailyDao.delete(d_idx, (String)session.getAttribute("userid"));
			
		return "redirect:/daily/list.do";
		
	}
	
	
}
