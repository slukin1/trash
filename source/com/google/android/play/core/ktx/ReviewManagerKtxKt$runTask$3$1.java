package com.google.android.play.core.ktx;

import d10.a;
import d10.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ReviewManagerKtxKt$runTask$3$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ a<Unit> $onCanceled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReviewManagerKtxKt$runTask$3$1(a<Unit> aVar) {
        super(1);
        this.$onCanceled = aVar;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        this.$onCanceled.invoke();
    }
}
