package com.andrevitoria.sgm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andrevitoria.sgm.domain.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {

}
