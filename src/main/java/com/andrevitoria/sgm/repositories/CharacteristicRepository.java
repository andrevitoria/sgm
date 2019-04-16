package com.andrevitoria.sgm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andrevitoria.sgm.domain.Characteristic;

@Repository
public interface CharacteristicRepository extends JpaRepository<Characteristic, Integer> {

}
