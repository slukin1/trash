package com.hbg.lib.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.VibrateManager;
import com.hbg.lib.core.R$dimen;
import com.hbg.lib.core.R$styleable;
import com.hbg.lib.core.ui.TradeTrendView;
import i6.t;
import java.util.ArrayList;
import java.util.List;
import k6.b;
import k6.c;
import u6.r;

public class TradeTrendViewNew extends LinearLayout implements t.a {

    /* renamed from: b  reason: collision with root package name */
    public final List<c> f68640b;

    /* renamed from: c  reason: collision with root package name */
    public b f68641c;

    /* renamed from: d  reason: collision with root package name */
    public int f68642d;

    /* renamed from: e  reason: collision with root package name */
    public int f68643e;

    /* renamed from: f  reason: collision with root package name */
    public int f68644f;

    /* renamed from: g  reason: collision with root package name */
    public final int f68645g;

    /* renamed from: h  reason: collision with root package name */
    public final List<c> f68646h;

    /* renamed from: i  reason: collision with root package name */
    public final List<k6.a> f68647i;

    /* renamed from: j  reason: collision with root package name */
    public List<? extends c.a> f68648j;

    /* renamed from: k  reason: collision with root package name */
    public List<? extends c.a> f68649k;

    /* renamed from: l  reason: collision with root package name */
    public TradeTrendView.b f68650l;

    /* renamed from: m  reason: collision with root package name */
    public t f68651m;

    /* renamed from: n  reason: collision with root package name */
    public long f68652n;

    /* renamed from: o  reason: collision with root package name */
    public int f68653o;

    /* renamed from: p  reason: collision with root package name */
    public int f68654p;

    /* renamed from: q  reason: collision with root package name */
    public int f68655q;

    /* renamed from: r  reason: collision with root package name */
    public int f68656r;

    /* renamed from: s  reason: collision with root package name */
    public NewestPriceItemViewNew f68657s;

    /* renamed from: t  reason: collision with root package name */
    public final ViewGroup.MarginLayoutParams f68658t;

    /* renamed from: u  reason: collision with root package name */
    public final c6.b<c> f68659u;

    /* renamed from: v  reason: collision with root package name */
    public final b.C0742b f68660v;

    public class a implements b.C0742b {
        public a() {
        }

        public void a(b bVar) {
            if (TradeTrendViewNew.this.f68650l != null) {
                TradeTrendViewNew.this.f68650l.c(bVar.c());
            }
        }

        public void b(b bVar) {
            if (TradeTrendViewNew.this.f68650l != null) {
                TradeTrendViewNew.this.f68650l.b(bVar.c());
            }
        }
    }

    public TradeTrendViewNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(c cVar) {
        TradeTrendView.b bVar = this.f68650l;
        if (bVar != null) {
            bVar.a(cVar.c());
        }
        VibrateManager.a(this);
    }

    public void c(int i11) {
        this.f68653o = i11;
        ArrayList arrayList = new ArrayList();
        if (i11 == 1) {
            arrayList.add(this.f68641c);
            arrayList.addAll(this.f68646h);
        } else if (i11 == 2) {
            arrayList.addAll(this.f68640b);
            arrayList.add(this.f68641c);
        } else {
            for (int size = this.f68640b.size() - this.f68642d; size < this.f68640b.size(); size++) {
                arrayList.add(this.f68640b.get(size));
            }
            arrayList.add(this.f68641c);
            for (int i12 = 0; i12 < this.f68642d; i12++) {
                arrayList.add(this.f68646h.get(i12));
            }
        }
        this.f68647i.clear();
        this.f68647i.addAll(arrayList);
        setSellList(this.f68649k);
        setBuyList(this.f68648j);
        k();
    }

    public void d(Context context) {
        setOrientation(1);
        this.f68651m = new t(this);
        e();
        k();
        c(0);
    }

    public void e() {
        for (int i11 = 0; i11 < this.f68643e; i11++) {
            this.f68640b.add(new c(this.f68659u));
        }
        this.f68647i.addAll(this.f68640b);
        b bVar = new b(this.f68660v);
        this.f68641c = bVar;
        this.f68647i.add(bVar);
        for (int i12 = 0; i12 < this.f68643e; i12++) {
            this.f68646h.add(new c(this.f68659u));
        }
        this.f68647i.addAll(this.f68646h);
    }

