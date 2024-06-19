package com.mp.domain.playlist.domain;

import com.mp.common.domain.BaseEntity;
import com.mp.domain.member.domain.Member;
import com.mp.domain.music.domain.Music;
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
@Table(name = "PLAY_LIST")
public class PlayList extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAY_LIST_SEQ")
    private Long playListSeq;

    /* TODO: default + 1 되게 하고 싶은데 */
    @Column(name = "PLAY_LIST_NUMBER")
    private Long playListNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_SEQ", nullable = false)
    private Member member;

    @Column(name = "PLAY_LIST_NAME", length = 100, nullable = false)
    private String playListName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MUSIC_SEQ", nullable = false)
    private Music music;
}
