package ub;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class b extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f84902a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f84903b;

    /* renamed from: c  reason: collision with root package name */
    public int f84904c;

    /* renamed from: d  reason: collision with root package name */
    public int f84905d;

    public b(Drawable drawable, Drawable drawable2, int i11, int i12) {
        this.f84902a = drawable2;
        this.f84903b = drawable;
        this.f84905d = i12;
        this.f84904c = i11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.set(0, 0, 0, this.f84904c);
        } else {
            rect.set(0, 0, 0, this.f84905d);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (!(childAdapterPosition == -1 || childAdapterPosition == itemCount - 1)) {
                if (childAdapterPosition == 0) {
                    int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                    this.f84903b.setBounds(paddingLeft, bottom, width, this.f84904c + bottom);
                    this.f84903b.draw(canvas);
                } else {
                    int bottom2 = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                    this.f84902a.setBounds(paddingLeft, bottom2, width, this.f84905d + bottom2);
                    this.f84902a.draw(canvas);
                }
            }
        }
    }
}
