package com.huobi.finance.bean;

import android.text.TextUtils;
import java.io.Serializable;

public class ExamInfo implements Serializable {
    private long countDown;
    private boolean hasNotify;
    private long idle;
    private String message;
    private String url;

    public boolean canEqual(Object obj) {
        return obj instanceof ExamInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExamInfo)) {
            return false;
        }
        ExamInfo examInfo = (ExamInfo) obj;
        if (!examInfo.canEqual(this) || isHasNotify() != examInfo.isHasNotify()) {
            return false;
        }
        String message2 = getMessage();
        String message3 = examInfo.getMessage();
        if (message2 != null ? !message2.equals(message3) : message3 != null) {
            return false;
        }
        String url2 = getUrl();
        String url3 = examInfo.getUrl();
        if (url2 != null ? url2.equals(url3) : url3 == null) {
            return getIdle() == examInfo.getIdle() && getCountDown() == examInfo.getCountDown();
        }
        return false;
    }

    public long getCountDown() {
        return this.countDown;
    }

    public long getIdle() {
        return this.idle;
    }

    public String getMessage() {
        return this.message;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i11 = isHasNotify() ? 79 : 97;
        String message2 = getMessage();
        int i12 = 43;
        int hashCode = ((i11 + 59) * 59) + (message2 == null ? 43 : message2.hashCode());
        String url2 = getUrl();
        int i13 = hashCode * 59;
        if (url2 != null) {
            i12 = url2.hashCode();
        }
        long idle2 = getIdle();
        int i14 = ((i13 + i12) * 59) + ((int) (idle2 ^ (idle2 >>> 32)));
        long countDown2 = getCountDown();
        return (i14 * 59) + ((int) ((countDown2 >>> 32) ^ countDown2));
    }

    public boolean isHasNotify() {
        return this.hasNotify;
    }

    public void setCountDown(long j11) {
        this.countDown = j11;
    }

    public void setHasNotify(boolean z11) {
        this.hasNotify = z11;
    }

    public void setIdle(long j11) {
        this.idle = j11;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public boolean showRetryBtn() {
        return this.hasNotify && !TextUtils.isEmpty(this.message);
    }

    public String toString() {
        return "ExamInfo(hasNotify=" + isHasNotify() + ", message=" + getMessage() + ", url=" + getUrl() + ", idle=" + getIdle() + ", countDown=" + getCountDown() + ")";
    }
}
