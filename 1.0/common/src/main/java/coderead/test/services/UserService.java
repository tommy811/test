package coderead.test.services;

import coderead.test.beans.User;

/**
 * @author tommy
 * @title: UserService
 * @projectName test
 * @description: 用户接口
 * @date 2020/4/110:43 AM
 */
public interface UserService {
     User getUser(Integer id);

     User editUserName(Integer id, String newName);
}
