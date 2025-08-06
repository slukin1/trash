package com.opensource.svgaplayer;

import com.opensource.svgaplayer.SVGAParser;
import d10.l;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/io/InputStream;", "invoke"}, k = 3, mv = {1, 1, 15})
public final class SVGAParser$decodeFromURL$2 extends Lambda implements l<InputStream, Unit> {
    public final /* synthetic */ String $cacheKey;
    public final /* synthetic */ SVGAParser.c $callback;
    public final /* synthetic */ SVGAParser.d $playCallback;
    public final /* synthetic */ String $urlPath;
    public final /* synthetic */ SVGAParser this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SVGAParser$decodeFromURL$2(SVGAParser sVGAParser, String str, SVGAParser.c cVar, SVGAParser.d dVar, String str2) {
        super(1);
        this.this$0 = sVGAParser;
        this.$cacheKey = str;
        this.$callback = cVar;
        this.$playCallback = dVar;
        this.$urlPath = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InputStream) obj);
        return Unit.f56620a;
    }

    public final void invoke(InputStream inputStream) {
        this.this$0.p(inputStream, this.$cacheKey, this.$callback, false, this.$playCallback, this.$urlPath);
    }
}
