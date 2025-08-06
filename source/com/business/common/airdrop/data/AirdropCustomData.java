package com.business.common.airdrop.data;

import androidx.annotation.Keep;
import kotlin.jvm.internal.x;

@Keep
public final class AirdropCustomData {
    private final AirdropExtInfo extInfo;

    public AirdropCustomData(AirdropExtInfo airdropExtInfo) {
        this.extInfo = airdropExtInfo;
    }

    public static /* synthetic */ AirdropCustomData copy$default(AirdropCustomData airdropCustomData, AirdropExtInfo airdropExtInfo, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            airdropExtInfo = airdropCustomData.extInfo;
        }
        return airdropCustomData.copy(airdropExtInfo);
    }

    public final AirdropExtInfo component1() {
        return this.extInfo;
    }

    public final AirdropCustomData copy(AirdropExtInfo airdropExtInfo) {
        return new AirdropCustomData(airdropExtInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AirdropCustomData) && x.b(this.extInfo, ((AirdropCustomData) obj).extInfo);
    }

    public final AirdropExtInfo getExtInfo() {
        return this.extInfo;
    }

    public int hashCode() {
        AirdropExtInfo airdropExtInfo = this.extInfo;
        if (airdropExtInfo == null) {
            return 0;
        }
        return airdropExtInfo.hashCode();
    }

    public String toString() {
        return "AirdropCustomData(extInfo=" + this.extInfo + ')';
    }
}
