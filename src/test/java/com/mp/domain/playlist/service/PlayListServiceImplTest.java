package com.mp.domain.playlist.service;

import com.mp.domain.music.domain.Music;
import com.mp.domain.playlist.domain.PlayList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayListServiceImplTest {

    @Autowired
    PlayListService playListService;

    @Transactional
    @Test
    void 플레이리스트_Music_추가() {
        long musicSeq = 1L;
        PlayList save = playListService.addPlayList(musicSeq);

        PlayList playList = playListService.getPlayList(save.getPlayListSeq());

        List<Music> music = playList.getMusic();
        assertEquals(music.get(0).getMusicSeq(), 1L);

    }
}