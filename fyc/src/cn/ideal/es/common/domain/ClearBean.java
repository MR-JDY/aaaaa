package cn.ideal.es.common.domain;
/**
 * 系统中所有实体类必须继承的接口，此为顶级接口，负责清理实体类中的字段数据。
 * @author Joe
 *
 */
public interface ClearBean {

	/**
	 * 清空实体类属性值
	 */
	public void clear();
}
