/*
 * package com.example.urlog.controller;
 * 
 * import javax.inject.Inject; import javax.servlet.http.HttpSession;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * import com.example.spring04.model.member.AdminDAO; import
 * com.example.spring04.model.member.MemberDTO;
 * 
 * @Controller
 * 
 * @RequestMapping("/admin/*") // class 앞의 RequestMapping은 class아래 메서드의
 * RequestMapping 공통 주소를 적어서 간소화 할 수 있다 // AdminController의 경우 /admin/ 이 각 메서드
 * RequestMapping에 공통으로 들어갔다. public class AdminController {
 * 
 * @Inject AdminDAO adminDao;
 * 
 * // localhost://spring04/admin/login.do
 * 
 * @RequestMapping("login.do") public String login() {
 * 
 * return "admin/login"; }
 * 
 * @RequestMapping("login_check.do") public ModelAndView login_check(AdminDTO
 * dto, HttpSession session, ModelAndView mav) {
 * 
 * String name = adminDao.login(dto); if(name != null) { // id, pw가 일치한다면
 * session.setAttribute("admin_userid", dto.getUserid());
 * session.setAttribute("admin_name", name);
 * 
 * session.setAttribute("userid", dto.getUserid());
 * session.setAttribute("username", name);
 * 
 * mav.setViewName("admin/admin"); mav.addObject("message", "success");
 * 
 * }else { // id, pw 불일치 mav.setViewName("admin/login");
 * mav.addObject("message", "error"); } return mav; }
 * 
 * @RequestMapping("logout.do") public String logout(HttpSession session) {
 * session.invalidate(); return "redirect:/admin/login.do?message=logout"; } }
 */