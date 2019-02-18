package com.meituan.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.Executors;

/**
 * @author yihua.huang@dianping.com
 */
public class AnnotationTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		System.out.println(ctx.getBean("message"));

		Executors.newCachedThreadPool();

	}
}
