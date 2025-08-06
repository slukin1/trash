package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class IntegrationQuestionInfo implements Serializable {
    private String content;

    /* renamed from: id  reason: collision with root package name */
    private int f70245id;

    public boolean canEqual(Object obj) {
        return obj instanceof IntegrationQuestionInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntegrationQuestionInfo)) {
            return false;
        }
        IntegrationQuestionInfo integrationQuestionInfo = (IntegrationQuestionInfo) obj;
        if (!integrationQuestionInfo.canEqual(this) || getId() != integrationQuestionInfo.getId()) {
            return false;
        }
        String content2 = getContent();
        String content3 = integrationQuestionInfo.getContent();
        return content2 != null ? content2.equals(content3) : content3 == null;
    }

    public String getContent() {
        return this.content;
    }

    public int getId() {
        return this.f70245id;
    }

    public int hashCode() {
        String content2 = getContent();
        return ((getId() + 59) * 59) + (content2 == null ? 43 : content2.hashCode());
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(int i11) {
        this.f70245id = i11;
    }

    public String toString() {
        return "IntegrationQuestionInfo(id=" + getId() + ", content=" + getContent() + ")";
    }
}
