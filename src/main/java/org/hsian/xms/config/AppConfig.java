package org.hsian.xms.config;

import org.hsian.xms.config.datasourceconfig.DataSourceConfig;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.inject.Inject;
import java.util.Properties;

/**
 * 程序环境配置类，用于替代原来的<b>applicationContext.xml</b>配置文件
 * Created by Hsian on 14-6-19.
 */
@Configuration
// 打开事务管理：<tx:annotation-driven/>
@EnableTransactionManagement
// 打开切片配置 @Aspect, <aop:aspectj-autoproxy />
@EnableAspectJAutoProxy
// 打开Scheduling
@EnableScheduling
// 打开缓存
@EnableCaching
@EnableAsync
// 引入各种配置类
@Import(
    value = {
        DataSourceConfig.class // 数据源相关的配置类
        //, RepositoryBeanContext.class // Dao层bean的配置类
        //, ServiceBeanContext.class // Service层bean的配置类
        //, ControllerBeanContext.class // Controller层bean的配置类
    }
)
// 组件扫描：<context:component-scan base-package="org.example.config"/>
@ComponentScan(
    basePackages = {
        "org.hsian.xms"
        //, "org.hsian.xms.services"
        //, "org.hsian.xms.repositories"
    },
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
    }
)
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig {

    @Inject
    DataSourceConfig dataSourceConfig;

    /**
     * @return 事务管理者 PlatformTransactionManager
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSourceConfig.dataSource());
    }

    @Inject
    private Environment env;

    /**
     * Property资源配置
     * @return PropertySourcesPlaceholderConfigurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * 缓存管理者
     * @return CacheManager
     */
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    /**
     * 邮件发送器
     * @return JavaMailSenderImpl
     */
    @Bean
    public JavaMailSenderImpl javaMailSenderImpl() {
        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
        mailSenderImpl.setHost(env.getProperty("smtp.host"));
        mailSenderImpl.setPort(env.getProperty("smtp.port", Integer.class));
        mailSenderImpl.setProtocol(env.getProperty("smtp.protocol"));
        mailSenderImpl.setUsername(env.getProperty("smtp.username"));
        mailSenderImpl.setPassword(env.getProperty("smtp.password"));

        Properties javaMailProps = new Properties();
        javaMailProps.put("mail.smtp.auth", true);
        javaMailProps.put("mail.smtp.starttls.enable", true);

        mailSenderImpl.setJavaMailProperties(javaMailProps);

        return mailSenderImpl;
    }


    /**
     * <pre> {@code
     *  <bean id="jdbcTemplate"
     *      class="org.springframework.jdbc.core.JdbcTemplate" abstract="false"
     *      lazy-init="false" autowire="default" dependency-check="default">
     *      <property name="dataSource" ref="dataSource" />
     *  </bean>
     * } </pre>
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceConfig.dataSource());
        return jdbcTemplate;
    }
}
