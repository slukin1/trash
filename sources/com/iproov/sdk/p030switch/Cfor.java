package com.iproov.sdk.p030switch;

import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.switch.for  reason: invalid class name and invalid package */
public final class Cfor {

    /* renamed from: do  reason: not valid java name */
    private final String f2004do;

    /* renamed from: if  reason: not valid java name */
    private final String f2005if;

    public Cfor(String str, String str2) {
        this.f2004do = str;
        this.f2005if = str2;
    }

    /* renamed from: do  reason: not valid java name */
    public final String m1885do() {
        return this.f2005if;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cfor)) {
            return false;
        }
        Cfor forR = (Cfor) obj;
        return x.b(this.f2004do, forR.f2004do) && x.b(this.f2005if, forR.f2005if);
    }

    public int hashCode() {
        String str = this.f2004do;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f2005if;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    /* renamed from: if  reason: not valid java name */
    public final String m1886if() {
        return this.f2004do;
    }

    public String toString() {
        return "PromptMessage(visual=" + this.f2004do + ", audible=" + this.f2005if + ')';
    }
}
