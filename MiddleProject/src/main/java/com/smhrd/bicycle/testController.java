package com.smhrd.bicycle;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.bicycle.mapper.PageMapper;
import com.smhrd.bicycle.model.User;

@Controller
public class testController {
	
	@Autowired
	PageMapper mapper;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test(@RequestParam("id") String id, @RequestParam("pw") String pw) {
		
		User a = new User(id,pw);
		
		int res = mapper.insert(a);
		
		if(res>0) {	
			System.out.println("디비연결성공");
			return "test";
		}else {
			System.out.println("디비연결실패");
			return "test";
		}
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String test1() {
		return "test";
	}
	
}
