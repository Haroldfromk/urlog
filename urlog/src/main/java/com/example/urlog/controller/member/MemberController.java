package com.example.urlog.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.urlog.model.member.MemberDAO;
import com.example.urlog.model.member.MemberDTO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	MemberDAO memberDao;
		
	@RequestMapping("login.do")
	public String login() {
		
		return"start/login";
	}
	
	@RequestMapping("login_check.do")
	public ModelAndView login_check (@ModelAttribute MemberDTO dto, HttpSession session, ModelAndView mav) {
		
		String name=memberDao.login(dto);
		String logo=memberDao.logo(dto);
		
		if (name!=null) {
			
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("member_name", name);
			session.setAttribute("logo", logo);
			mav.setViewName("start/main");
			
		}else {
			
			mav.setViewName("start/login");
			mav.addObject("message", "error");
			
		}
		
		System.out.println(name + logo);
		
		return mav;
		
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout (HttpSession session, ModelAndView mav) {
		
		session.invalidate();
		mav.setViewName("start/login");
		mav.addObject("message", "logout");
		
		return mav;
		
	}
	
	@RequestMapping("join.do")
	public String join() {
		return "start/join";
	}
	
	@RequestMapping("insert.do")
	public ModelAndView insert(@ModelAttribute MemberDTO dto, HttpSession session, ModelAndView mav) {
		
		memberDao.insert(dto);
		
		session.setAttribute("userid", dto.getUserid());
		session.setAttribute("member_name", dto.getMember_name());

		mav.setViewName("start/main");
					
		return mav;
		
	}
	
	@RequestMapping("view.do")
	public String view(HttpSession session, Model model) {
		
		String userid = (String)session.getAttribute("userid");
		model.addAttribute("dto", memberDao.detail(userid));
		session.setAttribute("userid", model.getAttribute(userid));
					
		return "member/view";
	}
	
	@RequestMapping("update.do")
	public ModelAndView update(@ModelAttribute MemberDTO dto, Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		boolean result = memberDao.check_passwd(dto.getUserid(), dto.getMember_passwd());
		if(result) {
							
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", dto.getMember_name());
			
			memberDao.update(dto);
			mav.setViewName("start/main");
			
			return mav;
							
		}else {
			
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			mav.setViewName("member/login");
			mav.addObject("message", "비밀번호가 일치하지 않습니다.");
			return mav;
			
		}
	}
	
	@RequestMapping("idcheck.do")
	public String idcheck(@RequestParam String userid, Model model) {
				
		int result = memberDao.idcheck(userid);
		
		model.addAttribute("userid",userid);
		model.addAttribute("result", result);
		
		return "member/idcheck";
	}
	

	@RequestMapping("delete.do")
	public String delete (@RequestParam String userid, @RequestParam String passwd, Model model) {
		boolean result = memberDao.check_passwd(userid, passwd);
		if(result) {
			
			model.addAttribute("message", "out");
			memberDao.delete(userid);
			
			return "start/login";
			
		}else {
			
			model.addAttribute("dto", memberDao.detail(userid));
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			
			return "member/view";
			
		}
	}
	
}
