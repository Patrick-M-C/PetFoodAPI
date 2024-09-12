package com.example.PetFoodShop;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petfooditem")
public class PetFoodController {

    private final PetFoodRepository petfoodRepository;
    public PetFoodController(PetFoodRepository petfoodRepository){
        this.petfoodRepository = petfoodRepository;
    }

    @PostMapping()
    int create(@RequestBody PetFoodItem petfoodItem){
        petfoodRepository.save(petfoodItem);
        return petfoodItem == null ? -1 : petfoodItem.getId();
    }

    @GetMapping("/{id}")
    PetFoodItem read(@PathVariable int id){
        return petfoodRepository.findById(id).get();
    }

    @GetMapping()
    List<PetFoodItem> getAll(){
        return petfoodRepository.findAll();
    }

    @PutMapping()
    void update(@RequestBody PetFoodItem petfoodItem){
        petfoodRepository.save(petfoodItem);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        petfoodRepository.deleteById(id);
    }
}
