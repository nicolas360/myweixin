package com.zhuc.myweixin.utils;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.google.common.collect.Maps;

/**
 * @title 		这个类既完成了PropertyPlaceholderConfigurer的任务,同时又提供了上下文properties访问的功能
 * @description	
 * @usage		
 * @copyright	Copyright 2011  SHCMCT Corporation. All rights reserved.
 * @company		上海中移通信技术工程有限公司
 * @author		hx_zhuc
 * @create		2012-10-15下午2:37:50
 */
public class DefinedPropertyConfigurer extends PropertyPlaceholderConfigurer {

	private static final Map<String, Object> ctxPropertiesMap = Maps.newHashMap();

	/**
	 * @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer#processProperties(org.springframework.beans.factory.config.ConfigurableListableBeanFactory,
	 *      java.util.Properties)
	 */
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			ctxPropertiesMap.put(keyStr, value);
		}
	}

	/**
	 * 根据name获取上下文属性的值
	 * 
	 * @param name
	 * @return
	 */
	public static String getContextProperty(String name) {
		Object value = ctxPropertiesMap.get(name);
		return null == value ? null : value.toString();
	}

}
