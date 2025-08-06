package com.jumio.core.util;

import java.io.File;
import java.io.Serializable;

public class FileData implements Serializable {
    private String fileType = "";
    private String mimeType = "";
    private String path = "";
    private Long timestamp;

    public void clear() {
        if (getHasPath()) {
            new File(this.path).delete();
        }
        this.path = "";
        this.mimeType = "";
        this.fileType = "";
        this.timestamp = null;
    }

    public final String getFileName() {
        return StringsKt__StringsKt.a1(this.path, "/", (String) null, 2, (Object) null);
    }

    public final String getFileType() {
        return this.fileType;
    }

    public final boolean getHasPath() {
        return this.path.length() > 0;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getPath() {
        return this.path;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final void setFileType(String str) {
        this.fileType = str;
    }

    public final void setMimeType(String str) {
        this.mimeType = str;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final void setTimestamp(Long l11) {
        this.timestamp = l11;
    }
}
