package com.mp.domain.music.vo;

import com.mp.common.type.MusicCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusicDto implements MusicVO {

    private Long musicSeq;
    private String musicName;
    private MusicCategory musicCategory;
    private boolean openYn;
    private MultipartFile musicFile;
    private MultipartFile imageFile;
}
