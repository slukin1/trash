package kotlin.text;

import d10.l;
import kotlin.jvm.internal.Lambda;

final class StringsKt___StringsKt$windowedSequence$2 extends Lambda implements l<Integer, Object> {
    public final /* synthetic */ int $size;
    public final /* synthetic */ CharSequence $this_windowedSequence;
    public final /* synthetic */ l<CharSequence, Object> $transform;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt___StringsKt$windowedSequence$2(int i11, CharSequence charSequence, l<? super CharSequence, Object> lVar) {
        super(1);
        this.$size = i11;
        this.$this_windowedSequence = charSequence;
        this.$transform = lVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Object invoke(int i11) {
        int i12 = this.$size + i11;
        if (i12 < 0 || i12 > this.$this_windowedSequence.length()) {
            i12 = this.$this_windowedSequence.length();
        }
        return this.$transform.invoke(this.$this_windowedSequence.subSequence(i11, i12));
    }
}
