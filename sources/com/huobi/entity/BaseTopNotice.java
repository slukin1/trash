package com.huobi.entity;

import java.io.Serializable;

public class BaseTopNotice implements Serializable {
    private static final long serialVersionUID = 6361154256339381715L;

    /* renamed from: id  reason: collision with root package name */
    public String f44606id;
    public String title;
    public String url;

    public boolean canEqual(Object obj) {
        return obj instanceof BaseTopNotice;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseTopNotice)) {
            return false;
        }
        BaseTopNotice baseTopNotice = (BaseTopNotice) obj;
        if (!baseTopNotice.canEqual(this)) {
            return false;
        }
        String id2 = getId();
        String id3 = baseTopNotice.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = baseTopNotice.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String url2 = getUrl();
        String url3 = baseTopNotice.getUrl();
        return url2 != null ? url2.equals(url3) : url3 == null;
    }

    public String getId() {
        return this.f44606id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String getWebUrl() {
        return "";
    }

    public int hashCode() {
        String id2 = getId();
        int i11 = 43;
        int hashCode = id2 == null ? 43 : id2.hashCode();
        String title2 = getTitle();
        int hashCode2 = ((hashCode + 59) * 59) + (title2 == null ? 43 : title2.hashCode());
        String url2 = getUrl();
        int i12 = hashCode2 * 59;
        if (url2 != null) {
            i11 = url2.hashCode();
        }
        return i12 + i11;
    }

    public void setId(String str) {
        this.f44606id = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "BaseTopNotice(id=" + getId() + ", title=" + getTitle() + ", url=" + getUrl() + ")";
    }
}
