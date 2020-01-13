package com.situ.store.address.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.store.address.domain.Address;

@Repository
public interface AddressDao {
	
	Long save(Address address);

	List<Address> findByPage(@Param("searchAddress") Address searchAddress, @Param("firstResult") Integer firstResult,@Param("maxResults") Integer maxResults);

	Integer getCount(@Param("searchAddress") Address searchAddress);
	
	Address get(Long rowId);

	void update(Address address);

	void delete(Long rowId);

	List<Address> findAll();
	
	List<Address> findByUserId(Long rowId);

	void doDefault(Long rowId);

	void doDefaultOthers(Address address);

	Address findDefault(Long rowId);
}
