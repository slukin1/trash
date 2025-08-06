package com.hbg.lib.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.VibrateManager;
import com.hbg.lib.core.R$dimen;
import com.hbg.lib.core.R$styleable;
import i6.t;
import java.util.ArrayList;
import java.util.List;
import k6.b;
import k6.c;
import u6.q;

public class TradeTrendView extends LinearLayout implements t.a {

    /* renamed from: b  reason: collision with root package name */
    public ViewTreeObserver.OnPreDrawListener f68619b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c> f68620c;

    /* renamed from: d  reason: collision with root package name */
    public k6.b f68621d;

    /* renamed from: e  reason: collision with root package name */
    public int f68622e;

    /* renamed from: f  reason: collision with root package name */
    public int f68623f;

    /* renamed from: g  reason: collision with root package name */
    public final List<c> f68624g;

    /* renamed from: h  reason: collision with root package name */
    public final List<k6.a> f68625h;

    /* renamed from: i  reason: collision with root package name */
    public List<? extends c.a> f68626i;

    /* renamed from: j  reason: collision with root package name */
    public List<? extends c.a> f68627j;

    /* renamed from: k  reason: collision with root package name */
    public b f68628k;

    /* renamed from: l  reason: collision with root package name */
    public t f68629l;

    /* renamed from: m  reason: collision with root package name */
    public long f68630m;

    /* renamed from: n  reason: collision with root package name */
    public int f68631n;

    /* renamed from: o  reason: collision with root package name */
    public int f68632o;

    /* renamed from: p  reason: collision with root package name */
    public int f68633p;

    /* renamed from: q  reason: collision with root package name */
    public int f68634q;

    /* renamed from: r  reason: collision with root package name */
    public NewestPriceItemView f68635r;

    /* renamed from: s  reason: collision with root package name */
    public int f68636s;

    /* renamed from: t  reason: collision with root package name */
    public c6.b<c> f68637t;

    /* renamed from: u  reason: collision with root package name */
    public b.C0742b f68638u;

    public class a implements b.C0742b {
        public a() {
        }

        public void a(k6.b bVar) {
            if (TradeTrendView.this.f68628k != null) {
                TradeTrendView.this.f68628k.c(bVar.c());
            }
        }

        public void b(k6.b bVar) {
            if (TradeTrendView.this.f68628k != null) {
                TradeTrendView.this.f68628k.b(bVar.c());
            }
        }
    }

    public interface b {
        void a(c.a aVar);

        void b(b.a aVar);

        void c(b.a aVar);
    }

    public TradeTrendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(c cVar) {
        b bVar = this.f68628k;
        if (bVar != null) {
            bVar.a(cVar.c());
        }
        VibrateManager.a(this);
    }

    public void c(int i11) {
        this.f68631n = i11;
        ArrayList arrayList = new ArrayList();
        if (i11 == 1) {
            arrayList.add(this.f68621d);
            arrayList.addAll(this.f68624g);
        } else if (i11 == 2) {
            arrayList.addAll(this.f68620c);
            arrayList.add(this.f68621d);
        } else {
            for (int size = this.f68620c.size() - this.f68622e; size < this.f68620c.size(); size++) {
                arrayList.add(this.f68620c.get(size));
            }
            arrayList.add(this.f68621d);
            for (int i12 = 0; i12 < this.f68622e; i12++) {
                arrayList.add(this.f68624g.get(i12));
            }
        }
        this.f68625h.clear();
        this.f68625h.addAll(arrayList);
        setSellList(this.f68627j);
        setBuyList(this.f68626i);
        k();
    }

    public int d() {
        return Math.min((getHeight() - getNewestPriceItemViewHeight()) / getItemHeight(), 20);
    }

    public void e(Context context) {
        setOrientation(1);
        this.f68629l = new t(this);
        f();
        k();
        c(0);
    }

    public void f() {
        for (int i11 = 0; i11 < this.f68623f; i11++) {
            this.f68620c.add(new c(this.f68637t));
        }
        this.f68625h.addAll(this.f68620c);
        k6.b bVar = new k6.b(this.f68638u);
        this.f68621d = bVar;
        this.f68625h.add(bVar);
        for (int i12 = 0; i12 < this.f68623f; i12++) {
            this.f68624g.add(new c(this.f68637t));
        }
        this.f68625h.addAll(this.f68624g);
    }

