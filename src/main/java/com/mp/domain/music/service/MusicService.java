package com.mp.domain.music.service;

import com.mp.domain.music.domain.Music;
import com.mp.domain.music.vo.MusicVO;

public interface MusicService {
    Music addMusic(MusicVO vo);
    void removeMusic(MusicVO vo);
    MusicVO getMusic(MusicVO vo);
}
