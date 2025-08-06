package com.hbg.module.community.multiadapter;

import d10.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class MutableTypes$unregister$1 extends Lambda implements l<f<?>, Boolean> {
    public final /* synthetic */ Class<?> $clazz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutableTypes$unregister$1(Class<?> cls) {
        super(1);
        this.$clazz = cls;
    }

    public final Boolean invoke(f<?> fVar) {
        return Boolean.valueOf(x.b(fVar.a(), this.$clazz));
    }
}
