package com.mibbda.jieun.notice.update;


public interface Notice_Update_Dao {

	
	// 관리자용 공지사항 입력하기 			
	// NoticeAdminListDao() => 메소드 명
	// 컨텐츠 내용 불러오는 메소드
	public Notice_Update_Dto NoticeContentView(String nSeqno);		
	
	// 글 수정 메소드
	public void NoticeModifyDao(String admin_adminId, String nTitle, String nContent, String nDate);
}
