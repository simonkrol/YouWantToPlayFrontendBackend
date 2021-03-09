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
}
