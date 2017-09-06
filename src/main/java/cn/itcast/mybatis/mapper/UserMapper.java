package cn.itcast.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;

import cn.itcast.mybatis.pojo.User;

//UserMapper 接口,实现用户的增删改查
public interface UserMapper {

	//根据id查询用户
	User queryUserById(Long id);
	
	//查询所有的用户
	List<User> queryAll();
	
	//添加用户
	Integer insertUser(User user);
	
	//更新用户'
	void updataUser(User user);
	
	//删除用户
	void deleteUser(Long id);
	
	//根据用户名和密码进行查询
	//User queryUserByUsernameAndPassword(String userName,String password);
	//使用param注解的形式践行取值
	User queryUserByUsernameAndPassword(
			@Param("userName")String userName,
			@Param("password")String password
			);
	
	//查询男性用户,如果姓名不为空,对姓名进行模糊查询
	@Test
	List<User> queryMaleUserByName(@Param("name")String name);
	
	//查询所有的用户,并按顺序排列
	//orderType: 0,按照年龄升序; 1 按照年龄降序; 默认按照ID升序
	List<User> queryAllUserAndSort(@Param("orderType")Integer orderType);
	
	//根据姓名和年龄来查询用户
	List<User> queryUserByUsernameAndAge(
			@Param("name")String name,
			@Param("age")Integer age
			);
	
	//修改用户
	void updata(User user);
	
	//根据id查询多个用户
	List<User> queryUsersByIds(@Param("ids")List<Long> ids);	//这里可以是collection或者数组
	
	
}
