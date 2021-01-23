package com.mibbda.jieun.notice.adminselect;

import java.util.ArrayList;




public interface Notice_AdminSelect_Dao {

	
	// 관리자용 공지사항 리스트 불러오기 			
	// NoticeAdminListDao() => 메소드 명
	public ArrayList<Notice_AdminSelect_Dto> NoticeAdminListDao();	
	
	
	//
	public ArrayList<Notice_AdminSelect_Dto> NoticeAdminQuery(String query, String content);
}
