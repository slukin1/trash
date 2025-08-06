package com.huobi.engineutils.ability;

import al.p;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.gson.Gson;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$string;
import com.huobi.account.entity.AccountType;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.AbstractAbility;
import com.huobi.engineutils.bean.LongAssetLevelData;
import com.huobi.engineutils.bean.ShortAssetLevelData;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.MarginBalanceDataTotal;
import com.huobi.finance.bean.MarginBalanceDetailInfo;
import com.huobi.finance.bean.SuperMarginDataTotal;
import com.huobi.finance.bean.SuperMarginDetailInfo;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.share.AssetShareHelper;
import com.tencent.android.tpush.common.Constants;
import d7.q0;
import dt.h2;
import i6.k;
import i6.m;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;
import qh.i0;
import rx.schedulers.Schedulers;
import u6.g;
import uh.i;

public class EngineCurrencyCommonAbility extends AbstractAbility {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f44529a;

    public class a extends BaseSubscriber<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbilityFunction.a f44530b;

        public a(AbilityFunction.a aVar) {
            this.f44530b = aVar;
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            this.f44530b.a(true, bool);
        }

        public void onAfter() {
            super.onAfter();
            this.f44530b.a(true, Boolean.FALSE);
        }
    }

    public class b extends BaseSubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbilityFunction.a f44532b;

        public b(AbilityFunction.a aVar) {
            this.f44532b = aVar;
        }

        public void onAfter() {
            super.onAfter();
            this.f44532b.a(false, "");
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            this.f44532b.a(true, l11.toString());
        }
    }

    public class c implements AssetShareHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ double f44534a;

        public c(double d11) {
            this.f44534a = d11;
        }

        public int a() {
            return -1;
        }

        public int b() {
            if (this.f44534a >= 0.0d) {
                return R$drawable.share_asset_style_1;
            }
            return R$drawable.share_asset_style_2;
        }

        public int c() {
            double d11 = this.f44534a;
            if (d11 == 0.0d) {
                return R$string.n_asset_share_total_same;
            }
            if (d11 > 0.0d) {
                return R$string.n_asset_share_total_great;
            }
            return R$string.n_asset_share_total_less;
        }
    }

    public class d extends BaseSubscriber<MarginBalanceDataTotal> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f44536b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbilityFunction.a f44537c;

        public d(Context context, AbilityFunction.a aVar) {
            this.f44536b = context;
            this.f44537c = aVar;
        }

        /* renamed from: a */
        public void onNext(MarginBalanceDataTotal marginBalanceDataTotal) {
            ArrayList arrayList = new ArrayList();
            if (marginBalanceDataTotal != null && !CollectionsUtils.b(marginBalanceDataTotal.getDetailInfos())) {
                for (BaseAssetInfo baseAssetInfo : marginBalanceDataTotal.getDetailInfos()) {
                    if (baseAssetInfo instanceof MarginBalanceDetailInfo) {
                        MarginBalanceDetailInfo marginBalanceDetailInfo = (MarginBalanceDetailInfo) baseAssetInfo;
                        ShortAssetLevelData shortAssetLevelData = new ShortAssetLevelData();
                        String baseCurrency = marginBalanceDetailInfo.getBaseCurrency();
                        String quoteCurrency = marginBalanceDetailInfo.getQuoteCurrency();
                        String j11 = p.j(marginBalanceDetailInfo.getBaseCurrencyLoaned(), baseCurrency);
                        String j12 = p.j(marginBalanceDetailInfo.getQuoteCurrencyLoaned(), quoteCurrency);
                        String j13 = p.j(marginBalanceDetailInfo.getBaseCurrencyOnorders(), baseCurrency);
                        String j14 = p.j(marginBalanceDetailInfo.getQuoteCurrencyOnorders(), quoteCurrency);
                        shortAssetLevelData.setSymbolIcon(p.l(baseCurrency));
                        shortAssetLevelData.setCurrency(marginBalanceDetailInfo.getSymbol());
                        shortAssetLevelData.setBaseCurrency(baseCurrency);
                        shortAssetLevelData.setQuoteCurrency(quoteCurrency);
                        shortAssetLevelData.setBaseCurrencyDisplayName(marginBalanceDetailInfo.getBaseCurrencyDisplayName());
                        shortAssetLevelData.setQuoteCurrencyDisplayName(marginBalanceDetailInfo.getQuoteCurrencyDisplayName());
                        shortAssetLevelData.setDisplayName(marginBalanceDetailInfo.getBaseCurrencyDisplayName() + "/" + marginBalanceDetailInfo.getQuoteCurrencyDisplayName());
                        shortAssetLevelData.setBaseAvailable(p.j(marginBalanceDetailInfo.getBaseCurrencyAvaiable(), baseCurrency));
                        shortAssetLevelData.setQuoteAvailable(p.j(marginBalanceDetailInfo.getQuoteCurrencyAvaiable(), quoteCurrency));
                        shortAssetLevelData.setBaseFreeze(j13);
                        shortAssetLevelData.setQuoteFreeze(j14);
                        shortAssetLevelData.setBaseBorrowed(j11);
                        shortAssetLevelData.setQuoteBorrowed(j12);
                        shortAssetLevelData.setRiskRate(marginBalanceDetailInfo.getRiskRate());
                        shortAssetLevelData.setMarginEquivalent(p.h(m.a(EngineCurrencyCommonAbility.this.m(baseCurrency, marginBalanceDetailInfo.getBaseCurrencyAvaiable())).add(m.a(EngineCurrencyCommonAbility.this.m(quoteCurrency, marginBalanceDetailInfo.getQuoteCurrencyAvaiable()))).toPlainString()));
                        MarginBalanceQueryData marginBalanceQueryData = marginBalanceDetailInfo.getMarginBalanceQueryData();
                        String riskState = marginBalanceQueryData != null ? marginBalanceQueryData.getRiskState() : "3";
                        String plainString = m.a(marginBalanceDetailInfo.getBaseCurrencyAvaiable()).add(m.a(marginBalanceDetailInfo.getBaseCurrencyOnorders())).subtract(m.a(marginBalanceDetailInfo.getBaseCurrencyLoaned())).toPlainString();
                        String plainString2 = m.a(marginBalanceDetailInfo.getQuoteCurrencyAvaiable()).add(m.a(marginBalanceDetailInfo.getQuoteCurrencyOnorders())).subtract(m.a(marginBalanceDetailInfo.getQuoteCurrencyLoaned())).toPlainString();
                        shortAssetLevelData.setBaseEstimation(plainString);
                        shortAssetLevelData.setQuoteEstimation(plainString2);
                        shortAssetLevelData.setRiskRateState(riskState);
                        shortAssetLevelData.setRiskRateStateText(EngineCurrencyCommonAbility.this.n(this.f44536b, riskState));
                        shortAssetLevelData.setRiskRateStateColor(EngineCurrencyCommonAbility.this.p(this.f44536b, riskState));
                        shortAssetLevelData.setRiskRateStateBg(EngineCurrencyCommonAbility.this.o(this.f44536b, riskState));
                        shortAssetLevelData.setBaseBorrowedAndFreeze(m.a(j11).abs().toPlainString());
                        shortAssetLevelData.setQuoteBorrowedAndFreeze(m.a(j12).abs().toPlainString());
                        arrayList.add(shortAssetLevelData);
                    }
                }
            }
            String json = new Gson().toJson((Object) arrayList);
            k.c("Js Load Level Gson = :" + json);
            this.f44537c.a(true, json);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                this.f44537c.a(false, ((APIStatusErrorException) th2).getErrMsg());
            }
        }
    }

    public class e extends BaseSubscriber<SuperMarginDataTotal> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbilityFunction.a f44539b;

        public e(AbilityFunction.a aVar) {
            this.f44539b = aVar;
        }

        /* renamed from: a */
        public void onNext(SuperMarginDataTotal superMarginDataTotal) {
            ArrayList arrayList = new ArrayList();
            if (superMarginDataTotal != null && !CollectionsUtils.b(superMarginDataTotal.getDetailInfos())) {
                for (BaseAssetInfo baseAssetInfo : superMarginDataTotal.getDetailInfos()) {
                    if (baseAssetInfo instanceof SuperMarginDetailInfo) {
                        LongAssetLevelData longAssetLevelData = new LongAssetLevelData();
                        String currency = baseAssetInfo.getCurrency();
                        longAssetLevelData.setSymbolIcon(p.l(currency));
                        longAssetLevelData.setCurrency(currency);
                        longAssetLevelData.setSymbolName(baseAssetInfo.getDisplayName());
                        longAssetLevelData.setAvailable(p.j(baseAssetInfo.getAvaialAble(), baseAssetInfo.getCurrency()));
                        longAssetLevelData.setAvailableEquivalent(EngineCurrencyCommonAbility.this.m(currency, baseAssetInfo.getAvaialAble()));
                        String loan = ((SuperMarginDetailInfo) baseAssetInfo).getLoan();
                        longAssetLevelData.setBorrowed(p.j(m.a(loan).abs().toPlainString(), longAssetLevelData.getCurrency()));
                        longAssetLevelData.setFreeze(p.h(m.a(baseAssetInfo.getOnOrders()).toPlainString()));
                        longAssetLevelData.setEstimation(m.a(baseAssetInfo.getAvaialAble()).add(m.a(baseAssetInfo.getOnOrders())).add(m.a(loan)).toPlainString());
                        arrayList.add(longAssetLevelData);
                    }
                }
            }
            String json = new Gson().toJson((Object) arrayList);
            k.c("Js Load Level Gson = :" + json);
            this.f44539b.a(true, json);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                this.f44539b.a(false, ((APIStatusErrorException) th2).getErrMsg());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ int u(int i11, int i12, JSONObject jSONObject, JSONObject jSONObject2) {
        if (i11 == 1) {
            if (i12 == 2) {
                return g(jSONObject.optString("todayProfit"), jSONObject2.optString("todayProfit"));
            }
            if (i12 == 3) {
                return g(jSONObject.optString("todayProfitRate"), jSONObject2.optString("todayProfitRate"));
            }
            if (i12 == 1) {
                return g(jSONObject.optString("sortKey"), jSONObject2.optString("sortKey"));
            }
            return g(jSONObject.optString("sortKey"), jSONObject2.optString("sortKey"));
        } else if (i12 == 2) {
            return g(jSONObject2.optString("todayProfit"), jSONObject.optString("todayProfit"));
        } else {
            if (i12 == 3) {
                return g(jSONObject2.optString("todayProfitRate"), jSONObject.optString("todayProfitRate"));
            }
            if (i12 == 1) {
                return g(jSONObject2.optString("sortKey"), jSONObject.optString("sortKey"));
            }
            return g(jSONObject2.optString("sortKey"), jSONObject.optString("sortKey"));
        }
    }

    public void a(rj.b bVar, Object obj, AbilityFunction.a aVar) {
        ContractCurrencyInfo h11;
        String Q;
        Object obj2 = obj;
        AbilityFunction.a aVar2 = aVar;
        if (aVar2 != null) {
            if (obj2 instanceof String) {
                try {
                    JSONObject jSONObject = new JSONObject((String) obj2);
                    Log.e("Console", jSONObject.toString());
                    int i11 = jSONObject.getInt("type");
                    if (i11 == 30) {
                        jSONObject.getString("symbol");
                        String string = jSONObject.getString("contractCode");
                        String string2 = jSONObject.getString("amount");
                        String string3 = jSONObject.getString("contractType");
                        String string4 = jSONObject.getString("lastPrice");
                        String str = IdManager.DEFAULT_VERSION_NAME;
                        TradeType s11 = s(string3);
                        TradeType tradeType = TradeType.LINEAR_SWAP;
                        if (s11 == tradeType) {
                            FutureContractInfo o11 = FutureContractInfoController.n().o(string);
                            if (o11 != null) {
                                str = o11.getContractFace();
                            }
                        } else if (s11 == TradeType.SWAP) {
                            SwapCurrencyInfo q11 = SwapCurrencyInfoController.k().q(string);
                            if (q11 != null) {
                                str = m.a(q11.getContractFace()).divide(m.a(string4), 12, 1).toPlainString();
                            }
                        } else if (s11 == TradeType.CONTRACT && (h11 = ContractCurrencyUtils.h(string)) != null) {
                            str = m.a(h11.getContractFace()).divide(m.a(string4), 12, 1).toPlainString();
                        }
                        String q12 = q(string2, str);
                        if (s11 == tradeType) {
                            q12 = m.a(q12).multiply(m.a(string4)).toPlainString();
                        }
                        aVar2.a(true, p.i(q12, 4));
                    } else if (i11 == 31) {
                        aVar2.a(true, Boolean.valueOf(i.d().e()));
                    } else if (i11 == 70) {
                        aVar2.a(true, com.hbg.lib.core.util.p.a(bVar.d()).toLowerCase());
                    } else if (i11 == 80) {
                        aVar2.a(true, t(jSONObject.getString(FirebaseAnalytics.Param.CURRENCY), jSONObject.has("amount") ? jSONObject.getString("amount") : "0"));
                    } else if (i11 == 99) {
                        aVar2.a(true, e(jSONObject.getJSONObject("parameter")));
                    } else if (i11 == 100) {
                        aVar2.a(true, f(jSONObject.getJSONObject("parameter")));
                    } else if (i11 == 111) {
                        aVar2.a(true, h(jSONObject.getString(FirebaseAnalytics.Param.CURRENCY), jSONObject.has("amount") ? jSONObject.getString("amount") : "0", jSONObject.has("currencyScale") ? jSONObject.getInt("currencyScale") : 2));
                    } else if (i11 != 112) {
                        Object obj3 = "open";
                        String str2 = "0";
                        Object obj4 = "close";
                        switch (i11) {
                            case 1:
                                aVar2.a(true, h(jSONObject.getString(FirebaseAnalytics.Param.CURRENCY), jSONObject.has("amount") ? jSONObject.getString("amount") : str2, 2));
                                return;
                            case 2:
                                aVar2.a(true, LegalCurrencyConfigUtil.j(jSONObject.getString(FirebaseAnalytics.Param.CURRENCY), LegalCurrencyConfigUtil.d(), jSONObject.getString("const")));
                                return;
                            case 3:
                                aVar2.a(true, LegalCurrencyConfigUtil.y());
                                return;
                            case 4:
                                aVar2.a(true, LegalCurrencyConfigUtil.d());
                                return;
                            case 5:
                                return;
                            case 6:
                                aVar2.a(true, p.l(jSONObject.getString(FirebaseAnalytics.Param.CURRENCY)));
                                return;
                            case 7:
                                String string5 = jSONObject.getString("wordKey");
                                Context d11 = bVar.d();
                                Resources resources = d11.getResources();
                                aVar2.a(true, resources.getString(resources.getIdentifier(string5, "string", d11.getPackageName())));
                                return;
                            case 8:
                                break;
                            case 9:
                                aVar2.a(true, LegalCurrencyConfigUtil.x());
                                return;
                            case 10:
                                boolean u11 = p.u();
                                HashMap hashMap = new HashMap();
                                hashMap.put("status", u11 ? obj3 : obj4);
                                BaseModuleConfig.a().w("app_assets_hide_click", hashMap);
                                aVar2.a(true, Boolean.valueOf(u11));
                                return;
                            case 11:
                                i0.d().f().compose(RxJavaHelper.t((g) null)).subscribe(new a(aVar2));
                                return;
                            case 12:
                                String string6 = jSONObject.getString("rate");
                                if (TextUtils.isEmpty(string6)) {
                                    Q = "--";
                                } else {
                                    Q = m.Q(string6, 2, 1);
                                    if (m.a(Q.replace("%", "").replace("+", "")).compareTo(BigDecimal.ZERO) > 0) {
                                        Q = "+" + Q;
                                    }
                                }
                                aVar2.a(true, Q);
                                return;
                            case 13:
                                aVar2.a(true, p.j(jSONObject.getString("amount"), "btc"));
                                return;
                            case 14:
                                p.v();
                                boolean u12 = p.u();
                                EventBus.d().k(new gh.b(u12));
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("status", u12 ? obj3 : obj4);
                                BaseModuleConfig.a().w("app_assets_hide_click", hashMap2);
                                return;
                            case 15:
                                y(bVar.d(), jSONObject.getString("rate"));
                                BaseModuleConfig.a().w("app_assets_share_click", (HashMap) null);
                                aVar2.a(true, "");
                                return;
                            case 16:
                                aVar2.a(true, k(bVar.d(), jSONObject.getString(Constants.FLAG_ACCOUNT)));
                                return;
                            case 17:
                                aVar2.a(true, r(bVar.d(), jSONObject.getString(Constants.FLAG_ACCOUNT)));
                                return;
                            case 18:
                                aVar2.a(true, String.format(Locale.ENGLISH, bVar.d().getString(com.hbg.module.exchange.R$string.n_grid_strategy_name), new Object[]{jSONObject.getString("name")}));
                                return;
                            case 19:
                                aVar2.a(true, p.j(jSONObject.has("amount") ? jSONObject.getString("amount") : str2, jSONObject.getString(FirebaseAnalytics.Param.CURRENCY)));
                                return;
                            case 20:
                                String string7 = jSONObject.getString("wordKey");
                                String string8 = jSONObject.getString("value");
                                Context d12 = bVar.d();
                                Resources resources2 = d12.getResources();
                                aVar2.a(true, String.format(resources2.getString(resources2.getIdentifier(string7, "string", d12.getPackageName())), new Object[]{string8}));
                                break;
                            case 21:
                                aVar2.a(true, Boolean.valueOf(ti.a.a()));
                                return;
                            case 22:
                                aVar2.a(true, LegalCurrencyConfigUtil.Q("btc", t(jSONObject.getString(FirebaseAnalytics.Param.CURRENCY), jSONObject.has("amount") ? jSONObject.getString("amount") : str2)));
                                return;
                            case 23:
                                FutureContractInfo o12 = FutureContractInfoController.n().o(jSONObject.getString("contractCode"));
                                if (o12 == null) {
                                    aVar2.a(true, "USDT");
                                    return;
                                }
                                String tradePartition = o12.getTradePartition();
                                if (!TextUtils.isEmpty(tradePartition)) {
                                    aVar2.a(true, tradePartition);
                                    return;
                                } else {
                                    aVar2.a(true, "USDT");
                                    return;
                                }
                            default:
                                switch (i11) {
                                    case 50:
                                        h2.t1().b1((TradeType) null, AccountType.otc_options.toString()).subscribeOn(Schedulers.io()).subscribe(new b(aVar2));
                                        return;
                                    case 51:
                                        w(bVar.d(), aVar2);
                                        return;
                                    case 52:
                                        v(aVar2);
                                        return;
                                    case 53:
                                        String string9 = jSONObject.getString("number");
                                        aVar2.a(true, m.c(string9, string9));
                                        return;
                                    case 54:
                                        aVar2.a(true, w.l() ? str2 : "1");
                                        return;
                                    default:
                                        aVar2.a(false, (Object) null);
                                        return;
                                }
                        }
                        String string10 = jSONObject.getString("colorKey");
                        Context d13 = bVar.d();
                        int identifier = d13.getResources().getIdentifier(string10, "color", d13.getPackageName());
                        aVar2.a(true, "#" + Integer.toHexString(ContextCompat.getColor(d13, identifier)));
                    } else {
                        aVar2.a(true, j(jSONObject.getString("amount"), jSONObject.getInt("precision")));
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                    aVar2.a(false, e11.getMessage());
                }
            } else {
                aVar2.a(false, (Object) null);
            }
        }
    }

    public boolean b() {
        return false;
    }

    public final String e(JSONObject jSONObject) {
        try {
            Log.d("assetOptPackage", "parameter : " + jSONObject.toString());
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    int optInt = optJSONObject.optInt("type", -1);
                    String str = "0";
                    if (optInt == 1) {
                        String string = optJSONObject.getString(FirebaseAnalytics.Param.CURRENCY);
                        if (optJSONObject.has("amount")) {
                            str = optJSONObject.getString("amount");
                        }
                        jSONObject2.put(next, (Object) l(string, str));
                    } else if (optInt == 6) {
                        jSONObject2.put(next, (Object) p.l(optJSONObject.getString(FirebaseAnalytics.Param.CURRENCY)));
                    } else if (optInt == 19) {
                        String string2 = optJSONObject.getString(FirebaseAnalytics.Param.CURRENCY);
                        if (optJSONObject.has("amount")) {
                            str = optJSONObject.getString("amount");
                        }
                        jSONObject2.put(next, (Object) p.j(str, string2));
                    } else if (optInt != 111) {
                        jSONObject2.put(next, (Object) "");
                    } else {
                        String string3 = optJSONObject.getString(FirebaseAnalytics.Param.CURRENCY);
                        if (optJSONObject.has("amount")) {
                            str = optJSONObject.getString("amount");
                        }
                        jSONObject2.put(next, (Object) h(string3, str, optJSONObject.has("currencyScale") ? optJSONObject.getInt("currencyScale") : 2));
                    }
                }
            }
            Log.d("assetOptPackage", "result : " + jSONObject2.toJSONString());
            return jSONObject2.toJSONString();
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final String f(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            Log.d("assetOptPackage2", "parameter : " + jSONObject.toString());
            long currentTimeMillis = System.currentTimeMillis();
            JSONArray optJSONArray = jSONObject2.optJSONArray("spotList");
            if (optJSONArray == null) {
                return new JSONObject().toString();
            }
            JSONObject optJSONObject = jSONObject2.has("indexPrice") ? jSONObject2.optJSONObject("indexPrice") : new JSONObject();
            String optString = jSONObject2.optString("searchKey", "");
            boolean optBoolean = jSONObject2.optBoolean("hiddenSmallAsset", false);
            int optInt = jSONObject2.optInt("sortType");
            int optInt2 = jSONObject2.optInt("sortSequence");
            JSONObject jSONObject3 = new JSONObject();
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            ArrayList arrayList2 = arrayList;
            long j11 = currentTimeMillis;
            JSONObject jSONObject4 = jSONObject3;
            i(optJSONArray, hashMap, optString, optBoolean, arrayList, optJSONObject);
            ArrayList arrayList3 = arrayList2;
            try {
                z(arrayList3, optInt2, optInt);
                x(hashMap, optString, arrayList3, optInt2, optBoolean, optJSONObject);
                jSONObject4.put("spotList", new JSONArray(arrayList3));
                jSONObject4.put("currencySymbol", LegalCurrencyConfigUtil.x());
                jSONObject4.put("colorMode", w.l() ? "0" : "1");
                Log.d("assetOptPackage2", "resultJSONObject : " + jSONObject4);
                Log.d("ConsumeTimeTag", "原生总耗时 -------> " + (System.currentTimeMillis() - j11) + "  总数据长度 ： " + arrayList3.size());
                return jSONObject4.toString();
            } catch (Exception e11) {
                e = e11;
                e.printStackTrace();
                Log.d("assetOptPackage2", "Exception : " + e);
                return null;
            }
        } catch (Exception e12) {
            e = e12;
            e.printStackTrace();
            Log.d("assetOptPackage2", "Exception : " + e);
            return null;
        }
    }

    public final int g(String str, String str2) {
        return m.a(str).compareTo(m.a(str2));
    }

    public final String h(String str, String str2, int i11) {
        String d11 = LegalCurrencyConfigUtil.d();
        if ("btc".equals(d11)) {
            return LegalCurrencyConfigUtil.Q("btc", t(str, str2));
        }
        if ("usdt".equals(d11)) {
            return p.i(t(str, str2), 2);
        }
        return LegalCurrencyConfigUtil.c(str, str2, i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x009a, code lost:
        if (i6.m.a(r2).compareTo(wi.a.f48036a) < 0) goto L_0x007e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(org.json.JSONArray r22, java.util.Map<java.lang.String, java.lang.Integer> r23, java.lang.String r24, boolean r25, java.util.List<org.json.JSONObject> r26, org.json.JSONObject r27) throws org.json.JSONException {
        /*
            r21 = this;
            r0 = r21
            r1 = r27
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 0
        L_0x0009:
            int r5 = r22.length()
            if (r4 >= r5) goto L_0x0148
            r5 = r22
            org.json.JSONObject r6 = r5.optJSONObject(r4)
            java.lang.String r7 = "currency"
            java.lang.String r7 = r6.optString(r7)
            java.lang.String r8 = r7.toUpperCase()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            r10 = r23
            r10.put(r8, r9)
            java.lang.String r8 = "positionNum"
            java.lang.String r8 = r6.optString(r8)
            java.lang.String r9 = "usdtAmount"
            java.lang.String r9 = r6.optString(r9)
            java.lang.String r11 = "usdtPrice"
            r6.optString(r11)
            java.lang.String r12 = "todayProfit"
            java.lang.String r12 = r6.optString(r12)
            java.lang.String r13 = "availableNum"
            java.lang.String r13 = r6.optString(r13)
            java.lang.String r14 = "suspense"
            java.lang.String r14 = r6.optString(r14)
            java.lang.String r15 = "avgPositionCost"
            java.lang.String r15 = r6.optString(r15)
            java.lang.String r5 = "avgCost"
            java.lang.String r5 = r6.optString(r5)
            java.lang.String r10 = "profit"
            java.lang.String r10 = r6.optString(r10)
            r16 = r2
            java.lang.String r2 = "currencyScale"
            r3 = 2
            int r2 = r6.optInt(r2, r3)
            r18 = r4
            java.lang.String r4 = "currencyAmountShowScale"
            int r4 = r6.optInt(r4, r3)
            java.lang.String r3 = r7.toUpperCase()
            r19 = r2
            java.lang.String r2 = r24.toUpperCase()
            boolean r2 = r3.contains(r2)
            if (r2 != 0) goto L_0x0082
        L_0x007e:
            r2 = r26
            goto L_0x0142
        L_0x0082:
            java.lang.String r2 = r0.t(r7, r8)
            java.lang.String r3 = "btc"
            java.lang.String r2 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.Q(r3, r2)
            if (r25 == 0) goto L_0x009d
            java.math.BigDecimal r2 = i6.m.a(r2)
            r20 = r3
            java.math.BigDecimal r3 = wi.a.f48036a
            int r2 = r2.compareTo(r3)
            if (r2 >= 0) goto L_0x009f
            goto L_0x007e
        L_0x009d:
            r20 = r3
        L_0x009f:
            java.lang.String r2 = al.p.l(r7)
            java.lang.String r3 = "symbolIcon"
            r6.put(r3, r2)
            java.lang.String r2 = "usdt"
            java.lang.String r3 = r0.l(r2, r9)
            java.lang.String r9 = "equalAmount"
            r6.put(r9, r3)
            java.lang.String r3 = r0.j(r8, r4)
            java.lang.String r9 = "positionNumDisplayNameNew"
            r6.put(r9, r3)
            r3 = 2
            java.lang.String r9 = r0.h(r2, r12, r3)
            java.lang.String r12 = "equalTodayProfit"
            r6.put(r12, r9)
            java.lang.String r9 = r0.j(r13, r4)
            java.lang.String r12 = "spotExAvailable"
            r6.put(r12, r9)
            java.lang.String r4 = r0.j(r14, r4)
            java.lang.String r9 = "spotExDebts"
            r6.put(r9, r4)
            java.lang.String r4 = r0.h(r2, r15, r3)
            java.lang.String r9 = "avgPositionCostParam"
            r6.put(r9, r4)
            java.lang.String r4 = r0.h(r7, r5, r3)
            java.lang.String r5 = "spotExCost"
            r6.put(r5, r4)
            java.lang.String r4 = r0.h(r2, r10, r3)
            java.lang.String r5 = "originSpotExYieldParam"
            r6.put(r5, r4)
            java.lang.String r3 = r0.h(r7, r8, r3)
            java.lang.String r4 = "sortKey"
            r6.put(r4, r3)
            java.lang.String r3 = "currentSpotExpandCurrency"
            java.lang.String r3 = r1.optString(r3)
            boolean r3 = r7.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x013d
            java.lang.String r3 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.d()
            java.lang.String r4 = r1.optString(r11)
            r5 = r19
            java.lang.String r2 = r0.h(r2, r4, r5)
            r5 = r20
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0138
            java.math.BigDecimal r3 = i6.m.a(r4)
            java.math.BigDecimal r4 = java.math.BigDecimal.ZERO
            int r3 = r3.compareTo(r4)
            if (r3 == 0) goto L_0x0138
            java.math.BigDecimal r3 = i6.m.a(r2)
            java.math.BigDecimal r4 = java.math.BigDecimal.ZERO
            int r3 = r3.compareTo(r4)
            if (r3 != 0) goto L_0x0138
            java.lang.String r2 = "<0.00000001"
        L_0x0138:
            java.lang.String r3 = "spotExPrice"
            r6.put(r3, r2)
        L_0x013d:
            r2 = r26
            r2.add(r6)
        L_0x0142:
            int r4 = r18 + 1
            r2 = r16
            goto L_0x0009
        L_0x0148:
            r16 = r2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "数据转换耗时 -------> "
            r1.append(r2)
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r16
            r1.append(r2)
            java.lang.String r2 = "   持仓数据长度 ："
            r1.append(r2)
            int r2 = r22.length()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "ConsumeTimeTag"
            android.util.Log.d(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.engineutils.ability.EngineCurrencyCommonAbility.i(org.json.JSONArray, java.util.Map, java.lang.String, boolean, java.util.List, org.json.JSONObject):void");
    }

    public final String j(String str, int i11) {
        BigDecimal scale = m.a(str).setScale(i11, RoundingMode.DOWN);
        if (m.a(str).compareTo(BigDecimal.ZERO) == 0) {
            return scale.toPlainString();
        }
        StringBuilder sb2 = new StringBuilder("<0.");
        for (int i12 = 0; i12 < i11 - 1; i12++) {
            sb2.append("0");
        }
        sb2.append("1");
        if (scale.compareTo(BigDecimal.ZERO) == 0) {
            return sb2.toString();
        }
        return scale.toPlainString();
    }

    public final String k(Context context, String str) {
        if (context == null) {
            return "";
        }
        if (this.f44529a == null) {
            HashMap hashMap = new HashMap();
            this.f44529a = hashMap;
            hashMap.put("1", context.getResources().getString(R$string.n_title_spot));
            this.f44529a.put("2", context.getResources().getString(R$string.n_title_future));
            this.f44529a.put("3", context.getResources().getString(R$string.n_kline_loan));
            this.f44529a.put("4", context.getResources().getString(R$string.n_asset_ybb_stop_financial));
            this.f44529a.put(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, context.getResources().getString(R$string.n_blance_fiat_assets));
            this.f44529a.put(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL, context.getResources().getString(R$string.n_option));
        }
        if (!this.f44529a.containsKey(str)) {
            return "";
        }
        return this.f44529a.get(str);
    }

    public final String l(String str, String str2) {
        String d11 = LegalCurrencyConfigUtil.d();
        if ("btc".equals(d11)) {
            return LegalCurrencyConfigUtil.Q("btc", t(str, str2));
        }
        if ("usdt".equals(d11)) {
            return p.i(t(str, str2), 2);
        }
        return LegalCurrencyConfigUtil.i(str, str2);
    }

    public final String m(String str, String str2) {
        String d11 = LegalCurrencyConfigUtil.d();
        if ("btc".equals(d11)) {
            return LegalCurrencyConfigUtil.Q("btc", t(str, str2));
        }
        if ("usdt".equals(d11)) {
            return p.j(t(str, str2), "usdt");
        }
        return LegalCurrencyConfigUtil.E(str, str2);
    }

    public String n(Context context, String str) {
        Resources resources = context.getResources();
        int i11 = R$string.margin_risk_safe;
        String string = resources.getString(i11);
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c11 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c11 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c11 = 2;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1444:
                if (str.equals("-1")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return context.getResources().getString(R$string.risk_rate_liquidating);
            case 1:
                return context.getResources().getString(R$string.margin_risk_rate_high_risk);
            case 2:
                return context.getResources().getString(R$string.margin_risk_rate_unsafe);
            case 3:
                return context.getResources().getString(i11);
            case 4:
                return context.getResources().getString(R$string.n_spot_account_wear_risk);
            default:
                return string;
        }
    }

    public String o(Context context, String str) {
        int i11 = R$color.baseColorMajorTheme010;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c11 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c11 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c11 = 2;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1444:
                if (str.equals("-1")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 4:
                i11 = R$color.kline_handicap_background_red;
                break;
            case 2:
                i11 = R$color.color_1AFE8731;
                break;
        }
        return "#" + Integer.toHexString(ContextCompat.getColor(context, i11));
    }

    public String p(Context context, String str) {
        int i11 = R$color.baseColorMajorTheme100;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c11 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c11 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c11 = 2;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1444:
                if (str.equals("-1")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                i11 = R$color.baseColorShadeButtonRedStart;
                break;
            case 1:
                i11 = R$color.baseColorShadeButtonRedStart;
                break;
            case 2:
                i11 = R$color.otc_trade_desc_hint_color;
                break;
            case 4:
                i11 = R$color.baseColorShadeButtonRedStart;
                break;
        }
        return "#" + Integer.toHexString(ContextCompat.getColor(context, i11));
    }

    public String q(String str, String str2) {
        if (m.b0(str)) {
            return str;
        }
        return m.a(str).multiply(m.a(str2)).toPlainString();
    }

    public final String r(Context context, String str) {
        if (context == null) {
            return "";
        }
        if (this.f44529a == null) {
            HashMap hashMap = new HashMap();
            this.f44529a = hashMap;
            hashMap.put("1", context.getResources().getString(R$string.n_title_spot));
            this.f44529a.put("2", context.getResources().getString(R$string.n_market_contract_usdt_m));
            this.f44529a.put("3", context.getResources().getString(R$string.n_market_contract_coin_m));
            this.f44529a.put("4", context.getResources().getString(R$string.n_balance_contract_linear_swap_title));
            this.f44529a.put(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, context.getResources().getString(R$string.n_blance_fiat_assets));
            Map<String, String> map = this.f44529a;
            Resources resources = context.getResources();
            int i11 = R$string.n_option;
            map.put(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL, resources.getString(i11));
            this.f44529a.put(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP, context.getResources().getString(i11));
            this.f44529a.put("8", context.getResources().getString(i11));
            this.f44529a.put("9", context.getResources().getString(i11));
            this.f44529a.put(CouponReturn.TYPE_EXPERIENCE, context.getResources().getString(i11));
            this.f44529a.put(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP, context.getResources().getString(i11));
            this.f44529a.put("12", context.getResources().getString(i11));
            this.f44529a.put(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT, context.getResources().getString(i11));
            this.f44529a.put("14", context.getResources().getString(i11));
            this.f44529a.put("15", context.getResources().getString(i11));
            this.f44529a.put(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_HUOBI_EARN, context.getResources().getString(i11));
            this.f44529a.put("17", context.getResources().getString(i11));
            this.f44529a.put("18", context.getResources().getString(i11));
        }
        if (!this.f44529a.containsKey(str)) {
            return "";
        }
        return this.f44529a.get(str);
    }

    public final TradeType s(String str) {
        if (str.equalsIgnoreCase("4")) {
            return TradeType.LINEAR_SWAP;
        }
        if (str.equalsIgnoreCase(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP)) {
            return TradeType.SWAP;
        }
        return TradeType.CONTRACT;
    }

    public final String t(String str, String str2) {
        if (!LegalCurrencyConfigUtil.Z(str)) {
            return "0.00";
        }
        return m.a(str2).multiply(LegalCurrencyConfigUtil.H(str)).toPlainString();
    }

    public void v(AbilityFunction.a aVar) {
        AssetDataCacheManager.k0().x0().subscribeOn(Schedulers.io()).subscribe(new e(aVar));
    }

    public void w(Context context, AbilityFunction.a aVar) {
        AssetDataCacheManager.k0().C0().subscribeOn(Schedulers.io()).subscribe(new d(context, aVar));
    }

    public final void x(Map<String, Integer> map, String str, List<JSONObject> list, int i11, boolean z11, JSONObject jSONObject) throws Exception {
        List<JSONObject> list2 = list;
        JSONObject jSONObject2 = jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        List<CurrencyBean> g11 = q0.g();
        for (int i12 = 0; i12 < g11.size(); i12++) {
            CurrencyBean currencyBean = g11.get(i12);
            if (!currencyBean.getState().equalsIgnoreCase(SymbolBean.ONLINE)) {
                Map<String, Integer> map2 = map;
            } else {
                Map<String, Integer> map3 = map;
                if (map.get(currencyBean.getName().toUpperCase()) == null && currencyBean.getName().toUpperCase().contains(str.toUpperCase()) && !z11) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(FirebaseAnalytics.Param.CURRENCY, currencyBean.getName().toLowerCase());
                    jSONObject3.put("displayName", currencyBean.getDisplayName());
                    jSONObject3.put("symbolIcon", p.l(currencyBean.getName().toLowerCase()));
                    jSONObject3.put("currencyScale", currencyBean.getPrecision());
                    if (currencyBean.getName().equalsIgnoreCase(jSONObject2.optString("currentSpotExpandCurrency"))) {
                        String d11 = LegalCurrencyConfigUtil.d();
                        String optString = jSONObject2.optString("usdtPrice");
                        String h11 = h("usdt", optString, jSONObject2.optInt("currencyScale"));
                        if ("btc".equals(d11) && m.a(optString).compareTo(BigDecimal.ZERO) != 0 && m.a(h11).compareTo(BigDecimal.ZERO) == 0) {
                            h11 = "<0.00000001";
                        }
                        jSONObject3.put("spotExPrice", h11);
                    }
                    if (i11 == 1) {
                        list2.add(0, jSONObject3);
                    } else {
                        list2.add(jSONObject3);
                    }
                }
            }
            int i13 = i11;
        }
        Log.d("ConsumeTimeTag", "全币种merge耗时 -------> " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void y(Context context, String str) {
        double d11 = 0.0d;
        if (str != null) {
            try {
                d11 = Double.valueOf(str).doubleValue();
            } catch (Exception unused) {
            }
        }
        AssetShareHelper.share(context, AssetShareHelper.loadNewView(context, String.valueOf(d11), new c(d11), 1));
    }

    public final void z(List<JSONObject> list, int i11, int i12) {
        long currentTimeMillis = System.currentTimeMillis();
        Collections.sort(list, new ik.e(this, i11, i12));
        Log.d("ConsumeTimeTag", "排序耗时 -------> " + (System.currentTimeMillis() - currentTimeMillis));
    }
}
