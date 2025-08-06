package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import kotlin.jvm.internal.x;

@Keep
public final class RedPacketCollectBean {
    private final String redCollectDetailUrl;

    public RedPacketCollectBean(String str) {
        this.redCollectDetailUrl = str;
    }

    public static /* synthetic */ RedPacketCollectBean copy$default(RedPacketCollectBean redPacketCollectBean, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = redPacketCollectBean.redCollectDetailUrl;
        }
        return redPacketCollectBean.copy(str);
    }

    public final String component1() {
        return this.redCollectDetailUrl;
    }

    public final RedPacketCollectBean copy(String str) {
        return new RedPacketCollectBean(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RedPacketCollectBean) && x.b(this.redCollectDetailUrl, ((RedPacketCollectBean) obj).redCollectDetailUrl);
    }

    public final String getRedCollectDetailUrl() {
        return this.redCollectDetailUrl;
    }

    public int hashCode() {
        String str = this.redCollectDetailUrl;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "RedPacketCollectBean(redCollectDetailUrl=" + this.redCollectDetailUrl + ')';
    }
}
