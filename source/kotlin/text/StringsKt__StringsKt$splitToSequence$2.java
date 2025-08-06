package kotlin.text;

import d10.l;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.h;

final class StringsKt__StringsKt$splitToSequence$2 extends Lambda implements l<h, String> {
    public final /* synthetic */ CharSequence $this_splitToSequence;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$splitToSequence$2(CharSequence charSequence) {
        super(1);
        this.$this_splitToSequence = charSequence;
    }

    public final String invoke(h hVar) {
        return StringsKt__StringsKt.S0(this.$this_splitToSequence, hVar);
    }
}
