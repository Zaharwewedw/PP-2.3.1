package web.service;

import web.Model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(User user);

    User getByIdUser(Long id);
}
