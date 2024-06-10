package com.mp.domain.fileStore.vo;

import com.mp.common.type.FileType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileStoreDto implements FileStoreVO {
    private MultipartFile file;
    private FileType fileType;
}
