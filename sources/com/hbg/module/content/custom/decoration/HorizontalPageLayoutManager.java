package com.hbg.module.content.custom.decoration;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalPageLayoutManager extends RecyclerView.LayoutManager {

    /* renamed from: a  reason: collision with root package name */
    public int f18088a;

    /* renamed from: b  reason: collision with root package name */
    public int f18089b;

    /* renamed from: c  reason: collision with root package name */
    public int f18090c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Rect> f18091d;

    /* renamed from: e  reason: collision with root package name */
    public int f18092e;

    /* renamed from: f  reason: collision with root package name */
    public int f18093f;

    /* renamed from: g  reason: collision with root package name */
    public int f18094g;

    /* renamed from: h  reason: collision with root package name */
    public int f18095h;

    /* renamed from: i  reason: collision with root package name */
    public int f18096i;

    /* renamed from: j  reason: collision with root package name */
    public int f18097j;

    /* renamed from: k  reason: collision with root package name */
    public int f18098k;

    /* renamed from: l  reason: collision with root package name */
    public int f18099l;

    public final void a(RecyclerView.State state) {
        this.f18094g = (state.b() / this.f18097j) + (state.b() % this.f18097j == 0 ? 0 : 1);
    }

    public final int b() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public final int c() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public boolean canScrollHorizontally() {
        return true;
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return getWidth();
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.f18090c;
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        a(state);
        return this.f18094g * getWidth();
    }

    public final void d(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!state.e()) {
            Rect rect = new Rect(getPaddingLeft() + this.f18090c, getPaddingTop(), ((getWidth() - getPaddingLeft()) - getPaddingRight()) + this.f18090c, (getHeight() - getPaddingTop()) - getPaddingBottom());
            Rect rect2 = new Rect();
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                rect2.left = getDecoratedLeft(childAt);
                rect2.top = getDecoratedTop(childAt);
                rect2.right = getDecoratedRight(childAt);
                rect2.bottom = getDecoratedBottom(childAt);
                if (!Rect.intersects(rect, rect2)) {
                    removeAndRecycleView(childAt, recycler);
                }
            }
            for (int i12 = 0; i12 < getItemCount(); i12++) {
                if (Rect.intersects(rect, this.f18091d.get(i12))) {
                    View o11 = recycler.o(i12);
                    addView(o11);
                    measureChildWithMargins(o11, this.f18098k, this.f18099l);
                    Rect rect3 = this.f18091d.get(i12);
                    int i13 = rect3.left;
                    int i14 = this.f18090c;
                    layoutDecorated(o11, i13 - i14, rect3.top, rect3.right - i14, rect3.bottom);
                }
            }
        }
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return null;
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        this.f18090c = 0;
        this.f18089b = 0;
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
        } else if (!state.e()) {
            this.f18095h = c() / this.f18093f;
            int b11 = b();
            int i11 = this.f18092e;
            int i12 = b11 / i11;
            this.f18096i = i12;
            this.f18098k = (this.f18093f - 1) * this.f18095h;
            this.f18099l = (i11 - 1) * i12;
            a(state);
            Log.i("zzz", "itemCount=" + getItemCount() + " state itemCount=" + state.b() + " pageSize=" + this.f18094g);
            this.f18088a = (this.f18094g + -1) * getWidth();
            detachAndScrapAttachedViews(recycler);
            int itemCount = getItemCount();
            int i13 = 0;
            while (i13 < this.f18094g) {
                int i14 = 0;
                while (i14 < this.f18092e) {
                    int i15 = 0;
                    while (true) {
                        int i16 = this.f18093f;
                        if (i15 >= i16) {
                            break;
                        }
                        int i17 = (this.f18097j * i13) + (i16 * i14) + i15;
                        if (i17 == itemCount) {
                            i14 = this.f18092e;
                            i13 = this.f18094g;
                            break;
                        }
                        View o11 = recycler.o(i17);
                        addView(o11);
                        measureChildWithMargins(o11, this.f18098k, this.f18099l);
                        int decoratedMeasuredWidth = getDecoratedMeasuredWidth(o11);
                        int decoratedMeasuredHeight = getDecoratedMeasuredHeight(o11);
                        Rect rect = this.f18091d.get(i17);
                        if (rect == null) {
                            rect = new Rect();
                        }
                        int c11 = (c() * i13) + (this.f18095h * i15);
                        int i18 = this.f18096i * i14;
                        rect.set(c11, i18, decoratedMeasuredWidth + c11, decoratedMeasuredHeight + i18);
                        this.f18091d.put(i17, rect);
                        i15++;
                    }
                    i14++;
                }
                removeAndRecycleAllViews(recycler);
                i13++;
            }
            d(recycler, state);
        }
    }

    public int scrollHorizontallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int i12 = this.f18090c;
        int i13 = i12 + i11;
        int i14 = this.f18088a;
        if (i13 > i14) {
            i11 = i14 - i12;
        } else if (i13 < 0) {
            i11 = 0 - i12;
        }
        this.f18090c = i12 + i11;
        offsetChildrenHorizontal(-i11);
        d(recycler, state);
        return i11;
    }
}
