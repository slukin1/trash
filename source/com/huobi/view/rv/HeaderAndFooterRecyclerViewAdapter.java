package com.huobi.view.rv;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.hbg.lib.common.utils.ThreadUtils;
import java.util.Objects;

public class HeaderAndFooterRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int BASE_TYPE_HEADER_FOOTER = Integer.MIN_VALUE;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mInnerAdapter;
    private int mIntCurrentType = Integer.MIN_VALUE;
    private RecyclerView.AdapterDataObserver mOdsInnerAdapter = new RecyclerView.AdapterDataObserver() {
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
    };
    private SparseArray<View> mSpaAllView = new SparseArray<>();
    private SparseArray<View> mSpaFooter = new SparseArray<>();
    private SparseArray<View> mSpaHeader = new SparseArray<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public HeaderAndFooterRecyclerViewAdapter() {
    }

    private int getInnerAdapterItemCount() {
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.mInnerAdapter;
        if (adapter == null) {
            return 0;
        }
        return adapter.getItemCount();
    }

    public void addFooterView(View view) {
        this.mSpaFooter.put(addHeaderOrFooterView(view), view);
        notifyDataSetChanged();
    }

    public int addHeaderOrFooterView(View view) {
        if (ThreadUtils.a()) {
            Objects.requireNonNull(view);
            if (this.mSpaHeader.indexOfValue(view) == -1 && this.mSpaFooter.indexOfValue(view) == -1) {
                int indexOfValue = this.mSpaAllView.indexOfValue(view);
                if (indexOfValue != -1) {
                    return this.mSpaAllView.keyAt(indexOfValue);
                }
                int i11 = this.mIntCurrentType + 1;
                this.mIntCurrentType = i11;
                this.mSpaAllView.put(i11, view);
                return i11;
            }
            throw new IllegalArgumentException("already add this view");
        }
        throw new IllegalArgumentException("You must call this method on the main thread");
    }

    public void addHeaderView(View view) {
        this.mSpaHeader.put(addHeaderOrFooterView(view), view);
        notifyDataSetChanged();
    }

    public void clearAllFooterView() {
        int size = this.mSpaFooter.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mSpaAllView.removeAt(this.mSpaFooter.keyAt(i11));
        }
        this.mSpaFooter.clear();
        notifyDataSetChanged();
    }

    public void clearAllHeaderView() {
        int size = this.mSpaHeader.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mSpaAllView.remove(this.mSpaHeader.keyAt(i11));
        }
        this.mSpaHeader.clear();
        notifyDataSetChanged();
    }

    public View getFooterView(int i11) {
        return this.mSpaFooter.valueAt(i11);
    }

    public int getFooterViewsCount() {
        return this.mSpaFooter.size();
    }

    public View getHeaderView(int i11) {
        return this.mSpaHeader.valueAt(i11);
    }

    public int getHeaderViewsCount() {
        return this.mSpaHeader.size();
    }

    public RecyclerView.Adapter<RecyclerView.ViewHolder> getInnerAdapter() {
        return this.mInnerAdapter;
    }

    public int getItemCount() {
        return getHeaderViewsCount() + getFooterViewsCount() + getInnerAdapterItemCount();
    }

    public int getItemViewType(int i11) {
        int innerAdapterItemCount = getInnerAdapterItemCount();
        int headerViewsCount = getHeaderViewsCount();
        if (i11 < headerViewsCount) {
            return this.mSpaHeader.keyAt(i11);
        }
        if (i11 < headerViewsCount || i11 >= headerViewsCount + innerAdapterItemCount) {
            return this.mSpaFooter.keyAt((i11 - innerAdapterItemCount) - headerViewsCount);
        }
        int itemViewType = this.mInnerAdapter.getItemViewType(i11 - headerViewsCount);
        if (itemViewType >= 0) {
            return itemViewType;
        }
        throw new IllegalArgumentException("your adapter's return value of getViewTypeCount() must >= 0");
    }

    public boolean isAddHeaderOrFooterView(View view) {
        return (this.mSpaHeader.indexOfValue(view) == -1 && this.mSpaFooter.indexOfValue(view) == -1) ? false : true;
    }

    public boolean isFooterView(int i11) {
        return i11 >= 0 && i11 > getHeaderViewsCount() + getInnerAdapterItemCount();
    }

    public boolean isHeaderView(int i11) {
        return i11 >= 0 && i11 < getHeaderViewsCount();
    }

    public boolean isItemView(int i11) {
        int innerAdapterItemCount = getInnerAdapterItemCount();
        int headerViewsCount = getHeaderViewsCount();
        return i11 >= 0 && i11 >= headerViewsCount && i11 < headerViewsCount + innerAdapterItemCount;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        int headerViewsCount = getHeaderViewsCount();
        if (i11 < headerViewsCount || i11 >= getInnerAdapterItemCount() + headerViewsCount) {
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).c(true);
                return;
            }
            return;
        }
        this.mInnerAdapter.onBindViewHolder(viewHolder, i11 - headerViewsCount);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (i11 >= 0) {
            return this.mInnerAdapter.onCreateViewHolder(viewGroup, i11);
        }
        return new ViewHolder(this.mSpaAllView.get(i11));
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.mInnerAdapter;
        if (adapter != null) {
            adapter.onFailedToRecycleView(viewHolder);
        }
        return super.onFailedToRecycleView(viewHolder);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.mInnerAdapter;
        if (adapter != null) {
            adapter.onViewAttachedToWindow(viewHolder);
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.mInnerAdapter;
        if (adapter != null) {
            adapter.onViewDetachedFromWindow(viewHolder);
        }
    }

    public void removeFooterView(View view) {
        int indexOfValue = this.mSpaFooter.indexOfValue(view);
        int indexOfValue2 = this.mSpaAllView.indexOfValue(view);
        if (indexOfValue != -1 && indexOfValue2 != -1) {
            this.mSpaFooter.removeAt(indexOfValue);
            this.mSpaAllView.removeAt(indexOfValue2);
            notifyDataSetChanged();
        }
    }

    public void removeHeaderView(View view) {
        int indexOfValue = this.mSpaHeader.indexOfValue(view);
        int indexOfValue2 = this.mSpaAllView.indexOfValue(view);
        if (indexOfValue != -1 && indexOfValue2 != -1) {
            this.mSpaHeader.removeAt(indexOfValue);
            this.mSpaAllView.removeAt(indexOfValue2);
            notifyDataSetChanged();
        }
    }

    public void setInnerAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        if (this.mInnerAdapter != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), this.mInnerAdapter.getItemCount());
            this.mInnerAdapter.unregisterAdapterDataObserver(this.mOdsInnerAdapter);
        }
        this.mInnerAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mOdsInnerAdapter);
            notifyItemRangeInserted(getHeaderViewsCount(), this.mInnerAdapter.getItemCount());
        }
    }

    public void removeFooterView(int i11) {
        this.mSpaFooter.removeAt(i11);
        notifyDataSetChanged();
    }

    public void removeHeaderView(int i11) {
        this.mSpaHeader.removeAt(i11);
        notifyDataSetChanged();
    }

    public HeaderAndFooterRecyclerViewAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        setInnerAdapter(adapter);
    }
}
