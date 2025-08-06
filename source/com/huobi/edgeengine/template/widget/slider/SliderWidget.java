package com.huobi.edgeengine.template.widget.slider;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager2.widget.ViewPager2;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.edgeengine.template.widget.NodeSequenceWidget;
import java.lang.ref.WeakReference;
import java.util.Map;
import rj.n;
import yj.i;

public class SliderWidget extends NodeSequenceWidget {

    /* renamed from: k0  reason: collision with root package name */
    public String f44330k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f44331l0;

    /* renamed from: m0  reason: collision with root package name */
    public String f44332m0;

    /* renamed from: n0  reason: collision with root package name */
    public String f44333n0;

    /* renamed from: o0  reason: collision with root package name */
    public String f44334o0;

    /* renamed from: p0  reason: collision with root package name */
    public String f44335p0;

    /* renamed from: q0  reason: collision with root package name */
    public String f44336q0;

    /* renamed from: r0  reason: collision with root package name */
    public String f44337r0;

    /* renamed from: s0  reason: collision with root package name */
    public String f44338s0;

    /* renamed from: t0  reason: collision with root package name */
    public String f44339t0;

    /* renamed from: u0  reason: collision with root package name */
    public int f44340u0 = 0;

    public class a extends com.huobi.edgeengine.template.widget.b {
        public a(View view) {
            super(view);
        }

        public void b(View view, String str) {
            if (view instanceof RollPagerView) {
                try {
                    ((RollPagerView) view).setPlayDelay(Integer.parseInt(str) * 1000);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public class b extends com.huobi.edgeengine.template.widget.b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RollPagerView f44342b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view, RollPagerView rollPagerView) {
            super(view);
            this.f44342b = rollPagerView;
        }

        public void b(View view, String str) {
            try {
                this.f44342b.v("true".equals(str));
            } catch (Throwable unused) {
            }
        }
    }

    public class c extends com.huobi.edgeengine.template.widget.b {
        public c(View view) {
            super(view);
        }

        public void b(View view, String str) {
            if (view instanceof RollPagerView) {
                try {
                    if ("true".equals(str)) {
                        ((RollPagerView) view).setAutoPlay(true);
                        ((RollPagerView) view).t();
                        return;
                    }
                    ((RollPagerView) view).setAutoPlay(false);
                    ((RollPagerView) view).q();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public class d extends i<RollPagerView> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WeakReference f44345b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(RollPagerView rollPagerView, WeakReference weakReference) {
            super(rollPagerView);
            this.f44345b = weakReference;
        }

        /* renamed from: b */
        public void a(RollPagerView rollPagerView, Object obj) {
            int i11;
            if (obj != null) {
                try {
                    if (rollPagerView.getViewPager() == null) {
                        return;
                    }
                    if (this.f44345b.get() != null) {
                        int parseInt = Integer.parseInt(obj.toString());
                        int currentItem = rollPagerView.getViewPager().getCurrentItem();
                        int realCount = ((ck.b) this.f44345b.get()).getRealCount();
                        if (realCount == 0) {
                            i11 = currentItem;
                        } else {
                            i11 = currentItem % realCount;
                        }
                        if (realCount == 0) {
                            ((ck.b) this.f44345b.get()).f(parseInt);
                        } else if (i11 != parseInt) {
                            rollPagerView.u(currentItem + (parseInt - i11), false);
                        }
                    }
                } catch (Throwable th2) {
                    Log.e("EdgeEngine.Widget", "currentIndex error!", th2);
                }
            }
        }
    }

    public class e extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WeakReference f44347a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n.c f44348b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ n f44349c;

        public e(WeakReference weakReference, n.c cVar, n nVar) {
            this.f44347a = weakReference;
            this.f44348b = cVar;
            this.f44349c = nVar;
        }

        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            if (this.f44347a.get() != null) {
                if (SliderWidget.this.f44340u0 == i11) {
                    int unused = SliderWidget.this.f44340u0 = -1;
                    return;
                }
                int unused2 = SliderWidget.this.f44340u0 = -1;
                if (((ck.b) this.f44347a.get()).getRealCount() != 0) {
                    i11 %= ((ck.b) this.f44347a.get()).getRealCount();
                }
                n.c cVar = this.f44348b;
                if (cVar != null) {
                    cVar.a(Integer.valueOf(i11));
                }
                if (!TextUtils.isEmpty(SliderWidget.this.f44336q0)) {
                    boolean unused3 = SliderWidget.this.z(SliderWidget.this.f44336q0.replace("@eventParams", String.valueOf(i11)), this.f44349c);
                }
            }
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44330k0 = map.get("autoScroll");
        this.f44331l0 = map.get("autoStop");
        this.f44332m0 = map.get("swipeEnable");
        this.f44333n0 = map.get("showIndicator");
        this.f44334o0 = map.get("currentIndex");
        this.f44335p0 = map.get("scrollMode");
        this.f44337r0 = map.get("onScroll");
        this.f44336q0 = map.get("onSelected");
        this.f44339t0 = map.get("timeInterval");
        this.f44338s0 = map.get(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
    }

    /* renamed from: b0 */
    public ViewGroup Q(Context context, n nVar) {
        RollPagerView rollPagerView = (RollPagerView) super.Q(context, nVar);
        ck.b bVar = new ck.b(this.f44094j0, rollPagerView);
        w(context, this.f44339t0, new a(rollPagerView), nVar);
        if ("vertical".equals(this.f44338s0)) {
            rollPagerView.setOrientation(1);
        } else {
            rollPagerView.setOrientation(0);
        }
        if ("infinite".equals(this.f44335p0)) {
            rollPagerView.setScrollMode(true);
            bVar.g(true);
        }
        if ("true".equals(this.f44331l0)) {
            rollPagerView.setAutoStop(true);
        } else {
            rollPagerView.setAutoStop(false);
        }
        if (com.sumsub.sns.internal.core.analytics.d.f31895b.equals(this.f44332m0)) {
            rollPagerView.setSwipeEnabled(false);
        } else {
            rollPagerView.setSwipeEnabled(true);
        }
        rollPagerView.setAdapter(bVar);
        w(context, this.f44333n0, new b(rollPagerView, rollPagerView), nVar);
        w(context, this.f44330k0, new c(rollPagerView), nVar);
        WeakReference weakReference = new WeakReference(bVar);
        n.c cVar = null;
        if (!TextUtils.isEmpty(this.f44334o0)) {
            cVar = p(nVar, this.f44334o0, new d(rollPagerView, weakReference));
        }
        rollPagerView.l(new e(weakReference, cVar, nVar));
        return rollPagerView;
    }

    /* renamed from: h0 */
    public ViewGroup q(Context context) {
        return new RollPagerView(context);
    }
}
