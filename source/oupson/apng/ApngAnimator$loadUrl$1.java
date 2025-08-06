package oupson.apng;

import d10.p;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.h0;
import oupson.apng.utils.ApngAnimatorOptions;

@d(c = "oupson.apng.ApngAnimator$loadUrl$1", f = "ApngAnimator.kt", l = {280}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/h0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ApngAnimator$loadUrl$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ ApngAnimatorOptions $apngAnimatorOptions;
    public final /* synthetic */ Float $speed;
    public final /* synthetic */ URL $url;
    public int label;
    public final /* synthetic */ ApngAnimator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApngAnimator$loadUrl$1(ApngAnimator apngAnimator, Float f11, URL url, ApngAnimatorOptions apngAnimatorOptions, c cVar) {
        super(2, cVar);
        this.this$0 = apngAnimator;
        this.$speed = f11;
        this.$url = url;
        this.$apngAnimatorOptions = apngAnimatorOptions;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ApngAnimator$loadUrl$1(this.this$0, this.$speed, this.$url, this.$apngAnimatorOptions, cVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ApngAnimator$loadUrl$1) create(obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(1:(2:3|4)(2:5|6))(4:7|8|9|(1:11))|12|13|14|15|16|(3:18|21|23)(2:19|20)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003a */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042 A[Catch:{ Exception -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055 A[Catch:{ Exception -> 0x005b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.k.b(r8)     // Catch:{ Exception -> 0x005b }
            goto L_0x002e
        L_0x000f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0017:
            kotlin.k.b(r8)
            oupson.apng.ApngAnimator r8 = r7.this$0
            java.lang.Float r1 = r7.$speed
            r8.u(r1)
            oupson.apng.Loader$Companion r8 = oupson.apng.Loader.f52931a     // Catch:{ Exception -> 0x005b }
            java.net.URL r1 = r7.$url     // Catch:{ Exception -> 0x005b }
            r7.label = r2     // Catch:{ Exception -> 0x005b }
            java.lang.Object r8 = r8.a(r1, r7)     // Catch:{ Exception -> 0x005b }
            if (r8 != r0) goto L_0x002e
            return r0
        L_0x002e:
            byte[] r8 = (byte[]) r8     // Catch:{ Exception -> 0x005b }
            oupson.apng.ApngAnimator r0 = r7.this$0     // Catch:{ NotPngException -> 0x003a }
            java.lang.Float r1 = r7.$speed     // Catch:{ NotPngException -> 0x003a }
            oupson.apng.utils.ApngAnimatorOptions r2 = r7.$apngAnimatorOptions     // Catch:{ NotPngException -> 0x003a }
            r0.o(r8, r1, r2)     // Catch:{ NotPngException -> 0x003a }
            goto L_0x005b
        L_0x003a:
            oupson.apng.ApngAnimator r0 = r7.this$0     // Catch:{ Exception -> 0x005b }
            boolean r0 = r0.m()     // Catch:{ Exception -> 0x005b }
            if (r0 == 0) goto L_0x0055
            kotlinx.coroutines.g1 r1 = kotlinx.coroutines.g1.f57277b     // Catch:{ Exception -> 0x005b }
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.v0.c()     // Catch:{ Exception -> 0x005b }
            r3 = 0
            oupson.apng.ApngAnimator$loadUrl$1$invokeSuspend$$inlined$apply$lambda$1 r4 = new oupson.apng.ApngAnimator$loadUrl$1$invokeSuspend$$inlined$apply$lambda$1     // Catch:{ Exception -> 0x005b }
            r0 = 0
            r4.<init>(r8, r0, r7)     // Catch:{ Exception -> 0x005b }
            r5 = 2
            r6 = 0
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x005b }
            goto L_0x005b
        L_0x0055:
            oupson.apng.exceptions.NotApngException r8 = new oupson.apng.exceptions.NotApngException     // Catch:{ Exception -> 0x005b }
            r8.<init>()     // Catch:{ Exception -> 0x005b }
            throw r8     // Catch:{ Exception -> 0x005b }
        L_0x005b:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: oupson.apng.ApngAnimator$loadUrl$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
