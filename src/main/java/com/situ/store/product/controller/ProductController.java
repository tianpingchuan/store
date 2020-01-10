package com.situ.store.product.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.store.catalog.domain.Catalog;
import com.situ.store.catalog.service.CatalogService;
import com.situ.store.product.domain.Product;
import com.situ.store.product.service.ProductService;
import com.situ.store.util.ContextUtils;
import com.situ.store.util.MultipartUtils;
import com.situ.store.util.PageUtils;

@Controller
@RequestMapping("/product")
public class ProductController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger(ProductController.class);
	private static final String PAGE_INDEX_PRODUCT = "product/product_index";
	private static final String PAGE_LIST_PRODUCT = "product/product_list";
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CatalogService catalogService;
	
	/**
	 * @进商品管理首页
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView goIndex(ModelAndView modelAndView) {
//		将目录信息查询出来
		modelAndView.addObject("catalogList3", catalogService.findAllByParentId(-1L));
		modelAndView.addObject("catalogProductList", catalogService.findAllByParentId(1L));
		modelAndView.setViewName(PAGE_INDEX_PRODUCT);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/upload")
	/**
	 * @商品新增
	 * @param product
	 * @param request
	 * @return
	 */
	public Long doAdd(Product product, HttpServletRequest request) {
		String createBy = ContextUtils.getCreateBy();
		return productService.productSave(product,request,createBy);
	}
	

	
	/**
	 * @查询所有的记录
	 * @param pageNo 分页的页号
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllProduct(@PathVariable Integer pageNo,Product searchProduct, ModelAndView modelAndView) {
		LOG.debug("这是页面提交的查询条件"+searchProduct);		
//		解决将提交问题为''设置成null，解决mapper-xml中的查询不用写！=''问题
		searchProduct = PageUtils.buildSearchParam(searchProduct);
//		LOG.debug(searchProduct);
		// 要展示的列表数据
		modelAndView.addObject("ProductList", productService.findByPage(pageNo,searchProduct));
		// 分页信息
		modelAndView.addObject("pageData", productService.buildPageData(pageNo,searchProduct));
		modelAndView.setViewName(PAGE_LIST_PRODUCT);
		return modelAndView;
	}
	
	/**
	 * @进修改
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/goupdate/{rowId}")
	public Product goupdate(@PathVariable("rowId")Long rowId) {
		return productService.findOneById(rowId);
	}
	
	@ResponseBody
	@RequestMapping("/doupdate")
	/**
	 * 执行用户修改
	 * @param role
	 * @return
	 */
	public Integer doUpdate(Product product, HttpServletRequest request) {
		String createBy = ContextUtils.getCreateBy();
		return productService.doUpdate(product,request,createBy);
	}
	
	/**
	 * 执行删除
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dodelete/{rowId}")
	public Integer doDelete(@PathVariable("rowId")Long rowId) {
		return productService.doDelete(rowId);
	}
	
	/**
	 * 执行下架
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/soldout/{rowId}")
	public Integer doLock(@PathVariable("rowId")Long rowId) {
		return productService.doOut(rowId);
	}
	/**
	 * 执行上架
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/putaway/{rowId}")
	public Integer doNoLock(@PathVariable("rowId")Long rowId) {
		return productService.doPut(rowId);
	}
	
	/**
	 * @判断name是否被使用fieldId=roleName&fieldValue=%E5%BC%A0%E4%B8%89&_=1576485199991
	 */
	@ResponseBody
	@RequestMapping("/checkProductName")
	public String checkProductName(String fieldId,String fieldValue) {
		return productService.checkProductName(fieldId,fieldValue);
	}
	/**
	 * @判断name是否被使用fieldId=roleName&fieldValue=%E5%BC%A0%E4%B8%89&_=1576485199991
	 */
	@ResponseBody
	@RequestMapping("/checkProductNum")
	public String checkProductNum(String fieldId,String fieldValue) {
		return productService.checkProductNum(fieldId,fieldValue);
	}
	
	/**
	 * @根据传进的商品编号查询商品
	 * @param productNum
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findNum/{productNum}")
	public Product findNum(@PathVariable("productNum")String productNum) {
		return productService.findByNum(productNum);
	}
	
	/**
	 * 
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/gochange/{parentCatalogId}")
	public ModelAndView goSelectcity2(ModelAndView modelAndView,@PathVariable Long parentCatalogId) {
		List<Catalog> catalogProductsList = catalogService.findAllByParentId(parentCatalogId);
		modelAndView.addObject("catalogProductsList", catalogProductsList);
		modelAndView.setViewName("product/product_catalog");
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/noteupload")
	public String doUplaod4SummerNote(Product product,HttpServletRequest request) {
		String realPath = request.getServletContext().getRealPath("/");
		return MultipartUtils.writeFile(product.getMulitFile(),realPath);
	}
}
