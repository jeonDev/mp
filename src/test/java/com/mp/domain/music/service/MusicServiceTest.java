package com.mp.domain.music.service;

import com.mp.common.type.MusicCategory;
import com.mp.domain.music.domain.Music;
import com.mp.domain.music.vo.MusicDto;
import com.mp.domain.music.vo.MusicVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MusicServiceTest {

    @Autowired
    MusicService musicService;

    @Transactional
    @Test
    void 음악_등록() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/jjh/project/file/mp/test.JPG");
        MusicVO vo = MusicDto.builder()
                .musicCategory(MusicCategory.BALLADE)
                .musicName("발라드")
                .musicFile(new MockMultipartFile("test", fileInputStream))
                .openYn(true)
                .build();
        Music music = musicService.addMusic(vo);
        assertEquals(vo.getMusicSeq(), music.getMusicSeq());
    }
}