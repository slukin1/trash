package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class EtpRiskInfo implements Serializable {
    public static final int TYPE_CHANGE = 1;
    public static final int TYPE_INFO = 2;
    private static final long serialVersionUID = 933289926575525488L;
    private String bizType;
    private String content;

    /* renamed from: id  reason: collision with root package name */
    private long f70238id;
    private String title;
    private int type;
    private int weight;

    public boolean canEqual(Object obj) {
        return obj instanceof EtpRiskInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EtpRiskInfo)) {
            return false;
        }
        EtpRiskInfo etpRiskInfo = (EtpRiskInfo) obj;
        if (!etpRiskInfo.canEqual(this) || getId() != etpRiskInfo.getId()) {
            return false;
        }
        String bizType2 = getBizType();
        String bizType3 = etpRiskInfo.getBizType();
        if (bizType2 != null ? !bizType2.equals(bizType3) : bizType3 != null) {
            return false;
        }
        if (getType() != etpRiskInfo.getType()) {
            return false;
        }
        String title2 = getTitle();
        String title3 = etpRiskInfo.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String content2 = getContent();
        String content3 = etpRiskInfo.getContent();
        if (content2 != null ? content2.equals(content3) : content3 == null) {
            return getWeight() == etpRiskInfo.getWeight();
        }
        return false;
    }

    public String getBizType() {
        return this.bizType;
    }

    public String getContent() {
        return this.content;
    }

    public long getId() {
        return this.f70238id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        long id2 = getId();
        String bizType2 = getBizType();
        int i11 = 43;
        int hashCode = ((((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (bizType2 == null ? 43 : bizType2.hashCode())) * 59) + getType();
        String title2 = getTitle();
        int hashCode2 = (hashCode * 59) + (title2 == null ? 43 : title2.hashCode());
        String content2 = getContent();
        int i12 = hashCode2 * 59;
        if (content2 != null) {
            i11 = content2.hashCode();
        }
        return ((i12 + i11) * 59) + getWeight();
    }

    public void setBizType(String str) {
        this.bizType = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(long j11) {
        this.f70238id = j11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setWeight(int i11) {
        this.weight = i11;
    }

    public String toString() {
        return "EtpRiskInfo(id=" + getId() + ", bizType=" + getBizType() + ", type=" + getType() + ", title=" + getTitle() + ", content=" + getContent() + ", weight=" + getWeight() + ")";
    }
}
