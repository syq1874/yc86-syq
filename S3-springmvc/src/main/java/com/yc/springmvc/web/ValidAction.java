package com.yc.springmvc.web;


import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.bean.DmUser;
import com.yc.damai.bean.Result;

@RestController
@RequestMapping("demo")
public class ValidAction {
	
	
	@RequestMapping("reg.do")
	public Result reg(@Valid DmUser du,Errors errors) {
		
		if(errors.hasErrors()) {
			return new Result(0,"验证错误",errors.getAllErrors());
		}else {
			return new Result(1,"注册成功");
		}
		
		
		
	}

}
