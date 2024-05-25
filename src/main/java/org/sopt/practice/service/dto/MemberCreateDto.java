package org.sopt.practice.service.dto;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.sopt.practice.domain.Part;


/*
- 자동으로 접근자 메서드(getter)가 생성된다.
- 레코드는 equals(), hashCode(), toString() 메서드가 자동으로 생성
- 레코드는 불변(immutable)하며, 한 번 생성되면 내부 상태를 변경할 수 없습니다.
- 필드를 final로 선언하여 보장
 */
public record MemberCreateDto(
        String name,
        Part part,
        int age
) {
}

