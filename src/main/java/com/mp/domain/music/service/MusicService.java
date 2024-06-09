package com.mp.domain.music.service;

import com.mp.domain.music.domain.Music;
import com.mp.domain.music.vo.MusicVO;

import java.util.List;

public interface MusicService {
    Music saveMusic(MusicVO vo);
    MusicVO getMusic(MusicVO vo);
    List<MusicVO> getMyMusicList();
}
