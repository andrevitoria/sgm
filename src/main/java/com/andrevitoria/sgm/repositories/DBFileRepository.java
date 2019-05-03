package com.andrevitoria.sgm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andrevitoria.sgm.domain.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}