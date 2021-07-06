package com.huy.repository;

import com.huy.model.ProvinceBirth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceBirthRepository extends JpaRepository<ProvinceBirth, Long> {
}
