package com.mp.domain.music.domain;

import com.mp.common.domain.BaseEntity;
import com.mp.common.type.MusicCategory;
import com.mp.domain.fileStore.domain.FileStore;
import com.mp.domain.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "MUSIC")
public class Music extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MUSIC_SEQ")
    private Long musicSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_SEQ", nullable = false)
    private Member member;

    @Column(name = "MUSIC_NAME", length = 500, nullable = false)
    private String musicName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MUSIC_FILE_SEQ", nullable = false)
    private FileStore musicFileStore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMAGE_FILE_SEQ")
    private FileStore imageFileStore;

    @Enumerated(EnumType.STRING)
    @Column(name = "MUSIC_CATEGORY")
    private MusicCategory musicCategory;

    @Column(name = "OPEN_YN")
    private boolean openYn;

    public void changeOpenYn(boolean openYn) {
        this.openYn = openYn;
    }
}
