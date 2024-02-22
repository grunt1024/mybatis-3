package org.apache.ibatis.debug;

import org.apache.ibatis.builder.BaseBuilder;
import org.apache.ibatis.debug.entity.User;
import org.apache.ibatis.debug.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author : zhanghua
 */
public class MybatisDemo {

    public static void main(String[] args) throws IOException {

        String resourcePath = "org/apache/ibatis/debug/Mybatis-config.xml";
        final Reader reader = Resources.getResourceAsReader(resourcePath);

        //读取配置信息, 构建sqlSessionFactory实例

        /**
         * XMLConfigBuilder 会解析 mybatis-config.xml 配置文件得到对应的 Configuration 全局配置对象，
         * 然后 SqlSessionFactoryBuilder 会根据得到的 Configuration 全局配置对象创建一个 DefaultSqlSessionFactory 对象返回给上层使用。
         */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //数据源信息在创建sqlsession时候, 封装到了事务类, 执行器持有事务类, sqlSession持有执行器
        //创建 sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //这里从statement里面取出sql,  id 去用来填充sql用的;
//        Long id = 1L;
//        List<Object> list = sqlSession.selectList("com.github.mybatisDemo.mapper.UserMapper.selectByPrimaryKey", id);


        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        final User user = userMapper.selectByPrimaryKey(1L);
        System.out.println(user.getName() + user.getAddress());

        sqlSession.close();
    }
}
