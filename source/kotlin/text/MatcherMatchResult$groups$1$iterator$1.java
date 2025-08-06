package kotlin.text;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class MatcherMatchResult$groups$1$iterator$1 extends Lambda implements l<Integer, e> {
    public final /* synthetic */ MatcherMatchResult$groups$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MatcherMatchResult$groups$1$iterator$1(MatcherMatchResult$groups$1 matcherMatchResult$groups$1) {
        super(1);
        this.this$0 = matcherMatchResult$groups$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final e invoke(int i11) {
        return this.this$0.get(i11);
    }
}
