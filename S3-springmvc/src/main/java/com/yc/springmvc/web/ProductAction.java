package com.yc.springmvc.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.bean.DmCart;
import com.yc.damai.bean.DmUser;

@RestController()
public class ProductAction {

	@RequestMapping(path = "product.do", params = "op=query")
	public String query() {
		return "query!!";
	}

	@RequestMapping(path = "product.do", params = "op=add")
	public String add() {
		return "add!!";
	}

	@RequestMapping(path = "product.do", params = "op=mod", method = RequestMethod.POST)
	public String mod() {
		return "mod!!";
	}

	@GetMapping(path = "product.do", params = "op=select")
	public String select() {
		return "select测试!!";
	}

	@GetMapping(path = "product.do", params = "op=mgr", 
			headers = { "Host=localhost", "Cookie" })
	public String mgr() {
		return "测试管理!!";
	}
	
	@GetMapping("login.do")
	public String login(String user, String pwd) {
		return user + ":" + pwd;
	}
	
	@GetMapping("reg.do")
	public String login(DmUser user, DmCart dc) {
		return user.toString() + "<br>" + dc;
	}
	
	@GetMapping("pay.do")
	public String pay(
			@RequestParam(
				name="userid",	//请求参数名
				//defaultValue="1",//默认值
				required=true  // 必须提供
			) 
			String uid, Double money) {
		return uid + ":" + money;
	}
	
	@GetMapping("findUser.do")
	public DmUser findUser() {
		DmUser du = new DmUser();
		du.setId(100);
		du.setCname("lisi");
		du.setPassword("123");
		return du;
	}
	
	
	
}