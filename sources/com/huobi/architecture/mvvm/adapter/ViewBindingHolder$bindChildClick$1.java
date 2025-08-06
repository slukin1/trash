package com.huobi.architecture.mvvm.adapter;

import android.view.View;
import d10.l;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import x1.a;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lx1/a;", "VB", "Landroid/view/View;", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class ViewBindingHolder$bindChildClick$1 extends Lambda implements l<View, Unit> {
    public final /* synthetic */ c<a> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewBindingHolder$bindChildClick$1(c<a> cVar) {
        super(1);
        this.this$0 = cVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.f56620a;
    }

    public final void invoke(View view) {
        p<View, Integer, Unit> e11 = this.this$0.e();
        if (e11 != null) {
            e11.invoke(view, Integer.valueOf(this.this$0.getLayoutPosition()));
        }
    }
}
