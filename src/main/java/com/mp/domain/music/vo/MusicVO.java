package com.mp.domain.music.vo;

import com.mp.common.type.MusicCategory;
import org.springframework.web.multipart.MultipartFile;

public interface MusicVO {
    Long getMusicSeq();
    String getMusicName();
    MusicCategory getMusicCategory();
    boolean isOpenYn();
    MultipartFile getMusicFile();
    MultipartFile getImageFile();
}
