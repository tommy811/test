package coderead.test.mybatis;

import coderead.test.mybatis.beans.User;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;










public class CacheTest {
    private static Configuration configuration;

    static { // 初始化MyBatis
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = factoryBuilder.build(CrudTest.class.getResourceAsStream("/mybatis-config.xml"));
        configuration = build.getConfiguration();
    }




    public static void main(String[] args) {
        // 基于类名称，获取缓存
        Cache cache = configuration.getCache(UserMapper.class.getName());
        User user = new User(666, "鲁班大叔");
        cache.putObject(666, user);// 设置缓存值
        cache.getObject(666);// 获取缓存值
    }












}
