package com.andrevitoria.sgm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.andrevitoria.sgm.domain.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
	/*
	 * @Transactional(readOnly = true) public Document findByDescription();
	 */
	 @Transactional(readOnly = true)
	Document findByDescription(String description);
}
