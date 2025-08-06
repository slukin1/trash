package com.huobi.homemarket.ui;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.hbg.lib.common.utils.ThreadUtils;
import java.util.Objects;
import v9.c;

public class HeaderAndFooterRecyclerViewAdapter extends RecyclerView.Adapter<c> {

    /* renamed from: a  reason: collision with root package name */
    public int f72864a = Integer.MIN_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f72865b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<View> f72866c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<View> f72867d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter<c> f72868e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f72869f = new a();

    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        public void onChanged() {
            super.onChanged();
            HeaderAndFooterRecyclerViewAdapter.this.notifyDataSetChanged();
        }

        public void onItemRangeChanged(int i11, int i12) {
            super.onItemRangeChanged(i11, i12);
            HeaderAndFooterRecyclerViewAdapter headerAndFooterRecyclerViewAdapter = HeaderAndFooterRecyclerViewAdapter.this;
            headerAndFooterRecyclerViewAdapter.notifyItemRangeChanged(i11 + headerAndFooterRecyclerViewAdapter.getHeaderViewsCount(), i12);
        }

        public void onItemRangeInserted(int i11, int i12) {
            super.onItemRangeInserted(i11, i12);
            HeaderAndFooterRecyclerViewAdapter headerAndFooterRecyclerViewAdapter = HeaderAndFooterRecyclerViewAdapter.this;
            headerAndFooterRecyclerViewAdapter.notifyItemRangeInserted(i11 + headerAndFooterRecyclerViewAdapter.getHeaderViewsCount(), i12);
        }

        public void onItemRangeMoved(int i11, int i12, int i13) {
            super.onItemRangeMoved(i11, i12, i13);
            int headerViewsCount = HeaderAndFooterRecyclerViewAdapter.this.getHeaderViewsCount();
            HeaderAndFooterRecyclerViewAdapter.this.notifyItemRangeChanged(i11 + headerViewsCount, i12 + headerViewsCount + i13);
        }

        public void onItemRangeRemoved(int i11, int i12) {
            super.onItemRangeRemoved(i11, i12);
            HeaderAndFooterRecyclerViewAdapter headerAndFooterRecyclerViewAdapter = HeaderAndFooterRecyclerViewAdapter.this;
            headerAndFooterRecyclerViewAdapter.notifyItemRangeRemoved(i11 + headerAndFooterRecyclerViewAdapter.getHeaderViewsCount(), i12);
        }
    }

    public static class b extends c {
        public b(View view) {
            super(view);
        }
    }

    public HeaderAndFooterRecyclerViewAdapter() {
    }

    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i11) {
        int headerViewsCount = getHeaderViewsCount();
        if (i11 < headerViewsCount || i11 >= getInnerAdapterItemCount() + headerViewsCount) {
            ViewGroup.LayoutParams layoutParams = cVar.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).c(true);
                return;
            }
            return;
        }
        this.f72868e.onBindViewHolder(cVar, i11 - headerViewsCount);
    }

    public int addHeaderOrFooterView(View view) {
        if (ThreadUtils.a()) {
            Objects.requireNonNull(view);
            if (this.f72866c.indexOfValue(view) == -1 && this.f72867d.indexOfValue(view) == -1) {
                int indexOfValue = this.f72865b.indexOfValue(view);
                if (indexOfValue != -1) {
                    return this.f72865b.keyAt(indexOfValue);
                }
                int i11 = this.f72864a + 1;
                this.f72864a = i11;
                this.f72865b.put(i11, view);
                return i11;
            }
            throw new IllegalArgumentException("already add this view");
        }
        throw new IllegalArgumentException("You must call this method on the main thread");
    }

    public void addHeaderView(View view) {
        this.f72866c.put(addHeaderOrFooterView(view), view);
        notifyDataSetChanged();
    }

    /* renamed from: c */
    public c onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (i11 >= 0) {
            return this.f72868e.onCreateViewHolder(viewGroup, i11);
        }
        return new b(this.f72865b.get(i11));
    }

    /* renamed from: d */
    public boolean onFailedToRecycleView(c cVar) {
        RecyclerView.Adapter<c> adapter = this.f72868e;
        if (adapter != null) {
            adapter.onFailedToRecycleView(cVar);
        }
        return super.onFailedToRecycleView(cVar);
    }

    /* renamed from: e */
    public void onViewAttachedToWindow(c cVar) {
        super.onViewAttachedToWindow(cVar);
        RecyclerView.Adapter<c> adapter = this.f72868e;
        if (adapter != null) {
            adapter.onViewAttachedToWindow(cVar);
        }
    }

    /* renamed from: f */
    public void onViewDetachedFromWindow(c cVar) {
        super.onViewDetachedFromWindow(cVar);
        RecyclerView.Adapter<c> adapter = this.f72868e;
        if (adapter != null) {
            adapter.onViewDetachedFromWindow(cVar);
        }
    }

    public int getFooterViewsCount() {
        return this.f72867d.size();
    }

    public int getHeaderViewsCount() {
        return this.f72866c.size();
    }

    public final int getInnerAdapterItemCount() {
        RecyclerView.Adapter<c> adapter = this.f72868e;
        if (adapter == null) {
            return 0;
        }
        return adapter.getItemCount();
    }

    public int getItemCount() {
        return getHeaderViewsCount() + getFooterViewsCount() + getInnerAdapterItemCount();
    }

    public int getItemViewType(int i11) {
        int innerAdapterItemCount = getInnerAdapterItemCount();
        int headerViewsCount = getHeaderViewsCount();
        if (i11 < headerViewsCount) {
            return this.f72866c.keyAt(i11);
        }
        if (i11 < headerViewsCount || i11 >= headerViewsCount + innerAdapterItemCount) {
            return this.f72867d.keyAt((i11 - innerAdapterItemCount) - headerViewsCount);
        }
        int itemViewType = this.f72868e.getItemViewType(i11 - headerViewsCount);
        if (itemViewType >= 0) {
            return itemViewType;
        }
        throw new IllegalArgumentException("your adapter's return value of getViewTypeCount() must >= 0");
    }

    public void setInnerAdapter(RecyclerView.Adapter<c> adapter) {
        if (this.f72868e != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), this.f72868e.getItemCount());
            this.f72868e.unregisterAdapterDataObserver(this.f72869f);
        }
        this.f72868e = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f72869f);
            notifyItemRangeInserted(getHeaderViewsCount(), this.f72868e.getItemCount());
        }
    }

    public HeaderAndFooterRecyclerViewAdapter(RecyclerView.Adapter<c> adapter) {
        setInnerAdapter(adapter);
    }
}
