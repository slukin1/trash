package dt;

import android.text.TextUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.c2c.C2CCurrencyProvider;
import com.hbg.lib.network.hbg.core.bean.AccountRiskInfo;
import com.hbg.lib.network.hbg.core.bean.AssertsTradeData;
import com.hbg.lib.network.hbg.core.bean.C2CAccountInNetAssetResult;
import com.hbg.lib.network.hbg.core.bean.C2CAccountOutNetAssetInfo;
import com.hbg.lib.network.hbg.core.bean.C2CAccountOutNetAssetResult;
import com.hbg.lib.network.hbg.core.bean.C2CCurrencyBean;
import com.hbg.lib.network.hbg.core.bean.C2CSymbolBean;
import com.hbg.lib.network.hbg.core.bean.MineAccountItem;
import com.hbg.lib.network.otc.core.bean.MarketPrice;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.swap.core.bean.ProductInfo;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapUserInfo;
import com.hbg.module.asset.AssetModuleConfig;
import com.huobi.account.entity.AccountQueryData;
import com.huobi.account.entity.AccountType;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.account.entity.BalanceQueryDataV2;
import com.huobi.account.entity.LegalQueryData;
import com.huobi.account.entity.SubaccountQueryData;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.entity.ContractCoinInfo;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.entity.SwapBalanceItem;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.C2CLendBalanceDataTotal;
import com.huobi.finance.bean.C2CLendBalanceDetailInfo;
import com.huobi.finance.bean.C2CMarginBalanceDataTotal;
import com.huobi.finance.bean.C2CMarginBalanceDetailInfo;
import com.huobi.finance.bean.ContractDataTotal;
import com.huobi.finance.bean.LegalDataTotal;
import com.huobi.finance.bean.LegalDetailInfo;
import com.huobi.finance.bean.MarginBalanceDataTotal;
import com.huobi.finance.bean.MarginBalanceDetailInfo;
import com.huobi.finance.bean.MineDataTotal;
import com.huobi.finance.bean.MineDetailInfo;
import com.huobi.finance.bean.SavingsDataTotal;
import com.huobi.finance.bean.SavingsDetailInfo;
import com.huobi.finance.bean.SuperMarginDataTotal;
import com.huobi.finance.bean.SuperMarginDetailInfo;
import com.huobi.finance.bean.SwapDataTotal;
import com.huobi.finance.utils.DepositWithdrawHelper;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.otc.bean.MarketCoin;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import com.huobi.supermargin.bean.MarginOverview;
import com.huobi.utils.SymbolUtil;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import i6.k;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import m9.e;
import m9.z;
import rx.Observable;
import rx.schedulers.Schedulers;
import u6.g;
import v7.b;
import x8.a;

public final class h2 {

    /* renamed from: q  reason: collision with root package name */
    public static h2 f84071q = new h2();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, BalanceQueryData> f84072a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, MarginBalanceQueryData> f84073b = null;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, C2CAccountInNetAssetResult> f84074c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public List<LegalQueryData> f84075d = null;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, AccountQueryData> f84076e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public Comparator<BaseAssetInfo> f84077f;

    /* renamed from: g  reason: collision with root package name */
    public Comparator<MarginBalanceDetailInfo> f84078g;

    /* renamed from: h  reason: collision with root package name */
    public Comparator<C2CMarginBalanceDetailInfo> f84079h;

    /* renamed from: i  reason: collision with root package name */
    public Comparator<C2CLendBalanceDetailInfo> f84080i;

    /* renamed from: j  reason: collision with root package name */
    public Comparator<MineDetailInfo> f84081j;

    /* renamed from: k  reason: collision with root package name */
    public Comparator<SavingsDetailInfo> f84082k;

    /* renamed from: l  reason: collision with root package name */
    public Comparator<ContractAccountInfo> f84083l;

    /* renamed from: m  reason: collision with root package name */
    public Comparator<SwapBalanceItem> f84084m;

    /* renamed from: n  reason: collision with root package name */
    public volatile AccountRiskInfo f84085n;

    /* renamed from: o  reason: collision with root package name */
    public long f84086o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f84087p;

