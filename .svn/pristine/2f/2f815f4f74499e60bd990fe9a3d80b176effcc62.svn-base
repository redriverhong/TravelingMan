package test;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;

import cyh.service.UserService;
import cyh.vo.user;


public class Test1 {
	private ApplicationContext ac;
	private UserService us;
	private Logger logger=Logger.getLogger(Test1.class);
	@Before
	public void before(){
		ac=new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		us=(UserService) ac.getBean("userService");
	}
	@Test
	public void test1(){
		user u=us.getUserById("1");
		System.out.println(u.getName());
		logger.info(JSON.toJSONString(u));
	}
}