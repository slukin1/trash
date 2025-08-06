package com.hbg.module.community.multiadapter;

import c10.a;
import d10.p;
import kotlin.jvm.internal.Lambda;

final class OneToManyEndpoint$withKotlinClassLinker$1 extends Lambda implements p<Integer, Object, Class<? extends ItemViewDelegate<Object, ?>>> {
    public final /* synthetic */ a<Object> $classLinker;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneToManyEndpoint$withKotlinClassLinker$1(a<Object> aVar) {
        super(2);
        this.$classLinker = aVar;
    }

    public final Class<? extends ItemViewDelegate<Object, ?>> invoke(int i11, Object obj) {
        return a.a(this.$classLinker.a(i11, obj));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), obj2);
    }
}
