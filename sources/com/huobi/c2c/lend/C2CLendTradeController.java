package com.huobi.c2c.lend;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.network.hbg.c2c.C2CCurrencyProvider;
import com.hbg.lib.network.hbg.core.bean.C2CCurrencyBean;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.widgets.LoadingHelper;
import com.huobi.c2c.lend.dialog.C2CLendTipsDialog;
import com.huobi.c2c.lend.view.C2CLendActionView;
import com.huobi.c2c.lend.view.C2CLendTradeView2;
import com.huobi.c2c.lend.view.C2CLendTradeViewPager;
import com.huobi.c2c.util.C2CDialogUtil;
import com.huobi.c2c.util.n;
import com.huobi.login.bean.JumpTarget;
import com.huobi.statistics.hbg.bean.AnalyticsExposureItem;
import com.huobi.trade.core.HbTradeFragment;
import com.huobi.utils.k0;
import i6.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rn.c;
import tg.r;
import u6.g;

public class C2CLendTradeController extends zs.a {

    /* renamed from: d  reason: collision with root package name */
    public C2CLendTradeViewPager f42857d;

    /* renamed from: e  reason: collision with root package name */
    public C2CLendActionView f42858e;

    /* renamed from: f  reason: collision with root package name */
    public a f42859f;

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f42860g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public int f42861h;

    /* renamed from: i  reason: collision with root package name */
    public d9.a<List<C2CCurrencyBean>> f42862i;

    /* renamed from: j  reason: collision with root package name */
    public String f42863j;

    /* renamed from: k  reason: collision with root package name */
    public C2CLendTipsDialog f42864k = new C2CLendTipsDialog();

    /* renamed from: l  reason: collision with root package name */
    public final LoadingHelper f42865l = new LoadingHelper();

    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            int unused = C2CLendTradeController.this.f42861h = i11;
        }
    }

    public class b extends q6.a<List<C2CCurrencyBean>> {
        public b(g gVar) {
            super(gVar);
        }

        /* renamed from: a */
        public void onRequestSuccess(List<C2CCurrencyBean> list) {
            C2CLendTradeController.this.f42865l.d();
            if (C2CLendTradeController.this.f42858e != null) {
                C2CLendTradeController.this.f42858e.setTabList(C2CLendTradeController.this.f42860g);
            }
            C2CLendTradeController.this.f42857d.setList(C2CLendTradeController.this.f42860g);
            C2CLendTradeController.this.s();
        }

        /* renamed from: b */
        public List<C2CCurrencyBean> onRequestSuccessAsync(List<C2CCurrencyBean> list) {
            super.onRequestSuccessAsync(list);
            d.b("C2CLendTradeController-->requestCurrency-->" + list);
            synchronized (C2CLendTradeController.this.f42860g) {
                C2CLendTradeController.this.f42860g.clear();
                HashSet hashSet = new HashSet();
                for (C2CCurrencyBean next : list) {
                    if (!hashSet.contains(next.getCurrency())) {
                        C2CLendTradeController.this.f42860g.add(next.getCurrency());
                        hashSet.add(next.getCurrency());
                    }
                }
            }
            return (List) super.onRequestSuccessAsync(list);
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            C2CLendTradeController.this.f42865l.d();
            d.f("C2CLendTradeController-->requestCurrency-->", th2);
        }

        public void onRequestStart() {
            if (C2CLendTradeController.this.f42860g.isEmpty()) {
                super.onRequestStart();
                C2CLendTradeController.this.f42865l.g(C2CLendTradeController.this.e().o8());
            }
        }
    }

    public C2CLendTradeController(HbTradeFragment hbTradeFragment, zs.b bVar) {
        super(hbTradeFragment, bVar);
        o();
        C2CLendTradeViewPager c2CLendTradeViewPager = new C2CLendTradeViewPager(this.f85111b, e());
        this.f42857d = c2CLendTradeViewPager;
        c2CLendTradeViewPager.addOnPageChangeListener(new a());
        this.f42859f = new a(this.f85111b, (String) null, (zs.b) null, true, this.f42857d);
        this.f42858e = new C2CLendActionView(this.f85111b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(int i11, String str) {
        if (this.f42861h != i11) {
            this.f42861h = i11;
            this.f42857d.setCurrentItem(i11, false);
        }
    }

    public void a(boolean z11) {
        if (z11) {
            v7.b.a().j0();
            if (r.x().X() || !r.x().T()) {
                k0.Q(this.f85111b);
                return;
            }
            o();
            if (r.x().X()) {
                k0.Q(this.f85111b);
                return;
            }
            if (!EventBus.d().i(this)) {
                EventBus.d().p(this);
            }
            this.f42859f.r0();
            this.f42857d.d();
            n();
            q();
            AnalyticsExposureItem analyticsExposureItem = new AnalyticsExposureItem();
            analyticsExposureItem.setPageId("1005133");
            analyticsExposureItem.setName("C2C借出交易页");
            is.a.l(analyticsExposureItem);
            if (!C2CLendTipsDialog.Ah() && !this.f42864k.isVisible()) {
                this.f42864k.show(this.f85111b.getSupportFragmentManager(), "mC2CLendTipsDialog");
                return;
            }
            return;
        }
        v7.b.a().b();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        this.f42859f.q0();
        this.f42857d.c();
        if (e() != null) {
            e().dismissProgressDialog();
        }
        if (this.f42864k.isVisible()) {
            this.f42864k.dismiss();
        }
        this.f42865l.d();
    }

    public void b(AppBarLayout appBarLayout) {
        this.f42858e.setCallback(new mi.a(this));
        this.f42858e.f(this.f42857d);
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, d().getDimensionPixelOffset(R.dimen.dimen_50));
        layoutParams.setScrollFlags(0);
        this.f42858e.setLayoutParams(layoutParams);
        appBarLayout.addView(this.f42858e);
    }

    public void c(FrameLayout frameLayout) {
        C2CLendTradeView2 f02 = this.f42859f.f0();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        frameLayout.addView(f02, layoutParams);
        frameLayout.addView(this.f42857d, layoutParams2);
    }

    public final void n() {
        if (r.x().F0() && !n.d()) {
            n.c().d((RequestCallback1) null);
        }
    }

    public final void o() {
        Bundle arguments = this.f85110a.getArguments();
        if (arguments != null) {
            r(arguments.getString("EXTRA_CURRENCY"));
        }
    }

    public void onDestroy() {
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        Intent A = k0.A(this.f85111b, "");
        c.i().m(this.f85111b, new JumpTarget(A, A));
        C2CDialogUtil.j();
    }

    public final void q() {
        d.b("C2CLendTradeController-->requestCurrency-->");
        d9.a<List<C2CCurrencyBean>> aVar = this.f42862i;
        if (aVar != null) {
            aVar.a();
        }
        b bVar = new b(e());
        if (this.f42860g.isEmpty() && !C2CCurrencyProvider.i()) {
            new d9.a(com.huobi.c2c.util.c.b(true)).d(bVar);
        }
        d9.a<List<C2CCurrencyBean>> aVar2 = new d9.a<>(com.huobi.c2c.util.c.d(false, true));
        this.f42862i = aVar2;
        aVar2.d(bVar);
    }

    public void r(String str) {
        this.f42863j = str == null ? null : StringUtils.g(str);
        s();
    }

    public final void s() {
        if (!TextUtils.isEmpty(this.f42863j) && this.f42860g.contains(this.f42863j)) {
            int indexOf = this.f42860g.indexOf(this.f42863j);
            this.f42861h = indexOf;
            this.f42857d.setCurrentItem(indexOf);
        }
    }
}
