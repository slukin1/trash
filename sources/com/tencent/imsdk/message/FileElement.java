package com.tencent.imsdk.message;

public class FileElement extends MessageBaseElement {
    private int fileBusinessID;
    private String fileDownloadUrl;
    private String fileName;
    private String filePath;
    private int fileSize;
    private String fileUUID;

    public FileElement() {
        setElementType(6);
    }

    public int getFileBusinessID() {
        return this.fileBusinessID;
    }

    public String getFileDownloadUrl() {
        return this.fileDownloadUrl;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public String getFileUUID() {
        return this.fileUUID;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public boolean update(MessageBaseElement messageBaseElement) {
        if (this.elementType != messageBaseElement.elementType) {
            return false;
        }
        FileElement fileElement = (FileElement) messageBaseElement;
        if (!this.filePath.equals(fileElement.filePath)) {
            return false;
        }
        this.fileUUID = fileElement.fileUUID;
        this.fileName = fileElement.fileName;
        this.fileSize = fileElement.fileSize;
        this.fileDownloadUrl = fileElement.fileDownloadUrl;
        this.fileBusinessID = fileElement.fileBusinessID;
        return true;
    }
}
