package com.mp.domain.playlist.domain;

import com.mp.common.domain.BaseEntity;
import com.mp.domain.music.domain.Music;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "PLAY_LIST")
public class PlayList extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAY_LIST_SEQ")
    private Long playListSeq;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PLAYLIST_SEQ")
    private List<Music> music;
}
