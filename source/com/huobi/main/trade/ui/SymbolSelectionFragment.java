package com.huobi.main.trade.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.bean.ContractTagInfo;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.bean.Partitions;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.market.MarketModuleConfig;
import com.huawei.hms.push.AttributionReporter;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.main.helper.l;
import com.huobi.otc.dialog.BaseFullBottomSheetFragment;
import com.huobi.utils.StatusBarUtils;
import com.huochat.community.network.domain.DomainTool;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import d7.b1;
import dt.h2;
import i8.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m9.r;
import o6.b;
import pro.huobi.R;
import sl.f0;
import sn.t;
import u6.g;
import us.i;
import us.j;

public class SymbolSelectionFragment extends BaseFullBottomSheetFragment {

    /* renamed from: q  reason: collision with root package name */
    public static List<SymbolPrice> f77792q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    public static List<SymbolPrice> f77793r = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f77794b;

    /* renamed from: c  reason: collision with root package name */
    public rj.b f77795c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<SymbolSelectionFragment> f77796d;

    /* renamed from: e  reason: collision with root package name */
    public f f77797e;

    /* renamed from: f  reason: collision with root package name */
    public List<FutureContractInfo> f77798f;

    /* renamed from: g  reason: collision with root package name */
    public List<SwapCurrencyInfo> f77799g;

    /* renamed from: h  reason: collision with root package name */
    public List<ContractCurrencyInfo> f77800h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f77801i;

    /* renamed from: j  reason: collision with root package name */
    public rj.b f77802j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f77803k = false;

    /* renamed from: l  reason: collision with root package name */
    public TradeType f77804l = TradeType.PRO;

    /* renamed from: m  reason: collision with root package name */
    public f0.b f77805m = new a();

    /* renamed from: n  reason: collision with root package name */
    public k.b f77806n = new b();

    /* renamed from: o  reason: collision with root package name */
    public b.C0747b f77807o = new c();

    /* renamed from: p  reason: collision with root package name */
    public r.b f77808p = new d();

    public class a implements f0.b {
        public a() {
        }

        public void e(List<SymbolPrice> list) {
            SymbolSelectionFragment.this.Jh(list, false);
        }

        public void onSuccess(List<SymbolPrice> list) {
        }
    }

    public class b implements k.b {
        public b() {
        }

        public void e(List<SymbolPrice> list) {
            SymbolSelectionFragment.this.Jh(list, true);
        }

        public void onSuccess(List<SymbolPrice> list) {
        }
    }

    public class c implements b.C0747b {
        public c() {
        }

        public void e(List<SymbolPrice> list) {
            List unused = SymbolSelectionFragment.f77792q = list;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            arrayList.addAll(SymbolSelectionFragment.f77793r);
            SymbolSelectionFragment.this.Jh(arrayList, true);
        }

        public void onSuccess(List<SymbolPrice> list) {
        }
    }

    public class d implements r.b {
        public d() {
        }

        public void e(List<SymbolPrice> list) {
            List unused = SymbolSelectionFragment.f77793r = list;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            arrayList.addAll(SymbolSelectionFragment.f77792q);
            SymbolSelectionFragment.this.Jh(arrayList, true);
        }

