package com.smhrd.bicycle.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.smhrd.bicycle.model.User;

@Mapper
public interface UserMapper {
	
	@Insert("insert into user_info(user_id,user_pw,user_birthdate,user_name,user_profile_img,joined_at,user_role) values(#{user_id},#{user_pw},#{user_birthdate},#{user_name},#{user_profile_img},1,'U')")
	public int join(User u);
	
}
