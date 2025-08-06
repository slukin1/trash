package bj;

import a7.e;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.contract.R$raw;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.bean.ContractOrderInsertRspInfo;
import com.hbg.lib.network.contract.core.bean.ContractTpSlOrderRspInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.dialog.OrderConfirmBottomSheetDialogFragment;
import com.hbg.lib.widgets.dialog.bean.OrderConfirmBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.contract.ContractModuleConfig;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.contract.entity.OffSiteLimit;
import com.huobi.contract.entity.PriceProtectionItem;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.contract.helper.FuturesTradeActionController;
import com.huobi.contract.utils.KycLimitCodeUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.n0;
import ej.f;
import ej.g;
import i6.m;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;

public class d1 {

    /* renamed from: a  reason: collision with root package name */
    public BigDecimal f40784a;

    /* renamed from: b  reason: collision with root package name */
    public BigDecimal f40785b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<n0> f40786c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, ContractAccountInfo> f40787d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public Map<String, ContractPosition> f40788e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public FuturesTradeActionController f40789f;

    /* renamed from: g  reason: collision with root package name */
    public OrderConfirmBottomSheetDialogFragment f40790g;

    public class a extends EasySubscriber<OffSiteLimit> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f40791b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DialogUtils.b.f f40792c;

        public a(Context context, DialogUtils.b.f fVar) {
            this.f40791b = context;
            this.f40792c = fVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            d1.this.y().z0(true);
        }

        /* renamed from: c */
        public void onNext(OffSiteLimit offSiteLimit) {
            super.onNext(offSiteLimit);
            if (offSiteLimit.tipFlag) {
                new DialogUtils.b.d((FragmentActivity) this.f40791b).C0(offSiteLimit.tipMsg).P0(this.f40791b.getString(R$string.n_sure)).s0(this.f40791b.getString(R$string.n_cancel)).Q0(this.f40792c).N0(new c1(this)).j0().show(((FragmentActivity) this.f40791b).getSupportFragmentManager(), "");
            } else {
                this.f40792c.a((HBDialogFragment) null);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            this.f40792c.a((HBDialogFragment) null);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            this.f40792c.a((HBDialogFragment) null);
        }
    }

    public class b extends EasySubscriber<Object> {
        public b() {
        }

        public void onAfter() {
            super.onAfter();
            if (d1.this.y() != null) {
                d1.this.y().dismissProgressDialog();
                d1.this.y().z0(true);
            }
        }

        public void onError2(Throwable th2) {
            if (!NetworkStatus.c(BaseApplication.b())) {
                HuobiToastUtil.j(R$string.n_no_network);
            } else {
                HuobiToastUtil.k(BaseApplication.b(), R$string.string_order_op_fail);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (KycLimitCodeUtils.a(aPIStatusErrorException.getErrCode())) {
                d1.this.y().t1(aPIStatusErrorException.getErrMsg());
            } else if (KycLimitCodeUtils.b(aPIStatusErrorException.getErrCode())) {
                d1.this.y().q(aPIStatusErrorException.getErrMsg());
            } else {
                String errCode = aPIStatusErrorException.getErrCode();
                errCode.hashCode();
                if (errCode.equals("1501")) {
                    d1.this.y().b1();
                } else if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                    HuobiToastUtil.l(BaseApplication.b(), aPIStatusErrorException.getErrMsg());
                }
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            if (d1.this.y() != null) {
                d1.this.y().c1(false);
                d1.this.y().u0(false, false);
                d1.this.y().w0(true, true);
                d1.this.y().t0();
            }
            HuobiToastUtil.t(BaseApplication.b(), R$string.string_order_op_ok);
            s6.a.b(BaseApplication.b()).c(R$raw.order_success);
            EventBus.d().k(new ContractAssetAndOrderUpdateEvent());
        }

        public void onStart() {
            super.onStart();
            if (d1.this.y() != null) {
                d1.this.y().showProgressDialog();
                d1.this.y().z0(false);
            }
        }

        public /* synthetic */ b(d1 d1Var, a aVar) {
            this();
        }
    }

