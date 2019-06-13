package group5.toolshare.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AllTools")
public class Tool {

    @Id
    private Long id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    private String name;
    private String toolCategory;
    private String age;
    private String owner;

}
