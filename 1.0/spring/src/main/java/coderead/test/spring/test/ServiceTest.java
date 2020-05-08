package coderead.test.spring.test;

import coderead.test.services.UserService;
import com.cbtu.agent.StackSessionBuild;
import com.cbtu.agent.jacoco.StackSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tommy
 * @title: ServiceTest
 * @projectName test
 * @description: 服务测试
 * @date 2020/5/56:14 PM
 */
public class ServiceTest {
    private ClassPathXmlApplicationContext context;

    @Before
    public void init() {
        context =
                new ClassPathXmlApplicationContext("spring.xml");
    }

    // 声明示事物
    @Test
    public void txText() {
        UserService userService = context.getBean(UserService.class);
        /*=================测试代码区间开始========================*/
        StackSession stackSession = StackSessionBuild.open();
        userService.editUserName(10,"鲁班大叔");
        stackSession.saveCase("执行事物");
        /*=================测试代码区间结束========================*/

    }
}
