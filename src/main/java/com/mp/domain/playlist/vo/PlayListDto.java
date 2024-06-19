package com.mp.domain.playlist.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayListDto implements PlayListVO {
    private Long musicSeq;
    private Long playListNumber;
    private String playListName;
}
