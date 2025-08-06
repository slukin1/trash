package com.huobi.index.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class IndexSpecial implements Serializable {
    @SerializedName("commentNum")
    public int commentNum;
    @SerializedName("content")
    public String content = "";
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    public int f73205id;
    @SerializedName("imgUrl")
    public String imgUrl = "";
    @SerializedName("skipUrl")
    public String skipUrl = "";
    @SerializedName("title")
    public String title = "";
    @SerializedName("updateTime")
    public long updateTime;
    @SerializedName("viewNum")
    public int viewNum;

    public boolean canEqual(Object obj) {
        return obj instanceof IndexSpecial;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexSpecial)) {
            return false;
        }
        IndexSpecial indexSpecial = (IndexSpecial) obj;
        if (!indexSpecial.canEqual(this) || getCommentNum() != indexSpecial.getCommentNum() || getId() != indexSpecial.getId()) {
            return false;
        }
        String imgUrl2 = getImgUrl();
        String imgUrl3 = indexSpecial.getImgUrl();
        if (imgUrl2 != null ? !imgUrl2.equals(imgUrl3) : imgUrl3 != null) {
            return false;
        }
        String skipUrl2 = getSkipUrl();
        String skipUrl3 = indexSpecial.getSkipUrl();
        if (skipUrl2 != null ? !skipUrl2.equals(skipUrl3) : skipUrl3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = indexSpecial.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String content2 = getContent();
        String content3 = indexSpecial.getContent();
        if (content2 != null ? content2.equals(content3) : content3 == null) {
            return getUpdateTime() == indexSpecial.getUpdateTime() && getViewNum() == indexSpecial.getViewNum();
        }
        return false;
    }

    public int getCommentNum() {
        return this.commentNum;
    }

    public String getContent() {
        return this.content;
    }

    public int getId() {
        return this.f73205id;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getSkipUrl() {
        return this.skipUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public int getViewNum() {
        return this.viewNum;
    }

    public int hashCode() {
        int commentNum2 = ((getCommentNum() + 59) * 59) + getId();
        String imgUrl2 = getImgUrl();
        int i11 = 43;
        int hashCode = (commentNum2 * 59) + (imgUrl2 == null ? 43 : imgUrl2.hashCode());
        String skipUrl2 = getSkipUrl();
        int hashCode2 = (hashCode * 59) + (skipUrl2 == null ? 43 : skipUrl2.hashCode());
        String title2 = getTitle();
        int hashCode3 = (hashCode2 * 59) + (title2 == null ? 43 : title2.hashCode());
        String content2 = getContent();
        int i12 = hashCode3 * 59;
        if (content2 != null) {
            i11 = content2.hashCode();
        }
        long updateTime2 = getUpdateTime();
        return ((((i12 + i11) * 59) + ((int) (updateTime2 ^ (updateTime2 >>> 32)))) * 59) + getViewNum();
    }

    public void setCommentNum(int i11) {
        this.commentNum = i11;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(int i11) {
        this.f73205id = i11;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setSkipUrl(String str) {
        this.skipUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUpdateTime(long j11) {
        this.updateTime = j11;
    }

    public void setViewNum(int i11) {
        this.viewNum = i11;
    }

    public String toString() {
        return "IndexSpecial(commentNum=" + getCommentNum() + ", id=" + getId() + ", imgUrl=" + getImgUrl() + ", skipUrl=" + getSkipUrl() + ", title=" + getTitle() + ", content=" + getContent() + ", updateTime=" + getUpdateTime() + ", viewNum=" + getViewNum() + ")";
    }
}
