package org.sopt.practice.settings;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest { //포트를 지정해 주는 것
    //다형성을 사용하기 위해 추상화 이용

    @LocalServerPort
    private  int port;

    @BeforeEach
    void SetUp(){
        RestAssured.port=port;
    }
}
