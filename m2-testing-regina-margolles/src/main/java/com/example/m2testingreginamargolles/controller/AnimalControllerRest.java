package com.example.m2testingreginamargolles.controller;

import com.example.m2testingreginamargolles.entities.Animal;
import com.example.m2testingreginamargolles.repository.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalControllerRest {

  AnimalRepository repository;


  public AnimalControllerRest(AnimalRepository repository) {
        this.repository = repository;
    }

   @GetMapping("/animal")
   public List<Animal>  findAll() {
        return repository.findAll();
   }

   @GetMapping("/data")
    public void demoData() {
       Animal animal1 = new Animal(null, "123", "yuko", 14, 30.0);
       Animal animal2 = new Animal(null, "456", "lea", 10, 23.8);
       Animal animal3 = new Animal(null, "678", "Noa", 4, 15.9);
       repository.save(animal1);
       repository.save(animal2);
       repository.save(animal3);
   }

   @PostMapping("/animal")
        public void create (@RequestBody Animal animal){
        if (animal.getId() == null)
            repository.save(animal);
   }

   @PutMapping("/animal")
        public void update (@RequestBody Animal animal){
        if (animal.getId() != null && repository.existsById(animal.getId()))
            repository.save(animal);
   }

   @DeleteMapping("/animal/{id}")
        public void deleteById (@PathVariable Long id){
        if (repository.existsById(id))
            repository.deleteById(id);
   }







}
