package sb;

import com.hbg.lib.network.otc.core.bean.OtcLiteCollection;
import com.hbg.lib.network.otc.core.bean.OtcLiteQueryData;
import com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo;
import com.hbg.lib.network.otc.core.bean.OtcQueryData;
import com.hbg.lite.wallet.bean.LegalDataTotal;
import com.hbg.lite.wallet.bean.LegalDetailInfo;
import i6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import va.b;
import wa.d;

public final class f {

    /* renamed from: c  reason: collision with root package name */
    public static f f84861c = new f();

    /* renamed from: a  reason: collision with root package name */
    public List<OtcQueryData> f84862a = null;

    /* renamed from: b  reason: collision with root package name */
    public OtcLiteCollection f84863b;

    public class a implements Func1<OtcLiteCollection, LegalDataTotal> {
        public a() {
        }

        /* renamed from: a */
        public LegalDataTotal call(OtcLiteCollection otcLiteCollection) {
            LegalDataTotal legalDataTotal = new LegalDataTotal();
            legalDataTotal.setNetAssetToBtc(otcLiteCollection.getConvert().getConvertBtc());
            List<LegalDetailInfo> g11 = f.this.g(otcLiteCollection);
            legalDataTotal.setNetAssetToUsdt("0");
            legalDataTotal.setDetailInfos(g11);
            legalDataTotal.setNetAssetLegal(m.a(otcLiteCollection.getConvert().getConvertUsdt()).multiply(m.a(d.c(sa.a.d()))).toPlainString());
            return legalDataTotal;
        }
    }

    public static f h() {
        return f84861c;
    }

    public static /* synthetic */ Map k() {
        return new HashMap();
    }

    public static /* synthetic */ void l(Map map, OtcLiteQueryData otcLiteQueryData) {
        if (otcLiteQueryData != null) {
            if (!map.containsKey(Integer.valueOf(otcLiteQueryData.getCoinId()))) {
                map.put(Integer.valueOf(otcLiteQueryData.getCoinId()), new HashMap());
            }
            ((Map) map.get(Integer.valueOf(otcLiteQueryData.getCoinId()))).put(0, otcLiteQueryData.getAvailable());
            ((Map) map.get(Integer.valueOf(otcLiteQueryData.getCoinId()))).put(1, otcLiteQueryData.getFrozen());
            ((Map) map.get(Integer.valueOf(otcLiteQueryData.getCoinId()))).put(2, otcLiteQueryData.getBorrow());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(OtcLiteCollection otcLiteCollection) {
        if (otcLiteCollection != null) {
            this.f84863b = otcLiteCollection;
        }
    }

    public static /* synthetic */ Boolean n(OtcLiteCollection otcLiteCollection) {
        return Boolean.valueOf(otcLiteCollection != null);
    }

    public void f() {
        this.f84863b = null;
    }

    public List<LegalDetailInfo> g(OtcLiteCollection otcLiteCollection) {
        List<OtcLiteQueryData> wallet;
        ArrayList arrayList = new ArrayList();
        List<OtcMarketCoinInfo.CoinInfo> p11 = b.o().p();
        if (!(otcLiteCollection == null || (wallet = otcLiteCollection.getWallet()) == null)) {
            for (OtcLiteQueryData next : wallet) {
                for (OtcMarketCoinInfo.CoinInfo coinId : p11) {
                    if (next.getCoinId() == coinId.getCoinId()) {
                        LegalDetailInfo legalDetailInfo = new LegalDetailInfo();
                        legalDetailInfo.setCoinId(next.getCoinId());
                        legalDetailInfo.setShow(true);
                        OtcMarketCoinInfo.CoinInfo s11 = b.s(next.getCoinId());
                        int i11 = 0;
                        String str = "--";
                        if (s11 != null) {
                            if (s11.getShortName() != null) {
                                str = s11.getShortName().toLowerCase(Locale.US);
                            }
                            legalDetailInfo.setCurrency(str);
                            legalDetailInfo.setCoinId(s11.getCoinId());
                        } else {
                            i11 = 7;
                            legalDetailInfo.setCurrency(str);
                        }
                        legalDetailInfo.setStatus(i11);
                        legalDetailInfo.setAvailable(next.getAvailable());
                        legalDetailInfo.setOnOrders(next.getFrozen());
                        legalDetailInfo.setEstimateAmountToLegal(m.a(next.getConvertUsdt()).multiply(m.a(d.c(sa.a.d()))).toPlainString());
                        legalDetailInfo.setEstimateAmountToUsdt(next.getConvertUsdt());
                        arrayList.add(legalDetailInfo);
                    }
                }
            }
        }
        return arrayList;
    }

    public Observable<LegalDataTotal> i(boolean z11) {
        return p(z11).map(new a());
    }

    public Observable<Map<Integer, Map<Integer, String>>> o(boolean z11) {
        return p(z11).flatMap(d.f53437b).collect(c.f53436b, b.f53435b);
    }

    public final Observable<OtcLiteCollection> p(boolean z11) {
        Observable<OtcLiteCollection> doOnNext = s8.a.a().getLiteWallet().b().subscribeOn(Schedulers.io()).doOnNext(new a(this));
        return z11 ? Observable.concat(Observable.just(this.f84863b), doOnNext).takeFirst(e.f53438b) : doOnNext;
    }
}
