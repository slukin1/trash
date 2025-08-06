package kotlin.collections.unsigned;

import d10.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.m;
import kotlin.n;

final class UArraysKt___UArraysKt$withIndex$3 extends Lambda implements a<Iterator<? extends m>> {
    public final /* synthetic */ byte[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UArraysKt___UArraysKt$withIndex$3(byte[] bArr) {
        super(0);
        this.$this_withIndex = bArr;
    }

    public final Iterator<m> invoke() {
        return n.o(this.$this_withIndex);
    }
}
