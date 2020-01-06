package com.situ.store.user.service;

import java.util.List;

import com.situ.store.base.domain.PageData;
import com.situ.store.user.domain.User;

public interface UserService {
	
	Long userSave1(User user);
	
	Long userSave2(User user, String createBy);
	
	Long userSave3(User user);
	
	User login(User user);
	
	PageData buildPageData(Integer pageNo, User searchUser);

	List<User> findByPage(Integer pageNo, User searchUser);
	
	User findOneById(Long rowId);

	Integer doUpdate(User user, String createBy);

	Integer doDelete(Long rowId);
	
	void initAdmin();

	String checkUserName(String fieldId, String fieldValue);

	String checkUserCode(String fieldId, String fieldValue);

	Integer doLock(Long rowId);

	Integer doNoLock(Long rowId);

	User findUserByCodeAndId(String userCode, Long rowId);
	
	List<User> findAll();


}
