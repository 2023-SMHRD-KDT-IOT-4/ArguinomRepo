package com.smhrd.bicycle.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.bicycle.model.User;

@Mapper
public interface UserMapper {
	
	// 회원가입
	
	// 로그인
	@Select("select * from user_info where user_id=#{user_id} and user_pw=#{user_pw}")
	public User login(User u);
	

	
}
