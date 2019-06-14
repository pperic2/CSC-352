package group5.toolshare.repository;

import group5.toolshare.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RoleRepository extends MongoRepository<Role, String>{

    Role findByRole(String role);

}
