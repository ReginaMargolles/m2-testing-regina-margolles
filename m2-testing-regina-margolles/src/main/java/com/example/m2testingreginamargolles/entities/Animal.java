package com.example.m2testingreginamargolles.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Long id;
    public String chipcode;
    public String name;
    public Integer age;
    public Double weight;

    public Animal() {}

    public Animal(Long id, String chipcode, String name, Integer age, Double weight) {
        this.id = id;
        this.chipcode = chipcode;
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChipcode() {
        return chipcode;
    }

    public void setChipcode(String chipcode) {
        this.chipcode = chipcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", chipcode='" + chipcode + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
