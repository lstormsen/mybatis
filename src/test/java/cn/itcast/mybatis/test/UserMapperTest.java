package cn.itcast.mybatis.test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.annotations.Param;
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
		
		//添加后尝试查看新增用户的id
		System.out.println("id: " + user.getId());
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
	
	@Test
	public void testQueryUserByUsernameAndpassword(){
		//通过用户名和密码 进行查询
		User user = userMapper.queryUserByUsernameAndPassword("liuyan", "123456");
		System.out.println(user);
		
	}
	
	@Test
	public void testqueryMaleUserByName(){
		//查询男性用户,如果姓名中有内容,则进行模糊查询
		List<User> list = userMapper.queryMaleUserByName("");
		
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	//查询所有的用户,并按顺序排列
	//orderType: 0,按照年龄升序; 1 按照年龄降序; 默认按照ID升序
	@Test
	public void testQueryAllUserAndSort(){
		List<User> list = userMapper.queryAllUserAndSort(-1);
		
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	//根据姓名和年龄条件查询用户
	@Test
	public void testQueryUserByUsernameAndAge(){
		List<User> list =  userMapper.queryUserByUsernameAndAge("岩", 28);
		for (User user : list) {
			System.out.println(user);
		}
		
	}
	
	//修改用户,判断字段是否需要修改
	@Test
	public void testUpdate(){
		User user = new User();
		user.setId(15L);
		user.setUserName("meimei");
		user.setPassword("123456");
		user.setName("霉霉");
		user.setSex(2);
		user.setAge(35);
		
		//修改
		userMapper.updata(user);
		
	}

}
