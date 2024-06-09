package com.mp.domain.music.service;

import com.mp.common.ex.ServiceError;
import com.mp.common.ex.ServiceException;
import com.mp.domain.music.domain.Music;
import com.mp.domain.music.domain.MusicRepository;
import com.mp.domain.music.vo.MusicDto;
import com.mp.domain.music.vo.MusicVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MusicServiceImpl implements MusicService {

    private final MusicRepository musicRepository;

    @Transactional
    @Override
    public Music addMusic(MusicVO vo) {
        Music music = Music.builder()
                .musicName(vo.getMusicName())
                .musicCategory(vo.getMusicCategory())
                .openYn(vo.isOpenYn())
                .build();

        return musicRepository.save(music);
    }

    @Transactional
    @Override
    public void removeMusic(MusicVO vo) {
        Music music = musicRepository.findById(vo.getMusicSeq())
                .orElseThrow(() -> new ServiceException(ServiceError.NO_ENTITY));
        music.changeOpenYn(false);
        musicRepository.save(music);
    }

    @Transactional(readOnly = true)
    @Override
    public MusicVO getMusic(MusicVO vo) {
        Music music = musicRepository.findById(vo.getMusicSeq())
                .orElseThrow(() -> new ServiceException(ServiceError.NO_ENTITY));

        return MusicDto.builder()
                .musicName(music.getMusicName())
                .musicCategory(music.getMusicCategory())
                .openYn(music.isOpenYn())
                .build();
    }
}
