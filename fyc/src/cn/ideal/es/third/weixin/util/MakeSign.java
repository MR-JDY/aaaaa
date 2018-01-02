package cn.ideal.es.third.weixin.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

public class MakeSign {

	/**
	 * 微信签名
	 * @param sPara
	 * @param key
	 * @return
	 */
	public static String makeSign(Map<String, String> sPara, String key) {
		ArrayList<String> list = new ArrayList<String>();
		for (Map.Entry<String, String> entry : sPara.entrySet()) {
			if (entry.getValue() != "") {
				list.add(entry.getKey() + "=" + entry.getValue() + "&");
			}
		}
		int size = list.size();
		String[] arrayToSort = list.toArray(new String[size]);
		Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(arrayToSort[i]);
		}
		String result = sb.toString();
		result += "key=" + key;
		System.out.println(sPara.get("out_trade_no") + "微信支付签名源串:" + result);
		result = DigestUtils.md5Hex(result).toUpperCase();
		System.out.println(sPara.get("out_trade_no") + "微信支付签名结果:" + result);
		return result;
	}
	/**
	 * 转换成XML报文
	 * @param sPara
	 * @return
	 * @throws Exception
	 */
	private String toXML(Map<String, String> sPara) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		for(String key : sPara.keySet()){
			sb.append("<" + key + ">");
			sb.append(sPara.get(key));
			sb.append("</" + key + ">");

		}
		sb.append("</xml>");
		return sb.toString();
	}
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("appid", "wxa2e516aa68265bfc");
		map.put("mch_id", "1298260201");
		map.put("nonce_str", "1add1a30ac87aa2db72f57a2375d8fec");
		map.put("trade_type", "NATIVE");
		map.put("notify_url", "http://xqgdtx.ngrok.cc/fyc/weixin/getPay.do");
		map.put("spbill_create_ip", "127.0.0.1");
		map.put("total_fee", "1");
		map.put("out_trade_no", "1415659990");
		map.put("body", "JSAPI支付测试");
		System.out.println(makeSign(map, "X5ReecXeighRetMerfes8dokUvyewv7Y"));
	}
}
