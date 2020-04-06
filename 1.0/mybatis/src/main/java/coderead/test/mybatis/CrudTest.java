package coderead.test.mybatis;

import coderead.test.mybatis.beans.User;
import com.cbtu.agent.StackSessionBuild;
import com.cbtu.agent.jacoco.StackSession;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author tommy
 * @title: CrudTest
 * @projectName test
 * @description: 增删改查测试
 * @date 2020/3/295:26 PM
 */
public class CrudTest {

    private SqlSession sqlSession;
    private UserMapper mapper;

    @Before
    public void init() {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = factoryBuilder.build(CrudTest.class.getResourceAsStream("/mybatis-config.xml"));
        SqlSession sqlSession = build.openSession(true);
        this.sqlSession = sqlSession;
        this.mapper=sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void insertTest() {

        StackSession stackSession = StackSessionBuild.open();
        /*=================测试代码区间开始========================*/
        _insert();
        /*=================测试代码区间结束========================*/
        stackSession.saveCase("新增");

    }

    @Test
    public void deleteTest() {
        User user = _insert();

        StackSession stackSession = StackSessionBuild.open();
        /*=================测试代码区间开始========================*/
        mapper.deleteUser(user.getId());
        /*=================测试代码区间结束========================*/
        stackSession.saveCase("删除");

    }

    @Test
    public void updateTest() {
        User user = _insert();
        user.setName("鲁班大叔爱代码");

        StackSession stackSession = StackSessionBuild.open();
        /*=================测试代码区间开始========================*/
        mapper.editUser(user);
        /*=================测试代码区间结束========================*/
        stackSession.saveCase("修改");

        mapper.deleteUser(user.getId());
    }

    @Test
    public void selectTest(){
        User user = _insert();
        StackSession stackSession = StackSessionBuild.open();
        /*=================测试代码区间开始========================*/
        mapper.selectByUser(user);
        /*=================测试代码区间结束========================*/
        stackSession.saveCase("查询");
        mapper.deleteUser(user.getId());

    }
    private User _insert(){
        User user = new User();
        user.setName("小强");
        user.setAge("12");
        user.setEmail("22@cbtu.com");
        user.setPhoneNumber("111222333");
        user.setSex("男");
        mapper.addUser(user);
        return user;
    }

}
