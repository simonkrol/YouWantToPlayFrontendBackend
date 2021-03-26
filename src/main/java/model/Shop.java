package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "linkedShops",  cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private final Set<Category> categories;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    public Shop() {
        this.categories = new HashSet<>();
    }
    
    public Shop(String name, List<Product> products)
    {
        this();
        this.name = name;
        this.products = products;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<Category> getCategories()
    {
        return categories;
    }

    public void addCategory(Category category)
    {
        categories.add(category);
        category.addLinkedShop(this);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
