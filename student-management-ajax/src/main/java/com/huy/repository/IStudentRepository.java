package com.huy.repository;

import com.huy.model.ProvinceBirth;
import com.huy.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    Iterable<Student> findAllByProvinceBirth(ProvinceBirth provinceBirth);
    Page<Student> findAllByFullNameContaining(String fullName, Pageable pageable);
}
