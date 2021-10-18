package com.example.m2testingreginamargolles.controller;

import com.example.m2testingreginamargolles.entities.Animal;
import com.example.m2testingreginamargolles.repository.AnimalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class AnimalControllerMVC {

    AnimalRepository repository;

    public AnimalControllerMVC(AnimalRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/animals/show")
public String showAnimal(Model model) {

    Animal animal1 = new Animal(null, "123", "tortuga", 3, 0.8);
    Animal animal2 = new Animal(null, "456", "periquito", 2, 0.5);
    //Cargar los datos en el modelo
    repository.save(animal1);
    repository.save(animal2);
    model.addAttribute("animal1",animal1);
    model.addAttribute("animal2",animal2);

    return "animal-view";
}

@GetMapping("/animals")
public String findAll (Model model) {
    //List<Animal> animals = repository.findAll();
    List<Animal> animals = new ArrayList<>();
    animals = repository.findAll();
    System.out.println("El tamaño de la lista es: " + animals.size());

    model.addAttribute("animals", animals);
    return "animal-list";
}



}
