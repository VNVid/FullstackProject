package toeatlist.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import toeatlist.tables.Food;

public interface FoodRepository extends CrudRepository<Food, Long> {
    Optional<Food> findById(Long id);

    void deleteById(Long id);

    void deleteAll();
}