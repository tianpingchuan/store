package com.situ.store.cart.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.store.cart.domain.Cart;
import com.situ.store.cart.domain.CartParam;
import com.situ.store.cart.domain.Items;
import com.situ.store.cart.service.CartService;
import com.situ.store.order.service.OrderService;
import com.situ.store.product.domain.Product;
import com.situ.store.product.service.ProductService;
import com.situ.store.user.domain.User;
import com.situ.store.user.service.UserService;
import com.situ.store.util.ConfigUtils;
import com.situ.store.util.ContextUtils;
import com.situ.store.util.PageUtils;

@Controller
@RequestMapping("/cart")
public class CartController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger(CartController.class);
	private static final String PAGE_INDEX_CART = "cart/cart_index";
	private static final String PAGE_LIST_CART = "cart/cart_list";

	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;

	
	
	/**
	 * @进用户管理首页
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		List<User> userCartList = userService.findAll();
		List<Product> productCartList = productService.findAll();
		modelAndView.addObject("userCartList", userCartList);
		modelAndView.addObject("productCartList", productCartList);
		modelAndView.setViewName(PAGE_INDEX_CART);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/add")
	/**
	 * @目录新增
	 * @param Cart
	 * @return
	 */
	public Long doAddCart(Cart cart) {
		String createBy = ContextUtils.getCreateBy();
		return cartService.CartSave(cart,createBy);
	}
	
	/**
	 * @查询所有的记录
	 * @param pageNo 分页的页号
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllCart(@PathVariable Integer pageNo,Cart searchCart, ModelAndView modelAndView) {
		LOG.debug("这是页面提交的查询条件"+searchCart);		
//		解决将提交问题为''设置成null，解决mapper-xml中的查询不用写！=''问题
		searchCart = PageUtils.buildSearchParam(searchCart);
		// 要展示的列表数据
		modelAndView.addObject("cartList", cartService.findByPage(pageNo,searchCart));
		// 分页信息
		modelAndView.addObject("pageData", cartService.buildPageData(pageNo,searchCart));
		modelAndView.setViewName(PAGE_LIST_CART);
		return modelAndView;
	}
	
	/**
	 * @进修改
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/goupdate/{rowId}")
	public Cart goupdate(@PathVariable("rowId")Long rowId) {
		return cartService.findOneById(rowId);
	}
	
	@ResponseBody
	@RequestMapping("/doupdate")
	/**
	 * 执行用户修改
	 * @param role
	 * @return
	 */
	public Integer doUpdate(Cart cart) {
		String createBy = ContextUtils.getCreateBy();
		return cartService.doUpdate(cart,createBy);
	}
	
	/**
	 * 执行删除
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dodelete/{rowId}")
	public Integer doDelete(@PathVariable("rowId")Long rowId) {
		return cartService.doDelete(rowId);
	}
	
	@ResponseBody
	@RequestMapping("/shopping")
	public Integer shopping(CartParam cartList,HttpSession session) {
		Object object = session.getAttribute(ConfigUtils.LOGIN_BUYER);
		User user = (User)object;
		if (user != null) {
			List<Items> list = cartList.getCartList();
			orderService.addOrder(user,list);
		}
		return 1;
	}
}
