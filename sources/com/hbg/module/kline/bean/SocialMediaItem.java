package com.hbg.module.kline.bean;

import com.hbg.module.kline.handler.SocialMediaHandler;
import java.io.Serializable;
import s9.a;

public class SocialMediaItem implements a, Serializable {
    private int imageResId;
    private String url;

    public boolean canEqual(Object obj) {
        return obj instanceof SocialMediaItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SocialMediaItem)) {
            return false;
        }
        SocialMediaItem socialMediaItem = (SocialMediaItem) obj;
        if (!socialMediaItem.canEqual(this) || getImageResId() != socialMediaItem.getImageResId()) {
            return false;
        }
        String url2 = getUrl();
        String url3 = socialMediaItem.getUrl();
        return url2 != null ? url2.equals(url3) : url3 == null;
    }

    public int getImageResId() {
        return this.imageResId;
    }

    public String getUrl() {
        return this.url;
    }

    public String getViewHandlerName() {
        return SocialMediaHandler.class.getName();
    }

    public int hashCode() {
        String url2 = getUrl();
        return ((getImageResId() + 59) * 59) + (url2 == null ? 43 : url2.hashCode());
    }

    public void setImageResId(int i11) {
        this.imageResId = i11;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "SocialMediaItem(imageResId=" + getImageResId() + ", url=" + getUrl() + ")";
    }
}
