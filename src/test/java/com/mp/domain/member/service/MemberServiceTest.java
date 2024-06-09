package com.mp.domain.member.service;

import com.mp.domain.member.domain.Member;
import com.mp.domain.member.vo.LoginVO;
import com.mp.domain.member.vo.MemberDto;
import com.mp.domain.member.vo.MemberVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    @Transactional
    void 고객_생성_성공() {

        MemberVO vo = MemberDto.builder()
                .id("test")
                .password("password")
                .name("테스트")
                .build();

        Member member = memberService.signUp(vo);

        assertEquals(vo.getId(), member.getId());
        assertTrue(passwordEncoder.matches(vo.getPassword(), member.getPassword()));
        assertEquals(vo.getName(), member.getName());
    }

    @Test
    @Transactional
    void 고객_생성_실패_ID중복() {
        MemberVO vo = MemberDto.builder()
                .id("test")
                .password("password")
                .name("테스트")
                .build();

        Member member1 = memberService.signUp(vo);

        assertThrows(Exception.class, () -> memberService.signUp(vo));
    }

    @Test
    @Transactional
    void 로그인_성공() {
        MemberVO vo = MemberDto.builder()
                .id("test")
                .password("password")
                .build();
        LoginVO login = memberService.login(vo);
        assertEquals(vo.getId(), login.getId());
    }

    @Test
    void 로그인_실패_패스워드오류() {
        MemberVO vo = MemberDto.builder()
                .id("test")
                .password("password1")
                .build();
        assertThrows(Exception.class, () -> memberService.login(vo));
    }
}