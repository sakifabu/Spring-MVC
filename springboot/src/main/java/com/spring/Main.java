package com.spring;

import com.spring.Model.Customer;
import com.spring.Model.TeacherProject;
import com.spring.Repository.CustomerRepository;
import com.spring.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Brian on 4/24/2017.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Main implements CommandLineRunner {
    @Autowired
    private ProjectRepository reposit;
    @Autowired
    private CustomerRepository repository;
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        reposit.deleteAll();
        reposit.save(new TeacherProject("Test", 1, 4, 4, 4, 4, 4, 4));
        for (TeacherProject teacher : reposit.findAll()){
            System.out.println(teacher);
        }
        */

        /*
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }
        */
    }
}
