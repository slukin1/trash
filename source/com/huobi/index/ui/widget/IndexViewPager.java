package com.huobi.index.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.huobi.index.ui.BaseRankingFragment;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class IndexViewPager extends ViewPager {

    /* renamed from: b  reason: collision with root package name */
    public int f74046b;

    /* renamed from: c  reason: collision with root package name */
    public int f74047c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, BaseRankingFragment> f74048d = new LinkedHashMap();

    /* renamed from: e  reason: collision with root package name */
    public Boolean f74049e;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f74050f;

    public IndexViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Boolean bool = Boolean.TRUE;
        this.f74049e = bool;
        this.f74050f = bool;
    }

    public void a(BaseRankingFragment baseRankingFragment, int i11) {
        this.f74048d.put(Integer.valueOf(i11), baseRankingFragment);
    }

    public boolean canScroll(View view, boolean z11, int i11, int i12, int i13) {
        return this.f74049e.booleanValue() ? super.canScroll(view, z11, i11, i12, i13) : this.f74049e.booleanValue();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void onMeasure(int i11, int i12) {
        BaseRankingFragment baseRankingFragment;
        if (this.f74050f.booleanValue()) {
            int size = this.f74048d.size();
            int i13 = this.f74046b;
            if (size > i13 && (baseRankingFragment = this.f74048d.get(Integer.valueOf(i13))) != null) {
                View rootView = baseRankingFragment.getRootView();
                int qh2 = baseRankingFragment.qh();
                if (rootView != null) {
                    rootView.measure(i11, View.MeasureSpec.makeMeasureSpec(0, 0));
                    int measuredHeight = rootView.getMeasuredHeight();
                    this.f74047c = measuredHeight;
                    this.f74047c = measuredHeight + qh2;
                }
            }
            if (this.f74048d.size() != 0) {
                i12 = View.MeasureSpec.makeMeasureSpec(this.f74047c, 1073741824);
            }
            setMeasuredDimension(i11, i12);
        }
        super.onMeasure(i11, i12);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void resetHeight(int i11) {
        this.f74046b = i11;
        if (this.f74048d.size() > i11) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, this.f74047c);
            } else {
                layoutParams.height = this.f74047c;
            }
            setLayoutParams(layoutParams);
        }
    }

    public void setCanScroll(boolean z11) {
        this.f74049e = Boolean.valueOf(z11);
    }

    public void setIsAutoHeight(Boolean bool) {
        this.f74050f = bool;
    }
}
