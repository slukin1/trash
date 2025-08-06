package com.hbg.module.community.multiadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.R$id;

public abstract class ViewDelegate<T, V extends View> extends ItemViewDelegate<T, a<V>> {

    public static final class a<V extends View> extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final V f17243a;

        public a(V v11) {
            super(v11);
            this.f17243a = v11;
        }

        public final V e() {
            return this.f17243a;
        }
    }

    public abstract void j(V v11, T t11, boolean z11, int i11);

    public void k(a<V> aVar, V v11, T t11, boolean z11, int i11) {
        v11.setTag(R$id.h_tagViewHolder, aVar);
        j(v11, t11, z11, i11);
    }

    /* renamed from: l */
    public void c(a<V> aVar, T t11, boolean z11, int i11) {
        k(aVar, aVar.e(), t11, z11, i11);
    }

    public abstract V m(Context context);

    public V n(Context context, ViewGroup viewGroup) {
        return m(context);
    }

    /* renamed from: o */
    public a<V> d(Context context, ViewGroup viewGroup) {
        return new a<>(n(context, viewGroup));
    }
}
