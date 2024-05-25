package org.sopt.practice.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Part part;

    private int age;


    //@Builder 애노테이션 붙임으로써 그냥 빌더패턴과 같아짐
    @Builder
    private Member(String name, Part part, int age){
        this.name=name;
        this.part=part;
        this.age=age;
    }

    //이거와 같아진 것! 편한거 골라서 쓰면 된다.
    public static Member create(String name, Part part,int age){
        return Member.builder()
                .name(name)
                .part(part)
                .age(age)
                .build();
    }
}