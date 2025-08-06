package com.sumsub.sns.core.widget.autocompletePhone;

import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\fHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/DetectFormatResult;", "", "countryIsoCode", "", "countryCode", "mask", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "getCountryIsoCode", "getMask", "maskLength", "", "getMaskLength", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DetectFormatResult {
    private final String countryCode;
    private final String countryIsoCode;
    private final String mask;

    public DetectFormatResult(String str, String str2, String str3) {
        this.countryIsoCode = str;
        this.countryCode = str2;
        this.mask = str3;
    }

    public static /* synthetic */ DetectFormatResult copy$default(DetectFormatResult detectFormatResult, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = detectFormatResult.countryIsoCode;
        }
        if ((i11 & 2) != 0) {
            str2 = detectFormatResult.countryCode;
        }
        if ((i11 & 4) != 0) {
            str3 = detectFormatResult.mask;
        }
        return detectFormatResult.copy(str, str2, str3);
    }

    public final String component1() {
        return this.countryIsoCode;
    }

    public final String component2() {
        return this.countryCode;
    }

    public final String component3() {
        return this.mask;
    }

    public final DetectFormatResult copy(String str, String str2, String str3) {
        return new DetectFormatResult(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DetectFormatResult)) {
            return false;
        }
        DetectFormatResult detectFormatResult = (DetectFormatResult) obj;
        return x.b(this.countryIsoCode, detectFormatResult.countryIsoCode) && x.b(this.countryCode, detectFormatResult.countryCode) && x.b(this.mask, detectFormatResult.mask);
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getCountryIsoCode() {
        return this.countryIsoCode;
    }

    public final String getMask() {
        return this.mask;
    }

    public final int getMaskLength() {
        return StringExtensionsKt.getMaskLength(this.mask);
    }

    public int hashCode() {
        String str = this.countryIsoCode;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.countryCode;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return ((hashCode + i11) * 31) + this.mask.hashCode();
    }

    public String toString() {
        return "DetectFormatResult(countryIsoCode=" + this.countryIsoCode + ", countryCode=" + this.countryCode + ", mask=" + this.mask + ')';
    }
}
