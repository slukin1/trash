package com.huobi.sharev2.createimage.create;

import com.blankj.utilcode.util.a;
import d10.l;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import xr.i;

public final class CreateImageImpl$doImageCreate$1 extends Lambda implements l<String, String> {
    public final /* synthetic */ String $data;
    public final /* synthetic */ CreateImageImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreateImageImpl$doImageCreate$1(String str, CreateImageImpl createImageImpl) {
        super(1);
        this.$data = str;
        this.this$0 = createImageImpl;
    }

    public final String invoke(String str) {
        a a11 = c.f81058a.a(this.$data);
        Objects.requireNonNull(a11, "json parse error ");
        CanvasImageReady canvasImageReady = new CanvasImageReady();
        canvasImageReady.g(a11);
        a11.a();
        a11.a();
        return i.r().I(a.c(), this.this$0.d(new b(canvasImageReady)), false);
    }
}
