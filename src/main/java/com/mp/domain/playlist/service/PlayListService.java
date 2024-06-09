package com.mp.domain.playlist.service;

import com.mp.domain.music.domain.Music;

import java.util.List;

public interface PlayListService {
    void addPlayList(Music music);
    void removePlayList(Music music);
    List<Music> getPlayList();
}
