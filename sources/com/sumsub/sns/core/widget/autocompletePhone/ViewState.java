package com.sumsub.sns.core.widget.autocompletePhone;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/ViewState;", "", "text", "", "countryCode", "validationError", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;)V", "getCountryCode", "()Ljava/lang/String;", "getText", "getValidationError", "()Ljava/lang/CharSequence;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewState {
    private final String countryCode;
    private final String text;
    private final CharSequence validationError;

    public ViewState(String str, String str2, CharSequence charSequence) {
        this.text = str;
        this.countryCode = str2;
        this.validationError = charSequence;
    }

    public static /* synthetic */ ViewState copy$default(ViewState viewState, String str, String str2, CharSequence charSequence, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = viewState.text;
        }
        if ((i11 & 2) != 0) {
            str2 = viewState.countryCode;
        }
        if ((i11 & 4) != 0) {
            charSequence = viewState.validationError;
        }
        return viewState.copy(str, str2, charSequence);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.countryCode;
    }

    public final CharSequence component3() {
        return this.validationError;
    }

    public final ViewState copy(String str, String str2, CharSequence charSequence) {
        return new ViewState(str, str2, charSequence);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewState)) {
            return false;
        }
        ViewState viewState = (ViewState) obj;
        return x.b(this.text, viewState.text) && x.b(this.countryCode, viewState.countryCode) && x.b(this.validationError, viewState.validationError);
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getText() {
        return this.text;
    }

    public final CharSequence getValidationError() {
        return this.validationError;
    }

    public int hashCode() {
        int hashCode = this.text.hashCode() * 31;
        String str = this.countryCode;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        CharSequence charSequence = this.validationError;
        if (charSequence != null) {
            i11 = charSequence.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "ViewState(text=" + this.text + ", countryCode=" + this.countryCode + ", validationError=" + this.validationError + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewState(String str, String str2, CharSequence charSequence, int i11, r rVar) {
        this(str, str2, (i11 & 4) != 0 ? null : charSequence);
    }
}
