package com.mibbda.jieun.notice.userselect;

import java.util.ArrayList;





public interface Notice_UserSelect_Dao {

	
	// 관리자용 공지사항 리스트 불러오기 			
	// NoticeUserListDao() => 메소드 명
	public ArrayList<Notice_UserSelect_Dto> NoticeUserListDao();
	
	// 컨텐츠 내용 불러오는 메소드
	public Notice_UserSelect_Dto NoticeContentView(String nSeqno);	
	
	// 검색 결과
	public ArrayList<Notice_UserSelect_Dto> NoticeUserQuery(String query, String content);
	
}
