package com.business.common.airdrop.data;

import androidx.annotation.Keep;

@Keep
public final class AirdropCloseIdBean {

    /* renamed from: id  reason: collision with root package name */
    private final int f64277id;

    public AirdropCloseIdBean(int i11) {
        this.f64277id = i11;
    }

    public static /* synthetic */ AirdropCloseIdBean copy$default(AirdropCloseIdBean airdropCloseIdBean, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = airdropCloseIdBean.f64277id;
        }
        return airdropCloseIdBean.copy(i11);
    }

    public final int component1() {
        return this.f64277id;
    }

    public final AirdropCloseIdBean copy(int i11) {
        return new AirdropCloseIdBean(i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AirdropCloseIdBean) && this.f64277id == ((AirdropCloseIdBean) obj).f64277id;
    }

    public final int getId() {
        return this.f64277id;
    }

    public int hashCode() {
        return this.f64277id;
    }

    public String toString() {
        return "AirdropCloseIdBean(id=" + this.f64277id + ')';
    }
}
