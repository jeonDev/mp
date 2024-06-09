package com.mp.domain.fileStore.service;

import com.mp.domain.fileStore.domain.FileStore;
import com.mp.domain.fileStore.domain.FileStoreRepository;
import com.mp.domain.fileStore.vo.FileStoreVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileStoreServiceImpl implements FileStoreService {

    private final FileStoreRepository fileStoreRepository;
    @Override
    public FileStore upload(FileStoreVO vo) {
        MultipartFile file = vo.getFile();
        String contentType = file.getContentType();
        // TODO:
        // 1. 확장자 체크

        // 2. 파일명 저장

        // 3. 파일 업로드

        // 4. 저장
        FileStore fileStore = FileStore.builder()
                .filePath("/Users/jjh/project/file/mp/")
                .build();
        return fileStoreRepository.save(fileStore);
    }

    @Override
    public FileStore get(FileStoreVO vo) {
        return null;
    }

    @Override
    public void remove(FileStoreVO vo) {

    }
}
