package com.mp.domain.playlist.service;

import com.mp.domain.music.domain.Music;
import com.mp.domain.playlist.domain.PlayList;
import com.mp.domain.playlist.vo.PlayListDto;
import com.mp.domain.playlist.vo.PlayListVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayListServiceImplTest {

    @Autowired
    PlayListService playListService;

    @Transactional
    @Test
    void 플레이리스트_Music_추가() {
        long musicSeq = 1L;
        PlayListVO vo = PlayListDto.builder()
                .musicSeq(musicSeq)
                .playListNumber(1L)
                .playListName("테스트")
                .build();
        PlayList save = playListService.addPlayList(vo);

        PlayList playList = playListService.getPlayList(save.getPlayListSeq());

        Music music = playList.getMusic();
        assertEquals(music.getMusicSeq(), musicSeq);

    }
}