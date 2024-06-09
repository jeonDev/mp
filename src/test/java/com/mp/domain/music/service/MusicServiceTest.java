package com.mp.domain.music.service;

import com.mp.common.type.MusicCategory;
import com.mp.domain.music.domain.Music;
import com.mp.domain.music.vo.MusicDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MusicServiceTest {

    @Autowired
    MusicService musicService;

    @Transactional
    @Test
    void 음악_등록() {
        MusicDto vo = MusicDto.builder()
                .musicCategory(MusicCategory.BALLADE)
                .musicName("발라드")
                .openYn(true)
                .build();
        Music music = musicService.addMusic(vo);
        assertEquals(vo.getMusicSeq(), music.getMusicSeq());
    }
}