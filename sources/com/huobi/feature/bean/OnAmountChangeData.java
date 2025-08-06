package com.huobi.feature.bean;

import android.text.Editable;

public class OnAmountChangeData {

    /* renamed from: a  reason: collision with root package name */
    public boolean f44620a;

    /* renamed from: b  reason: collision with root package name */
    public Editable f44621b;

    /* renamed from: c  reason: collision with root package name */
    public int f44622c;

    public Editable a() {
        return this.f44621b;
    }

    public int b() {
        return this.f44622c;
    }

    public boolean c() {
        return this.f44620a;
    }

    public void d(Editable editable) {
        this.f44621b = editable;
    }

    public void e(boolean z11) {
        this.f44620a = z11;
    }

    public void f(int i11) {
        this.f44622c = i11;
    }

    public String toString() {
        return "OnAmountChangeData{fromEt=" + this.f44620a + ", amountETText=" + this.f44621b + ", progress=" + this.f44622c + '}';
    }
}
