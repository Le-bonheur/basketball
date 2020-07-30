//package com.ssc.bkb.config.database;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.TransactionManagementConfigurer;
//
//import javax.annotation.Nonnull;
//import javax.sql.DataSource;
//
///**
// * 事务配置类
// *
// * @author Lebonheur
// * @version 1.0, 新建
// * @date 3/7/2020 15:05
// */
//@Configuration
//@EnableTransactionManagement
//public class TransactionManagementConfiguration implements TransactionManagementConfigurer {
//
//    private final DataSource dataSource;
//
//    @Autowired
//    public TransactionManagementConfiguration(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Nonnull
//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return new DataSourceTransactionManager(dataSource);
//    }
//}
