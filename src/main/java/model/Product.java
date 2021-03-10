package model;

import java.awt.image.BufferedImage;

public class Product {
    private String description;
    private int inventory;
    private BufferedImage image;

    public Product(String description, int inventory, BufferedImage image)
    {
        this.description = description;
        this.inventory = inventory;
        this.image = image;
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

    public BufferedImage getImage()
    {
        return image;
    }

    public void setImage(BufferedImage image)
    {
        this.image = image;
    }
}
