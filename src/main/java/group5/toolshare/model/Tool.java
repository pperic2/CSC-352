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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getOwner() {
        return owner;
    }

    public String getToolCategory() {
        return toolCategory;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setToolCategory (String toolCategory) {
        this.toolCategory = toolCategory;
    }

    public void setOwner (String owner){
        this.owner = owner;
    }
}
