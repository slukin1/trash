package jp;

import com.google.gson.Gson;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.finance.bean.CurrencySearchEntity;
import com.huobi.finance.bean.CurrencySearchItem;
import com.huobi.finance.utils.DepositWithdrawHelper;
import d7.k;
import dt.h2;
import i6.d;
import i6.m;
import io.flutter.plugin.common.MethodChannel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tg.r;
import u6.g;
import x7.f;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f84311a = new b();

    public class a extends BaseSubscriber<List<CurrencyBean>> {

        /* renamed from: b  reason: collision with root package name */
        public boolean f84312b = false;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f84313c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f84314d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f84315e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f84316f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f84317g;

        public a(String str, int i11, boolean z11, Map map, MethodChannel.Result result) {
            this.f84313c = str;
            this.f84314d = i11;
            this.f84315e = z11;
            this.f84316f = map;
            this.f84317g = result;
        }

        public void onCompleted() {
            super.onCompleted();
            if (!this.f84312b) {
                this.f84317g.success("");
            }
        }

        public void onError(Throwable th2) {
            this.f84317g.success("");
            this.f84312b = true;
            super.onError(th2);
        }

        public void onNext(List<CurrencyBean> list) {
            CurrencySearchEntity a11 = b.this.c(list, this.f84313c, this.f84314d, this.f84315e, this.f84316f);
            if (a11 != null) {
                String json = new Gson().toJson((Object) a11);
                d.b("CurrencySearchActivity-->onMethodCall-->initCoinList:" + json);
                this.f84317g.success(json);
            } else {
                this.f84317g.success("");
            }
            this.f84312b = true;
            super.onNext(list);
        }
    }

    public static b b() {
        return f84311a;
    }

    public final CurrencySearchEntity c(List<CurrencyBean> list, String str, int i11, boolean z11, Map<String, CurrencyBean> map) {
        BalanceQueryData balanceQueryData;
        Map<String, List<ChainInfo>> map2 = null;
        if (CollectionsUtils.b(list)) {
            return null;
        }
        try {
            balanceQueryData = h2.t1().v3(TradeType.PRO, true).toBlocking().first();
        } catch (Exception e11) {
            e11.printStackTrace();
            balanceQueryData = null;
        }
        boolean equals = "1".equals(str);
        if (r.x().F0()) {
            map2 = k.C().l();
        }
        if (map2 != null && !map2.isEmpty() && !list.isEmpty()) {
            for (CurrencyBean next : list) {
                if (!(next == null || next.getName() == null)) {
                    next.setChainInfos(map2.get(next.getName()));
                }
            }
        }
        CurrencySearchEntity currencySearchEntity = new CurrencySearchEntity();
        currencySearchEntity.setDeposit(equals);
        currencySearchEntity.setType(d(str));
        currencySearchEntity.setPageFrom(i11);
        currencySearchEntity.setShowDisableDeposit(z11);
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            CurrencyBean currencyBean = list.get(i12);
            if (currencyBean != null) {
                boolean z12 = equals && f.c(currencyBean.getName());
                if (e(balanceQueryData, currencyBean) || (currencyBean.isVisible() && !currencyBean.isEtpTag() && !z12 && !currencyBean.isCountryDisabled())) {
                    CurrencySearchItem currencySearchItem = new CurrencySearchItem();
                    currencySearchItem.setCurrency(currencyBean.getDisplayName());
                    currencySearchItem.setDepositEnabled(!((DepositWithdrawHelper.b(currencyBean) & 2) != 0));
                    currencySearchItem.setWithdrawEnable(!((DepositWithdrawHelper.b(currencyBean) & 4) != 0));
                    currencySearchItem.setFullName(currencyBean.getFullName());
                    if (!currencyBean.isFiatTag()) {
                        arrayList.add(currencySearchItem);
                    }
                    map.put(StringUtils.g(currencyBean.getDisplayName()), currencyBean);
                }
            }
        }
        currencySearchEntity.setList(arrayList);
        return currencySearchEntity;
    }

    public final int d(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e11) {
            d.b(e11.toString());
            return 0;
        }
    }

    public final boolean e(BalanceQueryData balanceQueryData, CurrencyBean currencyBean) {
        if (balanceQueryData == null || CollectionsUtils.b(balanceQueryData.getList()) || currencyBean == null || m.a(m.m(balanceQueryData.getBalance(currencyBean.getName(), "trade"), PrecisionUtil.z(currencyBean.getName()))).compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        return true;
    }

    public void f(MethodChannel.Result result, boolean z11, String str, int i11, boolean z12, Map<String, CurrencyBean> map) {
        k.C().E(z11).compose(RxJavaHelper.t((g) null)).subscribe(new a(str, i11, z12, map, result));
    }
}
