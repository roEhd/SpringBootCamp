package com.example.demo;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class MemberTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void join() throws Exception {
        //given
        Member member = new Member();
        member.setName("winter");
        member.setId("else");
        member.setOrg("koscom");
        member.setActive(true);
        //when
        Member storedMember = memberService.addUser(member);

        //then
        Member foundMember = memberRepository.findById(storedMember.getSeq()).get();
        assertEquals(member.getName(), foundMember.getName());
    }
}
