package com.hbg.lite.record.presenter;

import android.content.Intent;
import android.os.Bundle;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import com.hbg.lib.network.otc.core.bean.OrderInfoListBean;
import com.hbg.lib.network.otc.core.bean.RequestOrderListBean;
import com.hbg.lite.config.bean.LiteOtcTradeType;
import com.hbg.lite.record.bean.OtcOrderList;
import com.hbg.lite.wallet.bean.LegalDetailInfo;
import com.tencent.imsdk.v2.V2TIMConversation;
import ib.c;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import u6.g;

public class OtcCnyRecordPresenter extends BaseFragmentPresenter<b> {

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshPageSplitter<OtcOrderList> f77348c;

    /* renamed from: d  reason: collision with root package name */
    public int f77349d = 1;

    /* renamed from: e  reason: collision with root package name */
    public LiteOtcTradeType f77350e = LiteOtcTradeType.NONE;

    /* renamed from: f  reason: collision with root package name */
    public String f77351f = TtmlNode.COMBINE_ALL;

    /* renamed from: g  reason: collision with root package name */
    public int f77352g = -1;

    /* renamed from: h  reason: collision with root package name */
    public LegalDetailInfo f77353h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f77354i;

    /* renamed from: j  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<OtcOrderList> f77355j = new a();

    public class a implements SmartRefreshPageSplitter.c<OtcOrderList> {
        public a() {
        }

        public static /* synthetic */ Long g(OtcOrderList otcOrderList) {
            return 0L;
        }

        public Func1<? super OtcOrderList, ? extends Long> a() {
            try {
                return ib.b.f55035b;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return c.f55036b;
            }
        }

        public Observable<List<OtcOrderList>> c() {
            int unused = OtcCnyRecordPresenter.this.f77349d = 1;
            return OtcCnyRecordPresenter.this.h0();
        }

        /* renamed from: h */
        public Observable<List<OtcOrderList>> b(OtcOrderList otcOrderList) {
            OtcCnyRecordPresenter.d0(OtcCnyRecordPresenter.this);
            return OtcCnyRecordPresenter.this.h0();
        }
    }

    public interface b extends g, SmartRefreshPageSplitter.d {
    }

    public static /* synthetic */ int d0(OtcCnyRecordPresenter otcCnyRecordPresenter) {
        int i11 = otcCnyRecordPresenter.f77349d;
        otcCnyRecordPresenter.f77349d = i11 + 1;
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
                    OtcOrderList otcOrderList = new OtcOrderList();
                    otcOrderList.g(orderInfoListBean);
                    otcOrderList.h(this.f77354i);
                    arrayList.add(otcOrderList);
                }
            }
        }
        return arrayList;
    }

    public final SmartRefreshPageSplitter<OtcOrderList> g0() {
        return new SmartRefreshPageSplitter.Builder().n(true).l(true).m(10).p((SmartRefreshPageSplitter.d) getUI()).o(this.f77355j).k();
    }

    public final Observable<List<OtcOrderList>> h0() {
        RequestOrderListBean requestOrderListBean = new RequestOrderListBean();
        requestOrderListBean.setCurrPage(this.f77349d);
        LiteOtcTradeType liteOtcTradeType = this.f77350e;
        if (liteOtcTradeType != LiteOtcTradeType.NONE) {
            requestOrderListBean.setSide(liteOtcTradeType.getValue());
        }
        int i11 = this.f77352g;
        if (i11 != -1) {
            requestOrderListBean.setCryptoAsset(va.b.d(i11));
        }
        requestOrderListBean.setOrderStatus(this.f77351f);
        requestOrderListBean.setOrderType(V2TIMConversation.CONVERSATION_C2C_TYPE);
        requestOrderListBean.setSecondaryType("c2c_all_app");
        return s8.a.a().l(requestOrderListBean).b().map(new ib.a(this));
    }

    /* renamed from: j0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Intent intent = baseCoreActivity.getIntent();
        if (intent != null && intent.hasExtra("record_coin_id")) {
            LegalDetailInfo legalDetailInfo = (LegalDetailInfo) intent.getSerializableExtra("record_coin_id");
            this.f77353h = legalDetailInfo;
            this.f77352g = legalDetailInfo.getCoinId();
        }
        Bundle arguments = Q().getArguments();
        if (arguments != null) {
            this.f77354i = arguments.getBoolean("record_show_item_currency");
        }
        this.f77348c = g0();
        k0();
    }

    public void k0() {
        if (this.f77348c == null) {
            this.f77348c = g0();
        }
        this.f77348c.B();
    }

    public void l0(LiteOtcTradeType liteOtcTradeType, String str) {
        this.f77350e = liteOtcTradeType;
        this.f77351f = str;
        if (this.f77348c == null) {
            this.f77348c = g0();
        }
        this.f77348c.B();
    }

    public void m0() {
        this.f77350e = LiteOtcTradeType.NONE;
        this.f77351f = TtmlNode.COMBINE_ALL;
    }
}
