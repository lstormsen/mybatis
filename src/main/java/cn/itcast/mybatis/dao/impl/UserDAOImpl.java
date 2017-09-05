package cn.itcast.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.pojo.User;

//增删改查的实现类
public class UserDAOImpl implements UserDao {

	//TODO 注意,开发中不要这样写,开发中用spring注入
	//在成员变量的位置记录session,下面都可以使用
	private  SqlSession sqlSession;
	
	//通过构造函数接收sqlSession
	public UserDAOImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	
	@Override
	public User queryUserById(Long id) {
		return sqlSession.selectOne("userMapper.queryUserById",id);
	}


	@Override
	public List<User> queryAll() {
		return sqlSession.selectList("userMapper.queryAll");
	}

	@Override
	public void insertUser(User user) {
		//插入数据
		sqlSession.insert("userMapper.insertUser",user);
	}

	@Override
	public void updataUser(User user) {
		sqlSession.update("userMapper.updataUser", user);
	}

	@Override
	public void deleteUserById(Long id) {
		sqlSession.delete("userMapper.deleteUser", id);
	}

}
