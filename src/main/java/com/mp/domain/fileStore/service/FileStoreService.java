package com.mp.domain.fileStore.service;

import com.mp.domain.fileStore.domain.FileStore;
import com.mp.domain.fileStore.vo.FileStoreVO;

import java.io.IOException;

public interface FileStoreService {
    FileStore upload(FileStoreVO vo) throws IOException;
    FileStore get(FileStoreVO vo);
    void remove(FileStoreVO vo);
}
