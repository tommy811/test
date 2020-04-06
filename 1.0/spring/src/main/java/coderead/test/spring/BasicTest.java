package coderead.test.spring;

import coderead.test.services.UserService;
import com.cbtu.agent.StackSessionBuild;
import com.cbtu.agent.jacoco.StackSession;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author tommy
 * @title: BasicTest
 * @projectName test
 * @description: spring 基础功能测试
 * @date 2020/4/110:20 AM
 */
public class BasicTest {

    @Test
    public void initTest(){
        StackSession stackSession = StackSessionBuild.open();
        /*=================测试代码区间开始========================*/
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("spring.xml");
        /*=================测试代码区间结束========================*/
        stackSession.saveCase("启动容器");
    }


    @Test
    public void closeTest(){
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("spring.xml");
//        context.start();
        StackSession stackSession = StackSessionBuild.open();
        /*=================测试代码区间开始========================*/
        context.close();
        /*=================测试代码区间结束========================*/
        stackSession.saveCase("关闭容器");
    }

}
