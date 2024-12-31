package board.com.member.controller;

import board.com.member.dto.MemberDto;
import board.com.member.entity.Member;
import board.com.member.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberInfoController {

    @Autowired
    private MemberInfoService memberInfoService;

    /**
     * 회원 개인정보 조회
     */
    @GetMapping("/info/{id}")
    public MemberDto retrieveMember(@PathVariable(value = "id") String id){
        Member member = memberInfoService.retrieveMember(id);
        return new MemberDto(member);
    }

    /**
     * 회원 개인정보 전체 조회
     */
    @GetMapping
    public List<MemberDto> retrieveMembers() {
        List<Member> memberList = memberInfoService.retrieveMembers();
        List<MemberDto> memberDtoList = new ArrayList<>();
        for (Member member : memberList) {
            memberDtoList.add(new MemberDto(member));
        }
        return memberDtoList;
    }

    /**
     * 회원가입
     */
    @PostMapping("/add")
    public MemberDto insertMember(@RequestBody MemberDto memberDto){
        Member member= new Member(memberDto);
        Member insertMember = memberInfoService.insertMember(member);
        return new MemberDto(insertMember);
    }

    /**
     * 개인정보 수정
     */
    @PostMapping("/info/{id}/edit")
    public MemberDto updateMember(@RequestBody MemberDto memberDto) {
        Member member = new Member(memberDto);
        Member updateMember = memberInfoService.updateMember(member);
        return new MemberDto(updateMember);
    }

    /**
     * 개인정보 삭제
     */
    @PostMapping("/delete/{id}")
    public void deleteMember(@PathVariable String id){
        memberInfoService.deleteMember(id);
    }

}
