package com.business.common.swapzero.data;

import androidx.annotation.Keep;
import kotlin.jvm.internal.x;

@Keep
public final class SwapZeroSideModel {
    private final String adId;
    private final String content;
    private final Object iconRes;
    private final String jump;

    public SwapZeroSideModel(Object obj, String str, String str2, String str3) {
        this.iconRes = obj;
        this.adId = str;
        this.content = str2;
        this.jump = str3;
    }

    public static /* synthetic */ SwapZeroSideModel copy$default(SwapZeroSideModel swapZeroSideModel, Object obj, String str, String str2, String str3, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = swapZeroSideModel.iconRes;
        }
        if ((i11 & 2) != 0) {
            str = swapZeroSideModel.adId;
        }
        if ((i11 & 4) != 0) {
            str2 = swapZeroSideModel.content;
        }
        if ((i11 & 8) != 0) {
            str3 = swapZeroSideModel.jump;
        }
        return swapZeroSideModel.copy(obj, str, str2, str3);
    }

    public final Object component1() {
        return this.iconRes;
    }

    public final String component2() {
        return this.adId;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.jump;
    }

    public final SwapZeroSideModel copy(Object obj, String str, String str2, String str3) {
        return new SwapZeroSideModel(obj, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwapZeroSideModel)) {
            return false;
        }
        SwapZeroSideModel swapZeroSideModel = (SwapZeroSideModel) obj;
        return x.b(this.iconRes, swapZeroSideModel.iconRes) && x.b(this.adId, swapZeroSideModel.adId) && x.b(this.content, swapZeroSideModel.content) && x.b(this.jump, swapZeroSideModel.jump);
    }

    public final String getAdId() {
        return this.adId;
    }

    public final String getContent() {
        return this.content;
    }

    public final Object getIconRes() {
        return this.iconRes;
    }

    public final String getJump() {
        return this.jump;
    }

    public int hashCode() {
        Object obj = this.iconRes;
        int i11 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        String str = this.adId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.content;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.jump;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode3 + i11;
    }

    public String toString() {
        return "SwapZeroSideModel(iconRes=" + this.iconRes + ", adId=" + this.adId + ", content=" + this.content + ", jump=" + this.jump + ')';
    }
}
