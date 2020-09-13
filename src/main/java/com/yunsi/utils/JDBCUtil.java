package com.yunsi.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static DataSource ds;

    static{
        Properties pro = new Properties();
        InputStream ins = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(ins);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
            return ds.getConnection();
    }

    public static DataSource getDataSource(){
        return ds;
    }

/*    public static void main(String[] args) {
        Connection conn = JDBCUtil.getConnection();
        System.out.println(conn);
    }*/
}
