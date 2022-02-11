package toeatlist.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IterableUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toeatlist.repositories.FoodRepository;
import toeatlist.tables.Food;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRep;

    public List<Food> getAll() {
        return IterableUtils.toList(foodRep.findAll());
    }

    public Optional<Food> getById(Long id) {
        return foodRep.findById(id);
    }

    public void create(Food food) {
        foodRep.save(food);
    }

    public Food update(Long id, Food food) {
        Food newFood = new Food();
        newFood.setId(id);
        newFood.setDescription(food.getDescription());
        newFood.setCalories(food.getCalories());
        return foodRep.save(newFood);
    }

    public Boolean delete(Long id) {
        if (foodRep.findById(id) == null) {
            return false;
        }
        foodRep.deleteById(id);
        return true;
    }

    public void deleteAll() {
        foodRep.deleteAll();
    }

}
