package com.zhy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBlogApplicationTests {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Test
	public void contextLoads() {
		String a = redisTemplate.boundValueOps("test").get();
		System.out.print(a);
	}


}
