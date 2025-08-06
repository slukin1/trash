package zendesk.support.guide;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import zendesk.support.guide.HelpRecyclerViewAdapter;

class SeparatorDecoration extends RecyclerView.ItemDecoration {
    private Drawable divider;

    public SeparatorDecoration(Drawable drawable) {
        this.divider = drawable;
    }

    private boolean isItemACategory(RecyclerView.ViewHolder viewHolder) {
        return viewHolder instanceof HelpRecyclerViewAdapter.CategoryViewHolder;
    }

    private boolean isItemAnExpandedCategory(RecyclerView.ViewHolder viewHolder) {
        return (viewHolder instanceof HelpRecyclerViewAdapter.CategoryViewHolder) && ((HelpRecyclerViewAdapter.CategoryViewHolder) viewHolder).isExpanded();
    }

    private boolean isItemAnUnexpandedCategory(RecyclerView.ViewHolder viewHolder) {
        return (viewHolder instanceof HelpRecyclerViewAdapter.CategoryViewHolder) && !((HelpRecyclerViewAdapter.CategoryViewHolder) viewHolder).isExpanded();
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        if (recyclerView.getItemAnimator() == null || !recyclerView.getItemAnimator().isRunning()) {
            int childCount = recyclerView.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = recyclerView.getChildAt(i11);
                if (shouldShowTopSeparator(recyclerView, i11)) {
                    int paddingLeft = recyclerView.getPaddingLeft();
                    int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                    int top = childAt.getTop() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).topMargin;
                    this.divider.setBounds(paddingLeft, top, width, this.divider.getIntrinsicHeight() + top);
                    this.divider.draw(canvas);
                }
            }
        }
    }

    public boolean shouldShowTopSeparator(RecyclerView recyclerView, int i11) {
        boolean isItemACategory = isItemACategory(recyclerView.getChildViewHolder(recyclerView.getChildAt(i11)));
        boolean isItemAnExpandedCategory = isItemAnExpandedCategory(recyclerView.getChildViewHolder(recyclerView.getChildAt(i11)));
        boolean z11 = i11 > 0 && isItemAnUnexpandedCategory(recyclerView.getChildViewHolder(recyclerView.getChildAt(i11 - 1)));
        if (!isItemACategory) {
            return false;
        }
        if (isItemAnExpandedCategory || !z11) {
            return true;
        }
        return false;
    }
}
