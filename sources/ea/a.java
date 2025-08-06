package ea;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class a extends RecyclerView.ItemDecoration {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f76154d = {16843284};

    /* renamed from: a  reason: collision with root package name */
    public Drawable f76155a;

    /* renamed from: b  reason: collision with root package name */
    public int f76156b;

    /* renamed from: c  reason: collision with root package name */
    public int f76157c;

    public a(Context context, int i11) {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.f76155a = colorDrawable;
        if (i11 != -1) {
            this.f76156b = i11;
            this.f76157c = i11;
            return;
        }
        this.f76156b = colorDrawable.getIntrinsicWidth();
        this.f76157c = this.f76155a.getIntrinsicHeight();
    }

    public void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int bottom = childAt.getBottom() + layoutParams.bottomMargin;
            this.f76155a.setBounds(childAt.getLeft() - layoutParams.leftMargin, bottom, childAt.getRight() + layoutParams.rightMargin + this.f76156b, this.f76157c + bottom);
            this.f76155a.draw(canvas);
        }
    }

    public void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int top = childAt.getTop() - layoutParams.topMargin;
            int bottom = childAt.getBottom() + layoutParams.bottomMargin;
            int right = childAt.getRight() + layoutParams.rightMargin;
            this.f76155a.setBounds(right, top, this.f76156b + right, bottom);
            this.f76155a.draw(canvas);
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        int spanCount = getSpanCount(recyclerView);
        int itemCount = recyclerView.getAdapter().getItemCount();
        float f11 = (float) (this.f76157c / spanCount);
        int i11 = viewLayoutPosition % spanCount;
        boolean z11 = false;
        rect.set((int) (((float) i11) * f11), 0, (int) (((float) ((spanCount - 1) - i11)) * f11), 0);
        if (((itemCount - 1) / spanCount) + 1 == (viewLayoutPosition / spanCount) + 1) {
            z11 = true;
        }
        if (!z11) {
            rect.bottom = this.f76156b;
        }
    }

    public final int getSpanCount(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).k();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).D();
        }
        return -1;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        drawHorizontal(canvas, recyclerView);
        drawVertical(canvas, recyclerView);
    }

    public a(Context context, int i11, int i12) {
        this.f76155a = new ColorDrawable(0);
        this.f76156b = i11;
        this.f76157c = i12;
    }
}
