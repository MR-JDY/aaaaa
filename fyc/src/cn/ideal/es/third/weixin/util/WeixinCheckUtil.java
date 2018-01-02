package cn.ideal.es.third.weixin.util;

import java.util.Arrays;

import cn.ideal.es.common.util.Sha1Util;

public class WeixinCheckUtil {
	public static String ECHOSTR="XQG";//微信开发需要的随机字符串
	public static boolean checkSignature(String signature,String timestamp,String echostr,String nonce){
	
		String str[] = new String[]{ECHOSTR,timestamp,nonce};
		System.out.println(str[0]+"-"+str[1]+"-"+str[2]);
		Arrays.sort(str);
		
		//对String StringBuilder StringBuffer的总结见网址：http://www.iteye.com/topic/522167
		StringBuilder stringBuilder = new StringBuilder();
		for(String s:str){
			stringBuilder.append(s);
		}
		//加密
		String temp = Sha1Util.getSha1(stringBuilder.toString());
		if(temp.equals(signature)){
			return true;
		}
		return false;
	}
}
