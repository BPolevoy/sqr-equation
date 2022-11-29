package com.example.sqr.equation.service;

import com.example.sqr.equation.domain.RequestEquation;
import com.example.sqr.equation.repository.ResultRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculateServiceTest {

    @Autowired
    private CalculateService calculateService;

    @MockBean
    private ResultRepository resultRepository;

    @Test
    public void calcDiscriminant() {
        var requestEquation = new RequestEquation();
        requestEquation.setA(1);
        requestEquation.setB(3);
        requestEquation.setC(-4);
        var result = calculateService.calcDiscriminant(requestEquation);
        Assertions.assertEquals(result, 25);
    }

    @Test
    public void calcRadicalTest() {
        var requestEquation = new RequestEquation();
        requestEquation.setA(1);
        requestEquation.setB(3);
        requestEquation.setC(-4);
        var result = calculateService.calcRadical(calculateService.calcDiscriminant(requestEquation), requestEquation);
        Assertions.assertAll("radical",
                () -> Assertions.assertEquals(result.getFirstRadical(), 1),
                () -> Assertions.assertEquals(result.getSecondRadical(), -4));
    }
}
