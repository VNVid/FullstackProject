package toeatlist.repositories;

import org.springframework.data.repository.CrudRepository;

import toeatlist.tables.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);

    void deleteById(Long id);
}
