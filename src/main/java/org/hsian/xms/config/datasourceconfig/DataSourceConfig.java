package org.hsian.xms.config.datasourceconfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 数据源配置类
 * Created by Hsian on 14-6-19.
 */
@Configuration
@PropertySource(value = { "classpath:dataSource.properties" })
public class DataSourceConfig {

    private final static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Value("${masterJdbcDriverClass}") String driverClass;
    @Value("${masterJdbcUrl}") String url;
    @Value("${masterJdbcUser}") String user;
    @Value("${masterJdbcPassword}") String password;

    @Inject
    Environment env;

    /**
     *
     * @return DataSource
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        // instantiate, configure and return DataSource
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(env.getProperty("masterJdbcDriverClass"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        ds.setJdbcUrl(env.getProperty("masterJdbcUrl"));
        ds.setUser(env.getProperty("masterJdbcUser"));
        ds.setPassword(env.getProperty("masterJdbcPassword"));
        ds.setInitialPoolSize(env.getProperty("masterJdbcInitialPoolSize", Integer.class));
        // 连接池中保留的最小连接数。 value=10
        ds.setMinPoolSize(env.getProperty("masterJdbcMinPoolSize", Integer.class));
        // 连接池中保留的最大连接数。Default: 15 value=100
        ds.setMaxPoolSize(env.getProperty("masterJdbcMaxPoolSize", Integer.class));
        // 最大空闲时间,1800秒内未使用则连接被丢弃。若为0则永不丢弃。Default: 0 value=1800
        ds.setMaxIdleTime(env.getProperty("masterJdbcMaxIdleTime", Integer.class));
        // JDBC的标准参数，用以控制数据源内加载的PreparedStatements数量。
        // 但由于预缓存的statements属于单个connection而不是整个连接池。所以设置这个参数需要考虑到多方面的因素。
        // 如果maxStatements与maxStatementsPerConnection均为0，则缓存被关闭。Default: 0 value=1000
        ds.setMaxStatements(env.getProperty("masterJdbcMaxStatements", Integer.class));
        // 定义了连接池内单个连接所拥有的最大缓存statements数。Default: 0 value=1000
        ds.setMaxStatementsPerConnection(env.getProperty("masterJdbcMaxStatementsPerConnection", Integer.class));
        // 每60秒检查所有连接池中的空闲连接。Default: 0 value=60
        ds.setIdleConnectionTestPeriod(env.getProperty("masterJdbcIdleConnectionTestPeriod", Integer.class));
        // 当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。Default: 3
        ds.setAcquireIncrement(env.getProperty("masterJdbcAcquireIncrement", Integer.class));
        // 定义在从数据库获取新连接失败后重复尝试的次数。Default: 30
        ds.setAcquireRetryAttempts(env.getProperty("masterJdbcAcquireRetryAttempts", Integer.class));

        // 获取连接失败将会引起所有等待连接池来获取连接的线程抛出异常。
        // 但是数据源仍有效保留，并在下次调用getConnection()的时候继续尝试获取连接。
        // 如果设为true，那么在尝试获取连接失败后该数据源将申明已断开并永久关闭。Default: false
        // ds.setBreakAfterAcquireFailure(masterJdbcBreakAfterAcquireFailure);
        // 因性能消耗大请只在需要的时候使用它。如果设为true那么在每个connection提交的
        // 时候都将校验其有效性。建议使用idleConnectionTestPeriod或automaticTestTable
        // 等方法来提升连接测试的性能。Default: false
        // ds.setTestConnectionOnCheckout(masterJdbcTestConnectionOnCheckout);

        return ds;
    }
}
