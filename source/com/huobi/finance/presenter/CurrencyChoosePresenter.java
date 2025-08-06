package com.huobi.finance.presenter;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.contract.entity.ContractCoinInfo;
import com.huobi.currencyconfig.util.StableCurrencyRateConfigUtil;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.huobi.finance.controller.DepositWithdrawController;
import com.huobi.finance.ui.UnifyDepositActivity;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.finance.ui.UnifyWithdrawActivity;
import com.huobi.finance.utils.DepositWithdrawHelper;
import com.huobi.otc.bean.MarketCoin;
import com.tencent.android.tpush.common.Constants;
import d7.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import k20.h;
import org.greenrobot.eventbus.ThreadMode;
import u6.g;

public class CurrencyChoosePresenter extends ActivityPresenter<c> {

    /* renamed from: a  reason: collision with root package name */
    public String f45518a;

    /* renamed from: b  reason: collision with root package name */
    public String f45519b;

    /* renamed from: c  reason: collision with root package name */
    public String f45520c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45521d;

    public class a extends EasySubscriber<List<CurrencyBean>> {
        public a() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((c) CurrencyChoosePresenter.this.getUI()).m0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((c) CurrencyChoosePresenter.this.getUI()).m0();
        }

        public void onStart() {
            super.onStart();
            ((c) CurrencyChoosePresenter.this.getUI()).showLoading();
        }

