package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.pojo.User;

//UserMapper 接口,实现用户的增删改查
public interface UserMapper {

	//根据id查询用户
	User queryUserById(Long id);
	
	//查询所有的用户
	List<User> queryAll();
	
	//添加用户
	void insertUser(User user);
	
	//更新用户'
	void updataUser(User user);
	
	//删除用户
	void deleteUser(Long id);
}
