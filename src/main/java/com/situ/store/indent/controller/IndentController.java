package com.situ.store.indent.controller;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.store.address.domain.Address;
import com.situ.store.address.service.AddressService;
import com.situ.store.indent.domain.Indent;
import com.situ.store.indent.service.IndentService;
import com.situ.store.user.domain.User;
import com.situ.store.user.service.UserService;
import com.situ.store.util.ContextUtils;
import com.situ.store.util.PageUtils;

@Controller
@RequestMapping("/indent")
public class IndentController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static Logger LOG = Logger.getLogger(IndentController.class);
	private static final String PAGE_INDEX_INDENT = "indent/indent_index";
	private static final String PAGE_LIST_INDENT = "indent/indent_list";

	@Autowired
	private IndentService indentService;
	@Autowired
	private UserService userService;
	@Autowired
	private AddressService addressService;
	
	
	/**
	 * @进用户管理首页
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		List<User> userIndentList = userService.findAll();
		List<Address> addressIndentList = addressService.findAll();
		modelAndView.addObject("userIndentList", userIndentList);
		modelAndView.addObject("addressIndentList", addressIndentList);
		modelAndView.setViewName(PAGE_INDEX_INDENT);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/add")
	/**
	 * @目录新增
	 * @param Indent
	 * @return
	 */
	public Long doAddIndent(Indent indent) {
		String createBy = ContextUtils.getCreateBy();
		return indentService.IndentSave(indent,createBy);
	}
	
	/**
	 * @查询所有的记录
	 * @param pageNo 分页的页号
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllIndent(@PathVariable Integer pageNo,Indent searchIndent, ModelAndView modelAndView) {
		LOG.debug("这是页面提交的查询条件"+searchIndent);		
//		解决将提交问题为''设置成null，解决mapper-xml中的查询不用写！=''问题
		searchIndent = PageUtils.buildSearchParam(searchIndent);
//		LOG.debug(searchIndent);
		// 要展示的列表数据
		modelAndView.addObject("IndentList", indentService.findByPage(pageNo,searchIndent));
		// 分页信息
		modelAndView.addObject("pageData", indentService.buildPageData(pageNo,searchIndent));
		modelAndView.setViewName(PAGE_LIST_INDENT);
		return modelAndView;
	}
	
	/**
	 * @进修改
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/goupdate/{rowId}")
	public Indent goupdate(@PathVariable("rowId")Long rowId) {
		return indentService.findOneById(rowId);
	}
	
	@ResponseBody
	@RequestMapping("/doupdate")
	/**
	 * 执行用户修改
	 * @param role
	 * @return
	 */
	public Integer doUpdate(Indent indent) {
		String createBy = ContextUtils.getCreateBy();
		return indentService.doUpdate(indent,createBy);
	}
	
	/**
	 * 执行删除
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dodelete/{rowId}")
	public Integer doDelete(@PathVariable("rowId")Long rowId) {
		return indentService.doDelete(rowId);
	}
	
	/**
	 * @判断name是否被使用fieldId=roleName&fieldValue=%E5%BC%A0%E4%B8%89&_=1576485199991
	 */
	@ResponseBody
	@RequestMapping("/checkIndentCode")
	public String checkIndentCode(String fieldId,String fieldValue) {
		return indentService.checkCatalogName(fieldId,fieldValue);
	}
	
	
}
