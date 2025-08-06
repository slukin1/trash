package oupson.apng;

import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.h0;
import oupson.apng.utils.ApngAnimatorOptions;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/h0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@d(c = "oupson.apng.ApngAnimator$load$4", f = "ApngAnimator.kt", l = {}, m = "invokeSuspend")
final class ApngAnimator$load$4 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ ApngAnimatorOptions $apngAnimatorOptions;
    public final /* synthetic */ Float $speed;
    public final /* synthetic */ String $string;
    public int label;
    public final /* synthetic */ ApngAnimator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApngAnimator$load$4(ApngAnimator apngAnimator, Float f11, String str, ApngAnimatorOptions apngAnimatorOptions, c cVar) {
        super(2, cVar);
        this.this$0 = apngAnimator;
        this.$speed = f11;
        this.$string = str;
        this.$apngAnimatorOptions = apngAnimatorOptions;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ApngAnimator$load$4(this.this$0, this.$speed, this.$string, this.$apngAnimatorOptions, cVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ApngAnimator$load$4) create(obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0095, code lost:
        r13 = (r13 = r13.getAssets()).open(kotlin.text.StringsKt__StringsJVMKt.G(r12.$string, com.davemorrissey.labs.subscaleview.ImageSource.ASSET_SCHEME, "", false, 4, (java.lang.Object) null));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object unused = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r0 = r12.label
            if (r0 != 0) goto L_0x00fd
            kotlin.k.b(r13)
            oupson.apng.ApngAnimator r13 = r12.this$0
            java.lang.Float r0 = r12.$speed
            r13.u(r0)
            java.lang.String r13 = r12.$string
            java.lang.String r0 = "http"
            r1 = 0
            r2 = 2
            r3 = 0
            boolean r13 = kotlin.text.StringsKt__StringsKt.R(r13, r0, r1, r2, r3)
            if (r13 != 0) goto L_0x00ea
            java.lang.String r13 = r12.$string
            java.lang.String r0 = "https"
            boolean r13 = kotlin.text.StringsKt__StringsKt.R(r13, r0, r1, r2, r3)
            if (r13 == 0) goto L_0x002a
            goto L_0x00ea
        L_0x002a:
            java.io.File r13 = new java.io.File
            java.lang.String r0 = r12.$string
            r13.<init>(r0)
            boolean r13 = r13.exists()
            if (r13 == 0) goto L_0x007d
            java.lang.String r13 = r12.$string
            java.lang.String r0 = "content://"
            boolean r13 = kotlin.text.StringsKt__StringsJVMKt.M(r13, r0, r1, r2, r3)
            if (r13 == 0) goto L_0x0044
            java.lang.String r13 = r12.$string
            goto L_0x0057
        L_0x0044:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "file://"
            r13.append(r0)
            java.lang.String r0 = r12.$string
            r13.append(r0)
            java.lang.String r13 = r13.toString()
        L_0x0057:
            r0 = r13
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "%"
            java.lang.String r2 = "%25"
            java.lang.String r6 = kotlin.text.StringsKt__StringsJVMKt.G(r0, r1, r2, r3, r4, r5)
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r7 = "#"
            java.lang.String r8 = "%23"
            java.lang.String r13 = kotlin.text.StringsKt__StringsJVMKt.G(r6, r7, r8, r9, r10, r11)
            oupson.apng.ApngAnimator r0 = r12.this$0
            android.net.Uri r13 = android.net.Uri.parse(r13)
            java.lang.Float r1 = r12.$speed
            oupson.apng.utils.ApngAnimatorOptions r2 = r12.$apngAnimatorOptions
            r0.n(r13, r1, r2)
            goto L_0x00fa
        L_0x007d:
            java.lang.String r13 = r12.$string
            java.lang.String r0 = "file:///android_asset/"
            boolean r13 = kotlin.text.StringsKt__StringsJVMKt.M(r13, r0, r1, r2, r3)
            if (r13 == 0) goto L_0x00fa
            oupson.apng.ApngAnimator r13 = r12.this$0
            android.content.Context r13 = r13.f52929l
            if (r13 == 0) goto L_0x00ad
            android.content.res.AssetManager r13 = r13.getAssets()
            if (r13 == 0) goto L_0x00ad
            java.lang.String r4 = r12.$string
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r5 = "file:///android_asset/"
            java.lang.String r6 = ""
            java.lang.String r0 = kotlin.text.StringsKt__StringsJVMKt.G(r4, r5, r6, r7, r8, r9)
            java.io.InputStream r13 = r13.open(r0)
            if (r13 == 0) goto L_0x00ad
            byte[] r13 = kotlin.io.a.c(r13)
            goto L_0x00ae
        L_0x00ad:
            r13 = r3
        L_0x00ae:
            if (r13 == 0) goto L_0x00e2
            oupson.apng.utils.Utils$Companion r0 = oupson.apng.utils.Utils.f52981j
            boolean r0 = r0.l(r13)
            if (r0 == 0) goto L_0x00c2
            oupson.apng.ApngAnimator r0 = r12.this$0
            java.lang.Float r1 = r12.$speed
            oupson.apng.utils.ApngAnimatorOptions r2 = r12.$apngAnimatorOptions
            r0.o(r13, r1, r2)
            goto L_0x00fa
        L_0x00c2:
            oupson.apng.ApngAnimator r0 = r12.this$0
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x00dc
            kotlinx.coroutines.g1 r4 = kotlinx.coroutines.g1.f57277b
            kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.v0.c()
            r6 = 0
            oupson.apng.ApngAnimator$load$4$1 r7 = new oupson.apng.ApngAnimator$load$4$1
            r7.<init>(r12, r13, r3)
            r8 = 2
            r9 = 0
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r4, r5, r6, r7, r8, r9)
            goto L_0x00fa
        L_0x00dc:
            oupson.apng.exceptions.NotApngException r13 = new oupson.apng.exceptions.NotApngException
            r13.<init>()
            throw r13
        L_0x00e2:
            java.lang.Exception r13 = new java.lang.Exception
            java.lang.String r0 = "File are empty"
            r13.<init>(r0)
            throw r13
        L_0x00ea:
            java.net.URL r13 = new java.net.URL
            java.lang.String r0 = r12.$string
            r13.<init>(r0)
            oupson.apng.ApngAnimator r0 = r12.this$0
            java.lang.Float r1 = r12.$speed
            oupson.apng.utils.ApngAnimatorOptions r2 = r12.$apngAnimatorOptions
            r0.p(r13, r1, r2)
        L_0x00fa:
            kotlin.Unit r13 = kotlin.Unit.f56620a
            return r13
        L_0x00fd:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: oupson.apng.ApngAnimator$load$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
