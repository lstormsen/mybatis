package cn.itcast.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.itcast.mybatis.pojo.User;

public class MybaitsTest {

	public static void main(String[] args) throws Exception {
		
		//指定全局配置文件路径,是以classpath来指定
		String resource = "mybatis-config.xml";
		//加载配置文件,形成流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//通过流读取配置文件,形成SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//获取session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//执行statement.通过Mapper.xml文件的namespace + statement的ID来确认
		User user = sqlSession.selectOne("userMapper.queryUserById",1L);
	
		System.out.println(user);
	}

}
