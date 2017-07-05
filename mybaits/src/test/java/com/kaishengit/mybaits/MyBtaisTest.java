package com.kaishengit.mybaits;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kaishengit.entity.User;

public class MyBtaisTest {
	@Test
	public void first() throws Exception{
		try {
			System.out.println("ÄãºÃ");
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactoryBuilder SqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",1);
			System.out.println(user.getAddress());
			System.out.println(user.getUserName());
			System.out.println(user.getPassword());
			System.out.println("ÈËÄØ");
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void findAll() throws Exception{
		try {
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactoryBuilder SqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			List<User> userlist = sqlSession.selectList("com.kaishengit.mapper.UserMapper.findAll");
			for(User user:userlist){
				System.out.println(user.getUserName());
				System.out.println(user.getAddress());
			}
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void save() throws Exception{
		try {
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactoryBuilder SqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			User user =new User();
			user.setUserName("xiaoxiaoxin");
			user.setAddress("Â¬ÊÏ");
			user.setPassword("69123");
			sqlSession.insert("com.kaishengit.mapper.UserMapper.save", user);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void update() throws Exception{
		try {
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactoryBuilder SqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			User user = new User(); 
			user.setId(1);
			user.setUserName("wangxin");
			sqlSession.update("com.kaishengit.mapper.UserMapper.update", user);
			
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void delete() throws Exception{
		try {
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactoryBuilder SqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			
			sqlSession.delete("com.kaishengit.mapper.UserMapper.delete", 5);
			
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
