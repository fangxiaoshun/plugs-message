/*
 * Copyright © 2015-2026 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shsc.plug.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * SpringUtil
 * @author chenkui
 * @date 2019/06/06
 */
@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext APPLICATIONCONTEXT;


    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.APPLICATIONCONTEXT == null) {
            SpringUtil.APPLICATIONCONTEXT = applicationContext;
        }
    }

    /**
     * 获取applicationContext
     * @return applicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return APPLICATIONCONTEXT;
    }

    /**
     * 通过name获取 Bean
     * @param name name
     * @return Object
     */
    public static Object getBean(final String name){
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean
     * @param <T> T
     * @param clazz clazz
     * @return T
     */
    public static <T> T getBean(final Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     * @param <T> T
     * @param name name
     * @param clazz clazz
     * @return T
     */
    public static <T> T getBean(final String name, final Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
}
