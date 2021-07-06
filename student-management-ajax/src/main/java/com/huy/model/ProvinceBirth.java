package com.huy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "provinceBirths")
public class ProvinceBirth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Student.class, fetch = FetchType.EAGER)
    private List<Student> students;

    public ProvinceBirth(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProvinceBirth{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
