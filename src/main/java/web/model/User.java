package web.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @NotEmpty(message = "The name cannot be empty")
    @Size(min = 2, max = 15, message = "The name must consist of less than 2 and no more than 15 characters")
    private String name;
    @Min(value = 14, message = "Access to persons under 14 years of age is prohibited")
    @Max(value = 150, message = "The age is too great")
    private int age;
    @Email(message = "The email does not meet the requirements")
    @NotEmpty(message = "The email cannot be empty")
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public User() {

    }

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "   name = " + name +
                "  age = " + age +
                "  email = " + email + "   ";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
