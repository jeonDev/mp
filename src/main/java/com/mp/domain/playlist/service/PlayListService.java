package com.mp.domain.playlist.service;

import com.mp.domain.music.domain.Music;
import com.mp.domain.playlist.domain.PlayList;

import java.util.List;

public interface PlayListService {
    PlayList addPlayList(Long musicSeq);
    void removePlayList(Music music);
    List<Music> getMyPlayList();
    PlayList getPlayList(Long playList);
}
