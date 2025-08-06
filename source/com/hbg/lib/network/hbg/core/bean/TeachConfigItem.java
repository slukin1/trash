package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class TeachConfigItem implements Serializable {
    private static final long serialVersionUID = -4727647695687847414L;
    @SerializedName("code")
    private int code;
    @SerializedName("videoDesc")
    private String videoDesc;
    @SerializedName("videoPic")
    private String videoPic;
    @SerializedName("videoTitle")
    private String videoTitle;
    @SerializedName("videoUrl")
    private String videoUrl;

    public boolean canEqual(Object obj) {
        return obj instanceof TeachConfigItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TeachConfigItem)) {
            return false;
        }
        TeachConfigItem teachConfigItem = (TeachConfigItem) obj;
        if (!teachConfigItem.canEqual(this) || getCode() != teachConfigItem.getCode()) {
            return false;
        }
        String videoUrl2 = getVideoUrl();
        String videoUrl3 = teachConfigItem.getVideoUrl();
        if (videoUrl2 != null ? !videoUrl2.equals(videoUrl3) : videoUrl3 != null) {
            return false;
        }
        String videoPic2 = getVideoPic();
        String videoPic3 = teachConfigItem.getVideoPic();
        if (videoPic2 != null ? !videoPic2.equals(videoPic3) : videoPic3 != null) {
            return false;
        }
        String videoTitle2 = getVideoTitle();
        String videoTitle3 = teachConfigItem.getVideoTitle();
        if (videoTitle2 != null ? !videoTitle2.equals(videoTitle3) : videoTitle3 != null) {
            return false;
        }
        String videoDesc2 = getVideoDesc();
        String videoDesc3 = teachConfigItem.getVideoDesc();
        return videoDesc2 != null ? videoDesc2.equals(videoDesc3) : videoDesc3 == null;
    }

    public int getCode() {
        return this.code;
    }

    public String getVideoDesc() {
        return this.videoDesc;
    }

    public String getVideoPic() {
        return this.videoPic;
    }

    public String getVideoTitle() {
        return this.videoTitle;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        String videoUrl2 = getVideoUrl();
        int i11 = 43;
        int code2 = ((getCode() + 59) * 59) + (videoUrl2 == null ? 43 : videoUrl2.hashCode());
        String videoPic2 = getVideoPic();
        int hashCode = (code2 * 59) + (videoPic2 == null ? 43 : videoPic2.hashCode());
        String videoTitle2 = getVideoTitle();
        int hashCode2 = (hashCode * 59) + (videoTitle2 == null ? 43 : videoTitle2.hashCode());
        String videoDesc2 = getVideoDesc();
        int i12 = hashCode2 * 59;
        if (videoDesc2 != null) {
            i11 = videoDesc2.hashCode();
        }
        return i12 + i11;
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setVideoDesc(String str) {
        this.videoDesc = str;
    }

    public void setVideoPic(String str) {
        this.videoPic = str;
    }

    public void setVideoTitle(String str) {
        this.videoTitle = str;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public String toString() {
        return "TeachConfigItem(code=" + getCode() + ", videoUrl=" + getVideoUrl() + ", videoPic=" + getVideoPic() + ", videoTitle=" + getVideoTitle() + ", videoDesc=" + getVideoDesc() + ")";
    }
}
