package com.sumsub.sns.core.presentation.form;

import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import kotlin.jvm.internal.x;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final FormItem f30928a;

    public a(FormItem formItem) {
        this.f30928a = formItem;
    }

    public final FormItem a() {
        return this.f30928a;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar == null) {
            return false;
        }
        if (!x.b(this.f30928a.e(), aVar.f30928a.e()) || !x.b(this.f30928a.d().p(), aVar.f30928a.d().p())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String e11 = this.f30928a.e();
        int i11 = 0;
        int hashCode = e11 != null ? e11.hashCode() : 0;
        String p11 = this.f30928a.d().p();
        if (p11 != null) {
            i11 = p11.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return i.a((Object) this) + " -> " + this.f30928a;
    }
}
