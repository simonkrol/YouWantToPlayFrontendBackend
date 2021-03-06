package model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Main
{
    public static void main(String[] args)
    {

        SpringApplication.run(Main.class, args);
    }
    @Bean
    public CommandLineRunner demo(CategoryRepository repository, ShoppingCartRepository cartRepo) {
        return (args) -> {
            // save a few customers
            ArrayList<String> tags = new ArrayList<String>(
                    Arrays.asList("Sports", "Education", "Entertainment", "Politics", "Travel", "Food"));
            for (String cat: tags)
            {
                Category category = new Category(cat);
                repository.save(category);
            }
            ShoppingCart shoppingCart = new ShoppingCart();
            cartRepo.save(shoppingCart);
        };
    }

}
