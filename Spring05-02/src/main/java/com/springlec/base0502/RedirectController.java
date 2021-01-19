package com.springlec.base0502;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping("studentConfirm")
	public String studentRedirect(HttpServletRequest httpServletRequest, Model model) {
		
		String id = httpServletRequest.getParameter("id");
		if(id.contentEquals("abc")) {
			return "redirect:studentOK2";
		}
		return "redirect:studentNG2";
	}
	
	@RequestMapping("studentOK2")
	public String studentOK() {
		return "student/studentOK";
	}
	
	
	@RequestMapping("studentNG2")
	public String studentNG() {
		return "student/studentNG";
	}

}// ------------------
