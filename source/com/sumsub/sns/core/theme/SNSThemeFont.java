package com.sumsub.sns.core.theme;

import android.graphics.Typeface;
import com.sumsub.sns.core.a;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@a
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSThemeFont;", "", "typeface", "Landroid/graphics/Typeface;", "sizeSp", "", "(Landroid/graphics/Typeface;I)V", "getSizeSp", "()I", "getTypeface", "()Landroid/graphics/Typeface;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSThemeFont {
    private final int sizeSp;
    private final Typeface typeface;

    public SNSThemeFont(Typeface typeface2, int i11) {
        this.typeface = typeface2;
        this.sizeSp = i11;
    }

    public static /* synthetic */ SNSThemeFont copy$default(SNSThemeFont sNSThemeFont, Typeface typeface2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            typeface2 = sNSThemeFont.typeface;
        }
        if ((i12 & 2) != 0) {
            i11 = sNSThemeFont.sizeSp;
        }
        return sNSThemeFont.copy(typeface2, i11);
    }

    public final Typeface component1() {
        return this.typeface;
    }

    public final int component2() {
        return this.sizeSp;
    }

    public final SNSThemeFont copy(Typeface typeface2, int i11) {
        return new SNSThemeFont(typeface2, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SNSThemeFont)) {
            return false;
        }
        SNSThemeFont sNSThemeFont = (SNSThemeFont) obj;
        return x.b(this.typeface, sNSThemeFont.typeface) && this.sizeSp == sNSThemeFont.sizeSp;
    }

    public final int getSizeSp() {
        return this.sizeSp;
    }

    public final Typeface getTypeface() {
        return this.typeface;
    }

    public int hashCode() {
        return (this.typeface.hashCode() * 31) + this.sizeSp;
    }

    public String toString() {
        return "SNSThemeFont(typeface=" + this.typeface + ", sizeSp=" + this.sizeSp + ')';
    }
}
