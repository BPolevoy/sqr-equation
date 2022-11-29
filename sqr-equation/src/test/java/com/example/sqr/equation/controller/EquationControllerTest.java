package com.example.sqr.equation.controller;

import com.example.sqr.equation.domain.AnswerEquation;
import com.example.sqr.equation.domain.RequestEquation;
import com.example.sqr.equation.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EquationControllerTest {

    @MockBean
    private CalculateService calculateService;

    @Autowired
    private EquationController equationController;

    @Test
    public void getAnswerTest() {
        var mockResult = new AnswerEquation();
        mockResult.setRadicalFirst(1.1);
        mockResult.setRadicalFirst(1.1);
        Mockito.when(calculateService.calcRadical(Mockito.anyDouble(), Mockito.any(RequestEquation.class))).thenReturn(mockResult);
        Mockito.when(calculateService.calcDiscriminant(Mockito.any())).thenReturn(1.1);
        var req = new RequestEquation();
        req.setA(1.1);
        req.setB(1.1);
        req.setC(1.1);
        var result = new AnswerEquation();
        result.setRadicalFirst(1.1);
        result.setRadicalSecond(1.1);
        var r = equationController.getAnswer(req);
        Assertions.assertEquals(mockResult, r.getBody());
    }

    @Test
    public void getAnswerErrorTest() {
        Mockito.when(calculateService.calcDiscriminant(Mockito.any())).thenReturn(-1.1);
        var req = new RequestEquation();
        req.setA(1.1);
        req.setB(1.1);
        req.setC(1.1);
        var r = equationController.getAnswer(req);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, r.getStatusCode());
    }
}
