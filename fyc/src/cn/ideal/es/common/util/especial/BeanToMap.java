package cn.ideal.es.common.util.especial;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.ideal.es.domain.UserTest;

/**
 * 实体类对象转换成Map
 * @author Joe
 * 2017年12月4日
 */
public class BeanToMap {
		  
	    /** 
	     * 实体类对象转换成Map 
	     * @param obj 
	     * @return 
	     */  
	    public static Map<String, Object> ConvertObjToMap(Object obj) {  
	        Map<String, Object> reMap = new HashMap<String, Object>();  
	        if (obj == null)  
	            return null;  
	        Field[] fields = obj.getClass().getDeclaredFields();  
	        try {  
	            for (int i = 0; i < fields.length; i++) {  
	                try {  
	                    Field f = obj.getClass().getDeclaredField(  
	                            fields[i].getName());  
	                    f.setAccessible(true);  
	                    Object o = f.get(obj);  
	                    reMap.put(fields[i].getName(), o);  
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        } catch (SecurityException e) {  
	            e.printStackTrace();  
	        }  
	        return reMap;  
	    }  
	  
	    /** 
	     * 转换的示例方法 
	     * @param args 
	     */  
	    public static void main(String[] args) {  
	    	UserTest user = new UserTest("219396", "daolin", 23);  
	        user.setDate(new Date());  
	        Map<String, Object> map = ConvertObjToMap(user);
	        System.out.println(map);
	        for(int k = 0; k<map.size(); k++) {  
	            System.out.println(map.get("age").getClass().getSimpleName());  
	        }  
	    }  
	  
}
