package com.hbg.lib.widgets;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.hbg.lib.common.utils.Assert;
import i6.d;

public class AutoPlayViewPager extends ViewPager {

    /* renamed from: b  reason: collision with root package name */
    public boolean f70983b;

    /* renamed from: c  reason: collision with root package name */
    public int f70984c = 5000;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f70985d = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            a adapter = AutoPlayViewPager.this.getAdapter();
            if (adapter != null && AutoPlayViewPager.this.f70983b) {
                int currentItem = AutoPlayViewPager.this.getCurrentItem() + 1;
                if (currentItem < adapter.getCount()) {
                    AutoPlayViewPager.this.setCurrentItem(currentItem, true);
                } else {
                    AutoPlayViewPager.this.setCurrentItem(0, false);
                }
                AutoPlayViewPager autoPlayViewPager = AutoPlayViewPager.this;
                autoPlayViewPager.postDelayed(autoPlayViewPager.f70985d, (long) AutoPlayViewPager.this.f70984c);
            }
        }
    }

    public AutoPlayViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void d() {
        if (!this.f70983b) {
            removeCallbacks(this.f70985d);
            this.f70983b = true;
            postDelayed(this.f70985d, (long) this.f70984c);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    d();
                } else if (action != 7) {
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            e();
        } catch (Exception e11) {
            d.d(e11.getMessage());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e() {
        this.f70983b = false;
        removeCallbacks(this.f70985d);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        if (getLayoutParams() == null || getLayoutParams().height <= 0) {
            int i15 = 0;
            for (int i16 = 0; i16 < getChildCount(); i16++) {
                View childAt = getChildAt(i16);
                if (childAt.getLayoutParams() == null || childAt.getLayoutParams().height <= 0) {
                    childAt.measure(i11, View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, Integer.MIN_VALUE));
                    i14 = childAt.getMeasuredHeight();
                } else {
                    i14 = childAt.getLayoutParams().height;
                }
                if (i14 > i15) {
                    i15 = i14;
                }
            }
            i13 = i15;
        } else {
            i13 = getLayoutParams().height;
        }
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(i13, 1073741824));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f70984c = bundle.getInt("auto_play_time");
            parcelable = bundle.getParcelable("parent");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("parent", super.onSaveInstanceState());
        bundle.putInt("auto_play_time", this.f70984c);
        return bundle;
    }

    public void setAdapter(a aVar) {
        setAdapter((PagerAdapter) aVar);
    }

    public a getAdapter() {
        return (a) super.getAdapter();
    }

    @Deprecated
    public void setAdapter(PagerAdapter pagerAdapter) {
        Assert.b(pagerAdapter instanceof a, "Adapter类型错误");
        super.setAdapter(pagerAdapter);
        setCurrentItem(((a) pagerAdapter).c());
        d();
    }
}
