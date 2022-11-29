package com.example.sqr.equation.repository;

import com.example.sqr.equation.domain.DtoResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DtoResultRepository extends CrudRepository<DtoResult, DtoResult> {
}
