package kotlin.collections;

import d10.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;

final class ArraysKt___ArraysKt$withIndex$7 extends Lambda implements a<Iterator<? extends Double>> {
    public final /* synthetic */ double[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$7(double[] dArr) {
        super(0);
        this.$this_withIndex = dArr;
    }

    public final Iterator<Double> invoke() {
        return i.d(this.$this_withIndex);
    }
}
