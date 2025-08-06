package com.huobi.c2c.lend.view;

import android.view.MotionEvent;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.huobi.c2c.lend.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import zs.b;

public class C2CLendTradeViewPager extends ViewPager implements a.m {

    /* renamed from: b  reason: collision with root package name */
    public b f42989b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentActivity f42990c;

    /* renamed from: d  reason: collision with root package name */
    public ni.a f42991d;

    /* renamed from: e  reason: collision with root package name */
    public final List<com.huobi.c2c.lend.a> f42992e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, com.huobi.c2c.lend.a> f42993f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public boolean f42994g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f42995h;

    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            int unused = C2CLendTradeViewPager.this.f42995h = i11;
            C2CLendTradeViewPager.this.f42991d.c(i11);
        }
    }

    public C2CLendTradeViewPager(FragmentActivity fragmentActivity, b bVar) {
        super(fragmentActivity);
        this.f42989b = bVar;
        this.f42990c = fragmentActivity;
        addOnPageChangeListener(new a());
    }

    public void c() {
        ni.a aVar = this.f42991d;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void d() {
        ni.a aVar = this.f42991d;
        if (aVar != null) {
            aVar.e(getCurrentItem());
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f42994g) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public b getUI() {
        return this.f42989b;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f42994g) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f42994g) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setIsTouching(boolean z11) {
        setPagingEnabled(!z11);
    }

    public void setList(List<String> list) {
        synchronized (this.f42992e) {
            this.f42992e.clear();
            for (String next : list) {
                com.huobi.c2c.lend.a aVar = this.f42993f.get(next);
                if (aVar == null) {
                    aVar = new com.huobi.c2c.lend.a(this.f42990c, next, this.f42989b, this);
                    this.f42993f.put(next, aVar);
                }
                this.f42992e.add(aVar);
            }
        }
        if (this.f42991d == null) {
            this.f42991d = new ni.a(this.f42992e);
        }
        setAdapter(this.f42991d);
        setCurrentItem(this.f42995h);
        this.f42991d.f(this.f42995h);
    }

    public void setPagingEnabled(boolean z11) {
        this.f42994g = z11;
    }
}
