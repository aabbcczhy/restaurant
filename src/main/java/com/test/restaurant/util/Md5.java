package com.test.restaurant.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Md5 {
	
	public static String encodePassword(String password,String salt) {
		ByteSource byteSalt = ByteSource.Util.bytes(salt);
		SimpleHash result = new SimpleHash("md5", password, byteSalt, 2);
		return result.toString();
	}
	
}
