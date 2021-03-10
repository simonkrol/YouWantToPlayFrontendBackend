package model;

import java.util.List;

public class Shop {
    private String name;
    private List<String> categories;
    private List<Product> products;

    public Shop(String name, List<String> categories, List<Product> products)
    {
        this.name = name;
        this.categories = categories;
        this.products = products;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<String> getCategories()
    {
        return categories;
    }

    public void setCategories(List<String> categories)
    {
        this.categories = categories;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
