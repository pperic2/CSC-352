package group5.toolshare;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountsRepository extends MongoRepository<Accounts, String> {
    Accounts findBy_id(Long id);
    Accounts findByEmail(String email);
}