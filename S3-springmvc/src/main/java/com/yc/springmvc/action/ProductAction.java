package com.yc.springmvc.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.bean.DmProduct;
import com.yc.damai.dao.DmProductMapper;

@RestController("pAction")
public class ProductAction {
	
	@Resource
	private DmProductMapper pm;
	
	@GetMapping(path="product.do",params = "op=query")
	public Map<String,Object> query(DmProduct dp){
		
		Map<String,Object> m = new HashMap<String, Object>();
		m.put("list",pm.selectForHot());
		return m;
	}

}
