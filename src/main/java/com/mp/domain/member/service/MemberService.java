package com.mp.domain.member.service;

import com.mp.domain.member.domain.Member;
import com.mp.domain.member.vo.LoginVO;
import com.mp.domain.member.vo.MemberVO;
import com.mp.domain.member.vo.UserInfo;

import java.util.Optional;

public interface MemberService {

    Member signUp(MemberVO vo);
    LoginVO login(MemberVO vo);
    void logout();
    Member update(MemberVO vo);
    UserInfo getSession();
    Optional<Member> getMember(Long memberSeq);
}
