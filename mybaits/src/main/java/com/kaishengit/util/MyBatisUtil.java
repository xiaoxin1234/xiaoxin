package com.kaishengit.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sessionFactory = buildSessionFactort();

	private static SqlSessionFactory buildSessionFactort() {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(reader);
			return sqlSessionFactory;
		} catch (IOException e) {
			throw new RuntimeException("��ȡmtbatis�����ļ��쳣");
		}
	}
	public static SqlSessionFactory getSqlSessionFactory(){
		return sessionFactory;
	} 
	public static SqlSession getSqlSession(){
		return getSqlSessionFactory().openSession();
	}
	
}
