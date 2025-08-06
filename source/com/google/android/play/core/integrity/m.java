package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ak;
import java.util.Objects;

final class m implements t {

    /* renamed from: a  reason: collision with root package name */
    private Context f66837a;

    private m() {
    }

    public /* synthetic */ m(l lVar) {
    }

    public final m a(Context context) {
        Objects.requireNonNull(context);
        this.f66837a = context;
        return this;
    }

    public final o b() {
        ak.a(this.f66837a, Context.class);
        return new o(this.f66837a, (n) null);
    }
}
