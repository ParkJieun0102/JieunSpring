package com.springlec.base0401;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	// Spring 버전 3
	//***************************************************************
	// get방식
	// 1번째 방식 : jsp 까지만 실행해도 id : // pw : // 값을 주기전까지도 뜨긴 함 
	@RequestMapping("board/confirmId")
	public String confirmId(HttpServletRequest httpServletRequest, Model model) {
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/confirmId";
	}
	
	// get방식
	// 2번째 방식 : jsp 까지만 실행해도 뜨지 않음. 값을 모두 넘겨줘야 뜬다. 
	// 위에랑 비교하기 (위의 두줄을 밑에는 줄로 쓴 방식이다.) 
	// String ()  '''''' 의 값을 비교해보기 
	@RequestMapping("board/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		
		return "board/checkId";
	}
	//***************************************************************
	
	
	
	
	
	// Spring 버전 4
	//***************************************************************
	// get방식
	// 2번째 방식 : jsp 까지만 실행해도 뜨지 않음. 값을 모두 넘겨줘야 뜬다. 
	@RequestMapping("board/join")
	public String join(@RequestParam("name") String name, @RequestParam("id") String id,
				@RequestParam("pw") String pw, @RequestParam("email") String email, Model model) {
		Member member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		
		model.addAttribute("member", member);
		
		return "board/join";
	}
	
	
	// get방식
	// 1번째 방식 : jsp 까지만 실행해도 id : // pw : // 값을 주기전까지도 뜨긴 함 
	@RequestMapping("board/join2")
	public String join2(Member member) {
		return "board/join";
	}
	//***************************************************************
	
	
	
	//***************************************************************
	// board/student/1234 쳐야 
	// @PathVariable 이기에 "=" 이 필요없다. 
	@RequestMapping("student/{studentId}")
	public String student(@PathVariable String studentId, Model model) {
		model.addAttribute("studentId", studentId);
		
		return "board/studentView";
	}
	
	
}
