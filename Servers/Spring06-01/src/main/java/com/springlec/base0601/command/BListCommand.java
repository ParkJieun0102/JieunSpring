package com.springlec.base0601.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.springlec.base0601.dao.BDao;
import com.springlec.base0601.dto.BDto;

// 데이터 베이스를 불러오는 command
public class BListCommand implements BCommand {

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		// **
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);

	}

}
