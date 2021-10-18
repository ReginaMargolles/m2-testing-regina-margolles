package com.example.m2testingreginamargolles.repository;

import com.example.m2testingreginamargolles.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

   List<Animal> findByChipcode(String chipcode);

   List<Animal> findByNameAndAge(String name, Integer age);

   List<Animal> findByWeightLessThan (Double weight);


}
