package toeatlist.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import toeatlist.services.FoodService;
import toeatlist.tables.Food;

@RestController
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/food")
    public List<Food> getAllUsers() {
        return foodService.getAll();
    }

    @GetMapping("/food/{id}")
    public Food getFoodById(@PathVariable Long id) {
        Optional<Food> res = foodService.getById(id);
        if (!res.isPresent()) {
            return new Food();
        } else {
            return res.get();
        }
    }

    @PostMapping("/food")
    @ResponseStatus(HttpStatus.CREATED)
    public void createFood(@RequestBody Food food) {
        foodService.create(food);
    }

    @PutMapping("/food/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Food updateFood(@PathVariable("id") Long id, @RequestBody Food food) {
        return foodService.update(id, food);
    }

    @DeleteMapping("/food/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFood(@PathVariable("id") Long id) {
        foodService.delete(id);
    }

    @DeleteMapping("/food")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllFood() {
        foodService.deleteAll();
    }
}