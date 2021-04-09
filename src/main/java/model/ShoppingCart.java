package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private HashMap<Long, Integer> cart;

    public ShoppingCart(){
        this.cart = new HashMap<Long, Integer>();
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public HashMap<Long, Integer> getCart() {
        return cart;
    }

    public void setCart(HashMap<Long, Integer> cart) {
        this.cart = cart;
    }

    public void add(Product prod, int count){
        cart.put(prod.getId(), count);
    }

    //Not in requirements. Not doing
    public void remove(Product prod, int count){

    }

}
