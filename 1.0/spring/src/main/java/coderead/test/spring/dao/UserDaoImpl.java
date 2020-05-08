package coderead.test.spring.dao;

import coderead.test.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author tommy
 * @title: UserDaoImpl
 * @projectName test
 * @description: TODO
 * @date 2020/5/55:16 PM
 */
@Repository
public class UserDaoImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User getUser(Integer id){
        String sql = "select * from users where id=?";
        User user = (User) jdbcTemplate.
                queryForObject(sql, new BeanPropertyRowMapper(User.class), id);
        return user;
    }

    public void updateUser(User user){
       String sql = "update   users set name=? where id=?";
       jdbcTemplate.update(sql,user.getName(),user.getId());
    }
}



