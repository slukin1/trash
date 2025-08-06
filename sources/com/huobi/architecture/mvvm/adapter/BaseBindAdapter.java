package com.huobi.architecture.mvvm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.p;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import x1.a;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004B\u0007¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001e\u0010\u000e\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\f\u001a\u00020\bH\u0016J\u001e\u0010\u000f\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\f\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0017\u0010\u0011\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/huobi/architecture/mvvm/adapter/BaseBindAdapter;", "D", "Lx1/a;", "VB", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/huobi/architecture/mvvm/adapter/c;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "f", "holder", "position", "", "e", "c", "getItemCount", "d", "(Landroid/view/ViewGroup;)Lx1/a;", "", "a", "Ljava/util/List;", "mData", "Lcom/huobi/architecture/mvvm/adapter/b;", "b", "Lcom/huobi/architecture/mvvm/adapter/b;", "getMClickListener", "()Lcom/huobi/architecture/mvvm/adapter/b;", "setMClickListener", "(Lcom/huobi/architecture/mvvm/adapter/b;)V", "mClickListener", "<init>", "()V", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
public abstract class BaseBindAdapter<D, VB extends a> extends RecyclerView.Adapter<c<VB>> {

    /* renamed from: a  reason: collision with root package name */
    public final List<D> f42226a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public b f42227b;

    /* renamed from: c  reason: collision with root package name */
    public p<? super View, ? super Integer, Unit> f42228c;

    @SensorsDataInstrumented
    public static final void g(BaseBindAdapter baseBindAdapter, c cVar, View view) {
        b bVar = baseBindAdapter.f42227b;
        if (bVar != null) {
            bVar.onItemClick(cVar.itemView, cVar.getLayoutPosition());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public abstract void c(c<VB> cVar, int i11);

    public final VB d(ViewGroup viewGroup) {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Objects.requireNonNull(type, "null cannot be cast to non-null type java.lang.Class<VB of com.huobi.architecture.mvvm.adapter.BaseBindAdapter>");
        Class cls = (Class) type;
        VB invoke = cls.getMethod("inflate", new Class[]{LayoutInflater.class, ViewGroup.class, Boolean.TYPE}).invoke(cls, new Object[]{LayoutInflater.from(viewGroup.getContext()), viewGroup, Boolean.FALSE});
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type VB of com.huobi.architecture.mvvm.adapter.BaseBindAdapter");
        return (a) invoke;
    }

    /* renamed from: e */
    public void onBindViewHolder(c<VB> cVar, int i11) {
        cVar.f(this.f42228c);
        c(cVar, i11);
    }

    /* renamed from: f */
    public c<VB> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        c<VB> cVar = new c<>(d(viewGroup));
        cVar.itemView.setOnClickListener(new a(this, cVar));
        return cVar;
    }

    public int getItemCount() {
        return this.f42226a.size();
    }
}
