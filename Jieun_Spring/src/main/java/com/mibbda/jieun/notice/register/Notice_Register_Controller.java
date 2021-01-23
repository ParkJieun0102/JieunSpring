package com.mibbda.jieun.notice.register;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



// 지은 21.01.22 추가
@Controller
public class Notice_Register_Controller {
	
	@Autowired
	private SqlSession sqlSession; 
	
	
	@RequestMapping("insertNoticeView")
	public String write_view(Model model) {
		return "notice_admin/insertNoticeView";
	}
	
	@RequestMapping("insertNotice")
	public String write(HttpServletRequest request, Model model) {
		// 1. session 연결.
		Notice_Register_Dao dao = sqlSession.getMapper(Notice_Register_Dao.class);
		
		// 2. IDao에 선언해둔 메소드 사용(IDao에서 사용한 매개변수 방식대로 써야함)
		dao.NoticeWriteDao(request.getParameter("admin_adminId"), request.getParameter("nTitle"), request.getParameter("nContent"), request.getParameter("nDate"));
		
		// 3. IDao.xml에 쿼리로 연결하면 끝!		
		return "redirect:manageNoticeList";
	}

	
}
