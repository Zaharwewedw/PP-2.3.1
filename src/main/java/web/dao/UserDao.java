package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void saveUser(User user);

    void upDateUser(User user);

    void deleteUser(Long id);

    User getByIdUser(Long id);
}
