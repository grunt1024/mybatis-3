package org.apache.ibatis;

import org.apache.ibatis.builder.BaseBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author : zhanghua
 */
public class MybatisDemo {

    public static void main(String[] args) throws IOException {

        String resourcePath = "./Mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resourcePath);


        //读取配置信息, 构建sqlSessionFactory实例


        /**
         * XMLConfigBuilder 会解析 mybatis-config.xml 配置文件得到对应的 Configuration 全局配置对象，
         * 然后 SqlSessionFactoryBuilder 会根据得到的 Configuration 全局配置对象创建一个 DefaultSqlSessionFactory 对象返回给上层使用。
         */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);



        //数据源信息在创建sqlsession时候, 封装到了事务类, 执行器持有事务类, sqlSession持有执行器
        //创建 sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();


        sqlSessionFactory.openSession();


        //这里从statement里面取出sql,  id 去用来填充sql用的;
        Long id = 1L;
        List<Object> list = sqlSession.selectList("com.xx.xx.mapper.xxMapper.selectByPrimaryKey", id);

        sqlSession.close();
    }
}
