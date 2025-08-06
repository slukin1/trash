package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ak;
import java.util.Objects;

final class q implements ai {

    /* renamed from: a  reason: collision with root package name */
    private Context f66847a;

    private q() {
    }

    public /* synthetic */ q(p pVar) {
    }

    public final q a(Context context) {
        Objects.requireNonNull(context);
        this.f66847a = context;
        return this;
    }

    public final s b() {
        ak.a(this.f66847a, Context.class);
        return new s(this.f66847a, (r) null);
    }
}
