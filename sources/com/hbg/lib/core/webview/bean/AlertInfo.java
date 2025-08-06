package com.hbg.lib.core.webview.bean;

import java.io.Serializable;

public class AlertInfo implements Serializable {
    private String cancel;
    private String confirm;
    private String content;
    private boolean isShowAlert;
    private String title;

    public boolean canEqual(Object obj) {
        return obj instanceof AlertInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AlertInfo)) {
            return false;
        }
        AlertInfo alertInfo = (AlertInfo) obj;
        if (!alertInfo.canEqual(this) || isShowAlert() != alertInfo.isShowAlert()) {
            return false;
        }
        String title2 = getTitle();
        String title3 = alertInfo.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String content2 = getContent();
        String content3 = alertInfo.getContent();
        if (content2 != null ? !content2.equals(content3) : content3 != null) {
            return false;
        }
        String cancel2 = getCancel();
        String cancel3 = alertInfo.getCancel();
        if (cancel2 != null ? !cancel2.equals(cancel3) : cancel3 != null) {
            return false;
        }
        String confirm2 = getConfirm();
        String confirm3 = alertInfo.getConfirm();
        return confirm2 != null ? confirm2.equals(confirm3) : confirm3 == null;
    }

    public String getCancel() {
        return this.cancel;
    }

    public String getConfirm() {
        return this.confirm;
    }

    public String getContent() {
        return this.content;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i11 = isShowAlert() ? 79 : 97;
        String title2 = getTitle();
        int i12 = 43;
        int hashCode = ((i11 + 59) * 59) + (title2 == null ? 43 : title2.hashCode());
        String content2 = getContent();
        int hashCode2 = (hashCode * 59) + (content2 == null ? 43 : content2.hashCode());
        String cancel2 = getCancel();
        int hashCode3 = (hashCode2 * 59) + (cancel2 == null ? 43 : cancel2.hashCode());
        String confirm2 = getConfirm();
        int i13 = hashCode3 * 59;
        if (confirm2 != null) {
            i12 = confirm2.hashCode();
        }
        return i13 + i12;
    }

    public boolean isShowAlert() {
        return this.isShowAlert;
    }

    public void setCancel(String str) {
        this.cancel = str;
    }

    public void setConfirm(String str) {
        this.confirm = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setShowAlert(boolean z11) {
        this.isShowAlert = z11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "AlertInfo(isShowAlert=" + isShowAlert() + ", title=" + getTitle() + ", content=" + getContent() + ", cancel=" + getCancel() + ", confirm=" + getConfirm() + ")";
    }
}
