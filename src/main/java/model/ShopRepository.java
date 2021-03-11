package model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "shopsRes", path="shopsRes")
public interface ShopRepository extends CrudRepository<Shop, Long> {
    Shop findById(Long id);
}
