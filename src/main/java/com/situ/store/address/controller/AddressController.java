package com.situ.store.address.controller;

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
import com.situ.store.address.domain.TheAddress;
import com.situ.store.address.service.AddressService;
import com.situ.store.address.service.TheAddressService;
import com.situ.store.user.domain.User;
import com.situ.store.user.service.UserService;
import com.situ.store.util.ContextUtils;
import com.situ.store.util.PageUtils;

@Controller
@RequestMapping("/address")
public class AddressController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger(AddressController.class);
	private static final String PAGE_INDEX_ADDRESS = "address/address_index";
	private static final String PAGE_LIST_ADDRESS = "address/address_list";
	private static final String PAGE_CITY= "address/address_city";
	private static final String PAGE_AREA= "address/address_area";
	private static final String PAGE_PERSONAL_ADDRESS = "address/personal_address";
	
	@Autowired
	private AddressService addressService;
	@Autowired
	private UserService userService;
	@Autowired
	private TheAddressService theAddressService;
	
	/**
	 * @进用户管理首页
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		List<User> useraddressList = userService.findAll();
		List<TheAddress> theProvinceList = theAddressService.findAllProvince();
		modelAndView.addObject("useraddressList", useraddressList);
		modelAndView.addObject("theProvinceList", theProvinceList);
		modelAndView.setViewName(PAGE_INDEX_ADDRESS);
		return modelAndView;
	}
	
	/**
	 * @查找北京市下面的地区
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/findbeijing")
	public ModelAndView goCity(ModelAndView modelAndView) {
		List<TheAddress> theCityList = theAddressService.findBeiJing();
		modelAndView.addObject("theCityList", theCityList);
		modelAndView.setViewName(PAGE_CITY);
		return modelAndView;
	}
	/**
	 * @查找北京市下面的市辖区
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/findbeijingarea")
	public ModelAndView goArea(ModelAndView modelAndView) {
		List<TheAddress> theAreaList = theAddressService.findBeiJingArea();
		modelAndView.addObject("theAreaList", theAreaList);
		modelAndView.setViewName(PAGE_AREA);
		return modelAndView;
	}
	
	/**
	 * 
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/gochange1/{provinceCode}")
	public ModelAndView goSelectcity(ModelAndView modelAndView,@PathVariable Long provinceCode) {
		List<TheAddress> theCityList = theAddressService.findCity(provinceCode);
		modelAndView.addObject("theCityList", theCityList);
		modelAndView.setViewName(PAGE_CITY);
		return modelAndView;
	}
	/**
	 * 
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/gochange2/{cityCode}")
	public ModelAndView goSelectcity2(ModelAndView modelAndView,@PathVariable Long cityCode) {
		List<TheAddress> theAreaList = theAddressService.findCity(cityCode);
		modelAndView.addObject("theAreaList", theAreaList);
		modelAndView.setViewName(PAGE_AREA);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/add")
	/**
	 * @地址新增
	 * @param catalog
	 * @return
	 */
	public Long doAddAddress(Address address) {
		String createBy = ContextUtils.getCreateBy();
		return addressService.addressSave(address,createBy);
	}
	
	/**
	 * @查询所有的记录
	 * @param pageNo 分页的页号
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllCatalog(@PathVariable Integer pageNo,Address searchAddress, ModelAndView modelAndView) {
		LOG.debug("这是页面提交的查询条件"+searchAddress);		
//		解决将提交问题为''设置成null，解决mapper-xml中的查询不用写！=''问题
		searchAddress = PageUtils.buildSearchParam(searchAddress);
//		LOG.debug(searchAddress);
		// 要展示的列表数据
		modelAndView.addObject("addressList", addressService.findByPage(pageNo,searchAddress));
		// 分页信息
		modelAndView.addObject("pageData", addressService.buildPageData(pageNo,searchAddress));
		modelAndView.setViewName(PAGE_LIST_ADDRESS);
		return modelAndView;
	}
	/**
	 * @进修改
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/goupdate/{rowId}")
	public Address goupdate(@PathVariable("rowId")Long rowId) {
		return addressService.findOneById(rowId);
	}
	
	@ResponseBody
	@RequestMapping("/doupdate")
	/**
	 * 执行用户修改
	 * @param role
	 * @return
	 */
	public Integer doUpdate(Address address) {
		String createBy = ContextUtils.getCreateBy();
		return addressService.doUpdate(address,createBy);
	}
	
	/**
	 * 执行删除
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dodelete/{rowId}")
	public Integer doDelete(@PathVariable("rowId")Long rowId) {
		return addressService.doDelete(rowId);
	}
	
	/**
	 * 设置默认地址
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dodefault/{rowId}")
	public Integer doDefault(@PathVariable("rowId")Long rowId) {
		return addressService.doDefault(rowId);
	}
	
	/**
	 * 进个人用户的地址管理
	 * @param rowId
	 * @return
	 */
	@RequestMapping("/index/{rowId}")
	public ModelAndView goPersonalAddress(ModelAndView modelAndView,@PathVariable("rowId")Long rowId) {
		List<TheAddress> theProvinceList = theAddressService.findAllProvince();
		modelAndView.addObject("theProvinceList", theProvinceList);
		modelAndView.setViewName(PAGE_PERSONAL_ADDRESS);
		return modelAndView;
	}
	
}
