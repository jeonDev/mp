package com.mp.domain.fileStore.service;

import com.mp.domain.fileStore.domain.FileStore;
import com.mp.domain.fileStore.vo.FileStoreVO;

public interface FileStoreService {
    FileStore upload(FileStoreVO vo);
    FileStore get(FileStoreVO vo);
    void remove(FileStoreVO vo);
}
