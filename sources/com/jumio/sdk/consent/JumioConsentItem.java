package com.jumio.sdk.consent;

import android.text.SpannableString;
import android.text.Spanned;
import com.jumio.sdk.enums.JumioConsentType;
import java.io.Serializable;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jumio.core.o;
import jumio.core.u;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;

public final class JumioConsentItem implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f24955a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24956b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24957c;

    /* renamed from: d  reason: collision with root package name */
    public final JumioConsentType f24958d;

    public JumioConsentItem(String str, String str2, String str3, JumioConsentType jumioConsentType) {
        this.f24955a = str;
        this.f24956b = str2;
        this.f24957c = str3;
        this.f24958d = jumioConsentType;
    }

    public static /* synthetic */ JumioConsentItem copy$default(JumioConsentItem jumioConsentItem, String str, String str2, String str3, JumioConsentType jumioConsentType, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = jumioConsentItem.f24955a;
        }
        if ((i11 & 2) != 0) {
            str2 = jumioConsentItem.f24956b;
        }
        if ((i11 & 4) != 0) {
            str3 = jumioConsentItem.f24957c;
        }
        if ((i11 & 8) != 0) {
            jumioConsentType = jumioConsentItem.f24958d;
        }
        return jumioConsentItem.copy(str, str2, str3, jumioConsentType);
    }

    public static /* synthetic */ Spanned spannedTextWithLinkColor$default(JumioConsentItem jumioConsentItem, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        return jumioConsentItem.spannedTextWithLinkColor(i11);
    }

    public final String component1() {
        return this.f24955a;
    }

    public final String component2() {
        return this.f24956b;
    }

    public final String component3() {
        return this.f24957c;
    }

    public final JumioConsentType component4() {
        return this.f24958d;
    }

    public final JumioConsentItem copy(String str, String str2, String str3, JumioConsentType jumioConsentType) {
        return new JumioConsentItem(str, str2, str3, jumioConsentType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JumioConsentItem)) {
            return false;
        }
        JumioConsentItem jumioConsentItem = (JumioConsentItem) obj;
        return x.b(this.f24955a, jumioConsentItem.f24955a) && x.b(this.f24956b, jumioConsentItem.f24956b) && x.b(this.f24957c, jumioConsentItem.f24957c) && this.f24958d == jumioConsentItem.f24958d;
    }

    public final String getId() {
        return this.f24955a;
    }

    public final String getText() {
        return this.f24957c;
    }

    public final JumioConsentType getType() {
        return this.f24958d;
    }

    public final String getUrl() {
        return this.f24956b;
    }

    public int hashCode() {
        return this.f24958d.hashCode() + o.a(this.f24957c, o.a(this.f24956b, this.f24955a.hashCode() * 31, 31), 31);
    }

    public final Spanned spannedTextWithLinkColor(int i11) {
        d0 d0Var = d0.f56774a;
        String format = String.format(this.f24957c, Arrays.copyOf(new Object[0], 0));
        Matcher matcher = Pattern.compile("\\[\\(\\{(.*)\\}\\)\\]").matcher(format);
        if (!matcher.find()) {
            return new SpannableString(format);
        }
        String group = matcher.group(0);
        String str = "";
        String str2 = group == null ? str : group;
        String group2 = matcher.group(1);
        if (group2 != null) {
            str = group2;
        }
        String G = StringsKt__StringsJVMKt.G(format, str2, str, false, 4, (Object) null);
        SpannableString spannableString = new SpannableString(G);
        String str3 = G;
        String str4 = str;
        spannableString.setSpan(new u(this.f24956b, i11), StringsKt__StringsKt.g0(str3, str4, 0, false, 6, (Object) null), str.length() + StringsKt__StringsKt.g0(str3, str4, 0, false, 6, (Object) null), 33);
        return spannableString;
    }

    public String toString() {
        d0 d0Var = d0.f56774a;
        return String.format("%s", Arrays.copyOf(new Object[]{this.f24958d}, 1));
    }
}
