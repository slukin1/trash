package com.huobi.edgeengine.model;

import java.io.Serializable;
import kotlin.jvm.internal.x;

public final class ShareMode implements Serializable {
    private final String jumpUrl;
    private final String template;
    private final String type;
    private final String waitTime;

    public ShareMode(String str, String str2, String str3, String str4) {
        this.template = str;
        this.type = str2;
        this.waitTime = str3;
        this.jumpUrl = str4;
    }

    public static /* synthetic */ ShareMode copy$default(ShareMode shareMode, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = shareMode.template;
        }
        if ((i11 & 2) != 0) {
            str2 = shareMode.type;
        }
        if ((i11 & 4) != 0) {
            str3 = shareMode.waitTime;
        }
        if ((i11 & 8) != 0) {
            str4 = shareMode.jumpUrl;
        }
        return shareMode.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.template;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.waitTime;
    }

    public final String component4() {
        return this.jumpUrl;
    }

    public final ShareMode copy(String str, String str2, String str3, String str4) {
        return new ShareMode(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareMode)) {
            return false;
        }
        ShareMode shareMode = (ShareMode) obj;
        return x.b(this.template, shareMode.template) && x.b(this.type, shareMode.type) && x.b(this.waitTime, shareMode.waitTime) && x.b(this.jumpUrl, shareMode.jumpUrl);
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final String getType() {
        return this.type;
    }

    public final String getWaitTime() {
        return this.waitTime;
    }

    public int hashCode() {
        String str = this.template;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.waitTime;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.jumpUrl;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode3 + i11;
    }

    public String toString() {
        return "ShareMode(template=" + this.template + ", type=" + this.type + ", waitTime=" + this.waitTime + ", jumpUrl=" + this.jumpUrl + ')';
    }
}
