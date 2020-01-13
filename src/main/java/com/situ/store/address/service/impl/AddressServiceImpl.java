package com.situ.store.address.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.store.address.dao.AddressDao;
import com.situ.store.address.domain.Address;
import com.situ.store.address.service.AddressService;
import com.situ.store.base.domain.PageData;
import com.situ.store.util.PageUtils;

@Service
public class AddressServiceImpl implements Serializable, AddressService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AddressDao addressDao;
	
	@Override
	public Long addressSave(Address address, String createBy) {
		address.setActiveFlag(1);
		address.setIfDefault(1);
		address.setCreateBy(createBy);
		address.setCreateDate(new Date());
		return addressDao.save(address);
	}

	@Override
	public List<Address> findByPage(Integer pageNo, Address searchAddress) {
		// limit查询数据开始的下标
		Integer firstResult = (pageNo - 1) * PageUtils.PAGE_ROWS;
		// limit查询数据 要显示的条数
		Integer maxResults = PageUtils.PAGE_ROWS;
		return addressDao.findByPage(searchAddress, firstResult, maxResults);
	}

	@Override
	public PageData buildPageData(Integer pageNo, Address searchAddress) {
		// 查询出数据总数
		Integer dataCount = addressDao.getCount(searchAddress);
		return PageUtils.buildPageData(dataCount, pageNo);
	}

	@Override
	public Address findOneById(Long rowId) {
		return addressDao.get(rowId);
	}

	@Override
	public Integer doUpdate(Address address, String createBy) {
		address.setUpdateBy(createBy);
		address.setUpdateDate(new Date());
		addressDao.update(address);
		return 1;
	}

	@Override
	public Integer doDelete(Long rowId) {
		addressDao.delete(rowId);
		return 1;
	}

	@Override
	public List<Address> findAll() {
		return addressDao.findAll();
	}

	@Override
	public List<Address> findByUserId(Long rowId) {
		return addressDao.findByUserId(rowId);
	}

	@Override
	public Integer doDefault(Long rowId) {
		addressDao.doDefault(rowId);
		addressDao.doDefaultOthers(addressDao.get(rowId));
		return 1;
	}


}
