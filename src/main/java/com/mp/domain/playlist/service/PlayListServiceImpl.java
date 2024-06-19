package com.mp.domain.playlist.service;

import com.mp.common.ex.ServiceError;
import com.mp.common.ex.ServiceException;
import com.mp.domain.member.domain.Member;
import com.mp.domain.member.service.MemberService;
import com.mp.domain.member.vo.UserInfo;
import com.mp.domain.music.domain.Music;
import com.mp.domain.music.service.MusicService;
import com.mp.domain.playlist.domain.PlayList;
import com.mp.domain.playlist.domain.PlayListRepository;
import com.mp.domain.playlist.vo.PlayListVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PlayListServiceImpl implements PlayListService {

    private final PlayListRepository playListRepository;
    private final MemberService memberService;
    private final MusicService musicService;

    @Transactional
    @Override
    public PlayList addPlayList(PlayListVO vo) {
        // 1. Member
        UserInfo userInfo = memberService.getSession();
        Member member = memberService.getMember(userInfo.getMemberSeq())
                .orElseThrow(() -> new ServiceException(ServiceError.LOGIN_ID_NOT_EXISTS));

        // 2. Music
        Music music = musicService.getMusic(vo.getMusicSeq());

        // 3. PlayList
        PlayList playList = PlayList.builder()
                .music(music)
                .member(member)
                .playListNumber(vo.getPlayListNumber() != null ? vo.getPlayListNumber() : null)
                .playListName(vo.getPlayListName())
                .build();

        return playListRepository.save(playList);
    }

    @Transactional
    @Override
    public void removePlayList(Music music) {

    }

    @Transactional(readOnly = true)
    @Override
    public List<Music> getMyPlayList() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public PlayList getPlayList(Long playListSeq) {
        return playListRepository.findById(playListSeq)
                .orElseThrow(() -> new ServiceException(ServiceError.NO_ENTITY));
    }
}
