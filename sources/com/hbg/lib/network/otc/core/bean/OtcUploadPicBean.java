package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcUploadPicBean implements Serializable {
    private String code = "";
    private String data = "";
    private String fileName;
    private String filePath;
    private Long fileSize;
    private String message = "";

    public boolean canEqual(Object obj) {
        return obj instanceof OtcUploadPicBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcUploadPicBean)) {
            return false;
        }
        OtcUploadPicBean otcUploadPicBean = (OtcUploadPicBean) obj;
        if (!otcUploadPicBean.canEqual(this)) {
            return false;
        }
        String code2 = getCode();
        String code3 = otcUploadPicBean.getCode();
        if (code2 != null ? !code2.equals(code3) : code3 != null) {
            return false;
        }
        String data2 = getData();
        String data3 = otcUploadPicBean.getData();
        if (data2 != null ? !data2.equals(data3) : data3 != null) {
            return false;
        }
        String message2 = getMessage();
        String message3 = otcUploadPicBean.getMessage();
        if (message2 != null ? !message2.equals(message3) : message3 != null) {
            return false;
        }
        String filePath2 = getFilePath();
        String filePath3 = otcUploadPicBean.getFilePath();
        if (filePath2 != null ? !filePath2.equals(filePath3) : filePath3 != null) {
            return false;
        }
        Long fileSize2 = getFileSize();
        Long fileSize3 = otcUploadPicBean.getFileSize();
        if (fileSize2 != null ? !fileSize2.equals(fileSize3) : fileSize3 != null) {
            return false;
        }
        String fileName2 = getFileName();
        String fileName3 = otcUploadPicBean.getFileName();
        return fileName2 != null ? fileName2.equals(fileName3) : fileName3 == null;
    }

    public String getCode() {
        return this.code;
    }

    public String getData() {
        return this.data;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public Long getFileSize() {
        return this.fileSize;
    }

    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        String code2 = getCode();
        int i11 = 43;
        int hashCode = code2 == null ? 43 : code2.hashCode();
        String data2 = getData();
        int hashCode2 = ((hashCode + 59) * 59) + (data2 == null ? 43 : data2.hashCode());
        String message2 = getMessage();
        int hashCode3 = (hashCode2 * 59) + (message2 == null ? 43 : message2.hashCode());
        String filePath2 = getFilePath();
        int hashCode4 = (hashCode3 * 59) + (filePath2 == null ? 43 : filePath2.hashCode());
        Long fileSize2 = getFileSize();
        int hashCode5 = (hashCode4 * 59) + (fileSize2 == null ? 43 : fileSize2.hashCode());
        String fileName2 = getFileName();
        int i12 = hashCode5 * 59;
        if (fileName2 != null) {
            i11 = fileName2.hashCode();
        }
        return i12 + i11;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileSize(Long l11) {
        this.fileSize = l11;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "OtcUploadPicBean(code=" + getCode() + ", data=" + getData() + ", message=" + getMessage() + ", filePath=" + getFilePath() + ", fileSize=" + getFileSize() + ", fileName=" + getFileName() + ")";
    }
}
