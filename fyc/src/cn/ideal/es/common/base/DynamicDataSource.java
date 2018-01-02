package cn.ideal.es.common.base;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 获取动态数据源
 * @author Joe
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return DataBaseContextHolder.getDbSource();
	}

}
