package com.hbg.lib.widgets.adapter.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import i6.d;
import java.util.ArrayList;
import java.util.List;
import s9.a;
import v9.b;

public class EasyAssetRecyclerView<T extends s9.a> extends RecyclerView {

    /* renamed from: b  reason: collision with root package name */
    public b<T> f71742b;

    /* renamed from: c  reason: collision with root package name */
    public a f71743c;

    public interface a {
        void onScrollChanged();
    }

    public EasyAssetRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        SimpleItemAnimator simpleItemAnimator;
        RecyclerView.ItemAnimator itemAnimator = getItemAnimator();
        if ((itemAnimator instanceof SimpleItemAnimator) && (simpleItemAnimator = (SimpleItemAnimator) itemAnimator) != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
    }

    public void b() {
        b<T> bVar = this.f71742b;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
            return;
        }
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public void c(int i11) {
        try {
            b<T> bVar = this.f71742b;
            if (bVar != null) {
                bVar.notifyItemChanged(i11);
                return;
            }
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(i11);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void d(int i11, Object obj) {
        try {
            b<T> bVar = this.f71742b;
            if (bVar != null) {
                bVar.notifyItemChanged(i11, obj);
                return;
            }
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(i11, obj);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void e(int i11, int i12) {
        try {
            b<T> bVar = this.f71742b;
            if (bVar != null) {
                bVar.notifyItemRangeInserted(i11, i12);
                this.f71742b.notifyItemRangeChanged(i11, getItemCount());
                return;
            }
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                adapter.notifyItemRangeInserted(i11, i12);
                adapter.notifyItemRangeChanged(i11, getItemCount());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void f(int i11, int i12) {
        try {
            b<T> bVar = this.f71742b;
            if (bVar != null) {
                bVar.notifyItemRangeRemoved(i11, i12);
                this.f71742b.notifyItemRangeChanged(i11, getItemCount());
                return;
            }
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                adapter.notifyItemRangeRemoved(i11, i12);
                adapter.notifyItemRangeChanged(i11, getItemCount());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public List<T> getDataList() {
        b<T> bVar = this.f71742b;
        if (bVar != null) {
            return bVar.c();
        }
        return null;
    }

    public int getItemCount() {
        b<T> bVar = this.f71742b;
        if (bVar != null) {
            return bVar.getItemCount();
        }
        return 0;
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
    }

    public void onScrollStateChanged(int i11) {
        a aVar;
        super.onScrollStateChanged(i11);
        d.b("EasyRecyclerView-->onScrollStateChanged-->" + i11);
        if (i11 == 1 && (aVar = this.f71743c) != null) {
            aVar.onScrollChanged();
        }
    }

    public void setCallback(a aVar) {
        this.f71743c = aVar;
    }

    public void setData(List<T> list) {
        if (getLayoutManager() == null) {
            setLayoutManager(new StableLinearLayoutManager(getContext()));
        }
        b<T> bVar = this.f71742b;
        if (bVar == null) {
            b<T> bVar2 = new b<>(list);
            this.f71742b = bVar2;
            setAdapter(bVar2);
            return;
        }
        bVar.h(list);
        this.f71742b.notifyDataSetChanged();
    }

    public void setDataRangeChanged(List<T> list) {
        if (getLayoutManager() == null) {
            setLayoutManager(new StableLinearLayoutManager(getContext()));
        }
        if (this.f71742b == null) {
            b<T> bVar = new b<>(list);
            this.f71742b = bVar;
            setAdapter(bVar);
        } else if (list.size() != getItemCount()) {
            this.f71742b.h(list);
            this.f71742b.notifyDataSetChanged();
        } else {
            this.f71742b.h(list);
            this.f71742b.notifyItemRangeChanged(0, getItemCount());
        }
    }

    public void setLoadingView(T t11) {
        if (getLayoutManager() == null) {
            setLayoutManager(new StableLinearLayoutManager(getContext()));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t11);
        b<T> bVar = this.f71742b;
        if (bVar == null) {
            b<T> bVar2 = new b<>(arrayList);
            this.f71742b = bVar2;
            setAdapter(bVar2);
            return;
        }
        bVar.h(arrayList);
        this.f71742b.notifyDataSetChanged();
    }

    public EasyAssetRecyclerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
