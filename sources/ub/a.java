package ub;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f84898a;

    /* renamed from: b  reason: collision with root package name */
    public int f84899b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f84900c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f84901d;

    public a(Context context, int i11, int i12, boolean z11) {
        this.f84898a = ContextCompat.getDrawable(context, i11);
        this.f84899b = i12;
        this.f84900c = z11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildAdapterPosition(view) != 0 || !this.f84901d) {
            rect.set(0, 0, 0, this.f84899b);
            return;
        }
        int i11 = this.f84899b;
        rect.set(0, i11, 0, i11);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition;
        if (recyclerView.getAdapter() != null) {
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            int itemCount = recyclerView.getAdapter().getItemCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = recyclerView.getChildAt(i11);
                if (this.f84900c || !((childAdapterPosition = recyclerView.getChildAdapterPosition(childAt)) == -1 || childAdapterPosition == itemCount - 1)) {
                    int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                    this.f84898a.setBounds(paddingLeft, bottom, width, this.f84899b + bottom);
                    this.f84898a.draw(canvas);
                }
            }
        }
    }

    public a(Context context, int i11, int i12) {
        this(context, i11, i12, true);
    }
}
