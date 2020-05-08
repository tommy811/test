package coderead.test.mybatis;

import coderead.test.mybatis.beans.User;
import com.cbtu.agent.StackSessionBuild;
import com.cbtu.agent.jacoco.StackSession;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * @author tommy
 * @title: MyBatisTest
 * @projectName test
 * @description: 用于测试myBatis的基础功能
 * @date 2020/3/286:42 PM
 */
public class BasicTest {


        @Test
        public void initTest() {
            StackSession stackSession = StackSessionBuild.open();
            /*=================测试代码区间开始========================*/
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = factoryBuilder.build(BasicTest.class.getResourceAsStream("/mybatis-config.xml"));
            /*=================测试代码区间结束========================*/
            stackSession.saveCase("初始化");
        }

        @Test
        public void createSession() {
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = factoryBuilder.build(BasicTest.class.getResourceAsStream("/mybatis-config.xml"));

            StackSession stackSession = StackSessionBuild.open();
            /*=================测试代码区间开始========================*/
            SqlSession sqlSession = build.openSession(true);
            /*=================测试代码区间结束========================*/
            stackSession.saveCase("创建会话");
        }

        @Test
        public void closeSession() {
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = factoryBuilder.build(BasicTest.class.getResourceAsStream("/mybatis-config.xml"));
            SqlSession sqlSession = build.openSession(true);

            select(sqlSession);
            StackSession stackSession = StackSessionBuild.open();
            /*=================测试代码区间开始========================*/
            sqlSession.close();
            /*=================测试代码区间结束========================*/
            stackSession.saveCase("关闭会话");
        }

        @Test
        public void commitSessionTest(){
            SqlSession sqlSession = buildSession();
            select(sqlSession);

            StackSession stackSession = StackSessionBuild.open();
            /*=================测试代码区间开始========================*/
            sqlSession.commit();;
            /*=================测试代码区间结束========================*/
            stackSession.saveCase("提交会话");
        }

        @Test
        public void getProxyMapperTest(){
            SqlSession sqlSession = buildSession();
            StackSession stackSession = StackSessionBuild.open();
            /*=================测试代码区间开始========================*/
            sqlSession.getMapper(UserMapper.class);
            /*=================测试代码区间结束========================*/
            stackSession.saveCase("获取Mapper实例");

        }

        private void select(SqlSession sqlSession){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setId(10);
            user.setName("鲁班大叔");
            user.setAge("38");
            mapper.selectByUser(user);
        }

        private void update(SqlSession sqlSession){

        }

        public static SqlSessionFactory getFactory(){
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = factoryBuilder.build(BasicTest.class.getResourceAsStream("/mybatis-config.xml"));
            return build;
        }
        public static SqlSession buildSession(){
            return getFactory().openSession(true);
        }









}
