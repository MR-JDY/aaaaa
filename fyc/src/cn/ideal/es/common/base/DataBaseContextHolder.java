package cn.ideal.es.common.base;
/**
 * 
 * @author Joe
 *
 */
public class DataBaseContextHolder {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	
	public static String getDbSource(){
		return contextHolder.get();
	}
	public static void setDbSource(String dbSourceName){
		contextHolder.set(dbSourceName);
	}

}