package com.situ.store.address.service;

import java.util.List;

import com.situ.store.address.domain.Address;
import com.situ.store.base.domain.PageData;

public interface AddressService {

	Long addressSave(Address address, String createBy);

	List<Address> findByPage(Integer pageNo, Address searchAddress);

	PageData buildPageData(Integer pageNo, Address searchAddress);
//
//	Address findOneById(Long rowId);
//
//	Integer doUpdate(Address address, String createBy);
//
	Integer doDelete(Long rowId);

	List<Address> findAll();


}
