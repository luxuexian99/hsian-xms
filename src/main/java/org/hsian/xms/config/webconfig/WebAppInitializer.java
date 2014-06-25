package org.hsian.xms.config.webconfig;

import org.hsian.xms.config.AppConfig;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * web程序加载器，如：web.xml
 * Created by Hsian on 14-6-21.
 */
@Order(1)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * like:
     * <code>
     *     <context-param>
     *          <param-name>contextConfigLocation</param-name>
     *          <param-value>classpath:applicationContext.xml</param-value>
     *     </context-param>
     * </code>
     * in web.xml
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    /**
     * like:
     * <code>
     *     <servlet>
     *         <servlet-name>dispatcher</servlet-name>
     *         <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
     *         <init-param>
     *             <param-name>contextConfigLocation</param-name>
     *             <param-value>classpath:dispatcher-servlet.xml</param-value>
     *         </init-param>
     *         <load-on-startup>1</load-on-startup>
     *     </servlet>
     * </code>
     * in web.xml
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebAppInitializer.class};
    }

    /**
     * like:
     * <code>
     *     <servlet-mapping>
     *          <servlet-name>dispatcher</servlet-name>
     *          <url-pattern>/</url-pattern>
     *     </servlet-mapping>
     * </code>
     * in web.xml
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
