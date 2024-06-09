package com.mp.domain.music.domain;

import com.mp.common.domain.BaseEntity;
import com.mp.common.type.MusicCategory;
import com.mp.domain.fileStore.domain.FileStore;
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

    @Column(name = "MUSIC_NAME", length = 500, nullable = false)
    private String musicName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_STORE_SEQ", nullable = false)
    private FileStore fileStore;

    @Enumerated(EnumType.STRING)
    @Column(name = "MUSIC_CATEGORY")
    private MusicCategory musicCategory;

    @Column(name = "OPEN_YN")
    private boolean openYn;

    public void changeOpenYn(boolean openYn) {
        this.openYn = openYn;
    }
}
