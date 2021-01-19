package com.springlec.base0601.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0601.command.BCommand;
import com.springlec.base0601.command.BListCommand;

@Controller
public class BController {
	
	BCommand command = null;
	
	@RequestMapping("list")
	public String list(Model model) {
		System.out.println("list()");
		command = new BListCommand();
		command.excute(model);
		
		return "list";
	}
	
	@RequestMapping("write_view")
	public String write_view() {
		System.out.println("write_view");
		return "write_view";
	}
}
