package com.example.sqr.equation.controller;


import com.example.sqr.equation.domain.EquationAnswer;
import com.example.sqr.equation.domain.ResultDto;
import com.example.sqr.equation.domain.RequestEquation;
import com.example.sqr.equation.repository.ResultRepository;
import com.example.sqr.equation.service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equation")
public class EquationController {

    private final CalculateService calculateService;

    private final ResultRepository resultRepository;

    @GetMapping
    public ResponseEntity<EquationAnswer> getAnswer(@RequestBody RequestEquation equation) {
        var dis = calculateService.calcDiscriminant(equation);
        if (dis < 0 || (equation.getA() == 0 && equation.getB() == 0)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(calculateService.calcRadical(dis, equation));
    }

    @GetMapping("/")
    public ResponseEntity<List<ResultDto>> getData() {
        return ResponseEntity.ok(resultRepository.findAll());
    }


}
