package model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productsRes", path="productsRes")
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findById(long id);
}
