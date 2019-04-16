package com.andrevitoria.sgm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andrevitoria.sgm.domain.Protocol;

@Repository
public interface ProtocolRepository extends JpaRepository<Protocol, String> {

}
