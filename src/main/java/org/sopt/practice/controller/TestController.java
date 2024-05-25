package org.sopt.practice.controller;

import org.sopt.practice.controller.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* 이 컨트롤러는 /test 경로로 들어오는 GET 요청에는 "test API" 문자열을 반환하고,
* /test/json 경로로 들어오는 GET 요청에는 JSON 형식의 응답을 반환
*/

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test(){
        return "test API";
    }

    @GetMapping("/json")
    public ApiResponse testJson(){
         return ApiResponse.create("test API with JSON");
    }
}
