package cn.itcast.mybatis.jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;



public class JdbcTest {

	//回顾jdbc代码
	@Test
	public void testJDBC() throws Exception{
		
		//获取连接
		Connection connection = null;
		//编写SQL,形成statement 
		PreparedStatement statement = null;
		//5 执行sql
		ResultSet resultSet = null;
		try {
			//1 准备四大参数
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/heima07";
			String user = "root";
			String password = "123";
			
			//2 获取连接
			//加载驱动
			Class.forName(driverClass);
			
			connection = DriverManager.getConnection(url,user,password);
			
			//3 编译sql,获取statement
			String sql ="SELECT * FROM tb_user WHERE id = ?";
			statement = connection.prepareStatement(sql);
			 
			//4 设置sql参数,因为id为long类型所以使用setLong方法
			 //索引从1开始
			 statement.setLong(1, 1L);
			 
			resultSet = statement.executeQuery();
			 
			//6 解析结果集,封装成对象
			 while(resultSet.next()){
				 System.out.println("id :" + resultSet.getLong("id"));
				 System.out.println("username :" + resultSet.getString("user_name"));
				 System.out.println("password :" + resultSet.getString("password"));
				 System.out.println("age: " + resultSet.getInt("age"));
				 System.out.println("name: " + resultSet.getString("name"));
				 
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//7 释放资源
			 try {
				 if(resultSet != null)
					 resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			 try {
				 if(statement != null)
					 statement.close();
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
			 try {
				 if(connection != null)
					 connection.close();
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		}
		
	}
	

}
