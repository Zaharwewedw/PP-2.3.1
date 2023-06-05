package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.Model.User;
import web.dao.UserDaoImp;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserDaoImp userDaoImp;

    @Autowired
    public UserServiceImp(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoImp.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        userDaoImp.saveUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDaoImp.deleteUser(user);
    }

    @Override
    public User getByIdUser(Long id) {
        return userDaoImp.getByIdUser(id);
    }
}