    /* access modifiers changed from: private */
    public /* synthetic */ BalanceQueryData A2(BalanceQueryData balanceQueryData) {
        Q3(balanceQueryData.getList());
        return balanceQueryData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B2(TradeType tradeType, BalanceQueryData balanceQueryData) {
        this.f84072a.put(tradeType.name(), balanceQueryData);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ BalanceQueryData D2(BalanceQueryData balanceQueryData) {
        Q3(balanceQueryData.getList());
        return balanceQueryData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E2(TradeType tradeType, BalanceQueryData balanceQueryData) {
        this.f84072a.put(tradeType.name(), balanceQueryData);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ BalanceQueryData G2(BalanceQueryData balanceQueryData) {
        Q3(balanceQueryData.getList());
        return balanceQueryData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H2(TradeType tradeType, BalanceQueryData balanceQueryData) {
        this.f84072a.put(tradeType.name(), balanceQueryData);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ BalanceQueryData J2(BalanceQueryData balanceQueryData) {
        Q3(balanceQueryData.getList());
        return balanceQueryData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K2(TradeType tradeType, BalanceQueryData balanceQueryData) {
        this.f84072a.put(tradeType.name(), balanceQueryData);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ BalanceQueryData M2(BalanceQueryData balanceQueryData) {
        Q3(balanceQueryData.getList());
        return balanceQueryData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N2(TradeType tradeType, BalanceQueryData balanceQueryData) {
        this.f84072a.put(tradeType.name(), balanceQueryData);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ BalanceQueryData P2(BalanceQueryData balanceQueryData) {
        Q3(balanceQueryData.getList());
        return balanceQueryData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q2(TradeType tradeType, BalanceQueryData balanceQueryData) {
        this.f84072a.put(tradeType.name(), balanceQueryData);
    }

    public static /* synthetic */ Boolean R2(BalanceQueryData balanceQueryData) {
        return Boolean.valueOf(balanceQueryData != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U1(AccountQueryData accountQueryData) {
        k.o("AssetCalculate", "getAccountId " + accountQueryData.getType() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + accountQueryData.getId());
        this.f84076e.put(accountQueryData.getType(), accountQueryData);
    }

    public static /* synthetic */ Map U2() {
        return new HashMap();
    }

    public static /* synthetic */ void V2(Map map, SubaccountQueryData subaccountQueryData) {
        if (!map.containsKey(subaccountQueryData.getType())) {
            map.put(subaccountQueryData.getType(), new HashMap());
        }
        ((Map) map.get(subaccountQueryData.getType())).put(subaccountQueryData.getCurrency(), subaccountQueryData.getBalance());
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int X1(com.huobi.finance.bean.BaseAssetInfo r7, com.huobi.finance.bean.BaseAssetInfo r8) {
        /*
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = 0
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            java.lang.String r2 = r8.getEstimateAmount()     // Catch:{ NumberFormatException -> 0x0026 }
            double r2 = i6.m.h0(r2)     // Catch:{ NumberFormatException -> 0x0026 }
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ NumberFormatException -> 0x0026 }
            java.lang.String r3 = r7.getEstimateAmount()     // Catch:{ NumberFormatException -> 0x0024 }
            double r3 = i6.m.h0(r3)     // Catch:{ NumberFormatException -> 0x0024 }
            java.lang.Double r1 = java.lang.Double.valueOf(r3)     // Catch:{ NumberFormatException -> 0x0024 }
            goto L_0x002b
        L_0x0024:
            r3 = move-exception
            goto L_0x0028
        L_0x0026:
            r3 = move-exception
            r2 = r1
        L_0x0028:
            r3.printStackTrace()
        L_0x002b:
            double r3 = r1.doubleValue()
            double r5 = r2.doubleValue()
            int r3 = java.lang.Double.compare(r3, r5)
            if (r3 == 0) goto L_0x003e
            int r7 = r2.compareTo(r1)
            return r7
        L_0x003e:
            d7.k r1 = d7.k.C()     // Catch:{ NumberFormatException -> 0x0063 }
            java.lang.String r8 = r8.getCurrency()     // Catch:{ NumberFormatException -> 0x0063 }
            com.hbg.lib.data.symbol.TradeType r2 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NumberFormatException -> 0x0063 }
            java.lang.String r8 = r1.I(r8, r2)     // Catch:{ NumberFormatException -> 0x0063 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NumberFormatException -> 0x0063 }
            d7.k r1 = d7.k.C()     // Catch:{ NumberFormatException -> 0x0061 }
            java.lang.String r7 = r7.getCurrency()     // Catch:{ NumberFormatException -> 0x0061 }
            java.lang.String r7 = r1.I(r7, r2)     // Catch:{ NumberFormatException -> 0x0061 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)     // Catch:{ NumberFormatException -> 0x0061 }
            goto L_0x0068
        L_0x0061:
            r7 = move-exception
            goto L_0x0065
        L_0x0063:
            r7 = move-exception
            r8 = r0
        L_0x0065:
            r7.printStackTrace()
        L_0x0068:
            int r7 = r8.compareTo(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: dt.h2.X1(com.huobi.finance.bean.BaseAssetInfo, com.huobi.finance.bean.BaseAssetInfo):int");
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int Y1(com.huobi.finance.bean.C2CLendBalanceDetailInfo r6, com.huobi.finance.bean.C2CLendBalanceDetailInfo r7) {
        /*
            r0 = 0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            java.lang.String r1 = r7.getEstimateAmount()     // Catch:{ NumberFormatException -> 0x0021 }
            double r1 = i6.m.h0(r1)     // Catch:{ NumberFormatException -> 0x0021 }
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ NumberFormatException -> 0x0021 }
            java.lang.String r2 = r6.getEstimateAmount()     // Catch:{ NumberFormatException -> 0x001f }
            double r2 = i6.m.h0(r2)     // Catch:{ NumberFormatException -> 0x001f }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ NumberFormatException -> 0x001f }
            goto L_0x0026
        L_0x001f:
            r2 = move-exception
            goto L_0x0023
        L_0x0021:
            r2 = move-exception
            r1 = r0
        L_0x0023:
            r2.printStackTrace()
        L_0x0026:
            double r2 = r0.doubleValue()
            double r4 = r1.doubleValue()
            int r2 = java.lang.Double.compare(r2, r4)
            if (r2 == 0) goto L_0x0039
            int r6 = r1.compareTo(r0)
            return r6
        L_0x0039:
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            d7.k r2 = d7.k.C()     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r7 = r7.getCurrency()     // Catch:{ NumberFormatException -> 0x0065 }
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.C2C     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r7 = r2.I(r7, r3)     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)     // Catch:{ NumberFormatException -> 0x0065 }
            d7.k r7 = d7.k.C()     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r6 = r6.getCurrency()     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r6 = r7.I(r6, r3)     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)     // Catch:{ NumberFormatException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0069:
            int r6 = r1.compareTo(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: dt.h2.Y1(com.huobi.finance.bean.C2CLendBalanceDetailInfo, com.huobi.finance.bean.C2CLendBalanceDetailInfo):int");
    }

    public static /* synthetic */ Map Y2() {
        return new HashMap();
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int Z1(com.huobi.finance.bean.C2CMarginBalanceDetailInfo r8, com.huobi.finance.bean.C2CMarginBalanceDetailInfo r9) {
        /*
            r0 = 0
            java.lang.Double r2 = java.lang.Double.valueOf(r0)
            java.lang.String r3 = r9.getEstimateAmount()     // Catch:{ NumberFormatException -> 0x0021 }
            double r3 = i6.m.h0(r3)     // Catch:{ NumberFormatException -> 0x0021 }
            java.lang.Double r3 = java.lang.Double.valueOf(r3)     // Catch:{ NumberFormatException -> 0x0021 }
            java.lang.String r4 = r8.getEstimateAmount()     // Catch:{ NumberFormatException -> 0x001f }
            double r4 = i6.m.h0(r4)     // Catch:{ NumberFormatException -> 0x001f }
            java.lang.Double r2 = java.lang.Double.valueOf(r4)     // Catch:{ NumberFormatException -> 0x001f }
            goto L_0x0026
        L_0x001f:
            r4 = move-exception
            goto L_0x0023
        L_0x0021:
            r4 = move-exception
            r3 = r2
        L_0x0023:
            r4.printStackTrace()
        L_0x0026:
            double r4 = r2.doubleValue()
            double r6 = r3.doubleValue()
            int r4 = java.lang.Double.compare(r4, r6)
            if (r4 == 0) goto L_0x0072
            double r8 = r2.doubleValue()
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x0046
            double r8 = r3.doubleValue()
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 < 0) goto L_0x0046
            r8 = -1
            return r8
        L_0x0046:
            double r8 = r2.doubleValue()
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 < 0) goto L_0x0058
            double r8 = r3.doubleValue()
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x0058
            r8 = 1
            return r8
        L_0x0058:
            double r8 = r2.doubleValue()
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x006d
            double r8 = r3.doubleValue()
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x006d
            int r8 = r2.compareTo(r3)
            return r8
        L_0x006d:
            int r8 = r3.compareTo(r2)
            return r8
        L_0x0072:
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r8 = r8.getSymbol()
            java.lang.String r9 = r9.getSymbol()
            d7.a1 r2 = d7.a1.v()     // Catch:{ NumberFormatException -> 0x009e }
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.C2C     // Catch:{ NumberFormatException -> 0x009e }
            int r9 = r2.x(r9, r3)     // Catch:{ NumberFormatException -> 0x009e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch:{ NumberFormatException -> 0x009e }
            d7.a1 r9 = d7.a1.v()     // Catch:{ NumberFormatException -> 0x009e }
            int r8 = r9.x(r8, r3)     // Catch:{ NumberFormatException -> 0x009e }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)     // Catch:{ NumberFormatException -> 0x009e }
            goto L_0x00a2
        L_0x009e:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00a2:
            int r8 = r1.compareTo(r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: dt.h2.Z1(com.huobi.finance.bean.C2CMarginBalanceDetailInfo, com.huobi.finance.bean.C2CMarginBalanceDetailInfo):int");
    }

    public static /* synthetic */ void Z2(TradeType tradeType, Map map, SubaccountQueryData subaccountQueryData) {
        if (!map.containsKey(subaccountQueryData.getType())) {
            map.put(subaccountQueryData.getType(), new HashMap());
        }
        if (tradeType == TradeType.PRO) {
            ((Map) map.get(subaccountQueryData.getType())).put(subaccountQueryData.getCurrency(), subaccountQueryData.getAvailable());
        } else {
            ((Map) map.get(subaccountQueryData.getType())).put(subaccountQueryData.getCurrency(), subaccountQueryData.getBalance());
        }
    }

    public static /* synthetic */ int a2(ContractAccountInfo contractAccountInfo, ContractAccountInfo contractAccountInfo2) {
        Double d11;
        Double valueOf = Double.valueOf(0.0d);
        try {
            d11 = Double.valueOf(m.h0(contractAccountInfo2.getEstimateAmount()));
            try {
                valueOf = Double.valueOf(m.h0(contractAccountInfo.getEstimateAmount()));
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return d11.compareTo(valueOf);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            d11 = valueOf;
            e.printStackTrace();
            return d11.compareTo(valueOf);
        }
        return d11.compareTo(valueOf);
    }

    public static /* synthetic */ Observable b2(Throwable th2) {
        if (!(th2 instanceof APIStatusErrorException) || 1220 != m.k0(((APIStatusErrorException) th2).getErrCode())) {
            return Observable.error(th2);
        }
        return Observable.just(null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Map c3(String str, boolean z11, Map map) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        if (z11) {
            Map map2 = (Map) map.get(str);
            if (map2 != null) {
                hashMap.put(str, b3(map2));
            }
        } else {
            for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                hashMap.put(str2, b3((Map) map.get(str2)));
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ContractDataTotal d2(List list, List list2, List list3, ContractUserInfo.UserBean userBean, Map map) {
        return q1(SymbolUtil.d(), list, list3, userBean, map);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List d3(String str, List list) {
        if (list != null) {
            Map<String, C2CAccountInNetAssetResult> map = this.f84074c;
            if (map == null) {
                this.f84074c = new HashMap();
            } else {
                map.clear();
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                C2CAccountInNetAssetResult c2CAccountInNetAssetResult = (C2CAccountInNetAssetResult) it2.next();
                if (c2CAccountInNetAssetResult != null) {
                    this.f84074c.put(c2CAccountInNetAssetResult.getSubtype(), c2CAccountInNetAssetResult);
                }
            }
        }
        return h1(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ LegalDataTotal e2(List list, List list2, Map map) {
        int i11;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3 = BigDecimal.ZERO;
        Iterator it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                i11 = Integer.MIN_VALUE;
                break;
            }
            MarketCoin.Coin coin = (MarketCoin.Coin) it2.next();
            if ("ht".equalsIgnoreCase(coin.getShortName())) {
                i11 = coin.getCoinId();
                break;
            }
        }
        Map<Integer, BigDecimal> E1 = t1().E1("btc");
        BigDecimal bigDecimal4 = bigDecimal3;
        for (Map.Entry entry : map.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            Map map2 = (Map) entry.getValue();
            if (map2 != null && !map2.isEmpty()) {
                BigDecimal bigDecimal5 = E1.get(Integer.valueOf(intValue));
                for (Map.Entry entry2 : map2.entrySet()) {
                    if (entry2.getKey() != null) {
                        if (2 != ((Integer) entry2.getKey()).intValue()) {
                            String str = (String) entry2.getValue();
                            if (str == null) {
                                bigDecimal2 = BigDecimal.ZERO;
                            } else {
                                bigDecimal2 = new BigDecimal(str);
                            }
                            if (bigDecimal5 != null) {
                                bigDecimal3 = bigDecimal3.add(bigDecimal2.multiply(bigDecimal5));
                            }
                        } else if (intValue == i11) {
                            String str2 = (String) entry2.getValue();
                            if (str2 == null) {
                                bigDecimal = BigDecimal.ZERO;
                            } else {
                                bigDecimal = new BigDecimal(str2);
                            }
                            bigDecimal4 = bigDecimal4.add(bigDecimal);
                        }
                    }
                }
            }
        }
        List<LegalDetailInfo> u12 = t1().u1(map);
        if (u12 != null && !u12.isEmpty()) {
            Collections.sort(u12, e1());
        }
        LegalDataTotal legalDataTotal = new LegalDataTotal();
        legalDataTotal.setNetAssetToBtc(bigDecimal3.toPlainString());
        legalDataTotal.setNetAsset(LegalCurrencyConfigUtil.D(m.u0(bigDecimal3.toPlainString(), 12, 8), "btcusdt", TradeType.PRO));
        legalDataTotal.setTotalBurrow(bigDecimal4.toPlainString());
        legalDataTotal.setDetailAsset(map);
        legalDataTotal.setDetailInfos(u12);
        return legalDataTotal;
    }

    public static /* synthetic */ Observable e3(List list) {
        HashSet hashSet = new HashSet();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            hashSet.add(((C2CCurrencyBean) it2.next()).getCurrency());
        }
        return Observable.just(hashSet);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int f2(com.huobi.finance.bean.MarginBalanceDetailInfo r6, com.huobi.finance.bean.MarginBalanceDetailInfo r7) {
        /*
            r0 = 0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            java.lang.String r1 = r7.getEstimateAmount()     // Catch:{ NumberFormatException -> 0x0021 }
            double r1 = i6.m.h0(r1)     // Catch:{ NumberFormatException -> 0x0021 }
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ NumberFormatException -> 0x0021 }
            java.lang.String r2 = r6.getEstimateAmount()     // Catch:{ NumberFormatException -> 0x001f }
            double r2 = i6.m.h0(r2)     // Catch:{ NumberFormatException -> 0x001f }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ NumberFormatException -> 0x001f }
            goto L_0x0026
        L_0x001f:
            r2 = move-exception
            goto L_0x0023
        L_0x0021:
            r2 = move-exception
            r1 = r0
        L_0x0023:
            r2.printStackTrace()
        L_0x0026:
            double r2 = r0.doubleValue()
            double r4 = r1.doubleValue()
            int r2 = java.lang.Double.compare(r2, r4)
            if (r2 == 0) goto L_0x0039
            int r6 = r1.compareTo(r0)
            return r6
        L_0x0039:
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r6 = r6.getSymbol()
            java.lang.String r7 = r7.getSymbol()
            d7.a1 r2 = d7.a1.v()     // Catch:{ NumberFormatException -> 0x0065 }
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.MARGIN     // Catch:{ NumberFormatException -> 0x0065 }
            int r7 = r2.x(r7, r3)     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)     // Catch:{ NumberFormatException -> 0x0065 }
            d7.a1 r7 = d7.a1.v()     // Catch:{ NumberFormatException -> 0x0065 }
            int r6 = r7.x(r6, r3)     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)     // Catch:{ NumberFormatException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0069:
            int r6 = r1.compareTo(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: dt.h2.f2(com.huobi.finance.bean.MarginBalanceDetailInfo, com.huobi.finance.bean.MarginBalanceDetailInfo):int");
    }

    public static /* synthetic */ Map f3(Set set, List list) {
        HashMap hashMap = new HashMap();
        if (!(list == null || list.size() == 0)) {
            try {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    C2CAccountInNetAssetResult c2CAccountInNetAssetResult = (C2CAccountInNetAssetResult) it2.next();
                    if (!hashMap.containsKey(c2CAccountInNetAssetResult.getSubtype())) {
                        hashMap.put(c2CAccountInNetAssetResult.getSubtype(), new HashMap());
                    }
                    for (C2CAccountOutNetAssetInfo next : c2CAccountInNetAssetResult.getList()) {
                        if (!((Map) hashMap.get(c2CAccountInNetAssetResult.getSubtype())).containsKey(next.getType()) && set.contains(next.getCurrency())) {
                            ((Map) hashMap.get(c2CAccountInNetAssetResult.getSubtype())).put(next.getType(), new HashMap());
                        }
                        ((Map) ((Map) hashMap.get(c2CAccountInNetAssetResult.getSubtype())).get(next.getType())).put(next.getCurrency(), next.getBalance());
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g3(List list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            this.f84075d = arrayList;
            arrayList.addAll(list);
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int h2(com.huobi.finance.bean.MineDetailInfo r6, com.huobi.finance.bean.MineDetailInfo r7) {
        /*
            r0 = 0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            java.lang.String r1 = r7.getEstimateAmount()     // Catch:{ NumberFormatException -> 0x0021 }
            double r1 = i6.m.h0(r1)     // Catch:{ NumberFormatException -> 0x0021 }
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ NumberFormatException -> 0x0021 }
            java.lang.String r2 = r6.getEstimateAmount()     // Catch:{ NumberFormatException -> 0x001f }
            double r2 = i6.m.h0(r2)     // Catch:{ NumberFormatException -> 0x001f }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ NumberFormatException -> 0x001f }
            goto L_0x0026
        L_0x001f:
            r2 = move-exception
            goto L_0x0023
        L_0x0021:
            r2 = move-exception
            r1 = r0
        L_0x0023:
            r2.printStackTrace()
        L_0x0026:
            double r2 = r0.doubleValue()
            double r4 = r1.doubleValue()
            int r2 = java.lang.Double.compare(r2, r4)
            if (r2 == 0) goto L_0x0039
            int r6 = r1.compareTo(r0)
            return r6
        L_0x0039:
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            d7.k r2 = d7.k.C()     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r7 = r7.getCurrency()     // Catch:{ NumberFormatException -> 0x0065 }
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r7 = r2.I(r7, r3)     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)     // Catch:{ NumberFormatException -> 0x0065 }
            d7.k r7 = d7.k.C()     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r6 = r6.getCurrency()     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r6 = r7.I(r6, r3)     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)     // Catch:{ NumberFormatException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0069:
            int r6 = r1.compareTo(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: dt.h2.h2(com.huobi.finance.bean.MineDetailInfo, com.huobi.finance.bean.MineDetailInfo):int");
    }

    public static /* synthetic */ Boolean h3(List list) {
        return Boolean.valueOf(list != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j2(AccountQueryData accountQueryData) {
        Map<String, AccountQueryData> map = this.f84076e;
        map.put(accountQueryData.getType() + accountQueryData.getSubtype(), accountQueryData);
    }

    public static /* synthetic */ Map j3() {
        return new HashMap();
    }

    public static /* synthetic */ Boolean k2(String str, String str2, AccountQueryData accountQueryData) {
        return Boolean.valueOf(accountQueryData.getType().equals(str) && str2.equals(accountQueryData.getSubtype()));
    }

    public static /* synthetic */ void k3(Map map, LegalQueryData legalQueryData) {
        if (legalQueryData != null) {
            if (!map.containsKey(Integer.valueOf(legalQueryData.getCoinId()))) {
                map.put(Integer.valueOf(legalQueryData.getCoinId()), new HashMap());
            }
            ((Map) map.get(Integer.valueOf(legalQueryData.getCoinId()))).put(0, legalQueryData.getAvaialAble());
            ((Map) map.get(Integer.valueOf(legalQueryData.getCoinId()))).put(1, legalQueryData.getFrozen());
            ((Map) map.get(Integer.valueOf(legalQueryData.getCoinId()))).put(2, legalQueryData.getBorrow());
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int m2(com.huobi.finance.bean.SavingsDetailInfo r6, com.huobi.finance.bean.SavingsDetailInfo r7) {
        /*
            r0 = 0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            java.lang.String r1 = r7.getEstimateAmount()     // Catch:{ NumberFormatException -> 0x0021 }
            double r1 = i6.m.h0(r1)     // Catch:{ NumberFormatException -> 0x0021 }
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ NumberFormatException -> 0x0021 }
            java.lang.String r2 = r6.getEstimateAmount()     // Catch:{ NumberFormatException -> 0x001f }
            double r2 = i6.m.h0(r2)     // Catch:{ NumberFormatException -> 0x001f }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ NumberFormatException -> 0x001f }
            goto L_0x0026
        L_0x001f:
            r2 = move-exception
            goto L_0x0023
        L_0x0021:
            r2 = move-exception
            r1 = r0
        L_0x0023:
            r2.printStackTrace()
        L_0x0026:
            double r2 = r0.doubleValue()
            double r4 = r1.doubleValue()
            int r2 = java.lang.Double.compare(r2, r4)
            if (r2 == 0) goto L_0x0039
            int r6 = r1.compareTo(r0)
            return r6
        L_0x0039:
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            d7.k r2 = d7.k.C()     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r7 = r7.getCurrency()     // Catch:{ NumberFormatException -> 0x0065 }
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r7 = r2.I(r7, r3)     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)     // Catch:{ NumberFormatException -> 0x0065 }
            d7.k r7 = d7.k.C()     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r6 = r6.getCurrency()     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r6 = r7.I(r6, r3)     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)     // Catch:{ NumberFormatException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0069:
            int r6 = r1.compareTo(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: dt.h2.m2(com.huobi.finance.bean.SavingsDetailInfo, com.huobi.finance.bean.SavingsDetailInfo):int");
    }

    public static /* synthetic */ Map m3() {
        return new HashMap();
    }

    public static /* synthetic */ int n2(SwapBalanceItem swapBalanceItem, SwapBalanceItem swapBalanceItem2) {
        Double d11;
        Double valueOf = Double.valueOf(0.0d);
        try {
            d11 = Double.valueOf(m.h0(swapBalanceItem2.getEstimateAmount()));
            try {
                valueOf = Double.valueOf(m.h0(swapBalanceItem.getEstimateAmount()));
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return d11.compareTo(valueOf);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            d11 = valueOf;
            e.printStackTrace();
            return d11.compareTo(valueOf);
        }
        return d11.compareTo(valueOf);
    }

    public static /* synthetic */ void n3(Map map, LegalQueryData legalQueryData) {
        if (legalQueryData != null) {
            map.put(Integer.valueOf(legalQueryData.getCoinId()), legalQueryData.getAvaialAble());
        }
    }

    public static /* synthetic */ Observable o2(Throwable th2) {
        if (!(th2 instanceof APIStatusErrorException) || 1220 != m.k0(((APIStatusErrorException) th2).getErrCode())) {
            return Observable.error(th2);
        }
        return Observable.just(null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o3(List list) {
        if (list != null) {
            if (this.f84073b == null) {
                this.f84073b = new HashMap();
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                MarginBalanceQueryData marginBalanceQueryData = (MarginBalanceQueryData) it2.next();
                if (marginBalanceQueryData != null) {
                    this.f84073b.put(marginBalanceQueryData.getSymbol(), marginBalanceQueryData);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p3(List list) {
        if (list != null) {
            if (this.f84073b == null) {
                this.f84073b = new HashMap();
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                MarginBalanceQueryData marginBalanceQueryData = (MarginBalanceQueryData) it2.next();
                if (marginBalanceQueryData != null) {
                    this.f84073b.put(marginBalanceQueryData.getSymbol(), marginBalanceQueryData);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SwapDataTotal q2(List list, List list2, List list3, SwapUserInfo.UserBean userBean, Map map) {
        return I1(SymbolUtil.d(), list, list3, userBean, map);
    }

    public static /* synthetic */ Boolean q3(List list) {
        return Boolean.valueOf(list != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ BalanceDataTotal r2(Map map, Map map2) {
        return d1(SymbolUtil.d(), map, map2, TradeType.PRO);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ C2CLendBalanceDataTotal s2(C2CAccountOutNetAssetResult c2CAccountOutNetAssetResult, Map map) {
        return i1(k1(c2CAccountOutNetAssetResult, map));
    }

    public static /* synthetic */ Map s3() {
        return new HashMap();
    }

    public static h2 t1() {
        return f84071q;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ C2CMarginBalanceDataTotal t2(Map map, Map map2) {
        return l1(SymbolUtil.d(), map, map2);
    }

    public static /* synthetic */ void t3(Set set, Map map, MarginBalanceQueryData marginBalanceQueryData) {
        try {
            if (!map.containsKey(marginBalanceQueryData.getSymbol())) {
                map.put(marginBalanceQueryData.getSymbol(), new HashMap());
            }
            for (SubaccountQueryData next : marginBalanceQueryData.getList()) {
                if (!((Map) map.get(marginBalanceQueryData.getSymbol())).containsKey(next.getType()) && set.contains(next.getCurrency())) {
                    ((Map) map.get(marginBalanceQueryData.getSymbol())).put(next.getType(), new HashMap());
                }
                Map map2 = (Map) ((Map) map.get(marginBalanceQueryData.getSymbol())).get(next.getType());
                if (map2 != null) {
                    map2.put(next.getCurrency(), next.getBalance());
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ MarginBalanceDataTotal u2(Map map, Map map2) {
        return w1(SymbolUtil.d(), map, map2);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int u3(java.util.Map.Entry r8, java.util.Map.Entry r9) {
        /*
            r0 = 2147483647(0x7fffffff, float:NaN)
            java.lang.String r1 = "usdt"
            r2 = 0
            r3 = 2147483646(0x7ffffffe, float:NaN)
            java.lang.String r4 = "btc"
            r5 = 2147483645(0x7ffffffd, float:NaN)
            java.lang.String r6 = "eth"
            if (r8 == 0) goto L_0x0068
            java.lang.Object r7 = r8.getKey()
            if (r7 == 0) goto L_0x0068
            java.lang.Object r7 = r8.getKey()
            java.lang.String r7 = (java.lang.String) r7
            boolean r7 = r7.contains(r1)
            if (r7 == 0) goto L_0x0041
            java.lang.Object r7 = r8.getKey()
            java.lang.String r7 = (java.lang.String) r7
            boolean r7 = r7.contains(r4)
            if (r7 == 0) goto L_0x0032
        L_0x0030:
            r8 = r3
            goto L_0x0069
        L_0x0032:
            java.lang.Object r8 = r8.getKey()
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.contains(r6)
            if (r8 == 0) goto L_0x003f
            goto L_0x0066
        L_0x003f:
            r8 = r0
            goto L_0x0069
        L_0x0041:
            java.lang.Object r7 = r8.getKey()
            java.lang.String r7 = (java.lang.String) r7
            boolean r7 = r7.contains(r4)
            if (r7 == 0) goto L_0x005a
            java.lang.Object r8 = r8.getKey()
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.contains(r6)
            if (r8 == 0) goto L_0x0030
            goto L_0x0066
        L_0x005a:
            java.lang.Object r8 = r8.getKey()
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.contains(r6)
            if (r8 == 0) goto L_0x0068
        L_0x0066:
            r8 = r5
            goto L_0x0069
        L_0x0068:
            r8 = r2
        L_0x0069:
            if (r9 == 0) goto L_0x00bf
            java.lang.Object r7 = r9.getKey()
            if (r7 == 0) goto L_0x00bf
            java.lang.Object r7 = r9.getKey()
            java.lang.String r7 = (java.lang.String) r7
            boolean r1 = r7.contains(r1)
            if (r1 == 0) goto L_0x0098
            java.lang.Object r1 = r9.getKey()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L_0x008b
        L_0x0089:
            r0 = r3
            goto L_0x00c0
        L_0x008b:
            java.lang.Object r9 = r9.getKey()
            java.lang.String r9 = (java.lang.String) r9
            boolean r9 = r9.contains(r6)
            if (r9 == 0) goto L_0x00c0
            goto L_0x00bd
        L_0x0098:
            java.lang.Object r0 = r9.getKey()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r0.contains(r4)
            if (r0 == 0) goto L_0x00b1
            java.lang.Object r9 = r9.getKey()
            java.lang.String r9 = (java.lang.String) r9
            boolean r9 = r9.contains(r6)
            if (r9 == 0) goto L_0x0089
            goto L_0x00bd
        L_0x00b1:
            java.lang.Object r9 = r9.getKey()
            java.lang.String r9 = (java.lang.String) r9
            boolean r9 = r9.contains(r6)
            if (r9 == 0) goto L_0x00bf
        L_0x00bd:
            r0 = r5
            goto L_0x00c0
        L_0x00bf:
            r0 = r2
        L_0x00c0:
            int r0 = r0 - r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dt.h2.u3(java.util.Map$Entry, java.util.Map$Entry):int");
    }

    public static /* synthetic */ Observable v2(Long l11) {
        if (l11 == null) {
            return Observable.just(null);
        }
        return a.a().getMarginOverview(l11.longValue()).b().subscribeOn(Schedulers.io());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ BalanceQueryData x2(BalanceQueryDataV2 balanceQueryDataV2) {
        Q3(balanceQueryDataV2.getList());
        return balanceQueryDataV2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y2(TradeType tradeType, BalanceQueryData balanceQueryData) {
        this.f84072a.put(tradeType.name(), balanceQueryData);
    }

    /* renamed from: A1 */
    public List<MarginBalanceDetailInfo> g2(String str, Map<String, Map<String, Map<String, String>>> map) {
        ArrayList arrayList = new ArrayList();
        List<MarginBalanceQueryData> G3 = G3(false, str);
        Map<String, Map<String, String>> Q0 = Q0(map, "usdt");
        Map<String, Map<String, String>> Q02 = Q0(map, "btc");
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (Map.Entry next : Q0.entrySet()) {
            BigDecimal bigDecimal = BigDecimal.ZERO;
            for (Map.Entry value : ((Map) next.getValue()).entrySet()) {
                bigDecimal = bigDecimal.add(new BigDecimal((String) value.getValue()));
            }
            hashMap.put((String) next.getKey(), bigDecimal.toPlainString());
        }
        for (Map.Entry next2 : Q02.entrySet()) {
            BigDecimal bigDecimal2 = BigDecimal.ZERO;
            for (Map.Entry value2 : ((Map) next2.getValue()).entrySet()) {
                bigDecimal2 = bigDecimal2.add(new BigDecimal((String) value2.getValue()));
            }
            hashMap2.put((String) next2.getKey(), bigDecimal2.toPlainString());
        }
        Map<String, String> I = LegalCurrencyConfigUtil.I(hashMap);
        for (MarginBalanceQueryData next3 : G3) {
            String symbol = next3.getSymbol();
            arrayList.add(a1(next3, m.a((String) hashMap2.get(symbol)).toPlainString(), m.a(I.get(symbol)).toPlainString()));
        }
        Collections.sort(arrayList, x1());
        return arrayList;
    }

    public Observable<Map<String, Map<String, String>>> A3(TradeType tradeType, boolean z11, boolean z12, String str) {
        return I3(tradeType, z11, z12, str).map(new m0(this, str, z12));
    }

    public Comparator<MineDetailInfo> B1() {
        if (this.f84081j == null) {
            this.f84081j = z1.f54223b;
        }
        return this.f84081j;
    }

    public Observable<List<C2CAccountInNetAssetResult>> B3(boolean z11, String str) {
        Observable<R> map = b.a().requestC2CAccountInNetAsset().b().map(new k0(this, str));
        if (!z11) {
            return map;
        }
        List<C2CAccountInNetAssetResult> h12 = h1(str);
        if (h12.isEmpty()) {
            return map;
        }
        return Observable.just(h12);
    }

    public long C1(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return -1;
        }
        Map<String, AccountQueryData> map = this.f84076e;
        AccountQueryData accountQueryData = map.get(str + str2);
        if (accountQueryData != null) {
            return accountQueryData.getId();
        }
        return 0;
    }

    public Observable<Map<String, Map<String, Map<String, String>>>> C3(boolean z11, String str) {
        return Observable.zip(C2CCurrencyProvider.e(true).flatMap(n1.f54111b), B3(z11, str), a2.f53985b);
    }

    public Observable<Long> D1(String str, String str2) {
        AccountQueryData accountQueryData;
        if (TextUtils.isEmpty(str2)) {
            return Observable.just(-1L);
        }
        Map<String, AccountQueryData> map = this.f84076e;
        if (map.get(str + str2) != null) {
            Map<String, AccountQueryData> map2 = this.f84076e;
            accountQueryData = map2.get(str + str2);
        } else {
            accountQueryData = null;
        }
        if (accountQueryData == null) {
            return a.a().getAccounts().b().flatMap(l1.f54090b).doOnNext(new d(this)).filter(new o0(str, str2)).map(t0.f54152b);
        }
        return Observable.just(Long.valueOf(accountQueryData.getId()));
    }

    public final Observable<List<LegalQueryData>> D3(boolean z11) {
        Observable<R> doOnNext = s8.a.a().getWallet2().b().compose(RxJavaHelper.t((g) null)).doOnNext(new f(this));
        return z11 ? Observable.concat(Observable.just(this.f84075d), doOnNext).takeFirst(r1.f54142b) : doOnNext;
    }

    public Map<Integer, BigDecimal> E1(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        Map<String, SymbolPrice> T = LegalCurrencyConfigUtil.T();
        Map<String, BigDecimal> map = null;
        if (T != null && T.size() > 0) {
            map = t1().s1(str, T);
        }
        int b11 = OtcMarketPriceConfigUtil.b(str);
        if (b11 != Integer.MIN_VALUE) {
            hashMap.put(Integer.valueOf(b11), BigDecimal.ONE);
        }
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                int a11 = OtcMarketPriceConfigUtil.a((String) next.getKey());
                if (a11 != Integer.MIN_VALUE) {
                    hashMap.put(Integer.valueOf(a11), (BigDecimal) next.getValue());
                }
            }
        }
        return hashMap;
    }

    public final Observable<Map<Integer, Map<Integer, String>>> E3(boolean z11) {
        return D3(z11).flatMap(k1.f54077b).collect(u.f54158b, s.f54145b);
    }

    public Comparator<SavingsDetailInfo> F1() {
        if (this.f84082k == null) {
            this.f84082k = f2.f54021b;
        }
        return this.f84082k;
    }

    public Observable<Map<Integer, String>> F3(boolean z11) {
        return D3(z11).flatMap(q1.f54132b).collect(z.f54221b, r.f54140b);
    }

    public long G1(TradeType tradeType, String str) {
        AccountQueryData accountQueryData = this.f84076e.get(str);
        if (accountQueryData != null) {
            return accountQueryData.getId();
        }
        return 0;
    }

    public List<MarginBalanceQueryData> G3(boolean z11, String str) {
        HashMap hashMap = new HashMap();
        Map<String, MarginBalanceQueryData> map = this.f84073b;
        if (map != null) {
            hashMap.putAll(map);
        }
        ArrayList arrayList = new ArrayList();
        if (!z11) {
            for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                if (hashMap.get(str2) != null) {
                    arrayList.add((MarginBalanceQueryData) hashMap.get(str2));
                }
            }
        } else if (hashMap.get(str) != null) {
            arrayList.add((MarginBalanceQueryData) hashMap.get(str));
        }
        return arrayList;
    }

    public final void H0(Map<String, MineDetailInfo> map, String str, String str2, String str3, Map<String, BigDecimal> map2) {
        MineDetailInfo mineDetailInfo;
        if (map.get(str2) == null) {
            mineDetailInfo = new MineDetailInfo();
            mineDetailInfo.setCurrency(str2);
            mineDetailInfo.setDisplayName(d7.k.C().z(str2));
            map.put(str2, mineDetailInfo);
        } else {
            mineDetailInfo = map.get(str2);
        }
        if (map2.containsKey(str2)) {
            mineDetailInfo.setEstimateAmountToBtc(m.a(mineDetailInfo.getEstimateAmountToBtc()).add(map2.get(str2).multiply(m.a(str3))).toPlainString());
        }
        mineDetailInfo.setEstimateAmount(LegalCurrencyConfigUtil.L(m.a(mineDetailInfo.getEstimateAmount()).add(m.a(LegalCurrencyConfigUtil.G(str3, str2, TradeType.PRO)))));
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1266085216:
                if (str.equals("frozen")) {
                    c11 = 0;
                    break;
                }
                break;
            case 3016252:
                if (str.equals(BalanceQueryData.TYPE_BANK)) {
                    c11 = 1;
                    break;
                }
                break;
            case 3327275:
                if (str.equals("lock")) {
                    c11 = 2;
                    break;
                }
                break;
            case 110621028:
                if (str.equals("trade")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                mineDetailInfo.setOnOrders(str3);
                return;
            case 1:
                mineDetailInfo.setBank(str3);
                return;
            case 2:
                mineDetailInfo.setLock(str3);
                return;
            case 3:
                mineDetailInfo.setAvaialAble(str3);
                return;
            default:
                return;
        }
    }

    public final Comparator<SwapBalanceItem> H1() {
        if (this.f84084m == null) {
            this.f84084m = l.f54087b;
        }
        return this.f84084m;
    }

    public Observable<List<MarginBalanceQueryData>> H3(TradeType tradeType, boolean z11, boolean z12, String str) {
        Observable<List<MarginBalanceQueryData>> observable;
        Observable observable2;
        if (z12) {
            observable = a.a().getMaginBalanceWithSymbol(str).b().doOnNext(new g(this));
        } else {
            observable = a.a().getMaginBalanceWithSymbols(str).b().doOnNext(new e(this));
        }
        if (!z11) {
            return observable;
        }
        ArrayList arrayList = new ArrayList();
        Map<String, MarginBalanceQueryData> map = this.f84073b;
        if (map != null) {
            if (!z12) {
                for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    if (this.f84073b.get(str2) != null) {
                        arrayList.add(this.f84073b.get(str2));
                    }
                }
            } else if (map.get(str) != null) {
                arrayList.add(this.f84073b.get(str));
            }
            observable2 = Observable.just(arrayList);
        } else {
            observable2 = Observable.just(null);
        }
        return Observable.concat(observable2, observable).takeFirst(m1.f54100b);
    }

    public final void I0(Map<String, SavingsDetailInfo> map, String str, String str2, String str3, Map<String, BigDecimal> map2) {
        SavingsDetailInfo savingsDetailInfo;
        if (map.get(str2) == null) {
            savingsDetailInfo = new SavingsDetailInfo();
            savingsDetailInfo.setCurrency(str2);
            savingsDetailInfo.setDisplayName(d7.k.C().z(str2));
            map.put(str2, savingsDetailInfo);
        } else {
            savingsDetailInfo = map.get(str2);
        }
        if (map2.containsKey(str2)) {
            savingsDetailInfo.setEstimateAmountToBtc(m.a(savingsDetailInfo.getEstimateAmountToBtc()).add(map2.get(str2).multiply(m.a(str3))).toPlainString());
        }
        savingsDetailInfo.setEstimateAmount(LegalCurrencyConfigUtil.L(m.a(savingsDetailInfo.getEstimateAmount()).add(m.a(LegalCurrencyConfigUtil.G(str3, str2, TradeType.PRO)))));
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1266085216:
                if (str.equals("frozen")) {
                    c11 = 0;
                    break;
                }
                break;
            case -807723863:
                if (str.equals("earnings")) {
                    c11 = 1;
                    break;
                }
                break;
            case 62364819:
                if (str.equals("lending")) {
                    c11 = 2;
                    break;
                }
                break;
            case 110621028:
                if (str.equals("trade")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                savingsDetailInfo.setOnOrders(str3);
                return;
            case 1:
                savingsDetailInfo.setEarning(str3);
                return;
            case 2:
                savingsDetailInfo.setLending(str3);
                return;
            case 3:
                savingsDetailInfo.setAvaialAble(str3);
                return;
            default:
                return;
        }
    }

    public SwapDataTotal I1(String str, List<SwapAccountInfo> list, List<ProductInfo> list2, SwapUserInfo.UserBean userBean, Map<String, SymbolPrice> map) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        boolean z11 = false;
        boolean z12 = list == null || list.isEmpty();
        if (!(userBean == null || 1 == userBean.getActiveState())) {
            z11 = true;
        }
        ArrayList arrayList = new ArrayList();
        if (!z12 && !z11) {
            Map<String, BigDecimal> s12 = s1(str, map);
            for (SwapAccountInfo next : list) {
                if (!(next == null || next.getSymbol() == null)) {
                    SwapBalanceItem swapBalanceItem = new SwapBalanceItem(next);
                    String g11 = StringUtils.g(next.getSymbol());
                    if (g11.equalsIgnoreCase(str)) {
                        String marginBalance = next.getMarginBalance();
                        swapBalanceItem.setEstimateAmountToBtc(marginBalance);
                        bigDecimal = bigDecimal.add(m.a(marginBalance));
                    } else if (s12.containsKey(g11)) {
                        String plainString = s12.get(g11).multiply(new BigDecimal(next.getMarginBalance())).toPlainString();
                        swapBalanceItem.setEstimateAmountToBtc(plainString);
                        bigDecimal = bigDecimal.add(m.a(plainString));
                    }
                    swapBalanceItem.setEstimateAmount(m.a(LegalCurrencyConfigUtil.G(next.getMarginBalance(), swapBalanceItem.getCurrency(), TradeType.PRO)).toPlainString());
                    arrayList.add(swapBalanceItem);
                }
            }
            Collections.sort(arrayList, H1());
        } else if (list2 != null && !list2.isEmpty()) {
            if (list == null) {
                list = new ArrayList<>();
            }
            for (ProductInfo next2 : list2) {
                if (next2 != null) {
                    SwapAccountInfo swapAccountInfo = new SwapAccountInfo();
                    swapAccountInfo.setSymbol(next2.getSymbol());
                    list.add(swapAccountInfo);
                    arrayList.add(new SwapBalanceItem(swapAccountInfo));
                }
            }
        }
        SwapDataTotal swapDataTotal = new SwapDataTotal();
        swapDataTotal.setNetAssetToBtc(bigDecimal.toPlainString());
        swapDataTotal.setNetAsset(LegalCurrencyConfigUtil.D(m.u0(bigDecimal.toPlainString(), 12, 8), "btcusdt", TradeType.PRO));
        if (list == null) {
            arrayList = new ArrayList();
        }
        swapDataTotal.setDetailInfos(arrayList);
        return swapDataTotal;
    }

    public Observable<Map<String, Map<String, Map<String, String>>>> I3(TradeType tradeType, boolean z11, boolean z12, String str) {
        return H3(tradeType, z11, z12, str).flatMap(s1.f54147b).collect(y.f54209b, new q(new HashSet(d7.k.C().G(tradeType))));
    }

    public final void J0(Map<String, SuperMarginDetailInfo> map, String str, String str2, String str3, Map<String, BigDecimal> map2) {
        SuperMarginDetailInfo superMarginDetailInfo;
        if (map.get(str2) == null) {
            superMarginDetailInfo = new SuperMarginDetailInfo();
            superMarginDetailInfo.setCurrency(str2);
            superMarginDetailInfo.setDisplayName(d7.k.C().z(str2));
            map.put(str2, superMarginDetailInfo);
        } else {
            superMarginDetailInfo = map.get(str2);
        }
        if (map2.containsKey(str2)) {
            superMarginDetailInfo.setEstimateAmountToBtc(m.a(superMarginDetailInfo.getEstimateAmountToBtc()).add(map2.get(str2).multiply(m.a(str3))).toPlainString());
        }
        superMarginDetailInfo.setEstimateAmount(m.a(superMarginDetailInfo.getEstimateAmount()).add(m.a(LegalCurrencyConfigUtil.G(str3, str2, TradeType.PRO))).toPlainString());
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1266085216:
                if (str.equals("frozen")) {
                    c11 = 0;
                    break;
                }
                break;
            case 3327216:
                if (str.equals("loan")) {
                    c11 = 1;
                    break;
                }
                break;
            case 110621028:
                if (str.equals("trade")) {
                    c11 = 2;
                    break;
                }
                break;
            case 570402602:
                if (str.equals("interest")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                superMarginDetailInfo.setOnOrders(str3);
                return;
            case 1:
                superMarginDetailInfo.setLoan(str3);
                return;
            case 2:
                superMarginDetailInfo.setAvaialAble(str3);
                return;
            case 3:
                superMarginDetailInfo.setInterest(str3);
                return;
            default:
                return;
        }
    }

    public Observable<SwapDataTotal> J1(boolean z11) {
        Observable<SwapUserInfo.UserBean> observable;
        SwapUserInfo.UserBean h11 = z.f().h();
        if (h11 == null || h11.getActiveState() != 1) {
            observable = z.f().g(false).subscribeOn(Schedulers.io()).onErrorResumeNext(Observable.just(null));
        } else {
            observable = Observable.just(h11);
        }
        return Observable.zip(l9.a.a().L((String) null).b().subscribeOn(Schedulers.io()).onErrorResumeNext(i1.f54051b), e.e().f(z11, (String) null).subscribeOn(Schedulers.io()), qs.a.f84586a.f(z11).onErrorReturn(h1.f54039b), observable, LegalCurrencyConfigUtil.S(TradeType.PRO, z11).compose(RxJavaHelper.s()).onErrorResumeNext(Observable.just(null)), new d2(this));
    }

    public void J3(AccountRiskInfo accountRiskInfo) {
        this.f84085n = accountRiskInfo;
    }

    public final SuperMarginDataTotal K0(Map<String, Map<String, String>> map, Map<String, SymbolPrice> map2, MarginOverview marginOverview) {
        String d11 = SymbolUtil.d();
        BigDecimal bigDecimal = BigDecimal.ZERO;
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            Map<String, BigDecimal> s12 = s1(d11, map2);
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                BigDecimal bigDecimal2 = bigDecimal;
                for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                    String str2 = (String) entry.getKey();
                    String str3 = (String) entry.getValue();
                    if (!(str2 == null || str == null)) {
                        J0(hashMap, str, str2, str3, s12);
                        bigDecimal2 = T0(d11, bigDecimal2, s12, str, str2, str3);
                    }
                }
                bigDecimal = bigDecimal2;
            }
        }
        SuperMarginDataTotal superMarginDataTotal = new SuperMarginDataTotal();
        superMarginDataTotal.setNetAssetToBtc(bigDecimal.toPlainString());
        superMarginDataTotal.setNetAsset(LegalCurrencyConfigUtil.D(m.u0(bigDecimal.toPlainString(), 12, 8), "btcusdt", TradeType.PRO));
        superMarginDataTotal.setDetailAsset(map == null ? new HashMap<>() : map);
        superMarginDataTotal.setDetailMap(hashMap);
        superMarginDataTotal.setMarginOverview(marginOverview);
        return superMarginDataTotal;
    }

    public Observable<BalanceDataTotal> K1(boolean z11) {
        TradeType tradeType = TradeType.PRO;
        return Observable.zip(w3(tradeType, false), LegalCurrencyConfigUtil.S(tradeType, z11).compose(RxJavaHelper.s()).onErrorResumeNext(Observable.just(null)), new x1(this));
    }

    public final void K3(List<BalanceDetailInfo> list, Map<String, BalanceDetailInfo> map, List<CurrencyBean> list2) {
        if (list != null && list2 != null && !list2.isEmpty()) {
            for (CurrencyBean next : list2) {
                if (!(next == null || next.getName() == null)) {
                    String name = next.getName();
                    if (map != null && map.get(name) == null) {
                        int g12 = g1(name, next);
                        boolean z11 = false;
                        boolean z12 = (g12 & 16) != 0;
                        boolean z13 = (g12 & 1) != 0;
                        boolean z14 = (g12 & 8) != 0;
                        if (!z12 && (z14 || z13)) {
                            z11 = true;
                        }
                        if (!z11) {
                            BalanceDetailInfo balanceDetailInfo = new BalanceDetailInfo();
                            balanceDetailInfo.setShow(true);
                            balanceDetailInfo.setTradeType(TradeType.PRO);
                            balanceDetailInfo.setCurrency(name);
                            balanceDetailInfo.setDisplayName(next.getDisplayName());
                            balanceDetailInfo.setAvaialAble("0.00");
                            balanceDetailInfo.setOnOrders("0.00");
                            balanceDetailInfo.setEstimateAmount("0.00");
                            balanceDetailInfo.setEstimateAmountToBtc("0.00");
                            balanceDetailInfo.setDescCanNotDeposit(DepositWithdrawHelper.n(next.getChainInfos()));
                            balanceDetailInfo.setDescCanNotWithDraw(DepositWithdrawHelper.o(next.getChainInfos()));
                            balanceDetailInfo.setDescInvisible(next.getSuspendVisibleDesc());
                            balanceDetailInfo.setStatus(g12);
                            list.add(balanceDetailInfo);
                            map.put(name, balanceDetailInfo);
                        }
                    }
                }
            }
        }
    }

    public final MineDataTotal L0(Map<String, Map<String, String>> map, Map<String, SymbolPrice> map2) {
        String d11 = SymbolUtil.d();
        BigDecimal bigDecimal = BigDecimal.ZERO;
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            Map<String, BigDecimal> s12 = s1(d11, map2);
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                BigDecimal bigDecimal2 = bigDecimal;
                for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                    String str2 = (String) entry.getKey();
                    String str3 = (String) entry.getValue();
                    if (!(str2 == null || str == null)) {
                        H0(hashMap, str, str2, str3, s12);
                        bigDecimal2 = R0(d11, bigDecimal2, s12, str, str2, str3);
                    }
                }
                bigDecimal = bigDecimal2;
            }
        }
        MineDataTotal mineDataTotal = new MineDataTotal();
        mineDataTotal.setNetAssetToBtc(bigDecimal.toPlainString());
        mineDataTotal.setNetAsset(LegalCurrencyConfigUtil.D(m.u0(bigDecimal.toPlainString(), 12, 8), "btcusdt", TradeType.PRO));
        mineDataTotal.setDetailAsset(map == null ? new HashMap<>() : map);
        ArrayList arrayList = new ArrayList(hashMap.values());
        Collections.sort(arrayList, o1.f54119b);
        mineDataTotal.setDetailInfos(arrayList);
        return mineDataTotal;
    }

    public Observable<C2CLendBalanceDataTotal> L1(boolean z11) {
        return Observable.zip(b.a().requestC2CAccountOutNetAsset().b().subscribeOn(Schedulers.io()), LegalCurrencyConfigUtil.f(z11).compose(RxJavaHelper.s()).onErrorResumeNext(Observable.just(null)), new t1(this));
    }

    public void L3(List<C2CLendBalanceDetailInfo> list, List<C2CCurrencyBean> list2) {
        if (list != null) {
            HashSet hashSet = new HashSet();
            if (!list.isEmpty()) {
                for (s9.a next : list) {
                    if (next instanceof BaseAssetInfo) {
                        hashSet.add(((BaseAssetInfo) next).getDelegateKey());
                    }
                }
            }
            for (C2CCurrencyBean currency : list2) {
                String currency2 = currency.getCurrency();
                if (!hashSet.contains(currency2)) {
                    C2CLendBalanceDetailInfo c2CLendBalanceDetailInfo = new C2CLendBalanceDetailInfo();
                    c2CLendBalanceDetailInfo.setCurrency(currency2);
                    c2CLendBalanceDetailInfo.setDisplayName(d7.k.C().z(currency2));
                    c2CLendBalanceDetailInfo.setEarnings("0.00");
                    c2CLendBalanceDetailInfo.setLending("0.00");
                    c2CLendBalanceDetailInfo.setTrade("0.00");
                    c2CLendBalanceDetailInfo.setEstimateAmountToBtc("0.00");
                    c2CLendBalanceDetailInfo.setEstimateAmount("0.00");
                    list.add(c2CLendBalanceDetailInfo);
                }
            }
        }
    }

    public final SavingsDataTotal M0(Map<String, Map<String, String>> map, Map<String, SymbolPrice> map2) {
        String d11 = SymbolUtil.d();
        BigDecimal bigDecimal = BigDecimal.ZERO;
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            Map<String, BigDecimal> s12 = s1(d11, map2);
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                BigDecimal bigDecimal2 = bigDecimal;
                for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                    String str2 = (String) entry.getKey();
                    String str3 = (String) entry.getValue();
                    if (!(str2 == null || str == null)) {
                        I0(hashMap, str, str2, str3, s12);
                        bigDecimal2 = S0(d11, bigDecimal2, s12, str, str2, str3);
                    }
                }
                bigDecimal = bigDecimal2;
            }
        }
        SavingsDataTotal savingsDataTotal = new SavingsDataTotal();
        savingsDataTotal.setNetAssetToBtc(bigDecimal.toPlainString());
        savingsDataTotal.setNetAsset(LegalCurrencyConfigUtil.D(m.u0(bigDecimal.toPlainString(), 12, 8), "btcusdt", TradeType.PRO));
        savingsDataTotal.setDetailAsset(map == null ? new HashMap<>() : map);
        ArrayList arrayList = new ArrayList(hashMap.values());
        Collections.sort(arrayList, g2.f54028b);
        savingsDataTotal.setDetailInfos(arrayList);
        return savingsDataTotal;
    }

    public Observable<C2CMarginBalanceDataTotal> M1(boolean z11, String str) {
        return Observable.zip(C3(z11, str), LegalCurrencyConfigUtil.f(z11).compose(RxJavaHelper.s()).onErrorResumeNext(Observable.just(null)), new y1(this)).subscribeOn(Schedulers.io());
    }

    public void M3(List<C2CMarginBalanceDetailInfo> list, List<C2CSymbolBean> list2) {
        if (list != null) {
            HashSet hashSet = new HashSet();
            if (!list.isEmpty()) {
                for (s9.a next : list) {
                    if (next instanceof BaseAssetInfo) {
                        hashSet.add(((BaseAssetInfo) next).getDelegateKey());
                    }
                }
            }
            for (C2CSymbolBean next2 : list2) {
                String str = next2.getBaseCurrency() + next2.getQuoteCurrency();
                if (!hashSet.contains(str)) {
                    C2CMarginBalanceDetailInfo c2CMarginBalanceDetailInfo = new C2CMarginBalanceDetailInfo();
                    c2CMarginBalanceDetailInfo.setBaseCurrency(next2.getBaseCurrency());
                    c2CMarginBalanceDetailInfo.setBaseCurrencyDisplayName(a1.v().p(str));
                    c2CMarginBalanceDetailInfo.setQuoteCurrency(next2.getQuoteCurrency());
                    c2CMarginBalanceDetailInfo.setQuoteCurrencyDisplayName(a1.v().F(str));
                    c2CMarginBalanceDetailInfo.setSymbol(str);
                    c2CMarginBalanceDetailInfo.setBaseCurrencyAvaiable("0.00");
                    c2CMarginBalanceDetailInfo.setBaseCurrencyOnorders("0.00");
                    c2CMarginBalanceDetailInfo.setBaseCurrencyLoaned("0.00");
                    c2CMarginBalanceDetailInfo.setQuoteCurrencyAvaiable("0.00");
                    c2CMarginBalanceDetailInfo.setQuoteCurrencyOnorders("0.00");
                    c2CMarginBalanceDetailInfo.setQuoteCurrencyLoaned("0.00");
                    c2CMarginBalanceDetailInfo.setEstimateAmount("0.00");
                    list.add(c2CMarginBalanceDetailInfo);
                }
            }
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.String> N0(java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r21, java.lang.String r22) {
        /*
            r20 = this;
            r1 = r22
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            if (r21 == 0) goto L_0x0206
            boolean r0 = r21.isEmpty()
            if (r0 == 0) goto L_0x0011
            goto L_0x0206
        L_0x0011:
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.PRO
            java.util.Map r0 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.P(r0)
            if (r0 == 0) goto L_0x0029
            int r4 = r0.size()
            if (r4 <= 0) goto L_0x0029
            dt.h2 r4 = t1()
            java.util.Map r0 = r4.s1(r1, r0)
            r4 = r0
            goto L_0x002a
        L_0x0029:
            r4 = 0
        L_0x002a:
            java.lang.String r5 = "0.00"
            java.util.Set r0 = r21.entrySet()
            java.util.Iterator r6 = r0.iterator()
        L_0x0034:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0206
            java.lang.Object r0 = r6.next()
            r7 = r0
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r0 = r7.getValue()
            java.util.Map r0 = (java.util.Map) r0
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r8 = r0.iterator()
        L_0x004f:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x0034
            java.lang.Object r0 = r8.next()
            r9 = r0
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r0 = r9.getKey()
            if (r0 != 0) goto L_0x0063
            goto L_0x004f
        L_0x0063:
            java.lang.Object r0 = r9.getKey()
            java.lang.Object r0 = r2.get(r0)
            java.lang.String r11 = "trade"
            java.lang.String r13 = "lock"
            r14 = 1
            java.lang.String r15 = "frozen"
            r16 = 0
            java.lang.String r3 = "credit"
            r17 = -1
            if (r0 != 0) goto L_0x0130
            java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch:{ Exception -> 0x0088 }
            java.lang.Object r18 = r9.getValue()     // Catch:{ Exception -> 0x0088 }
            r10 = r18
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0088 }
            r0.<init>(r10)     // Catch:{ Exception -> 0x0088 }
            goto L_0x008e
        L_0x0088:
            r0 = move-exception
            r0.printStackTrace()
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
        L_0x008e:
            java.lang.String r0 = r0.toPlainString()
            java.lang.Object r10 = r9.getKey()
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L_0x009d
            goto L_0x00c0
        L_0x009d:
            if (r4 == 0) goto L_0x00bf
            int r10 = r4.size()
            if (r10 <= 0) goto L_0x00bf
            java.lang.Object r10 = r9.getKey()
            java.lang.Object r10 = r4.get(r10)
            java.math.BigDecimal r10 = (java.math.BigDecimal) r10
            if (r10 == 0) goto L_0x00bf
            java.math.BigDecimal r12 = new java.math.BigDecimal
            r12.<init>(r0)
            java.math.BigDecimal r0 = r12.multiply(r10)
            java.lang.String r0 = r0.toPlainString()
            goto L_0x00c0
        L_0x00bf:
            r0 = 0
        L_0x00c0:
            java.lang.Object r10 = r7.getKey()
            java.lang.String r10 = (java.lang.String) r10
            r10.hashCode()
            int r12 = r10.hashCode()
            switch(r12) {
                case -1352291591: goto L_0x00ee;
                case -1266085216: goto L_0x00e5;
                case 3327275: goto L_0x00dc;
                case 110621028: goto L_0x00d3;
                default: goto L_0x00d0;
            }
        L_0x00d0:
            r10 = r17
            goto L_0x00f7
        L_0x00d3:
            boolean r3 = r10.equals(r11)
            if (r3 != 0) goto L_0x00da
            goto L_0x00d0
        L_0x00da:
            r10 = 3
            goto L_0x00f7
        L_0x00dc:
            boolean r3 = r10.equals(r13)
            if (r3 != 0) goto L_0x00e3
            goto L_0x00d0
        L_0x00e3:
            r10 = 2
            goto L_0x00f7
        L_0x00e5:
            boolean r3 = r10.equals(r15)
            if (r3 != 0) goto L_0x00ec
            goto L_0x00d0
        L_0x00ec:
            r10 = r14
            goto L_0x00f7
        L_0x00ee:
            boolean r3 = r10.equals(r3)
            if (r3 != 0) goto L_0x00f5
            goto L_0x00d0
        L_0x00f5:
            r10 = r16
        L_0x00f7:
            switch(r10) {
                case 0: goto L_0x010e;
                case 1: goto L_0x00fc;
                case 2: goto L_0x00fc;
                case 3: goto L_0x00fc;
                default: goto L_0x00fa;
            }
        L_0x00fa:
            goto L_0x004f
        L_0x00fc:
            java.lang.Object r3 = r9.getKey()
            java.lang.String r3 = (java.lang.String) r3
            boolean r9 = android.text.TextUtils.isEmpty(r0)
            if (r9 == 0) goto L_0x0109
            r0 = r5
        L_0x0109:
            r2.put(r3, r0)
            goto L_0x004f
        L_0x010e:
            java.lang.Object r3 = r9.getKey()
            java.lang.String r3 = (java.lang.String) r3
            boolean r9 = android.text.TextUtils.isEmpty(r0)
            if (r9 == 0) goto L_0x011c
            r0 = r5
            goto L_0x012b
        L_0x011c:
            java.math.BigDecimal r9 = java.math.BigDecimal.ZERO
            java.math.BigDecimal r10 = new java.math.BigDecimal
            r10.<init>(r0)
            java.math.BigDecimal r0 = r9.subtract(r10)
            java.lang.String r0 = r0.toPlainString()
        L_0x012b:
            r2.put(r3, r0)
            goto L_0x004f
        L_0x0130:
            java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch:{ Exception -> 0x013c }
            java.lang.Object r10 = r9.getValue()     // Catch:{ Exception -> 0x013c }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x013c }
            r0.<init>(r10)     // Catch:{ Exception -> 0x013c }
            goto L_0x0142
        L_0x013c:
            r0 = move-exception
            r0.printStackTrace()
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
        L_0x0142:
            java.lang.String r0 = r0.toPlainString()
            java.lang.Object r10 = r9.getKey()
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L_0x0151
            goto L_0x0174
        L_0x0151:
            if (r4 == 0) goto L_0x0173
            int r10 = r4.size()
            if (r10 <= 0) goto L_0x0173
            java.lang.Object r10 = r9.getKey()
            java.lang.Object r10 = r4.get(r10)
            java.math.BigDecimal r10 = (java.math.BigDecimal) r10
            if (r10 == 0) goto L_0x0173
            java.math.BigDecimal r12 = new java.math.BigDecimal
            r12.<init>(r0)
            java.math.BigDecimal r0 = r12.multiply(r10)
            java.lang.String r0 = r0.toPlainString()
            goto L_0x0174
        L_0x0173:
            r0 = 0
        L_0x0174:
            java.math.BigDecimal r10 = new java.math.BigDecimal
            boolean r12 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r19 = "0"
            if (r12 == 0) goto L_0x0180
            r0 = r19
        L_0x0180:
            r10.<init>(r0)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            java.lang.Object r12 = r9.getValue()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L_0x0192
            goto L_0x019e
        L_0x0192:
            java.lang.Object r12 = r9.getKey()
            java.lang.Object r12 = r2.get(r12)
            r19 = r12
            java.lang.String r19 = (java.lang.String) r19
        L_0x019e:
            r12 = r19
            r0.<init>(r12)
            java.lang.Object r12 = r7.getKey()
            java.lang.String r12 = (java.lang.String) r12
            r12.hashCode()
            int r19 = r12.hashCode()
            switch(r19) {
                case -1352291591: goto L_0x01d2;
                case -1266085216: goto L_0x01c8;
                case 3327275: goto L_0x01be;
                case 110621028: goto L_0x01b4;
                default: goto L_0x01b3;
            }
        L_0x01b3:
            goto L_0x01db
        L_0x01b4:
            boolean r3 = r12.equals(r11)
            if (r3 != 0) goto L_0x01bb
            goto L_0x01db
        L_0x01bb:
            r17 = 3
            goto L_0x01db
        L_0x01be:
            boolean r3 = r12.equals(r13)
            if (r3 != 0) goto L_0x01c5
            goto L_0x01db
        L_0x01c5:
            r17 = 2
            goto L_0x01db
        L_0x01c8:
            boolean r3 = r12.equals(r15)
            if (r3 != 0) goto L_0x01cf
            goto L_0x01db
        L_0x01cf:
            r17 = r14
            goto L_0x01db
        L_0x01d2:
            boolean r3 = r12.equals(r3)
            if (r3 != 0) goto L_0x01d9
            goto L_0x01db
        L_0x01d9:
            r17 = r16
        L_0x01db:
            switch(r17) {
                case 0: goto L_0x01f3;
                case 1: goto L_0x01e0;
                case 2: goto L_0x01e0;
                case 3: goto L_0x01e0;
                default: goto L_0x01de;
            }
        L_0x01de:
            goto L_0x004f
        L_0x01e0:
            java.lang.Object r3 = r9.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.math.BigDecimal r0 = r10.add(r0)
            java.lang.String r0 = r0.toPlainString()
            r2.put(r3, r0)
            goto L_0x004f
        L_0x01f3:
            java.lang.Object r3 = r9.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.math.BigDecimal r0 = r0.subtract(r10)
            java.lang.String r0 = r0.toPlainString()
            r2.put(r3, r0)
            goto L_0x004f
        L_0x0206:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: dt.h2.N0(java.util.Map, java.lang.String):java.util.Map");
    }

    public Observable<MarginBalanceDataTotal> N1(TradeType tradeType, boolean z11, boolean z12, String str) {
        return Observable.zip(I3(tradeType, false, z12, str), LegalCurrencyConfigUtil.f(z11).compose(RxJavaHelper.s()).onErrorResumeNext(Observable.just(null)), new w1(this));
    }

    public void N3(List<MarginBalanceDetailInfo> list) {
        if (list != null) {
            HashSet hashSet = new HashSet();
            if (!list.isEmpty()) {
                for (s9.a next : list) {
                    if (next instanceof BaseAssetInfo) {
                        hashSet.add(((BaseAssetInfo) next).getDelegateKey());
                    }
                }
            }
            for (SymbolBean next2 : a1.v().Z(TradeType.MARGIN)) {
                String symbol = next2.getSymbol();
                if (!hashSet.contains(symbol)) {
                    MarginBalanceDetailInfo marginBalanceDetailInfo = new MarginBalanceDetailInfo();
                    marginBalanceDetailInfo.setBaseCurrency(next2.getBaseCurrency());
                    marginBalanceDetailInfo.setQuoteCurrency(next2.getQuoteCurrency());
                    marginBalanceDetailInfo.setBaseCurrencyDisplayName(next2.getBaseCurrencyDisplayName());
                    marginBalanceDetailInfo.setQuoteCurrencyDisplayName(next2.getQuoteCurrencyDisplayName());
                    marginBalanceDetailInfo.setSymbol(symbol);
                    marginBalanceDetailInfo.setBaseCurrencyAvaiable("0.00");
                    marginBalanceDetailInfo.setBaseCurrencyOnorders("0.00");
                    marginBalanceDetailInfo.setBaseCurrencyLoaned("0.00");
                    marginBalanceDetailInfo.setQuoteCurrencyAvaiable("0.00");
                    marginBalanceDetailInfo.setQuoteCurrencyOnorders("0.00");
                    marginBalanceDetailInfo.setQuoteCurrencyLoaned("0.00");
                    marginBalanceDetailInfo.setEstimateAmount("0.00");
                    list.add(marginBalanceDetailInfo);
                }
            }
        }
    }

    public final Map<String, Map<String, String>> O0(Map<String, Map<String, Map<String, String>>> map, String str) {
        BigDecimal bigDecimal;
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            Map<String, SymbolPrice> T = LegalCurrencyConfigUtil.T();
            Map<String, BigDecimal> map2 = null;
            if (T != null && T.size() > 0) {
                map2 = t1().s1(str, T);
            }
            for (Map.Entry next : map.entrySet()) {
                if (next.getKey() != null) {
                    HashMap hashMap2 = new HashMap();
                    for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                        for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                            if (entry2.getKey() != null) {
                                BigDecimal bigDecimal2 = BigDecimal.ZERO;
                                BigDecimal a11 = m.a((String) entry2.getValue());
                                if (str.equals(entry2.getKey())) {
                                    bigDecimal2 = a11;
                                } else if (!(map2 == null || map2.size() <= 0 || (bigDecimal = map2.get(entry2.getKey())) == null)) {
                                    bigDecimal2 = a11.multiply(bigDecimal);
                                }
                                BigDecimal a12 = m.a((String) hashMap2.get(entry2.getKey()));
                                String str2 = (String) entry.getKey();
                                str2.hashCode();
                                char c11 = 65535;
                                switch (str2.hashCode()) {
                                    case -1266085216:
                                        if (str2.equals("frozen")) {
                                            c11 = 0;
                                            break;
                                        }
                                        break;
                                    case 3327216:
                                        if (str2.equals("loan")) {
                                            c11 = 1;
                                            break;
                                        }
                                        break;
                                    case 110621028:
                                        if (str2.equals("trade")) {
                                            c11 = 2;
                                            break;
                                        }
                                        break;
                                    case 570402602:
                                        if (str2.equals("interest")) {
                                            c11 = 3;
                                            break;
                                        }
                                        break;
                                }
                                switch (c11) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                        hashMap2.put((String) entry2.getKey(), bigDecimal2.add(a12).toPlainString());
                                        break;
                                }
                            }
                        }
                    }
                    hashMap.put((String) next.getKey(), hashMap2);
                }
            }
        }
        return hashMap;
    }

    public Observable<MineDataTotal> O1(boolean z11) {
        return Observable.zip(w3(TradeType.MINE, false), LegalCurrencyConfigUtil.S(TradeType.PRO, z11).compose(RxJavaHelper.s()).onErrorResumeNext(Observable.just(null)), new u1(this));
    }

    public void O3(List<MineDetailInfo> list, List<MineAccountItem> list2) {
        if (list != null) {
            HashMap hashMap = new HashMap();
            if (!list.isEmpty()) {
                for (MineDetailInfo next : list) {
                    hashMap.put(StringUtils.i(next.getCurrency()), next);
                }
            }
            for (MineAccountItem next2 : list2) {
                String i11 = StringUtils.i(next2.getCurrency());
                if (hashMap.containsKey(i11)) {
                    ((MineDetailInfo) hashMap.get(i11)).setTransferable(next2.isTransferable());
                } else {
                    MineDetailInfo mineDetailInfo = new MineDetailInfo();
                    mineDetailInfo.setDisplayName(d7.k.C().z(i11));
                    mineDetailInfo.setCurrency(next2.getCurrency());
                    mineDetailInfo.setTransferable(next2.isTransferable());
                    mineDetailInfo.setEstimateAmount("0.00");
                    list.add(mineDetailInfo);
                }
            }
        }
    }

    public final void P0(List<BalanceDetailInfo> list, Map<String, Map<String, String>> map) {
        String str;
        if (list != null && !list.isEmpty() && map != null && !map.isEmpty()) {
            Map<String, String> N0 = N0(map, "usdt");
            Map<String, String> N02 = N0(map, "btc");
            Map<String, String> I = LegalCurrencyConfigUtil.I(N0);
            Iterator<BalanceDetailInfo> it2 = list.iterator();
            while (it2.hasNext()) {
                BalanceDetailInfo next = it2.next();
                String currency = next.getCurrency();
                int status = next.getStatus();
                boolean z11 = false;
                boolean z12 = (status & 16) != 0;
                boolean z13 = (status & 1) != 0;
                boolean z14 = (status & 8) != 0;
                String str2 = null;
                if (I == null) {
                    str = null;
                } else {
                    str = I.get(currency);
                }
                if (N02 != null) {
                    str2 = N02.get(currency);
                }
                boolean isZeroAmount = next.isZeroAmount();
                if (!z12 && isZeroAmount && (z14 || z13)) {
                    z11 = true;
                }
                if (z11) {
                    it2.remove();
                } else {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "0.00";
                    }
                    next.setEstimateAmountToBtc(str2);
                    if (next.isTruncationZero()) {
                        str = "0.00";
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = "0.00";
                    }
                    next.setEstimateAmount(str);
                }
            }
        }
    }

    public Observable<SavingsDataTotal> P1(boolean z11) {
        return Observable.zip(w3(TradeType.SAVINGS, z11), LegalCurrencyConfigUtil.S(TradeType.PRO, z11).compose(RxJavaHelper.s()).onErrorResumeNext(Observable.just(null)), new v1(this));
    }

    public void P3(List<SavingsDetailInfo> list, List<String> list2) {
        if (list != null) {
            HashMap hashMap = new HashMap();
            if (!list.isEmpty()) {
                for (SavingsDetailInfo next : list) {
                    hashMap.put(StringUtils.i(next.getCurrency()), next);
                }
            }
            for (String next2 : list2) {
                String i11 = StringUtils.i(next2);
                if (!hashMap.containsKey(i11)) {
                    SavingsDetailInfo savingsDetailInfo = new SavingsDetailInfo();
                    savingsDetailInfo.setDisplayName(d7.k.C().z(i11));
                    savingsDetailInfo.setCurrency(next2);
                    savingsDetailInfo.setEstimateAmount("0.00");
                    list.add(savingsDetailInfo);
                }
            }
        }
    }

    public final Map<String, Map<String, String>> Q0(Map<String, Map<String, Map<String, String>>> map, String str) {
        BigDecimal bigDecimal;
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            Map<String, SymbolPrice> T = LegalCurrencyConfigUtil.T();
            Map<String, BigDecimal> map2 = null;
            if (T != null && T.size() > 0) {
                map2 = t1().s1(str, T);
            }
            for (Map.Entry next : map.entrySet()) {
                if (next.getKey() != null) {
                    HashMap hashMap2 = new HashMap();
                    for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                        for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                            if (entry2.getKey() != null) {
                                BigDecimal bigDecimal2 = BigDecimal.ZERO;
                                BigDecimal a11 = m.a((String) entry2.getValue());
                                if (str.equals(entry2.getKey())) {
                                    bigDecimal2 = a11;
                                } else if (!(map2 == null || map2.size() <= 0 || (bigDecimal = map2.get(entry2.getKey())) == null)) {
                                    bigDecimal2 = a11.multiply(bigDecimal);
                                }
                                BigDecimal a12 = m.a((String) hashMap2.get(entry2.getKey()));
                                String str2 = (String) entry.getKey();
                                str2.hashCode();
                                char c11 = 65535;
                                switch (str2.hashCode()) {
                                    case -1352291591:
                                        if (str2.equals(BalanceQueryData.TYPE_CREDIT)) {
                                            c11 = 0;
                                            break;
                                        }
                                        break;
                                    case -1266085216:
                                        if (str2.equals("frozen")) {
                                            c11 = 1;
                                            break;
                                        }
                                        break;
                                    case 3327216:
                                        if (str2.equals("loan")) {
                                            c11 = 2;
                                            break;
                                        }
                                        break;
                                    case 110621028:
                                        if (str2.equals("trade")) {
                                            c11 = 3;
                                            break;
                                        }
                                        break;
                                    case 570402602:
                                        if (str2.equals("interest")) {
                                            c11 = 4;
                                            break;
                                        }
                                        break;
                                }
                                switch (c11) {
                                    case 0:
                                        hashMap2.put((String) entry2.getKey(), a12.subtract(bigDecimal2).toPlainString());
                                        break;
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                        hashMap2.put((String) entry2.getKey(), bigDecimal2.add(a12).toPlainString());
                                        break;
                                }
                            }
                        }
                    }
                    hashMap.put((String) next.getKey(), hashMap2);
                }
            }
        }
        return hashMap;
    }

    public Observable<SuperMarginDataTotal> Q1(boolean z11) {
        TradeType tradeType = TradeType.SUPERMARGIN;
        return Observable.zip(w3(tradeType, false).switchIfEmpty(Observable.just(null)).subscribeOn(Schedulers.io()), LegalCurrencyConfigUtil.S(TradeType.PRO, z11).compose(RxJavaHelper.s()).onErrorResumeNext(Observable.just(null)).subscribeOn(Schedulers.io()), b1(tradeType, AccountType.supermargin.toString()).switchIfEmpty(Observable.just(null)).flatMap(e1.f54014b), new c2(this));
    }

    public final void Q3(List<SubaccountQueryData> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (SubaccountQueryData next : list) {
                if (!(next == null || next.getSuspense() == null || m.a(next.getSuspense()).compareTo(BigDecimal.ZERO) == 0)) {
                    SubaccountQueryData subaccountQueryData = new SubaccountQueryData();
                    subaccountQueryData.setCurrency(next.getCurrency());
                    subaccountQueryData.setBalance(next.getSuspense());
                    subaccountQueryData.setType("frozen");
                    arrayList.add(subaccountQueryData);
                }
            }
            if (!arrayList.isEmpty()) {
                list.addAll(arrayList);
            }
        }
    }

    public final BigDecimal R0(String str, BigDecimal bigDecimal, Map<String, BigDecimal> map, String str2, String str3, String str4) {
        if (str3.equalsIgnoreCase(str)) {
            if ("trade".equals(str2) || "frozen".equals(str2) || "lock".equals(str2) || BalanceQueryData.TYPE_BANK.equals(str2)) {
                return bigDecimal.add(m.a(str4));
            }
            return bigDecimal;
        } else if (!map.containsKey(str3)) {
            return bigDecimal;
        } else {
            return ("trade".equals(str2) || "frozen".equals(str2) || "lock".equals(str2) || BalanceQueryData.TYPE_BANK.equals(str2)) ? bigDecimal.add(map.get(str3).multiply(m.a(str4))) : bigDecimal;
        }
    }

    public final void R3(List<Map.Entry<String, BigDecimal>> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, b.f53988b);
        }
    }

    public final BigDecimal S0(String str, BigDecimal bigDecimal, Map<String, BigDecimal> map, String str2, String str3, String str4) {
        boolean z11 = "trade".equals(str2) || "frozen".equals(str2) || "lending".equals(str2) || "earnings".equals(str2);
        if (str3.equalsIgnoreCase(str)) {
            if (z11) {
                return bigDecimal.add(m.a(str4));
            }
            return bigDecimal;
        } else if (!map.containsKey(str3)) {
            return bigDecimal;
        } else {
            return z11 ? bigDecimal.add(map.get(str3).multiply(m.a(str4))) : bigDecimal;
        }
    }

    public final BigDecimal T0(String str, BigDecimal bigDecimal, Map<String, BigDecimal> map, String str2, String str3, String str4) {
        if (str3.equalsIgnoreCase(str)) {
            if ("trade".equals(str2) || "frozen".equals(str2) || "loan".equals(str2) || "interest".equals(str2)) {
                return bigDecimal.add(m.a(str4));
            }
            return bigDecimal;
        } else if (!map.containsKey(str3)) {
            return bigDecimal;
        } else {
            return ("trade".equals(str2) || "frozen".equals(str2) || "loan".equals(str2) || "interest".equals(str2)) ? bigDecimal.add(map.get(str3).multiply(m.a(str4))) : bigDecimal;
        }
    }

    public Map<String, String> U0(List<AssertsTradeData> list) {
        HashMap hashMap = new HashMap();
        for (AssertsTradeData next : list) {
            hashMap.put(next.getCurrency(), next.getBalance());
        }
        return hashMap;
    }

    /* renamed from: V0 */
    public Map<String, String> b3(Map<String, Map<String, String>> map) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            Map map2 = map.get("trade");
            Map map3 = map.get(BalanceQueryData.TYPE_CREDIT);
            if (map2 != null && !map2.isEmpty()) {
                boolean z11 = map3 == null || map3.isEmpty();
                for (Map.Entry entry : map2.entrySet()) {
                    if (z11 || !map3.containsKey(entry.getKey())) {
                        hashMap.put((String) entry.getKey(), (String) entry.getValue());
                    } else {
                        hashMap.put((String) entry.getKey(), m.a((String) entry.getValue()).subtract(m.a((String) map3.get(entry.getKey()))).toPlainString());
                    }
                }
            }
        }
        return hashMap;
    }

    public void W0() {
        this.f84076e.clear();
        this.f84072a.clear();
        this.f84073b = null;
        this.f84075d = null;
        this.f84074c.clear();
        this.f84085n = null;
    }

    public final void X0(String str, Map<String, Map<String, String>> map, Map<String, CurrencyBean> map2, HashMap<String, BalanceDetailInfo> hashMap) {
        Map map3 = map.get(str);
        if (map3 != null && !map3.isEmpty()) {
            for (Map.Entry entry : map3.entrySet()) {
                String str2 = (String) entry.getKey();
                if (str2 != null) {
                    CurrencyBean currencyBean = null;
                    if (map2.containsKey(str2)) {
                        currencyBean = map2.get(str2);
                    }
                    if (currencyBean != null) {
                        if (hashMap.containsKey(str2)) {
                            BalanceDetailInfo balanceDetailInfo = hashMap.get(str2);
                            if ("trade".equals(str)) {
                                balanceDetailInfo.setAvaialAble((String) entry.getValue());
                            } else if ("frozen".equals(str)) {
                                balanceDetailInfo.setOnOrders((String) entry.getValue());
                            } else if ("lock".equals(str)) {
                                balanceDetailInfo.setLock((String) entry.getValue());
                            } else if (BalanceQueryData.TYPE_CREDIT.equals(str)) {
                                balanceDetailInfo.setCredit((String) entry.getValue());
                            }
                        } else {
                            BalanceDetailInfo balanceDetailInfo2 = new BalanceDetailInfo();
                            balanceDetailInfo2.setShow(true);
                            balanceDetailInfo2.setTradeType(TradeType.PRO);
                            if ("trade".equals(str)) {
                                balanceDetailInfo2.setAvaialAble((String) entry.getValue());
                                balanceDetailInfo2.setOnOrders("0.00");
                            } else if ("frozen".equals(str)) {
                                balanceDetailInfo2.setAvaialAble("0.00");
                                balanceDetailInfo2.setOnOrders((String) entry.getValue());
                            } else if ("lock".equals(str)) {
                                balanceDetailInfo2.setAvaialAble("0.00");
                                balanceDetailInfo2.setOnOrders("0.00");
                                balanceDetailInfo2.setLock((String) entry.getValue());
                            } else if (BalanceQueryData.TYPE_CREDIT.equals(str)) {
                                balanceDetailInfo2.setAvaialAble("0.00");
                                balanceDetailInfo2.setOnOrders("0.00");
                                balanceDetailInfo2.setLock("0.00");
                                balanceDetailInfo2.setCredit((String) entry.getValue());
                            }
                            balanceDetailInfo2.setCurrency(str2);
                            balanceDetailInfo2.setDisplayName(d7.k.C().z(str2));
                            balanceDetailInfo2.setDescCanNotDeposit(DepositWithdrawHelper.n(currencyBean.getChainInfos()));
                            balanceDetailInfo2.setDescCanNotWithDraw(DepositWithdrawHelper.o(currencyBean.getChainInfos()));
                            balanceDetailInfo2.setDescInvisible(currencyBean.getSuspendVisibleDesc());
                            balanceDetailInfo2.setStatus(g1(str2, currencyBean));
                            hashMap.put(str2, balanceDetailInfo2);
                        }
                    }
                }
            }
        }
    }

    public final C2CMarginBalanceDetailInfo Y0(C2CAccountInNetAssetResult c2CAccountInNetAssetResult, String str, String str2) {
        C2CMarginBalanceDetailInfo c2CMarginBalanceDetailInfo = new C2CMarginBalanceDetailInfo();
        String subtype = c2CAccountInNetAssetResult.getSubtype();
        c2CMarginBalanceDetailInfo.setSymbol(subtype);
        c2CMarginBalanceDetailInfo.setShow(true);
        c2CMarginBalanceDetailInfo.setState(c2CAccountInNetAssetResult.getState());
        a1 v11 = a1.v();
        TradeType tradeType = TradeType.PRO;
        String o11 = v11.o(subtype, tradeType);
        String E = a1.v().E(subtype, tradeType);
        c2CMarginBalanceDetailInfo.setBaseCurrency(o11);
        c2CMarginBalanceDetailInfo.setBaseCurrencyDisplayName(a1.v().p(subtype));
        c2CMarginBalanceDetailInfo.setQuoteCurrencyDisplayName(a1.v().F(subtype));
        c2CMarginBalanceDetailInfo.setQuoteCurrency(E);
        c2CMarginBalanceDetailInfo.setRiskRate(c2CAccountInNetAssetResult.getRisk());
        c2CMarginBalanceDetailInfo.setData(c2CAccountInNetAssetResult);
        HashMap hashMap = new HashMap();
        for (C2CAccountOutNetAssetInfo next : c2CAccountInNetAssetResult.getList()) {
            String currency = next.getCurrency();
            String balance = next.getBalance();
            String type = next.getType();
            Map map = (Map) hashMap.get(type);
            if (map == null) {
                map = new HashMap();
                hashMap.put(type, map);
            }
            map.put(currency, m.a((String) map.get(currency)).add(m.a(balance)).toPlainString());
        }
        c2CMarginBalanceDetailInfo.setBaseCurrencyAvaiable(BigDecimal.ZERO.toPlainString());
        c2CMarginBalanceDetailInfo.setQuoteCurrencyAvaiable(BigDecimal.ZERO.toPlainString());
        if (hashMap.get("trade") != null) {
            String str3 = (String) ((Map) hashMap.get("trade")).get(o11);
            if (str3 != null) {
                c2CMarginBalanceDetailInfo.setBaseCurrencyAvaiable(str3);
            }
            String str4 = (String) ((Map) hashMap.get("trade")).get(E);
            if (str4 != null) {
                c2CMarginBalanceDetailInfo.setQuoteCurrencyAvaiable(str4);
            }
        }
        c2CMarginBalanceDetailInfo.setBaseCurrencyOnorders(BigDecimal.ZERO.toPlainString());
        c2CMarginBalanceDetailInfo.setQuoteCurrencyOnorders(BigDecimal.ZERO.toPlainString());
        if (hashMap.get("frozen") != null) {
            String str5 = (String) ((Map) hashMap.get("frozen")).get(o11);
            if (str5 != null) {
                c2CMarginBalanceDetailInfo.setBaseCurrencyOnorders(str5);
            }
            String str6 = (String) ((Map) hashMap.get("frozen")).get(E);
            if (str6 != null) {
                c2CMarginBalanceDetailInfo.setQuoteCurrencyOnorders(str6);
            }
        }
        if (hashMap.get("loan") != null) {
            BigDecimal a11 = m.a((String) ((Map) hashMap.get("loan")).get(o11));
            if (a11.compareTo(BigDecimal.ZERO) < 0) {
                a11 = BigDecimal.ZERO.subtract(a11);
            }
            c2CMarginBalanceDetailInfo.setBaseCurrencyLoaned(a11.toPlainString());
            BigDecimal a12 = m.a((String) ((Map) hashMap.get("loan")).get(E));
            if (a12.compareTo(BigDecimal.ZERO) < 0) {
                a12 = BigDecimal.ZERO.subtract(a12);
            }
            c2CMarginBalanceDetailInfo.setQuoteCurrencyLoaned(a12.toPlainString());
        } else {
            c2CMarginBalanceDetailInfo.setBaseCurrencyLoaned(BigDecimal.ZERO.toPlainString());
            c2CMarginBalanceDetailInfo.setQuoteCurrencyLoaned(BigDecimal.ZERO.toPlainString());
        }
        c2CMarginBalanceDetailInfo.setEstimateToBtc(str);
        c2CMarginBalanceDetailInfo.setEstimateAmount(str2);
        return c2CMarginBalanceDetailInfo;
    }

    public LegalDetailInfo Z0(int i11, Map<Integer, String> map, Map<Integer, String> map2, Map<Integer, BigDecimal> map3) {
        int i12;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        LegalDetailInfo legalDetailInfo = new LegalDetailInfo();
        legalDetailInfo.setCoinId(i11);
        legalDetailInfo.setShow(true);
        MarketCoin.Coin h11 = OtcMarketPriceConfigUtil.h(i11);
        String str = "--";
        if (h11 != null) {
            i12 = h11.getCurrencyStatus();
            if (h11.getCoinCode() != null) {
                str = h11.getCoinCode().toLowerCase(Locale.US);
            }
            legalDetailInfo.setCurrency(str);
            legalDetailInfo.setDisplayName(d7.k.C().z(h11.getCoinCode()));
        } else {
            i12 = 7;
            legalDetailInfo.setCurrency(str);
            legalDetailInfo.setDisplayName(str);
        }
        legalDetailInfo.setStatus(i12);
        if (map != null && !map.isEmpty()) {
            if (map3.get(Integer.valueOf(i11)) == null) {
                bigDecimal = BigDecimal.ZERO;
            } else {
                bigDecimal = map3.get(Integer.valueOf(i11));
            }
            BigDecimal bigDecimal3 = BigDecimal.ZERO;
            BigDecimal bigDecimal4 = bigDecimal3;
            for (Map.Entry next : map.entrySet()) {
                if (next.getKey() != null) {
                    if (2 != ((Integer) next.getKey()).intValue()) {
                        String str2 = (String) next.getValue();
                        if (str2 == null) {
                            bigDecimal2 = BigDecimal.ZERO;
                        } else {
                            bigDecimal2 = new BigDecimal(str2);
                        }
                        bigDecimal3 = bigDecimal3.add(bigDecimal2.multiply(bigDecimal));
                        bigDecimal4 = bigDecimal4.add(bigDecimal2.multiply(m.a(map2.get(Integer.valueOf(i11)))));
                        if (((Integer) next.getKey()).intValue() == 0) {
                            legalDetailInfo.setAvaialAble(str2);
                        } else if (1 == ((Integer) next.getKey()).intValue()) {
                            legalDetailInfo.setOnOrders(str2);
                        }
                    } else {
                        legalDetailInfo.setBorrow((String) next.getValue());
                    }
                }
            }
            legalDetailInfo.setEstimateAmountToBtc(bigDecimal3.toPlainString());
            legalDetailInfo.setEstimateAmount(LegalCurrencyConfigUtil.L(bigDecimal4));
        }
        return legalDetailInfo;
    }

    public final MarginBalanceDetailInfo a1(MarginBalanceQueryData marginBalanceQueryData, String str, String str2) {
        MarginBalanceDetailInfo marginBalanceDetailInfo = new MarginBalanceDetailInfo();
        String symbol = marginBalanceQueryData.getSymbol();
        SymbolBean J = a1.v().J(symbol, TradeType.PRO);
        marginBalanceDetailInfo.setSymbol(symbol);
        marginBalanceDetailInfo.setShow(true);
        marginBalanceDetailInfo.setState(marginBalanceQueryData.getState());
        String baseCurrency = J.getBaseCurrency();
        String quoteCurrency = J.getQuoteCurrency();
        marginBalanceDetailInfo.setBaseCurrency(baseCurrency);
        marginBalanceDetailInfo.setQuoteCurrency(quoteCurrency);
        marginBalanceDetailInfo.setBaseCurrencyDisplayName(J.getBaseCurrencyDisplayName());
        marginBalanceDetailInfo.setQuoteCurrencyDisplayName(J.getQuoteCurrencyDisplayName());
        marginBalanceDetailInfo.setFlPrice(marginBalanceQueryData.getFlPrice());
        marginBalanceDetailInfo.setRiskRate(marginBalanceQueryData.getRiskRate());
        marginBalanceDetailInfo.setMarginBalanceQueryData(marginBalanceQueryData);
        HashMap hashMap = new HashMap();
        for (SubaccountQueryData next : marginBalanceQueryData.getList()) {
            String currency = next.getCurrency();
            String balance = next.getBalance();
            String type = next.getType();
            Map map = (Map) hashMap.get(type);
            if (map == null) {
                map = new HashMap();
                hashMap.put(type, map);
            }
            map.put(currency, m.a((String) map.get(currency)).add(m.a(balance)).toPlainString());
        }
        if (hashMap.get("trade") != null) {
            marginBalanceDetailInfo.setBaseCurrencyAvaiable((String) ((Map) hashMap.get("trade")).get(baseCurrency));
            marginBalanceDetailInfo.setQuoteCurrencyAvaiable((String) ((Map) hashMap.get("trade")).get(quoteCurrency));
        } else {
            marginBalanceDetailInfo.setBaseCurrencyAvaiable(BigDecimal.ZERO.toPlainString());
            marginBalanceDetailInfo.setQuoteCurrencyAvaiable(BigDecimal.ZERO.toPlainString());
        }
        if (hashMap.get("frozen") != null) {
            marginBalanceDetailInfo.setBaseCurrencyOnorders((String) ((Map) hashMap.get("frozen")).get(baseCurrency));
            marginBalanceDetailInfo.setQuoteCurrencyOnorders((String) ((Map) hashMap.get("frozen")).get(quoteCurrency));
        } else {
            marginBalanceDetailInfo.setBaseCurrencyOnorders(BigDecimal.ZERO.toPlainString());
            marginBalanceDetailInfo.setQuoteCurrencyOnorders(BigDecimal.ZERO.toPlainString());
        }
        if (hashMap.get("interest") != null) {
            marginBalanceDetailInfo.setBaseCurrencyInterest((String) ((Map) hashMap.get("interest")).get(baseCurrency));
            marginBalanceDetailInfo.setQuoteCurrencyInterest((String) ((Map) hashMap.get("interest")).get(quoteCurrency));
        } else {
            marginBalanceDetailInfo.setBaseCurrencyInterest(BigDecimal.ZERO.toPlainString());
            marginBalanceDetailInfo.setQuoteCurrencyInterest(BigDecimal.ZERO.toPlainString());
        }
        if (hashMap.get(BalanceQueryData.TYPE_CREDIT) != null) {
            marginBalanceDetailInfo.setBaseCurrencyCredit((String) ((Map) hashMap.get(BalanceQueryData.TYPE_CREDIT)).get(baseCurrency));
            marginBalanceDetailInfo.setQuoteCurrencyCredit((String) ((Map) hashMap.get(BalanceQueryData.TYPE_CREDIT)).get(quoteCurrency));
        } else {
            marginBalanceDetailInfo.setBaseCurrencyCredit(BigDecimal.ZERO.toPlainString());
            marginBalanceDetailInfo.setQuoteCurrencyCredit(BigDecimal.ZERO.toPlainString());
        }
        if (hashMap.get("loan") != null) {
            BigDecimal a11 = m.a((String) ((Map) hashMap.get("loan")).get(baseCurrency));
            if (a11.compareTo(BigDecimal.ZERO) < 0) {
                a11 = BigDecimal.ZERO.subtract(a11);
            }
            marginBalanceDetailInfo.setBaseCurrencyLoaned(a11.toPlainString());
            BigDecimal a12 = m.a((String) ((Map) hashMap.get("loan")).get(quoteCurrency));
            if (a12.compareTo(BigDecimal.ZERO) < 0) {
                a12 = BigDecimal.ZERO.subtract(a12);
            }
            marginBalanceDetailInfo.setQuoteCurrencyLoaned(a12.toPlainString());
        } else {
            marginBalanceDetailInfo.setBaseCurrencyLoaned(BigDecimal.ZERO.toPlainString());
            marginBalanceDetailInfo.setQuoteCurrencyLoaned(BigDecimal.ZERO.toPlainString());
        }
        marginBalanceDetailInfo.setEstimateToBtc(str);
        marginBalanceDetailInfo.setEstimateAmount(str2);
        return marginBalanceDetailInfo;
    }

    public Observable<Long> b1(TradeType tradeType, String str) {
        AccountQueryData accountQueryData = this.f84076e.get(str);
        if (accountQueryData != null) {
            return Observable.just(Long.valueOf(accountQueryData.getId()));
        }
        return a.a().getAccounts().b().flatMap(p1.f54126b).doOnNext(new c(this)).filter(new n0(str)).map(r0.f54141b);
    }

    public AccountRiskInfo c1() {
        return this.f84085n;
    }

    public BalanceDataTotal d1(String str, Map<String, Map<String, String>> map, Map<String, SymbolPrice> map2, TradeType tradeType) {
        BigDecimal add;
        String str2 = str;
        Map<String, Map<String, String>> map3 = map;
        TradeType tradeType2 = tradeType;
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (map3 != null && !map.isEmpty()) {
            Map<String, BigDecimal> s12 = s1(str2, map2);
            for (Map.Entry next : map.entrySet()) {
                for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                    if (entry.getKey() != null) {
                        if (((String) entry.getKey()).equalsIgnoreCase(str2)) {
                            if (TradeType.PRO == tradeType2) {
                                if ("trade".equals(next.getKey()) || "frozen".equals(next.getKey()) || "lock".equals(next.getKey())) {
                                    bigDecimal = bigDecimal.add(m.a((String) entry.getValue()));
                                } else if (BalanceQueryData.TYPE_CREDIT.equals(next.getKey())) {
                                    bigDecimal = bigDecimal.subtract(m.a((String) entry.getValue()));
                                }
                            } else if (!"loan".equals(next.getKey())) {
                                if (BalanceQueryData.TYPE_CREDIT.equals(next.getKey())) {
                                    bigDecimal = bigDecimal.subtract(m.a((String) entry.getValue()));
                                } else {
                                    bigDecimal = bigDecimal.add(m.a((String) entry.getValue()));
                                }
                            }
                        } else if (s12.containsKey(entry.getKey())) {
                            BigDecimal bigDecimal2 = s12.get(entry.getKey());
                            if (entry.getValue() == null) {
                                break;
                            }
                            BigDecimal bigDecimal3 = new BigDecimal((String) entry.getValue());
                            if (TradeType.PRO == tradeType2) {
                                if ("trade".equals(next.getKey()) || "frozen".equals(next.getKey()) || "lock".equals(next.getKey())) {
                                    add = bigDecimal.add(bigDecimal2.multiply(bigDecimal3));
                                } else if (BalanceQueryData.TYPE_CREDIT.equals(next.getKey())) {
                                    add = bigDecimal.subtract(bigDecimal2.multiply(bigDecimal3));
                                }
                            } else if (!"loan".equals(next.getKey())) {
                                if (BalanceQueryData.TYPE_CREDIT.equals(next.getKey())) {
                                    add = bigDecimal.subtract(bigDecimal2.multiply(bigDecimal3));
                                } else {
                                    add = bigDecimal.add(bigDecimal2.multiply(bigDecimal3));
                                }
                            }
                            bigDecimal = add;
                        }
                        str2 = str;
                    }
                }
                str2 = str;
            }
        }
        BalanceDataTotal balanceDataTotal = new BalanceDataTotal();
        balanceDataTotal.setNetAssetToBtc(bigDecimal.toPlainString());
        balanceDataTotal.setNetAsset(LegalCurrencyConfigUtil.D(m.u0(bigDecimal.toPlainString(), 12, 8), "btcusdt", TradeType.PRO));
        balanceDataTotal.setDetailAsset(map3 == null ? new HashMap<>() : map3);
        balanceDataTotal.setDetailInfos(f1(map3, balanceDataTotal));
        return balanceDataTotal;
    }

    public Comparator<BaseAssetInfo> e1() {
        if (this.f84077f == null) {
            this.f84077f = w.f54185b;
        }
        return this.f84077f;
    }

    public List<BalanceDetailInfo> f1(Map<String, Map<String, String>> map, BalanceDataTotal balanceDataTotal) {
        ArrayList arrayList = new ArrayList();
        if (map == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        List<CurrencyBean> w11 = d7.k.C().w();
        HashMap hashMap2 = new HashMap();
        if (w11 != null) {
            for (CurrencyBean next : w11) {
                hashMap2.put(next.getName(), next);
            }
        }
        X0("trade", map, hashMap2, hashMap);
        X0("frozen", map, hashMap2, hashMap);
        X0("lock", map, hashMap2, hashMap);
        X0(BalanceQueryData.TYPE_CREDIT, map, hashMap2, hashMap);
        balanceDataTotal.setDetailInfoMap(hashMap);
        if (!hashMap.isEmpty()) {
            for (Map.Entry key : hashMap.entrySet()) {
                arrayList.add((BalanceDetailInfo) hashMap.get(key.getKey()));
            }
        }
        P0(arrayList, map);
        K3(arrayList, hashMap, w11);
        Collections.sort(arrayList, e1());
        return arrayList;
    }

    public int g1(String str, CurrencyBean currencyBean) {
        int b11 = currencyBean != null ? DepositWithdrawHelper.b(currencyBean) : 1;
        MarketCoin.Coin i11 = OtcMarketPriceConfigUtil.i(str);
        return (i11 == null || !i11.isTrade()) ? b11 | 32 : b11;
    }

    public final List<C2CAccountInNetAssetResult> h1(String str) {
        if (str == null) {
            return new ArrayList(this.f84074c.values());
        }
        boolean z11 = !str.contains(Constants.ACCEPT_TIME_SEPARATOR_SP);
        ArrayList arrayList = new ArrayList();
        Map<String, C2CAccountInNetAssetResult> map = this.f84074c;
        if (map != null) {
            if (!z11) {
                for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    if (this.f84074c.get(str2) != null) {
                        arrayList.add(this.f84074c.get(str2));
                    }
                }
            } else if (map.get(str) != null) {
                arrayList.add(this.f84074c.get(str));
            }
        }
        return arrayList;
    }

    public final C2CLendBalanceDataTotal i1(List<C2CLendBalanceDetailInfo> list) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (C2CLendBalanceDetailInfo estimateAmountToBtc : list) {
            bigDecimal = m.a(estimateAmountToBtc.getEstimateAmountToBtc()).add(bigDecimal);
        }
        C2CLendBalanceDataTotal c2CLendBalanceDataTotal = new C2CLendBalanceDataTotal();
        c2CLendBalanceDataTotal.setNetAssetToBtc(bigDecimal.toString());
        c2CLendBalanceDataTotal.setNetAsset(LegalCurrencyConfigUtil.D(m.u0(bigDecimal.toPlainString(), 12, 8), "btcusdt", TradeType.PRO));
        c2CLendBalanceDataTotal.setDetailInfoList(list);
        return c2CLendBalanceDataTotal;
    }

    public Comparator<C2CLendBalanceDetailInfo> j1() {
        if (this.f84080i == null) {
            this.f84080i = h0.f54038b;
        }
        return this.f84080i;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.huobi.finance.bean.C2CLendBalanceDetailInfo> k1(com.hbg.lib.network.hbg.core.bean.C2CAccountOutNetAssetResult r7, java.util.Map<java.lang.String, com.hbg.lib.network.pro.socket.bean.SymbolPrice> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "btc"
            java.util.Map r8 = r6.s1(r0, r8)
            java.util.List r7 = r7.getList()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x0013:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x008e
            java.lang.Object r1 = r7.next()
            com.hbg.lib.network.hbg.core.bean.C2CAccountOutNetAssetInfo r1 = (com.hbg.lib.network.hbg.core.bean.C2CAccountOutNetAssetInfo) r1
            java.lang.String r2 = r1.getCurrency()
            java.lang.Object r3 = r0.get(r2)
            if (r3 != 0) goto L_0x0040
            com.huobi.finance.bean.C2CLendBalanceDetailInfo r3 = new com.huobi.finance.bean.C2CLendBalanceDetailInfo
            r3.<init>()
            r3.setCurrency(r2)
            d7.k r4 = d7.k.C()
            java.lang.String r4 = r4.z(r2)
            r3.setDisplayName(r4)
            r0.put(r2, r3)
            goto L_0x0047
        L_0x0040:
            java.lang.Object r2 = r0.get(r2)
            r3 = r2
            com.huobi.finance.bean.C2CLendBalanceDetailInfo r3 = (com.huobi.finance.bean.C2CLendBalanceDetailInfo) r3
        L_0x0047:
            java.lang.String r2 = r1.getBalance()
            java.lang.String r1 = r1.getType()
            r1.hashCode()
            r4 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -807723863: goto L_0x0071;
                case 62364819: goto L_0x0066;
                case 110621028: goto L_0x005b;
                default: goto L_0x005a;
            }
        L_0x005a:
            goto L_0x007b
        L_0x005b:
            java.lang.String r5 = "trade"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0064
            goto L_0x007b
        L_0x0064:
            r4 = 2
            goto L_0x007b
        L_0x0066:
            java.lang.String r5 = "lending"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x006f
            goto L_0x007b
        L_0x006f:
            r4 = 1
            goto L_0x007b
        L_0x0071:
            java.lang.String r5 = "earnings"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r4 = 0
        L_0x007b:
            switch(r4) {
                case 0: goto L_0x0087;
                case 1: goto L_0x0083;
                case 2: goto L_0x007f;
                default: goto L_0x007e;
            }
        L_0x007e:
            goto L_0x008a
        L_0x007f:
            r3.setTrade(r2)
            goto L_0x008a
        L_0x0083:
            r3.setLending(r2)
            goto L_0x008a
        L_0x0087:
            r3.setEarnings(r2)
        L_0x008a:
            r3.calculateEstimate(r8)
            goto L_0x0013
        L_0x008e:
            java.util.ArrayList r7 = new java.util.ArrayList
            java.util.Collection r8 = r0.values()
            r7.<init>(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: dt.h2.k1(com.hbg.lib.network.hbg.core.bean.C2CAccountOutNetAssetResult, java.util.Map):java.util.List");
    }

    public final C2CMarginBalanceDataTotal l1(String str, Map<String, Map<String, Map<String, String>>> map, Map<String, SymbolPrice> map2) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (map != null && !map.isEmpty()) {
            Map<String, BigDecimal> s12 = s1(str, map2);
            for (Map.Entry<String, Map<String, Map<String, String>>> value : map.entrySet()) {
                for (Map.Entry entry : ((Map) value.getValue()).entrySet()) {
                    for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                        if (((String) entry2.getKey()).equalsIgnoreCase(str)) {
                            if (((String) entry.getKey()).equals("trade") || ((String) entry.getKey()).equals("frozen") || ((String) entry.getKey()).equals("interest") || ((String) entry.getKey()).equals("loan")) {
                                bigDecimal = bigDecimal.add(m.a((String) entry2.getValue()));
                            }
                        } else if (s12.containsKey(entry2.getKey())) {
                            BigDecimal bigDecimal2 = s12.get(entry2.getKey());
                            BigDecimal bigDecimal3 = new BigDecimal((String) entry2.getValue());
                            if (((String) entry.getKey()).equals("trade") || ((String) entry.getKey()).equals("frozen") || ((String) entry.getKey()).equals("interest") || ((String) entry.getKey()).equals("loan")) {
                                bigDecimal = bigDecimal.add(bigDecimal2.multiply(bigDecimal3));
                            }
                        }
                    }
                }
            }
        }
        C2CMarginBalanceDataTotal c2CMarginBalanceDataTotal = new C2CMarginBalanceDataTotal();
        c2CMarginBalanceDataTotal.setTotalAssetToBtc(bigDecimal.toPlainString());
        c2CMarginBalanceDataTotal.setTotalAsset(LegalCurrencyConfigUtil.D(m.u0(bigDecimal.toPlainString(), 12, 8), "btcusdt", TradeType.PRO));
        c2CMarginBalanceDataTotal.setNetAssetToBtc(c2CMarginBalanceDataTotal.getTotalAssetToBtc());
        c2CMarginBalanceDataTotal.setNetAsset(c2CMarginBalanceDataTotal.getTotalAsset());
        if (map == null) {
            map = new HashMap<>();
        }
        c2CMarginBalanceDataTotal.setDetailAsset(map);
        return c2CMarginBalanceDataTotal;
    }

    public Comparator<C2CMarginBalanceDetailInfo> m1() {
        if (this.f84079h == null) {
            this.f84079h = s0.f54146b;
        }
        return this.f84079h;
    }

    public List<C2CMarginBalanceDetailInfo> n1(String str, Map<String, Map<String, Map<String, String>>> map) {
        Map<String, String> o12 = o1(map, "usdt");
        Map<String, String> o13 = o1(map, "btc");
        Map<String, String> I = LegalCurrencyConfigUtil.I(o12);
        ArrayList arrayList = new ArrayList();
        for (C2CAccountInNetAssetResult next : h1(str)) {
            String subtype = next.getSubtype();
            arrayList.add(Y0(next, m.a(o13.get(subtype)).toPlainString(), m.a(I.get(subtype)).toPlainString()));
        }
        return arrayList;
    }

    public final Map<String, String> o1(Map<String, Map<String, Map<String, String>>> map, String str) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : O0(map, str).entrySet()) {
            BigDecimal bigDecimal = BigDecimal.ZERO;
            for (Map.Entry value : ((Map) next.getValue()).entrySet()) {
                bigDecimal = bigDecimal.add(new BigDecimal((String) value.getValue()));
            }
            hashMap.put((String) next.getKey(), bigDecimal.toPlainString());
        }
        return hashMap;
    }

    public final Comparator<ContractAccountInfo> p1() {
        if (this.f84083l == null) {
            this.f84083l = a.f53982b;
        }
        return this.f84083l;
    }

    public ContractDataTotal q1(String str, List<ContractAccountInfo> list, List<ContractCoinInfo> list2, ContractUserInfo.UserBean userBean, Map<String, SymbolPrice> map) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        boolean z11 = false;
        boolean z12 = list == null || list.isEmpty();
        if (!(userBean == null || 1 == userBean.getActiveState())) {
            z11 = true;
        }
        if (!z12 && !z11) {
            Map<String, BigDecimal> s12 = s1(str, map);
            for (ContractAccountInfo next : list) {
                if (!(next == null || next.getSymbol() == null)) {
                    String g11 = StringUtils.g(next.getSymbol());
                    next.setDisplayName(d7.k.C().z(g11));
                    if (g11.equalsIgnoreCase(str)) {
                        String marginBalance = next.getMarginBalance();
                        next.setEstimateAmountToBtc(marginBalance);
                        bigDecimal = bigDecimal.add(m.a(marginBalance));
                    } else if (s12.containsKey(g11)) {
                        String plainString = s12.get(g11).multiply(new BigDecimal(next.getMarginBalance())).toPlainString();
                        next.setEstimateAmountToBtc(plainString);
                        bigDecimal = bigDecimal.add(m.a(plainString));
                    }
                    next.setEstimateAmount(m.a(LegalCurrencyConfigUtil.G(next.getMarginBalance(), next.getCurrency(), TradeType.PRO)).toPlainString());
                }
            }
            Collections.sort(list, p1());
        } else if (list2 != null && !list2.isEmpty()) {
            if (list == null) {
                list = new ArrayList<>();
            }
            for (ContractCoinInfo next2 : list2) {
                if (next2 != null) {
                    ContractAccountInfo contractAccountInfo = new ContractAccountInfo();
                    contractAccountInfo.setSymbol(next2.getSymbol());
                    contractAccountInfo.setDisplayName(d7.k.C().z(next2.getSymbol()));
                    list.add(contractAccountInfo);
                }
            }
        }
        ContractDataTotal contractDataTotal = new ContractDataTotal();
        contractDataTotal.setNetAssetToBtc(bigDecimal.toPlainString());
        contractDataTotal.setNetAsset(LegalCurrencyConfigUtil.D(m.u0(bigDecimal.toPlainString(), 12, 8), "btcusdt", TradeType.PRO));
        if (list == null) {
            list = new ArrayList<>();
        }
        contractDataTotal.setDetailInfos(list);
        return contractDataTotal;
    }

    public Observable<ContractDataTotal> r1(boolean z11) {
        Observable<ContractUserInfo.UserBean> observable;
        ContractUserInfo.UserBean userInfo = AssetModuleConfig.a().getUserInfo();
        if (userInfo == null || userInfo.getActiveState() != 1) {
            observable = AssetModuleConfig.a().D0(false).subscribeOn(Schedulers.io()).onErrorResumeNext(Observable.just(null));
        } else {
            observable = Observable.just(userInfo);
        }
        return Observable.zip(AssetModuleConfig.a().k(false).subscribeOn(Schedulers.io()).onErrorResumeNext(j1.f54063b), AssetModuleConfig.a().l(z11).subscribeOn(Schedulers.io()), ContractCurrencyUtils.f(z11, "0").onErrorReturn(g1.f54027b).subscribeOn(Schedulers.io()), observable, LegalCurrencyConfigUtil.S(TradeType.PRO, z11).compose(RxJavaHelper.s()).onErrorResumeNext(Observable.just(null)), new e2(this));
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:579)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:485)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:240)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        */
    public java.util.Map<java.lang.String, java.math.BigDecimal> s1(java.lang.String r13, java.util.Map<java.lang.String, com.hbg.lib.network.pro.socket.bean.SymbolPrice> r14) {
        /*
            r12 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            if (r14 == 0) goto L_0x0019
            r2.putAll(r14)     // Catch:{ Exception -> 0x0015 }
            goto L_0x0019
        L_0x0015:
            r14 = move-exception
            r14.printStackTrace()
        L_0x0019:
            if (r13 == 0) goto L_0x0020
            java.math.BigDecimal r14 = java.math.BigDecimal.ONE
            r0.put(r13, r14)
        L_0x0020:
            java.util.Set r14 = r2.entrySet()
            java.util.Iterator r14 = r14.iterator()
        L_0x0028:
            boolean r2 = r14.hasNext()
            r3 = 32
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x00f6
            java.lang.Object r2 = r14.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            d7.a1 r6 = d7.a1.v()
            java.lang.Object r7 = r2.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r6 = r6.n(r7)
            d7.a1 r7 = d7.a1.v()
            java.lang.Object r8 = r2.getKey()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r7 = r7.D(r8)
            boolean r8 = r0.containsKey(r7)
            boolean r9 = r0.containsKey(r6)
            boolean r10 = r6.equalsIgnoreCase(r13)
            if (r10 == 0) goto L_0x009c
            if (r8 != 0) goto L_0x009c
            java.lang.Object r6 = r2.getValue()
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r6 = (com.hbg.lib.network.pro.socket.bean.SymbolPrice) r6
            if (r6 == 0) goto L_0x0092
            java.lang.Double r8 = r6.getClose()
            if (r8 != 0) goto L_0x0073
            goto L_0x0092
        L_0x0073:
            java.math.BigDecimal r2 = new java.math.BigDecimal
            java.lang.Double r6 = r6.getClose()
            java.lang.String r6 = r6.toString()
            r2.<init>(r6)
            java.math.BigDecimal r6 = java.math.BigDecimal.ZERO
            int r6 = r2.compareTo(r6)
            if (r6 == 0) goto L_0x008e
            java.math.BigDecimal r5 = java.math.BigDecimal.ONE
            java.math.BigDecimal r5 = r5.divide(r2, r3, r4)
        L_0x008e:
            r0.put(r7, r5)
            goto L_0x0028
        L_0x0092:
            java.lang.Object r2 = r2.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r1.put(r2, r5)
            goto L_0x0028
        L_0x009c:
            boolean r3 = r7.equalsIgnoreCase(r13)
            if (r3 == 0) goto L_0x00d0
            if (r9 != 0) goto L_0x00d0
            java.lang.Object r3 = r2.getValue()
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r3 = (com.hbg.lib.network.pro.socket.bean.SymbolPrice) r3
            if (r3 == 0) goto L_0x00c5
            java.lang.Double r4 = r3.getClose()
            if (r4 != 0) goto L_0x00b3
            goto L_0x00c5
        L_0x00b3:
            java.math.BigDecimal r2 = new java.math.BigDecimal
            java.lang.Double r3 = r3.getClose()
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            r0.put(r6, r2)
            goto L_0x0028
        L_0x00c5:
            java.lang.Object r2 = r2.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r1.put(r2, r5)
            goto L_0x0028
        L_0x00d0:
            java.lang.Object r3 = r2.getValue()
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r3 = (com.hbg.lib.network.pro.socket.bean.SymbolPrice) r3
            if (r3 == 0) goto L_0x00eb
            java.lang.Double r4 = r3.getClose()
            if (r4 == 0) goto L_0x00eb
            java.math.BigDecimal r5 = new java.math.BigDecimal
            java.lang.Double r3 = r3.getClose()
            java.lang.String r3 = r3.toString()
            r5.<init>(r3)
        L_0x00eb:
            java.lang.Object r2 = r2.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r1.put(r2, r5)
            goto L_0x0028
        L_0x00f6:
            int r14 = r1.size()
        L_0x00fa:
            if (r14 <= 0) goto L_0x018f
            if (r5 != 0) goto L_0x0113
            java.util.ArrayList r2 = new java.util.ArrayList
            java.util.Set r5 = r1.entrySet()
            r2.<init>(r5)
            java.lang.String r5 = "usdt"
            boolean r5 = r5.equalsIgnoreCase(r13)
            if (r5 == 0) goto L_0x0112
            r12.R3(r2)
        L_0x0112:
            r5 = r2
        L_0x0113:
            java.util.Iterator r2 = r5.iterator()
            r6 = 0
        L_0x0118:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x018d
            java.lang.Object r7 = r2.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getValue()
            if (r8 != 0) goto L_0x012b
            goto L_0x0118
        L_0x012b:
            d7.a1 r8 = d7.a1.v()
            java.lang.Object r9 = r7.getKey()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r8 = r8.n(r9)
            d7.a1 r9 = d7.a1.v()
            java.lang.Object r10 = r7.getKey()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r9 = r9.D(r10)
            java.lang.Object r10 = r0.get(r9)
            java.math.BigDecimal r10 = (java.math.BigDecimal) r10
            java.lang.Object r11 = r0.get(r8)
            java.math.BigDecimal r11 = (java.math.BigDecimal) r11
            if (r11 == 0) goto L_0x0179
            if (r10 != 0) goto L_0x0179
            java.lang.Object r8 = r7.getValue()
            java.math.BigDecimal r8 = (java.math.BigDecimal) r8
            java.math.BigDecimal r10 = java.math.BigDecimal.ZERO
            int r8 = r8.compareTo(r10)
            if (r8 == 0) goto L_0x0118
            java.math.BigDecimal r8 = java.math.BigDecimal.ONE
            java.lang.Object r7 = r7.getValue()
            java.math.BigDecimal r7 = (java.math.BigDecimal) r7
            java.math.BigDecimal r7 = r8.divide(r7, r3, r4)
            java.math.BigDecimal r7 = r7.multiply(r11)
            r0.put(r9, r7)
            goto L_0x018a
        L_0x0179:
            if (r11 != 0) goto L_0x0118
            if (r10 == 0) goto L_0x0118
            java.lang.Object r7 = r7.getValue()
            java.math.BigDecimal r7 = (java.math.BigDecimal) r7
            java.math.BigDecimal r7 = r10.multiply(r7)
            r0.put(r8, r7)
        L_0x018a:
            int r6 = r6 + 1
            goto L_0x0118
        L_0x018d:
            if (r6 != 0) goto L_0x00fa
        L_0x018f:
            java.util.List r14 = com.huobi.currencyconfig.util.StableCurrencyRateConfigUtil.d()
            com.huobi.currencyconfig.util.StableCurrencyRateConfigUtil.b(r13, r0, r14)
            d7.k r13 = d7.k.C()
            java.util.List r13 = r13.w()
            java.util.Iterator r13 = r13.iterator()
        L_0x01a2:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x01f5
            java.lang.Object r14 = r13.next()
            com.hbg.lib.network.pro.core.bean.CurrencyBean r14 = (com.hbg.lib.network.pro.core.bean.CurrencyBean) r14
            if (r14 == 0) goto L_0x01a2
            boolean r1 = r14.isFiatTag()
            if (r1 == 0) goto L_0x01a2
            java.lang.String r14 = r14.getName()
            java.lang.Object r1 = r0.get(r14)
            java.math.BigDecimal r1 = (java.math.BigDecimal) r1
            if (r1 != 0) goto L_0x01a2
            java.lang.String r1 = com.hbg.lib.common.utils.StringUtils.g(r14)
            java.lang.String r2 = "usd"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x01d1
            java.lang.String r1 = "1"
            goto L_0x01d5
        L_0x01d1:
            java.lang.String r1 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.s(r14)
        L_0x01d5:
            java.lang.String r2 = "husd"
            java.lang.Object r2 = r0.get(r2)
            java.math.BigDecimal r2 = (java.math.BigDecimal) r2
            java.math.BigDecimal r1 = i6.m.a(r1)
            if (r2 == 0) goto L_0x01a2
            java.math.BigDecimal r4 = java.math.BigDecimal.ZERO
            int r4 = r1.compareTo(r4)
            if (r4 == 0) goto L_0x01a2
            java.math.RoundingMode r4 = java.math.RoundingMode.DOWN
            java.math.BigDecimal r1 = r2.divide(r1, r3, r4)
            r0.put(r14, r1)
            goto L_0x01a2
        L_0x01f5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dt.h2.s1(java.lang.String, java.util.Map):java.util.Map");
    }

    public final List<LegalDetailInfo> u1(Map<Integer, Map<Integer, String>> map) {
        if (map == null || map.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        Map<Integer, BigDecimal> E1 = t1().E1("btc");
        for (Map.Entry next : t1().E1("usdt").entrySet()) {
            if (!(next == null || next.getValue() == null)) {
                hashMap.put((Integer) next.getKey(), LegalCurrencyConfigUtil.B(((BigDecimal) next.getValue()).toPlainString()));
            }
        }
        for (Map.Entry next2 : map.entrySet()) {
            arrayList.add(Z0(((Integer) next2.getKey()).intValue(), (Map) next2.getValue(), hashMap, E1));
        }
        return arrayList;
    }

    public Observable<LegalDataTotal> v1() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z11 = currentTimeMillis - this.f84086o < 40000;
        if (!z11) {
            this.f84086o = currentTimeMillis;
        }
        Observable<List<MarketPrice.Price>> j11 = OtcMarketPriceConfigUtil.j(z11);
        Observable<List<MarketCoin.Coin>> onErrorResumeNext = OtcMarketPriceConfigUtil.f(this.f84087p).timeout(2000, TimeUnit.MILLISECONDS).onErrorResumeNext(Observable.empty());
        this.f84087p = true;
        return Observable.zip(j11, onErrorResumeNext, E3(false), new b2(this));
    }

    public Observable<BalanceQueryData> v3(TradeType tradeType, boolean z11) {
        Observable<R> observable;
        if (tradeType == TradeType.PRO) {
            observable = b1(tradeType, AccountType.spot.toString()).flatMap(c1.f54001b).map(new g0(this)).doOnNext(new m(this, tradeType));
        } else if (TradeType.MARGIN == tradeType) {
            observable = b1(tradeType, AccountType.spot.toString()).flatMap(b1.f53990b).map(new a0(this)).doOnNext(new j(this, tradeType));
        } else if (tradeType == TradeType.POINT) {
            observable = b1(tradeType, AccountType.point.toString()).flatMap(a1.f53984b).map(new d0(this)).doOnNext(new k(this, tradeType));
        } else if (tradeType == TradeType.SUPERMARGIN) {
            observable = b1(tradeType, AccountType.supermargin.toString()).flatMap(z0.f54222b).map(new e0(this)).doOnNext(new n(this, tradeType));
        } else if (tradeType == TradeType.MINE) {
            observable = b1(tradeType, AccountType.mine_pool.toString()).flatMap(y0.f54210b).map(new f0(this)).doOnNext(new h(this, tradeType));
        } else if (tradeType == TradeType.SAVINGS) {
            observable = b1(tradeType, AccountType.savings.toString()).flatMap(x0.f54198b).map(new b0(this)).doOnNext(new o(this, tradeType));
        } else {
            observable = tradeType == TradeType.OTC_OPTIONS ? b1(tradeType, AccountType.otc_options.toString()).flatMap(f1.f54020b).map(new c0(this)).doOnNext(new i(this, tradeType)) : null;
        }
        return z11 ? Observable.concat(Observable.just(this.f84072a.get(tradeType.name())), observable).takeFirst(w0.f54186b) : observable;
    }

    public MarginBalanceDataTotal w1(String str, Map<String, Map<String, Map<String, String>>> map, Map<String, SymbolPrice> map2) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        String str2 = str;
        BigDecimal bigDecimal3 = BigDecimal.ZERO;
        if (map == null || map.isEmpty()) {
            bigDecimal2 = bigDecimal3;
            bigDecimal = bigDecimal2;
        } else {
            Map<String, BigDecimal> s12 = s1(str2, map2);
            bigDecimal2 = bigDecimal3;
            bigDecimal = bigDecimal2;
            for (Map.Entry<String, Map<String, Map<String, String>>> value : map.entrySet()) {
                for (Map.Entry entry : ((Map) value.getValue()).entrySet()) {
                    for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                        if (((String) entry2.getKey()).equalsIgnoreCase(str2)) {
                            if (((String) entry.getKey()).equals(BalanceQueryData.TYPE_CREDIT)) {
                                bigDecimal3 = bigDecimal3.subtract(m.a((String) entry2.getValue()));
                            } else if (BalanceQueryData.isNetAsset((String) entry.getKey())) {
                                bigDecimal3 = bigDecimal3.add(m.a((String) entry2.getValue()));
                            }
                            if (((String) entry.getKey()).equals("loan") || ((String) entry.getKey()).equals("interest")) {
                                bigDecimal2 = bigDecimal2.add(m.a((String) entry2.getValue()));
                            }
                            if (((String) entry.getKey()).equals("trade") || ((String) entry.getKey()).equals("frozen")) {
                                bigDecimal = bigDecimal.add(m.a((String) entry2.getValue()));
                            }
                        } else if (s12.containsKey(entry2.getKey())) {
                            BigDecimal bigDecimal4 = s12.get(entry2.getKey());
                            BigDecimal bigDecimal5 = new BigDecimal((String) entry2.getValue());
                            if (((String) entry.getKey()).equals(BalanceQueryData.TYPE_CREDIT)) {
                                bigDecimal3 = bigDecimal3.subtract(bigDecimal4.multiply(bigDecimal5));
                            } else if (BalanceQueryData.isNetAsset((String) entry.getKey())) {
                                bigDecimal3 = bigDecimal3.add(bigDecimal4.multiply(bigDecimal5));
                            }
                            if (((String) entry.getKey()).equals("loan") || ((String) entry.getKey()).equals("interest")) {
                                bigDecimal2 = bigDecimal2.add(bigDecimal4.multiply(bigDecimal5));
                            }
                            if (((String) entry.getKey()).equals("trade") || ((String) entry.getKey()).equals("frozen")) {
                                bigDecimal = bigDecimal.add(bigDecimal4.multiply(bigDecimal5));
                            }
                        }
                        str2 = str;
                    }
                    str2 = str;
                }
                str2 = str;
            }
        }
        MarginBalanceDataTotal marginBalanceDataTotal = new MarginBalanceDataTotal();
        marginBalanceDataTotal.setNetAssetToBtc(bigDecimal3.toPlainString());
        String u02 = m.u0(bigDecimal3.toPlainString(), 12, 8);
        TradeType tradeType = TradeType.PRO;
        marginBalanceDataTotal.setNetAsset(LegalCurrencyConfigUtil.D(u02, "btcusdt", tradeType));
        marginBalanceDataTotal.setNetLiabilitiesToBtc(bigDecimal2.abs().toPlainString());
        marginBalanceDataTotal.setNetLiabilitiesAsset(LegalCurrencyConfigUtil.D(m.u0(bigDecimal2.abs().toPlainString(), 12, 8), "btcusdt", tradeType));
        marginBalanceDataTotal.setTotalAssetToBtc(bigDecimal.toPlainString());
        marginBalanceDataTotal.setTotalAsset(LegalCurrencyConfigUtil.D(m.u0(bigDecimal.toPlainString(), 12, 8), "btcusdt", tradeType));
        marginBalanceDataTotal.setDetailAsset(map == null ? new HashMap<>() : map);
        return marginBalanceDataTotal;
    }

    public Observable<Map<String, Map<String, String>>> w3(TradeType tradeType, boolean z11) {
        return v3(tradeType, z11).flatMap(v0.f54174b).filter(new p0(new HashSet(d7.k.C().o(tradeType)))).collect(x.f54197b, t.f54151b);
    }

    public final Comparator<MarginBalanceDetailInfo> x1() {
        if (this.f84078g == null) {
            this.f84078g = d1.f54008b;
        }
        return this.f84078g;
    }

    public Observable<Map<String, Map<String, String>>> x3(TradeType tradeType, boolean z11) {
        return v3(tradeType, z11).flatMap(u0.f54159b).filter(new q0(new HashSet(d7.k.C().o(tradeType)))).collect(v.f54173b, new p(tradeType));
    }

    public MarginBalanceQueryData y1(String str) {
        Map<String, MarginBalanceQueryData> map = this.f84073b;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Observable<Map<String, String>> y3(TradeType tradeType, boolean z11) {
        return w3(tradeType, z11).map(new j0(this));
    }

    public Observable<List<MarginBalanceDetailInfo>> z1(boolean z11, String str) {
        return I3(TradeType.MARGIN, z11, false, str).map(new l0(this, str));
    }

    public Observable<Map<String, String>> z3(TradeType tradeType, boolean z11) {
        return x3(tradeType, z11).map(new i0(this));
    }
}
