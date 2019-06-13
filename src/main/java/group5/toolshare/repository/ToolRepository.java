package group5.toolshare.repository;

import group5.toolshare.model.Tool;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Helps to perform CRUD operations for Tool
 */
@RepositoryRestResource
public interface ToolRepository extends CrudRepository<Tool, Long>  {
    Tool findByNameAndOwner(String name, String owner);
}