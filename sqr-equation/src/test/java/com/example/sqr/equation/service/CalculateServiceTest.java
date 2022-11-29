package com.example.sqr.equation.service;

import com.example.sqr.equation.domain.RequestEquation;
import com.example.sqr.equation.repository.DtoResultRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculateServiceTest {

    @Autowired
    CalculateService calculateService;

    @MockBean
    DtoResultRepository dtoResultRepository;

    @Test
    public void calcDiscriminant() {
        var req = new RequestEquation();
        req.setA(1);
        req.setB(3);
        req.setC(-4);
        var result = calculateService.calcDiscriminant(req);
        Assertions.assertEquals(result, 25);
    }

    @Test
    public void calcRadicalTest(){
        var req = new RequestEquation();
        req.setA(1);
        req.setB(3);
        req.setC(-4);
        var result = calculateService.calcRadical(calculateService.calcDiscriminant(req), req);
        Assertions.assertAll("",
                ()-> Assertions.assertEquals(result.getRadicalFirst(), 1),
                ()->Assertions.assertEquals(result.getRadicalSecond(), -4));
    }
}
