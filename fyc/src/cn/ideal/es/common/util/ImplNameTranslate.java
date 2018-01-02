package cn.ideal.es.common.util;

import org.apache.commons.lang.StringUtils;

import cn.ideal.es.common.constants.CommonStandard;

/**
 * 去掉实现类后缀，例如：userImpl——>user
 * @author Joe
 *
 */
public class ImplNameTranslate {
	public static String translate(String orgName){
		return StringUtils.uncapitalize(orgName).replace(CommonStandard.implBeanNameSuffix, "");	
	}
}
