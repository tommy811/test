package coderead.test.spring.test;

import coderead.test.services.UserService;
import com.cbtu.agent.StackSessionBuild;
import com.cbtu.agent.jacoco.StackSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tommy
 * @title: BeanTest
 * @projectName test
 * @description: Bean实例测试
 * @date 2020/4/48:22 PM
 */
public class BeanTest {
    private ClassPathXmlApplicationContext context;

    @Before
    public void init(){
         context=
                new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void getBean(){
        StackSession stackSession = StackSessionBuild.open();
        /*=================测试代码区间开始========================*/
        UserService userService = context.getBean(UserService.class);
        userService.getUser(1);
        /*=================测试代码区间结束========================*/
        stackSession.printStack(System.out);
//        stackSession.saveCase("获取Bean");
    }

}
