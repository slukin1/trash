package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Keep
public final class ShareResultBean {
    private final Integer shared;

    public ShareResultBean() {
        this((Integer) null, 1, (r) null);
    }

    public ShareResultBean(Integer num) {
        this.shared = num;
    }

    public static /* synthetic */ ShareResultBean copy$default(ShareResultBean shareResultBean, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = shareResultBean.shared;
        }
        return shareResultBean.copy(num);
    }

    public final Integer component1() {
        return this.shared;
    }

    public final ShareResultBean copy(Integer num) {
        return new ShareResultBean(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShareResultBean) && x.b(this.shared, ((ShareResultBean) obj).shared);
    }

    public final Integer getShared() {
        return this.shared;
    }

    public int hashCode() {
        Integer num = this.shared;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "ShareResultBean(shared=" + this.shared + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShareResultBean(Integer num, int i11, r rVar) {
        this((i11 & 1) != 0 ? 0 : num);
    }
}
