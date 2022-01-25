package org.api.configuration;

import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "org.api.mapper", sqlSessionTemplateRef = "apiSqlSessionTemplate")
public class TransactionConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public SqlSessionFactory apiSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        factory.setTypeAliasesPackage("org.api.mapper");
        return factory.getObject();
    }

    @Bean
    public SqlSessionTemplate apiSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(apiSqlSessionFactory());
    }

    @Bean
    public DataSourceTransactionManager apiTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
