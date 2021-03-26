package model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "categoriesRes", path="categoriesRes")
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findById(long id);
    Category findByName(String name);
}
