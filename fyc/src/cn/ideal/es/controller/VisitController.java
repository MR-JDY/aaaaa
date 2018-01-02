package cn.ideal.es.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/visit")
public class VisitController extends BaseController{

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		System.out.println("进来了");
		return "index";
	}
}
