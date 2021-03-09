package model;

import java.util.List;

public class Shop {
    private String name;
    private List<String> categories;
    private List<Product> products;

    public Shop(String name, List<String> categories)
    {
        this.name = name;
        this.categories = categories;
    }


}
