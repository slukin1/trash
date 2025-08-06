package com.huobi.otc.helper;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.network.otc.core.bean.MarketPrice;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.huobi.otc.bean.MarketCoin;
import com.huobi.otc.service.OTCService;
import java.util.ArrayList;
import java.util.List;
import jp.r0;
import rx.Observable;
import rx.functions.Func1;

public class OtcMarketPriceConfigImpl implements lp.d {

    /* renamed from: a  reason: collision with root package name */
    public List<MarketPrice.Price> f78898a = null;

    /* renamed from: b  reason: collision with root package name */
    public List<MarketCoin.Coin> f78899b = null;

    public class a implements Func1<MarketPrice, Observable<List<MarketPrice.Price>>> {
        public a() {
        }

        /* renamed from: a */
        public Observable<List<MarketPrice.Price>> call(MarketPrice marketPrice) {
            List unused = OtcMarketPriceConfigImpl.this.f78898a = new ArrayList();
            OtcMarketPriceConfigImpl.this.f78898a.addAll(marketPrice.getPriceList());
            return Observable.just(marketPrice.getPriceList());
        }
    }

    public class b implements Func1<List<MarketPrice.Price>, Boolean> {
        public b() {
        }

        /* renamed from: a */
        public Boolean call(List<MarketPrice.Price> list) {
            return Boolean.valueOf(list != null);
        }
    }

    public class c implements Func1<MarketCoin, Observable<List<MarketCoin.Coin>>> {
        public c() {
        }

        /* renamed from: a */
        public Observable<List<MarketCoin.Coin>> call(MarketCoin marketCoin) {
            List unused = OtcMarketPriceConfigImpl.this.f78899b = new ArrayList();
            OtcMarketPriceConfigImpl.this.f78899b.addAll(marketCoin.getCoinList());
            OtcMarketPriceConfigImpl otcMarketPriceConfigImpl = OtcMarketPriceConfigImpl.this;
            otcMarketPriceConfigImpl.m(otcMarketPriceConfigImpl.f78899b);
            return Observable.just(marketCoin.getCoinList());
        }
    }

    public class d extends TypeToken<List<MarketCoin.Coin>> {
        public d() {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List l(Throwable th2) {
        return j();
    }

    public List<MarketCoin.Coin> a() {
        ArrayList arrayList = new ArrayList();
        List<MarketCoin.Coin> list = this.f78899b;
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(this.f78899b);
        }
        return arrayList;
    }

    public Observable<List<MarketPrice.Price>> b(boolean z11) {
        Observable<R> flatMap = s8.a.a().getMarketPriceList().b().flatMap(new a());
        return z11 ? Observable.concat(Observable.just(this.f78898a), flatMap).takeFirst(new b()) : flatMap;
    }

    public Observable<List<MarketCoin.Coin>> c(boolean z11) {
        List<MarketCoin.Coin> j11;
        Observable<R> onErrorReturn = ((OTCService) OtcRetrofit.request(OTCService.class)).getMarketCoinList().compose(OtcRetrofit.o()).flatMap(new c()).onErrorReturn(new r0(this));
        if (z11 && (j11 = j()) != null) {
            return Observable.just(j11);
        }
        i6.d.c("MarketCoinList", "get otc market coin list from [network].");
        return onErrorReturn;
    }

    public final List<MarketCoin.Coin> j() {
        if (this.f78899b != null) {
            i6.d.c("MarketCoinList", "get otc market coin list from [cache].");
            return this.f78899b;
        }
        List<MarketCoin.Coin> k11 = k();
        if (k11 == null) {
            return null;
        }
        this.f78899b = k11;
        i6.d.c("MarketCoinList", "get otc market coin list from [file cache].");
        return k11;
    }

    public final List<MarketCoin.Coin> k() {
        List<MarketCoin.Coin> list = null;
        String d11 = SPUtil.d("SP_KEY_MARKET_COIN_LIST", (String) null);
        if (TextUtils.isEmpty(d11)) {
            return null;
        }
        try {
            List<MarketCoin.Coin> list2 = (List) new Gson().fromJson(d11, new d().getType());
            try {
                i6.d.c("MarketCoinList", "Read otc market coin list from file.  Size =" + list2.size() + " " + d11);
                return list2;
            } catch (Exception e11) {
                e = e11;
                list = list2;
            }
        } catch (Exception e12) {
            e = e12;
            e.printStackTrace();
            return list;
        }
    }

    public final void m(List<MarketCoin.Coin> list) {
        try {
            String json = new Gson().toJson((Object) list);
            SPUtil.m("SP_KEY_MARKET_COIN_LIST", json);
            i6.d.c("MarketCoinList", "Save otc market coin list to file. " + json);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
