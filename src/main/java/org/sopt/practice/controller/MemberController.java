package org.sopt.practice.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.practice.service.dto.MemberCreateDto;
import org.sopt.practice.service.dto.MemberFindDto;
import org.sopt.practice.service.MemberService;
import org.sopt.practice.service.dto.UserJoinResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member") //어디로 요청이 들어올거냐?를 보는 것.
public class MemberController {

    private final MemberService memberService;

//    @PostMapping
//    public ResponseEntity postMember(@RequestBody MemberCreateDto memberCreate) {
//        return ResponseEntity.created(URI.create(memberService.createMember(memberCreate))).build();
//        //createMember가 MemberService의 함수이다.
//    }

    @PostMapping
    public ResponseEntity<UserJoinResponse> postMember(
            @RequestBody MemberCreateDto memberCreate
    ) {
        UserJoinResponse userJoinResponse = memberService.createMember(memberCreate);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", userJoinResponse.userId())
                .body(
                        userJoinResponse
                );
    }

    @GetMapping("/{memberId}")
    public  ResponseEntity<MemberFindDto> findMemberById(@PathVariable Long memberId){
        return ResponseEntity.ok(memberService.findMemberById(memberId));
        //findMemberById가 MemberService의 함수이다.
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMember(@PathVariable Long memberId){
        memberService.deleteMemberById(memberId);    //deleteMemberById가 MemberService의 함수이다.

        return ResponseEntity.noContent().build();
        /*
        클라이언트에게 반환할 데이터가 없으므로, HTTP 상태 코드 204(No Content)를 함께 응답합니다.
        이는 요청이 성공적으로 처리되었지만 응답으로 반환할 데이터가 없음을 나타냅니다.
         */

    }

}
