package com.situ.store.indent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.store.indent.domain.Indent;

@Repository
public interface IndentDao {

	Long save(Indent indent);

	List<Indent> findByPage(@Param("searchIndent") Indent searchIndent, @Param("firstResult") Integer firstResult,@Param("maxResults") Integer maxResults);

	Integer getCount(@Param("searchIndent") Indent searchIndent);
	
	void update(Indent indent);

	void delete(Long rowId);
	
	List<Indent> findAll();
	
	Indent get(Long rowId);

	Indent getByCode(String indentCode);


}
