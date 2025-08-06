package com.huobi.edgeengine.template.widget.slider;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.huobi.edgeengine.R$drawable;
import com.huobi.edgeengine.util.Utils;
import com.huobi.edgeengine.util.ViewUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class RollPagerView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public ViewPager2 f44309b;

    /* renamed from: c  reason: collision with root package name */
    public ck.b f44310c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<TabLayout> f44311d;

    /* renamed from: e  reason: collision with root package name */
    public long f44312e;

    /* renamed from: f  reason: collision with root package name */
    public int f44313f;

    /* renamed from: g  reason: collision with root package name */
    public Timer f44314g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44315h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f44316i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f44317j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f44318k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f44319l;

    /* renamed from: m  reason: collision with root package name */
    public int f44320m;

    /* renamed from: n  reason: collision with root package name */
    public int f44321n;

    /* renamed from: o  reason: collision with root package name */
    public e f44322o;

    public class a extends ViewPager2.OnPageChangeCallback {
        public a() {
        }

        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            RollPagerView.this.s(i11);
        }
    }

    public class b extends RecyclerView.AdapterDataObserver {
        public b() {
        }

        public void onChanged() {
            RollPagerView.this.r();
        }

        public void onItemRangeChanged(int i11, int i12) {
            RollPagerView.this.r();
        }

        public void onItemRangeInserted(int i11, int i12) {
            RollPagerView.this.r();
        }

        public void onItemRangeMoved(int i11, int i12, int i13) {
            RollPagerView.this.r();
        }

        public void onItemRangeRemoved(int i11, int i12) {
            RollPagerView.this.r();
        }

        public void onItemRangeChanged(int i11, int i12, Object obj) {
            RollPagerView.this.r();
        }
    }

    public class c implements TabLayout.OnTabSelectedListener {
        public c() {
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        @SensorsDataInstrumented
        public void onTabSelected(TabLayout.Tab tab) {
            ((ImageView) tab.getCustomView()).setImageResource(R$drawable.slider_view_indicator_selected);
            SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            ((ImageView) tab.getCustomView()).setImageResource(R$drawable.slider_view_indicator_unselected);
        }
    }

    public class d extends ViewPager2.OnPageChangeCallback {
        public d() {
        }

        public void onPageSelected(int i11) {
            TabLayout tabLayout = (TabLayout) RollPagerView.this.f44311d.get();
            if (tabLayout != null) {
                int realCount = RollPagerView.this.f44310c.getRealCount();
                if (realCount != 0) {
                    i11 %= realCount;
                }
                tabLayout.selectTab(tabLayout.getTabAt(i11));
            }
        }
    }

    public static final class e extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<RollPagerView> f44327a;

        public e(RollPagerView rollPagerView) {
            this.f44327a = new WeakReference<>(rollPagerView);
        }

        public void handleMessage(Message message) {
            RollPagerView rollPagerView = (RollPagerView) this.f44327a.get();
            int currentItem = rollPagerView.getViewPager().getCurrentItem() + 1;
            if (rollPagerView.f44318k && currentItem >= rollPagerView.f44310c.getItemCount()) {
                rollPagerView.x();
            } else if (!rollPagerView.f44317j) {
                currentItem %= rollPagerView.f44320m;
            } else if (currentItem >= rollPagerView.f44310c.getItemCount()) {
                currentItem = 0;
            }
            rollPagerView.getViewPager().setCurrentItem(currentItem);
            if (rollPagerView.f44320m <= 1) {
                rollPagerView.x();
            }
        }
    }

    public static class f extends TimerTask {

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<RollPagerView> f44328b;

        public f(RollPagerView rollPagerView) {
            this.f44328b = new WeakReference<>(rollPagerView);
        }

        public void run() {
            RollPagerView rollPagerView = (RollPagerView) this.f44328b.get();
            if (rollPagerView == null) {
                cancel();
            } else if (rollPagerView.isShown() && System.currentTimeMillis() - rollPagerView.f44312e > ((long) rollPagerView.f44313f)) {
                rollPagerView.f44322o.sendEmptyMessage(0);
            }
        }
    }

    public RollPagerView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p() {
        requestLayout();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            this.f44312e = System.currentTimeMillis();
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e11) {
            e11.printStackTrace();
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public ViewPager2 getViewPager() {
        return this.f44309b;
    }

    public void l(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f44309b.registerOnPageChangeCallback(onPageChangeCallback);
    }

    public final int m(float f11) {
        return (int) ((f11 * ((float) ViewUtils.a(getContext()))) / 375.0f);
    }

    public final void n(AttributeSet attributeSet) {
        ViewPager2 viewPager2 = this.f44309b;
        if (viewPager2 != null) {
            removeView(viewPager2);
        }
        ViewPager2 viewPager22 = new ViewPager2(getContext());
        this.f44309b = viewPager22;
        viewPager22.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f44309b);
        ScrollSpeedManger.a(this.f44309b);
        this.f44309b.registerOnPageChangeCallback(new a());
    }

    public final boolean o() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        return layoutParams.height == -2 || layoutParams.width == -2;
    }

    public void onMeasure(int i11, int i12) {
        ViewPager2 viewPager2;
        View findViewByPosition;
        if (o() && (viewPager2 = this.f44309b) != null && (viewPager2.getChildAt(0) instanceof RecyclerView) && (findViewByPosition = ((RecyclerView) this.f44309b.getChildAt(0)).getLayoutManager().findViewByPosition(this.f44321n)) != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams.width == -2) {
                i11 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            if (layoutParams.height == -2) {
                i12 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            findViewByPosition.measure(i11, i12);
            if (layoutParams.width == -2) {
                i11 = View.MeasureSpec.makeMeasureSpec(findViewByPosition.getMeasuredWidth(), 1073741824);
            }
            if (layoutParams.height == -2) {
                i12 = View.MeasureSpec.makeMeasureSpec(findViewByPosition.getMeasuredHeight(), 1073741824);
            }
        }
        super.onMeasure(i11, i12);
    }

    public void q() {
        x();
    }

    public final void r() {
        TabLayout tabLayout = (TabLayout) this.f44311d.get();
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
            int m11 = m(3.0f);
            int m12 = m(6.0f);
            ck.b bVar = this.f44310c;
            if (bVar != null) {
                int realCount = bVar.getRealCount();
                for (int i11 = 0; i11 < realCount; i11++) {
                    TabLayout.Tab newTab = tabLayout.newTab();
                    if (newTab != null) {
                        ImageView imageView = new ImageView(getContext());
                        imageView.setImageResource(R$drawable.slider_view_indicator_unselected);
                        imageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                        newTab.view.setPadding(m11, 0, m11, 0);
                        newTab.view.setMinimumWidth(m12);
                        newTab.setCustomView((View) imageView);
                    }
                    tabLayout.addTab(newTab, false);
                }
                if (realCount > 0) {
                    int tabCount = tabLayout.getTabCount() - 1;
                    int currentItem = this.f44309b.getCurrentItem();
                    if (realCount != 0) {
                        currentItem %= realCount;
                    }
                    int min = Math.min(currentItem, tabCount);
                    if (min != tabLayout.getSelectedTabPosition()) {
                        tabLayout.selectTab(tabLayout.getTabAt(min));
                    }
                }
            }
        }
    }

    public void s(int i11) {
        if (o()) {
            this.f44321n = i11;
            post(new bk.a(this));
        }
    }

    public void setAdapter(ck.b bVar) {
        this.f44309b.setAdapter(bVar);
        this.f44310c = bVar;
        s(0);
    }

    public void setAutoPlay(boolean z11) {
        this.f44316i = z11;
        if (z11) {
            w();
        }
    }

    public void setAutoStop(boolean z11) {
        this.f44318k = z11;
    }

    public void setDataSize(int i11) {
        this.f44320m = i11;
        if (i11 <= 1) {
            x();
        } else {
            w();
        }
    }

    public void setOrientation(int i11) {
        ViewPager2 viewPager2 = this.f44309b;
        if (viewPager2 != null) {
            viewPager2.setOrientation(i11);
        }
    }

    public void setPlayDelay(int i11) {
        this.f44313f = i11;
    }

    public void setScrollMode(boolean z11) {
        this.f44317j = z11;
    }

    public void setSwipeEnabled(boolean z11) {
        this.f44309b.setUserInputEnabled(z11);
    }

    public void t() {
        w();
    }

    public void u(int i11, boolean z11) {
        x();
        this.f44309b.setCurrentItem(i11, z11);
        w();
    }

    public void v(boolean z11) {
        if (z11) {
            TabLayout tabLayout = new TabLayout(getContext());
            this.f44311d = new WeakReference<>(tabLayout);
            tabLayout.setSelectedTabIndicatorHeight(0);
            tabLayout.setTabMode(0);
            this.f44310c.registerAdapterDataObserver(new b());
            tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new c());
            this.f44309b.registerOnPageChangeCallback(new d());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, Utils.a(getContext(), 3.0f));
            layoutParams.gravity = 83;
            layoutParams.leftMargin = m(14.0f);
            layoutParams.bottomMargin = m(8.0f);
            addView(tabLayout, layoutParams);
            r();
        }
    }

    public final void w() {
        if (this.f44316i && this.f44313f > 0 && this.f44310c != null && this.f44320m > 1) {
            Timer timer = this.f44314g;
            if (timer != null) {
                timer.cancel();
            }
            Timer timer2 = new Timer();
            this.f44314g = timer2;
            f fVar = new f(this);
            int i11 = this.f44313f;
            timer2.schedule(fVar, (long) i11, (long) i11);
        }
    }

    public final void x() {
        Timer timer = this.f44314g;
        if (timer != null) {
            timer.cancel();
            this.f44314g = null;
        }
    }

    public RollPagerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RollPagerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f44313f = 3000;
        this.f44315h = true;
        this.f44316i = true;
        this.f44317j = false;
        this.f44318k = false;
        this.f44319l = true;
        this.f44320m = 0;
        this.f44322o = new e(this);
        n(attributeSet);
    }
}
