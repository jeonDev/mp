package com.mp.domain.music.domain;

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
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MUSIC_SEQ")
    private Long musicSeq;

    @Column(name = "MUSIC_NAME", length = 500, nullable = false)
    private String musicName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_STORE_SEQ", nullable = false)
    private FileStore fileStore;

}
