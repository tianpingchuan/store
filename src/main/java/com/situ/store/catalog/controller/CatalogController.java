package com.situ.store.catalog.controller;

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

import com.situ.store.catalog.domain.Catalog;
import com.situ.store.catalog.service.CatalogService;
import com.situ.store.product.domain.Product;
import com.situ.store.product.service.ProductService;
import com.situ.store.util.ContextUtils;
import com.situ.store.util.PageUtils;

@Controller
@RequestMapping("/catalog")
public class CatalogController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Logger LOG = Logger.getLogger(CatalogController.class);
	private static final String PAGE_INDEX_CATALOG = "catalog/catalog_index";
	private static final String PAGE_LIST_CATALOG = "catalog/catalog_list";
	
	@Autowired
	private CatalogService catalogService;
	@Autowired
	private ProductService productService;
	
	/**
	 * @进用户管理首页
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_INDEX_CATALOG);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/add")
	/**
	 * @目录新增
	 * @param catalog
	 * @return
	 */
	public Long doAddCatalog(Catalog catalog) {
		String createBy = ContextUtils.getCreateBy();
		return catalogService.catalogSave(catalog,createBy);
	}
	
	/**
	 * @查询所有的记录
	 * @param pageNo 分页的页号
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllCatalog(@PathVariable Integer pageNo,Catalog searchCatalog, ModelAndView modelAndView) {
		LOG.debug("这是页面提交的查询条件"+searchCatalog);		
//		解决将提交问题为''设置成null，解决mapper-xml中的查询不用写！=''问题
		searchCatalog = PageUtils.buildSearchParam(searchCatalog);
//		LOG.debug(searchCatalog);
		// 要展示的列表数据
		modelAndView.addObject("catalogList", catalogService.findByPage(pageNo,searchCatalog));
		// 分页信息
		modelAndView.addObject("pageData", catalogService.buildPageData(pageNo,searchCatalog));
		modelAndView.setViewName(PAGE_LIST_CATALOG);
		return modelAndView;
	}
	
//	/**
//	 * @查询所有目录
//	 * @param modelAndView
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/find")
//	public List<Catalog> findAll(HttpSession session) {
//		List<Catalog> list = catalogService.findAll();
//		session.setAttribute("catalogList2", list);
//		return list;
//	}
	/**
	 * @查询所有目录
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/find")
	public ModelAndView findAll(ModelAndView modelAndView) {
		List<Catalog> list = catalogService.findAll();
		modelAndView.addObject("catalogList2", list);
		modelAndView.setViewName(PAGE_INDEX_CATALOG);
		return modelAndView;
	}
	
	/**
	 * @进修改
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/goupdate/{rowId}")
	public Catalog goupdate(@PathVariable("rowId")Long rowId) {
		return catalogService.findOneById(rowId);
	}
	
	@ResponseBody
	@RequestMapping("/doupdate")
	/**
	 * 执行用户修改
	 * @param role
	 * @return
	 */
	public Integer doUpdate(Catalog catalog) {
		String createBy = ContextUtils.getCreateBy();
		return catalogService.doUpdate(catalog,createBy);
	}
	
	/**
	 * 执行删除
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dodelete/{rowId}")
	public Integer doDelete(@PathVariable("rowId")Long rowId) {
		return catalogService.doDelete(rowId);
	}
	
	
	/**
	 * @判断name是否被使用fieldId=roleName&fieldValue=%E5%BC%A0%E4%B8%89&_=1576485199991
	 */
	@ResponseBody
	@RequestMapping("/checkCatalogName")
	public String checkUserName(String fieldId,String fieldValue,Long parentCatalogId) {
		return catalogService.checkCatalogName(fieldId,fieldValue,parentCatalogId);
	}
	
	@ResponseBody
	@RequestMapping("/findproduct/{rowId}")
	/**
	 * 跳转到目录商品详情,将商品信息加到session域
	 * @param modelAndView
	 * @param rowId
	 * @return
	 */
	public Integer goProduct(HttpSession session,@PathVariable("rowId") Long rowId) {
		List<Product> productList = productService.findByCatalogId(rowId);
		if(productList != null) {
			session.setAttribute("productCatalog", productList);
			return 1;
		}
		return 0;
	}
}
