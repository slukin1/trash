package com.jumio.sdk.document;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class JumioDigitalDocument implements JumioDocument {

    /* renamed from: a  reason: collision with root package name */
    public final String f24972a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24973b;

    public JumioDigitalDocument(String str, String str2) {
        this.f24972a = str;
        this.f24973b = str2;
    }

    public static /* synthetic */ JumioDigitalDocument copy$default(JumioDigitalDocument jumioDigitalDocument, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = jumioDigitalDocument.f24972a;
        }
        if ((i11 & 2) != 0) {
            str2 = jumioDigitalDocument.f24973b;
        }
        return jumioDigitalDocument.copy(str, str2);
    }

    public final String component1() {
        return this.f24972a;
    }

    public final String component2() {
        return this.f24973b;
    }

    public final JumioDigitalDocument copy(String str, String str2) {
        return new JumioDigitalDocument(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JumioDigitalDocument)) {
            return false;
        }
        JumioDigitalDocument jumioDigitalDocument = (JumioDigitalDocument) obj;
        return x.b(this.f24972a, jumioDigitalDocument.f24972a) && x.b(this.f24973b, jumioDigitalDocument.f24973b);
    }

    public final String getTitle() {
        return this.f24973b;
    }

    public final String getType() {
        return this.f24972a;
    }

    public int hashCode() {
        return this.f24973b.hashCode() + (this.f24972a.hashCode() * 31);
    }

    public String toString() {
        String str = this.f24972a;
        String str2 = this.f24973b;
        return "JumioDigitalDocument(type=" + str + ", title=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioDigitalDocument(String str, String str2, int i11, r rVar) {
        this(str, (i11 & 2) != 0 ? str : str2);
    }
}