    public void f() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt instanceof NewestPriceItemViewNew) {
                ((NewestPriceItemViewNew) childAt).d();
            } else if (childAt instanceof TradeTrendItemView) {
                ((TradeTrendItemView) childAt).i();
            }
        }
    }

    public boolean g() {
        return this.f68653o == 0;
    }

    public int getItemHeight() {
        return this.f68654p;
    }

    public int getNewestPriceItemViewHeight() {
        NewestPriceItemViewNew newestPriceItemViewNew = this.f68657s;
        if (newestPriceItemViewNew != null) {
            return newestPriceItemViewNew.getHeight();
        }
        return 0;
    }

    public void handleMessage(Message message) {
        this.f68652n = System.currentTimeMillis();
        f();
    }

    public void i() {
        t tVar = this.f68651m;
        if (tVar == null) {
            return;
        }
        if (tVar.hasMessages(1)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f68652n > 200) {
                this.f68652n = currentTimeMillis;
                this.f68651m.removeMessages(1);
                this.f68651m.sendEmptyMessage(1);
                return;
            }
            return;
        }
        this.f68651m.sendEmptyMessageDelayed(1, 250);
    }

    public final void j() {
        this.f68640b.clear();
        for (int i11 = 0; i11 < this.f68643e; i11++) {
            this.f68640b.add(new c(this.f68659u));
        }
        this.f68646h.clear();
        for (int i12 = 0; i12 < this.f68643e; i12++) {
            this.f68646h.add(new c(this.f68659u));
        }
        c(this.f68653o);
    }

    public void k() {
        int i11;
        int i12;
        removeAllViews();
        int i13 = 2;
        int i14 = 1;
        if (this.f68647i.size() <= 1) {
            i12 = 0;
            i13 = 0;
            i14 = 0;
            i11 = 0;
        } else if (this.f68647i.get(0) instanceof b) {
            i13 = 0;
            i12 = 1;
            i11 = 1;
        } else {
            List<k6.a> list = this.f68647i;
            if (list.get(list.size() - 1) instanceof b) {
                i12 = 1;
                i13 = 1;
                i11 = 1;
                i14 = 0;
            } else if (this.f68644f <= this.f68645g) {
                i12 = 1;
                i13 = 1;
                i11 = 1;
            } else {
                i12 = 1;
                i11 = 1;
                i14 = 2;
            }
        }
        addView(new Space(getContext()), new LinearLayout.LayoutParams(-1, 0, (float) i13));
        for (k6.a next : this.f68647i) {
            if (next instanceof b) {
                addView(new Space(getContext()), new LinearLayout.LayoutParams(-1, 0, (float) i12));
                if (this.f68657s == null) {
                    this.f68657s = new NewestPriceItemViewNew(getContext());
                }
                this.f68657s.e((b) next);
                addView(this.f68657s, this.f68658t);
                addView(new Space(getContext()), new LinearLayout.LayoutParams(-1, 0, (float) i11));
            } else {
                TradeTrendItemView tradeTrendItemView = new TradeTrendItemView(getContext());
                int i15 = this.f68656r;
                if (i15 != 0) {
                    tradeTrendItemView.setIndexColor(i15);
                }
                int i16 = this.f68655q;
                if (i16 != 0) {
                    tradeTrendItemView.setAmountColor(i16);
                }
                tradeTrendItemView.j((c) next);
                addView(tradeTrendItemView, new LinearLayout.LayoutParams(-1, this.f68654p));
            }
        }
        addView(new Space(getContext()), new LinearLayout.LayoutParams(-1, 0, (float) i14));
    }

    public void l(int i11, int i12) {
        boolean z11;
        boolean z12 = true;
        if (i11 != this.f68642d) {
            this.f68642d = i11;
            z11 = true;
        } else {
            z11 = false;
        }
        if (i12 != this.f68643e) {
            this.f68643e = i12;
        } else {
            z12 = z11;
        }
        if (z12) {
            j();
        }
    }

    public void setBuyList(List<? extends c.a> list) {
        if (list != null) {
            this.f68648j = list;
            for (int i11 = 0; i11 < this.f68646h.size(); i11++) {
                if (i11 < list.size()) {
                    this.f68646h.get(i11).e((c.a) list.get(i11));
                }
            }
        }
    }

    public void setCallback(TradeTrendView.b bVar) {
        this.f68650l = bVar;
    }

    public void setInsidePadding(int i11) {
        this.f68644f = i11;
    }

    public void setNewestPrice(b.a aVar) {
        b bVar = this.f68641c;
        if (bVar != null) {
            bVar.e(aVar);
        }
    }

    public void setSellList(List<? extends c.a> list) {
        if (list != null) {
            this.f68649k = list;
            for (int i11 = 0; i11 < this.f68640b.size(); i11++) {
                List<c> list2 = this.f68640b;
                c cVar = list2.get((list2.size() - 1) - i11);
                if (i11 < list.size()) {
                    cVar.e((c.a) list.get(i11));
                }
            }
        }
    }

    public TradeTrendViewNew(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f68640b = new ArrayList();
        this.f68642d = 5;
        this.f68643e = 10;
        this.f68644f = 0;
        this.f68645g = PixelUtils.a(24.0f);
        this.f68646h = new ArrayList();
        this.f68647i = new ArrayList();
        this.f68653o = 0;
        this.f68658t = new ViewGroup.MarginLayoutParams(-1, -2);
        this.f68659u = new r(this);
        this.f68660v = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TradeTrendView, i11, 0);
        this.f68654p = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.TradeTrendView_trade_item_height, getResources().getDimensionPixelOffset(R$dimen.dimen_18));
        this.f68655q = obtainStyledAttributes.getColor(R$styleable.TradeTrendView_trade_item_amount_color, 0);
        this.f68656r = obtainStyledAttributes.getColor(R$styleable.TradeTrendView_trade_item_index_color, 0);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        d(context);
    }
}
