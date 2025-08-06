package com.hbg.module.community.multiadapter;

import c10.a;
import d10.p;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.c;

final class OneToManyEndpoint$withKotlinClassLinker$2 extends Lambda implements p<Integer, Object, Class<? extends ItemViewDelegate<Object, ?>>> {
    public final /* synthetic */ p<Integer, Object, c<? extends ItemViewDelegate<Object, ?>>> $classLinker;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneToManyEndpoint$withKotlinClassLinker$2(p<? super Integer, Object, ? extends c<? extends ItemViewDelegate<Object, ?>>> pVar) {
        super(2);
        this.$classLinker = pVar;
    }

    public final Class<? extends ItemViewDelegate<Object, ?>> invoke(int i11, Object obj) {
        return a.a(this.$classLinker.invoke(Integer.valueOf(i11), obj));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), obj2);
    }
}
