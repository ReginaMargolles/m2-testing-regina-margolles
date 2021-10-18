package com.example.m2testingreginamargolles;

import com.example.m2testingreginamargolles.entities.Animal;
import com.example.m2testingreginamargolles.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
@SpringBootApplication
public class M2TestingReginaMargollesApplication implements CommandLineRunner {

	@Autowired
	AnimalRepository animalRepository;

	public static void main(String[] args) {
		SpringApplication.run(M2TestingReginaMargollesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*	Animal animal1 = new Animal(null, "123", "yuko", 14, 30.0);
			Animal animal2 = new Animal(null, "456", "lea", 10, 23.8);
			Animal animal3 = new Animal(null, "678", "Noa", 4, 15.9);
			animalRepository.save(animal1);
			animalRepository.save(animal2);
			animalRepository.save(animal3); */
		Scanner scanner = new Scanner(System.in);
		Integer option;
		try {
			do {
				ShowMenu();
				option = scanner.nextInt();
				switch (option) {
					case 1:
						createAnimal();
						break;
					case 2:
						showAllAnimal();
						break;
					case 3:
						showAnimalById();
						break;
					case 4:
						modifyAnimal();
						break;
					case 5:
						deleteAnimal();
						break;
					case 6:
						deleteAllAnimal();
						break;
					case 7:
						countNumberOfAnimal();
						break;
					case 8:
						existsById();
						break;
					case 9:
						findByChipcode();
						break;
					case 10:
						findByNameAndAge();
						break;
					case 11:
						findByWeightLessThan();
						break;


				}

			} while (option != 12);


		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	private void createAnimal() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca el codigo de chip");
		String chipcode = scanner.next();
		System.out.println("Introduzca el nombre del animal");
		String name = scanner.next();
		System.out.println("Introduzca la edad del animal");
		Integer age = scanner.nextInt();
		System.out.println("Introduzca el peso del animal");
		Double weight = scanner.nextDouble();
		Animal animal = new Animal(null, chipcode, name, age, weight);
		animalRepository.save(animal);

	}

	private void showAllAnimal() {

		List<Animal> animals = animalRepository.findAll();
		if (animals.isEmpty()) {
			System.out.println("No hay animales en la base de datos");
		} else {
			for (Animal animal : animals)
				System.out.println(animal);
		}

	}

	private void showAnimalById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca el id del animal a mostrar");
		Long id = scanner.nextLong();
		Optional<Animal> animalOptional = animalRepository.findById(id);
		if (animalOptional.isEmpty()) {
			System.out.println("El animal no existe");
		} else {
			Animal animal = animalOptional.get();
			System.out.println(animal);
		}
	}

	private void modifyAnimal() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca el id del animal a modificar");
		Long id = scanner.nextLong();
		Optional<Animal> animalOptional = animalRepository.findById(id);
		if (animalOptional.isPresent()) {
			Animal animalmodify = animalOptional.get();
			System.out.println("Introduzca el codigo de chip (actual: " + animalmodify.getChipcode() + ")");
			String chipcode = scanner.next();
			animalmodify.setChipcode(chipcode);
			System.out.println("Introduzca el nombre del animal (actual: " + animalmodify.getName() + ")");
			String name = scanner.next();
			animalmodify.setName(name);
			System.out.println("Introduzca la edad del animal (actual: " + animalmodify.getAge() + ")");
			Integer age = scanner.nextInt();
			animalmodify.setAge(age);
			System.out.println("Introduzca el peso del animal (actual: " + animalmodify.getWeight() + ")");
			Double weight = scanner.nextDouble();
			animalmodify.setWeight(weight);
			animalRepository.save(animalmodify);
		} else {
			System.out.println("No existe el animal con el id: " + id);
		}

	}

	private void deleteAnimal() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escriba el id del animal a borrar");
		Long id = scanner.nextLong();
		boolean exist = animalRepository.existsById(id);
		if (exist) {
			animalRepository.deleteById(id);
			System.out.println("El animal se ha borrado correctamente");
		} else {
			System.out.println("No existe el animal en la base de datos");
		}
	}

	private void countNumberOfAnimal() {
		Long number_element;
		number_element = animalRepository.count();
		System.out.println("El número de elementos es: " + number_element);
	}

	private void existsById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escriba el id del animal a buscar");
		Long id = scanner.nextLong();
		if (animalRepository.existsById(id)) {
			System.out.println("El animal con id: " + id + " existe en la base de datos");
		} else {
			System.out.println("El animal con id: " + id + " no existe en la base de datos");
		}

	}


	private void deleteAllAnimal() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Desea borrar todos los animales (true o false");
		Boolean confirm = scanner.nextBoolean();
		if (confirm) {
			animalRepository.deleteAll();
			System.out.println("Se han borrado todos los animales de la base de datos");
		}
	}

	private void findByChipcode() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escriba el numero de chip a buscar");
		String chipcode = scanner.next();
		List<Animal> lista = animalRepository.findByChipcode(chipcode);
		if (!lista.isEmpty()) {
			for (Animal animal : lista)
				System.out.println(animal);
		} else {
			System.out.println("No se ha encontrado ningun animal para el codigo de chip: " + chipcode);
		}

	}

	private void findByNameAndAge() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escriba el nombre del animal a buscar");
		String name = scanner.next();
		System.out.println("Escriba la edad del animal a buscar");
		Integer age = scanner.nextInt();
		List<Animal> lista = animalRepository.findByNameAndAge(name, age);
		if (!lista.isEmpty()) {
			for (Animal animal : lista)
				System.out.println(animal);
		} else {
			System.out.println("No se ha encontrado ningun animal para el nombre: " + name + " y la edad: " + age);
		}

	}

	private void findByWeightLessThan() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escriba el peso menor que a buscar");
		Double weight = scanner.nextDouble();
		List<Animal> lista = animalRepository.findByWeightLessThan(weight);
		if (!lista.isEmpty()) {
			for (Animal animal : lista)
				System.out.println(animal);
		} else {
			System.out.println("No se ha encontrado ningun animal con el peso menor que : " + weight);
		}
	}


	public void ShowMenu() {
		System.out.println("**********************MENU***********************");
		System.out.println(" 1 . Crear un animal");
		System.out.println(" 2 . Buscar todos los animales");
		System.out.println(" 3 . Buscar un animal por id");
		System.out.println(" 4 . Modificar un animal");
		System.out.println(" 5 . Borrar un animal por id");
		System.out.println(" 6 . Borrar todos los animales");
		System.out.println(" 7 . Contar el número de animales existentes");
		System.out.println(" 8 . Comprobar si existe un animal por id");
		System.out.println(" 9 . Encontrar un animal por codigo de chip");
		System.out.println(" 10. Encontrar un animal por nombre y edad");
		System.out.println(" 11. Encontrar un animal por peso menor que");
		System.out.println(" 12. Salir");
		System.out.println("**************************************************");
	}

}
