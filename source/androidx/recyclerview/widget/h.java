package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class h extends RecyclerView.ItemDecoration {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f10850d = {16843284};

    /* renamed from: a  reason: collision with root package name */
    public Drawable f10851a;

    /* renamed from: b  reason: collision with root package name */
    public int f10852b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f10853c = new Rect();

    @SuppressLint({"UnknownNullness"})
    public h(Context context, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f10850d);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.f10851a = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        setOrientation(i11);
    }

    public final void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int i11;
        int i12;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i12 = recyclerView.getPaddingTop();
            i11 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i12, recyclerView.getWidth() - recyclerView.getPaddingRight(), i11);
        } else {
            i11 = recyclerView.getHeight();
            i12 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = recyclerView.getChildAt(i13);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.f10853c);
            int round = this.f10853c.right + Math.round(childAt.getTranslationX());
            this.f10851a.setBounds(round - this.f10851a.getIntrinsicWidth(), i12, round, i11);
            this.f10851a.draw(canvas);
        }
        canvas.restore();
    }

    public final void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int i11;
        int i12;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i12 = recyclerView.getPaddingLeft();
            i11 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i12, recyclerView.getPaddingTop(), i11, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i11 = recyclerView.getWidth();
            i12 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = recyclerView.getChildAt(i13);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.f10853c);
            int round = this.f10853c.bottom + Math.round(childAt.getTranslationY());
            this.f10851a.setBounds(i12, round - this.f10851a.getIntrinsicHeight(), i11, round);
            this.f10851a.draw(canvas);
        }
        canvas.restore();
    }

    @SuppressLint({"UnknownNullness"})
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Drawable drawable = this.f10851a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f10852b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getLayoutManager() != null && this.f10851a != null) {
            if (this.f10852b == 1) {
                drawVertical(canvas, recyclerView);
            } else {
                drawHorizontal(canvas, recyclerView);
            }
        }
    }

    public void setDrawable(Drawable drawable) {
        if (drawable != null) {
            this.f10851a = drawable;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void setOrientation(int i11) {
        if (i11 == 0 || i11 == 1) {
            this.f10852b = i11;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }
}
