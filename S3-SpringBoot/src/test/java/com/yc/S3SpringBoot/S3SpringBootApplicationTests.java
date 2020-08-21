package com.yc.S3SpringBoot;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.yc.S3SpringBoot.biz.MailService;
import com.yc.S3SpringBoot.dao.ProductMapper;

@SpringBootTest
class S3SpringBootApplicationTests {

	@Resource
	ProductMapper pm;

	@Resource
	MailService ms;

	@Test
	void contextLoads() {
		Assert.isTrue(pm.selectAll().size() > 0, "没有数据");
	}

	@Test
	void testMail() {
		ms.sendSimpleMail("1953745128@qq.com", "密码重置验证码", "您重置密码的验证码是: 123456");
	}

}