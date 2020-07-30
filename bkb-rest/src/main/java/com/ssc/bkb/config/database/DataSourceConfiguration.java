//package com.ssc.bkb.config.database;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//
//import java.beans.PropertyVetoException;
//
///**
// * 数据库配置类
// *
// * @author Lebonheur
// * @version 1.0, 新建
// * @date 3/7/2020 14:56
// */
//public class DataSourceConfiguration {
//
//    @Value("${jdbc.driver}")
//    private String jdbcDriver;
//    @Value("${jdbc.url}")
//    private String jdbcUrl;
//    @Value("${jdbc.username}")
//    private String jdbcUsername;
//    @Value("${jdbc.password}")
//    private String jdbcPassword;
//
//    @Bean(name = "dataSource")
//    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setDriverClass(jdbcDriver);
//        dataSource.setJdbcUrl(jdbcUrl);
//        dataSource.setUser(jdbcUsername);
//        dataSource.setPassword(jdbcPassword);
//        //关闭连接后不自动commit
//        dataSource.setAutoCommitOnClose(false);
//        return dataSource;
//    }
//
//}
