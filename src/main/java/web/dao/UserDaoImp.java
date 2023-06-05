package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.Model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImp() {
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        User managed = entityManager.merge(user);
        entityManager.persist(managed);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        User managed = entityManager.merge(user);
        entityManager.remove(managed);
    }

    @Override
    public User getByIdUser(Long id) {
        return entityManager.find(User.class, id);
    }
}
