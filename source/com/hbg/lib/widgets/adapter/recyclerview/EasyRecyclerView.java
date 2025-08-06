package com.hbg.lib.widgets.adapter.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import i6.d;
import java.util.List;
import s9.a;

public class EasyRecyclerView<T extends s9.a> extends RecyclerView {

    /* renamed from: b  reason: collision with root package name */
    public v9.a<T> f71744b;

    /* renamed from: c  reason: collision with root package name */
    public a f71745c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71746d;

    public interface a {
        void onScrollChanged();
    }

    public EasyRecyclerView(Context context) {
        super(context);
        b(context);
    }

    public int a(T t11) {
        v9.a<T> aVar = this.f71744b;
        if (aVar != null) {
            return aVar.e(t11);
        }
        return -1;
    }

    public final void b(Context context) {
    }

    public void c() {
        v9.a<T> aVar = this.f71744b;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
            return;
        }
        v9.a adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public void d(int i11) {
        try {
            v9.a<T> aVar = this.f71744b;
            if (aVar != null) {
                aVar.notifyItemChanged(i11);
                return;
            }
            v9.a adapter = getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(i11);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void e(List<T> list) {
        if (getLayoutManager() == null) {
            setLayoutManager(new StableLinearLayoutManager(getContext()));
        }
        v9.a<T> aVar = this.f71744b;
        if (aVar == null) {
            v9.a<T> aVar2 = new v9.a<>(list);
            this.f71744b = aVar2;
            setAdapter(aVar2);
            return;
        }
        aVar.i(list);
        v9.a<T> aVar3 = this.f71744b;
        aVar3.notifyItemRangeChanged(0, aVar3.getItemCount());
    }

    public void f(boolean z11) {
        this.f71746d = z11;
    }

    public List<T> getDataList() {
        v9.a<T> aVar = this.f71744b;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    public int getItemCount() {
        v9.a<T> aVar = this.f71744b;
        if (aVar != null) {
            return aVar.getItemCount();
        }
        return 0;
    }

    public void onMeasure(int i11, int i12) {
        if (this.f71746d) {
            setMeasuredDimension(i11, i12);
        }
        super.onMeasure(i11, i12);
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
    }

    public void onScrollStateChanged(int i11) {
        a aVar;
        super.onScrollStateChanged(i11);
        d.b("EasyRecyclerView-->onScrollStateChanged-->" + i11);
        if (i11 == 1 && (aVar = this.f71745c) != null) {
            aVar.onScrollChanged();
        }
    }

    public void setCallback(a aVar) {
        this.f71745c = aVar;
    }

    public void setData(List<T> list) {
        if (getLayoutManager() == null) {
            setLayoutManager(new StableLinearLayoutManager(getContext()));
        }
        v9.a<T> aVar = this.f71744b;
        if (aVar == null) {
            v9.a<T> aVar2 = new v9.a<>(list);
            this.f71744b = aVar2;
            setAdapter(aVar2);
            return;
        }
        aVar.i(list);
        this.f71744b.notifyDataSetChanged();
    }

    public v9.a getAdapter() {
        return this.f71744b;
    }

    public EasyRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public EasyRecyclerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(context);
    }
}
