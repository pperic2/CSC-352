package group5.toolshare.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Helps to perform CRUD operations for Tool
 */
@RepositoryRestResource
public interface ToolRepository extends CrudRepository<Tool, Long>  {
    Tool findByID(Long id);
}
