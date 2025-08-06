package com.sumsub.sns.core.presentation.base.adapter;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.sumsub.sns.core.presentation.base.adapter.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.x;

public abstract class a<T, VH extends b<T>> extends RecyclerView.Adapter<VH> {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<T> f30897a = new ArrayList<>();

    /* renamed from: com.sumsub.sns.core.presentation.base.adapter.a$a  reason: collision with other inner class name */
    public static final class C0288a<T> extends DiffUtil.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final List<T> f30898a;

        /* renamed from: b  reason: collision with root package name */
        public final List<T> f30899b;

        public C0288a(List<? extends T> list, List<? extends T> list2) {
            this.f30898a = list;
            this.f30899b = list2;
        }

        public boolean areContentsTheSame(int i11, int i12) {
            return x.b(this.f30898a.get(i11), this.f30899b.get(i12));
        }

        public boolean areItemsTheSame(int i11, int i12) {
            return x.b(this.f30898a.get(i11), this.f30899b.get(i12));
        }

        public int getNewListSize() {
            return this.f30899b.size();
        }

        public int getOldListSize() {
            return this.f30898a.size();
        }
    }

    public DiffUtil.Callback a(List<? extends T> list, List<? extends T> list2) {
        return new C0288a(list, list2);
    }

    public int getItemCount() {
        return this.f30897a.size();
    }

    public void a(List<? extends T> list) {
        DiffUtil.d b11 = DiffUtil.b(a(this.f30897a, list));
        this.f30897a.clear();
        this.f30897a.addAll(list);
        b11.c(this);
    }

    public final T a(int i11) {
        return this.f30897a.get(i11);
    }
}
