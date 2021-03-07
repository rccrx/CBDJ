package com.crx.cbdj.common.context;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContext implements ApplicationContextAware, DisposableBean {

    private static ApplicationContext applicationContext;

    public static <T> T getBean(String beanId) {
        assertContextInjected();
        return (T) applicationContext.getBean(beanId);
    }

    public static <T> T getBean(Class<T> cls) {
        assertContextInjected();
        return applicationContext.getBean(cls);
    }

    public void destroy() throws Exception {
        applicationContext = null;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.applicationContext = applicationContext;
    }

    private static void assertContextInjected() {
        /*
        注意，是第一个参数的值为false时，才会打印第二个参数的消息，并且抛出异常IllegalStateException，
        所以如果服务器启动没有自动打开网页，Intellij IDEA的下方server打印出"Error during artifact deployment"，
        且Tomcat Localhost Log打印出错误"org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'userService' defined in file [/Users/RC/Documents/ProjectAtWork/CBDJ/target/cbdj-1.0.0-SNAPSHOT/WEB-INF/classes/spring-context.xml]: Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.crx.cbdj.service.impl.UserServiceImpl]: Constructor threw exception; nested exception is java.lang.IllegalStateException: ApplicationContext为空"，
        则看看是不是错写成"applicationContext==null"，
        或者spring-context.xml缺少"<bean id="spring/Context" class="com.crx.cbdj.common.context.SpringContext" />"
        */
        Validate.validState(applicationContext!=null, "ApplicationContext为空");
    }
}
