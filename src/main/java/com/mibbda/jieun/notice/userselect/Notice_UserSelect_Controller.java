package com.mibbda.jieun.notice.userselect;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


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

	
}
