package group5.toolshare;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(collection = "accounts")
public class Accounts {
    @Id
    @Field("_id")
    private Long id;

    @Field("email")
//    @Email(message = "*Please provide a valid Email")
//    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Field("password")
//    @Length(min = 5, message = "*Your password must have at least 5 characters")
//    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Field("name")
//    @NotEmpty(message = "*Please provide your name")
    private String name;

    @Field("last_name")
//    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
