package cn.itcast.mybatis.test;


import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.dao.impl.UserDAOImpl;
import cn.itcast.mybatis.pojo.User;

//测试增删改查功能
public class UserDAOImplTest {

	private UserDao userDAO;
	
	
	@Before
	public void setUp() throws Exception {
		//设置资源路径
		String resource = "mybatis-config.xml";
		//获取输入流,关联配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//读取设置,获取session工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//获取session,同时打开自动提交,每次操作都是一个新的事务
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		//传入sqlSession对象,构建DAO对象
		this.userDAO = new UserDAOImpl(sqlSession);
		
	}

	@Test
	public void testQueryUserById() {
		//根据id查询用户
		User user = userDAO.queryUserById(5L);
		System.out.println(user);
	}

	@Test
	public void testQueryAll() {
		//查询所有用户
		List<User> list = userDAO.queryAll();
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testInsertUser() {
		//插入用户
		User user = new User();
		user.setName("林志玲");
		user.setAge(20);
		user.setSex(2);
		user.setNote("声音很嗲..");
		
		userDAO.insertUser(user);
	}

	@Test
	public void testUpdataUser() {
		//更新用户(先查再更新)
		User user = userDAO.queryUserById(1L);
		user.setAge(100);
		
		//更新用户
		userDAO.updataUser(user);
		
	}

	@Test
	public void testDeleteUserById() {
		//根据id删除用户
		userDAO.deleteUserById(13L);
	}

}
