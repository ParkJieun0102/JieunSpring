package com.springlec.base0601.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0601.command.BCommand;
import com.springlec.base0601.command.BListCommand;
import com.springlec.base0601.command.BWriteCommand;

@Controller
public class BController {
	
	BCommand command = null;
	
	// 리스트 띄움
	@RequestMapping("list")
	public String list(Model model) {
		System.out.println("list()");
		command = new BListCommand();
		command.excute(model);
		
		return "list";
	}
	
	// 입력화면 띄움
	@RequestMapping("write_view")
	public String write_view() {
		System.out.println("write_view");
		return "write_view";
	}
	
	// 입력한값 저장됨
	// request 들어온 값을 model 로 바꿔준다.
	// bean 을 따로 만들지 않는다.
	@RequestMapping("write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.excute(model);
		//********* 입력완료 ********************
		
		// 입력이 완료되면 리스트를 띄워야 하므로 return값은 저렇게
		// return "list" 는 list.jsp 로 보내는 것이고
		// return "redirect:list" 는 BController 안에 있는 list로 보내는 것
		return "redirect:list";
	}
	
	
	
	
}//-----
