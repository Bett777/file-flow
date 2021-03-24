package com.jgc.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * <p>spring上下文工具类</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/08 10:07
 **/
public class SpringApplicationContextUtils {
    private static ApplicationContext context;

    public SpringApplicationContextUtils() {
    }

    public static void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringApplicationContextUtils.context = context;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static ConfigurableApplicationContext getConfigurableApplicationContext() {
        return (ConfigurableApplicationContext)context;
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }
}
