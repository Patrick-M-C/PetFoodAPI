package com.example.PetFoodShop;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetFoodRepository extends JpaRepository<PetFoodItem, Integer> {
}
