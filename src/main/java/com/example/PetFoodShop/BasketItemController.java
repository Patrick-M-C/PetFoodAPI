package com.example.PetFoodShop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/basketitems")
public class BasketItemController {

    private final BasketItemRepository basketItemRepository;
    public BasketItemController(BasketItemRepository basketItemRepository) {
        this.basketItemRepository = basketItemRepository;
    }

    @PostMapping()
    int create(@RequestBody BasketItem basketItem){
        basketItemRepository.save(basketItem);
        return basketItem == null ? -1 : basketItem.getId();
    }

    @GetMapping("/{id}")
    BasketItem read(@PathVariable int id){
        return basketItemRepository.findById(id).get();
    }

    @GetMapping()
    List<BasketItem> getAll(){
        return basketItemRepository.findAll();
    }

    @PutMapping()
    void update(@RequestBody BasketItem basketItem){
        basketItemRepository.save(basketItem);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        basketItemRepository.deleteById(id);
    }
}
