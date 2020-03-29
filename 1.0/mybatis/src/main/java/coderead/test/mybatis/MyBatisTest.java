package coderead.test.mybatis;

import coderead.test.mybatis.beans.User;
import com.cbtu.agent.StackSessionBuild;
import com.cbtu.agent.jacoco.StackSession;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tommy
 * Created by Tommy on 2019/12/23
 **/
public class MyBatisTest {
    SqlSessionFactory build;
    private SqlSession sqlSession;
    private SqlSession sqlSession2;

    @Before
    public void init() {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        build = factoryBuilder.build(MyBatisTest.class.getResourceAsStream("/mybatis-config.xml"));
        sqlSession = build.openSession(true);
        sqlSession2 = build.openSession(false);
    }

    @Test
    public void createSession() {
        StackSession stackSession = StackSessionBuild.open(getClass(), "createSession");
        SqlSession sqlSession = build.openSession(true);
        stackSession.printStack(System.out);
    }

    @Test
    public void buildTest() {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        StackSession stackSession = StackSessionBuild.open(getClass(), "buildTest");
        System.out.println("--------\r\n\n\n");
        SqlSessionFactory build = factoryBuilder.build(MyBatisTest.class.getResourceAsStream("/mybatis-config.xml"));
        stackSession.close();
        stackSession.printStack(System.out);
        System.out.println("--------\r\n\n\n");
    }


    @Test
    public void insertTest() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        StackSession stackSession = StackSessionBuild.open(getClass(), "insertTest");
        User user = new User();
        user.setName("小强");
        user.setAge("12");
        user.setEmail("22@cbtu.com");
        user.setPhoneNumber("111222333");
        user.setSex("男");
        mapper.addUser(user);
        stackSession.close();
        stackSession.printStack(System.out);
    }

    @Test
    public void deleteTest() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        StackSession stackSession = StackSessionBuild.open(getClass(), "insertTest");
        mapper.deleteUser(99);
        stackSession.printStack(System.out);
    }

    @Test
    public void updateTest() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        StackSession stackSession = StackSessionBuild.open(getClass(), "updateTest");

        User user = new User();
        user.setId(10);
        user.setName("鲁班大师111");
        user.setAge("38");
        user.setEmail("22@cbtu.com");
        user.setPhoneNumber("111222333");
        user.setSex("男");
        mapper.editUser(user);
        stackSession.close();
        stackSession.printStack(System.out);
    }

    @Test
    public void selectTest()  {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("小强");
        StackSession stackSession = StackSessionBuild.open(getClass(), "selectTest");
        mapper.selectByUser(user);
        stackSession.printStack(System.out);
        StackSession.clear();
    }

    @Test
    public void cacheTest()  {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("---------------------\n");
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = new User();
        user2.setName("luban");
        StackSession stackSession = new StackSession(getClass().getName(), "cacheTest");
        mapper.selectByUser(user2);
        stackSession.printStack(System.out);
        System.out.println("--------\r\n\n\n");
        StackSession.clear();
        sqlSession.commit();
        mapper2.selectByUser(user2);
    }


    @Test
    public void commitTest()  {
        UserMapper mapper = sqlSession2.getMapper(UserMapper.class);
        User user = new User();
        user.setId(10);
        user.setName("鲁班大师111");
        user.setAge("38");
        mapper.editUser(user);
        mapper.selectByUser(user);
        StackSession stackSession = StackSessionBuild.open(getClass(), "commitTest");
        sqlSession2.commit();
        stackSession.printStack(System.out);
        sqlSession2.close();
    }


    @Test
    public void closeTest()  {
        UserMapper mapper = sqlSession2.getMapper(UserMapper.class);
        User user = new User();
        user.setId(10);
        user.setName("鲁班大师111");
        user.setAge("38");
        mapper.selectByUser(user);
        StackSession stackSession = StackSessionBuild.open(getClass(), "commitTest");
        sqlSession2.close();
        stackSession.printStack(System.out);
    }

}

