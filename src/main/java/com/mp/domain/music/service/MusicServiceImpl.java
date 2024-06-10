package com.mp.domain.music.service;

import com.mp.common.ex.ServiceError;
import com.mp.common.ex.ServiceException;
import com.mp.common.type.FileType;
import com.mp.domain.fileStore.domain.FileStore;
import com.mp.domain.fileStore.service.FileStoreService;
import com.mp.domain.fileStore.vo.FileStoreDto;
import com.mp.domain.fileStore.vo.FileStoreVO;
import com.mp.domain.member.domain.Member;
import com.mp.domain.member.service.MemberService;
import com.mp.domain.member.vo.UserInfo;
import com.mp.domain.music.domain.Music;
import com.mp.domain.music.domain.MusicRepository;
import com.mp.domain.music.vo.MusicDto;
import com.mp.domain.music.vo.MusicVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class MusicServiceImpl implements MusicService {

    private final MusicRepository musicRepository;

    private final FileStoreService fileStoreService;
    private final MemberService memberService;

    @Transactional
    @Override
    public Music addMusic(MusicVO vo) {
        log.debug("add Music");

        // 1. Member
        UserInfo userInfo = memberService.getSession();
        Member member = memberService.getMember(userInfo.getMemberSeq())
                .orElseThrow(() -> new ServiceException(ServiceError.LOGIN_ID_NOT_EXISTS));

        // 2. File Upload
        // 2-1. Music
        FileStoreVO musicFileStoreVO = FileStoreDto.builder()
                .file(vo.getMusicFile())
                .fileType(FileType.MUSIC)
                .build();

        FileStore musicFile = null;
        try {
            musicFile = fileStoreService.upload(musicFileStoreVO);
        } catch (IOException e) {
            throw new ServiceException(ServiceError.FILE_UPLOAD_FAIL);
        }

        // 2-2. Image
        FileStore imageFile = null;
        if (vo.getImageFile() != null) {
            FileStoreVO imageFileStoreVO = FileStoreDto.builder()
                    .file(vo.getMusicFile())
                    .fileType(FileType.IMAGE)
                    .build();

            try {
                imageFile = fileStoreService.upload(imageFileStoreVO);
            } catch (IOException e) {
                throw new ServiceException(ServiceError.FILE_UPLOAD_FAIL);
            }
        }

        // 3. Save
        Music music = Music.builder()
                .member(member)
                .musicName(vo.getMusicName())
                .musicCategory(vo.getMusicCategory())
                .musicFileStore(musicFile)
                .imageFileStore(imageFile)
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
