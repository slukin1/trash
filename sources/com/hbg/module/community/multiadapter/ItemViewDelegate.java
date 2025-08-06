package com.hbg.module.community.multiadapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

public abstract class ItemViewDelegate<T, VH extends RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public MultiTypeAdapter f17236a;

    public long a(T t11) {
        return -1;
    }

    public void b(VH vh2, T t11, List<? extends Object> list, boolean z11, int i11) {
        c(vh2, t11, z11, i11);
    }

    public abstract void c(VH vh2, T t11, boolean z11, int i11);

    public abstract VH d(Context context, ViewGroup viewGroup);

    public boolean e(VH vh2) {
        return false;
    }

    public void f(VH vh2) {
    }

    public void g(VH vh2) {
    }

    public void h(VH vh2) {
    }

    public final void i(MultiTypeAdapter multiTypeAdapter) {
        this.f17236a = multiTypeAdapter;
    }
}
