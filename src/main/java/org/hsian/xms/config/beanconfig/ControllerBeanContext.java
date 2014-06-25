package org.hsian.xms.config.beanconfig;

import org.hsian.xms.controllers.IndexController;
import org.hsian.xms.controllers.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Hsian on 14-6-21.
 */
@Configuration
public class ControllerBeanContext {

    @Bean
    public IndexController indexController() {
        return new IndexController();
    }

    @Bean
    public UserController userController() {
        return new UserController();
    }
}
