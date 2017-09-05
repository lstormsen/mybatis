package cn.itcast.mybatis.dao;

import java.util.List;

import cn.itcast.mybatis.pojo.User;

/**
 * 说明：user的接口,用于用户的增删改查
 * @author 黑马.xiaoli
 * @version 1.0
 * @date 2017年9月4日
 */
public interface UserDao {
	
	//根据id查询用户
	User queryUserById(Long id);
	
	//查询所有的用户
	List<User> queryAll();
	
	//添加用户
	void insertUser(User user);
	
	//修改用户
	void updataUser(User user);
	
	//根据id删除用户
	void deleteUserById(Long id);

}
