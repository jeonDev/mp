package com.mp.domain.member.service;

import com.mp.common.ex.ServiceError;
import com.mp.common.ex.ServiceException;
import com.mp.domain.member.domain.Member;
import com.mp.domain.member.domain.MemberRepository;
import com.mp.domain.member.vo.*;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    private final HttpSession httpSession;

    @Transactional
    @Override
    public Member signUp(MemberVO vo) {
        if (!this.isCheckPasswordPattern(vo.getPassword())) throw new ServiceException(ServiceError.LOGIN_PASSWORD_PATTERN_FAIL);

        Member member = Member.builder()
                .id(vo.getId())
                .password(passwordEncoder.encode(vo.getPassword()))
                .name(vo.getName())
                .build();

        return memberRepository.save(member);
    }

    private boolean isCheckPasswordPattern(String password) {
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public LoginVO login(MemberVO vo) {
        Member member = memberRepository.findById(vo.getId())
                .orElseThrow(() -> new ServiceException(ServiceError.LOGIN_ID_NOT_EXISTS));

        if (!passwordEncoder.matches(vo.getPassword(), member.getPassword()))
            throw new ServiceException(ServiceError.LOGIN_PASSWORD_FAIL);

        UserInfo userInfo = MemberSession.builder()
                .memberSeq(member.getMemberSeq())
                .build();

        httpSession.setAttribute("userInfo", userInfo);

        return LoginDto.builder()
                .id(member.getId())
                .name(member.getName())
                .build();
    }

    @Override
    public void logout() {

    }

    @Transactional
    @Override
    public Member update(MemberVO vo) {
        Member member = memberRepository.findById(vo.getId())
                .orElseThrow(() -> new ServiceException(ServiceError.LOGIN_ID_NOT_EXISTS));

        if (!this.isCheckPasswordPattern(vo.getPassword())) throw new ServiceException(ServiceError.LOGIN_PASSWORD_PATTERN_FAIL);

        member.update(passwordEncoder.encode(vo.getPassword()), vo.getName());
        return memberRepository.save(member);
    }

    @Override
    public UserInfo getSession() {
        return (UserInfo) httpSession.getAttribute("userInfo");
    }

    @Override
    public Optional<Member> getMember(Long memberSeq) {
        return memberRepository.findById(memberSeq);
    }
}
