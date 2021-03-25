package model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "shopsRes", path="shopsRes")
public interface ShopRepository extends CrudRepository<Shop, Long> {
    Shop findById(long id);
}
