package com.situ.store.order.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.store.address.dao.AddressDao;
import com.situ.store.address.domain.Address;
import com.situ.store.base.domain.PageData;
import com.situ.store.cart.domain.Items;
import com.situ.store.indent.dao.IndentDao;
import com.situ.store.indent.domain.Indent;
import com.situ.store.order.dao.OrderDao;
import com.situ.store.order.domain.Order;
import com.situ.store.order.service.OrderService;
import com.situ.store.product.dao.ProductDao;
import com.situ.store.product.domain.Product;
import com.situ.store.user.domain.User;
import com.situ.store.util.PageUtils;

@Service
public class OrderServiceImpl implements OrderService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private IndentDao indentDao;
	@Autowired
	private AddressDao addressDao;
	
	@Override
	public Long orderSave(Order order, String createBy) {
		order.setActiveFlag(1);
		order.setCreateBy(createBy);
		order.setCreateDate(new Date());
		return orderDao.save(order);
	}

	@Override
	public List<Order> findByPage(Integer pageNo, Order searchOrder) {
		// limit查询数据开始的下标
		Integer firstResult = (pageNo - 1) * PageUtils.PAGE_ROWS;
		// limit查询数据 要显示的条数
		Integer maxResults = PageUtils.PAGE_ROWS;
		return orderDao.findByPage(searchOrder, firstResult, maxResults);
	}

	@Override
	public PageData buildPageData(Integer pageNo, Order searchOrder) {
		// 查询出数据总数
		Integer dataCount = orderDao.getCount(searchOrder);
		return PageUtils.buildPageData(dataCount, pageNo);
	}

	@Override
	public Order findOneById(Long rowId) {
		return orderDao.get(rowId);
	}

	@Override
	public Integer doUpdate(Order order, String createBy) {
		order.setUpdateBy(createBy);
		order.setUpdateDate(new Date());
		orderDao.update(order);
		return 1;
	}

	@Override
	public Integer doDelete(Long rowId) {
		orderDao.delete(rowId);
		return 1;
	}

	@Override
	public List<Order> findAll() {
		return orderDao.findAll();
	}

	@Override
	/**
	 * 保存订单信息
	 */
	public Long addOrder(User user, List<Items> list) {
		Indent indent = new Indent();//new一个订单实例
		String uuid = UUID.randomUUID().toString();//生成一个订单编号
		indent.setIndentCode(uuid);
		Long totalPrices = 0L;//购买商品总价
		for(Items items:list) {//遍历list集合，将每个商品信息取出
			Order order = new Order();//new一个订单列表的实例
			order.setIndentCode(uuid);
			String item_name = items.getItem_name();//商品的名字
//			通过商品名称查询商品信息
			Product product = productDao.getByName(item_name);
			order.setProductNum(product.getProductNum());
			order.setProductName(product.getProductName());
			Integer quantity = items.getQuantity();//购买的数量
			order.setBayCount(quantity);
			Integer productPrice = product.getProductPrice();//商品的单价
			Long price =(long) productPrice * quantity;
			totalPrices += price;
			order.setTotalPrices(price);
			order.setActiveFlag(1);
			order.setCreateBy(user.getUserCode());
			order.setCreateDate(new Date());
			orderDao.save(order);
		}
		indent.setUserId(user.getRowId());
		indent.setTotalPrices(totalPrices);
//		查询用户的默认地址信息
		Address address = addressDao.findDefault(user.getRowId());
		if(address != null) {//判断查询地址是否为空，不为空将第一个地址的id赋给订单地址
			indent.setAddressId(address.getRowId());
		} else {
			indent.setAddressId(null);
		}
		indent.setIndentState(0);//订单状态为未发货
		indent.setPayWay(1);//支付方式默认支付宝
		indent.setActiveFlag(1);
		indent.setCreateBy(user.getUserCode());
		indent.setCreateDate(new Date());
		indentDao.save(indent);
		
		
		
//		Order order = new Order();//new一个订单列表的实例
//		String uuid = UUID.randomUUID().toString();//生成一个订单编号
//		String productNum = "";//商品编号
//		String productInfo = "";//商品购买信息：商品-数量
//		Integer bayCount = 0;//购买商品总数量
//		Long totalPrices = 0L;//购买商品总价
//		for(Items items:list) {//遍历list集合，将每个商品信息取出
//			Indent indent = new Indent();//每次循环创建一个订单实例
//			String item_name = items.getItem_name();//商品的名字
////			通过商品名称查询商品信息
//			Product product = productDao.getByName(item_name);
//			Integer productPrice = product.getProductPrice();//商品的单价
//			productNum += product.getRowId()+"-";
//			Integer quantity = items.getQuantity();//购买的数量
//			productInfo += product.getProductName()+"-"+quantity+";";
//			bayCount += quantity;
//			Long price =(long) productPrice * quantity;
//			totalPrices += price;
//			
////			查询用户的默认地址信息
////			List<Address> addressList = addressDao.findByUserId(user.getRowId());
//			Address address = addressDao.findDefault(user.getRowId());
//			
//			indent.setIndentCode(uuid);
//			indent.setUserId(user.getRowId());
//			indent.setTotalPrices(price);
//			if(address != null) {//判断查询地址是否为空，不为空将第一个地址的id赋给订单地址
//				indent.setAddressId(address.getRowId());
//			} else {
//				indent.setAddressId(null);
//			}
//			indent.setIndentState(0);//订单状态为未发货
//			indent.setPayWay(1);//支付方式默认支付宝
//			indent.setActiveFlag(1);
//			indent.setCreateBy(user.getUserCode());
//			indent.setCreateDate(new Date());
//			indentDao.save(indent);
//		}
//		order.setIndentCode(uuid);
//		order.setProductNum(productNum);
//		order.setProductInfo(productInfo);
//		order.setBayCount(bayCount);
//		order.setTotalPrices(totalPrices);
//		order.setActiveFlag(1);
//		order.setCreateBy(user.getUserCode());
//		order.setCreateDate(new Date());
//		orderDao.save(order);
		
		
		return 1L;
	}

	
	
	@Override
	public List<Order> findByIndentCode(String indentCode) {
		return orderDao.findByIndentCode(indentCode);
	}



	

	

}
