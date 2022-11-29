package com.example.sqr.equation.service;

import com.example.sqr.equation.domain.EquationAnswer;
import com.example.sqr.equation.domain.RequestEquation;

public interface CalculateService {

    double calcDiscriminant(RequestEquation requestEquation);

    EquationAnswer calcRadical(double discriminant, RequestEquation requestEquation);
}
