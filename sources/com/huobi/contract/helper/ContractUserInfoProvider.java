package com.huobi.contract.helper;

import android.text.TextUtils;
import bj.s2;
import bj.u2;
import bj.v2;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.module.contract.service.ContractService;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.entity.ContractUserInfoActive;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import rx.Observable;

public class ContractUserInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    public ContractUserInfo.UserBean f43122a;

    /* renamed from: b  reason: collision with root package name */
    public ContractCurrencyInfo f43123b;

    /* renamed from: c  reason: collision with root package name */
    public SwapCurrencyInfo f43124c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static ContractUserInfoProvider f43125a = new ContractUserInfoProvider();
    }

    public static ContractUserInfoProvider i() {
        return a.f43125a;
    }

    public static /* synthetic */ ContractUserInfo.UserBean t(ContractUserInfo.UserBean userBean, ContractUserInfoActive contractUserInfoActive) {
        userBean.setActiveState(contractUserInfoActive.getContract().getActive());
        userBean.setIsAgree(contractUserInfoActive.getAgree());
        userBean.setIsAgreeV2(contractUserInfoActive.getAgreeV2());
        userBean.setKycCountry(contractUserInfoActive.getKycCountry());
        userBean.setKycState(contractUserInfoActive.getKycState());
        return userBean;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(ContractUserInfo.UserBean userBean) {
        this.f43122a = userBean;
    }

    public static /* synthetic */ Boolean w(ContractUserInfo.UserBean userBean) {
        return Boolean.valueOf(userBean != null);
    }

    public final boolean f(ContractCurrencyInfo contractCurrencyInfo) {
        return contractCurrencyInfo != null && !TextUtils.isEmpty(contractCurrencyInfo.getSymbol()) && !TextUtils.isEmpty(contractCurrencyInfo.getContractCode()) && !TextUtils.isEmpty(contractCurrencyInfo.getContractType()) && !TextUtils.isEmpty(contractCurrencyInfo.getDelivDate());
    }

    public void g() {
        this.f43122a = null;
    }

    public String h() {
        try {
            TradeType j11 = i().j();
            if (j11 == null) {
                return "";
            }
            if (j11 == TradeType.CONTRACT) {
                ContractCurrencyInfo k11 = i().k();
                if (k11 != null) {
                    return k11.getContractShortType();
                }
                return "";
            }
            SwapCurrencyInfo m11 = i().m();
            if (m11 != null) {
                return m11.getContractShortType();
            }
            return "";
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public TradeType j() {
        String d11 = ConfigPreferences.d("user_config", "config_contract_currency_info");
        if (TextUtils.isEmpty(d11)) {
            return TradeType.LINEAR_SWAP;
        }
        if (d11.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return TradeType.SWAP;
        }
        return TradeType.CONTRACT;
    }

    public ContractCurrencyInfo k() {
        List<ContractCurrencyInfo> k11 = ContractCurrencyUtils.k();
        if (k11 == null || k11.isEmpty()) {
            return null;
        }
        return l(k11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo} */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e5, code lost:
        r1 = r5;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo l(java.util.List<com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo> r10) {
        /*
            r9 = this;
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r0 = r9.f43123b
            boolean r0 = r9.f(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000c
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r0 = r9.f43123b
            goto L_0x000d
        L_0x000c:
            r0 = r1
        L_0x000d:
            r2 = 1
            r3 = 0
            if (r10 == 0) goto L_0x0019
            boolean r4 = r10.isEmpty()
            if (r4 != 0) goto L_0x0019
            r4 = r2
            goto L_0x001a
        L_0x0019:
            r4 = r3
        L_0x001a:
            if (r4 == 0) goto L_0x00ef
            if (r0 == 0) goto L_0x008b
            java.util.Iterator r2 = r10.iterator()
        L_0x0022:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0046
            java.lang.Object r4 = r2.next()
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r4 = (com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo) r4
            if (r4 != 0) goto L_0x0031
            goto L_0x0022
        L_0x0031:
            java.lang.String r5 = r0.getContractCode()
            if (r5 == 0) goto L_0x0022
            java.lang.String r5 = r4.getContractCode()
            java.lang.String r6 = r0.getContractCode()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0022
            r1 = r4
        L_0x0046:
            if (r1 != 0) goto L_0x00e6
            java.lang.String r0 = r0.getSymbol()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x00e6
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r4 = r10.iterator()
        L_0x005b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0078
            java.lang.Object r5 = r4.next()
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r5 = (com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo) r5
            if (r5 != 0) goto L_0x006a
            goto L_0x005b
        L_0x006a:
            java.lang.String r6 = r5.getSymbol()
            boolean r6 = r0.equals(r6)
            if (r6 == 0) goto L_0x005b
            r2.add(r5)
            goto L_0x005b
        L_0x0078:
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L_0x00e6
            bj.r2 r0 = bj.r2.f12489b
            java.util.Collections.sort(r2, r0)
            java.lang.Object r0 = r2.get(r3)
            r1 = r0
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r1 = (com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo) r1
            goto L_0x00e6
        L_0x008b:
            java.lang.String r0 = "user_config"
            java.lang.String r4 = "config_contract_currency_info"
            java.lang.String r0 = com.hbg.lib.core.util.ConfigPreferences.d(r0, r4)
            java.util.Iterator r4 = r10.iterator()
        L_0x0097:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00e6
            java.lang.Object r5 = r4.next()
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r5 = (com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo) r5
            if (r5 != 0) goto L_0x00a6
            goto L_0x0097
        L_0x00a6:
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            com.hbg.lib.data.symbol.TradeType r7 = com.hbg.lib.data.symbol.TradeType.CONTRACT
            com.hbg.lib.data.symbol.TradeType r8 = r9.j()
            boolean r8 = r7.equals(r8)
            r8 = r8 ^ r2
            r6 = r6 | r8
            if (r6 == 0) goto L_0x00d1
            java.lang.String r6 = r5.getSymbol()
            java.lang.String r7 = "btc"
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0097
            java.lang.String r6 = r5.getContractType()
            java.lang.String r7 = "quarter"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x0097
            goto L_0x00e5
        L_0x00d1:
            java.lang.String r6 = r5.getContractShortType()
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0097
            com.hbg.lib.data.symbol.TradeType r6 = r9.j()
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x0097
        L_0x00e5:
            r1 = r5
        L_0x00e6:
            if (r1 != 0) goto L_0x00ef
            java.lang.Object r10 = r10.get(r3)
            r1 = r10
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r1 = (com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo) r1
        L_0x00ef:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.contract.helper.ContractUserInfoProvider.l(java.util.List):com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo");
    }

    public SwapCurrencyInfo m() {
        List<SwapCurrencyInfo> e11 = SwapCurrencyInfoController.k().e();
        if (e11 == null || e11.isEmpty()) {
            return null;
        }
        return n(e11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo n(java.util.List<com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo> r8) {
        /*
            r7 = this;
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r0 = r7.f43124c
            r1 = 0
            if (r8 == 0) goto L_0x000d
            boolean r2 = r8.isEmpty()
            if (r2 != 0) goto L_0x000d
            r2 = 1
            goto L_0x000e
        L_0x000d:
            r2 = r1
        L_0x000e:
            r3 = 0
            if (r2 == 0) goto L_0x00a0
            if (r0 == 0) goto L_0x003b
            java.util.Iterator r2 = r8.iterator()
        L_0x0017:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0097
            java.lang.Object r4 = r2.next()
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r4 = (com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo) r4
            if (r4 != 0) goto L_0x0026
            goto L_0x0017
        L_0x0026:
            java.lang.String r5 = r0.getContractCode()
            if (r5 == 0) goto L_0x0017
            java.lang.String r5 = r4.getContractCode()
            java.lang.String r6 = r0.getContractCode()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0017
            goto L_0x0096
        L_0x003b:
            java.lang.String r0 = "user_config"
            java.lang.String r2 = "config_contract_currency_info"
            java.lang.String r0 = com.hbg.lib.core.util.ConfigPreferences.d(r0, r2)
            java.util.Iterator r2 = r8.iterator()
        L_0x0047:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0097
            java.lang.Object r4 = r2.next()
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r4 = (com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo) r4
            if (r4 != 0) goto L_0x0056
            goto L_0x0047
        L_0x0056:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L_0x007e
            com.hbg.lib.data.symbol.TradeType r5 = com.hbg.lib.data.symbol.TradeType.SWAP
            com.hbg.lib.data.symbol.TradeType r6 = r7.j()
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x0069
            goto L_0x007e
        L_0x0069:
            java.lang.String r6 = r4.getContractShortType()
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0047
            com.hbg.lib.data.symbol.TradeType r6 = r7.j()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0047
            goto L_0x0096
        L_0x007e:
            java.lang.String r5 = r4.getSymbol()
            java.lang.String r6 = "btc"
            boolean r5 = r6.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0047
            java.lang.String r5 = r4.getContractCode()
            java.lang.String r6 = "BTC-USD"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0047
        L_0x0096:
            r3 = r4
        L_0x0097:
            if (r3 != 0) goto L_0x00a0
            java.lang.Object r8 = r8.get(r1)
            r3 = r8
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r3 = (com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo) r3
        L_0x00a0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.contract.helper.ContractUserInfoProvider.n(java.util.List):com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo");
    }

    public ContractUserInfo.UserBean o() {
        return this.f43122a;
    }

    public Observable<ContractUserInfo.UserBean> p(boolean z11) {
        Observable<R> doOnNext = ((ContractService) ContractRetrofit.request(ContractService.class)).userInfo().compose(ContractRetrofit.h()).flatMap(u2.f12505b).doOnNext(new s2(this));
        return z11 ? Observable.concat(Observable.just(this.f43122a), doOnNext).takeFirst(v2.f12514b) : doOnNext;
    }

    public boolean q() {
        ContractUserInfo.UserBean userBean = this.f43122a;
        return userBean != null && userBean.offSite;
    }

    public boolean r() {
        ContractUserInfo.UserBean userBean = this.f43122a;
        if (userBean == null || userBean.getActiveState() != 1) {
            return false;
        }
        return true;
    }

    public void x(ContractCurrencyInfo contractCurrencyInfo) {
        this.f43123b = contractCurrencyInfo;
        if (contractCurrencyInfo != null) {
            ConfigPreferences.m("user_config", "config_contract_currency_info", contractCurrencyInfo.getContractShortType());
        }
    }

    public void y(SwapCurrencyInfo swapCurrencyInfo) {
        this.f43124c = swapCurrencyInfo;
        if (swapCurrencyInfo != null) {
            ConfigPreferences.m("user_config", "config_contract_currency_info", swapCurrencyInfo.getContractShortType());
        }
    }

    public void z(ContractUserInfo.UserBean userBean) {
        this.f43122a = userBean;
    }
}
