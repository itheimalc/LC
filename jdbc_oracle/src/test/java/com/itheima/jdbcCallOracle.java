package com.itheima;

import oracle.jdbc.OracleTypes;
import org.junit.Test;

import java.sql.*;

public class jdbcCallOracle {

    @Test
    public void jdbcOracle() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.206.10:1521:orcl", "itheima", "itheima");
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM emp WHERE empno = ?");
        ps.setObject(1,7788);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("ename"));
        }
        resultSet.close();
        ps.close();
        connection.close();
    }

    /**
     * java调用存储过程
     * {?= call <procedure-name>[(<arg1>,<arg2>, ...)]}   调用存储函数使用
     * {call <procedure-name>[(<arg1>,<arg2>, ...)]}   调用存储过程使用
     * @throws Exception
     */
    @Test
    public void jdbcProcedure() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.206.10:1521:orcl", "itheima", "itheima");

        CallableStatement cs = connection.prepareCall("{call p_yearsal(?,?)} ");
        cs.setObject(1,7788);
        cs.registerOutParameter(2, OracleTypes.NUMBER);
        cs.execute();

        System.out.println(cs.getObject(2));

        cs.close();
        connection.close();
    }

    /**
     * java调用存储函数
     * {?= call <procedure-name>[(<arg1>,<arg2>, ...)]}   调用存储函数使用
     * {call <procedure-name>[(<arg1>,<arg2>, ...)]}   调用存储过程使用
     * @throws Exception
     */
    @Test
    public void jdbcFunction() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.206.10:1521:orcl", "itheima", "itheima");

        CallableStatement cs = connection.prepareCall("{?= call yearsal(?)}  ");
        cs.registerOutParameter(1,OracleTypes.NUMBER);
        cs.setObject(2,7788);
        cs.execute();

        System.out.println(cs.getObject(1));

        cs.close();
        connection.close();

    }
}
