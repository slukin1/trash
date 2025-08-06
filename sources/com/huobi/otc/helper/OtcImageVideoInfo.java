package com.huobi.otc.helper;

import java.io.Serializable;

public class OtcImageVideoInfo implements Serializable {
    private String filePath;
    private boolean isImage;
    private String videoImagePath;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcImageVideoInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcImageVideoInfo)) {
            return false;
        }
        OtcImageVideoInfo otcImageVideoInfo = (OtcImageVideoInfo) obj;
        if (!otcImageVideoInfo.canEqual(this)) {
            return false;
        }
        String filePath2 = getFilePath();
        String filePath3 = otcImageVideoInfo.getFilePath();
        if (filePath2 != null ? !filePath2.equals(filePath3) : filePath3 != null) {
            return false;
        }
        if (isImage() != otcImageVideoInfo.isImage()) {
            return false;
        }
        String videoImagePath2 = getVideoImagePath();
        String videoImagePath3 = otcImageVideoInfo.getVideoImagePath();
        return videoImagePath2 != null ? videoImagePath2.equals(videoImagePath3) : videoImagePath3 == null;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getVideoImagePath() {
        return this.videoImagePath;
    }

    public int hashCode() {
        String filePath2 = getFilePath();
        int i11 = 43;
        int hashCode = (((filePath2 == null ? 43 : filePath2.hashCode()) + 59) * 59) + (isImage() ? 79 : 97);
        String videoImagePath2 = getVideoImagePath();
        int i12 = hashCode * 59;
        if (videoImagePath2 != null) {
            i11 = videoImagePath2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isImage() {
        return this.isImage;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setImage(boolean z11) {
        this.isImage = z11;
    }

    public void setVideoImagePath(String str) {
        this.videoImagePath = str;
    }

    public String toString() {
        return "OtcImageVideoInfo(filePath=" + getFilePath() + ", isImage=" + isImage() + ", videoImagePath=" + getVideoImagePath() + ")";
    }
}
