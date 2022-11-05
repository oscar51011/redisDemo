package com.redis.service;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import com.redis.bean.Address;
import com.redis.bean.User;
import com.redis.exception.RedisException;

@Service
public class RedisJsonTypeService {

	private static final String JSON_KEY = "JSON";
	
	@Resource
    private RedisTemplate<String, User> redisTemplate;
	
	private void setSerializer() {
		redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
	}
	
	public void setUserJsonData() {
		setSerializer();
		User user = new User();
        user.setName("user");
        user.setAge(10);
        Address address = new Address();
        address.setCity("test");
        address.setNumber(123);
        user.setAddress(address);
		redisTemplate.opsForValue().set(JSON_KEY, user);
	}
	
	public User getUserJsonData() {
		setSerializer();
		User user = (User)redisTemplate.opsForValue().get(JSON_KEY);
		if(user == null) throw new RedisException("找無此資料");
		return user;
	}
}
