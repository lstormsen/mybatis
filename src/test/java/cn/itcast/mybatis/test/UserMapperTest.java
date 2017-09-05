package cn.itcast.mybatis.test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.pojo.User;

public class UserMapperTest {

	private UserMapper userMapper;
	
	@Before
	public void setUp() throws Exception { 
		//1 获取资源路径
		String resource= "mybatis-config.xml";
		//2 获取输入流,关联配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//3 读取设置,获得session工厂,第二个参数: 指定使用的环境的名称
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//4 获取session,同时开启自动提交,每一个操作都是一个事务
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		//获取UserMapper的实现类,通过mybatis获取
		userMapper = sqlSession.getMapper(UserMapper.class);
	}

	@Test
	public void testQueryById() {
		//通过id查询用户
		User user = userMapper.queryUserById(8L);
		System.out.println(user);
		
	}

	@Test
	public void testQueryAll() {
		//查询所有的用户
		List<User> list =  userMapper.queryAll();
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testInsertUser() {
		User user = new User();
		user.setAge(20);
		user.setName("林志玲");
		user.setNote("没有代表作...");
		
		//添加用户
		userMapper.insertUser(user);
	}

	@Test
	public void testUpdataUser() {
		//修改用户
		//先查再改
		User user = userMapper.queryUserById(1L);
		user.setAge(30);
		
		userMapper.updataUser(user);
		
	}

	@Test
	public void testDeleteUser() {
		//通过id删除用户
		userMapper.deleteUser(13L);
	}

}
