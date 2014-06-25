package org.hsian.xms.config.datasourceconfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 数据源配置类
 * Created by Hsian on 14-6-19.
 */
@Configuration
@PropertySource(value = { "classpath:dataSource.properties" })
public class DataSourceConfig {

    @Value("${masterJdbcDriverClass}") String driverClass;
    @Value("${masterJdbcUrl}") String url;
    @Value("${masterJdbcUser}") String user;
    @Value("${masterJdbcPassword}") String password;

    @Bean(autowire= Autowire.BY_TYPE)
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }
}
