package com.pixeon.sistemaa.util;

import redis.clients.jedis.Jedis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CacheRedisUtil {
	
	private static Jedis jedis;

	private static Gson gson;
	
	static {
		jedis = new Jedis("127.0.0.1");
		gson = new GsonBuilder().create();
	}
	
	public static Object carregarDoCache(){
		
		return null;
		
	}
	
	

}