    public d1(n0 n0Var) {
        this.f40786c = new WeakReference<>(n0Var);
        this.f40789f = new FuturesTradeActionController();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void A(View view) {
        if (y() != null) {
            y().z0(true);
        }
        ContractModuleConfig.a().c("confirm_order_close_pop_back_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        R(contractOrderPlace, contractCurrencyInfo);
        X(contractOrderPlace);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(Context context, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo, boolean z11, View view) {
        p0.l(z11 ^ true ? 1 : 0);
        Q(context, contractOrderPlace, contractCurrencyInfo, new x0(this, contractOrderPlace, contractCurrencyInfo));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        s(contractOrderPlace, contractCurrencyInfo);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(Context context, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo, boolean z11, View view) {
        p0.j(z11 ^ true ? 1 : 0);
        Q(context, contractOrderPlace, contractCurrencyInfo, new a1(this, contractOrderPlace, contractCurrencyInfo));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        R(contractOrderPlace, contractCurrencyInfo);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void G(View view) {
        if (y() != null) {
            y().z0(true);
        }
        ContractModuleConfig.a().c("confirm_order_close_pop_back_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        t(contractOrderPlace, contractCurrencyInfo);
        X(contractOrderPlace);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(Context context, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo, boolean z11, View view) {
        p0.l(z11 ^ true ? 1 : 0);
        Q(context, contractOrderPlace, contractCurrencyInfo, new w0(this, contractOrderPlace, contractCurrencyInfo));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        t(contractOrderPlace, contractCurrencyInfo);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void K(View view) {
        if (y() != null) {
            y().z0(true);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        s(contractOrderPlace, contractCurrencyInfo);
    }

    public Observable<Object> M(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        if (contractOrderPlace.z() == 100) {
            contractOrderPlace.m0(1);
        } else {
            contractOrderPlace.m0(0);
        }
        return q7.a.a().t(contractOrderPlace.G(), contractCurrencyInfo.getContractType(), contractCurrencyInfo.getContractCode(), contractOrderPlace.W(), contractOrderPlace.l(), contractOrderPlace.y(), contractOrderPlace.i()).b().delay(300, TimeUnit.MILLISECONDS);
    }

    public ContractOrderPlace N(Context context, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        ContractOrderPlace contractOrderPlace2 = contractOrderPlace;
        String w11 = contractOrderPlace.w();
        String b11 = contractOrderPlace.b();
        int v11 = contractOrderPlace.v();
        boolean X = contractOrderPlace.X();
        int e11 = contractOrderPlace.e();
        String G = contractOrderPlace.G();
        String o11 = contractOrderPlace.o();
        int Q = contractOrderPlace.Q();
        BigDecimal a11 = m.a(w11);
        BigDecimal a12 = m.a(b11);
        BigDecimal w12 = w(G);
        BigDecimal x11 = x(contractCurrencyInfo.getContractCode(), X);
        if (contractOrderPlace.t() == 1 && Q != 1) {
            a11 = m.a(contractOrderPlace.S());
        }
        BigDecimal bigDecimal4 = a11;
        if (e.E(TradeType.CONTRACT)) {
            BigDecimal bigDecimal5 = BigDecimal.ZERO;
            if (v11 == 0) {
                if (e11 != 0) {
                    if (contractOrderPlace.d() != null) {
                        a12 = w12.multiply(m.a(o11)).multiply(contractOrderPlace.d()).divide(m.f68179a, 32, 1);
                    } else {
                        a12 = w12.multiply(m.a(o11)).multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
                    }
                }
                BigDecimal divide = bigDecimal4.multiply(a12).divide(m.a(contractCurrencyInfo.getContractFace()), f.t(G), 1);
                if (n(context, G, divide, contractCurrencyInfo, bigDecimal4, o11)) {
                    contractOrderPlace2.l0(false);
                }
                if (contractOrderPlace.t() != 1 && w12.multiply(m.a(o11)).compareTo(a12) < 0) {
                    HuobiToastUtil.j(R$string.n_contract_trade_available_not_enough);
                    contractOrderPlace2.l0(false);
                }
                b11 = divide.toPlainString();
                bigDecimal5 = divide;
            } else if (v11 == 1 || v11 == 2) {
                if (e11 == 0) {
                    bigDecimal2 = bigDecimal4.multiply(a12).divide(m.a(contractCurrencyInfo.getContractFace()), 32, 1);
                } else if (contractOrderPlace.d() != null) {
                    bigDecimal2 = x11.multiply(contractOrderPlace.d()).divide(m.f68179a, 32, 1);
                } else {
                    bigDecimal2 = x11.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
                }
                if (bigDecimal2.compareTo(BigDecimal.ONE) >= 0 || bigDecimal2.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal3 = bigDecimal2.setScale(f.t(G), 1);
                } else {
                    bigDecimal3 = BigDecimal.ONE;
                }
                BigDecimal bigDecimal6 = bigDecimal3;
                if (n(context, G, bigDecimal6, contractCurrencyInfo, bigDecimal4, o11)) {
                    contractOrderPlace2.l0(false);
                }
                if (contractOrderPlace.t() != 1 && bigDecimal6.compareTo(x11) > 0) {
                    HuobiToastUtil.j(R$string.contract_trade_close_available_not_enough);
                    contractOrderPlace2.l0(false);
                }
                b11 = bigDecimal6.toPlainString();
                bigDecimal5 = bigDecimal6;
            }
            this.f40785b = bigDecimal5;
            if (bigDecimal4.compareTo(BigDecimal.ZERO) != 0) {
                this.f40784a = bigDecimal5.multiply(m.a(contractCurrencyInfo.getContractFace())).divide(bigDecimal4, f.n(contractCurrencyInfo.getContractCode()), 1);
            }
        } else {
            if (v11 == 0) {
                if (bigDecimal4.compareTo(BigDecimal.ZERO) != 0) {
                    BigDecimal divide2 = w12.multiply(bigDecimal4).multiply(m.a(o11)).divide(m.a(contractCurrencyInfo.getContractFace()), f.c(G), 1);
                    if (e11 != 0) {
                        if (contractOrderPlace.d() != null) {
                            a12 = divide2.multiply(contractOrderPlace.d()).divide(m.f68179a, f.c(G), 1);
                        } else {
                            a12 = divide2.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, f.c(G), 1);
                        }
                    }
                    if (a12.compareTo(BigDecimal.ZERO) <= 0) {
                        HuobiToastUtil.j(R$string.contract_trade_available_not_more_than_one);
                        contractOrderPlace2.l0(false);
                    }
                    if (contractOrderPlace.t() != 1 && divide2.compareTo(a12) < 0) {
                        HuobiToastUtil.j(R$string.n_contract_trade_available_not_enough);
                        contractOrderPlace2.l0(false);
                    }
                }
            } else if (v11 == 1 || v11 == 2) {
                if (e11 != 0) {
                    if (contractOrderPlace.d() != null) {
                        a12 = x11.multiply(contractOrderPlace.d()).divide(m.f68179a, 32, 1);
                    } else {
                        a12 = x11.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
                    }
                }
                if (a12.compareTo(BigDecimal.ONE) >= 0 || a12.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal = a12.setScale(f.t(G), 1);
                } else {
                    bigDecimal = BigDecimal.ONE;
                }
                a12 = bigDecimal;
                if (a12.compareTo(BigDecimal.ZERO) <= 0) {
                    HuobiToastUtil.j(R$string.contract_trade_available_not_more_than_one);
                    contractOrderPlace2.l0(false);
                }
                if (contractOrderPlace.t() != 1 && a12.compareTo(x11) > 0) {
                    HuobiToastUtil.j(R$string.contract_trade_close_available_not_enough);
                    contractOrderPlace2.l0(false);
                }
            }
            b11 = a12.toPlainString();
            this.f40785b = a12;
            if (bigDecimal4.compareTo(BigDecimal.ZERO) != 0) {
                this.f40784a = a12.multiply(m.a(contractCurrencyInfo.getContractFace())).divide(bigDecimal4, f.n(contractCurrencyInfo.getContractCode()), 1);
            }
        }
        if (m.a(contractOrderPlace.w()).compareTo(BigDecimal.ZERO) == 0) {
            HuobiToastUtil.j(R$string.n_can_not_get_price);
            contractOrderPlace2.l0(false);
        }
        contractOrderPlace2.c1(b11);
        this.f40789f.a(contractOrderPlace2);
        return contractOrderPlace2;
    }

    public final void O(ContractOrderPlace contractOrderPlace, boolean z11) {
        HashMap hashMap = new HashMap();
        if (contractOrderPlace.X()) {
            if (contractOrderPlace.r().equals("open")) {
                hashMap.put("trade_type", "buy_open");
            } else {
                hashMap.put("trade_type", "buy_flat");
            }
        } else if (contractOrderPlace.r().equals("open")) {
            hashMap.put("trade_type", "sell_open");
        } else {
            hashMap.put("trade_type", "sell_flat");
        }
        hashMap.put("business_category", contractOrderPlace.r().equals("open") ? "open_buy_sell" : "flat_buy_sell");
        hashMap.put("type", "coin_contract");
        hashMap.put("margin_type", SPUtil.j() ? "usdt_multiple" : "usdt_single");
        if (z11) {
            ContractModuleConfig.a().c("appexposure_contracts", hashMap);
            return;
        }
        hashMap.put("button_name", "confirm");
        ContractModuleConfig.a().c("appclick_contracts", hashMap);
    }

    public ContractOrderPlace P(Context context, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        String str;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        ContractOrderPlace contractOrderPlace2 = contractOrderPlace;
        String G = contractOrderPlace.G();
        String b11 = contractOrderPlace.b();
        String w11 = contractOrderPlace.w();
        boolean X = contractOrderPlace.X();
        int e11 = contractOrderPlace.e();
        BigDecimal a11 = m.a(w11);
        BigDecimal a12 = m.a(b11);
        BigDecimal x11 = x(contractCurrencyInfo.getContractCode(), X);
        if (e.E(TradeType.CONTRACT)) {
            BigDecimal bigDecimal4 = BigDecimal.ZERO;
            if (e11 == 0) {
                bigDecimal2 = a11.multiply(a12).divide(m.a(contractCurrencyInfo.getContractFace()), 32, 1);
            } else {
                bigDecimal2 = x11.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
            }
            if (bigDecimal2.compareTo(BigDecimal.ONE) >= 0 || bigDecimal2.compareTo(BigDecimal.ZERO) <= 0) {
                bigDecimal3 = bigDecimal2.setScale(f.t(G), 1);
            } else {
                bigDecimal3 = BigDecimal.ONE;
            }
            BigDecimal bigDecimal5 = bigDecimal3;
            if (n(context, G, bigDecimal5, contractCurrencyInfo, a11, contractOrderPlace.o())) {
                contractOrderPlace2.l0(false);
            }
            if (bigDecimal5.compareTo(x11) > 0) {
                HuobiToastUtil.j(R$string.contract_trade_close_available_not_enough);
                contractOrderPlace2.l0(false);
            }
            str = bigDecimal5.toPlainString();
            this.f40785b = bigDecimal5;
            if (a11.compareTo(BigDecimal.ZERO) != 0) {
                this.f40784a = bigDecimal5.multiply(m.a(contractCurrencyInfo.getContractFace())).divide(a11, f.n(contractCurrencyInfo.getContractCode()), 1);
            }
        } else {
            if (e11 != 0) {
                a12 = x11.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
            }
            if (a12.compareTo(BigDecimal.ONE) >= 0 || a12.compareTo(BigDecimal.ZERO) <= 0) {
                bigDecimal = a12.setScale(f.c(G), 1);
            } else {
                bigDecimal = BigDecimal.ONE;
            }
            if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                HuobiToastUtil.j(R$string.contract_trade_available_not_more_than_one);
                contractOrderPlace2.l0(false);
            }
            if (bigDecimal.compareTo(x11) > 0) {
                HuobiToastUtil.j(R$string.contract_trade_close_available_not_enough);
                contractOrderPlace2.l0(false);
            }
            String plainString = bigDecimal.toPlainString();
            this.f40785b = bigDecimal;
            if (a11.compareTo(BigDecimal.ZERO) != 0) {
                this.f40784a = bigDecimal.multiply(m.a(contractCurrencyInfo.getContractFace())).divide(a11, f.n(contractCurrencyInfo.getContractCode()), 1);
            }
            str = plainString;
        }
        contractOrderPlace2.N0(G);
        contractOrderPlace2.c1(str);
        this.f40789f.a(contractOrderPlace2);
        return contractOrderPlace2;
    }

    public final void Q(Context context, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo, DialogUtils.b.f fVar) {
        if (ContractUserInfoProvider.i().q()) {
            q7.a.a().E(contractCurrencyInfo.getContractCode(), contractCurrencyInfo.getContractType(), contractOrderPlace.w(), contractOrderPlace.W(), contractOrderPlace.y(), contractOrderPlace.l(), contractOrderPlace.r()).b().compose(RxJavaHelper.t(y())).subscribe(new a(context, fVar));
        } else {
            fVar.a((HBDialogFragment) null);
        }
    }

    public final void R(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        if (6 == contractOrderPlace.Q()) {
            M(contractOrderPlace, contractCurrencyInfo).compose(RxJavaHelper.t(y())).subscribe(new b(this, (a) null));
        } else {
            q(contractOrderPlace, contractCurrencyInfo).compose(RxJavaHelper.t(y())).subscribe(new b(this, (a) null));
        }
    }

    public void S(String str, ContractAccountInfo contractAccountInfo) {
        this.f40787d.put(str, contractAccountInfo);
    }

    public void T(String str, ContractPosition contractPosition) {
        this.f40788e.put(str, contractPosition);
    }

    public void U(ContractOrderPlace contractOrderPlace, Context context, ContractCurrencyInfo contractCurrencyInfo, View.OnClickListener onClickListener, OrderConfirmBottomSheetDialogFragment.a aVar) {
        String str;
        String str2;
        String str3;
        String str4;
        Context context2 = context;
        BigDecimal a11 = m.a(contractOrderPlace.S());
        BigDecimal valueOf = BigDecimal.valueOf(contractOrderPlace.k());
        BigDecimal a12 = m.a(contractOrderPlace.w());
        boolean X = contractOrderPlace.X();
        boolean z11 = false;
        if (contractOrderPlace.Q() == 1) {
            str = String.format(context2.getString(R$string.contract_order_dialog_price), new Object[]{a12.toPlainString()});
        } else {
            str = contractOrderPlace.s().toString();
        }
        ArrayList arrayList = new ArrayList();
        OrderConfirmBean.ListItem listItem = new OrderConfirmBean.ListItem();
        listItem.setKey(context2.getString(R$string.contract_order_dialog_exchange_title));
        listItem.setValue(contractOrderPlace.P());
        listItem.setUseNewStyle(true);
        arrayList.add(listItem);
        OrderConfirmBean.ListItem listItem2 = new OrderConfirmBean.ListItem();
        listItem2.setKey(context2.getString(R$string.contract_order_dialog_kind_title));
        listItem2.setValue(g.d(contractCurrencyInfo.getContractShortType(), contractCurrencyInfo.getContractCode(), 2));
        listItem2.setUseNewStyle(true);
        arrayList.add(listItem2);
        if (contractOrderPlace.t() == 1) {
            if (a11.compareTo(valueOf) >= 0) {
                str4 = String.format(context2.getString(R$string.n_contract_price_greater), new Object[]{a11.toPlainString()});
            } else {
                str4 = String.format(context2.getString(R$string.n_contract_price_less), new Object[]{a11.toPlainString()});
            }
            OrderConfirmBean.ListItem listItem3 = new OrderConfirmBean.ListItem();
            listItem3.setKey(context2.getString(R$string.n_exchange_order_list_trigger_condition));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str4);
            if (!TextUtils.isEmpty(contractOrderPlace.T())) {
                spannableStringBuilder.append(com.huobi.utils.n0.b(context2, -1, contractOrderPlace.T(), "(", ")"));
            }
            listItem3.setValue(spannableStringBuilder);
            listItem3.setUseNewStyle(true);
            arrayList.add(listItem3);
        }
        if (contractOrderPlace.t() == 5) {
            OrderConfirmBean.ListItem listItem4 = new OrderConfirmBean.ListItem();
            listItem4.setKey(context2.getString(R$string.n_contract_active_price_condition));
            if (contractOrderPlace.X()) {
                listItem4.setValue(String.format(context2.getString(R$string.n_contract_price_less), new Object[]{a12.toPlainString()}));
            } else {
                listItem4.setValue(String.format(context2.getString(R$string.n_contract_price_greater), new Object[]{a12.toPlainString()}));
            }
            listItem4.setUseNewStyle(true);
            arrayList.add(listItem4);
            OrderConfirmBean.ListItem listItem5 = new OrderConfirmBean.ListItem();
            listItem5.setKey(context2.getString(R$string.n_contract_call_back_rate));
            listItem5.setValue(contractOrderPlace.h() + "%");
            listItem5.setUseNewStyle(true);
            arrayList.add(listItem5);
        }
        OrderConfirmBean.ListItem listItem6 = new OrderConfirmBean.ListItem();
        int i11 = R$string.contract_order_dialog_order_price_title;
        listItem6.setKey(context2.getString(i11));
        listItem6.setUseNewStyle(true);
        if (contractOrderPlace.t() == 5) {
            listItem6.setValue(contractOrderPlace.N().toString());
        } else if (contractOrderPlace.t() == 6) {
            listItem6.setValue(context.getResources().getString(R$string.n_exchange_order_list_market));
        } else {
            listItem6.setValue(str);
        }
        arrayList.add(listItem6);
        OrderConfirmBean.ListItem listItem7 = new OrderConfirmBean.ListItem();
        listItem7.setKey(context2.getString(R$string.contract_order_dialog_amout_title));
        listItem7.setValue(this.f40784a + contractCurrencyInfo.getSymbol());
        listItem7.setUseNewStyle(true);
        arrayList.add(listItem7);
        if (!TextUtils.isEmpty(contractOrderPlace.K()) || !TextUtils.isEmpty(contractOrderPlace.E())) {
            z11 = true;
        }
        if (z11) {
            arrayList.add(new OrderConfirmBean.DividerItem());
        }
        if (!TextUtils.isEmpty(contractOrderPlace.K())) {
            OrderConfirmBean.ListItem listItem8 = new OrderConfirmBean.ListItem();
            listItem8.setKey(context2.getString(R$string.n_contract_confirm_dialog_take_profit_trigger_price));
            if (X) {
                str3 = "≥ " + contractOrderPlace.K() + " " + context2.getString(R$string.usd_en_uppercase);
            } else {
                str3 = "≤ " + contractOrderPlace.K() + " " + context2.getString(R$string.usd_en_uppercase);
            }
            listItem8.setValue(str3);
            arrayList.add(listItem8);
            OrderConfirmBean.ListItem listItem9 = new OrderConfirmBean.ListItem();
            listItem9.setKey(context2.getString(i11));
            if ("limit".equals(contractOrderPlace.J()) || TextUtils.isEmpty(contractOrderPlace.J())) {
                listItem9.setValue(contractOrderPlace.H() + " " + context2.getString(R$string.usd_en_uppercase));
            } else {
                listItem9.setValue(contractOrderPlace.I());
            }
            arrayList.add(listItem9);
        }
        if (!TextUtils.isEmpty(contractOrderPlace.E())) {
            OrderConfirmBean.ListItem listItem10 = new OrderConfirmBean.ListItem();
            listItem10.setKey(context2.getString(R$string.n_contract_confirm_dialog_stop_loss_trigger_price));
            if (X) {
                str2 = "≤ " + contractOrderPlace.E() + " " + context2.getString(R$string.usd_en_uppercase);
            } else {
                str2 = "≥ " + contractOrderPlace.E() + " " + context2.getString(R$string.usd_en_uppercase);
            }
            listItem10.setValue(str2);
            arrayList.add(listItem10);
            OrderConfirmBean.ListItem listItem11 = new OrderConfirmBean.ListItem();
            listItem11.setKey(context2.getString(i11));
            if ("limit".equals(contractOrderPlace.D()) || TextUtils.isEmpty(contractOrderPlace.D())) {
                listItem11.setValue(contractOrderPlace.B() + " " + context2.getString(R$string.usd_en_uppercase));
            } else {
                listItem11.setValue(contractOrderPlace.C());
            }
            arrayList.add(listItem11);
        }
        if (z11) {
            arrayList.add(new OrderConfirmBean.DividerItem());
            PriceProtectionItem priceProtectionItem = new PriceProtectionItem();
            priceProtectionItem.setSymbol(contractCurrencyInfo.getSymbol());
            priceProtectionItem.setContractCode(contractCurrencyInfo.getContractCode());
            priceProtectionItem.setContractShortType(contractCurrencyInfo.getContractShortType());
            priceProtectionItem.setTradeType(TradeType.CONTRACT);
            arrayList.add(priceProtectionItem);
        }
        OrderConfirmBean orderConfirmBean = new OrderConfirmBean();
        orderConfirmBean.setList(arrayList);
        orderConfirmBean.setConfirmBtnText(context2.getString(R$string.login_dialog_confirm));
        orderConfirmBean.setTitle(context2.getString(R$string.contract_order_place_confirm_title));
        if (contractOrderPlace.t() == 1) {
            if (a12.compareTo(a11) >= 0) {
                if (a12.divide(a11, 32, 1).compareTo(BigDecimal.valueOf(1.01d)) > 0 && X) {
                    orderConfirmBean.setHint(context2.getString(R$string.contract_order_place_price_high));
                }
            } else if (a12.divide(a11, 32, 1).compareTo(BigDecimal.valueOf(0.99d)) < 0 && !X) {
                orderConfirmBean.setHint(context2.getString(R$string.contract_order_place_price_low));
            }
        }
        OrderConfirmBottomSheetDialogFragment vh2 = OrderConfirmBottomSheetDialogFragment.vh(orderConfirmBean, aVar, onClickListener);
        this.f40790g = vh2;
        vh2.show(((FragmentActivity) context2).getSupportFragmentManager(), "OrderConfirmBottomSheetDialogFragment");
        ContractModuleConfig.a().c("confirm_order_close_pop_expose", (HashMap) null);
        O(contractOrderPlace, true);
    }

    public ContractOrderPlace V(Context context, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        String w11 = contractOrderPlace.w();
        String b11 = contractOrderPlace.b();
        int v11 = contractOrderPlace.v();
        boolean X = contractOrderPlace.X();
        int e11 = contractOrderPlace.e();
        String G = contractOrderPlace.G();
        String o11 = contractOrderPlace.o();
        int Q = contractOrderPlace.Q();
        BigDecimal a11 = m.a(w11);
        BigDecimal a12 = m.a(b11);
        BigDecimal w12 = w(G);
        if (contractOrderPlace.t() == 1 && Q != 1) {
            a11 = m.a(contractOrderPlace.S());
        }
        BigDecimal bigDecimal3 = a11;
        if (e.E(TradeType.CONTRACT)) {
            if (v11 == 0) {
                if (e11 != 0) {
                    if (contractOrderPlace.d() != null) {
                        a12 = w12.multiply(m.a(o11)).multiply(contractOrderPlace.d()).divide(m.f68179a, 32, 1);
                    } else {
                        a12 = w12.multiply(m.a(o11)).multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
                    }
                }
                if (n(context, G, bigDecimal3.multiply(a12).divide(m.a(contractCurrencyInfo.getContractFace()), f.t(G), 1), contractCurrencyInfo, bigDecimal3, o11)) {
                    contractOrderPlace.l0(false);
                }
            } else if (v11 == 1 || v11 == 2) {
                if (e11 == 0) {
                    bigDecimal = bigDecimal3.multiply(a12).divide(m.a(contractCurrencyInfo.getContractFace()), 32, 1);
                } else {
                    BigDecimal x11 = x(contractCurrencyInfo.getContractCode(), X);
                    if (contractOrderPlace.d() != null) {
                        bigDecimal = x11.multiply(contractOrderPlace.d()).divide(m.f68179a, 32, 1);
                    } else {
                        bigDecimal = x11.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
                    }
                }
                if (bigDecimal.compareTo(BigDecimal.ONE) >= 0 || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal2 = bigDecimal.setScale(f.t(G), 1);
                } else {
                    bigDecimal2 = BigDecimal.ONE;
                }
                if (n(context, G, bigDecimal2, contractCurrencyInfo, bigDecimal3, o11)) {
                    contractOrderPlace.l0(false);
                }
            }
        }
        return contractOrderPlace;
    }

    public void W(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo, Context context) {
        int t11 = contractOrderPlace.t();
        if (this.f40789f.b(t11)) {
            if (p0.b()) {
                U(contractOrderPlace, context, contractCurrencyInfo, new t0(this), new b1(this, context, contractOrderPlace, contractCurrencyInfo));
                return;
            }
            Q(context, contractOrderPlace, contractCurrencyInfo, new y0(this, contractOrderPlace, contractCurrencyInfo));
        } else if (t11 == 1) {
            if (p0.c()) {
                U(contractOrderPlace, context, contractCurrencyInfo, new q0(this), new s0(this, context, contractOrderPlace, contractCurrencyInfo));
                return;
            }
            Q(context, contractOrderPlace, contractCurrencyInfo, new z0(this, contractOrderPlace, contractCurrencyInfo));
        } else if (t11 != 5) {
        } else {
            if (p0.c()) {
                U(contractOrderPlace, context, contractCurrencyInfo, new u0(this), new r0(this, context, contractOrderPlace, contractCurrencyInfo));
                return;
            }
            Q(context, contractOrderPlace, contractCurrencyInfo, new v0(this, contractOrderPlace, contractCurrencyInfo));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void X(com.huobi.contract.entity.ContractOrderPlace r18) {
        /*
            r17 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "service_line"
            java.lang.String r2 = "currency_contract"
            r0.put(r1, r2)
            java.lang.String r1 = r18.G()
            java.lang.String r2 = r18.j()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0032
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = "_"
            r2.append(r1)
            java.lang.String r1 = r18.j()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
        L_0x0032:
            java.lang.String r2 = "tradepair_name"
            r0.put(r2, r1)
            java.lang.String r1 = r18.K()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r2 = "20"
            java.lang.String r3 = "10"
            java.lang.String r4 = "5"
            java.lang.String r6 = "optimal_5"
            java.lang.String r8 = "optimal_20"
            r9 = 1
            java.lang.String r10 = "optimal_10"
            java.lang.String r11 = "limit"
            r12 = -1
            java.lang.String r13 = ""
            r14 = 0
            java.lang.String r15 = " USD"
            java.lang.String r5 = "pgear_name"
            if (r1 != 0) goto L_0x00c8
            java.lang.String r1 = r18.J()
            r1.hashCode()
            int r16 = r1.hashCode()
            switch(r16) {
                case 102976443: goto L_0x0083;
                case 1305011708: goto L_0x007a;
                case 1305011739: goto L_0x0071;
                case 1843212472: goto L_0x0068;
                default: goto L_0x0066;
            }
        L_0x0066:
            r1 = r12
            goto L_0x008b
        L_0x0068:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x006f
            goto L_0x0066
        L_0x006f:
            r1 = 3
            goto L_0x008b
        L_0x0071:
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x0078
            goto L_0x0066
        L_0x0078:
            r1 = 2
            goto L_0x008b
        L_0x007a:
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x0081
            goto L_0x0066
        L_0x0081:
            r1 = r9
            goto L_0x008b
        L_0x0083:
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x008a
            goto L_0x0066
        L_0x008a:
            r1 = r14
        L_0x008b:
            switch(r1) {
                case 0: goto L_0x00b1;
                case 1: goto L_0x00ad;
                case 2: goto L_0x00a9;
                case 3: goto L_0x00a5;
                default: goto L_0x008e;
            }
        L_0x008e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = r18.H()
            r1.append(r7)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r0.put(r5, r1)
            goto L_0x00cb
        L_0x00a5:
            r0.put(r5, r4)
            goto L_0x00cb
        L_0x00a9:
            r0.put(r5, r2)
            goto L_0x00cb
        L_0x00ad:
            r0.put(r5, r3)
            goto L_0x00cb
        L_0x00b1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = r18.H()
            r1.append(r7)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r0.put(r5, r1)
            goto L_0x00cb
        L_0x00c8:
            r0.put(r5, r13)
        L_0x00cb:
            java.lang.String r1 = r18.E()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r5 = "lgear_name"
            if (r1 != 0) goto L_0x0146
            java.lang.String r1 = r18.D()
            r1.hashCode()
            int r7 = r1.hashCode()
            switch(r7) {
                case 102976443: goto L_0x0101;
                case 1305011708: goto L_0x00f8;
                case 1305011739: goto L_0x00ef;
                case 1843212472: goto L_0x00e6;
                default: goto L_0x00e5;
            }
        L_0x00e5:
            goto L_0x0109
        L_0x00e6:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x00ed
            goto L_0x0109
        L_0x00ed:
            r12 = 3
            goto L_0x0109
        L_0x00ef:
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x00f6
            goto L_0x0109
        L_0x00f6:
            r12 = 2
            goto L_0x0109
        L_0x00f8:
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x00ff
            goto L_0x0109
        L_0x00ff:
            r12 = r9
            goto L_0x0109
        L_0x0101:
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x0108
            goto L_0x0109
        L_0x0108:
            r12 = r14
        L_0x0109:
            switch(r12) {
                case 0: goto L_0x012f;
                case 1: goto L_0x012b;
                case 2: goto L_0x0127;
                case 3: goto L_0x0123;
                default: goto L_0x010c;
            }
        L_0x010c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r18.B()
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r0.put(r5, r1)
            goto L_0x0149
        L_0x0123:
            r0.put(r5, r4)
            goto L_0x0149
        L_0x0127:
            r0.put(r5, r2)
            goto L_0x0149
        L_0x012b:
            r0.put(r5, r3)
            goto L_0x0149
        L_0x012f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r18.B()
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r0.put(r5, r1)
            goto L_0x0149
        L_0x0146:
            r0.put(r5, r13)
        L_0x0149:
            sc.a r1 = com.hbg.module.contract.ContractModuleConfig.a()
            java.lang.String r2 = "confirm_order_close_pop_submit_click"
            r1.c(r2, r0)
            r0 = r17
            r1 = r18
            r0.O(r1, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bj.d1.X(com.huobi.contract.entity.ContractOrderPlace):void");
    }

    public final boolean n(Context context, String str, BigDecimal bigDecimal, ContractCurrencyInfo contractCurrencyInfo, BigDecimal bigDecimal2, String str2) {
        if (bigDecimal.compareTo(BigDecimal.ONE) >= 0 || bigDecimal2.compareTo(BigDecimal.ZERO) == 0) {
            return false;
        }
        BigDecimal divide = m.a(contractCurrencyInfo.getContractFace()).divide(bigDecimal2, 32, 1);
        if (e.H(TradeType.CONTRACT)) {
            divide = divide.divide(m.a(str2), RoundingMode.UP);
        }
        HuobiToastUtil.l(context, String.format(context.getString(R$string.contract_trade_lowest_amount), new Object[]{m.F(divide.toPlainString(), f.n(contractCurrencyInfo.getContractCode())), str}));
        return true;
    }

    public void o() {
        this.f40787d.clear();
        p();
    }

    public void p() {
        this.f40788e.clear();
    }

    public Observable<ContractOrderInsertRspInfo> q(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        ContractOrderPlace contractOrderPlace2 = contractOrderPlace;
        if (contractOrderPlace.Q() != 1) {
            contractOrderPlace2.B0("");
        }
        if (contractOrderPlace.z() == 100) {
            contractOrderPlace2.m0(1);
        } else {
            contractOrderPlace2.m0(0);
        }
        return q7.a.a().I(contractOrderPlace.G(), contractCurrencyInfo.getContractType(), contractCurrencyInfo.getContractCode(), contractOrderPlace.w(), contractOrderPlace.y(), contractOrderPlace.W(), contractOrderPlace.l(), contractOrderPlace.r(), contractOrderPlace.o(), contractOrderPlace.i(), contractOrderPlace.K(), contractOrderPlace.H(), contractOrderPlace.J(), contractOrderPlace.L(), contractOrderPlace.E(), contractOrderPlace.B(), contractOrderPlace.D(), contractOrderPlace.F(), contractOrderPlace.M()).b().delay(300, TimeUnit.MILLISECONDS);
    }

    public Observable<ContractTpSlOrderRspInfo> r(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        ContractOrderPlace contractOrderPlace2 = contractOrderPlace;
        if (!"limit".equalsIgnoreCase(contractOrderPlace.J())) {
            contractOrderPlace2.O0("");
        }
        if (!"limit".equalsIgnoreCase(contractOrderPlace.D())) {
            contractOrderPlace2.I0("");
        }
        return q7.a.a().N(contractOrderPlace.G(), contractCurrencyInfo.getContractType(), contractCurrencyInfo.getContractCode(), contractOrderPlace.l(), contractOrderPlace.W(), contractOrderPlace.K(), contractOrderPlace.H(), contractOrderPlace.J(), contractOrderPlace.L(), contractOrderPlace.E(), contractOrderPlace.B(), contractOrderPlace.D(), contractOrderPlace.F()).b().delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(y()));
    }

    public final void s(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        contractOrderPlace.k0(m.a(contractOrderPlace.h()).divide(m.f68179a, 3, 1).toPlainString());
        q7.a.a().F(contractOrderPlace.G(), contractCurrencyInfo.getContractType(), contractCurrencyInfo.getContractCode(), contractOrderPlace.l(), contractOrderPlace.r(), contractOrderPlace.o(), contractOrderPlace.W(), contractOrderPlace.h(), contractOrderPlace.w(), contractOrderPlace.y()).b().delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(y())).subscribe(new b(this, (a) null));
    }

    public final void t(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        if (BigDecimal.valueOf(contractOrderPlace.k()).compareTo(BigDecimal.ZERO) == 0) {
            HuobiToastUtil.j(R$string.n_can_not_get_price);
            if (y() != null) {
                y().z0(true);
                return;
            }
            return;
        }
        u(contractOrderPlace, contractCurrencyInfo).subscribe(new b(this, (a) null));
    }

    public Observable<ContractOrderInsertRspInfo> u(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        if (contractOrderPlace.Q() != 1) {
            contractOrderPlace.B0("");
        }
        return q7.a.a().y(contractOrderPlace.G(), contractCurrencyInfo.getContractType(), contractCurrencyInfo.getContractCode(), contractOrderPlace.w(), contractOrderPlace.y(), contractOrderPlace.W(), contractOrderPlace.l(), contractOrderPlace.r(), contractOrderPlace.o(), contractOrderPlace.U(), contractOrderPlace.S()).b().delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(y()));
    }

    public BigDecimal v() {
        return this.f40784a;
    }

    public BigDecimal w(String str) {
        ContractAccountInfo contractAccountInfo = this.f40787d.get(str);
        if (contractAccountInfo == null) {
            return BigDecimal.ZERO;
        }
        return m.a(contractAccountInfo.getMarginAvailable());
    }

    public BigDecimal x(String str, boolean z11) {
        ContractPosition contractPosition;
        if (z11) {
            Map<String, ContractPosition> map = this.f40788e;
            contractPosition = map.get(str + "sell");
        } else {
            Map<String, ContractPosition> map2 = this.f40788e;
            contractPosition = map2.get(str + "buy");
        }
        if (contractPosition == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(contractPosition.getAvailable());
    }

    public final n0 y() {
        return (n0) this.f40786c.get();
    }

    public void z() {
        OrderConfirmBottomSheetDialogFragment orderConfirmBottomSheetDialogFragment = this.f40790g;
        if (orderConfirmBottomSheetDialogFragment != null && orderConfirmBottomSheetDialogFragment.isAdded()) {
            this.f40790g.dismiss();
        }
        if (y() != null) {
            y().z0(true);
        }
    }
}
