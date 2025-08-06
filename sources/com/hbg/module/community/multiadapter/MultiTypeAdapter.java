package com.hbg.module.community.multiadapter;

import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.reflect.c;

public class MultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f17237d = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public List<? extends Object> f17238a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17239b;

    /* renamed from: c  reason: collision with root package name */
    public g f17240c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public MultiTypeAdapter() {
        this((List) null, 0, (g) null, 7, (r) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MultiTypeAdapter(java.util.List r1, int r2, com.hbg.module.community.multiadapter.g r3, int r4, kotlin.jvm.internal.r r5) {
        /*
            r0 = this;
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0008
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x0008:
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000d
            r2 = 0
        L_0x000d:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0018
            com.hbg.module.community.multiadapter.MutableTypes r3 = new com.hbg.module.community.multiadapter.MutableTypes
            r4 = 0
            r5 = 2
            r3.<init>(r2, r4, r5, r4)
        L_0x0018:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.multiadapter.MultiTypeAdapter.<init>(java.util.List, int, com.hbg.module.community.multiadapter.g, int, kotlin.jvm.internal.r):void");
    }

    public final ItemViewDelegate<Object, RecyclerView.ViewHolder> a(RecyclerView.ViewHolder viewHolder) {
        return c().getType(viewHolder.getItemViewType()).b();
    }

    public g c() {
        return this.f17240c;
    }

    public final int d(int i11, Object obj) throws DelegateNotFoundException {
        int c11 = c().c(obj.getClass());
        if (c11 != -1) {
            return c11 + c().getType(c11).c().a(i11, obj);
        }
        throw new DelegateNotFoundException(obj.getClass());
    }

    public final <T> e<T> e(Class<T> cls) {
        j(cls);
        return new c(this, cls);
    }

    public final <T> e<T> f(c<T> cVar) {
        return e(c10.a.a(cVar));
    }

    public final <T> void g(Class<T> cls, ItemViewBinder<T, ?> itemViewBinder) {
        h(cls, itemViewBinder);
    }

    public int getItemCount() {
        return getItems().size();
    }

    public long getItemId(int i11) {
        return c().getType(getItemViewType(i11)).b().a(getItems().get(i11));
    }

    public int getItemViewType(int i11) {
        return d(i11, getItems().get(i11));
    }

    public List<Object> getItems() {
        return this.f17238a;
    }

    public final <T> void h(Class<T> cls, ItemViewDelegate<T, ?> itemViewDelegate) {
        j(cls);
        i(new f(cls, itemViewDelegate, new DefaultLinker()));
    }

    public final <T> void i(f<T> fVar) {
        c().b(fVar);
        fVar.b().i(this);
    }

    public final void j(Class<?> cls) {
        if (c().a(cls)) {
            Log.w("MultiTypeAdapter", "The type " + cls.getSimpleName() + " you originally registered is now overwritten.");
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        onBindViewHolder(viewHolder, i11, CollectionsKt__CollectionsKt.k());
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return c().getType(i11).b().d(viewGroup.getContext(), viewGroup);
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return a(viewHolder).e(viewHolder);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        a(viewHolder).f(viewHolder);
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        a(viewHolder).g(viewHolder);
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        a(viewHolder).h(viewHolder);
    }

    public void setItems(List<? extends Object> list) {
        this.f17238a = list;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11, List<? extends Object> list) {
        Object obj;
        Object obj2 = getItems().get(i11);
        int i12 = i11 + 1;
        if (i12 < getItems().size()) {
            obj = getItems().get(i12);
        } else {
            obj = new Object();
        }
        a(viewHolder).b(viewHolder, obj2, list, !x.b(obj2.getClass().getSimpleName(), obj.getClass().getSimpleName()), i11);
    }

    public MultiTypeAdapter(List<? extends Object> list, int i11, g gVar) {
        this.f17238a = list;
        this.f17239b = i11;
        this.f17240c = gVar;
    }
}
