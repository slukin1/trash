package com.huobi.architecture.mvvm.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import x1.a;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010R6\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/huobi/architecture/mvvm/adapter/c;", "Lx1/a;", "VB", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/Function2;", "Landroid/view/View;", "", "", "childClickListener", "Ld10/p;", "e", "()Ld10/p;", "f", "(Ld10/p;)V", "vb", "<init>", "(Lx1/a;)V", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
public final class c<VB extends a> extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final VB f42231a;

    /* renamed from: b  reason: collision with root package name */
    public p<? super View, ? super Integer, Unit> f42232b;

    public c(VB vb2) {
        super(vb2.getRoot());
        this.f42231a = vb2;
    }

    public final p<View, Integer, Unit> e() {
        return this.f42232b;
    }

    public final void f(p<? super View, ? super Integer, Unit> pVar) {
        this.f42232b = pVar;
    }
}
