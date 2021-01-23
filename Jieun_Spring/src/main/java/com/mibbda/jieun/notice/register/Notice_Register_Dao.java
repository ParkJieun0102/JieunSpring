package com.mibbda.jieun.notice.register;


public interface Notice_Register_Dao {

	
	// 관리자용 공지사항 입력하기 			
	// NoticeAdminListDao() => 메소드 명
	public void NoticeWriteDao(String admin_adminId, String nTitle, String nContent, String nDate);
	
}
