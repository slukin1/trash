package androidx.core.view;

import android.view.View;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.sequences.SequenceScope;

@d(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {414, 416}, m = "invokeSuspend")
public final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements p<SequenceScope<? super View>, c<? super Unit>, Object> {
    public final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, c<? super ViewKt$allViews$1> cVar) {
        super(2, cVar);
        this.$this_allViews = view;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, cVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    public final Object invoke(SequenceScope<? super View> sequenceScope, c<? super Unit> cVar) {
        return ((ViewKt$allViews$1) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlin.sequences.SequenceScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.k.b(r5)
            goto L_0x004f
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            java.lang.Object r1 = r4.L$0
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            kotlin.k.b(r5)
            goto L_0x0037
        L_0x0022:
            kotlin.k.b(r5)
            java.lang.Object r5 = r4.L$0
            r1 = r5
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            android.view.View r5 = r4.$this_allViews
            r4.L$0 = r1
            r4.label = r3
            java.lang.Object r5 = r1.b(r5, r4)
            if (r5 != r0) goto L_0x0037
            return r0
        L_0x0037:
            android.view.View r5 = r4.$this_allViews
            boolean r3 = r5 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x004f
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            kotlin.sequences.g r5 = androidx.core.view.ViewGroupKt.b(r5)
            r3 = 0
            r4.L$0 = r3
            r4.label = r2
            java.lang.Object r5 = r1.f(r5, r4)
            if (r5 != r0) goto L_0x004f
            return r0
        L_0x004f:
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewKt$allViews$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
