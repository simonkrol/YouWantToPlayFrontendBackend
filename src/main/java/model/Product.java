package model;

import javax.persistence.*;
import java.sql.Blob;
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private int inventory;
    private Long shopID;
    private String Name;

    @Lob
    private byte[] image;

    public Product() { }

    public Product(String description, int inventory, byte[] image, Long shopID)
    {
        this.shopID = shopID;
        this.description = description;
        this.inventory = inventory;
        this.image = image;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getInventory()
    {
        return inventory;
    }

    public void setInventory(int inventory)
    {
        this.inventory = inventory;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

    public Long getShopId()
    {
        return shopID;
    }
}
