package com.hbg.module.libkt.utils.event.bean;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class PageVisible {

    /* renamed from: a  reason: collision with root package name */
    public String f24885a;

    public PageVisible() {
        this((String) null, 1, (r) null);
    }

    public PageVisible(String str) {
        this.f24885a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PageVisible) && x.b(this.f24885a, ((PageVisible) obj).f24885a);
    }

    public int hashCode() {
        String str = this.f24885a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "PageVisible(pageTitle=" + this.f24885a + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PageVisible(String str, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str);
    }
}
