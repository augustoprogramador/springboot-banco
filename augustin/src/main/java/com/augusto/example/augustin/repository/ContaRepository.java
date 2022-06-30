package com.augusto.example.augustin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.augusto.example.augustin.model.Conta;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Long> {

}
