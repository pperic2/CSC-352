package group5.toolshare;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "accounts")
public class Accounts {
    @Id
    private String id;

    private String name;

    @Indexed(unique = true)
    private String email;
}
