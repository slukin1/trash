package com.huobi.login.presenter;

import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nn.b;
import nn.c;
import nn.e;
import nn.f;
import nn.h;
import nn.i;
import nn.j;
import qu.d;
import tq.p;
import u6.g;

public class CountryAreaSelectPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public v9.a<CountryListData> f75448a;

    /* renamed from: b  reason: collision with root package name */
    public List<CountryListData> f75449b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<CountryListData> f75450c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f75451d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f75452e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f75453f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f75454g;

    public interface a extends g {
        void Jd(v9.a<CountryListData> aVar);

        LoadingLayout f1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            CountryListData countryListData = (CountryListData) it2.next();
            countryListData.m(this.f75452e);
            if (this.f75454g) {
                countryListData.l(d.i().h(countryListData.c(), countryListData.e()));
            }
        }
        ((a) getUI()).f1().g();
        this.f75449b.addAll(list);
        this.f75448a.notifyDataSetChanged();
        this.f75450c.addAll(this.f75449b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a0(APIStatusErrorException aPIStatusErrorException) {
        ((a) getUI()).f1().k();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b0(Throwable th2) {
        ((a) getUI()).f1().k();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c0(List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ((CountryListData) it2.next()).m(this.f75452e);
        }
        ((a) getUI()).f1().g();
        this.f75449b.addAll(list);
        this.f75448a.notifyDataSetChanged();
        this.f75450c.addAll(this.f75449b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(APIStatusErrorException aPIStatusErrorException) {
        ((a) getUI()).f1().k();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f0(Throwable th2) {
        ((a) getUI()).f1().k();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g0(List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ((CountryListData) it2.next()).m(this.f75452e);
        }
        ((a) getUI()).f1().g();
        this.f75449b.addAll(list);
        this.f75448a.notifyDataSetChanged();
        this.f75450c.addAll(this.f75449b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h0(APIStatusErrorException aPIStatusErrorException) {
        ((a) getUI()).f1().k();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(Throwable th2) {
        ((a) getUI()).f1().k();
    }

    /* renamed from: j0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        this.f75452e = getActivity().getIntent().getBooleanExtra("SHOW_COUNTRY_ICON", false);
        this.f75453f = getActivity().getIntent().getBooleanExtra("SHOW_ALL_COUNTRY", false);
        String stringExtra = getActivity().getIntent().getStringExtra("choose_type");
        this.f75454g = getActivity().getIntent().getBooleanExtra("choose_from_add_address", false);
        this.f75451d = "choose_type_name".equals(stringExtra);
        this.f75448a = new v9.a<>(this.f75449b);
        ((a) getUI()).Jd(this.f75448a);
        k0();
    }

    public void k0() {
        if (this.f75451d) {
            l0();
        } else {
            m0();
        }
    }

    public final void l0() {
        ((a) getUI()).f1().p();
        UserCenterRemoteDataSource.A().v().compose(RxJavaHelper.t((g) null)).compose(p.c0()).subscribe(EasySubscriber.create(new h(this), new nn.d(this), new f(this)));
    }

    public final void m0() {
        ((a) getUI()).f1().p();
        if (this.f75453f) {
            UserCenterRemoteDataSource.A().t().compose(RxJavaHelper.t((g) null)).compose(p.c0()).subscribe(EasySubscriber.create(new j(this), new b(this), new e(this)));
        } else {
            UserCenterRemoteDataSource.A().D().compose(RxJavaHelper.t((g) null)).compose(p.c0()).subscribe(EasySubscriber.create(new i(this), new c(this), new nn.g(this)));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008f, code lost:
        if (r3.toLowerCase(r4).contains(r6.toLowerCase(r4)) == false) goto L_0x0091;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n0(java.lang.String r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 == 0) goto L_0x002b
            java.util.List<com.huobi.login.usercenter.data.source.bean.CountryListData> r6 = r5.f75449b
            r6.clear()
            java.util.List<com.huobi.login.usercenter.data.source.bean.CountryListData> r6 = r5.f75449b
            java.util.List<com.huobi.login.usercenter.data.source.bean.CountryListData> r0 = r5.f75450c
            r6.addAll(r0)
            v9.a<com.huobi.login.usercenter.data.source.bean.CountryListData> r6 = r5.f75448a
            r6.notifyDataSetChanged()
            h6.a r6 = r5.getUI()
            com.huobi.login.presenter.CountryAreaSelectPresenter$a r6 = (com.huobi.login.presenter.CountryAreaSelectPresenter.a) r6
            com.hbg.lib.widgets.LoadingLayout r6 = r6.f1()
            r6.g()
            goto L_0x00d9
        L_0x002b:
            boolean r1 = i6.m.Y(r6)
            if (r1 == 0) goto L_0x0051
            java.util.List<com.huobi.login.usercenter.data.source.bean.CountryListData> r1 = r5.f75450c
            java.util.Iterator r1 = r1.iterator()
        L_0x0037:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00a9
            java.lang.Object r2 = r1.next()
            com.huobi.login.usercenter.data.source.bean.CountryListData r2 = (com.huobi.login.usercenter.data.source.bean.CountryListData) r2
            java.lang.String r3 = r2.a()
            boolean r3 = r3.contains(r6)
            if (r3 == 0) goto L_0x0037
            r0.add(r2)
            goto L_0x0037
        L_0x0051:
            java.util.List<com.huobi.login.usercenter.data.source.bean.CountryListData> r1 = r5.f75450c
            java.util.Iterator r1 = r1.iterator()
        L_0x0057:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00a9
            java.lang.Object r2 = r1.next()
            com.huobi.login.usercenter.data.source.bean.CountryListData r2 = (com.huobi.login.usercenter.data.source.bean.CountryListData) r2
            com.hbg.lib.core.util.AppLanguageHelper r3 = com.hbg.lib.core.util.AppLanguageHelper.getInstance()
            boolean r3 = r3.isChineseLanguage()
            if (r3 == 0) goto L_0x007b
            java.lang.String r3 = r2.d()
            boolean r3 = r3.contains(r6)
            if (r3 == 0) goto L_0x0057
            r0.add(r2)
            goto L_0x0057
        L_0x007b:
            java.lang.String r3 = r2.f()
            if (r3 == 0) goto L_0x0091
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r3 = r3.toLowerCase(r4)
            java.lang.String r4 = r6.toLowerCase(r4)
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L_0x00a5
        L_0x0091:
            java.lang.String r3 = r2.e()
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r3 = r3.toLowerCase(r4)
            java.lang.String r4 = r6.toLowerCase(r4)
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L_0x0057
        L_0x00a5:
            r0.add(r2)
            goto L_0x0057
        L_0x00a9:
            int r6 = r0.size()
            if (r6 != 0) goto L_0x00bd
            h6.a r6 = r5.getUI()
            com.huobi.login.presenter.CountryAreaSelectPresenter$a r6 = (com.huobi.login.presenter.CountryAreaSelectPresenter.a) r6
            com.hbg.lib.widgets.LoadingLayout r6 = r6.f1()
            r6.i()
            goto L_0x00d9
        L_0x00bd:
            java.util.List<com.huobi.login.usercenter.data.source.bean.CountryListData> r6 = r5.f75449b
            r6.clear()
            java.util.List<com.huobi.login.usercenter.data.source.bean.CountryListData> r6 = r5.f75449b
            r6.addAll(r0)
            v9.a<com.huobi.login.usercenter.data.source.bean.CountryListData> r6 = r5.f75448a
            r6.notifyDataSetChanged()
            h6.a r6 = r5.getUI()
            com.huobi.login.presenter.CountryAreaSelectPresenter$a r6 = (com.huobi.login.presenter.CountryAreaSelectPresenter.a) r6
            com.hbg.lib.widgets.LoadingLayout r6 = r6.f1()
            r6.g()
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.login.presenter.CountryAreaSelectPresenter.n0(java.lang.String):void");
    }
}
