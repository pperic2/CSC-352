package group5.toolshare.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "AllTools")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;


//    @Id
//    @GeneratedValue
//    private String id;

//    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    private String name;
    private String toolCategory;
    private String age;
    private String owner;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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
