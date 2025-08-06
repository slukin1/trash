package com.huobi.finance.model.subaccount;

import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.future.bean.FutureProductInfo;
import com.hbg.lib.data.future.controller.FutureProductInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCrossAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.contract.entity.LinearSwapBalanceItem;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.LinearSwapDataTotal;
import h8.a;
import i6.m;
import i8.s;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.schedulers.Schedulers;
import xk.b;
import xk.e;
import xk.f;
import xk.g;
import xk.h;
import xk.i;

public class LinearSwapDataProvider extends b<LinearSwapDataTotal, LinearSwapBalanceItem, FutureProductInfo, LinearSwapUserInfo> {
    public static /* synthetic */ List q(List list, List list2, List list3) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                LinearSwapCrossAccountInfo linearSwapCrossAccountInfo = (LinearSwapCrossAccountInfo) it2.next();
                arrayList.add(LinearSwapAccountInfo.fromCross(linearSwapCrossAccountInfo, linearSwapCrossAccountInfo.getMarginAccount()));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            arrayList.add(LinearSwapAccountInfo.fromCross((LinearSwapCrossAccountInfo) list2.get(0), "HUSD"));
        }
        arrayList.addAll(list3);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable r(Throwable th2) {
        if (p(th2)) {
            return Observable.just(null);
        }
        return Observable.error(th2);
    }

    public static /* synthetic */ LinearSwapDataTotal s(List list) {
        LinearSwapDataTotal linearSwapDataTotal = new LinearSwapDataTotal();
        linearSwapDataTotal.setAccountInfoList(list);
        return linearSwapDataTotal;
    }

    public static /* synthetic */ int t(LinearSwapBalanceItem linearSwapBalanceItem, LinearSwapBalanceItem linearSwapBalanceItem2) {
        double d11;
        double d12 = 0.0d;
        try {
            d11 = m.h0(linearSwapBalanceItem2.getEstimateAmount());
            try {
                d12 = m.h0(linearSwapBalanceItem.getEstimateAmount());
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return Double.compare(d11, d12);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            d11 = 0.0d;
            e.printStackTrace();
            return Double.compare(d11, d12);
        }
        return Double.compare(d11, d12);
    }

    public static /* synthetic */ List u(Throwable th2) {
        return null;
    }

    public /* bridge */ /* synthetic */ Observable a(boolean z11) {
        return super.a(z11);
    }

    public Observable<LinearSwapDataTotal> d() {
        return Observable.zip(a.a().J("", TtmlNode.COMBINE_ALL).b(), a.a().J("husd", TtmlNode.COMBINE_ALL).b(), a.a().z((String) null, TtmlNode.COMBINE_ALL).b(), i.f61633b).subscribeOn(Schedulers.io()).onErrorResumeNext(new f(this)).map(h.f61632b);
    }

    public Comparator<LinearSwapBalanceItem> e() {
        if (this.f48082a == null) {
            this.f48082a = e.f61629b;
        }
        return this.f48082a;
    }

    public Observable<List<FutureProductInfo>> f(boolean z11) {
        return FutureProductInfoController.d().f(true, z11).onErrorReturn(g.f61631b);
    }

    public Observable<LinearSwapUserInfo> g(boolean z11) {
        return s.d().e(z11).subscribeOn(Schedulers.io());
    }

    /* renamed from: o */
    public void c(LinearSwapDataTotal linearSwapDataTotal, List<FutureProductInfo> list, Map<String, BigDecimal> map, Comparator<LinearSwapBalanceItem> comparator, LinearSwapUserInfo linearSwapUserInfo) {
        BigDecimal bigDecimal;
        String str;
        LinearSwapDataTotal linearSwapDataTotal2 = linearSwapDataTotal;
        Map<String, BigDecimal> map2 = map;
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        List<LinearSwapAccountInfo> accountInfoList = linearSwapDataTotal.getAccountInfoList();
        boolean z11 = accountInfoList == null || accountInfoList.isEmpty();
        boolean z12 = (linearSwapUserInfo == null || linearSwapUserInfo.getActiveState() == 1) ? false : true;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z11 || z12) {
            if (list != null && !list.isEmpty()) {
                if (accountInfoList == null) {
                    accountInfoList = new ArrayList<>();
                }
                for (FutureProductInfo next : list) {
                    if (next != null) {
                        LinearSwapAccountInfo linearSwapAccountInfo = new LinearSwapAccountInfo();
                        linearSwapAccountInfo.setSymbol(next.getSymbol());
                        linearSwapAccountInfo.setTradePartition(next.getTradePartition());
                        if ("usdt".equalsIgnoreCase(next.getUnderlyingCurrency())) {
                            linearSwapAccountInfo.setCross(true);
                            accountInfoList.add(0, linearSwapAccountInfo);
                            arrayList.add(0, new LinearSwapBalanceItem(linearSwapAccountInfo));
                        } else if ("husd".equalsIgnoreCase(next.getUnderlyingCurrency())) {
                            linearSwapAccountInfo.setCross(true);
                            linearSwapAccountInfo.setSymbol("HUSD");
                            if (accountInfoList.isEmpty() || !accountInfoList.get(0).isCross()) {
                                accountInfoList.add(0, linearSwapAccountInfo);
                                arrayList.add(0, new LinearSwapBalanceItem(linearSwapAccountInfo));
                            } else if (accountInfoList.size() < 2 || !accountInfoList.get(1).isCross()) {
                                accountInfoList.add(1, linearSwapAccountInfo);
                                arrayList.add(1, new LinearSwapBalanceItem(linearSwapAccountInfo));
                            }
                        } else if ("husd".equalsIgnoreCase(next.getTradePartition())) {
                            accountInfoList.add(linearSwapAccountInfo);
                            arrayList2.add(new LinearSwapBalanceItem(linearSwapAccountInfo));
                        } else {
                            accountInfoList.add(linearSwapAccountInfo);
                            arrayList.add(new LinearSwapBalanceItem(linearSwapAccountInfo));
                        }
                    }
                }
                arrayList.addAll(arrayList2);
            }
            bigDecimal = bigDecimal2;
        } else {
            BigDecimal bigDecimal3 = bigDecimal2;
            for (LinearSwapAccountInfo next2 : accountInfoList) {
                if (!(next2 == null || next2.getSymbol() == null)) {
                    LinearSwapBalanceItem linearSwapBalanceItem = new LinearSwapBalanceItem(next2);
                    linearSwapBalanceItem.setDisplayName(StringUtils.i(next2.getSymbol() + "/" + "usdt"));
                    String marginBalance = next2.getMarginBalance();
                    linearSwapBalanceItem.setEstimateAmountToUsdt(marginBalance);
                    bigDecimal2 = bigDecimal2.add(m.a(marginBalance));
                    if (next2.getTradePartition() != null) {
                        str = next2.getTradePartition().toLowerCase();
                    } else if (!next2.isCross() || next2.getSymbol() == null) {
                        str = "usdt";
                    } else {
                        str = next2.getSymbol().toLowerCase();
                    }
                    if (map2.containsKey(str)) {
                        BigDecimal bigDecimal4 = map2.get(str);
                        BigDecimal bigDecimal5 = new BigDecimal(next2.getMarginBalance());
                        if (bigDecimal4 != null) {
                            String plainString = bigDecimal4.multiply(bigDecimal5).toPlainString();
                            linearSwapBalanceItem.setEstimateAmountToBtc(plainString);
                            bigDecimal3 = bigDecimal3.add(m.a(plainString));
                        }
                    }
                    linearSwapBalanceItem.setEstimateAmount(m.a(LegalCurrencyConfigUtil.B(next2.getMarginBalance())).toPlainString());
                    if (next2.isCross() || !"husd".equalsIgnoreCase(next2.getTradePartition())) {
                        arrayList.add(linearSwapBalanceItem);
                    } else {
                        arrayList2.add(linearSwapBalanceItem);
                    }
                }
            }
            arrayList.addAll(arrayList2);
            Collections.sort(arrayList, comparator);
            bigDecimal = bigDecimal2;
            bigDecimal2 = bigDecimal3;
        }
        linearSwapDataTotal2.setNetAssetToBtc(bigDecimal2.toPlainString());
        linearSwapDataTotal2.setNetAssetToUsdt(bigDecimal.toPlainString());
        linearSwapDataTotal2.setNetAsset(LegalCurrencyConfigUtil.B(m.u0(bigDecimal.toPlainString(), 12, 8)));
        if (accountInfoList == null) {
            arrayList = new ArrayList();
        }
        linearSwapDataTotal2.setDetailInfos(arrayList);
    }

    public final boolean p(Throwable th2) {
        if (!(th2 instanceof APIStatusErrorException) || 1220 != m.k0(((APIStatusErrorException) th2).getErrCode())) {
            return false;
        }
        return true;
    }
}
