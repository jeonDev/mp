package com.mp.domain.music.vo;

import com.mp.common.type.MusicCategory;

public interface MusicVO {
    Long getMusicSeq();
    String getMusicName();
    MusicCategory getMusicCategory();
    boolean isOpenYn();
}
