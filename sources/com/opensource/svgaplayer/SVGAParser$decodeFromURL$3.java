package com.opensource.svgaplayer;

import ay.b;
import com.opensource.svgaplayer.SVGAParser;
import d10.l;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 1, 15})
public final class SVGAParser$decodeFromURL$3 extends Lambda implements l<Exception, Unit> {
    public final /* synthetic */ SVGAParser.c $callback;
    public final /* synthetic */ URL $url;
    public final /* synthetic */ String $urlPath;
    public final /* synthetic */ SVGAParser this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SVGAParser$decodeFromURL$3(SVGAParser sVGAParser, URL url, SVGAParser.c cVar, String str) {
        super(1);
        this.this$0 = sVGAParser;
        this.$url = url;
        this.$callback = cVar;
        this.$urlPath = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Exception) obj);
        return Unit.f56620a;
    }

    public final void invoke(Exception exc) {
        b bVar = b.f26389a;
        bVar.b("SVGAParser", "================ svga file: " + this.$url + " download fail ================");
        this.this$0.w(exc, this.$callback, this.$urlPath);
    }
}
