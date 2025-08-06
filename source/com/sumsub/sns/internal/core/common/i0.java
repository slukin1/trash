package com.sumsub.sns.internal.core.common;

import android.content.Context;
import dy.b;
import kotlin.i;
import kotlin.jvm.internal.Lambda;

public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public final i f32081a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f32082b = a().n();

    public static final class a extends Lambda implements d10.a<b> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f32083a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.f32083a = context;
        }

        /* renamed from: a */
        public final b invoke() {
            return new b(this.f32083a);
        }
    }

    public i0(Context context) {
        this.f32081a = LazyKt__LazyJVMKt.a(new a(context));
    }

    public final b a() {
        return (b) this.f32081a.getValue();
    }

    public final boolean b() {
        return this.f32082b;
    }
}
