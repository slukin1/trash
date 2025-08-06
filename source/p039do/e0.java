package p039do;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bo.a;
import co.b;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.otc.core.bean.MarketPrice;
import com.hbg.lib.network.otc.core.bean.OtcConfigBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.otc.enums.TradeBusinessEnum;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import com.huobi.utils.GsonHelper;
import i6.b;
import i6.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.c1;
import pro.huobi.R;
import rx.Observable;
import u6.g;

/* renamed from: do.e0  reason: invalid package */
public class e0 extends a<b> implements b.a, a.C0827a {

    /* renamed from: j  reason: collision with root package name */
    public Handler f83855j = new i6.b(this);

    /* renamed from: k  reason: collision with root package name */
    public boolean f83856k;

    /* renamed from: l  reason: collision with root package name */
    public String f83857l;

    /* renamed from: m  reason: collision with root package name */
    public final bo.b f83858m = new bo.b(g(R.string.trade_dialog_otc_list_header));

    /* renamed from: n  reason: collision with root package name */
    public String f83859n;

    /* renamed from: do.e0$a */
    public class a extends BaseSubscriber<OtcConfigBean> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(OtcConfigBean otcConfigBean) {
            super.onNext(otcConfigBean);
            if (otcConfigBean != null) {
                otcConfigBean.setVersion(System.currentTimeMillis());
                va.b.o().E(GsonHelper.a().toJson((Object) otcConfigBean));
                e0.this.D();
                e0.this.C();
            }
        }

        public void onError(Throwable th2) {
        }

        public void onStart() {
            super.onStart();
        }
    }

    public e0(Context context, co.b bVar, g gVar) {
        super(context, TradeType.OTC, bVar, gVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(APIStatusErrorException aPIStatusErrorException) {
        d.b("OtcTradeDataProvider-->requestData-->e:" + aPIStatusErrorException.toString());
        w();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(Throwable th2) {
        d.b("OtcTradeDataProvider-->requestData-->throwable:" + th2.toString());
        w();
    }

    public static /* synthetic */ List y(List list, List list2) {
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(List list) {
        d.b("OtcTradeDataProvider-->requestData-->" + list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            MarketPrice.Price price = (MarketPrice.Price) it2.next();
            if (price.getCurrencyId().equals(this.f83857l)) {
                bo.a aVar = new bo.a(price, this);
                aVar.g(this.f83859n);
                arrayList.add(aVar);
            }
        }
        this.f83834g.clear();
        this.f83834g.add(this.f83858m);
        this.f83834g.addAll(arrayList);
        p();
        w();
    }

    public final void C() {
        Observable.zip(OtcMarketPriceConfigUtil.j(true).compose(RxJavaHelper.t(j())), OtcMarketPriceConfigUtil.f(true).compose(RxJavaHelper.t(j())), d0.f53843b).compose(RxJavaHelper.t(j())).subscribe(EasySubscriber.create(new c0(this), new a0(this), new b0(this)));
    }

    public final void D() {
        String f11 = op.a.r(0).f();
        E(f11);
        this.f83859n = c1.h().l(TradeBusinessEnum.ALL, f11);
        d.b("OtcTradeDataProvider-->OtcAdsListModel-->quoteAsset:" + f11 + " currencySymbol:" + this.f83859n);
    }

    public void E(String str) {
        this.f83857l = va.b.j(str);
    }

    public final void F(boolean z11) {
        this.f83856k = z11;
    }

    public boolean b(bo.a aVar) {
        String nf2 = h().nf();
        if (!TextUtils.isEmpty(nf2)) {
            return nf2.equals(String.valueOf(aVar.e().getCoinId()));
        }
        return false;
    }

    public void d(bo.a aVar) {
        if (h() != null) {
            h().a(this.f83831d, aVar);
        }
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            x();
        }
    }

    public void k() {
        d.b("OtcTradeDataProvider-->register-->");
        p();
        F(true);
        this.f83855j.removeMessages(1);
        this.f83855j.sendEmptyMessage(1);
    }

    public void l() {
    }

    public void o() {
        d.b("OtcTradeDataProvider-->unregister-->");
        F(false);
        this.f83855j.removeMessages(1);
    }

    public final void w() {
    }

    public void x() {
        if (!va.b.o().x()) {
            s8.a.a().d().b().compose(RxJavaHelper.t(j())).subscribe(new a());
            return;
        }
        D();
        C();
    }
}
