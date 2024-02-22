package org.apache.ibatis.debug;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSession;

import java.io.IOException;
import java.io.Reader;

/**
 * @author ZhangHua
 * @date 2024/2/22 15:22
 */
public class CacheTest {


    public static void main(String[] args) throws IOException {

        String resourcePath = "org/apache/ibatis/debug/xml/Mybatis-config.xml";
        final Reader reader = Resources.getResourceAsReader(resourcePath);

        //读取配置信息, 构建sqlSessionFactory实例

        /**
         * XMLConfigBuilder 会解析 mybatis-config.xml 配置文件得到对应的 Configuration 全局配置对象，
         * 然后 SqlSessionFactoryBuilder 会根据得到的 Configuration 全局配置对象创建一个 DefaultSqlSessionFactory 对象返回给上层使用。
         */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //数据源信息在创建sqlsession时候, 封装到了事务类, 执行器持有事务类, sqlSession持有执行器
        //创建 sqlSession
        DefaultSqlSession sqlSession;


        //sqlSession 里面持有 Executor, Executor里面有个缓存类

    }
}
