package coderead.test.spring.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author tommy
 * @title: LifecycleBean
 * @projectName test
 * @description: 测试常用接口如： Lifecycle、InitializingBean、ApplicationContextAware
 * @date 2020/4/47:44 PM
 */
@Component
@Lazy
public class ListenerBean implements Lifecycle, InitializingBean, ApplicationContextAware {
    @Override
    public void start() {
        System.out.println("Lifecycle Bean生命周期启动");
    }

    @Override
    public void stop() {
        System.out.println("Lifecycle Bean生命周期停止");
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化Bean");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("依赖填充 ApplicationContext");
    }
}
