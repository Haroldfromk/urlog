package com.example.urlog.controller.photo;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.urlog.model.photo.PhotoDAO;
import com.example.urlog.model.photo.PhotoDTO;

@Controller
@RequestMapping("/photo/*")
public class PhotoController {
	
	@Inject
	PhotoDAO photoDao;
	
	@SuppressWarnings("unused")
	@RequestMapping("insert.do")
	public String insert(PhotoDTO dto,HttpSession session, HttpServletRequest request) {
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
		dto.setP_idx(photoDao.getidx());
		
		if((Integer)dto.getP_idx() == null) {
			dto.setP_idx(1);
		}else {
			dto.setP_idx(dto.getP_idx()+1);
		}
				
		dto.setP_filename(filename);
		photoDao.insert(dto);
		return "redirect:/photo/list.do";
	}
	
	@RequestMapping("write.do")
	public String write() {
		return "photo/write";
		
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("/photo/list");
		mav.addObject("list", photoDao.list());
		return mav;
	}

	
	@RequestMapping("edit/{p_idx}")
	public ModelAndView edit(@PathVariable int p_idx, HttpSession session, String userid, ModelAndView mav) {
			
			mav.setViewName("/photo/edit");
			mav.addObject("dto", photoDao.detailfm(p_idx, (String)session.getAttribute("userid")));
			
		return mav;
	}

	@RequestMapping("update.do")
	public String update(PhotoDTO dto, HttpSession session, HttpServletRequest request) {
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
	         dto.setP_filename(filename);
	      } else { 
	         PhotoDTO dto2 = photoDao.detail(dto.getP_idx());
	         dto.setP_filename(dto2.getP_filename());
	      }
	      dto.setUserid((String)session.getAttribute("userid"));
	      photoDao.update(dto);
	         return "redirect:/photo/list.do";
	}
	
	@RequestMapping("delete.do")
	public String delete(int p_idx, HttpSession session, String userid, HttpServletRequest request) {
		String filename = photoDao.file_info(p_idx, (String)session.getAttribute("userid"));
		if (filename != null && !filename.equals("-")) {
			ServletContext application = request.getSession().getServletContext();
			String path = application.getRealPath("/WEB-INF/views/images/");
			File f = new File(path + filename);
			if (f.exists()) {
				f.delete();
			}
		} 
		
		photoDao.delete(p_idx, (String)session.getAttribute("userid"));
			
		return "redirect:/photo/list.do";
		
	}
}
