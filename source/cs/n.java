package cs;

import android.text.TextUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.contract.core.bean.CenterMarketConfigContracts;
import com.hbg.lib.network.contract.core.bean.CenterMarketConfigInfo;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.contract.core.util.RemindTriggerType;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.staring.bean.AllRulesResult;
import com.huobi.staring.bean.CustomConfig;
import com.huobi.staring.bean.CustomPriceInfoResp;
import com.huobi.staring.bean.CustomPriceResp;
import com.huobi.staring.bean.CustomRuleListResult;
import com.huobi.staring.bean.CustomRuleResp;
import com.huobi.staring.bean.CustomSaveResult;
import com.huobi.staring.bean.PriceConfig;
import com.huobi.staring.bean.RemindCustomSub;
import com.huobi.staring.bean.RuleConfigResult;
import i6.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import u6.g;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static RuleConfigResult f83816a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f83817b;

    public class a extends BaseSubscriber<RuleConfigResult> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseSubscriber f83818b;

        public a(BaseSubscriber baseSubscriber) {
            this.f83818b = baseSubscriber;
        }

        /* renamed from: a */
        public void onNext(RuleConfigResult ruleConfigResult) {
            super.onNext(ruleConfigResult);
            d.b("StaringRemindHelper-->requestRuleConfigList-->" + ruleConfigResult);
            if (!(ruleConfigResult == null || ruleConfigResult.getCustom() == null || ruleConfigResult.getCustom().getPrice() == null || ruleConfigResult.getCustom().getPrice().getSymbols() == null)) {
                List<String> symbols = ruleConfigResult.getCustom().getPrice().getSymbols();
                ArrayList arrayList = new ArrayList();
                ruleConfigResult.getCustom().getPrice().setSymbols(arrayList);
                for (String next : symbols) {
                    if ((!next.contains("usdt".toUpperCase()) && !next.contains("usdt") && !next.contains("husd".toUpperCase()) && !next.contains("husd")) || (!next.endsWith("CW") && !next.endsWith("NW") && !next.endsWith("CQ") && !next.endsWith("NQ"))) {
                        arrayList.add(next);
                    }
                }
            }
            RuleConfigResult unused = n.f83816a = ruleConfigResult;
            BaseSubscriber baseSubscriber = this.f83818b;
            if (baseSubscriber != null) {
                baseSubscriber.onNext(ruleConfigResult);
            }
        }

        public void onAfter() {
            super.onAfter();
            boolean unused = n.f83817b = false;
            BaseSubscriber baseSubscriber = this.f83818b;
            if (baseSubscriber != null) {
                baseSubscriber.onAfter();
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            BaseSubscriber baseSubscriber = this.f83818b;
            if (baseSubscriber != null) {
                baseSubscriber.onError(th2);
            }
        }

        public void onStart() {
            super.onStart();
            BaseSubscriber baseSubscriber = this.f83818b;
            if (baseSubscriber != null) {
                baseSubscriber.onStart();
            }
        }
    }

    public static boolean h() {
        if (f83816a != null) {
            return false;
        }
        v();
        return true;
    }

    public static String i(CenterMarketConfigInfo centerMarketConfigInfo) {
        if (centerMarketConfigInfo == null) {
            return "--";
        }
        String symbol = centerMarketConfigInfo.getSymbol();
        if (centerMarketConfigInfo.getBusinessType() == RemindBusinessType.CONTRACT.type) {
            if (centerMarketConfigInfo.getContractType() == RemindContractType.TYPE_CURRENT_WEEK.type) {
                return symbol + "_" + "CW";
            } else if (centerMarketConfigInfo.getContractType() == RemindContractType.TYPE_NEXT_WEEK.type) {
                return symbol + "_" + "NW";
            } else if (centerMarketConfigInfo.getContractType() == RemindContractType.TYPE_CURRENT_SEASON.type) {
                return symbol + "_" + "CQ";
            } else {
                return symbol + "_" + "NQ";
            }
        } else if (centerMarketConfigInfo.getBusinessType() == RemindBusinessType.SWAP.type) {
            return symbol + "-USD";
        } else {
            return symbol + "-USDT";
        }
    }

    public static RuleConfigResult j() {
        return f83816a;
    }

    public static boolean k() {
        return f83816a != null;
    }

    public static boolean l(String str) {
        CustomConfig custom;
        PriceConfig price;
        List<String> symbols;
        if (!TextUtils.isEmpty(str) && !h() && (custom = f83816a.getCustom()) != null && (price = custom.getPrice()) != null && (symbols = price.getSymbols()) != null && !symbols.isEmpty()) {
            for (String equalsIgnoreCase : symbols) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ Observable m(List list) {
        CustomRuleListResult customRuleListResult = new CustomRuleListResult();
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            CenterMarketConfigInfo centerMarketConfigInfo = (CenterMarketConfigInfo) it2.next();
            CustomPriceResp customPriceResp = new CustomPriceResp();
            customPriceResp.setPriceId(centerMarketConfigInfo.getId());
            int i11 = 2;
            if (RemindTriggerType.UP.type == centerMarketConfigInfo.getTriggerType()) {
                i11 = 1;
            }
            customPriceResp.setDirection(i11);
            customPriceResp.setSymbol(i(centerMarketConfigInfo));
            customPriceResp.setPrice(centerMarketConfigInfo.getTriggerPrice());
            customPriceResp.setBusinessType(RemindBusinessType.parse(centerMarketConfigInfo.getBusinessType()));
            customPriceResp.setContractType(RemindContractType.parse(centerMarketConfigInfo.getContractType()));
            arrayList.add(customPriceResp);
        }
        customRuleListResult.setCustomPrice(arrayList);
        return Observable.just(customRuleListResult);
    }

    public static /* synthetic */ Observable n(List list) {
        AllRulesResult allRulesResult = new AllRulesResult();
        CustomRuleResp customRuleResp = new CustomRuleResp();
        CustomPriceInfoResp customPriceInfoResp = new CustomPriceInfoResp();
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            CenterMarketConfigInfo centerMarketConfigInfo = (CenterMarketConfigInfo) it2.next();
            CustomPriceResp customPriceResp = new CustomPriceResp();
            customPriceResp.setPriceId(centerMarketConfigInfo.getId());
            int i11 = 2;
            if (RemindTriggerType.UP.type == centerMarketConfigInfo.getTriggerType()) {
                i11 = 1;
            }
            customPriceResp.setDirection(i11);
            customPriceResp.setSymbol(i(centerMarketConfigInfo));
            customPriceResp.setPrice(centerMarketConfigInfo.getTriggerPrice());
            customPriceResp.setBusinessType(RemindBusinessType.parse(centerMarketConfigInfo.getBusinessType()));
            customPriceResp.setContractType(RemindContractType.parse(centerMarketConfigInfo.getContractType()));
            arrayList.add(customPriceResp);
        }
        customPriceInfoResp.setPrices(arrayList);
        customRuleResp.setPriceInfo(customPriceInfoResp);
        allRulesResult.setCustom(customRuleResp);
        return Observable.just(allRulesResult);
    }

    public static /* synthetic */ Observable o(Integer num) {
        return Observable.just(new RemindCustomSub(num.intValue() == 2));
    }

    public static /* synthetic */ Observable p(CenterMarketConfigContracts centerMarketConfigContracts) {
        RuleConfigResult ruleConfigResult = new RuleConfigResult();
        List<String> symbols = centerMarketConfigContracts.getSystem().getSymbols();
        ruleConfigResult.setSymbolLimit(symbols.size());
        CustomConfig customConfig = new CustomConfig();
        PriceConfig priceConfig = new PriceConfig();
        priceConfig.setSymbols(symbols);
        customConfig.setPrice(priceConfig);
        ruleConfigResult.setCustom(customConfig);
        return Observable.just(ruleConfigResult);
    }

    public static /* synthetic */ Observable q(Integer num) {
        CustomSaveResult customSaveResult = new CustomSaveResult();
        customSaveResult.setPriceId(num.intValue());
        return Observable.just(customSaveResult);
    }

    public static void r(g gVar, Subscriber<CustomRuleListResult> subscriber) {
        q7.a.a().O((String) null, (RemindContractType) null).b().compose(RxJavaHelper.t(gVar)).flatMap(l.f53483b).subscribe(subscriber);
    }

    public static void s(RemindContractType remindContractType, String str, g gVar, Subscriber<AllRulesResult> subscriber) {
        if (!TextUtils.isEmpty(str)) {
            q7.a.a().O(str, remindContractType).b().compose(RxJavaHelper.t(gVar)).flatMap(m.f53484b).subscribe(subscriber);
        }
    }

    public static Observable<RemindCustomSub> t(RemindContractType remindContractType, String str, g gVar) {
        return q7.a.a().H(str, remindContractType).b().compose(RxJavaHelper.t(gVar)).flatMap(k.f53482b);
    }

    public static void u(List<Long> list, g gVar, Subscriber<Object> subscriber) {
        q7.a.a().L(list).b().compose(RxJavaHelper.t(gVar)).subscribe(subscriber);
    }

    public static void v() {
        w((BaseSubscriber<RuleConfigResult>) null);
    }

    public static void w(BaseSubscriber<RuleConfigResult> baseSubscriber) {
        if (gj.d.n().q() && !f83817b) {
            f83817b = true;
            q7.a.a().r().b().compose(RxJavaHelper.t((g) null)).flatMap(i.f53480b).subscribe(new a(baseSubscriber));
        }
    }

    public static void x(RemindContractType remindContractType, RemindBusinessType remindBusinessType, long j11, String str, String str2, boolean z11, g gVar, Subscriber<CustomSaveResult> subscriber) {
        if (!TextUtils.isEmpty(str)) {
            q7.a.a().K(remindBusinessType, str, remindContractType, z11 ? RemindTriggerType.UP : RemindTriggerType.DOWN, str2).b().flatMap(j.f53481b).compose(RxJavaHelper.t(gVar)).subscribe(subscriber);
        }
    }
}
