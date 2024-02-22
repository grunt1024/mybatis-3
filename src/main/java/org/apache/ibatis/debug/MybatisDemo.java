package org.apache.ibatis.debug;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.debug.entity.User;
import org.apache.ibatis.debug.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * @author : zhanghua
 */
public class MybatisDemo {

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
        SqlSession sqlSession = sqlSessionFactory.openSession();

        query1(sqlSession);

        sqlSession.close();
    }

    private static void query1(SqlSession sqlSession) {
        //这里从statement里面取出sql,  id 去用来填充sql用的;
        Long id = 1L;
        User user = sqlSession.selectOne("org.apache.ibatis.debug.mapper.UserMapper.selectByPrimaryKey", id);

//        sqlSession.selectList();
//        sqlSession.selectOne();
    }

    private static void query2(SqlSession sqlSession) {
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        final User user = userMapper.selectByPrimaryKey(1L);
    }

    private static void analyseSqlSession(SqlSession sqlSession) {
        //执行一次sql, 数据源,事务,sql语句分别在哪存储?
        Configuration configuration = sqlSession.getConfiguration();
        Environment environment = configuration.getEnvironment();

        final TransactionFactory transactionFactory = environment.getTransactionFactory();
        PooledDataSource dataSource = (PooledDataSource) environment.getDataSource();

        System.out.println("数据源信息:  " + dataSource.getUrl() + dataSource.getUsername() + dataSource.getPassword());

        for (String mappedStatementName : configuration.getMappedStatementNames()) {
            System.out.println("===================start========================");

            final MappedStatement mappedStatement = configuration.getMappedStatement(mappedStatementName);
            System.out.println("id:" + mappedStatement.getId());
            System.out.println("sql:" + mappedStatement.getBoundSql("").getSql());

            System.out.println("===================end========================");
        }


        //TODO 如果

    }

}
