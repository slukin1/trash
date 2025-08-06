package com.hbg.module.community.multiadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public abstract class ItemViewBinder<T, VH extends RecyclerView.ViewHolder> extends ItemViewDelegate<T, VH> {

    /* renamed from: b  reason: collision with root package name */
    public String f17232b;

    /* renamed from: c  reason: collision with root package name */
    public String f17233c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f17234d;

    public static final class a<B extends f> extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public B f17235a;

        public a(B b11) {
            super(b11.getRoot());
            this.f17235a = b11;
        }

        public final B e() {
            return this.f17235a;
        }
    }

    public final VH d(Context context, ViewGroup viewGroup) {
        return m(LayoutInflater.from(context), viewGroup);
    }

    public final String j() {
        return this.f17232b;
    }

    public final String k() {
        return this.f17233c;
    }

    public final boolean l() {
        return this.f17234d;
    }

    public abstract VH m(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public final void n(boolean z11) {
        this.f17234d = z11;
    }

    public final void o(String str) {
        this.f17232b = str;
    }

    public final void p(String str) {
        this.f17233c = str;
    }
}
