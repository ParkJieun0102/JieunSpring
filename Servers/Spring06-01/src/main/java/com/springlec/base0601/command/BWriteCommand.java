package com.springlec.base0601.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.base0601.dao.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		
		// 데이터 왔다갔다 하기위해 model을 사용
		// 키값과 벨류걊을 바꿔준다.
		Map<String, Object> map = model.asMap();	
		HttpServletRequest request = (HttpServletRequest) map.get("request");	// 받을 때 request
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
	}

}
