package toeatlist.services;

import java.util.List;
import org.apache.commons.collections4.IterableUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toeatlist.repositories.UserRepository;
import toeatlist.tables.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRep;

    public List<User> getAll() {
        return IterableUtils.toList(userRep.findAll());
    }

    public User findByLogin(String login) {
        User user = userRep.findByLogin(login);
        return user;
    }

    // return true if user was added successfully
    /*
     * public Boolean create(String login, String password) {
     * // Integer weight, Integer height, Integer age, String gender) {
     * if (userRep.findByLogin(login) == null) {
     * User user = User.builder()
     * .login(login)
     * .password(password)
     * .build();
     * 
     * userRep.save(user);
     * }
     * return false;
     * }
     */
    public Boolean create(User user) {
        // Integer weight, Integer height, Integer age, String gender) {
        if (userRep.findByLogin(user.getLogin()) == null) {
            userRep.save(user);
            return true;
        }
        return false;
    }

    public Boolean delete(Long id) {
        if (userRep.findById(id) == null) {
            return false;
        }
        userRep.deleteById(id);
        return true;
    }

}
