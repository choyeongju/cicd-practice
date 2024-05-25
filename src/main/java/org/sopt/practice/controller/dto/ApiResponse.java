package org.sopt.practice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


/*
JSON 통신을 해야 하므로, 이 클래스를 활용하여 JSON 객체를 만드는 것이다.
리스폰스 객체의 필드에 접근해야하기 때문에 @Getter 어노테이션이 없으면 통신이 되지 않음.
 */
@AllArgsConstructor //생성자 자동으로 생성해줌
@Getter
public class ApiResponse {
    private String content;

    public static ApiResponse create(String content){
        return new ApiResponse(content);
    }

}
