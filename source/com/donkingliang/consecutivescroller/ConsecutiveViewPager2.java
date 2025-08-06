package com.donkingliang.consecutivescroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ConsecutiveViewPager2 extends FrameLayout implements n4.a {

    /* renamed from: b  reason: collision with root package name */
    public ViewPager2 f64931b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f64932c;

    /* renamed from: d  reason: collision with root package name */
    public int f64933d;

    public static class a implements View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<ConsecutiveViewPager2> f64934b;

        /* renamed from: c  reason: collision with root package name */
        public View f64935c;

        public a(ConsecutiveViewPager2 consecutiveViewPager2, View view) {
            this.f64934b = new WeakReference<>(consecutiveViewPager2);
            this.f64935c = view;
        }

        public void onViewAttachedToWindow(View view) {
            if (this.f64934b.get() != null) {
                ((ConsecutiveViewPager2) this.f64934b.get()).e(this.f64935c);
            }
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public ConsecutiveViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    private void setAttachListener(View view) {
        if (view.getTag(-123) != null) {
            a aVar = (a) view.getTag(-123);
            if (aVar.f64934b.get() == null) {
                view.removeOnAttachStateChangeListener(aVar);
                view.setTag(-123, (Object) null);
            }
        }
        if (view.getTag(-123) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if ((layoutParams instanceof ConsecutiveScrollerLayout.LayoutParams) && ((ConsecutiveScrollerLayout.LayoutParams) layoutParams).f64920a) {
                a aVar2 = new a(this, view);
                view.addOnAttachStateChangeListener(aVar2);
                view.setTag(-123, aVar2);
            }
        }
    }

    public View b(View view) {
        if (!(this.f64932c.getAdapter() instanceof FragmentStateAdapter) || !(view instanceof FrameLayout)) {
            return view;
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return frameLayout.getChildCount() > 0 ? frameLayout.getChildAt(0) : view;
    }

    public final void c(Context context) {
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.f64931b = viewPager2;
        addView(viewPager2, -1, -1);
        this.f64932c = (RecyclerView) this.f64931b.getChildAt(0);
    }

    public boolean canScrollHorizontally(int i11) {
        return this.f64931b.canScrollHorizontally(i11);
    }

    public boolean canScrollVertically(int i11) {
        return this.f64931b.canScrollVertically(i11);
    }

    public final boolean d() {
        ViewParent parent = getParent();
        if (!(parent instanceof ConsecutiveScrollerLayout)) {
            return false;
        }
        ConsecutiveScrollerLayout consecutiveScrollerLayout = (ConsecutiveScrollerLayout) parent;
        if (consecutiveScrollerLayout.indexOfChild(this) == consecutiveScrollerLayout.getChildCount() - 1) {
            return true;
        }
        return false;
    }

    public final void e(View view) {
        View m11;
        if (view != null && (getParent() instanceof ConsecutiveScrollerLayout)) {
            ConsecutiveScrollerLayout consecutiveScrollerLayout = (ConsecutiveScrollerLayout) getParent();
            int indexOfChild = consecutiveScrollerLayout.indexOfChild(this);
            if ((indexOfChild != consecutiveScrollerLayout.getChildCount() - 1 || getHeight() >= consecutiveScrollerLayout.getHeight() || consecutiveScrollerLayout.getScrollY() < consecutiveScrollerLayout.f64896c) && (m11 = consecutiveScrollerLayout.m()) != null) {
                int indexOfChild2 = consecutiveScrollerLayout.indexOfChild(m11);
                if (indexOfChild < indexOfChild2) {
                    consecutiveScrollerLayout.U(view);
                } else if (indexOfChild > indexOfChild2) {
                    consecutiveScrollerLayout.V(view);
                }
            }
        }
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f64931b.getAdapter();
    }

    public int getAdjustHeight() {
        return this.f64933d;
    }

    public int getCurrentItem() {
        return this.f64931b.getCurrentItem();
    }

    public View getCurrentScrollerView() {
        View view;
        int currentItem = getCurrentItem();
        RecyclerView.Adapter adapter = this.f64932c.getAdapter();
        RecyclerView.LayoutManager layoutManager = this.f64932c.getLayoutManager();
        if (adapter == null || layoutManager == null || currentItem < 0 || currentItem >= adapter.getItemCount()) {
            view = null;
        } else {
            view = b(layoutManager.findViewByPosition(currentItem));
            if (view != null) {
                setAttachListener(view);
            }
        }
        return view == null ? this.f64932c : view;
    }

    public int getOffscreenPageLimit() {
        return this.f64931b.getOffscreenPageLimit();
    }

    public int getOrientation() {
        return this.f64931b.getOrientation();
    }

    public List<View> getScrolledViews() {
        ArrayList arrayList = new ArrayList();
        int childCount = this.f64932c.getChildCount();
        if (childCount > 0) {
            for (int i11 = 0; i11 < childCount; i11++) {
                arrayList.add(b(this.f64932c.getChildAt(i11)));
            }
        }
        return arrayList;
    }

    public ViewPager2 getViewPager2() {
        return this.f64931b;
    }

    public void onMeasure(int i11, int i12) {
        if (!d() || this.f64933d <= 0) {
            super.onMeasure(i11, i12);
        } else {
            super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(FrameLayout.getDefaultSize(0, i12) - this.f64933d, View.MeasureSpec.getMode(i12)));
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.f64931b.setAdapter(adapter);
    }

    public void setAdjustHeight(int i11) {
        if (this.f64933d != i11) {
            this.f64933d = i11;
            requestLayout();
        }
    }

    public void setCurrentItem(int i11) {
        this.f64931b.setCurrentItem(i11);
    }

    public void setOffscreenPageLimit(int i11) {
        this.f64931b.setOffscreenPageLimit(i11);
    }

    public void setOrientation(int i11) {
        this.f64931b.setOrientation(i11);
    }

    public ConsecutiveViewPager2(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(context);
    }
}
