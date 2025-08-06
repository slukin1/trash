package oupson.apng.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import d10.p;
import java.io.ByteArrayInputStream;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import oupson.apng.Loader;
import oupson.apng.decoder.ApngDecoder;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/h0;", "Landroid/graphics/drawable/Drawable;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@d(c = "oupson.apng.decoder.ApngDecoder$Companion$decodeApng$14", f = "ApngDecoder.kt", l = {628}, m = "invokeSuspend")
final class ApngDecoder$Companion$decodeApng$14 extends SuspendLambda implements p<h0, c<? super Drawable>, Object> {
    public final /* synthetic */ Bitmap.Config $config;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ float $speed;
    public final /* synthetic */ URL $url;
    public Object L$0;
    public Object L$1;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApngDecoder$Companion$decodeApng$14(Context context, URL url, float f11, Bitmap.Config config, c cVar) {
        super(2, cVar);
        this.$context = context;
        this.$url = url;
        this.$speed = f11;
        this.$config = config;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ApngDecoder$Companion$decodeApng$14(this.$context, this.$url, this.$speed, this.$config, cVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ApngDecoder$Companion$decodeApng$14) create(obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        ApngDecoder.Companion companion;
        Context context;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            companion = ApngDecoder.f52962c;
            Context context2 = this.$context;
            Loader.Companion companion2 = Loader.f52931a;
            URL url = this.$url;
            this.L$0 = companion;
            this.L$1 = context2;
            this.label = 1;
            Object a11 = companion2.a(url, this);
            if (a11 == d11) {
                return d11;
            }
            context = context2;
            obj = a11;
        } else if (i11 == 1) {
            context = (Context) this.L$1;
            companion = (ApngDecoder.Companion) this.L$0;
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return companion.a(context, new ByteArrayInputStream((byte[]) obj), this.$speed, this.$config);
    }
}
