package com.mp.domain.fileStore.service;

import com.mp.domain.fileStore.domain.FileStore;
import com.mp.domain.fileStore.vo.FileStoreVO;

public interface FileStoreService {
    FileStore save(FileStoreVO vo);
    FileStore get(FileStoreVO vo);
    void remove(FileStoreVO vo);
}
