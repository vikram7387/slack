package com.techM.slack.model;

import java.util.HashMap;

public class CacheInfo {
	
	private static CacheInfo cacheInfo=null;
	
	private static HashMap<String,String> user=null;
	
	private CacheInfo() {
	}

	public static CacheInfo getInstance() {
		if(cacheInfo !=null) {
			cacheInfo= new CacheInfo();
			return cacheInfo;
		}else {
			return cacheInfo;
		}
	}

	public static CacheInfo getCacheInfo() {
		return cacheInfo;
	}

	public static void setCacheInfo(CacheInfo cacheInfo) {
		CacheInfo.cacheInfo = cacheInfo;
	}

	public static HashMap<String,String> getUser() {
		return user;
	}

	public static void setUser(HashMap<String,String> user) {
		CacheInfo.user = user;
	}
	
	public static void setUserDetail(String user,String messages) {
		if(CacheInfo.getUser()!=null) {
	     	HashMap<String, String> hashMap=CacheInfo.getUser();
	     	hashMap.put(user, messages);
	     	CacheInfo.setUser(hashMap);
		}else {
			HashMap<String, String> hashMap=new HashMap<String,String>();
			hashMap.put(user, messages);
			CacheInfo.setUser(hashMap);
		}	
	}
	
	public static String getUserDetails(String user) {
		HashMap<String,String> hashMap=CacheInfo.getUser();
		if(hashMap!=null) {
			return hashMap.get(user);
		}
		return null;
	} 
	
	
	
}