    public void g() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt instanceof NewestPriceItemView) {
                ((NewestPriceItemView) childAt).f();
            } else if (childAt instanceof TradeTrendItemView) {
                ((TradeTrendItemView) childAt).i();
            }
        }
    }

    public TextView getIndexPriceView() {
        NewestPriceItemView newestPriceItemView = this.f68635r;
        if (newestPriceItemView != null) {
            return newestPriceItemView.getIndexTv();
        }
        return null;
    }

    public int getItemHeight() {
        return this.f68632o;
    }

    public NewestPriceItemView getNewestPriceItemView() {
        return this.f68635r;
    }

    public int getNewestPriceItemViewHeight() {
        int i11;
        NewestPriceItemView newestPriceItemView = this.f68635r;
        if (newestPriceItemView == null) {
            return 0;
        }
        if (newestPriceItemView.getHeight() > 0) {
            i11 = this.f68635r.getHeight();
        } else {
            i11 = this.f68636s;
            if (i11 <= 0) {
                i11 = PixelUtils.a(42.0f);
            }
        }
        this.f68636s = i11;
        return i11;
    }

    public void handleMessage(Message message) {
        this.f68630m = System.currentTimeMillis();
        g();
    }

    public void i() {
        t tVar = this.f68629l;
        if (tVar == null) {
            return;
        }
        if (tVar.hasMessages(1)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f68630m > 200) {
                this.f68630m = currentTimeMillis;
                this.f68629l.removeMessages(1);
                this.f68629l.sendEmptyMessage(1);
                return;
            }
            return;
        }
        this.f68629l.sendEmptyMessageDelayed(1, 250);
    }

    public final void j() {
        this.f68620c.clear();
        for (int i11 = 0; i11 < this.f68623f; i11++) {
            this.f68620c.add(new c(this.f68637t));
        }
        this.f68624g.clear();
        for (int i12 = 0; i12 < this.f68623f; i12++) {
            this.f68624g.add(new c(this.f68637t));
        }
        c(this.f68631n);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k() {
        /*
            r9 = this;
            r9.removeAllViews()
            java.util.List<k6.a> r0 = r9.f68625h
            int r0 = r0.size()
            r1 = 0
            r2 = 1
            if (r0 <= r2) goto L_0x002c
            java.util.List<k6.a> r0 = r9.f68625h
            java.lang.Object r0 = r0.get(r1)
            boolean r0 = r0 instanceof k6.b
            if (r0 == 0) goto L_0x001a
            r0 = r1
            r3 = r2
            goto L_0x002e
        L_0x001a:
            java.util.List<k6.a> r0 = r9.f68625h
            int r3 = r0.size()
            int r3 = r3 - r2
            java.lang.Object r0 = r0.get(r3)
            boolean r0 = r0 instanceof k6.b
            if (r0 == 0) goto L_0x002c
            r3 = r1
            r0 = r2
            goto L_0x002e
        L_0x002c:
            r0 = r2
            r3 = r0
        L_0x002e:
            android.widget.Space r4 = new android.widget.Space
            android.content.Context r5 = r9.getContext()
            r4.<init>(r5)
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            float r0 = (float) r0
            r6 = -1
            r5.<init>(r6, r1, r0)
            r9.addView(r4, r5)
            java.util.List<k6.a> r0 = r9.f68625h
            java.util.Iterator r0 = r0.iterator()
        L_0x0047:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x00df
            java.lang.Object r4 = r0.next()
            k6.a r4 = (k6.a) r4
            boolean r5 = r4 instanceof k6.b
            if (r5 == 0) goto L_0x00b7
            android.widget.Space r5 = new android.widget.Space
            android.content.Context r7 = r9.getContext()
            r5.<init>(r7)
            android.widget.LinearLayout$LayoutParams r7 = new android.widget.LinearLayout$LayoutParams
            float r8 = (float) r2
            r7.<init>(r6, r1, r8)
            r9.addView(r5, r7)
            com.hbg.lib.core.ui.NewestPriceItemView r5 = r9.f68635r
            if (r5 == 0) goto L_0x007a
            android.view.ViewTreeObserver$OnPreDrawListener r7 = r9.f68619b
            if (r7 == 0) goto L_0x007a
            android.view.ViewTreeObserver r5 = r5.getViewTreeObserver()
            android.view.ViewTreeObserver$OnPreDrawListener r7 = r9.f68619b
            r5.removeOnPreDrawListener(r7)
        L_0x007a:
            com.hbg.lib.core.ui.NewestPriceItemView r5 = new com.hbg.lib.core.ui.NewestPriceItemView
            android.content.Context r7 = r9.getContext()
            r5.<init>(r7)
            r9.f68635r = r5
            android.view.ViewTreeObserver$OnPreDrawListener r7 = r9.f68619b
            if (r7 == 0) goto L_0x0092
            android.view.ViewTreeObserver r5 = r5.getViewTreeObserver()
            android.view.ViewTreeObserver$OnPreDrawListener r7 = r9.f68619b
            r5.addOnPreDrawListener(r7)
        L_0x0092:
            com.hbg.lib.core.ui.NewestPriceItemView r5 = r9.f68635r
            k6.b r4 = (k6.b) r4
            r5.g(r4)
            com.hbg.lib.core.ui.NewestPriceItemView r4 = r9.f68635r
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            r7 = -2
            r5.<init>(r6, r7)
            r9.addView(r4, r5)
            android.widget.Space r4 = new android.widget.Space
            android.content.Context r5 = r9.getContext()
            r4.<init>(r5)
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            float r7 = (float) r2
            r5.<init>(r6, r1, r7)
            r9.addView(r4, r5)
            goto L_0x0047
        L_0x00b7:
            com.hbg.lib.core.ui.TradeTrendItemView r5 = new com.hbg.lib.core.ui.TradeTrendItemView
            android.content.Context r7 = r9.getContext()
            r5.<init>(r7)
            int r7 = r9.f68634q
            if (r7 == 0) goto L_0x00c7
            r5.setIndexColor(r7)
        L_0x00c7:
            int r7 = r9.f68633p
            if (r7 == 0) goto L_0x00ce
            r5.setAmountColor(r7)
        L_0x00ce:
            k6.c r4 = (k6.c) r4
            r5.j(r4)
            android.widget.LinearLayout$LayoutParams r4 = new android.widget.LinearLayout$LayoutParams
            int r7 = r9.f68632o
            r4.<init>(r6, r7)
            r9.addView(r5, r4)
            goto L_0x0047
        L_0x00df:
            android.widget.Space r0 = new android.widget.Space
            android.content.Context r2 = r9.getContext()
            r0.<init>(r2)
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            float r3 = (float) r3
            r2.<init>(r6, r1, r3)
            r9.addView(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.core.ui.TradeTrendView.k():void");
    }

    public void l(int i11, int i12) {
        boolean z11;
        boolean z12 = true;
        if (i11 != this.f68622e) {
            this.f68622e = i11;
            z11 = true;
        } else {
            z11 = false;
        }
        if (i12 != this.f68623f) {
            this.f68623f = i12;
        } else {
            z12 = z11;
        }
        if (z12) {
            j();
        }
    }

    public void m(int i11) {
        if (i11 != this.f68632o) {
            this.f68632o = i11;
            k();
        }
    }

    public void setBuyList(List<? extends c.a> list) {
        if (list != null) {
            this.f68626i = list;
            for (int i11 = 0; i11 < this.f68624g.size(); i11++) {
                if (i11 < list.size()) {
                    this.f68624g.get(i11).e((c.a) list.get(i11));
                }
            }
        }
    }

    public void setCallback(b bVar) {
        this.f68628k = bVar;
    }

    public void setNewestPrice(b.a aVar) {
        k6.b bVar = this.f68621d;
        if (bVar != null) {
            bVar.e(aVar);
            NewestPriceItemView newestPriceItemView = this.f68635r;
            if (newestPriceItemView != null) {
                newestPriceItemView.g(this.f68621d);
            }
        }
    }

    public void setNewestPriceItemViewPreDrawListener(ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        NewestPriceItemView newestPriceItemView = this.f68635r;
        if (newestPriceItemView != null) {
            if (this.f68619b != null) {
                newestPriceItemView.getViewTreeObserver().removeOnPreDrawListener(this.f68619b);
            }
            this.f68635r.getViewTreeObserver().addOnPreDrawListener(onPreDrawListener);
        }
        this.f68619b = onPreDrawListener;
    }

    public void setSellList(List<? extends c.a> list) {
        if (list != null) {
            this.f68627j = list;
            for (int i11 = 0; i11 < this.f68620c.size(); i11++) {
                List<c> list2 = this.f68620c;
                c cVar = list2.get((list2.size() - 1) - i11);
                if (i11 < list.size()) {
                    cVar.e((c.a) list.get(i11));
                }
            }
        }
    }

    public TradeTrendView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f68620c = new ArrayList();
        this.f68622e = 5;
        this.f68623f = 10;
        this.f68624g = new ArrayList();
        this.f68625h = new ArrayList();
        this.f68631n = 0;
        this.f68636s = PixelUtils.a(42.0f);
        this.f68637t = new q(this);
        this.f68638u = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TradeTrendView, i11, 0);
        this.f68632o = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.TradeTrendView_trade_item_height, getResources().getDimensionPixelOffset(R$dimen.dimen_21));
        this.f68633p = obtainStyledAttributes.getColor(R$styleable.TradeTrendView_trade_item_amount_color, 0);
        this.f68634q = obtainStyledAttributes.getColor(R$styleable.TradeTrendView_trade_item_index_color, 0);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        e(context);
    }
}
