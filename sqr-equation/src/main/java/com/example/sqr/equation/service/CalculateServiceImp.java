package com.example.sqr.equation.service;

import com.example.sqr.equation.domain.AnswerEquation;
import com.example.sqr.equation.domain.DtoResult;
import com.example.sqr.equation.domain.RequestEquation;
import com.example.sqr.equation.repository.DtoResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculateServiceImp implements CalculateService {

    private final DtoResultRepository dtoResultRepository;

    @Override
    public double calcDiscriminant(RequestEquation equation) {
        return equation.getB() * equation.getB() - 4 * equation.getA() * equation.getC();
    }

    public AnswerEquation calcRadical(double dis, RequestEquation requestEquation) {
        var result = new AnswerEquation();
        var d = Math.sqrt(dis);
        if (requestEquation.getA() == 0) {
            result.setRadicalFirst(-requestEquation.getC() / requestEquation.getB());
        } else {
            result.setRadicalFirst(((-requestEquation.getB()) + d) / 2 * requestEquation.getA());
            result.setRadicalSecond(((-requestEquation.getB()) - d) / 2 * requestEquation.getA());
        }
        mappingToAnswer(requestEquation, result);
        return result;
    }

    void mappingToAnswer(RequestEquation requestEquation, AnswerEquation answerEquation) {
        var result = new DtoResult();
        result.setA(requestEquation.getA());
        result.setB(requestEquation.getB());
        result.setC(requestEquation.getC());
        result.setRadicalFirst(answerEquation.getRadicalFirst());
        result.setRadicalSecond(answerEquation.getRadicalSecond());
        dtoResultRepository.save(result);
    }
}
