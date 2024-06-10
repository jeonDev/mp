package com.mp.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum FileStatus {
    JPG(FileType.IMAGE, "jpg"),
    MP3(FileType.MUSIC, "mp3"),
    MP4(FileType.MUSIC, "mp4");

    private final FileType type;
    private final String ext;

    public static boolean isFileExtCheck(FileType fileType, String ext) {
        FileStatus fileStatus = Arrays.stream(values())
                .filter(val -> val.ext.equals(ext))
                .findFirst()
                .orElse(null);
        return fileStatus != null && fileType == fileStatus.type;
    }
}
