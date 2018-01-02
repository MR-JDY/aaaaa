package cn.ideal.es.common.util.especial;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

/**
 * 关于Json的一些转化
 * @author Joe 2017年12月4日
 */
public class JsonUtils {

	/*
	 * public void Map2Json(StringBuffer sb, Map<K, V> map) { Set<K> keys =
	 * map.keySet(); sb.append("{"); for (Iterator<K> it = keys.iterator();
	 * it.hasNext();) { K key = (K)it.next(); Object object = map.get(key);
	 * sb.append(key + ":"); if
	 * (object.getClass().getSimpleName().equals("HashMap")) { Map2Json2(sb,
	 * (Map) object); } else
	 * if(object.getClass().getSimpleName().equals("String")){ sb.append("\"" +
	 * object.toString() + "\""); } else{ Integer parseInt =
	 * Integer.parseInt(object.toString()); sb.append(parseInt); } if
	 * (it.hasNext()) { sb.append(","); } } sb.append("}"); }
	 */
	/**
	 * map转json字符串
	 * 
	 * @param sb
	 * @param map
	 */
	/*@SuppressWarnings("unchecked")
	public static void Map2Json2(StringBuffer sb, Map<String,Object> map) {
		Set<String> keys = map.keySet();
		String key = "";
		String value = "";
		sb.append("{");
		for (Iterator<String> it = keys.iterator(); it.hasNext();) {
			key = (String) it.next();
			Object object = map.get(key);
			value = object.toString();
			sb.append("\"" + key + "\":");
			if (object.getClass().getSimpleName().equals("HashMap")) {
				Map2Json2(sb, (Map<String,Object>) object);
			} else {
				sb.append("\"" + value + "\"");
			}
			if (it.hasNext()) {
				sb.append(",");
			}
		}
		sb.append("}");
	}

	public static void main(String[] args) {
		Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
		Map<String, String> map2 = new HashMap<String, String>();
		Map<String, String> map3 = new HashMap<String, String>();
		map.put("xiang", map2);
		map.put("xiang3", map3);
		map2.put("qiao", "哈哈");
		map2.put("xiang2", "嘿嘿2");
		map3.put("qiao2", "哈哈2");
		StringBuffer sb = new StringBuffer("");
		System.out.println(JSONObject.fromObject(map));
		System.out.println(map.getClass().getSimpleName());
	}*/
}
