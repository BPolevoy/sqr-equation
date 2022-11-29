package com.example.sqr.equation.service;

import com.example.sqr.equation.domain.AnswerEquation;
import com.example.sqr.equation.domain.RequestEquation;

public interface CalculateService {

    double calcDiscriminant(RequestEquation equation);

    AnswerEquation calcRadical(double dis, RequestEquation requestEquation);
}
