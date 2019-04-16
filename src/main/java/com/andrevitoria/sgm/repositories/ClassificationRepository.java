package com.andrevitoria.sgm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andrevitoria.sgm.domain.Classification;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Integer> {

}
