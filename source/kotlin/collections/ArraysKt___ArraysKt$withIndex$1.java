package kotlin.collections;

import d10.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

public final class ArraysKt___ArraysKt$withIndex$1 extends Lambda implements a<Iterator<? extends T>> {
    public final /* synthetic */ T[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$1(T[] tArr) {
        super(0);
        this.$this_withIndex = tArr;
    }

    public final Iterator<T> invoke() {
        return h.a(this.$this_withIndex);
    }
}
