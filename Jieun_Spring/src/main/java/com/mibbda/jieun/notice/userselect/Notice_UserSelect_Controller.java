package com.mibbda.jieun.notice.userselect;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mibbda.jieun.notice.update.Notice_Update_Dao;


// 지은 21.01.22 추가
@Controller
public class Notice_UserSelect_Controller {
	
	@Autowired
	private SqlSession sqlSession; 
	
	//NoticeUserList
	@RequestMapping("noticeList")
	public String list(Model model) {
		
		// Notice_UserSelect_Dao.xml과 연결.
		Notice_UserSelect_Dao dao = sqlSession.getMapper(Notice_UserSelect_Dao.class);
		
		//
		model.addAttribute("NoticeUserList", dao.NoticeUserListDao());
		
		//
		return "notice_user/noticeList";
	}

	
	@RequestMapping("noticeView")
	public String contentView(HttpServletRequest request, Model model){

		Notice_Update_Dao dao = sqlSession.getMapper(Notice_Update_Dao.class);	
		model.addAttribute("userNoticeView", dao.NoticeContentView(request.getParameter("nSeqno")));
		return "notice_user/noticeView";
	}
	
	
	// 검색
		@RequestMapping("/UserNoticeSearch")
		public String listQuery(HttpServletRequest request, Model model) {
			Notice_UserSelect_Dao dao = sqlSession.getMapper(Notice_UserSelect_Dao.class);
			model.addAttribute("NoticeUserList", dao.NoticeUserQuery(request.getParameter("query"), request.getParameter("content")));
			return "notice_user/noticeList";
		}
		
}
