package com.hbg.lite.record.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import com.hbg.lib.network.otc.core.bean.OrderInfoListBean;
import com.hbg.lib.network.otc.core.bean.RequestOrderListBean;
import com.hbg.lite.record.bean.OtcTradingHouseOrderList;
import com.hbg.lite.wallet.bean.LegalDetailInfo;
import ib.d;
import ib.e;
import ib.f;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import u6.g;

public class OtcCoinRecordPresenter extends BaseFragmentPresenter<b> {

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshPageSplitter<OtcTradingHouseOrderList> f77357c;

    /* renamed from: d  reason: collision with root package name */
    public int f77358d = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f77359e = -1;

    /* renamed from: f  reason: collision with root package name */
    public String f77360f = TtmlNode.COMBINE_ALL;

    /* renamed from: g  reason: collision with root package name */
    public String f77361g;

    /* renamed from: h  reason: collision with root package name */
    public int f77362h = -1;

    /* renamed from: i  reason: collision with root package name */
    public LegalDetailInfo f77363i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f77364j;

    /* renamed from: k  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<OtcTradingHouseOrderList> f77365k = new a();

    public class a implements SmartRefreshPageSplitter.c<OtcTradingHouseOrderList> {
        public a() {
        }

        public static /* synthetic */ Long g(OtcTradingHouseOrderList otcTradingHouseOrderList) {
            return 0L;
        }

        public Func1<? super OtcTradingHouseOrderList, ? extends Long> a() {
            try {
                return e.f55038b;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return f.f55039b;
            }
        }

        public Observable<List<OtcTradingHouseOrderList>> c() {
            int unused = OtcCoinRecordPresenter.this.f77358d = 1;
            return OtcCoinRecordPresenter.this.h0();
        }

        /* renamed from: h */
        public Observable<List<OtcTradingHouseOrderList>> b(OtcTradingHouseOrderList otcTradingHouseOrderList) {
            OtcCoinRecordPresenter.d0(OtcCoinRecordPresenter.this);
            return OtcCoinRecordPresenter.this.h0();
        }
    }

    public interface b extends g, SmartRefreshPageSplitter.d {
    }

    public static /* synthetic */ int d0(OtcCoinRecordPresenter otcCoinRecordPresenter) {
        int i11 = otcCoinRecordPresenter.f77358d;
        otcCoinRecordPresenter.f77358d = i11 + 1;
        return i11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List i0(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                OrderInfoListBean orderInfoListBean = (OrderInfoListBean) list.get(i11);
                if (orderInfoListBean != null) {
                    OtcTradingHouseOrderList otcTradingHouseOrderList = new OtcTradingHouseOrderList();
                    otcTradingHouseOrderList.h(orderInfoListBean);
                    otcTradingHouseOrderList.i(this.f77364j);
                    arrayList.add(otcTradingHouseOrderList);
                }
            }
        }
        return arrayList;
    }

    public final void g0() {
        if (this.f77357c == null) {
            this.f77357c = new SmartRefreshPageSplitter.Builder().n(true).l(true).m(10).p((SmartRefreshPageSplitter.d) getUI()).o(this.f77365k).k();
        }
    }

    public final Observable<List<OtcTradingHouseOrderList>> h0() {
        int i11;
        RequestOrderListBean requestOrderListBean = new RequestOrderListBean();
        requestOrderListBean.setCurrPage(this.f77358d);
        int i12 = this.f77359e;
        if (i12 != -1) {
            requestOrderListBean.setSide(xa.a.a(i12 == Integer.parseInt("0")));
        }
        if (!TextUtils.isEmpty(this.f77361g)) {
            if (TextUtils.isEmpty(this.f77361g)) {
                i11 = 2;
            } else {
                i11 = Integer.parseInt(this.f77361g);
            }
            requestOrderListBean.setQuoteAsset(va.b.d(i11));
        }
        int i13 = this.f77362h;
        if (i13 != -1) {
            requestOrderListBean.setCryptoAsset(va.b.d(i13));
        }
        if (!TextUtils.isEmpty(this.f77360f)) {
            requestOrderListBean.setOrderStatus(this.f77360f);
        }
        requestOrderListBean.setOrderType("exchange");
        return s8.a.a().l(requestOrderListBean).b().map(new d(this));
    }

    /* renamed from: j0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Intent intent = baseCoreActivity.getIntent();
        if (intent != null && intent.hasExtra("record_coin_id")) {
            LegalDetailInfo legalDetailInfo = (LegalDetailInfo) intent.getSerializableExtra("record_coin_id");
            this.f77363i = legalDetailInfo;
            this.f77362h = legalDetailInfo.getCoinId();
        }
        Bundle arguments = Q().getArguments();
        if (arguments != null) {
            this.f77364j = arguments.getBoolean("record_show_item_currency");
        }
        this.f77361g = va.b.o().f("usdt");
        g0();
        k0();
    }

    public void k0() {
        g0();
        this.f77357c.B();
    }

    public void l0(int i11, String str) {
        this.f77359e = i11;
        this.f77360f = str;
        g0();
        this.f77357c.B();
    }

    public void m0() {
        this.f77359e = -1;
        this.f77360f = TtmlNode.COMBINE_ALL;
    }
}
