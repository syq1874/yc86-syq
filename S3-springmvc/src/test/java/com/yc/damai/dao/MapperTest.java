package com.yc.damai.dao;

import java.io.IOException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("/beans.xml")
public class MapperTest {
	
	@Resource
	DmProductMapper mapper;
	
	@Test
	public void test12() throws IOException {
		mapper.selectById(1);
	}
	
}

