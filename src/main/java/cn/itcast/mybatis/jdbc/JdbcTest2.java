package cn.itcast.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class JdbcTest2 {
	
	//复习jdbc
	@Test
	public void jdbcTest() throws Exception{
		
		Connection connection = null;
		PreparedStatement statement = null;
		//5 执行sql
		ResultSet resultSet = null;
		try {
			//1  获取四大参数
			String driverClass = "com.mysql.jdbc.Driver";
			String url="jdbc:mysql://127.0.0.1:3306/heima07";
			String user="root";
			String password="123";
			
			//2  获取连接
			//加载驱动,获取连接
			Class.forName(driverClass);
			
			connection = DriverManager.getConnection(url,user,password);
			
			//3  编译sql,创建statement
			String sql = "SELECT * FROM tb_user WHERE id = ?";
			
			statement = connection.prepareStatement(sql);
			
			//4 为sql注入参数
			statement.setLong(1, 1L);
			
			resultSet = statement.executeQuery();
			
			//6 解析结果集
			while(resultSet.next()){
				System.out.println("id: " + resultSet.getLong("id"));
				System.out.println("age: " + resultSet.getInt("age"));
				System.out.println("name: " + resultSet.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//7 关闭资源
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
