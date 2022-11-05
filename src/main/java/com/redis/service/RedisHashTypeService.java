package com.redis.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import com.redis.bean.Address;
import com.redis.bean.User;
import com.redis.exception.RedisException;

/**
 * Hash Type 一般操作 redis 服務 ( 可以裝配多個 Key, Value)
 * 
 * @author oscar51011
 *
 */
@Service
public class RedisHashTypeService {

	private static final String HASH_KEY = "HASH";
	
	private static final String USER_HASH_KEY = "USER";
	
	@Autowired
    private RedisTemplate<Object, Object> redisTemplate;
	
	private void setSerializer() {
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        // 針對 Hash value 做序列化處理(JdkSerializationRedisSerializer序列化後長度比較短) 
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
	}
	
	/**
	 * 新增 HASH Key
	 */
	public void setHashData() {
		
		setSerializer();
        User user = new User();
        user.setName("user");
        user.setAge(10);
        Address address = new Address();
        address.setCity("test");
        address.setNumber(123);
        user.setAddress(address);
        
        
		Map<String, Object> testMap = new HashMap<String, Object>();
		testMap.put(USER_HASH_KEY, user);
		
		redisTemplate.opsForHash().putAll( HASH_KEY, testMap);
	}
	
	/**
	 * 刪除 Hash 型態的資料
	 */
	public boolean deleteHashData() {
		return redisTemplate.delete(HASH_KEY);
	}
	
	/**
	 * 取得 Hash 的 USER field data
	 * @return
	 */
	public User getHashUserField() {
		setSerializer();
		User user = (User)redisTemplate.opsForHash().get(HASH_KEY, USER_HASH_KEY);
		if(user == null) throw new RedisException("找無此資料");
		return user;
	}
	
	/**
	 * 在既定的 HASH 中新增 field
	 * @param hashKey
	 * @param hashValue
	 */
	public void addHashField(String hashKey,String hashValue) {
		setSerializer();
		redisTemplate.opsForHash().put(HASH_KEY, hashKey, hashValue);
	}
	
	/**
	 * 在既定的 HASH 中刪除 field
	 * @param hashKey
	 */
	public Long deleteHashField(String hashKey) {
		setSerializer();
		return redisTemplate.opsForHash().delete(HASH_KEY, hashKey);
	}
	
	
}
