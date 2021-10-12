package com.fox.model.entity;
import java.sql.Timestamp;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class User {

    private Integer id;
    private String surname;
    private String name;
    private String email;
    private String gender;
    private Integer age;
    private Timestamp birthday;
    private String phone;

    public User(Integer id, String surname, String name, String email, String gender, Integer age,
                Timestamp birthday, String phone) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.phone = phone;
    }

    public User(String surname, String name, String email, String gender, Integer age,
                Timestamp birthday, String phone) {
        this(null, surname, name, email, gender, age, birthday, phone);
    }

    @Override
    public String toString() {
        return "\n\nUser: id: " + id + ", surname: " + surname + ", name: " + name + ", email: " + email
                + ", gender: " + gender + ", age: " + age + ", birthday: " + birthday + ", phone: " + phone
                + "]";
    }
}
