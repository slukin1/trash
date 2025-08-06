package com.opensource.svgaplayer;

import ay.b;
import d10.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", "invoke", "com/opensource/svgaplayer/SVGAParser$decodeFromInputStream$1$1$3$1", "com/opensource/svgaplayer/SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$1"}, k = 3, mv = {1, 1, 15})
public final class SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$3 extends Lambda implements a<Unit> {
    public final /* synthetic */ SVGAVideoEntity $videoItem;
    public final /* synthetic */ SVGAParser$decodeFromInputStream$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$3(SVGAVideoEntity sVGAVideoEntity, SVGAParser$decodeFromInputStream$1 sVGAParser$decodeFromInputStream$1) {
        super(0);
        this.$videoItem = sVGAVideoEntity;
        this.this$0 = sVGAParser$decodeFromInputStream$1;
    }

    public final void invoke() {
        b.f26389a.e("SVGAParser", "SVGAVideoEntity prepare success");
        SVGAParser$decodeFromInputStream$1 sVGAParser$decodeFromInputStream$1 = this.this$0;
        sVGAParser$decodeFromInputStream$1.f28515b.v(this.$videoItem, sVGAParser$decodeFromInputStream$1.f28518e, sVGAParser$decodeFromInputStream$1.f28519f);
    }
}
