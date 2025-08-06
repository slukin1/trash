package org.aspectj.runtime.reflect;

import w10.c;

public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public Class f59018a;

    /* renamed from: b  reason: collision with root package name */
    public String f59019b;

    /* renamed from: c  reason: collision with root package name */
    public int f59020c;

    public g(Class cls, String str, int i11) {
        this.f59018a = cls;
        this.f59019b = str;
        this.f59020c = i11;
    }

    public String a() {
        return this.f59019b;
    }

    public int b() {
        return this.f59020c;
    }

    public String toString() {
        return a() + ":" + b();
    }
}
