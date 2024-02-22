package org.apache.ibatis.debug;

import java.sql.*;

/**
 * @author ZhangHua
 * @date 2024/2/22 14:30
 */
public class JdbcTest {

    public static void main(String[] args) throws SQLException {

        //这一句之后通过反射找到对应的数据库驱动类, 发起tcp连接, 执行tcp三次握手, 用户认证
        Connection connection = DriverManager.getConnection("", "", "");


        //执行sql的抽象
        final Statement statement = connection.createStatement();

//        执行静态SQL语句。通常通过Statement实例实现。
//        执行动态SQL语句。通常通过PreparedStatement实例实现。
//        执行数据库存储过程。通常通过CallableStatement实例实现。


        //查询结果集的抽象
        final ResultSet resultSet = statement.executeQuery("select * from user");

        while (resultSet.next()) {
            resultSet.getString("name");
        }


        resultSet.close();
        statement.close();
        connection.close();

        //上面代码是jdbc大体流程;

//        //Mybatis 去查询数据本质上也是jdbc,那么Mybatis是如何解析查询出来的数据的呢?
//        StatementHandler statementHandler = new SimpleStatementHandler();
//
//        ResultSetHandler handler = new DefaultResultSetHandler();
    }


    private void mainClass() {
//        SqlSessionFactory;
//        SqlSession;
//
//        Executor;
//
//        DataSource;
//        DataSourceFactory;
//
//        Transaction;
//        TransactionFactory;
//
//
//        Statement;
//        StatementHandler;
//
//
//        Resultset;
//        ResultHandler;
//
//        Cache;
//
//
//        MappedStatement;

    }


}
