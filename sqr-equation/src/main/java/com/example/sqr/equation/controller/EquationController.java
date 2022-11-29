package com.example.sqr.equation.controller;


import com.example.sqr.equation.domain.AnswerEquation;
import com.example.sqr.equation.domain.DtoResult;
import com.example.sqr.equation.domain.RequestEquation;
import com.example.sqr.equation.repository.DtoResultRepository;
import com.example.sqr.equation.service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equation")
public class EquationController {

    private final CalculateService calculateService;

    private final DtoResultRepository dtoResultRepository;

    @GetMapping
    public ResponseEntity<AnswerEquation> getAnswer(@RequestBody RequestEquation equation) {
        var dis = calculateService.calcDiscriminant(equation);
        var response = ResponseEntity.badRequest();
        if (dis < 0) {
            return response.build();
        }
        if (equation.getA() == 0 && equation.getB() == 0) {
            return response.build();
        }
        return ResponseEntity.ok(calculateService.calcRadical(dis, equation));

    }

    @GetMapping("/")
    public ResponseEntity<Iterable<DtoResult>> getData() {
        return ResponseEntity.ok(dtoResultRepository.findAll());

    }


}
