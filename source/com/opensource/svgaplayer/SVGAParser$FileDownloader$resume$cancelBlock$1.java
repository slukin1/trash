package com.opensource.svgaplayer;

import d10.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 15})
public final class SVGAParser$FileDownloader$resume$cancelBlock$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ Ref$BooleanRef $cancelled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SVGAParser$FileDownloader$resume$cancelBlock$1(Ref$BooleanRef ref$BooleanRef) {
        super(0);
        this.$cancelled = ref$BooleanRef;
    }

    public final void invoke() {
        this.$cancelled.element = true;
    }
}
