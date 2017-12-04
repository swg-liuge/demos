package com.song.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@ContextConfiguration(value = {"classpath:application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSource() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
