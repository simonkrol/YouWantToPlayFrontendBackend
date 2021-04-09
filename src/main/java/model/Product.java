package model;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Blob;
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private int inventory;

    private Long shopID;
    private String imageUrl;

    private String name;

    @Lob
    private byte[] image;

    public Product() { }

    public Product(String name, String description, int inventory, byte[] image, Long shopID, String imageUrl)
    {
        this.imageUrl = imageUrl;
        this.shopID = shopID;
        this.description = description;
        this.inventory = inventory;
        this.image = image;
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

    public long getShopId()
    {
        return shopID;
    }

    public void setShopId(long shopId){
        this.shopID = shopId;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
