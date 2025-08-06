package com.business.common.airdrop.data;

import androidx.annotation.Keep;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Keep
public final class AirdropCustomBean {
    private final String businessID;
    private final AirdropCustomData data;
    private final boolean encrypt;
    private final String platform;
    private final String version;

    public AirdropCustomBean(AirdropCustomData airdropCustomData, String str, String str2, String str3, boolean z11) {
        this.data = airdropCustomData;
        this.platform = str;
        this.version = str2;
        this.businessID = str3;
        this.encrypt = z11;
    }

    public static /* synthetic */ AirdropCustomBean copy$default(AirdropCustomBean airdropCustomBean, AirdropCustomData airdropCustomData, String str, String str2, String str3, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            airdropCustomData = airdropCustomBean.data;
        }
        if ((i11 & 2) != 0) {
            str = airdropCustomBean.platform;
        }
        String str4 = str;
        if ((i11 & 4) != 0) {
            str2 = airdropCustomBean.version;
        }
        String str5 = str2;
        if ((i11 & 8) != 0) {
            str3 = airdropCustomBean.businessID;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            z11 = airdropCustomBean.encrypt;
        }
        return airdropCustomBean.copy(airdropCustomData, str4, str5, str6, z11);
    }

    public final AirdropCustomData component1() {
        return this.data;
    }

    public final String component2() {
        return this.platform;
    }

    public final String component3() {
        return this.version;
    }

    public final String component4() {
        return this.businessID;
    }

    public final boolean component5() {
        return this.encrypt;
    }

    public final AirdropCustomBean copy(AirdropCustomData airdropCustomData, String str, String str2, String str3, boolean z11) {
        return new AirdropCustomBean(airdropCustomData, str, str2, str3, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirdropCustomBean)) {
            return false;
        }
        AirdropCustomBean airdropCustomBean = (AirdropCustomBean) obj;
        return x.b(this.data, airdropCustomBean.data) && x.b(this.platform, airdropCustomBean.platform) && x.b(this.version, airdropCustomBean.version) && x.b(this.businessID, airdropCustomBean.businessID) && this.encrypt == airdropCustomBean.encrypt;
    }

    public final String getBusinessID() {
        return this.businessID;
    }

    public final AirdropCustomData getData() {
        return this.data;
    }

    public final boolean getEncrypt() {
        return this.encrypt;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        AirdropCustomData airdropCustomData = this.data;
        int i11 = 0;
        int hashCode = (airdropCustomData == null ? 0 : airdropCustomData.hashCode()) * 31;
        String str = this.platform;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.version;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.businessID;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        int i12 = (hashCode3 + i11) * 31;
        boolean z11 = this.encrypt;
        if (z11) {
            z11 = true;
        }
        return i12 + (z11 ? 1 : 0);
    }

    public String toString() {
        return "AirdropCustomBean(data=" + this.data + ", platform=" + this.platform + ", version=" + this.version + ", businessID=" + this.businessID + ", encrypt=" + this.encrypt + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AirdropCustomBean(AirdropCustomData airdropCustomData, String str, String str2, String str3, boolean z11, int i11, r rVar) {
        this(airdropCustomData, str, str2, str3, (i11 & 16) != 0 ? false : z11);
    }
}
