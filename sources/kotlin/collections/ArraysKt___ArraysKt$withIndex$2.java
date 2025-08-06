package kotlin.collections;

import d10.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;

final class ArraysKt___ArraysKt$withIndex$2 extends Lambda implements a<Iterator<? extends Byte>> {
    public final /* synthetic */ byte[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$2(byte[] bArr) {
        super(0);
        this.$this_withIndex = bArr;
    }

    public final Iterator<Byte> invoke() {
        return i.b(this.$this_withIndex);
    }
}
