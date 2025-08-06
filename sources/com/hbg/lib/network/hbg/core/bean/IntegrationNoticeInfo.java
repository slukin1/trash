package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class IntegrationNoticeInfo implements Serializable {
    private String content;

    /* renamed from: id  reason: collision with root package name */
    private long f70244id;
    private String path;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof IntegrationNoticeInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntegrationNoticeInfo)) {
            return false;
        }
        IntegrationNoticeInfo integrationNoticeInfo = (IntegrationNoticeInfo) obj;
        if (!integrationNoticeInfo.canEqual(this) || getId() != integrationNoticeInfo.getId()) {
            return false;
        }
        String content2 = getContent();
        String content3 = integrationNoticeInfo.getContent();
        if (content2 != null ? !content2.equals(content3) : content3 != null) {
            return false;
        }
        String path2 = getPath();
        String path3 = integrationNoticeInfo.getPath();
        if (path2 != null ? path2.equals(path3) : path3 == null) {
            return getType() == integrationNoticeInfo.getType();
        }
        return false;
    }

    public String getContent() {
        return this.content;
    }

    public long getId() {
        return this.f70244id;
    }

    public String getPath() {
        return this.path;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        long id2 = getId();
        String content2 = getContent();
        int i11 = 43;
        int hashCode = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (content2 == null ? 43 : content2.hashCode());
        String path2 = getPath();
        int i12 = hashCode * 59;
        if (path2 != null) {
            i11 = path2.hashCode();
        }
        return ((i12 + i11) * 59) + getType();
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(long j11) {
        this.f70244id = j11;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "IntegrationNoticeInfo(id=" + getId() + ", content=" + getContent() + ", path=" + getPath() + ", type=" + getType() + ")";
    }
}
