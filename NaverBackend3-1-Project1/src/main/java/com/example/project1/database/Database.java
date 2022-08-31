package com.example.project1.database;

import com.example.project1.entity.Customer;
import com.example.project1.entity.Product;
import com.example.project1.repository.jpa.CustomerRepository;
import com.example.project1.repository.jpa.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class Database {
    private static  final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository, ProductRepository productRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // Init customer
                Customer customer1 = new Customer("Huy Hoang 1", "a", "1");
                logger.info("insert data:" + customerRepository.save(customer1));
                Customer customer2 = new Customer("Huy Hoang 2", "b", "2");
                logger.info("insert data:" + customerRepository.save(customer2));
                Customer customer3 = new Customer("Huy Hoang 3", "c", "3");
                logger.info("insert data:" + customerRepository.save(customer3));
                Customer customer4 = new Customer("Huy Hoang 4", "d", "4");
                logger.info("insert data:" + customerRepository.save(customer4));
                Customer customer5 = new Customer("Huy Hoang 5", "e", "5");
                logger.info("insert data:" + customerRepository.save(customer5));

                // Init product
                Product product1 = new Product("product1", "1", "1", 5L, new BigDecimal(23145L));
                logger.info("insert data:" + productRepository.save(product1));
                Product product2 = new Product("product2", "12", "12", 5L, new BigDecimal(41325L));
                logger.info("insert data:" + productRepository.save(product2));
                Product product3 = new Product("product3", "13", "13", 5L, new BigDecimal(144325L));
                logger.info("insert data:" + productRepository.save(product3));
                Product product4 = new Product("product4", "14", "14", 5L, new BigDecimal(14655L));
                logger.info("insert data:" + productRepository.save(product4));
                Product product5 = new Product("product5", "15", "15", 5L, new BigDecimal(14574L));
                logger.info("insert data:" + productRepository.save(product5));
                Product product6 = new Product("product6", "16", "16", 5L, new BigDecimal(145536L));
                logger.info("insert data:" + productRepository.save(product6));
                Product product7 = new Product("product7", "17", "17", 5L, new BigDecimal(53145L));
                logger.info("insert data:" + productRepository.save(product7));
                Product product8 = new Product("product8", "18", "18", 5L, new BigDecimal(54145L));
                logger.info("insert data:" + productRepository.save(product8));
                Product product9 = new Product("product9", "19", "19", 5L, new BigDecimal(144365L));
                logger.info("insert data:" + productRepository.save(product9));
                Product product10 = new Product("product10", "10", "10", 5L, new BigDecimal(12445L));
                logger.info("insert data:" + productRepository.save(product10));
            }
        };
    }


}
