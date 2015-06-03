/**
 * 
 */
package com.zhuc.myweixin.utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

import com.google.common.base.Strings;

/**
 * @title 		
 * @description	增加对不需要的路径的过滤
 * @usage		
 * @copyright	Copyright 2011  SHCMCT Corporation. All rights reserved.
 * @company		上海中移通信技术工程有限公司
 * @author		yaoqiang
 * @create		2013-4-25 下午8:07:08
 */
public class EntityManagerInViewExtendFilter extends OpenEntityManagerInViewFilter {
	
	private String exceptionUrl ;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (!Strings.isNullOrEmpty(exceptionUrl)){
			String url = request.getRequestURI() ;
			String context = request.getContextPath() ;
			if (url.startsWith(context+exceptionUrl)){
				filterChain.doFilter(request, response);
			}else {
				super.doFilterInternal(request, response, filterChain);
			}
		}else {
			super.doFilterInternal(request, response, filterChain);
		}
	}


	public void setExceptionUrl(String exceptionUrl) {
		this.exceptionUrl = exceptionUrl;
	}


	
}
