package com.liqiang.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DataSourceUtils {
    private static DataSource ds;

    private static Connection conn;

    public static DataSource getDatasSource() {
        return ds;
    }

    public static Connection getConnection() {
        
        try {
        	InitialContext ctx = new InitialContext();
        	/*
        	 *  根据xml中配置的数据库连接池的name属性
        	 *  name:是绑定在那个项目上的DataSource,指定web根路径在下
				auth:说明验证类型为容器
				driverClassName:驱动类名：指明你用的mysql驱动包 
				type:指定连接池所用类型为DataSource(ODBC数据源)
				url:需要连接的数据库
				username:数据库名称
				password:数据库密码
        	 * */
        	ds  = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
            conn = ds.getConnection();// 每一次从ds中获取一个新的连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public void close()
    {
    	if(conn != null)
    	{
    		try {
    			conn.close();
    		}catch(Exception e)
    		{
    			e.printStackTrace();
    		}	
    	}
    }
}
