/**
 * @Company:中享思途   
 * @Title:ShopLoginInterceptor.java 
 * @Author:wxinpeng   
 * @Date:2020年1月14日 上午9:19:47     
 */
package com.situ.store.interceptor;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.situ.store.util.ConfigUtils;

/** 
 * @ClassName:ShopLoginInterceptor 
 * @Description:(商城用户登录状态-拦截器)  
 */
public class ShopLoginInterceptor extends HandlerInterceptorAdapter implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String XHR_OBJECT_NAME = "XMLHttpRequest";// jQuery的Ajax请求的头文件的值
	private static final String HEADER_REQUEST_WITH = "x-requested-with";// jQuery 在发起Ajax请求时,携带的头文件信息
	private static final Integer AJAX_REQUEST_STATUS_CODE_NOLOGIN = 700;// Ajax请求的未登录返回的状态码
	private static final String PAGE_LOGIN = "buyer/index_user";
	private static String basePath;// 项目的base路径

	/**
	 * @Title: preHandle 
	 * @Description:(在业务处理器处理请求之前被调用)
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		// 判断如果当前用户为非登录状态,则提示跳到登录页面
		Object object = session.getAttribute(ConfigUtils.LOGIN_BUYER);
//		System.out.println("----------");
//		System.out.println("----------");
//		System.out.println("进入拦截器");
//		System.out.println("----------");
//		System.out.println("----------");
		if (object == null) {
			// 如果是AJAX的请求
			if (isAjaxRequest(request)) {
				// 设置响应的状态吗为700,对应重写的jQuery的ajax方法
				response.setStatus(AJAX_REQUEST_STATUS_CODE_NOLOGIN);
			} else {// 不是AJAX请求
				response.sendRedirect(getBasePath(request) + PAGE_LOGIN);
			}
			//return false 在此拦截器直接返回，不再向下执行。
			return false;
		}
		//如果代码能执行到这里，则让请求通过这个拦截器，继续向下执行。
		return super.preHandle(request, response, handler);
	}

	/**
	 * @Title: isAjaxRequest
	 * @Description:(判断是否为Ajax请求)
	 * @param request
	 * @return true:是;false:不是;
	 */
	private boolean isAjaxRequest(HttpServletRequest request) {
		String jQueryXHRObjectName = request.getHeader(HEADER_REQUEST_WITH);
		if (jQueryXHRObjectName != null && XHR_OBJECT_NAME.equals(jQueryXHRObjectName)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @Description:属性 basePath 的get方法
	 * @return basePath
	 */
	private String getBasePath(HttpServletRequest request) {
		// 如果base没有值,则先取值再返回,否则直接返回。
		if (basePath == null || "".equals(basePath)) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(request.getScheme()).append("://").append(request.getServerName()).append(":").append(request.getServerPort()).append(request.getContextPath()).append("/");
			basePath = buffer.toString();
		}
		return basePath;
	}
}
