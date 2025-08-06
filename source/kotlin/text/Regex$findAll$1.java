package kotlin.text;

import d10.a;
import kotlin.jvm.internal.Lambda;

public final class Regex$findAll$1 extends Lambda implements a<g> {
    public final /* synthetic */ CharSequence $input;
    public final /* synthetic */ int $startIndex;
    public final /* synthetic */ Regex this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Regex$findAll$1(Regex regex, CharSequence charSequence, int i11) {
        super(0);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$startIndex = i11;
    }

    public final g invoke() {
        return this.this$0.find(this.$input, this.$startIndex);
    }
}
