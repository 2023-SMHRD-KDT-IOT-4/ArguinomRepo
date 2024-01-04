package com.smhrd.bicycle.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.smhrd.bicycle.model.User;

@Mapper
public interface PageMapper {
	
	@Insert("insert into test values (#{id}, #{pw})")
	public int insert(User user);
}
