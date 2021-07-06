package com.huy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String dateOfBirth;
    private String idCard;
    private String telephoneNumbers;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "provinceBirth_id")
    private ProvinceBirth provinceBirth;

    public Student(String fullName, String dateOfBirth, String idCard, String telephoneNumbers, String email, String address) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.telephoneNumbers = telephoneNumbers;
        this.email = email;
        this.address = address;
    }

    public Student(String fullName, String dateOfBirth, ProvinceBirth provinceBirth, String idCard, String telephoneNumbers, String email, String address) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.provinceBirth = provinceBirth;
        this.idCard = idCard;
        this.telephoneNumbers = telephoneNumbers;
        this.email = email;
        this.address = address;
    }

    @Override
    public Student clone() {
        Student student = new Student();
        student.setId(id);
        student.setFullName(fullName);
        student.setDateOfBirth(dateOfBirth);
        student.setIdCard(idCard);
        student.setTelephoneNumbers(telephoneNumbers);
        student.setEmail(email);
        student.setAddress(address);
        student.setProvinceBirth(provinceBirth);
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", idCard='" + idCard + '\'' +
                ", telephoneNumbers='" + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", provinceBirth=" + provinceBirth +
                '}';
    }
}
