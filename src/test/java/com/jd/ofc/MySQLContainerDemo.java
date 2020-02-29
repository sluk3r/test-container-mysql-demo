package com.jd.ofc;


import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

public class MySQLContainerDemo {
    @Rule
    public MySQLContainer mysql = new MySQLContainer();
    
    
    @Test
    public void name() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        
        String jdbcUrl = mysql.getJdbcUrl();
        String userName = mysql.getUsername();
        String password = mysql.getPassword();
    
        Connection connect = DriverManager
                .getConnection(jdbcUrl, userName, password);
    
        ResultSet resultSet =
                connect.createStatement().executeQuery("SELECT 1");
        resultSet.next();
        int result = resultSet.getInt(1);
    
        assertEquals(1, result);
    }
}
