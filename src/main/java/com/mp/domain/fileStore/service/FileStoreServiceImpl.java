package com.mp.domain.fileStore.service;

import com.mp.common.ex.ServiceError;
import com.mp.common.ex.ServiceException;
import com.mp.common.type.FileStatus;
import com.mp.common.util.DateUtils;
import com.mp.domain.fileStore.domain.FileStore;
import com.mp.domain.fileStore.domain.FileStoreRepository;
import com.mp.domain.fileStore.vo.FileStoreVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileStoreServiceImpl implements FileStoreService {

    private final FileStoreRepository fileStoreRepository;

    @Value("${storage.path}")
    private String storagePath;

    @Override
    public FileStore upload(FileStoreVO vo) throws IOException {
        MultipartFile file = vo.getFile();
        String contentType = file.getContentType();

        // 1. 확장자 체크
        if (!FileStatus.isFileExtCheck(vo.getFileType(), contentType))
            throw new ServiceException(ServiceError.FILE_NO_EXT);

        // 2. 파일명 저장
        String fileName = DateUtils.getNowDate("yyyyMMdd") + "_" + UUID.randomUUID();

        // 3. 파일 업로드
        File newFile = new File(storagePath + fileName);
        file.transferTo(newFile);

        // 4. 저장
        FileStore fileStore = FileStore.builder()
                .filePath(storagePath + fileName)
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
