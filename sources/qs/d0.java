package qs;

import a7.e;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import bh.j;
import bj.p0;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.network.swap.core.bean.OrderInsertRspInfo;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.lib.network.swap.core.bean.SwapTpSlOrderRspInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.dialog.OrderConfirmBottomSheetDialogFragment;
import com.hbg.lib.widgets.dialog.bean.OrderConfirmBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.entity.OffSiteLimit;
import com.huobi.contract.entity.PriceProtectionItem;
import com.huobi.contract.helper.FuturesTradeActionController;
import com.huobi.contract.utils.KycLimitCodeUtils;
import com.huobi.utils.n0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ej.f;
import gs.g;
import i6.m;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import m9.z;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.Observable;
import ts.g0;
import us.i;

public class d0 {

    /* renamed from: a  reason: collision with root package name */
    public BigDecimal f84587a;

    /* renamed from: b  reason: collision with root package name */
    public BigDecimal f84588b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<g0> f84589c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, SwapAccountInfo> f84590d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public Map<String, SwapPosition> f84591e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public FuturesTradeActionController f84592f;

    /* renamed from: g  reason: collision with root package name */
    public OrderConfirmBottomSheetDialogFragment f84593g;

    public class a extends EasySubscriber<OffSiteLimit> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f84594b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DialogUtils.b.f f84595c;

        public a(Context context, DialogUtils.b.f fVar) {
            this.f84594b = context;
            this.f84595c = fVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            d0.this.C().z0(true);
        }

        /* renamed from: c */
        public void onNext(OffSiteLimit offSiteLimit) {
            super.onNext(offSiteLimit);
            if (offSiteLimit.tipFlag) {
                new DialogUtils.b.d((FragmentActivity) this.f84594b).C0(offSiteLimit.tipMsg).P0(this.f84594b.getString(R.string.n_sure)).s0(this.f84594b.getString(R.string.n_cancel)).Q0(this.f84595c).N0(new c0(this)).j0().show(((FragmentActivity) this.f84594b).getSupportFragmentManager(), "");
            } else {
                this.f84595c.a((HBDialogFragment) null);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            this.f84595c.a((HBDialogFragment) null);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            this.f84595c.a((HBDialogFragment) null);
        }
    }

    public class b extends EasySubscriber<Object> {
        public b() {
        }

        public void onAfter() {
            super.onAfter();
            d0.this.C().dismissProgressDialog();
            d0.this.C().z0(true);
        }

        public void onError2(Throwable th2) {
            if (!NetworkStatus.c(BaseApplication.b())) {
                HuobiToastUtil.j(R.string.n_no_network);
            } else {
                HuobiToastUtil.k(BaseApplication.b(), R.string.string_order_op_fail);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (KycLimitCodeUtils.a(aPIStatusErrorException.getErrCode())) {
                d0.this.C().t1(aPIStatusErrorException.getErrMsg());
            } else if (KycLimitCodeUtils.b(aPIStatusErrorException.getErrCode())) {
                d0.this.C().q(aPIStatusErrorException.getErrMsg());
            } else {
                String errCode = aPIStatusErrorException.getErrCode();
                errCode.hashCode();
                if (errCode.equals("1501")) {
                    d0.this.C().b1();
                } else if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                    HuobiToastUtil.l(BaseApplication.b(), aPIStatusErrorException.getErrMsg());
                }
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            d0.this.C().c1(false);
            d0.this.C().u0(false, false);
            d0.this.C().w0(true, true);
            d0.this.C().t0();
            HuobiToastUtil.t(j.c(), R.string.string_order_op_ok);
            s6.a.b(j.c()).c(R.raw.order_success);
            EventBus.d().k(new ContractAssetAndOrderUpdateEvent());
        }

        public void onStart() {
            super.onStart();
            d0.this.C().showProgressDialog();
            d0.this.C().z0(false);
        }

        public /* synthetic */ b(d0 d0Var, a aVar) {
            this();
        }
    }

    public d0(g0 g0Var) {
        this.f84589c = new WeakReference<>(g0Var);
        this.f84592f = new FuturesTradeActionController();
    }

