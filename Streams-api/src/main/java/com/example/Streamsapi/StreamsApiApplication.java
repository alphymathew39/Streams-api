package com.example.Streamsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class StreamsApiApplication {


static List<Employee> employees = new ArrayList<>();
static {
	employees.add(new Employee("Anu","kumar", 50000.0,List.of("project1","project2")));
	employees.add(new Employee("manu","nikhil", 20000.0,List.of("project2","project3")));
	employees.add(new Employee("neethu","ram", 35000.0,List.of("project3","project4")));
}


	public static void main(String[] args) {

//		SpringApplication.run(StreamsApiApplication.class, args);

		//foreach
		employees.stream()
				.forEach(employee -> System.out.println(employee));


		//map and collect
		List<Employee> increasedSalary = employees.stream()
//		Set<Employee> increasedSalary = employees.stream()
				.map(employee ->  new Employee(
						employee.getFirstName(),
						employee.getLastName(),
						employee.getSalary() *1.10,
						employee.getProjects()
				))
				.collect(Collectors.toList());
			//		.collect(Collectors.toSet());
		System.out.println(increasedSalary);


		//filter
		List<Employee> filterSalary = employees.stream()
				.filter(employee -> employee.getSalary() > 25000.0)
				.map(employee ->  new Employee(
						employee.getFirstName(),
						employee.getLastName(),
						employee.getSalary() *1.10,
						employee.getProjects()
				))
				.collect(Collectors.toList());
		System.out.println( filterSalary);



		//findFirst
		Employee firstEmployee = employees.stream()
				.filter(employee -> employee.getSalary() > 25000.0)
				.map(employee ->  new Employee(
						employee.getFirstName(),
						employee.getLastName(),
						employee.getSalary() *1.10,
						employee.getProjects()
				))
						.findFirst().orElse(null);
		System.out.println( firstEmployee);

		//flatMap
		String projects = employees.stream()
				.map(employee -> employee.getProjects())
				.flatMap(strings -> strings.stream())
				.collect(Collectors.joining(","));
		System.out.println(projects);

		//short circuit operations
		List<Employee> shortCircuit = employees.stream()
				.skip(1)
				.limit(1)
				.collect(Collectors.toList());
		System.out.println(shortCircuit);

		//Finite Data
		Stream.generate(Math::random)
				.limit(5)
				.forEach( value -> System.out.println(value));

		//sorting
		List<Employee> sortedEmployees = employees.stream()
				.sorted((o1,o2) -> o1.getFirstName()
				.compareToIgnoreCase(o2.getFirstName()))
						.collect(Collectors.toList());
		System.out.println(sortedEmployees);

		//min and max
		Employee maxSalary = employees.stream()
				.max(Comparator.comparing(Employee::getSalary))
				.orElseThrow(NoSuchElementException::new);
		System.out.println(maxSalary);

		//reduce
		 Double totalSalary = employees.stream()
				 .map(employee ->  employee.getSalary())
				 .reduce(0.0, Double::sum);
		System.out.println(totalSalary);

















	}
}
