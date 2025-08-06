package com.sumsub.sns.core.theme;

import com.sumsub.sns.core.a;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@a
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSThemeColor;", "", "light", "", "dark", "(II)V", "getDark", "()I", "getLight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSThemeColor {
    private final int dark;
    private final int light;

    public SNSThemeColor(int i11, int i12) {
        this.light = i11;
        this.dark = i12;
    }

    public static /* synthetic */ SNSThemeColor copy$default(SNSThemeColor sNSThemeColor, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = sNSThemeColor.light;
        }
        if ((i13 & 2) != 0) {
            i12 = sNSThemeColor.dark;
        }
        return sNSThemeColor.copy(i11, i12);
    }

    public final int component1() {
        return this.light;
    }

    public final int component2() {
        return this.dark;
    }

    public final SNSThemeColor copy(int i11, int i12) {
        return new SNSThemeColor(i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SNSThemeColor)) {
            return false;
        }
        SNSThemeColor sNSThemeColor = (SNSThemeColor) obj;
        return this.light == sNSThemeColor.light && this.dark == sNSThemeColor.dark;
    }

    public final int getDark() {
        return this.dark;
    }

    public final int getLight() {
        return this.light;
    }

    public int hashCode() {
        return (this.light * 31) + this.dark;
    }

    public String toString() {
        return "SNSThemeColor(light=" + this.light + ", dark=" + this.dark + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSThemeColor(int i11, int i12, int i13, r rVar) {
        this(i11, (i13 & 2) != 0 ? i11 : i12);
    }
}
