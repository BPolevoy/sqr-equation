package com.example.sqr.equation.repository;

import com.example.sqr.equation.domain.ResultDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends CrudRepository<ResultDto, ResultDto> {

    @Override
    List<ResultDto> findAll();
}
