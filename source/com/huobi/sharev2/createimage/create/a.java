package com.huobi.sharev2.createimage.create;

import kotlin.jvm.internal.x;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f81053a;

    /* renamed from: b  reason: collision with root package name */
    public final e f81054b;

    public final e a() {
        return this.f81054b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return x.b(this.f81053a, aVar.f81053a) && x.b(this.f81054b, aVar.f81054b);
    }

    public int hashCode() {
        String str = this.f81053a;
        return ((str == null ? 0 : str.hashCode()) * 31) + 0;
    }

    public String toString() {
        return "CreateImageBean(action=" + this.f81053a + ", data=" + this.f81054b + ')';
    }
}
