package com.zopim.android.sdk.attachment;

import java.io.File;
import mz.b;
import mz.f;

public enum FileExtension {
    JPG("jpg"),
    JPEG("jpeg"),
    PNG("png"),
    GIF("gif"),
    PDF("pdf"),
    TXT("txt"),
    UNKNOWN("unknown");
    
    public final String extension;

    private FileExtension(String str) {
        this.extension = str;
    }

    public static FileExtension getExtension(File file) {
        if (file == null || f.e(file.getName())) {
            return UNKNOWN;
        }
        return valueOfExtension(b.a(file.getName()));
    }

    public static FileExtension valueOfExtension(String str) {
        for (FileExtension fileExtension : values()) {
            if (fileExtension.getValue().equalsIgnoreCase(str)) {
                return fileExtension;
            }
        }
        return UNKNOWN;
    }

    public String getValue() {
        return this.extension;
    }
}
