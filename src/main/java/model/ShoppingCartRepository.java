package model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.ArrayList;

@RepositoryRestResource(collectionResourceRel = "shoppingCartsRes", path="shoppingCartsRes")
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
    ShoppingCart findById(long id);

    ArrayList<ShoppingCart> findAll();
}