        public void onNext(List<CurrencyBean> list) {
            super.onNext(list);
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            StableCurrencyRateConfigUtil.f();
            for (CurrencyBean next : list) {
                if (next != null) {
                    SymbolCurrencyEntity symbolCurrencyEntity = new SymbolCurrencyEntity(next.getName());
                    symbolCurrencyEntity.setStatus(DepositWithdrawHelper.b(next));
                    symbolCurrencyEntity.setDescCanNotDeposit(DepositWithdrawHelper.n(next.getChainInfos()));
                    symbolCurrencyEntity.setDescCanNotWithDraw(DepositWithdrawHelper.o(next.getChainInfos()));
                    arrayList.add(symbolCurrencyEntity);
                    hashMap.put(next.getName(), symbolCurrencyEntity);
                }
            }
            ((c) CurrencyChoosePresenter.this.getUI()).F0();
            ((c) CurrencyChoosePresenter.this.getUI()).wg(arrayList);
        }
    }

    public class b extends EasySubscriber<List<SymbolCurrencyEntity>> {
        public b() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((c) CurrencyChoosePresenter.this.getUI()).m0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((c) CurrencyChoosePresenter.this.getUI()).m0();
        }

        public void onStart() {
            super.onStart();
            ((c) CurrencyChoosePresenter.this.getUI()).showLoading();
        }

        public void onNext(List<SymbolCurrencyEntity> list) {
            super.onNext(list);
            CurrencyChoosePresenter.this.a0(list);
            ((c) CurrencyChoosePresenter.this.getUI()).F0();
            ((c) CurrencyChoosePresenter.this.getUI()).wg(list);
        }
    }

    public interface c extends g {
        void F0();

        void m0();

        void showLoading();

        void wg(List<SymbolCurrencyEntity> list);
    }

    public static /* synthetic */ List Y(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                MarketCoin.Coin coin = (MarketCoin.Coin) it2.next();
                if (coin != null && !TextUtils.isEmpty(coin.getShortName())) {
                    arrayList.add(new SymbolCurrencyEntity(coin.getShortName().toLowerCase(Locale.US)));
                }
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            Iterator it3 = list2.iterator();
            while (it3.hasNext()) {
                ContractCoinInfo contractCoinInfo = (ContractCoinInfo) it3.next();
                if (contractCoinInfo != null && !TextUtils.isEmpty(contractCoinInfo.getSymbol())) {
                    arrayList.add(new SymbolCurrencyEntity(contractCoinInfo.getSymbol().toLowerCase(Locale.US)));
                }
            }
        }
        HashSet hashSet = new HashSet(arrayList);
        arrayList.clear();
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public final void S(SymbolCurrencyEntity symbolCurrencyEntity) {
        if (!U(symbolCurrencyEntity.getName()) && DepositWithdrawController.n(symbolCurrencyEntity.getStatus(), "", getActivity(), symbolCurrencyEntity.getName())) {
            if (this.f45521d) {
                getActivity().setResult(-1, new Intent().putExtra("coin", symbolCurrencyEntity.getName()));
            } else {
                UnifyDepositActivity.wh(getActivity(), symbolCurrencyEntity.getName());
            }
            getActivity().finish();
        }
    }

    public final void T(SymbolCurrencyEntity symbolCurrencyEntity) {
        if (!U(symbolCurrencyEntity.getName()) && DepositWithdrawController.o(symbolCurrencyEntity.getStatus(), "", getActivity(), symbolCurrencyEntity.getName())) {
            if (this.f45521d) {
                getActivity().setResult(-1, new Intent().putExtra("coin", symbolCurrencyEntity.getName()));
            } else {
                UnifyWithdrawActivity.Di(getActivity(), symbolCurrencyEntity.getName(), TradeType.PRO);
            }
            getActivity().finish();
        }
    }

    public final boolean U(String str) {
        if (!"try".equalsIgnoreCase(str)) {
            return false;
        }
        com.hbg.lib.widgets.dialog.b.a(getActivity());
        return true;
    }

    public void V(SymbolCurrencyEntity symbolCurrencyEntity) {
        if (symbolCurrencyEntity != null) {
            SoftInputUtils.f(getActivity());
            symbolCurrencyEntity.getStatus();
            if ("1".equals(this.f45518a)) {
                S(symbolCurrencyEntity);
            } else if ("2".equals(this.f45518a)) {
                T(symbolCurrencyEntity);
            } else if ("3".equals(this.f45518a)) {
                if (this.f45521d) {
                    getActivity().setResult(-1, new Intent().putExtra("coin", symbolCurrencyEntity.getName()));
                } else {
                    UnifyTransferActivity.Th(getActivity(), symbolCurrencyEntity.getName(), this.f45519b);
                }
                getActivity().finish();
            }
        }
    }

    public final EasySubscriber W() {
        return new b();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void X() {
        /*
            r4 = this;
            java.lang.String r0 = r4.f45518a
            int r1 = r0.hashCode()
            java.lang.String r2 = "2"
            r3 = 1
            switch(r1) {
                case 49: goto L_0x001f;
                case 50: goto L_0x0017;
                case 51: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0029
        L_0x000d:
            java.lang.String r1 = "3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 0
            goto L_0x002a
        L_0x0017:
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0029
            r0 = 2
            goto L_0x002a
        L_0x001f:
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = r3
            goto L_0x002a
        L_0x0029:
            r0 = -1
        L_0x002a:
            if (r0 == 0) goto L_0x004f
            d7.k r0 = d7.k.C()
            java.lang.String r1 = com.hbg.lib.core.util.p.b()
            rx.Observable r0 = r0.n(r3, r1, r2)
            h6.a r1 = r4.getUI()
            u6.g r1 = (u6.g) r1
            rx.Observable$Transformer r1 = com.hbg.lib.core.util.RxJavaHelper.t(r1)
            rx.Observable r0 = r0.compose(r1)
            com.huobi.finance.presenter.CurrencyChoosePresenter$a r1 = new com.huobi.finance.presenter.CurrencyChoosePresenter$a
            r1.<init>()
            r0.subscribe(r1)
            goto L_0x00a9
        L_0x004f:
            rx.Observable r0 = com.huobi.otc.utils.OtcMarketPriceConfigUtil.f(r3)
            h6.a r1 = r4.getUI()
            u6.g r1 = (u6.g) r1
            rx.Observable$Transformer r1 = com.hbg.lib.core.util.RxJavaHelper.t(r1)
            rx.Observable r0 = r0.compose(r1)
            boolean r1 = com.hbg.lib.core.util.o.h()
            if (r1 == 0) goto L_0x0089
            java.lang.String r1 = "0"
            rx.Observable r1 = com.huobi.contract.helper.ContractCurrencyUtils.f(r3, r1)
            h6.a r2 = r4.getUI()
            u6.g r2 = (u6.g) r2
            rx.Observable$Transformer r2 = com.hbg.lib.core.util.RxJavaHelper.t(r2)
            rx.Observable r1 = r1.compose(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            rx.Observable r2 = rx.Observable.just(r2)
            rx.Observable r1 = r1.onErrorResumeNext(r2)
            goto L_0x008e
        L_0x0089:
            r1 = 0
            rx.Observable r1 = rx.Observable.just(r1)
        L_0x008e:
            com.huobi.finance.presenter.f2 r2 = com.huobi.finance.presenter.f2.f45874b
            rx.Observable r0 = rx.Observable.zip(r0, r1, r2)
            h6.a r1 = r4.getUI()
            u6.g r1 = (u6.g) r1
            rx.Observable$Transformer r1 = com.hbg.lib.core.util.RxJavaHelper.t(r1)
            rx.Observable r0 = r0.compose(r1)
            com.hbg.lib.core.network.rx.EasySubscriber r1 = r4.W()
            r0.subscribe(r1)
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.presenter.CurrencyChoosePresenter.X():void");
    }

    /* renamed from: Z */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f45518a = intent.getStringExtra("KEY_JUMP_FOR");
            this.f45519b = intent.getStringExtra(Constants.FLAG_ACCOUNT);
            this.f45520c = intent.getStringExtra("coin");
            this.f45521d = intent.getBooleanExtra("JUMP_RECHOOSE", false);
        }
        if (this.f45518a == null) {
            this.f45518a = "3";
        }
    }

    public final void a0(List<SymbolCurrencyEntity> list) {
        int i11;
        if (list != null && !list.isEmpty()) {
            List<CurrencyBean> w11 = k.C().w();
            for (SymbolCurrencyEntity next : list) {
                if (!(next == null || next.getName() == null)) {
                    String name = next.getName();
                    CurrencyBean currencyBean = null;
                    if (w11 != null && !w11.isEmpty()) {
                        Iterator<CurrencyBean> it2 = w11.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                CurrencyBean next2 = it2.next();
                                if (next2 != null && next2.getName().equalsIgnoreCase(name)) {
                                    currencyBean = next2;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (currencyBean != null) {
                        i11 = DepositWithdrawHelper.b(currencyBean) | 0;
                        next.setDescCanNotDeposit(DepositWithdrawHelper.n(currencyBean.getChainInfos()));
                        next.setDescCanNotWithDraw(DepositWithdrawHelper.o(currencyBean.getChainInfos()));
                    } else {
                        i11 = 1;
                    }
                    next.setStatus(i11);
                }
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
    }

    public void onStop() {
        super.onStop();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        rn.c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }
}
