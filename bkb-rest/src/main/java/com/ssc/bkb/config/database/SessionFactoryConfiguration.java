//package com.ssc.bkb.config.database;
//
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//
///**
// * 数据库sqlSession配置类
// *
// * @author Lebonheur
// * @version 1.0, 新建
// * @date 3/7/2020 15:02
// */
//@Configuration
//public class SessionFactoryConfiguration {
//
//    private final DataSource dataSource;
//
//    @Value("${mapper_path}")
//    private String mapperPath;
//
//    @Value("${mybatis_config_file}")
//    private String mybatisConfigFilePath;
//
//    @Value("${entity_package}")
//    private String entityPackage;
//
//    @Autowired
//    public SessionFactoryConfiguration(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Bean(name="sqlSessionFactory")
//    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mapperPath;
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
//        return sqlSessionFactoryBean;
//    }
//
//}
