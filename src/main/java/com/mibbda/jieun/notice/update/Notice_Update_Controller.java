package com.mibbda.jieun.notice.update;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




// 지은 21.01.22 추가
@Controller
public class Notice_Update_Controller {
	
	@Autowired
	private SqlSession sqlSession; 
	
	
	@RequestMapping("manaNoticeView")
	public String contentView(HttpServletRequest request, Model model){

		Notice_Update_Dao dao = sqlSession.getMapper(Notice_Update_Dao.class);	
		model.addAttribute("noticeView", dao.NoticeContentView(request.getParameter("nSeqno")));
		return "notice_admin/manaViewNotice";
	}
	
	@RequestMapping(value="/updateNotice", method=RequestMethod.POST )
	public String modify(HttpServletRequest request, Model model){
		// 1. session 연결.
		Notice_Update_Dao dao = sqlSession.getMapper(Notice_Update_Dao.class);
		// 2. IDao에 선언해둔 메소드 사용(IDao에서 사용한 매개변수 방식대로 써야함)
		dao.NoticeModifyDao(request.getParameter("admin_adminId"), request.getParameter("nTitle"), request.getParameter("nContent"), request.getParameter("nDate"));
		// 3. IDao.xml에 쿼리로 연결하면 끝!		
	
		return "redirect:manageNoticeList";
	}

	
}
