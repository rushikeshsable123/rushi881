package com.cjc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeControllerMVC {
	
	List<Student> al = new ArrayList<Student>();
	
	@RequestMapping("/")
	public String prelogin()
	{
		return "login";
	}
	@RequestMapping("/reg")
	public String reglogin()
	{
		
		return "register";
	}
	@RequestMapping("/regin")
	public String suc(@ModelAttribute Student s)
	{
		System.out.println(s.getName());
		System.out.println(s.getMobilno());
		System.out.println(s.getUsername());
		System.out.println(s.getPassword());
		System.out.println("suc method");
		al.add(s);
		return "login";
	}
	
	@RequestMapping("/log")
    public String loginCheck(@RequestParam("username")String un,@RequestParam("password")String ps,Model m)
		{
			System.out.println("login_method----"+un);
			System.out.println("login_method----"+ps);
			for(Student stu1 : al)
			{
				if(un.equalsIgnoreCase(stu1.getUsername())&& ps.equals(stu1.getPassword()))
				{
					m.addAttribute("data", stu1);
					return "success";
				}
			}
			return "login";
		}
}
