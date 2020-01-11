package com.situ.store.base.controller.user;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.situ.store.catalog.service.CatalogService;
import com.situ.store.product.service.ProductService;
import com.situ.store.user.domain.User;
import com.situ.store.user.service.UserService;
import com.situ.store.util.ConfigUtils;

@Controller
public class BuyerController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String BUYER_INDEX = "buyer/index_user";
	private static final String GO_MENS = "buyer/mens";
	private static final String GO_SINGLE = "buyer/single";
	
	@Autowired
	private UserService userService;
	@Autowired
	private CatalogService catalogService;
	@Autowired
	private ProductService productService;
	
	/**
	 * @进商城主页
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping(path= {"/","/index"})
	public ModelAndView goLoginIn(ModelAndView modelAndView, HttpSession session,
			@CookieValue(value = ConfigUtils.COOKIE_BUYER_NAME, required = false) String remember) {
		if (remember != null) {
			String[] array = remember.split(":");
			String userCode = array[0];
			Long rowId = Long.parseLong(array[1]);
//			使用usercode和id到数据库中查询用户实例
			User user = userService.findUserByCodeAndId(userCode, rowId);
			if (user != null) {// 判断有这个用户
//				满足用户登录状态
//				有登陆用户将用户信息放入session
				session.setAttribute(ConfigUtils.LOGIN_BUYER, user);
				userService.doUpdateLogin(user);
			}
		}
		
		modelAndView.addObject("catalogParentList", catalogService.findAllByParentId(-1L));
		modelAndView.addObject("productList", productService.findAll());
		modelAndView.addObject("catalogChildList", catalogService.findAllChild());
		modelAndView.setViewName(BUYER_INDEX);
		return modelAndView;
	}
	
	/**
	 * @进男装页面
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/mens")
	public ModelAndView goMens(ModelAndView modelAndView) {
		modelAndView.addObject("catalogParentList", catalogService.findAllByParentId(-1L));
		modelAndView.addObject("productList", productService.findAll());
		modelAndView.addObject("catalogChildList", catalogService.findAllChild());
		modelAndView.setViewName(GO_MENS);
		return modelAndView;
	}
	
	
	/**
	 * @进购买页面
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/single")
	public ModelAndView goSingle(ModelAndView modelAndView) {
		modelAndView.addObject("catalogParentList", catalogService.findAllByParentId(-1L));
		modelAndView.addObject("productList", productService.findAll());
		modelAndView.addObject("catalogChildList", catalogService.findAllChild());
		modelAndView.setViewName(GO_SINGLE);
		return modelAndView;
	}
}
