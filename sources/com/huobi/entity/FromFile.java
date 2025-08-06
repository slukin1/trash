package com.huobi.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FromFile {
    private String contentType = "application/octet-stream";
    private byte[] data;
    private File file;
    private int fileSize;
    private String filname;
    private InputStream inStream;
    private String parameterName;

    public FromFile(String str, byte[] bArr, String str2, String str3) {
        this.data = bArr;
        this.filname = str;
        this.parameterName = str2;
        if (str3 != null) {
            this.contentType = str3;
        }
    }

    public String getContentType() {
        return this.contentType;
    }

    public byte[] getData() {
        return this.data;
    }

    public File getFile() {
        return this.file;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public String getFilname() {
        return this.filname;
    }

    public InputStream getInStream() {
        return this.inStream;
    }

    public String getParameterName() {
        return this.parameterName;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setFilname(String str) {
        this.filname = str;
    }

    public void setParameterName(String str) {
        this.parameterName = str;
    }

    public FromFile(String str, File file2, String str2, String str3) {
        this.filname = str;
        this.parameterName = str2;
        this.file = file2;
        try {
            this.inStream = new FileInputStream(file2);
        } catch (FileNotFoundException e11) {
            e11.printStackTrace();
        }
        if (str3 != null) {
            this.contentType = str3;
        }
    }

    public FromFile(InputStream inputStream, int i11, String str, String str2, String str3) {
        this.inStream = inputStream;
        this.fileSize = i11;
        this.filname = str;
        this.parameterName = str2;
        this.contentType = str3;
    }
}
