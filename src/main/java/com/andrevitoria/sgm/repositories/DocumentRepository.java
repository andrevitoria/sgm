package com.andrevitoria.sgm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.andrevitoria.sgm.domain.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
