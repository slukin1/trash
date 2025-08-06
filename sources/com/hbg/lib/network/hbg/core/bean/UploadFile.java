package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class UploadFile implements Serializable {
    private String fileName;
    private String mimeType;
    private String url;
    private String urlForDownload;

    public String getFileName() {
        return this.fileName;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUrlForDownload() {
        return this.urlForDownload;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUrlForDownload(String str) {
        this.urlForDownload = str;
    }
}
