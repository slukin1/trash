package kotlin.collections;

import d10.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;

final class ArraysKt___ArraysKt$withIndex$6 extends Lambda implements a<Iterator<? extends Float>> {
    public final /* synthetic */ float[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$6(float[] fArr) {
        super(0);
        this.$this_withIndex = fArr;
    }

    public final Iterator<Float> invoke() {
        return i.e(this.$this_withIndex);
    }
}