        public void onSuccess(List<SymbolPrice> list) {
        }
    }

    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f77813a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f77813a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SUPERMARGIN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f77813a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.MARGIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f77813a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f77813a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f77813a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f77813a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.COPY_TRADING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f77813a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.main.trade.ui.SymbolSelectionFragment.e.<clinit>():void");
        }
    }

    public interface f {
        void a(TradeType tradeType, String str, Object obj);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hh(BalanceDataTotal balanceDataTotal) {
        List<? extends BaseAssetInfo> detailInfos = balanceDataTotal.getDetailInfos();
        if (detailInfos != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<? extends BaseAssetInfo> it2 = detailInfos.iterator();
            while (it2.hasNext()) {
                BalanceDetailInfo balanceDetailInfo = (BalanceDetailInfo) it2.next();
                if (balanceDetailInfo != null && !BaseAssetInfo.isMinAmountAsset(balanceDetailInfo.getEstimateAmountToBtc())) {
                    jSONArray.add(balanceDetailInfo);
                }
            }
            rj.b bVar = this.f77795c;
            bVar.I("sendSpotHoldCoins(" + jSONArray.toJSONString() + ")");
        }
    }

    public static Double wh(SymbolPrice symbolPrice) {
        Double close = symbolPrice.getClose();
        Double open = symbolPrice.getOpen();
        double doubleValue = open != null ? close.doubleValue() - open.doubleValue() : 0.0d;
        if (Double.compare(close.doubleValue(), 0.0d) != 0) {
            return Double.valueOf((doubleValue / open.doubleValue()) * 100.0d);
        }
        return null;
    }

    public void Ah(String str, String str2, boolean z11) {
        if (getActivity() == null || getActivity().isFinishing() || this.f77804l != TradeType.COPY_TRADING) {
            f fVar = this.f77797e;
            if (fVar != null) {
                TradeType tradeType = this.f77804l;
                fVar.a(tradeType, str, vh(tradeType, str2, z11));
                return;
            }
            return;
        }
        rj.b bVar = this.f77802j;
        bVar.I("onSymbolChange('" + str2 + "')");
    }

    public final void Bh(JSONObject jSONObject) {
        List<String> list;
        JSONArray jSONArray = new JSONArray();
        List<FutureContractInfo> f11 = FutureContractInfoController.n().f();
        this.f77798f = f11;
        if (f11 == null || f11.size() == 0) {
            FutureContractInfoController.n().i(TradeType.LINEAR_SWAP, false).compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
        }
        if (this.f77804l == TradeType.COPY_TRADING) {
            list = this.f77801i;
        } else {
            list = FutureContractInfoController.n().t(TradeType.LINEAR_SWAP);
        }
        for (String next : list) {
            List<FutureContractInfo> list2 = this.f77798f;
            if (list2 != null) {
                for (FutureContractInfo next2 : list2) {
                    TradeType tradeType = this.f77804l;
                    TradeType tradeType2 = TradeType.COPY_TRADING;
                    if ((tradeType == tradeType2 && next2.contractShortType.equals(next)) || next2.getSymbol().equals(next)) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("symbol", (Object) this.f77804l == tradeType2 ? next.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0] : next);
                        jSONObject2.put("contractShortType", (Object) next2.getContractShortType());
                        jSONObject2.put("priceTickPrecision", (Object) Integer.valueOf(FuturePrecisionUtil.y(next2.getContractCode(), next2.getContractShortType(), next2.getOptionCode())));
                        jSONObject2.put("contractName", (Object) a7.e.p(getContext(), next2.getSymbol(), next2.getQuoteCurrency()));
                        jSONObject2.put("swapQuoteCurrency", (Object) a7.e.r(getContext(), next2.getContractCode(), next2.getContractType()));
                        jSONObject2.put("isSwap", (Object) Boolean.valueOf(next2.isLinearSwapSwap()));
                        SymbolPrice symbolPrice = k.g().h().get(next2.getContractShortType());
                        if (symbolPrice != null) {
                            jSONObject2.put("decimalcPrice", (Object) symbolPrice.getClose());
                            jSONObject2.put("decimalDelta", (Object) wh(symbolPrice));
                        }
                        jSONArray.add(jSONObject2);
                    }
                }
            }
        }
        if (this.f77804l == TradeType.COPY_TRADING) {
            jSONObject.put("copyTradingModels", (Object) jSONArray);
        } else {
            jSONObject.put("linearSwapModels", (Object) jSONArray);
        }
        JSONObject jSONObject3 = new JSONObject();
        long Y = MarketModuleConfig.a().Y();
        long T = MarketModuleConfig.a().T();
        jSONObject3.put("swapMaintain", (Object) Boolean.valueOf(bj.d.x()));
        jSONObject3.put("swapMaintainRecoveryText", (Object) String.format(getString(R.string.n_swap_contract_maintenance_tips), new Object[]{DateTimeUtils.h(T, "yyyy/MM/dd HH:mm")}));
        jSONObject3.put("contractMaintain", (Object) Boolean.valueOf(bj.d.s()));
        jSONObject3.put("contractMaintainRecoveryText", (Object) String.format(getString(R.string.n_delivery_contract_maintenance_tips), new Object[]{DateTimeUtils.h(Y, "yyyy/MM/dd HH:mm")}));
        jSONObject3.put("linearSwapMaintain", (Object) Boolean.valueOf(bj.d.t()));
        jSONObject3.put("linearSwapMaintainRecoveryText", (Object) String.format(getString(R.string.n_contract_maintenance_tips), new Object[]{DateTimeUtils.h(MarketModuleConfig.a().p(), "yyyy/MM/dd HH:mm")}));
        jSONObject.put("contractMaintainStatus", (Object) jSONObject3);
    }

    public final JSONObject Ch(Map<String, SymbolBean> map, Map<String, SymbolBean> map2) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (String next : map.keySet()) {
                jSONObject.put(next, (Object) Fh(map.get(next), true, (map2 != null ? map2.remove(next) : null) != null));
            }
        }
        if (map2 != null) {
            for (String next2 : map2.keySet()) {
                jSONObject.put(next2, (Object) Fh(map.get(next2), false, true));
            }
        }
        for (SymbolPrice next3 : f0.g().f()) {
            if (jSONObject.containsKey(next3.getSymbol())) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(next3.getSymbol());
                jSONObject2.put("decimalcPrice", (Object) next3.getClose());
                jSONObject2.put("decimalDelta", (Object) next3.getRise() == null ? null : Double.valueOf(next3.getRise().doubleValue() * 100.0d));
                jSONObject.put(next3.getSymbol(), (Object) jSONObject2);
            }
        }
        return jSONObject;
    }

    public final void Dh() {
        if (this.f77804l == TradeType.PRO && tg.r.x().F0()) {
            h2.t1().K1(true).retry(3).doOnNext(new eo.b(this)).compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
        }
    }

    public final int Eh(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1852006340:
                if (str.equals(SymbolBean.SUSPEND)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1548612125:
                if (str.equals(SymbolBean.OFFLINE)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1012222381:
                if (str.equals(SymbolBean.ONLINE)) {
                    c11 = 2;
                    break;
                }
                break;
            case -225132355:
                if (str.equals(SymbolBean.PRE_ONLINE)) {
                    c11 = 3;
                    break;
                }
                break;
            case 544136836:
                if (str.equals(SymbolBean.TRANSFER_BOARD)) {
                    c11 = 4;
                    break;
                }
                break;
            case 1667641997:
                if (str.equals(SymbolBean.NOT_ONLINE)) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 4;
            case 1:
                return 5;
            case 2:
                return 3;
            case 3:
                return 2;
            case 4:
                return 6;
            case 5:
                return 1;
            default:
                return 0;
        }
    }

    public final JSONObject Fh(SymbolBean symbolBean, boolean z11, boolean z12) {
        JSONObject jSONObject = new JSONObject();
        if (symbolBean == null) {
            return jSONObject;
        }
        jSONObject.put("state", (Object) Integer.valueOf(Eh(symbolBean.getState())));
        jSONObject.put("symbol", (Object) symbolBean.getSymbol());
        jSONObject.put("baseCurrency", (Object) symbolBean.getBaseCurrency());
        jSONObject.put("quoteCurrency", (Object) symbolBean.getQuoteCurrency());
        jSONObject.put("baseCurrencyDisplayName", (Object) symbolBean.getBaseCurrencyDisplayName());
        jSONObject.put("quoteCurrencyDisplayName", (Object) symbolBean.getQuoteCurrencyDisplayName());
        jSONObject.put("quoteTitle", (Object) symbolBean.getQuoteCurrencyDisplayName());
        jSONObject.put("symbolName", (Object) symbolBean.getSymbolName());
        jSONObject.put("weight", (Object) Integer.valueOf(symbolBean.getWeight()));
        jSONObject.put("visitEnabled", (Object) Boolean.valueOf(!SymbolBean.OFFLINE.equals(symbolBean.getState())));
        jSONObject.put("tradePricePrecision", (Object) Integer.valueOf(symbolBean.getTradePricePrecision()));
        jSONObject.put("loanEnabled", (Object) Boolean.valueOf(z11));
        jSONObject.put("loanRatio", (Object) symbolBean.getLeverageRatio());
        jSONObject.put("superLoanEnabled", (Object) Boolean.valueOf(z12));
        jSONObject.put("superLoanRatio", (Object) symbolBean.getSuperMarginLeverageRatio());
        jSONObject.put("isSt", (Object) Boolean.valueOf(symbolBean.isStTag()));
        jSONObject.put("isHad", (Object) Boolean.valueOf(symbolBean.isHadSt()));
        jSONObject.put("isAlts", (Object) Boolean.valueOf(symbolBean.isAltsTag()));
        jSONObject.put("isFiat", (Object) Boolean.valueOf(symbolBean.isFiatTag()));
        jSONObject.put("isCrypto", (Object) Boolean.valueOf(symbolBean.isCryptoTag()));
        jSONObject.put("isETP", (Object) Boolean.valueOf(symbolBean.isEtpTag()));
        jSONObject.put("isZeroFee", (Object) Boolean.valueOf(symbolBean.isZerofeeTag()));
        jSONObject.put("isPrime", (Object) Boolean.valueOf(symbolBean.isPrimeTag()));
        jSONObject.put("isPrimeLite", (Object) Boolean.valueOf(b1.a().b().d(symbolBean.getSymbol())));
        jSONObject.put("isPrimeTransfer", (Object) Boolean.FALSE);
        if (symbolBean.getPartitions() != null) {
            JSONArray jSONArray = new JSONArray();
            for (Partitions next : symbolBean.getPartitions()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("partitionId", (Object) next.f70614id);
                jSONObject2.put("name", (Object) next.name);
                jSONObject2.put("weight", (Object) next.weight);
                jSONArray.add(jSONObject2);
            }
            jSONObject.put("partitions", (Object) jSONArray);
        }
        return jSONObject;
    }

    public final JSONObject Gh(List<SymbolBean> list, boolean z11, boolean z12) {
        JSONObject jSONObject = new JSONObject();
        List<SymbolPrice> f11 = f0.g().f();
        for (SymbolBean next : list) {
            jSONObject.put(next.getSymbol(), (Object) Fh(next, z11, z12));
        }
        for (SymbolPrice next2 : f11) {
            if (jSONObject.containsKey(next2.getSymbol())) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(next2.getSymbol());
                jSONObject2.put("decimalcPrice", (Object) next2.getClose());
                jSONObject2.put("decimalDelta", (Object) next2.getRise() == null ? null : Double.valueOf(next2.getRise().doubleValue() * 100.0d));
                jSONObject.put(next2.getSymbol(), (Object) jSONObject2);
            }
        }
        return jSONObject;
    }

    public final void Ih(rj.b bVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("h5Url", (Object) BaseModuleConfig.a().j());
        jSONObject.put("priceColorType", (Object) Integer.valueOf(w.l() ^ true ? 1 : 0));
        boolean g11 = NightHelper.e().g();
        if (this.f77803k) {
            g11 = !KLineHelper.f();
        }
        jSONObject.put("colorMode", (Object) Integer.valueOf(g11 ? 1 : 0));
        jSONObject.put("iconURLHost", (Object) AssetModuleConfig.a().j().replace(DomainTool.DOMAIN_PREFIX, ""));
        jSONObject.put("iconPlaceholder", (Object) "");
        jSONObject.put("OS", (Object) 1);
        jSONObject.put("isLogin", (Object) Integer.valueOf(tg.r.x().F0() ? 1 : 0));
        jSONObject.put("bottomSafeAreaHeight", (Object) 0);
        jSONObject.put(AttributionReporter.APP_VERSION, (Object) 105400);
        jSONObject.put("language", (Object) p.a(getActivity()).toLowerCase());
        jSONObject.put("webUrl", (Object) BaseModuleConfig.a().j());
        jSONObject.put("statusHeight", (Object) Float.valueOf((float) PixelUtils.h((float) StatusBarUtils.a(getActivity()))));
        jSONObject.put("countryId", (Object) sn.a.c().a());
        jSONObject.put("isChild", (Object) tg.r.x().X() ? "1" : "0");
        bVar.I("sendCommonConfig(" + jSONObject.toJSONString() + ")");
    }

    public final void Jh(List<SymbolPrice> list, boolean z11) {
        if (this.f77795c != null && !mz.a.g(list)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            for (SymbolPrice next : list) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("decimalcPrice", (Object) next.getClose());
                if (z11) {
                    jSONObject3.put("decimalDelta", (Object) wh(next));
                } else {
                    jSONObject3.put("decimalDelta", (Object) next.getRise() == null ? null : Double.valueOf(next.getRise().doubleValue() * 100.0d));
                }
                jSONObject2.put(next.getSymbol(), (Object) jSONObject3);
            }
            jSONObject.put("data", (Object) jSONObject2);
            rj.b bVar = this.f77795c;
            bVar.I("sendSocketData(" + jSONObject.toJSONString() + ")");
        }
    }

    public void Kh(f fVar) {
        this.f77797e = fVar;
    }

    public void Lh(List<String> list) {
        this.f77801i = list;
    }

    public void Mh(rj.b bVar) {
        this.f77802j = bVar;
    }

    public final void Nh(TradeType tradeType) {
        this.f77804l = tradeType;
    }

    public void Oh(FragmentManager fragmentManager, String str, TradeType tradeType) {
        if (tradeType != null) {
            switch (e.f77813a[tradeType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    tradeType = TradeType.PRO;
                    break;
            }
        } else {
            tradeType = TradeType.PRO;
        }
        Nh(tradeType);
        super.show(fragmentManager, str);
    }

    public void Ph(FragmentManager fragmentManager, String str, TradeType tradeType, boolean z11) {
        if (tradeType != null) {
            switch (e.f77813a[tradeType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    tradeType = TradeType.PRO;
                    break;
            }
        } else {
            tradeType = TradeType.PRO;
        }
        Nh(tradeType);
        this.f77803k = z11;
        super.show(fragmentManager, str);
    }

    public final void Qh(boolean z11) {
        if (z11) {
            switch (e.f77813a[this.f77804l.ordinal()]) {
                case 1:
                case 2:
                case 7:
                    f0.g().e("SYMBOL_SELECTION_DATA_TAG", this.f77805m);
                    f0.g().i();
                    return;
                case 3:
                case 4:
                    o6.b.g().e("SYMBOL_SELECTION_DATA_TAG", this.f77807o);
                    o6.b.g().i();
                    r.g().e("SYMBOL_SELECTION_DATA_TAG", this.f77808p);
                    r.g().i();
                    return;
                case 5:
                case 6:
                    k.g().e("SYMBOL_SELECTION_DATA_TAG", this.f77806n);
                    k.g().i();
                    return;
                default:
                    return;
            }
        } else {
            f0.g().j("SYMBOL_SELECTION_DATA_TAG");
            f0.g().n();
            k.g().j("SYMBOL_SELECTION_DATA_TAG");
            k.g().n();
            o6.b.g().j("SYMBOL_SELECTION_DATA_TAG");
            o6.b.g().n();
            r.g().j("SYMBOL_SELECTION_DATA_TAG");
            r.g().n();
        }
    }

    public boolean getHideAble() {
        return true;
    }

    public int getPeekHeight() {
        return (getResources().getDisplayMetrics().heightPixels - StatusBarUtils.a(getContext())) - PixelUtils.a(20.0f);
    }

    public void initView(View view) {
        this.f77794b = (ViewGroup) view.findViewById(R.id.symbol_selection_root);
        this.f77796d = new WeakReference<>(this);
        rj.b bVar = new rj.b(getActivity(), "symbolselection");
        this.f77795c = bVar;
        bVar.s(TUIConstants.TUIChat.FRAGMENT, this.f77796d);
        this.f77795c.H();
        Qh(true);
        Ih(this.f77795c);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        int i11 = 0;
        switch (e.f77813a[this.f77804l.ordinal()]) {
            case 1:
                jSONObject2 = Ch(a1.v().V(TradeType.MARGIN), a1.v().V(TradeType.SUPERMARGIN));
                i11 = 1;
                break;
            case 2:
                jSONObject2 = Ch(a1.v().V(TradeType.MARGIN), a1.v().V(TradeType.SUPERMARGIN));
                i11 = 2;
                break;
            case 3:
            case 4:
                xh(jSONObject);
                yh(jSONObject);
                i11 = 3;
                break;
            case 5:
                Bh(jSONObject);
                yh(jSONObject);
                i11 = 4;
                break;
            case 6:
                Bh(jSONObject);
                yh(jSONObject);
                i11 = 5;
                break;
            default:
                jSONObject2 = Gh(a1.v().Z(TradeType.PRO), false, false);
                break;
        }
        jSONObject.put("symbolDic", (Object) jSONObject2);
        jSONObject.put("oriFavorites", JSON.toJSON(t.r()));
        Map<String, CurrencyBean> u11 = d7.k.C().u();
        JSONObject jSONObject3 = new JSONObject();
        for (String next : u11.keySet()) {
            CurrencyBean currencyBean = u11.get(next);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("displayName", (Object) currencyBean.getDisplayName());
            jSONObject4.put("weight", (Object) currencyBean.getWeight());
            jSONObject3.put(next, (Object) jSONObject4);
        }
        jSONObject.put("coinsDic", (Object) jSONObject3);
        jSONObject.put("originTradeType", (Object) Integer.valueOf(i11));
        jSONObject.put("isKLine", (Object) 1);
        this.f77795c.t("symbolBridge", SymbolSelectionAbility.class);
        this.f77795c.I("sendSymbols(" + jSONObject.toJSONString() + ")");
        this.f77794b.addView(this.f77795c.D("symbol_menu.xml", getContext()));
        this.f77795c.I("start()");
        Dh();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_symbol_selection, (ViewGroup) null);
        onCreateDialog.setContentView(inflate);
        initView(inflate);
        return onCreateDialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        Qh(false);
        this.f77795c.B();
        this.f77796d.clear();
        this.f77796d = null;
        l.c().a();
    }

    public void onStart() {
        super.onStart();
    }

    public final Object vh(TradeType tradeType, String str, boolean z11) {
        List<FutureContractInfo> list;
        int i11 = e.f77813a[tradeType.ordinal()];
        if (i11 == 3 || i11 == 4) {
            if (z11) {
                List<SwapCurrencyInfo> list2 = this.f77799g;
                if (list2 == null) {
                    return null;
                }
                for (SwapCurrencyInfo next : list2) {
                    if (TextUtils.equals(str, next.getContractShortType())) {
                        return next;
                    }
                }
            } else {
                List<ContractCurrencyInfo> list3 = this.f77800h;
                if (list3 == null) {
                    return null;
                }
                for (ContractCurrencyInfo next2 : list3) {
                    if (TextUtils.equals(str, next2.getContractShortType())) {
                        return next2;
                    }
                }
            }
            return null;
        } else if (i11 != 5 || (list = this.f77798f) == null) {
            return null;
        } else {
            for (FutureContractInfo next3 : list) {
                if (TextUtils.equals(str, next3.getContractShortType())) {
                    return next3;
                }
            }
            return null;
        }
    }

    public final void xh(JSONObject jSONObject) {
        String str;
        String str2;
        Iterator it2;
        Iterator<String> it3;
        JSONObject jSONObject2 = jSONObject;
        JSONArray jSONArray = new JSONArray();
        List<SwapCurrencyInfo> e11 = SwapCurrencyInfoController.k().e();
        this.f77799g = e11;
        String str3 = "contractName";
        String str4 = "priceTickPrecision";
        if (e11 != null) {
            Iterator<String> it4 = SwapCurrencyInfoController.k().r().iterator();
            while (it4.hasNext()) {
                String next = it4.next();
                for (SwapCurrencyInfo next2 : this.f77799g) {
                    if (next2.getSymbol().equals(next)) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("symbol", (Object) next);
                        it3 = it4;
                        jSONObject3.put("contractShortType", (Object) next2.getContractShortType());
                        jSONObject3.put(str4, (Object) Integer.valueOf(i.o(next2.getSymbol())));
                        jSONObject3.put(str3, (Object) j.i(next2.getSymbol()));
                        jSONObject3.put("swapQuoteCurrency", (Object) j.j(getContext()));
                        jSONObject3.put("isSwap", (Object) Boolean.TRUE);
                        SymbolPrice symbolPrice = r.g().h().get(next2.getContractShortType());
                        if (symbolPrice != null) {
                            jSONObject3.put("decimalcPrice", (Object) symbolPrice.getClose());
                            jSONObject3.put("decimalDelta", (Object) wh(symbolPrice));
                        }
                        jSONArray.add(jSONObject3);
                    } else {
                        it3 = it4;
                    }
                    it4 = it3;
                }
            }
        }
        jSONObject2.put("swapModels", (Object) jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        List<ContractCurrencyInfo> m11 = ContractCurrencyUtils.m();
        this.f77800h = m11;
        if (m11 != null) {
            Iterator it5 = ContractCurrencyUtils.l().iterator();
            while (it5.hasNext()) {
                String str5 = (String) it5.next();
                for (ContractCurrencyInfo next3 : this.f77800h) {
                    if (next3.getSymbol().equals(str5)) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("symbol", (Object) str5);
                        it2 = it5;
                        jSONObject4.put("contractShortType", (Object) next3.getContractShortType());
                        jSONObject4.put(str4, (Object) Integer.valueOf(ej.f.p(next3.getContractCode())));
                        str2 = str4;
                        jSONObject4.put(str3, (Object) ej.g.i(getContext(), next3.getSymbol()));
                        str = str3;
                        jSONObject4.put("swapQuoteCurrency", (Object) ej.g.k(getContext(), next3.getContractCode(), next3.getContractType()));
                        jSONObject4.put("isSwap", (Object) Boolean.FALSE);
                        SymbolPrice symbolPrice2 = o6.b.g().h().get(next3.getContractShortType());
                        if (symbolPrice2 != null) {
                            jSONObject4.put("decimalcPrice", (Object) symbolPrice2.getClose());
                            jSONObject4.put("decimalDelta", (Object) wh(symbolPrice2));
                        }
                        jSONArray2.add(jSONObject4);
                    } else {
                        it2 = it5;
                        str = str3;
                        str2 = str4;
                    }
                    it5 = it2;
                    str4 = str2;
                    str3 = str;
                }
            }
        }
        jSONObject2.put("contractModels", (Object) jSONArray2);
        JSONObject jSONObject5 = new JSONObject();
        long Y = MarketModuleConfig.a().Y();
        long T = MarketModuleConfig.a().T();
        jSONObject5.put("swapMaintain", (Object) Boolean.valueOf(bj.d.x()));
        jSONObject5.put("swapMaintainRecoveryText", (Object) String.format(getString(R.string.n_swap_contract_maintenance_tips), new Object[]{DateTimeUtils.h(T, "yyyy/MM/dd HH:mm")}));
        jSONObject5.put("contractMaintain", (Object) Boolean.valueOf(bj.d.s()));
        jSONObject5.put("contractMaintainRecoveryText", (Object) String.format(getString(R.string.n_delivery_contract_maintenance_tips), new Object[]{DateTimeUtils.h(Y, "yyyy/MM/dd HH:mm")}));
        jSONObject5.put("linearSwapMaintain", (Object) Boolean.valueOf(bj.d.t()));
        jSONObject5.put("linearSwapMaintainRecoveryText", (Object) String.format(getString(R.string.n_contract_maintenance_tips), new Object[]{DateTimeUtils.h(MarketModuleConfig.a().p(), "yyyy/MM/dd HH:mm")}));
        jSONObject2.put("contractMaintainStatus", (Object) jSONObject5);
    }

    public final void yh(JSONObject jSONObject) {
        ContractTagInfo c11 = com.huobi.utils.w.d().c();
        JSONArray jSONArray = new JSONArray();
        if (!(c11 == null || c11.getTagsGroup() == null)) {
            for (ContractTagInfo.TagsGroupInfo next : c11.getTagsGroup()) {
                if (!(next == null || next.e() == null)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("tagGroupId", (Object) next.c());
                    jSONObject2.put("frontTagGroupId", (Object) next.b());
                    jSONObject2.put("tagGroupName", (Object) next.d());
                    JSONArray jSONArray2 = new JSONArray();
                    for (ContractTagInfo.TagsGroupInfo.TagInfo next2 : next.e()) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("tagId", (Object) next2.f());
                        jSONObject3.put("frontTagId", (Object) next2.b());
                        jSONObject3.put(com.tencent.android.tpush.common.Constants.FLAG_TAG_NAME, (Object) next2.h());
                        jSONObject3.put("tagLink", (Object) next2.g());
                        jSONObject3.put("productIds", JSON.toJSON(next2.e()));
                        jSONObject3.put("frontTagUrl", (Object) next2.c());
                        jSONObject3.put("isMarketShow", (Object) Boolean.valueOf("true".equals(next2.d())));
                        jSONArray2.add(jSONObject3);
                    }
                    jSONObject2.put(InnerShareParams.TAGS, (Object) jSONArray2);
                    jSONArray.add(jSONObject2);
                }
            }
        }
        jSONObject.put("oriContractTags", (Object) jSONArray);
    }

    public void zh(String str, TradeType tradeType, String str2, boolean z11) {
        f fVar = this.f77797e;
        if (fVar != null) {
            fVar.a(tradeType, str, vh(tradeType, str2, z11));
        }
    }
}
