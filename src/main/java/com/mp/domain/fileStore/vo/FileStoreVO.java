package com.mp.domain.fileStore.vo;

import com.mp.common.type.FileType;
import org.springframework.web.multipart.MultipartFile;

public interface FileStoreVO {
    MultipartFile getFile();
    FileType getFileType();
}
