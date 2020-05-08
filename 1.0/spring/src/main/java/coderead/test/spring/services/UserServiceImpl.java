package coderead.test.spring.services;

import coderead.test.beans.User;
import coderead.test.services.UserService;
import coderead.test.spring.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tommy
 * @title: UserService
 * @projectName test
 * @description: 用户服务
 * @date 2020/4/110:39 AM
 */
//@Service
public class UserServiceImpl implements UserService  {

    private String name;

    @Autowired
    private UserDaoImpl dao;

    @Autowired
    ApplicationContext context; // 依赖自动注入
    final ListenerBean listenerBean;

    // 构造函数依赖注入
    public UserServiceImpl(ListenerBean lifecycleBean) {
        System.out.println("创建Bean");
        this.listenerBean=lifecycleBean;
    }

    @Override
    public User getUser(Integer id) {
        User user=new User();
        user.setName(name);
        return user;
    }
    @Override
    @Transactional
    public User editUserName(Integer id, String newName){
        User user = dao.getUser(id);
        user.setName(newName);
        dao.updateUser(user);
         user = dao.getUser(id);
            return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }


}
