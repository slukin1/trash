package com.tencent.qcloud.tuikit.timcommon.component.swipe;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.qcloud.tuikit.timcommon.component.swipe.Attributes;
import java.util.List;

public abstract class RecyclerSwipeAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements SwipeItemMangerInterface, SwipeAdapterInterface {
    public SwipeItemMangerImpl mItemManger = new SwipeItemMangerImpl(this);

    public void closeAllExcept(SwipeLayout swipeLayout) {
        this.mItemManger.closeAllExcept(swipeLayout);
    }

    public void closeAllSwipeItems() {
        this.mItemManger.closeAllSwipeItems();
    }

    public void closeItem(int i11) {
        this.mItemManger.closeItem(i11);
    }

    public Attributes.Mode getMode() {
        return this.mItemManger.getMode();
    }

    public List<Integer> getOpenItems() {
        return this.mItemManger.getOpenItems();
    }

    public List<SwipeLayout> getOpenLayouts() {
        return this.mItemManger.getOpenLayouts();
    }

    public boolean isOpen(int i11) {
        return this.mItemManger.isOpen(i11);
    }

    public void notifyDatasetChanged() {
        super.notifyDataSetChanged();
    }

    public void notifySwipeItemChanged(int i11) {
        super.notifyItemChanged(i11);
    }

    public abstract void onBindViewHolder(VH vh2, int i11);

    public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i11);

    public void openItem(int i11) {
        this.mItemManger.openItem(i11);
    }

    public void removeShownLayouts(SwipeLayout swipeLayout) {
        this.mItemManger.removeShownLayouts(swipeLayout);
    }

    public void setMode(Attributes.Mode mode) {
        this.mItemManger.setMode(mode);
    }

    public void setSwipeEnabled(boolean z11) {
        this.mItemManger.setSwipeEnabled(z11);
    }

    public void switchAllSwipeEnable(boolean z11) {
        this.mItemManger.switchAllSwipeEnable(z11);
    }
}
