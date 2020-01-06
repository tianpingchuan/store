package com.situ.store.order.controller;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.store.indent.domain.Indent;
import com.situ.store.indent.service.IndentService;
import com.situ.store.order.domain.Order;
import com.situ.store.order.service.OrderService;
import com.situ.store.product.domain.Product;
import com.situ.store.product.service.ProductService;
import com.situ.store.util.ContextUtils;
import com.situ.store.util.PageUtils;

@Controller
@RequestMapping("/order")
public class OrderController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger(OrderController.class);
	private static final String PAGE_INDEX_ORDER = "order/order_index";
	private static final String PAGE_LIST_ORDER = "order/order_list";

	@Autowired
	private IndentService indentService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	
	
	/**
	 * @进用户管理首页
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		List<Indent> indentOrderList = indentService.findAll();
		List<Product> productOrderList = productService.findAll();
		modelAndView.addObject("indentOrderList", indentOrderList);
		modelAndView.addObject("productOrderList", productOrderList);
		modelAndView.setViewName(PAGE_INDEX_ORDER);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/add")
	/**
	 * @目录新增
	 * @param order
	 * @return
	 */
	public Long doAddorder(Order order) {
		String createBy = ContextUtils.getCreateBy();
		return orderService.orderSave(order,createBy);
	}
	
	/**
	 * @查询所有的记录
	 * @param pageNo 分页的页号
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllorder(@PathVariable Integer pageNo,Order searchOrder, ModelAndView modelAndView) {
		LOG.debug("这是页面提交的查询条件"+searchOrder);		
//		解决将提交问题为''设置成null，解决mapper-xml中的查询不用写！=''问题
		searchOrder = PageUtils.buildSearchParam(searchOrder);
		// 要展示的列表数据
		modelAndView.addObject("orderList", orderService.findByPage(pageNo,searchOrder));
		// 分页信息
		modelAndView.addObject("pageData", orderService.buildPageData(pageNo,searchOrder));
		modelAndView.setViewName(PAGE_LIST_ORDER);
		return modelAndView;
	}
	
	/**
	 * @进修改
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/goupdate/{rowId}")
	public Order goupdate(@PathVariable("rowId")Long rowId) {
		return orderService.findOneById(rowId);
	}
	
	@ResponseBody
	@RequestMapping("/doupdate")
	/**
	 * 执行用户修改
	 * @param role
	 * @return
	 */
	public Integer doUpdate(Order order) {
		String createBy = ContextUtils.getCreateBy();
		return orderService.doUpdate(order,createBy);
	}
	
	/**
	 * 执行删除
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dodelete/{rowId}")
	public Integer doDelete(@PathVariable("rowId")Long rowId) {
		return orderService.doDelete(rowId);
	}
}