    public static /* synthetic */ SwapTpSlOrderRspInfo E(SwapTpSlOrderRspInfo swapTpSlOrderRspInfo) {
        return swapTpSlOrderRspInfo;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void F(View view) {
        g.i("confirm_order_close_pop_back_click", (HashMap) null);
        C().z0(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        U(contractOrderPlace, swapCurrencyInfo);
        b0(contractOrderPlace);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(Context context, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo, boolean z11, View view) {
        p0.l(z11 ^ true ? 1 : 0);
        T(context, contractOrderPlace, swapCurrencyInfo, new y(this, contractOrderPlace, swapCurrencyInfo));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        s(contractOrderPlace, swapCurrencyInfo);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(Context context, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo, boolean z11, View view) {
        p0.j(z11 ^ true ? 1 : 0);
        T(context, contractOrderPlace, swapCurrencyInfo, new a0(this, contractOrderPlace, swapCurrencyInfo));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        U(contractOrderPlace, swapCurrencyInfo);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void L(View view) {
        g.i("confirm_order_close_pop_back_click", (HashMap) null);
        C().z0(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        t(contractOrderPlace, swapCurrencyInfo);
        b0(contractOrderPlace);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(Context context, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo, boolean z11, View view) {
        p0.l(z11 ^ true ? 1 : 0);
        T(context, contractOrderPlace, swapCurrencyInfo, new w(this, contractOrderPlace, swapCurrencyInfo));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        t(contractOrderPlace, swapCurrencyInfo);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void P(View view) {
        if (C() != null) {
            C().z0(true);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        s(contractOrderPlace, swapCurrencyInfo);
    }

    public BigDecimal A(String str) {
        SwapAccountInfo swapAccountInfo = this.f84590d.get(str);
        if (swapAccountInfo == null) {
            return BigDecimal.ZERO;
        }
        return m.a(swapAccountInfo.getMarginAvailable());
    }

    public BigDecimal B(String str, boolean z11) {
        SwapPosition swapPosition;
        if (z11) {
            Map<String, SwapPosition> map = this.f84591e;
            swapPosition = map.get(str + "sell");
        } else {
            Map<String, SwapPosition> map2 = this.f84591e;
            swapPosition = map2.get(str + "buy");
        }
        if (swapPosition == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(swapPosition.getAvailable());
    }

    public final g0 C() {
        return (g0) this.f84589c.get();
    }

    public void D() {
        OrderConfirmBottomSheetDialogFragment orderConfirmBottomSheetDialogFragment = this.f84593g;
        if (orderConfirmBottomSheetDialogFragment != null && orderConfirmBottomSheetDialogFragment.isAdded()) {
            this.f84593g.dismiss();
        }
        C().z0(true);
    }

    public Observable<OrderInsertRspInfo> R(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        if (contractOrderPlace.z() == 100) {
            contractOrderPlace.m0(1);
        } else {
            contractOrderPlace.m0(0);
        }
        return l9.a.a().B(swapCurrencyInfo.getContractCode(), contractOrderPlace.W(), contractOrderPlace.l(), contractOrderPlace.y(), contractOrderPlace.i()).b().delay(300, TimeUnit.MILLISECONDS);
    }

    public final void S(ContractOrderPlace contractOrderPlace, boolean z11) {
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
        String str = contractOrderPlace.r().equals("open") ? "open_buy_sell" : "flat_buy_sell";
        hashMap.put("margin_type", SPUtil.j() ? "usdt_multiple" : "usdt_single");
        if (z11) {
            g.a(str, "coin_contract", hashMap);
        } else {
            g.j(str, "coin_contract", "confirm", hashMap);
        }
    }

    public final void T(Context context, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo, DialogUtils.b.f fVar) {
        if (z.f().j()) {
            l9.a.a().J(swapCurrencyInfo.getContractCode(), contractOrderPlace.w(), contractOrderPlace.W(), contractOrderPlace.y(), contractOrderPlace.l(), contractOrderPlace.r()).b().compose(RxJavaHelper.t(C())).subscribe(new a(context, fVar));
        } else {
            fVar.a((HBDialogFragment) null);
        }
    }

    public final void U(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        if (6 == contractOrderPlace.Q()) {
            R(contractOrderPlace, swapCurrencyInfo).compose(RxJavaHelper.t(C())).subscribe(new b(this, (a) null));
        } else {
            Y(contractOrderPlace, swapCurrencyInfo).compose(RxJavaHelper.t(C())).subscribe(new b(this, (a) null));
        }
    }

    public void V(String str, SwapAccountInfo swapAccountInfo) {
        this.f84590d.put(str, swapAccountInfo);
    }

    public void W(String str, SwapPosition swapPosition) {
        this.f84591e.put(str, swapPosition);
    }

    public void X(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo, Context context, View.OnClickListener onClickListener, OrderConfirmBottomSheetDialogFragment.a aVar) {
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
            str = String.format(context2.getString(R.string.contract_order_dialog_price), new Object[]{a12.toPlainString()});
        } else {
            str = contractOrderPlace.s().toString();
        }
        ArrayList arrayList = new ArrayList();
        OrderConfirmBean.ListItem listItem = new OrderConfirmBean.ListItem();
        listItem.setKey(context2.getString(R.string.contract_order_dialog_exchange_title));
        listItem.setValue(contractOrderPlace.P());
        listItem.setUseNewStyle(true);
        arrayList.add(listItem);
        OrderConfirmBean.ListItem listItem2 = new OrderConfirmBean.ListItem();
        listItem2.setKey(context2.getString(R.string.contract_order_dialog_kind_title));
        listItem2.setUseNewStyle(true);
        listItem2.setValue(us.j.f(contractOrderPlace.G(), context2));
        arrayList.add(listItem2);
        if (contractOrderPlace.t() == 1) {
            if (a11.compareTo(valueOf) >= 0) {
                str4 = String.format(context2.getString(R.string.n_contract_price_greater), new Object[]{a11.toPlainString()});
            } else {
                str4 = String.format(context2.getString(R.string.n_contract_price_less), new Object[]{a11.toPlainString()});
            }
            OrderConfirmBean.ListItem listItem3 = new OrderConfirmBean.ListItem();
            listItem3.setKey(context2.getString(R.string.n_exchange_order_list_trigger_condition));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str4);
            if (!TextUtils.isEmpty(contractOrderPlace.T())) {
                spannableStringBuilder.append(n0.b(context2, -1, contractOrderPlace.T(), "(", ")"));
            }
            listItem3.setValue(spannableStringBuilder);
            listItem3.setUseNewStyle(true);
            arrayList.add(listItem3);
        }
        if (contractOrderPlace.t() == 5) {
            OrderConfirmBean.ListItem listItem4 = new OrderConfirmBean.ListItem();
            listItem4.setKey(context2.getString(R.string.n_contract_active_price_condition));
            if (contractOrderPlace.X()) {
                listItem4.setValue(String.format(context2.getString(R.string.n_contract_price_less), new Object[]{a12.toPlainString()}));
            } else {
                listItem4.setValue(String.format(context2.getString(R.string.n_contract_price_greater), new Object[]{a12.toPlainString()}));
            }
            listItem4.setUseNewStyle(true);
            arrayList.add(listItem4);
            OrderConfirmBean.ListItem listItem5 = new OrderConfirmBean.ListItem();
            listItem5.setKey(context2.getString(R.string.n_contract_call_back_rate));
            listItem5.setValue(contractOrderPlace.h() + "%");
            listItem5.setUseNewStyle(true);
            arrayList.add(listItem5);
        }
        OrderConfirmBean.ListItem listItem6 = new OrderConfirmBean.ListItem();
        listItem6.setKey(context2.getString(R.string.contract_order_dialog_order_price_title));
        listItem6.setUseNewStyle(true);
        if (contractOrderPlace.t() == 5) {
            listItem6.setValue(contractOrderPlace.N().toString());
        } else if (contractOrderPlace.t() == 6) {
            listItem6.setValue(context.getResources().getString(R.string.n_exchange_order_list_market));
        } else {
            listItem6.setValue(str);
        }
        arrayList.add(listItem6);
        OrderConfirmBean.ListItem listItem7 = new OrderConfirmBean.ListItem();
        listItem7.setKey(context2.getString(R.string.contract_order_dialog_amout_title));
        listItem7.setValue(z() + contractOrderPlace.G());
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
            listItem8.setKey(context2.getString(R.string.n_contract_confirm_dialog_take_profit_trigger_price));
            if (X) {
                str3 = "≥ " + contractOrderPlace.K() + " " + context2.getString(R.string.usd_en_uppercase);
            } else {
                str3 = "≤ " + contractOrderPlace.K() + " " + context2.getString(R.string.usd_en_uppercase);
            }
            listItem8.setValue(str3);
            arrayList.add(listItem8);
            OrderConfirmBean.ListItem listItem9 = new OrderConfirmBean.ListItem();
            listItem9.setKey(context2.getString(R.string.contract_order_dialog_order_price_title));
            if ("limit".equals(contractOrderPlace.J()) || TextUtils.isEmpty(contractOrderPlace.J())) {
                listItem9.setValue(contractOrderPlace.H() + " " + context2.getString(R.string.usd_en_uppercase));
            } else {
                listItem9.setValue(contractOrderPlace.I());
            }
            arrayList.add(listItem9);
        }
        if (!TextUtils.isEmpty(contractOrderPlace.E())) {
            OrderConfirmBean.ListItem listItem10 = new OrderConfirmBean.ListItem();
            listItem10.setKey(context2.getString(R.string.n_contract_confirm_dialog_stop_loss_trigger_price));
            if (X) {
                str2 = "≤ " + contractOrderPlace.E() + " " + context2.getString(R.string.usd_en_uppercase);
            } else {
                str2 = "≥ " + contractOrderPlace.E() + " " + context2.getString(R.string.usd_en_uppercase);
            }
            listItem10.setValue(str2);
            arrayList.add(listItem10);
            OrderConfirmBean.ListItem listItem11 = new OrderConfirmBean.ListItem();
            listItem11.setKey(context2.getString(R.string.contract_order_dialog_order_price_title));
            if ("limit".equals(contractOrderPlace.D()) || TextUtils.isEmpty(contractOrderPlace.D())) {
                listItem11.setValue(contractOrderPlace.B() + " " + context2.getString(R.string.usd_en_uppercase));
            } else {
                listItem11.setValue(contractOrderPlace.C());
            }
            arrayList.add(listItem11);
        }
        if (z11) {
            arrayList.add(new OrderConfirmBean.DividerItem());
            PriceProtectionItem priceProtectionItem = new PriceProtectionItem();
            priceProtectionItem.setSymbol(swapCurrencyInfo.getSymbol());
            priceProtectionItem.setContractCode(swapCurrencyInfo.getContractCode());
            priceProtectionItem.setContractShortType(swapCurrencyInfo.getContractShortType());
            priceProtectionItem.setTradeType(TradeType.SWAP);
            arrayList.add(priceProtectionItem);
        }
        OrderConfirmBean orderConfirmBean = new OrderConfirmBean();
        orderConfirmBean.setList(arrayList);
        orderConfirmBean.setConfirmBtnText(context2.getString(R.string.login_dialog_confirm));
        orderConfirmBean.setTitle(context2.getString(R.string.contract_order_place_confirm_title));
        if (contractOrderPlace.t() == 1) {
            if (a12.compareTo(a11) >= 0) {
                if (a12.divide(a11, 32, 1).compareTo(BigDecimal.valueOf(1.01d)) > 0 && X) {
                    orderConfirmBean.setHint(context2.getString(R.string.contract_order_place_price_high));
                }
            } else if (a12.divide(a11, 32, 1).compareTo(BigDecimal.valueOf(0.99d)) < 0 && !X) {
                orderConfirmBean.setHint(context2.getString(R.string.contract_order_place_price_low));
            }
        }
        OrderConfirmBottomSheetDialogFragment vh2 = OrderConfirmBottomSheetDialogFragment.vh(orderConfirmBean, aVar, onClickListener);
        this.f84593g = vh2;
        vh2.show(((FragmentActivity) context2).getSupportFragmentManager(), "OrderConfirmBottomSheetDialogFragment");
        g.i("confirm_order_close_pop_expose", (HashMap) null);
        S(contractOrderPlace, true);
    }

    public Observable<OrderInsertRspInfo> Y(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        ContractOrderPlace contractOrderPlace2 = contractOrderPlace;
        if (contractOrderPlace.Q() != 1) {
            contractOrderPlace2.B0("");
        }
        if (contractOrderPlace.z() == 100) {
            contractOrderPlace2.m0(1);
        } else {
            contractOrderPlace2.m0(0);
        }
        return l9.a.a().D(swapCurrencyInfo.getContractCode(), contractOrderPlace.w(), contractOrderPlace.y(), contractOrderPlace.W(), contractOrderPlace.l(), contractOrderPlace.r(), contractOrderPlace.o(), contractOrderPlace.i(), contractOrderPlace.K(), contractOrderPlace.H(), contractOrderPlace.J(), contractOrderPlace.L(), contractOrderPlace.E(), contractOrderPlace.B(), contractOrderPlace.D(), contractOrderPlace.F(), contractOrderPlace.M()).b().delay(300, TimeUnit.MILLISECONDS);
    }

    public ContractOrderPlace Z(Context context, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        String w11 = contractOrderPlace.w();
        int Q = contractOrderPlace.Q();
        String b11 = contractOrderPlace.b();
        boolean X = contractOrderPlace.X();
        String G = contractOrderPlace.G();
        BigDecimal a11 = m.a(w11);
        BigDecimal a12 = m.a(b11);
        BigDecimal A = A(G);
        if (contractOrderPlace.t() == 1 && Q != 1) {
            a11 = m.a(contractOrderPlace.S());
        }
        BigDecimal bigDecimal3 = a11;
        if (e.E(TradeType.SWAP)) {
            int v11 = contractOrderPlace.v();
            int e11 = contractOrderPlace.e();
            String o11 = contractOrderPlace.o();
            if (v11 == 0) {
                if (e11 != 0) {
                    if (contractOrderPlace.d() != null) {
                        a12 = A.multiply(m.a(o11)).multiply(contractOrderPlace.d()).divide(m.f68179a, 32, 1);
                    } else {
                        a12 = A.multiply(m.a(o11)).multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
                    }
                }
                if (o(context, G, bigDecimal3.multiply(a12).divide(m.a(swapCurrencyInfo.getContractFace()), i.z(G), 1), swapCurrencyInfo, bigDecimal3, o11)) {
                    contractOrderPlace.l0(false);
                }
            } else if (v11 == 1 || v11 == 2) {
                if (e11 == 0) {
                    bigDecimal = bigDecimal3.multiply(a12).divide(m.a(swapCurrencyInfo.getContractFace()), 32, 1);
                } else {
                    BigDecimal B = B(swapCurrencyInfo.getContractCode(), X);
                    if (contractOrderPlace.d() != null) {
                        bigDecimal = B.multiply(contractOrderPlace.d()).divide(m.f68179a, 32, 1);
                    } else {
                        bigDecimal = B.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
                    }
                }
                if (bigDecimal.compareTo(BigDecimal.ONE) >= 0 || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal2 = bigDecimal.setScale(i.z(G), 1);
                } else {
                    bigDecimal2 = BigDecimal.ONE;
                }
                if (o(context, G, bigDecimal2, swapCurrencyInfo, bigDecimal3, o11)) {
                    contractOrderPlace.l0(false);
                }
            }
        }
        return contractOrderPlace;
    }

    public void a0(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo, Context context) {
        int t11 = contractOrderPlace.t();
        if (this.f84592f.b(t11)) {
            C().z0(false);
            if (p0.b()) {
                X(contractOrderPlace, swapCurrencyInfo, context, new p(this), new b0(this, context, contractOrderPlace, swapCurrencyInfo));
                return;
            }
            T(context, contractOrderPlace, swapCurrencyInfo, new x(this, contractOrderPlace, swapCurrencyInfo));
        } else if (t11 == 1) {
            C().z0(false);
            if (p0.c()) {
                X(contractOrderPlace, swapCurrencyInfo, context, new t(this), new r(this, context, contractOrderPlace, swapCurrencyInfo));
                return;
            }
            T(context, contractOrderPlace, swapCurrencyInfo, new z(this, contractOrderPlace, swapCurrencyInfo));
        } else if (t11 != 5) {
        } else {
            if (p0.c()) {
                X(contractOrderPlace, swapCurrencyInfo, context, new u(this), new q(this, context, contractOrderPlace, swapCurrencyInfo));
                return;
            }
            T(context, contractOrderPlace, swapCurrencyInfo, new v(this, contractOrderPlace, swapCurrencyInfo));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b0(com.huobi.contract.entity.ContractOrderPlace r18) {
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
            java.lang.String r1 = "confirm_order_close_pop_submit_click"
            gs.g.i(r1, r0)
            r0 = r17
            r1 = r18
            r0.S(r1, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qs.d0.b0(com.huobi.contract.entity.ContractOrderPlace):void");
    }

    public final boolean o(Context context, String str, BigDecimal bigDecimal, SwapCurrencyInfo swapCurrencyInfo, BigDecimal bigDecimal2, String str2) {
        if (bigDecimal.compareTo(BigDecimal.ONE) >= 0 || bigDecimal2.compareTo(BigDecimal.ZERO) == 0) {
            return false;
        }
        BigDecimal divide = m.a(swapCurrencyInfo.getContractFace()).divide(bigDecimal2, 32, 1);
        if (e.H(TradeType.SWAP)) {
            divide = divide.divide(m.a(str2), RoundingMode.UP);
        }
        HuobiToastUtil.l(context, String.format(context.getString(R.string.contract_trade_lowest_amount), new Object[]{m.F(divide.toPlainString(), i.k(str)), str}));
        return true;
    }

    public void p() {
        this.f84590d.clear();
        q();
    }

    public void q() {
        this.f84591e.clear();
    }

    public Observable<SwapTpSlOrderRspInfo> r(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        ContractOrderPlace contractOrderPlace2 = contractOrderPlace;
        if (!"limit".equalsIgnoreCase(contractOrderPlace.J())) {
            contractOrderPlace2.O0("");
        }
        if (!"limit".equalsIgnoreCase(contractOrderPlace.D())) {
            contractOrderPlace2.I0("");
        }
        return l9.a.a().r(swapCurrencyInfo.getContractCode(), contractOrderPlace.l(), contractOrderPlace.W(), contractOrderPlace.K(), contractOrderPlace.H(), contractOrderPlace.J(), contractOrderPlace.L(), contractOrderPlace.E(), contractOrderPlace.B(), contractOrderPlace.D(), contractOrderPlace.F()).b().delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(C())).map(s.f70445b);
    }

    public final void s(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        contractOrderPlace.k0(m.a(contractOrderPlace.h()).divide(m.f68179a, 3, 1).toPlainString());
        l9.a.a().E(swapCurrencyInfo.getContractCode(), contractOrderPlace.l(), contractOrderPlace.r(), contractOrderPlace.o(), contractOrderPlace.W(), contractOrderPlace.h(), contractOrderPlace.w(), contractOrderPlace.y()).b().delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(C())).subscribe(new b(this, (a) null));
    }

    public final void t(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        if (BigDecimal.valueOf(contractOrderPlace.k()).compareTo(BigDecimal.ZERO) == 0) {
            HuobiToastUtil.j(R.string.n_can_not_get_price);
            C().z0(true);
            return;
        }
        u(contractOrderPlace, swapCurrencyInfo).compose(RxJavaHelper.t(C())).subscribe(new b(this, (a) null));
    }

    public Observable<OrderInsertRspInfo> u(ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        if (contractOrderPlace.Q() != 1) {
            contractOrderPlace.B0("");
        }
        return l9.a.a().P(swapCurrencyInfo.getContractCode(), contractOrderPlace.U(), contractOrderPlace.S(), contractOrderPlace.w(), contractOrderPlace.y(), contractOrderPlace.W(), contractOrderPlace.l(), contractOrderPlace.r(), contractOrderPlace.o()).b().delay(300, TimeUnit.MILLISECONDS);
    }

    public ContractOrderPlace v(Context context, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
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
        BigDecimal B = B(swapCurrencyInfo.getContractCode(), X);
        if (e.E(TradeType.SWAP)) {
            BigDecimal bigDecimal4 = BigDecimal.ZERO;
            if (e11 == 0) {
                bigDecimal2 = a11.multiply(a12).divide(m.a(swapCurrencyInfo.getContractFace()), 32, 1);
            } else {
                bigDecimal2 = B.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
            }
            if (bigDecimal2.compareTo(BigDecimal.ONE) >= 0 || bigDecimal2.compareTo(BigDecimal.ZERO) <= 0) {
                bigDecimal3 = bigDecimal2.setScale(i.z(G), 1);
            } else {
                bigDecimal3 = BigDecimal.ONE;
            }
            BigDecimal bigDecimal5 = bigDecimal3;
            if (o(context, G, bigDecimal5, swapCurrencyInfo, a11, contractOrderPlace.o())) {
                contractOrderPlace2.l0(false);
            }
            if (bigDecimal5.compareTo(B) > 0) {
                HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                contractOrderPlace2.l0(false);
            }
            str = bigDecimal5.toPlainString();
            this.f84588b = bigDecimal5;
            if (a11.compareTo(BigDecimal.ZERO) != 0) {
                this.f84587a = bigDecimal5.multiply(m.a(swapCurrencyInfo.getContractFace())).divide(a11, i.y(G), 1);
            }
        } else {
            if (e11 != 0) {
                a12 = B.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
            }
            if (a12.compareTo(BigDecimal.ONE) >= 0 || a12.compareTo(BigDecimal.ZERO) <= 0) {
                bigDecimal = a12.setScale(f.t(G), 1);
            } else {
                bigDecimal = BigDecimal.ONE;
            }
            if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                HuobiToastUtil.j(R.string.contract_trade_available_not_more_than_one);
                contractOrderPlace2.l0(false);
            }
            if (bigDecimal.compareTo(B) > 0) {
                HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                contractOrderPlace2.l0(false);
            }
            String plainString = bigDecimal.toPlainString();
            this.f84588b = bigDecimal;
            if (a11.compareTo(BigDecimal.ZERO) != 0) {
                this.f84587a = bigDecimal.multiply(m.a(swapCurrencyInfo.getContractFace())).divide(a11, i.y(G), 1);
            }
            str = plainString;
        }
        contractOrderPlace2.N0(G);
        contractOrderPlace2.c1(str);
        this.f84592f.a(contractOrderPlace2);
        return contractOrderPlace2;
    }

    public final void w(ContractOrderPlace contractOrderPlace, BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3, SwapCurrencyInfo swapCurrencyInfo, Context context, BigDecimal bigDecimal4) {
        BigDecimal bigDecimal5;
        BigDecimal bigDecimal6;
        BigDecimal bigDecimal7;
        BigDecimal bigDecimal8;
        ContractOrderPlace contractOrderPlace2 = contractOrderPlace;
        BigDecimal bigDecimal9 = bigDecimal2;
        BigDecimal bigDecimal10 = bigDecimal3;
        BigDecimal bigDecimal11 = bigDecimal4;
        String b11 = contractOrderPlace.b();
        int v11 = contractOrderPlace.v();
        int e11 = contractOrderPlace.e();
        String G = contractOrderPlace.G();
        String o11 = contractOrderPlace.o();
        BigDecimal bigDecimal12 = BigDecimal.ZERO;
        if (v11 == 0) {
            if (e11 != 0) {
                if (contractOrderPlace.d() != null) {
                    bigDecimal8 = bigDecimal9.multiply(m.a(o11)).multiply(contractOrderPlace.d()).divide(m.f68179a, 32, 1);
                } else {
                    bigDecimal8 = bigDecimal9.multiply(m.a(o11)).multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
                }
                bigDecimal7 = bigDecimal8;
            } else {
                bigDecimal7 = bigDecimal;
            }
            BigDecimal divide = bigDecimal10.multiply(bigDecimal7).divide(m.a(swapCurrencyInfo.getContractFace()), i.z(G), 1);
            if (o(context, G, divide, swapCurrencyInfo, bigDecimal3, o11)) {
                contractOrderPlace2.l0(false);
            }
            if (contractOrderPlace.t() != 1 && bigDecimal9.multiply(m.a(o11)).compareTo(bigDecimal7) < 0) {
                HuobiToastUtil.j(R.string.n_contract_trade_available_not_enough);
                contractOrderPlace2.l0(false);
            }
            b11 = divide.toPlainString();
            bigDecimal12 = divide;
        } else if (v11 == 1 || v11 == 2) {
            if (e11 == 0) {
                bigDecimal5 = bigDecimal10.multiply(bigDecimal).divide(m.a(swapCurrencyInfo.getContractFace()), 32, 1);
            } else if (contractOrderPlace.d() != null) {
                bigDecimal5 = bigDecimal11.multiply(contractOrderPlace.d()).divide(m.f68179a, 32, 1);
            } else {
                bigDecimal5 = bigDecimal11.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
            }
            if (bigDecimal5.compareTo(BigDecimal.ONE) >= 0 || bigDecimal5.compareTo(BigDecimal.ZERO) <= 0) {
                bigDecimal6 = bigDecimal5.setScale(i.z(G), 1);
            } else {
                bigDecimal6 = BigDecimal.ONE;
            }
            BigDecimal bigDecimal13 = bigDecimal6;
            if (o(context, G, bigDecimal13, swapCurrencyInfo, bigDecimal3, o11)) {
                contractOrderPlace2.l0(false);
            }
            if (contractOrderPlace.t() != 1 && bigDecimal13.compareTo(bigDecimal11) > 0) {
                HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                contractOrderPlace2.l0(false);
            }
            b11 = bigDecimal13.toPlainString();
            bigDecimal12 = bigDecimal13;
        }
        this.f84588b = bigDecimal12;
        if (bigDecimal10.compareTo(BigDecimal.ZERO) != 0) {
            this.f84587a = bigDecimal12.multiply(m.a(swapCurrencyInfo.getContractFace())).divide(bigDecimal10, i.y(G), 1);
        }
        contractOrderPlace2.c1(b11);
        if (m.a(contractOrderPlace.w()).compareTo(BigDecimal.ZERO) == 0) {
            HuobiToastUtil.j(R.string.n_can_not_get_price);
            contractOrderPlace2.l0(false);
        }
    }

    public ContractOrderPlace x(Context context, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        String w11 = contractOrderPlace.w();
        int Q = contractOrderPlace.Q();
        String b11 = contractOrderPlace.b();
        boolean X = contractOrderPlace.X();
        String G = contractOrderPlace.G();
        BigDecimal a11 = m.a(w11);
        BigDecimal a12 = m.a(b11);
        BigDecimal A = A(G);
        BigDecimal B = B(swapCurrencyInfo.getContractCode(), X);
        if (contractOrderPlace.t() == 1 && Q != 1) {
            a11 = m.a(contractOrderPlace.S());
        }
        BigDecimal bigDecimal = a11;
        if (e.E(TradeType.SWAP)) {
            w(contractOrderPlace, a12, A, bigDecimal, swapCurrencyInfo, context, B);
        } else {
            y(contractOrderPlace, a12, A, bigDecimal, swapCurrencyInfo, context, B);
        }
        this.f84592f.a(contractOrderPlace);
        return contractOrderPlace;
    }

    public final void y(ContractOrderPlace contractOrderPlace, BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3, SwapCurrencyInfo swapCurrencyInfo, Context context, BigDecimal bigDecimal4) {
        contractOrderPlace.b();
        int v11 = contractOrderPlace.v();
        int e11 = contractOrderPlace.e();
        String G = contractOrderPlace.G();
        String o11 = contractOrderPlace.o();
        if (v11 == 0) {
            if (bigDecimal3.compareTo(BigDecimal.ZERO) != 0) {
                BigDecimal divide = bigDecimal2.multiply(bigDecimal3).multiply(m.a(o11)).divide(m.a(swapCurrencyInfo.getContractFace()), i.b(G), 1);
                if (e11 != 0) {
                    if (contractOrderPlace.d() != null) {
                        bigDecimal = divide.multiply(contractOrderPlace.d()).divide(m.f68179a, i.b(G), 1);
                    } else {
                        bigDecimal = divide.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, i.b(G), 1);
                    }
                }
                if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    HuobiToastUtil.j(R.string.contract_trade_available_not_more_than_one);
                    contractOrderPlace.l0(false);
                }
                if (contractOrderPlace.t() != 1 && divide.compareTo(bigDecimal) < 0) {
                    HuobiToastUtil.j(R.string.n_contract_trade_available_not_enough);
                    contractOrderPlace.l0(false);
                }
            }
        } else if (v11 == 1 || v11 == 2) {
            if (e11 != 0) {
                if (contractOrderPlace.d() != null) {
                    bigDecimal = bigDecimal4.multiply(contractOrderPlace.d()).divide(m.f68179a, 32, 1);
                } else {
                    bigDecimal = bigDecimal4.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
                }
            }
            if (bigDecimal.compareTo(BigDecimal.ONE) >= 0 || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                bigDecimal = bigDecimal.setScale(i.b(G), 1);
            } else {
                bigDecimal = BigDecimal.ONE;
            }
            if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                HuobiToastUtil.j(R.string.contract_trade_available_not_more_than_one);
                contractOrderPlace.l0(false);
            }
            if (contractOrderPlace.t() != 1 && bigDecimal.compareTo(bigDecimal4) > 0) {
                HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                contractOrderPlace.l0(false);
            }
        }
        String plainString = bigDecimal.toPlainString();
        this.f84588b = bigDecimal;
        if (bigDecimal3.compareTo(BigDecimal.ZERO) != 0) {
            this.f84587a = bigDecimal.multiply(m.a(swapCurrencyInfo.getContractFace())).divide(bigDecimal3, i.y(G), 1);
        }
        contractOrderPlace.c1(plainString);
        if (m.a(contractOrderPlace.w()).compareTo(BigDecimal.ZERO) == 0) {
            HuobiToastUtil.j(R.string.n_can_not_get_price);
            contractOrderPlace.l0(false);
        }
    }

    public BigDecimal z() {
        return this.f84587a;
    }
}
