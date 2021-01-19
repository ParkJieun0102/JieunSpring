package com.springlec.base0301;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 컨트롤 + 스페이스 = 임폴트 자동
@Controller
public class myController {
	
	@RequestMapping("test/view1")
	public String view1() {
		return "test/view1";
	}
	
	@RequestMapping("test/viewid")
	public String view2(Model model) {
		model.addAttribute("id", "tester");
		return "test/viewid";
	}
}
