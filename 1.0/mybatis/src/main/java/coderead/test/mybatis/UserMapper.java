package coderead.test.mybatis;

import coderead.test.mybatis.beans.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select({" select * from users where id=#{1}"})
    User selectByid(Integer id);

    @Select({" select * from users where id=#{1}"})
    User selectByid2(Integer id);

    List<User> selectByUser(User user);

    @Insert("INSERT INTO `users`( `name`, `age`, `sex`, `email`, `phone_number`) VALUES ( #{name}, #{age}, #{sex}, #{email}, #{phoneNumber})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addUser(User user);

    int editUser(User user);

    @Delete("delete from users where id=#{id}")
    int deleteUser(Integer id);


}
