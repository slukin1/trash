package com.jumio.defaultui;

import androidx.navigation.AnimBuilder;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class a extends Lambda implements l<AnimBuilder, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f70820a = new a();

    public a() {
        super(1);
    }

    public final Object invoke(Object obj) {
        AnimBuilder animBuilder = (AnimBuilder) obj;
        animBuilder.e(R.animator.jumio_slide_in);
        int i11 = R.animator.jumio_slide_out;
        animBuilder.f(i11);
        animBuilder.g(i11);
        return Unit.f56620a;
    }
}
