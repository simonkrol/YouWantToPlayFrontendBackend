package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "shop_categories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "shop_id"))
    private final Set<Shop> linkedShops;

    public Category() {
        linkedShops = new HashSet<>();
    }

    public Category(String name)
    {
        this();
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName() { return name; }

    public void addLinkedShop(Shop toAdd)
    {
        linkedShops.add(toAdd);
    }

    public Set<Shop> getLinkedShops() { return new HashSet<>(linkedShops);}
}
