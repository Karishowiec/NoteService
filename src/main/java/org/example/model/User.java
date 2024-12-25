package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматична генерація ID
    private Long id;

    @Column(nullable = false) // Колонка не може бути null
    private String name;

    @Column(unique = true) // Унікальне значення
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Note>notes;
    // Геттери і Сеттери
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}