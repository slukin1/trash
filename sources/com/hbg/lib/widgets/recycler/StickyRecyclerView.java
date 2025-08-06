package com.hbg.lib.widgets.recycler;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.hbg.lib.widgets.recycler.CommonRecyclerView;
import java.util.List;
import ka.a;

public class StickyRecyclerView<I extends ka.a> extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public CommonRecyclerView<I> f72296b;

    /* renamed from: c  reason: collision with root package name */
    public StableLinearLayoutManager f72297c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<RecyclerView.ViewHolder> f72298d;

    /* renamed from: e  reason: collision with root package name */
    public int f72299e;

    public class a extends StableLinearLayoutManager {
        public a(Context context) {
            super(context);
        }

        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            super.onLayoutChildren(recycler, state);
            StickyRecyclerView.this.e();
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            StickyRecyclerView.this.e();
        }
    }

    public StickyRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void c(Context context) {
        d(context);
    }

    public final void d(Context context) {
        this.f72297c = new a(context);
        AnonymousClass2 r02 = new CommonRecyclerView<I>(context) {
            public RecyclerView.LayoutManager g(Context context) {
                return StickyRecyclerView.this.f72297c;
            }
        };
        this.f72296b = r02;
        r02.addOnScrollListener(new b());
    }

    public final void e() {
        View view;
        ja.a adapter = this.f72296b.getAdapter();
        StableLinearLayoutManager stableLinearLayoutManager = this.f72297c;
        if (stableLinearLayoutManager != null && adapter != null) {
            int findFirstVisibleItemPosition = stableLinearLayoutManager.findFirstVisibleItemPosition();
            ka.a e11 = this.f72296b.e(findFirstVisibleItemPosition);
            if (this.f72299e != findFirstVisibleItemPosition) {
                for (int i11 = 0; i11 < this.f72298d.size(); i11++) {
                    RecyclerView.ViewHolder valueAt = this.f72298d.valueAt(i11);
                    if (!(valueAt == null || (view = valueAt.itemView) == null)) {
                        view.setVisibility(8);
                    }
                }
                if (e11 == null || !e11.isSticky()) {
                    this.f72299e = -1;
                    return;
                }
                int resId = e11.getResId();
                RecyclerView.ViewHolder viewHolder = this.f72298d.get(resId);
                if (viewHolder == null && (viewHolder = adapter.createViewHolder(this, resId)) != null) {
                    addView(viewHolder.itemView);
                    this.f72298d.put(resId, viewHolder);
                }
                if (viewHolder != null) {
                    viewHolder.itemView.setVisibility(0);
                    adapter.bindViewHolder(viewHolder, findFirstVisibleItemPosition);
                }
                this.f72299e = findFirstVisibleItemPosition;
            }
        }
    }

    public void setCallback(CommonRecyclerView.Callback callback) {
        this.f72296b.setCallback(callback);
    }

    public void setData(List<I> list) {
        this.f72296b.setData(list);
    }

    public StickyRecyclerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f72298d = new SparseArray<>();
        this.f72299e = -1;
        c(context);
    }
}
