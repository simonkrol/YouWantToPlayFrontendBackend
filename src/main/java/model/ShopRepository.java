package model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "shops", path="shops")
public interface ShopRepository extends CrudRepository<Shop, Long> {
    Shop findById(Long id);
}