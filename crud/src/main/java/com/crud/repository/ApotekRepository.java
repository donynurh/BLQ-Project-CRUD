package com.crud.repository;

import com.crud.Entity.ApotekModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApotekRepository extends JpaRepository<ApotekModel, Long> {
}
