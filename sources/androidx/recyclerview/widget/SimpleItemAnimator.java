package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    public boolean mSupportsChangeAnimations = true;

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateAdd(RecyclerView.ViewHolder viewHolder);

    public boolean animateAppearance(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i11;
        int i12;
        if (itemHolderInfo == null || ((i11 = itemHolderInfo.f10688a) == (i12 = itemHolderInfo2.f10688a) && itemHolderInfo.f10689b == itemHolderInfo2.f10689b)) {
            return animateAdd(viewHolder);
        }
        return animateMove(viewHolder, i11, itemHolderInfo.f10689b, i12, itemHolderInfo2.f10689b);
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i11, int i12, int i13, int i14);

    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i11;
        int i12;
        int i13 = itemHolderInfo.f10688a;
        int i14 = itemHolderInfo.f10689b;
        if (viewHolder2.shouldIgnore()) {
            int i15 = itemHolderInfo.f10688a;
            i11 = itemHolderInfo.f10689b;
            i12 = i15;
        } else {
            i12 = itemHolderInfo2.f10688a;
            i11 = itemHolderInfo2.f10689b;
        }
        return animateChange(viewHolder, viewHolder2, i13, i14, i12, i11);
    }

    public boolean animateDisappearance(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i11 = itemHolderInfo.f10688a;
        int i12 = itemHolderInfo.f10689b;
        View view = viewHolder.itemView;
        int left = itemHolderInfo2 == null ? view.getLeft() : itemHolderInfo2.f10688a;
        int top = itemHolderInfo2 == null ? view.getTop() : itemHolderInfo2.f10689b;
        if (viewHolder.isRemoved() || (i11 == left && i12 == top)) {
            return animateRemove(viewHolder);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return animateMove(viewHolder, i11, i12, left, top);
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateMove(RecyclerView.ViewHolder viewHolder, int i11, int i12, int i13, int i14);

    public boolean animatePersistence(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i11 = itemHolderInfo.f10688a;
        int i12 = itemHolderInfo2.f10688a;
        if (i11 == i12 && itemHolderInfo.f10689b == itemHolderInfo2.f10689b) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        return animateMove(viewHolder, i11, itemHolderInfo.f10689b, i12, itemHolderInfo2.f10689b);
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateRemove(RecyclerView.ViewHolder viewHolder);

    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder) {
        return !this.mSupportsChangeAnimations || viewHolder.isInvalid();
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchAddFinished(RecyclerView.ViewHolder viewHolder) {
        onAddFinished(viewHolder);
        dispatchAnimationFinished(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchAddStarting(RecyclerView.ViewHolder viewHolder) {
        onAddStarting(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchChangeFinished(RecyclerView.ViewHolder viewHolder, boolean z11) {
        onChangeFinished(viewHolder, z11);
        dispatchAnimationFinished(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchChangeStarting(RecyclerView.ViewHolder viewHolder, boolean z11) {
        onChangeStarting(viewHolder, z11);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchMoveFinished(RecyclerView.ViewHolder viewHolder) {
        onMoveFinished(viewHolder);
        dispatchAnimationFinished(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchMoveStarting(RecyclerView.ViewHolder viewHolder) {
        onMoveStarting(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchRemoveFinished(RecyclerView.ViewHolder viewHolder) {
        onRemoveFinished(viewHolder);
        dispatchAnimationFinished(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchRemoveStarting(RecyclerView.ViewHolder viewHolder) {
        onRemoveStarting(viewHolder);
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    @SuppressLint({"UnknownNullness"})
    public void onAddFinished(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onAddStarting(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onChangeFinished(RecyclerView.ViewHolder viewHolder, boolean z11) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onChangeStarting(RecyclerView.ViewHolder viewHolder, boolean z11) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onMoveFinished(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onMoveStarting(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
    }

    public void setSupportsChangeAnimations(boolean z11) {
        this.mSupportsChangeAnimations = z11;
    }
}
