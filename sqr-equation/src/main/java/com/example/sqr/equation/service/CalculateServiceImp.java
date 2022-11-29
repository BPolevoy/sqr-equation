package com.example.sqr.equation.service;

import com.example.sqr.equation.domain.EquationAnswer;
import com.example.sqr.equation.domain.ResultDto;
import com.example.sqr.equation.domain.RequestEquation;
import com.example.sqr.equation.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculateServiceImp implements CalculateService {

    private final ResultRepository resultRepository;

    @Override
    public double calcDiscriminant(RequestEquation requestEquation) {
        return requestEquation.getB() * requestEquation.getB() - 4 * requestEquation.getA() * requestEquation.getC();
    }

    public EquationAnswer calcRadical(double discriminant, RequestEquation requestEquation) {
        var result = new EquationAnswer();
        var d = Math.sqrt(discriminant);
        if (requestEquation.getA() == 0) {
            result.setFirstRadical(-requestEquation.getC() / requestEquation.getB());
        } else {
            result.setFirstRadical((-requestEquation.getB() + d) / 2 * requestEquation.getA());
            result.setSecondRadical((-requestEquation.getB() - d) / 2 * requestEquation.getA());
        }
        mappingToAnswer(requestEquation, result);
        return result;
    }

    private void mappingToAnswer(RequestEquation requestEquation, EquationAnswer equationAnswer) {
        var result = new ResultDto();
        result.setA(requestEquation.getA());
        result.setB(requestEquation.getB());
        result.setC(requestEquation.getC());
        result.setFirstRadical(equationAnswer.getFirstRadical());
        result.setSecondRadical(equationAnswer.getSecondRadical());
        resultRepository.save(result);
    }
}
