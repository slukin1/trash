package com.huobi.finance.presenter;

import android.content.Intent;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.network.exception.NullResponseException;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.OtcFinanceRecordItem;
import com.huobi.finance.bean.OtcFinanceResponse;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import com.huobi.page.SmartRefreshPageSplitter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rn.c;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import u6.g;

public class OtcCurrencyFinanceRecordPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public SmartRefreshPageSplitter<OtcFinanceRecordItem> f45625a;

    /* renamed from: b  reason: collision with root package name */
    public int f45626b;

    /* renamed from: c  reason: collision with root package name */
    public String f45627c;

    /* renamed from: d  reason: collision with root package name */
    public int f45628d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f45629e;

    /* renamed from: f  reason: collision with root package name */
    public int f45630f = 1;

    /* renamed from: g  reason: collision with root package name */
    public OtcFinanceResponse<List<OtcFinanceRecordItem>> f45631g;

    /* renamed from: h  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<OtcFinanceRecordItem> f45632h = new a();

    public class a implements SmartRefreshPageSplitter.c<OtcFinanceRecordItem> {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(List list) {
            if (list == null || list.isEmpty()) {
                OtcCurrencyFinanceRecordPresenter.this.f45625a.D((List) null);
                return;
            }
            OtcCurrencyFinanceRecordPresenter.this.f45625a.D(list);
            OtcCurrencyFinanceRecordPresenter.this.f45625a.C((OtcFinanceRecordItem) list.get(list.size() - 1));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(OtcFinanceResponse otcFinanceResponse) {
            OtcFinanceResponse unused = OtcCurrencyFinanceRecordPresenter.this.f45631g = otcFinanceResponse;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(List list) {
            if (list == null || list.isEmpty()) {
                OtcCurrencyFinanceRecordPresenter.this.f45625a.D((List) null);
                return;
            }
            OtcCurrencyFinanceRecordPresenter.this.f45625a.D(list);
            OtcCurrencyFinanceRecordPresenter.this.f45625a.C((OtcFinanceRecordItem) list.get(list.size() - 1));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void o(List list) {
            if (list != null && !list.isEmpty()) {
                OtcCurrencyFinanceRecordPresenter.this.f45625a.D(list);
                OtcCurrencyFinanceRecordPresenter.this.f45625a.C((OtcFinanceRecordItem) list.get(list.size() - 1));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void p(OtcFinanceResponse otcFinanceResponse) {
            OtcFinanceResponse unused = OtcCurrencyFinanceRecordPresenter.this.f45631g = otcFinanceResponse;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void q(List list) {
            if (list != null && !list.isEmpty()) {
                OtcCurrencyFinanceRecordPresenter.this.f45625a.D(list);
                OtcCurrencyFinanceRecordPresenter.this.f45625a.C((OtcFinanceRecordItem) list.get(list.size() - 1));
            }
        }

        public Func1<? super OtcFinanceRecordItem, ? extends Long> a() {
            return k6.f45956b;
        }

        public Observable<List<OtcFinanceRecordItem>> c() {
            int unused = OtcCurrencyFinanceRecordPresenter.this.f45630f = 1;
            if (OtcCurrencyFinanceRecordPresenter.this.f45626b == 1) {
                OtcCurrencyFinanceRecordPresenter otcCurrencyFinanceRecordPresenter = OtcCurrencyFinanceRecordPresenter.this;
                return otcCurrencyFinanceRecordPresenter.k0(otcCurrencyFinanceRecordPresenter.f45630f).doOnNext(new i6(this));
            }
            MapParamsBuilder c11 = MapParamsBuilder.c();
            if (OtcCurrencyFinanceRecordPresenter.this.f45628d != Integer.MIN_VALUE) {
                c11.a("coinId", Integer.valueOf(OtcCurrencyFinanceRecordPresenter.this.f45628d));
            }
            c11.a("currPage", Integer.valueOf(OtcCurrencyFinanceRecordPresenter.this.f45630f));
            if (OtcCurrencyFinanceRecordPresenter.this.f45629e != Integer.MIN_VALUE) {
                if (OtcCurrencyFinanceRecordPresenter.this.f45629e == 45) {
                    c11.a("type", String.format("%d,%d", new Object[]{45, 46}));
                } else {
                    c11.a("type", Integer.valueOf(OtcCurrencyFinanceRecordPresenter.this.f45629e));
                }
            }
            return OtcCurrencyFinanceRecordPresenter.this.j0(c11.b()).doOnNext(new f6(this)).compose(OtcCurrencyFinanceRecordPresenter.this.u0()).doOnNext(new h6(this));
        }

        /* renamed from: r */
        public Observable<List<OtcFinanceRecordItem>> b(OtcFinanceRecordItem otcFinanceRecordItem) {
            OtcCurrencyFinanceRecordPresenter.Z(OtcCurrencyFinanceRecordPresenter.this);
            if (OtcCurrencyFinanceRecordPresenter.this.f45626b == 1) {
                OtcCurrencyFinanceRecordPresenter otcCurrencyFinanceRecordPresenter = OtcCurrencyFinanceRecordPresenter.this;
                return otcCurrencyFinanceRecordPresenter.k0(otcCurrencyFinanceRecordPresenter.f45630f).doOnNext(new j6(this));
            }
            MapParamsBuilder c11 = MapParamsBuilder.c();
            if (OtcCurrencyFinanceRecordPresenter.this.f45628d != Integer.MIN_VALUE) {
                c11.a("coinId", Integer.valueOf(OtcCurrencyFinanceRecordPresenter.this.f45628d));
            }
            c11.a("currPage", Integer.valueOf(OtcCurrencyFinanceRecordPresenter.this.f45630f));
            if (OtcCurrencyFinanceRecordPresenter.this.f45629e != Integer.MIN_VALUE) {
                if (OtcCurrencyFinanceRecordPresenter.this.f45629e == 45) {
                    c11.a("type", String.format("%d,%d", new Object[]{45, 46}));
                } else {
                    c11.a("type", Integer.valueOf(OtcCurrencyFinanceRecordPresenter.this.f45629e));
                }
            }
            return OtcCurrencyFinanceRecordPresenter.this.j0(c11.b()).doOnNext(new e6(this)).compose(OtcCurrencyFinanceRecordPresenter.this.u0()).doOnNext(new g6(this));
        }
    }

    public interface b extends SmartRefreshPageSplitter.d {
        void f9(String str);
    }

    public static /* synthetic */ int Z(OtcCurrencyFinanceRecordPresenter otcCurrencyFinanceRecordPresenter) {
        int i11 = otcCurrencyFinanceRecordPresenter.f45630f;
        otcCurrencyFinanceRecordPresenter.f45630f = i11 + 1;
        return i11;
    }

    public static /* synthetic */ OtcFinanceRecordItem m0(OtcFinanceRecordItem otcFinanceRecordItem) {
        if (otcFinanceRecordItem != null) {
            otcFinanceRecordItem.setLayoutType(1);
        }
        return otcFinanceRecordItem;
    }

    public static /* synthetic */ int n0(OtcFinanceRecordItem otcFinanceRecordItem, OtcFinanceRecordItem otcFinanceRecordItem2) {
        int i11 = (otcFinanceRecordItem2.getGmtCreate() > otcFinanceRecordItem.getGmtCreate() ? 1 : (otcFinanceRecordItem2.getGmtCreate() == otcFinanceRecordItem.getGmtCreate() ? 0 : -1));
        if (i11 < 0) {
            return -1;
        }
        return i11 == 0 ? 0 : 1;
    }

    public static /* synthetic */ List p0(List list, List list2) {
        ArrayList<OtcFinanceRecordItem> arrayList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
        }
        if (list2 != null && !list2.isEmpty()) {
            arrayList.addAll(list2);
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, x5.f46175b);
            for (OtcFinanceRecordItem layoutType : arrayList) {
                layoutType.setLayoutType(1);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void q0(OtcFinanceResponse otcFinanceResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (otcFinanceResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (otcFinanceResponse.isSuccess()) {
            subscriber.onNext(otcFinanceResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(otcFinanceResponse.getErrCode(), otcFinanceResponse.getErrMsg()));
        }
    }

    public int i0() {
        return this.f45626b;
    }

    public final Observable<OtcFinanceResponse<List<OtcFinanceRecordItem>>> j0(Map<String, Object> map) {
        return ((FinanceService) OtcRetrofit.request(FinanceService.class)).queryFinances(map);
    }

    public final Observable<List<OtcFinanceRecordItem>> k0(int i11) {
        Class cls = FinanceService.class;
        int i12 = this.f45629e;
        if (i12 == 5 || i12 == 6) {
            MapParamsBuilder c11 = MapParamsBuilder.c();
            int i13 = this.f45628d;
            if (i13 != Integer.MIN_VALUE) {
                c11.a("coinId", Integer.valueOf(i13));
            }
            c11.a("currPage", Integer.valueOf(i11)).a("type", Integer.valueOf(this.f45629e));
            return ((FinanceService) OtcRetrofit.request(cls)).queryFinances(c11.b()).compose(u0()).flatMap(c6.f45836b).map(a6.f45802b).toList();
        }
        MapParamsBuilder c12 = MapParamsBuilder.c();
        c12.a("currPage", Integer.valueOf(i11));
        MapParamsBuilder c13 = MapParamsBuilder.c();
        c13.a("currPage", Integer.valueOf(i11));
        c12.a("type", 5);
        c13.a("type", 6);
        int i14 = this.f45628d;
        if (i14 != Integer.MIN_VALUE) {
            c12.a("coinId", Integer.valueOf(i14));
            c13.a("coinId", Integer.valueOf(this.f45628d));
        }
        return Observable.zip(((FinanceService) OtcRetrofit.request(cls)).queryFinances(c13.b()).compose(u0()).compose(RxJavaHelper.t((g) getUI())), ((FinanceService) OtcRetrofit.request(cls)).queryFinances(c12.b()).compose(u0()).compose(RxJavaHelper.t((g) getUI())), d6.f45851b);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onStart() {
        super.onStart();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }

    /* renamed from: t0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("coin_name");
            this.f45627c = stringExtra;
            this.f45628d = OtcMarketPriceConfigUtil.b(stringExtra);
            this.f45626b = intent.getIntExtra("from", 0);
        }
        if (this.f45626b == 1) {
            ((b) getUI()).f9(getString(R.string.transfer_history_title));
        }
        this.f45629e = Integer.MIN_VALUE;
        SmartRefreshPageSplitter<OtcFinanceRecordItem> k11 = new SmartRefreshPageSplitter.Builder().p(true).n(true).o(10).r(bVar).q(this.f45632h).k();
        this.f45625a = k11;
        k11.F();
    }

    public <T> Observable.Transformer<OtcFinanceResponse<T>, T> u0() {
        return z5.f46203b;
    }

    public void v0(int i11) {
        this.f45629e = i11;
        this.f45625a.F();
    }
}
