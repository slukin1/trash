package ym;

import a7.e;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import bh.j;
import bj.p0;
import cn.k2;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.network.linear.swap.core.bean.LinearOrderInsertRspInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOrderInsertRspInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTpSlOrderRspInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.dialog.OrderConfirmBottomSheetDialogFragment;
import com.hbg.lib.widgets.dialog.bean.OrderConfirmBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.entity.OffSiteLimit;
import com.huobi.contract.entity.PriceProtectionItem;
import com.huobi.contract.utils.KycLimitCodeUtils;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.controller.FutureTradeActionController;
import com.huobi.feature.util.FutureOrderErrorHelper;
import com.huobi.utils.n0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dn.i;
import gs.g;
import i6.m;
import i8.s;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.Observable;
import tg.d;
import tg.r;

public class z extends FutureTradeActionController {

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<k2> f76960h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, LinearSwapAccountInfo> f76961i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public Map<String, LinearSwapPosition> f76962j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    public AccountBalanceInfoV5 f76963k;

    /* renamed from: l  reason: collision with root package name */
    public OrderConfirmBottomSheetDialogFragment f76964l;

    public class a extends EasySubscriber<OffSiteLimit> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f76965b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DialogUtils.b.f f76966c;

        public a(Context context, DialogUtils.b.f fVar) {
            this.f76965b = context;
            this.f76966c = fVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            z.this.Z().z0(true);
        }

        /* renamed from: c */
        public void onNext(OffSiteLimit offSiteLimit) {
            super.onNext(offSiteLimit);
            if (offSiteLimit.tipFlag) {
                new DialogUtils.b.d((FragmentActivity) this.f76965b).C0(offSiteLimit.tipMsg).P0(this.f76965b.getString(R.string.n_sure)).s0(this.f76965b.getString(R.string.n_cancel)).Q0(this.f76966c).N0(new y(this)).j0().show(((FragmentActivity) this.f76965b).getSupportFragmentManager(), "");
            } else {
                this.f76966c.a((HBDialogFragment) null);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            this.f76966c.a((HBDialogFragment) null);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            this.f76966c.a((HBDialogFragment) null);
        }
    }

    public z(k2 k2Var) {
        this.f76960h = new WeakReference<>(k2Var);
    }

    public static /* synthetic */ LinearSwapTpSlOrderRspInfo b0(LinearSwapTpSlOrderRspInfo linearSwapTpSlOrderRspInfo) {
        return linearSwapTpSlOrderRspInfo;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void c0(View view) {
        g.i("confirm_order_close_pop_back_click", (HashMap) null);
        Z().z0(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        r0(contractOrderPlace, futureContractInfo);
        y0(contractOrderPlace);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e0(Context context, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, boolean z11, View view) {
        p0.l(z11 ^ true ? 1 : 0);
        q0(context, contractOrderPlace, futureContractInfo, new s(this, contractOrderPlace, futureContractInfo));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f0(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        Q(contractOrderPlace, futureContractInfo);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g0(Context context, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, boolean z11, View view) {
        p0.j(z11 ^ true ? 1 : 0);
        q0(context, contractOrderPlace, futureContractInfo, new w(this, contractOrderPlace, futureContractInfo));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h0(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, HBDialogFragment hBDialogFragment) {
        r0(contractOrderPlace, futureContractInfo);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i0(View view) {
        g.i("confirm_order_close_pop_back_click", (HashMap) null);
        Z().z0(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        R(contractOrderPlace, futureContractInfo);
        y0(contractOrderPlace);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0(Context context, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, boolean z11, View view) {
        p0.l(z11 ^ true ? 1 : 0);
        q0(context, contractOrderPlace, futureContractInfo, new u(this, contractOrderPlace, futureContractInfo));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, HBDialogFragment hBDialogFragment) {
        R(contractOrderPlace, futureContractInfo);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m0(View view) {
        if (Z() != null) {
            Z().z0(true);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        Q(contractOrderPlace, futureContractInfo);
    }

    public final BigDecimal L(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, int i11) {
        return m.a(l()).multiply(m.a(futureContractInfo.getContractFace())).multiply(m.a("0").max(m.a(String.valueOf(i11)).multiply(m.a(contractOrderPlace.w()).subtract(m.a(X(futureContractInfo))))));
    }

    public boolean M(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.compareTo(BigDecimal.ONE) < 0 && bigDecimal2.compareTo(BigDecimal.ZERO) != 0;
    }

    public void N() {
        this.f76961i.clear();
        O();
    }

    public void O() {
        this.f76962j.clear();
    }

    public Observable<LinearSwapTpSlOrderRspInfo> P(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        d9.a<LinearSwapTpSlOrderRspInfo> aVar;
        ContractOrderPlace contractOrderPlace2 = contractOrderPlace;
        if (!"limit".equalsIgnoreCase(contractOrderPlace.J())) {
            contractOrderPlace2.O0("");
        }
        if (!"limit".equalsIgnoreCase(contractOrderPlace.D())) {
            contractOrderPlace2.I0("");
        }
        if (contractOrderPlace.q() == 1) {
            aVar = h8.a.a().s0(futureContractInfo.getContractCode(), contractOrderPlace.l(), contractOrderPlace.W(), contractOrderPlace.K(), contractOrderPlace.H(), contractOrderPlace.J(), contractOrderPlace.L(), contractOrderPlace.E(), contractOrderPlace.B(), contractOrderPlace.D(), contractOrderPlace.F());
        } else {
            aVar = h8.a.a().r(futureContractInfo.getContractCode(), contractOrderPlace.l(), contractOrderPlace.W(), contractOrderPlace.K(), contractOrderPlace.H(), contractOrderPlace.J(), contractOrderPlace.L(), contractOrderPlace.E(), contractOrderPlace.B(), contractOrderPlace.D(), contractOrderPlace.F());
        }
        return aVar.b().delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(Z())).map(o.f61869b);
    }

    public final void Q(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        contractOrderPlace.k0(m.a(contractOrderPlace.h()).divide(m.f68179a, 3, 1).toPlainString());
        if (contractOrderPlace.q() == 2) {
            h8.a.a().c0(futureContractInfo.getContractCode(), contractOrderPlace.l(), contractOrderPlace.r(), contractOrderPlace.o(), contractOrderPlace.W(), contractOrderPlace.h(), contractOrderPlace.w(), contractOrderPlace.y(), contractOrderPlace.c0(), contractOrderPlace.b0()).b().delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(Z())).subscribe(new b());
        } else {
            h8.a.a().d0(futureContractInfo.getContractType(), futureContractInfo.getContractCode(), futureContractInfo.getPair(), contractOrderPlace.l(), contractOrderPlace.r(), contractOrderPlace.o(), contractOrderPlace.W(), contractOrderPlace.h(), contractOrderPlace.w(), contractOrderPlace.y(), contractOrderPlace.c0(), contractOrderPlace.b0()).b().delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(Z())).subscribe(new b());
        }
    }

    public final void R(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        if (BigDecimal.valueOf(contractOrderPlace.k()).compareTo(BigDecimal.ZERO) == 0) {
            HuobiToastUtil.j(R.string.n_can_not_get_price);
            Z().z0(true);
            return;
        }
        S(contractOrderPlace, futureContractInfo).compose(RxJavaHelper.t(Z())).subscribe(new b());
    }

    public Observable<LinearSwapOrderInsertRspInfo> S(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        if (contractOrderPlace.Q() != 1) {
            contractOrderPlace.B0("");
        } else {
            ContractOrderPlace contractOrderPlace2 = contractOrderPlace;
        }
        if (contractOrderPlace.q() == 2) {
            return h8.a.a().B(futureContractInfo.getContractCode(), contractOrderPlace.U(), contractOrderPlace.S(), contractOrderPlace.w(), contractOrderPlace.y(), contractOrderPlace.W(), contractOrderPlace.l(), contractOrderPlace.r(), contractOrderPlace.o(), contractOrderPlace.c0(), contractOrderPlace.b0()).b().delay(300, TimeUnit.MILLISECONDS);
        }
        return h8.a.a().o0(futureContractInfo.getContractCode(), contractOrderPlace.U(), contractOrderPlace.S(), contractOrderPlace.w(), contractOrderPlace.y(), contractOrderPlace.W(), contractOrderPlace.l(), contractOrderPlace.r(), contractOrderPlace.o(), contractOrderPlace.c0(), contractOrderPlace.b0()).b().delay(300, TimeUnit.MILLISECONDS);
    }

    public void T(ContractOrderPlace contractOrderPlace, BigDecimal bigDecimal, BigDecimal bigDecimal2, FutureContractInfo futureContractInfo, Context context) {
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        BigDecimal bigDecimal5;
        String b11 = contractOrderPlace.b();
        int v11 = contractOrderPlace.v();
        int e11 = contractOrderPlace.e();
        String G = contractOrderPlace.G();
        contractOrderPlace.o();
        BigDecimal Y = Y(futureContractInfo.getContractCode() + "_" + i.b(contractOrderPlace.q()), contractOrderPlace.X());
        BigDecimal bigDecimal6 = BigDecimal.ZERO;
        if (v11 == 0) {
            if (contractOrderPlace.X()) {
                bigDecimal5 = g();
            } else {
                bigDecimal5 = k();
            }
            if (bigDecimal5 == null) {
                bigDecimal5 = BigDecimal.ZERO;
            }
            if (e11 != 0) {
                if (contractOrderPlace.d() != null) {
                    bigDecimal = bigDecimal5.multiply(contractOrderPlace.d()).divide(m.f68179a, 32, 1);
                } else {
                    bigDecimal = bigDecimal5.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
                }
            }
            bigDecimal6 = m.a(FutureUnitUtil.e(bigDecimal.toPlainString(), contractOrderPlace.w(), futureContractInfo.getContractFace(), TradeType.LINEAR_SWAP, FuturePrecisionUtil.g(G))).setScale(FuturePrecisionUtil.B(), 1);
            if (M(bigDecimal6, bigDecimal2)) {
                contractOrderPlace.l0(false);
                x0(contractOrderPlace, futureContractInfo, context, G);
            }
            if (contractOrderPlace.t() != 1 && bigDecimal5.compareTo(bigDecimal) < 0) {
                HuobiToastUtil.j(R.string.n_contract_trade_available_not_enough);
                contractOrderPlace.l0(false);
            }
            b11 = bigDecimal6.toPlainString();
        } else if (v11 == 1 || v11 == 2) {
            if (e11 == 0) {
                bigDecimal3 = m.a(FutureUnitUtil.e(bigDecimal.toPlainString(), contractOrderPlace.w(), futureContractInfo.getContractFace(), TradeType.LINEAR_SWAP, FuturePrecisionUtil.g(G)));
            } else if (contractOrderPlace.d() != null) {
                bigDecimal3 = Y.multiply(contractOrderPlace.d()).divide(m.f68179a, 32, 1);
            } else {
                bigDecimal3 = Y.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
            }
            if (bigDecimal3.compareTo(BigDecimal.ONE) >= 0 || bigDecimal3.compareTo(BigDecimal.ZERO) <= 0) {
                bigDecimal4 = bigDecimal3.setScale(FuturePrecisionUtil.B(), 1);
            } else {
                bigDecimal4 = BigDecimal.ONE;
            }
            bigDecimal6 = bigDecimal4;
            if (M(bigDecimal6, bigDecimal2)) {
                contractOrderPlace.l0(false);
                if (contractOrderPlace.Q() != 6) {
                    x0(contractOrderPlace, futureContractInfo, context, G);
                }
            }
            if (contractOrderPlace.t() != 1 && bigDecimal6.compareTo(Y) > 0) {
                HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                contractOrderPlace.l0(false);
            }
            b11 = bigDecimal6.toPlainString();
        }
        p(bigDecimal6);
        if (bigDecimal2.compareTo(BigDecimal.ZERO) != 0) {
            int B = FuturePrecisionUtil.B();
            TradeType tradeType = TradeType.LINEAR_SWAP;
            if (e.G(tradeType)) {
                B = FuturePrecisionUtil.g(G);
            } else if (e.E(tradeType)) {
                B = FuturePrecisionUtil.s(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), (String) null);
            }
            o(m.a(FutureUnitUtil.b(bigDecimal6.toPlainString(), contractOrderPlace.w(), futureContractInfo.getContractFace(), tradeType, B)));
        }
        contractOrderPlace.c1(b11);
        if (m.a(contractOrderPlace.w()).compareTo(BigDecimal.ZERO) == 0) {
            HuobiToastUtil.j(R.string.n_can_not_get_price);
            contractOrderPlace.l0(false);
        }
    }

    public void U(ContractOrderPlace contractOrderPlace, BigDecimal bigDecimal, BigDecimal bigDecimal2, FutureContractInfo futureContractInfo, Context context) {
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        contractOrderPlace.b();
        int v11 = contractOrderPlace.v();
        int e11 = contractOrderPlace.e();
        contractOrderPlace.G();
        if (v11 == 0) {
            if (bigDecimal2.compareTo(BigDecimal.ZERO) != 0) {
                if (contractOrderPlace.X()) {
                    bigDecimal4 = i();
                } else {
                    bigDecimal4 = j();
                }
                if (bigDecimal4 == null) {
                    bigDecimal4 = BigDecimal.ZERO;
                }
                if (e11 != 0) {
                    if (contractOrderPlace.d() != null) {
                        bigDecimal = bigDecimal4.multiply(contractOrderPlace.d()).divide(m.f68179a, FuturePrecisionUtil.B(), 1);
                    } else {
                        bigDecimal = bigDecimal4.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, FuturePrecisionUtil.B(), 1);
                    }
                }
                if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    HuobiToastUtil.j(R.string.contract_trade_available_not_more_than_one);
                    contractOrderPlace.l0(false);
                }
                if (contractOrderPlace.t() != 1 && bigDecimal4.compareTo(bigDecimal) < 0) {
                    HuobiToastUtil.j(R.string.n_contract_trade_available_not_enough);
                    contractOrderPlace.l0(false);
                }
            }
        } else if (v11 == 1 || v11 == 2) {
            if (contractOrderPlace.X()) {
                bigDecimal3 = i();
            } else {
                bigDecimal3 = j();
            }
            if (bigDecimal3 == null) {
                bigDecimal3 = BigDecimal.ZERO;
            }
            if (e11 != 0) {
                if (contractOrderPlace.d() != null) {
                    bigDecimal = bigDecimal3.multiply(contractOrderPlace.d()).divide(m.f68179a, 32, 1);
                } else {
                    bigDecimal = bigDecimal3.multiply(m.a(String.valueOf(contractOrderPlace.z()))).divide(m.f68179a, 32, 1);
                }
            }
            if (bigDecimal.compareTo(BigDecimal.ONE) >= 0 || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                bigDecimal = bigDecimal.setScale(FuturePrecisionUtil.B(), 1);
            } else {
                bigDecimal = BigDecimal.ONE;
            }
            if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                HuobiToastUtil.j(R.string.contract_trade_available_not_more_than_one);
                contractOrderPlace.l0(false);
            }
            if (contractOrderPlace.t() != 1 && bigDecimal.compareTo(bigDecimal3) > 0) {
                HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                contractOrderPlace.l0(false);
            }
        }
        String plainString = bigDecimal.toPlainString();
        p(bigDecimal);
        if (bigDecimal2.compareTo(BigDecimal.ZERO) != 0) {
            o(m.a(FutureUnitUtil.d(bigDecimal.toPlainString(), contractOrderPlace.w(), futureContractInfo.getContractFace(), TradeType.LINEAR_SWAP)).setScale(FuturePrecisionUtil.s(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), futureContractInfo.getOptionCode()), 1));
        }
        contractOrderPlace.c1(plainString);
        if (m.a(contractOrderPlace.w()).compareTo(BigDecimal.ZERO) == 0) {
            HuobiToastUtil.j(R.string.n_can_not_get_price);
            contractOrderPlace.l0(false);
        }
    }

    public String V(String str, String str2, double d11, FutureContractInfo futureContractInfo) {
        return (TextUtils.isEmpty(str) || InstructionFileId.DOT.equals(str)) ? "" : LegalCurrencyConfigUtil.R(str2, new BigDecimal(d11), str, FuturePrecisionUtil.t(str2, futureContractInfo.contractCode, futureContractInfo.contractShortType, futureContractInfo.optionCode));
    }

    public BigDecimal W(String str) {
        LinearSwapAccountInfo linearSwapAccountInfo = this.f76961i.get(str);
        if (linearSwapAccountInfo == null) {
            return BigDecimal.ZERO;
        }
        return m.a(linearSwapAccountInfo.getMarginAvailable());
    }

    public String X(FutureContractInfo futureContractInfo) {
        return i8.m.b().c(futureContractInfo.getContractCode());
    }

    public BigDecimal Y(String str, boolean z11) {
        LinearSwapPosition linearSwapPosition;
        if (z11) {
            Map<String, LinearSwapPosition> map = this.f76962j;
            linearSwapPosition = map.get(str + "sell");
        } else {
            Map<String, LinearSwapPosition> map2 = this.f76962j;
            linearSwapPosition = map2.get(str + "buy");
        }
        if (linearSwapPosition == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(linearSwapPosition.getAvailable());
    }

    public final k2 Z() {
        return (k2) this.f76960h.get();
    }

    public void a(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        String str;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        TradeType tradeType = TradeType.LINEAR_SWAP;
        if (e.G(tradeType)) {
            str = contractOrderPlace.n() + "";
        } else {
            str = contractOrderPlace.w();
        }
        BigDecimal a11 = m.a(str);
        BigDecimal Y = Y(futureContractInfo.getContractCode() + "_" + i.b(contractOrderPlace.q()), true);
        BigDecimal Y2 = Y(futureContractInfo.getContractCode() + "_" + i.b(contractOrderPlace.q()), false);
        if (!e.G(tradeType) || a11.compareTo(BigDecimal.ZERO) == 0) {
            bigDecimal2 = Y.multiply(m.a(futureContractInfo.getContractFace())).setScale(FuturePrecisionUtil.s(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), (String) null), 1);
            bigDecimal = Y2.multiply(m.a(futureContractInfo.getContractFace())).setScale(FuturePrecisionUtil.s(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), (String) null), 1);
        } else {
            bigDecimal2 = Y.multiply(m.a(futureContractInfo.getContractFace())).multiply(a11).setScale(FuturePrecisionUtil.g(contractOrderPlace.G()), 1);
            bigDecimal = Y2.multiply(m.a(futureContractInfo.getContractFace())).multiply(a11).setScale(FuturePrecisionUtil.g(contractOrderPlace.G()), 1);
        }
        n(bigDecimal2);
        u(bigDecimal);
    }

    public void a0() {
        OrderConfirmBottomSheetDialogFragment orderConfirmBottomSheetDialogFragment = this.f76964l;
        if (orderConfirmBottomSheetDialogFragment != null && orderConfirmBottomSheetDialogFragment.isAdded()) {
            this.f76964l.dismiss();
        }
        Z().z0(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.huobi.contract.entity.ContractOrderPlace r11, com.hbg.lib.data.future.bean.FutureContractInfo r12) {
        /*
            r10 = this;
            java.lang.String r0 = r11.w()
            java.lang.String r1 = r11.G()
            java.lang.String r2 = r12.getContractCode()
            java.lang.String r3 = r12.getContractShortType()
            r4 = 0
            int r2 = com.hbg.lib.data.future.util.FuturePrecisionUtil.s(r2, r3, r4)
            boolean r3 = r11.a0()
            r5 = 1
            if (r3 == 0) goto L_0x0033
            java.lang.String r12 = r11.p()
            java.math.BigDecimal r12 = i6.m.a(r12)
            java.lang.String r3 = r11.o()
            java.math.BigDecimal r3 = i6.m.a(r3)
            java.math.BigDecimal r12 = r12.multiply(r3)
        L_0x0030:
            r3 = r4
            goto L_0x00ba
        L_0x0033:
            com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5 r3 = r10.f76963k
            if (r3 == 0) goto L_0x00a8
            java.math.BigDecimal r3 = i6.m.a(r0)
            java.lang.String r6 = "0"
            java.math.BigDecimal r7 = i6.m.a(r6)
            com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5 r8 = r10.f76963k
            java.lang.String r8 = r8.getAvailableMargin()
            java.math.BigDecimal r8 = i6.m.a(r8)
            java.lang.String r9 = r11.o()
            java.math.BigDecimal r9 = i6.m.a(r9)
            java.math.BigDecimal r8 = r8.multiply(r9)
            java.math.BigDecimal r9 = r10.L(r11, r12, r5)
            java.math.BigDecimal r8 = r8.subtract(r9)
            java.math.BigDecimal r7 = r7.max(r8)
            java.math.BigDecimal r6 = i6.m.a(r6)
            com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5 r8 = r10.f76963k
            java.lang.String r8 = r8.getAvailableMargin()
            java.math.BigDecimal r8 = i6.m.a(r8)
            java.lang.String r9 = r11.o()
            java.math.BigDecimal r9 = i6.m.a(r9)
            java.math.BigDecimal r8 = r8.multiply(r9)
            r9 = -1
            java.math.BigDecimal r12 = r10.L(r11, r12, r9)
            java.math.BigDecimal r12 = r8.subtract(r12)
            java.math.BigDecimal r12 = r6.max(r12)
            java.math.BigDecimal r6 = java.math.BigDecimal.ZERO
            int r6 = r3.compareTo(r6)
            if (r6 == 0) goto L_0x00a5
            java.math.BigDecimal r6 = r7.divide(r3, r2, r5)
            java.math.BigDecimal r6 = r6.multiply(r3)
            java.math.BigDecimal r12 = r12.divide(r3, r2, r5)
            java.math.BigDecimal r12 = r12.multiply(r3)
            r3 = r12
            r12 = r6
            goto L_0x00ba
        L_0x00a5:
            r3 = r12
            r12 = r7
            goto L_0x00ba
        L_0x00a8:
            java.math.BigDecimal r12 = r10.W(r1)
            java.lang.String r3 = r11.o()
            java.math.BigDecimal r3 = i6.m.a(r3)
            java.math.BigDecimal r12 = r12.multiply(r3)
            goto L_0x0030
        L_0x00ba:
            com.hbg.lib.data.symbol.TradeType r6 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP
            boolean r7 = a7.e.G(r6)
            if (r7 == 0) goto L_0x00d7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            double r7 = r11.n()
            r0.append(r7)
            java.lang.String r11 = ""
            r0.append(r11)
            java.lang.String r0 = r0.toString()
        L_0x00d7:
            java.math.BigDecimal r11 = i6.m.a(r0)
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
            int r0 = r11.compareTo(r0)
            if (r0 == 0) goto L_0x0109
            boolean r0 = a7.e.G(r6)
            if (r0 == 0) goto L_0x00fd
            int r11 = com.hbg.lib.data.future.util.FuturePrecisionUtil.g(r1)
            java.math.BigDecimal r4 = r12.setScale(r11, r5)
            if (r3 != 0) goto L_0x00f4
            goto L_0x0109
        L_0x00f4:
            int r11 = com.hbg.lib.data.future.util.FuturePrecisionUtil.g(r1)
            java.math.BigDecimal r11 = r3.setScale(r11, r5)
            goto L_0x010a
        L_0x00fd:
            java.math.BigDecimal r4 = r12.divide(r11, r2, r5)
            if (r3 != 0) goto L_0x0104
            goto L_0x0109
        L_0x0104:
            java.math.BigDecimal r11 = r3.divide(r11, r2, r5)
            goto L_0x010a
        L_0x0109:
            r11 = r4
        L_0x010a:
            r10.n(r4)
            r10.u(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ym.z.b(com.huobi.contract.entity.ContractOrderPlace, com.hbg.lib.data.future.bean.FutureContractInfo):void");
    }

    public void c(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        BigDecimal scale = Y(futureContractInfo.getContractCode() + "_" + i.b(contractOrderPlace.q()), true).setScale(FuturePrecisionUtil.B(), 1);
        BigDecimal scale2 = Y(futureContractInfo.getContractCode() + "_" + i.b(contractOrderPlace.q()), false).setScale(FuturePrecisionUtil.B(), 1);
        q(scale);
        r(scale2);
    }

    public void d(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        BigDecimal bigDecimal;
        String w11 = contractOrderPlace.w();
        String G = contractOrderPlace.G();
        if (contractOrderPlace.a0()) {
            bigDecimal = m.a(contractOrderPlace.p());
        } else {
            AccountBalanceInfoV5 accountBalanceInfoV5 = this.f76963k;
            if (accountBalanceInfoV5 != null) {
                bigDecimal = m.a(accountBalanceInfoV5.getAvailableMargin());
            } else {
                bigDecimal = W(G);
            }
        }
        BigDecimal a11 = m.a(w11);
        BigDecimal bigDecimal2 = null;
        if (a11.compareTo(BigDecimal.ZERO) != 0) {
            bigDecimal2 = bigDecimal.multiply(m.a(contractOrderPlace.o())).divide(m.a(futureContractInfo.getContractFace()).multiply(a11), FuturePrecisionUtil.B(), 1);
        }
        q(bigDecimal2);
        r(bigDecimal2);
    }

    public ContractOrderPlace e(Context context, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        String str;
        boolean z11;
        contractOrderPlace.q0(X(futureContractInfo));
        ContractOrderPlace s11 = s(contractOrderPlace);
        boolean X = s11.X();
        if (s11.n() != 0.0d) {
            s11.o0(s11.n());
        } else if (X) {
            if (s11.A() != 0.0d) {
                s11.o0(s11.A());
            }
        } else if (s11.f() != 0.0d) {
            s11.o0(s11.f());
        }
        String w11 = s11.w();
        String b11 = s11.b();
        BigDecimal a11 = m.a(w11);
        BigDecimal a12 = m.a(b11);
        TradeType tradeType = TradeType.LINEAR_SWAP;
        if (e.E(tradeType) || e.G(tradeType)) {
            T(s11, a12, a11, futureContractInfo, context);
        } else {
            U(s11, a12, a11, futureContractInfo, context);
        }
        f(s11);
        if (r.x().F0()) {
            boolean z12 = false;
            boolean z13 = s11.q() == 1;
            if (z13) {
                str = "USDT";
            } else {
                str = futureContractInfo.getContractCode();
            }
            if (SPUtil.j()) {
                z11 = pk.e.a().c();
            } else {
                z11 = pk.e.a().b(z13, str);
            }
            s11.H0(z11);
            if (("close".equals(s11.r()) && z11) || (z11 && gl.a.a(tradeType))) {
                z12 = true;
            }
            s11.F0(z12);
        }
        return s11;
    }

    public Observable<LinearOrderInsertRspInfo> o0(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        if (contractOrderPlace.z() == 100) {
            contractOrderPlace.m0(1);
        } else {
            contractOrderPlace.m0(0);
        }
        if (contractOrderPlace.q() == 2) {
            return h8.a.a().Z(futureContractInfo.getContractCode(), contractOrderPlace.W(), contractOrderPlace.l(), contractOrderPlace.y(), contractOrderPlace.i(), contractOrderPlace.V(), false, contractOrderPlace.u()).b().delay(300, TimeUnit.MILLISECONDS);
        }
        return h8.a.a().R(futureContractInfo.getContractCode(), contractOrderPlace.W(), contractOrderPlace.l(), contractOrderPlace.y(), contractOrderPlace.i(), contractOrderPlace.V(), true, contractOrderPlace.u()).b().delay(300, TimeUnit.MILLISECONDS);
    }

    public final void p0(ContractOrderPlace contractOrderPlace, boolean z11) {
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
        hashMap.put("margin_type", g.d());
        if (z11) {
            g.a(str, "usdt_contract", hashMap);
        } else {
            g.j(str, "usdt_contract", "confirm", hashMap);
        }
    }

    public final void q0(Context context, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, DialogUtils.b.f fVar) {
        if (s.d().g()) {
            h8.a.a().l0(futureContractInfo.contractCode, futureContractInfo.contractType, contractOrderPlace.w(), contractOrderPlace.W(), contractOrderPlace.y(), contractOrderPlace.q(), contractOrderPlace.l(), contractOrderPlace.r()).b().compose(RxJavaHelper.t(Z())).subscribe(new a(context, fVar));
        } else {
            fVar.a((HBDialogFragment) null);
        }
    }

    public final void r0(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        if (6 == contractOrderPlace.Q()) {
            o0(contractOrderPlace, futureContractInfo).compose(RxJavaHelper.t(Z())).subscribe(new b(contractOrderPlace));
        } else {
            w0(contractOrderPlace, futureContractInfo).compose(RxJavaHelper.t(Z())).subscribe(new b(contractOrderPlace));
        }
    }

    public void s0(String str, LinearSwapAccountInfo linearSwapAccountInfo) {
        this.f76961i.put(str, linearSwapAccountInfo);
    }

    public void t0(AccountBalanceInfoV5 accountBalanceInfoV5) {
        this.f76963k = accountBalanceInfoV5;
    }

    public void u0(String str, LinearSwapPosition linearSwapPosition) {
        this.f76962j.put(str, linearSwapPosition);
    }

    public ContractOrderPlace v(Context context, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        contractOrderPlace.q0(X(futureContractInfo));
        ContractOrderPlace s11 = s(contractOrderPlace);
        boolean X = s11.X();
        if (s11.n() != 0.0d) {
            s11.o0(s11.n());
        } else if (X) {
            if (s11.A() != 0.0d) {
                s11.o0(s11.A());
            }
        } else if (s11.f() != 0.0d) {
            s11.o0(s11.f());
        }
        String w11 = s11.w();
        String b11 = s11.b();
        BigDecimal a11 = m.a(w11);
        BigDecimal a12 = m.a(b11);
        TradeType tradeType = TradeType.LINEAR_SWAP;
        if (e.E(tradeType) || e.G(tradeType)) {
            int v11 = s11.v();
            int e11 = s11.e();
            String G = s11.G();
            if (v11 == 0) {
                if (s11.X()) {
                    bigDecimal3 = g();
                } else {
                    bigDecimal3 = k();
                }
                if (bigDecimal3 == null) {
                    bigDecimal3 = BigDecimal.ZERO;
                }
                if (e11 != 0) {
                    if (s11.d() != null) {
                        a12 = bigDecimal3.multiply(s11.d()).divide(m.f68179a, 32, 1);
                    } else {
                        a12 = bigDecimal3.multiply(m.a(String.valueOf(s11.z()))).divide(m.f68179a, 32, 1);
                    }
                }
                if (M(m.a(FutureUnitUtil.e(a12.toPlainString(), s11.w(), futureContractInfo.getContractFace(), tradeType, FuturePrecisionUtil.g(G))).setScale(FuturePrecisionUtil.B(), 1), a11)) {
                    s11.l0(false);
                    x0(s11, futureContractInfo, context, G);
                }
            } else if (v11 == 1 || v11 == 2) {
                BigDecimal Y = Y(futureContractInfo.getContractCode() + "_" + i.b(s11.q()), s11.X());
                if (e11 == 0) {
                    bigDecimal = m.a(FutureUnitUtil.e(a12.toPlainString(), s11.w(), futureContractInfo.getContractFace(), tradeType, FuturePrecisionUtil.g(G)));
                } else if (s11.d() != null) {
                    bigDecimal = Y.multiply(s11.d()).divide(m.f68179a, 32, 1);
                } else {
                    bigDecimal = Y.multiply(m.a(String.valueOf(s11.z()))).divide(m.f68179a, 32, 1);
                }
                if (bigDecimal.compareTo(BigDecimal.ONE) >= 0 || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal2 = bigDecimal.setScale(FuturePrecisionUtil.B(), 1);
                } else {
                    bigDecimal2 = BigDecimal.ONE;
                }
                if (M(bigDecimal2, a11)) {
                    s11.l0(false);
                    x0(s11, futureContractInfo, context, G);
                }
            }
        }
        return s11;
    }

    public void v0(ContractOrderPlace contractOrderPlace, Context context, FutureContractInfo futureContractInfo, View.OnClickListener onClickListener, OrderConfirmBottomSheetDialogFragment.a aVar) {
        String str;
        boolean z11;
        String str2;
        String str3;
        String str4;
        Context context2 = context;
        BigDecimal a11 = m.a(contractOrderPlace.S());
        BigDecimal valueOf = BigDecimal.valueOf(contractOrderPlace.k());
        BigDecimal a12 = m.a(contractOrderPlace.w());
        boolean X = contractOrderPlace.X();
        if (contractOrderPlace.Q() == 1) {
            str = String.format(context2.getString(R.string.two_label_with_space), new Object[]{a12.toPlainString(), futureContractInfo.getQuoteCurrency()});
        } else {
            str = contractOrderPlace.s().toString();
        }
        String str5 = str;
        ArrayList arrayList = new ArrayList();
        OrderConfirmBean.ListItem listItem = new OrderConfirmBean.ListItem();
        listItem.setKey(context2.getString(R.string.contract_order_dialog_exchange_title));
        listItem.setValue(contractOrderPlace.P());
        listItem.setUseNewStyle(true);
        arrayList.add(listItem);
        OrderConfirmBean.ListItem listItem2 = new OrderConfirmBean.ListItem();
        listItem2.setKey(context2.getString(R.string.contract_order_dialog_kind_title));
        listItem2.setUseNewStyle(true);
        OrderConfirmBean.ListItem listItem3 = listItem2;
        ArrayList arrayList2 = arrayList;
        listItem3.setValue(e.m(context, contractOrderPlace.G(), futureContractInfo.getQuoteCurrency(), futureContractInfo.getContractCode(), futureContractInfo.getContractType(), contractOrderPlace.q()));
        arrayList2.add(listItem3);
        if (contractOrderPlace.t() == 1) {
            if (a11.compareTo(valueOf) >= 0) {
                str4 = String.format(context2.getString(R.string.n_option_price_greater), new Object[]{a11.toPlainString(), futureContractInfo.getQuoteCurrency()});
            } else {
                str4 = String.format(context2.getString(R.string.n_option_price_less), new Object[]{a11.toPlainString(), futureContractInfo.getQuoteCurrency()});
            }
            OrderConfirmBean.ListItem listItem4 = new OrderConfirmBean.ListItem();
            listItem4.setKey(context2.getString(R.string.n_exchange_order_list_trigger_condition));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str4);
            if (!TextUtils.isEmpty(contractOrderPlace.T())) {
                spannableStringBuilder.append(n0.b(context2, -1, contractOrderPlace.T(), "(", ")"));
            }
            listItem4.setValue(spannableStringBuilder);
            listItem4.setUseNewStyle(true);
            arrayList2.add(listItem4);
        }
        if (contractOrderPlace.t() == 5) {
            OrderConfirmBean.ListItem listItem5 = new OrderConfirmBean.ListItem();
            listItem5.setKey(context2.getString(R.string.n_contract_active_price_condition));
            if (contractOrderPlace.X()) {
                z11 = false;
                listItem5.setValue(String.format(context2.getString(R.string.n_option_price_less), new Object[]{a12.toPlainString(), futureContractInfo.getQuoteCurrency()}));
            } else {
                z11 = false;
                listItem5.setValue(String.format(context2.getString(R.string.n_option_price_greater), new Object[]{a12.toPlainString(), futureContractInfo.getQuoteCurrency()}));
            }
            listItem5.setUseNewStyle(true);
            arrayList2.add(listItem5);
            OrderConfirmBean.ListItem listItem6 = new OrderConfirmBean.ListItem();
            listItem6.setKey(context2.getString(R.string.n_contract_call_back_rate));
            listItem6.setValue(contractOrderPlace.h() + "%");
            listItem6.setUseNewStyle(true);
            arrayList2.add(listItem6);
        } else {
            z11 = false;
        }
        OrderConfirmBean.ListItem listItem7 = new OrderConfirmBean.ListItem();
        listItem7.setKey(context2.getString(R.string.contract_order_dialog_order_price_title));
        listItem7.setUseNewStyle(true);
        if (contractOrderPlace.t() == 5) {
            listItem7.setValue(contractOrderPlace.N().toString());
        } else if (contractOrderPlace.t() == 6) {
            listItem7.setValue(context.getResources().getString(R.string.n_exchange_order_list_market));
        } else {
            listItem7.setValue(str5);
        }
        arrayList2.add(listItem7);
        OrderConfirmBean.ListItem listItem8 = new OrderConfirmBean.ListItem();
        listItem8.setKey(context2.getString(R.string.contract_order_dialog_amout_title));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(h());
        TradeType tradeType = TradeType.LINEAR_SWAP;
        sb2.append(e.G(tradeType) ? "usdt".toUpperCase(Locale.US) : contractOrderPlace.G());
        listItem8.setValue(sb2.toString());
        listItem8.setUseNewStyle(true);
        arrayList2.add(listItem8);
        boolean z12 = (!TextUtils.isEmpty(contractOrderPlace.K()) || !TextUtils.isEmpty(contractOrderPlace.E())) ? true : z11;
        if (z12) {
            arrayList2.add(new OrderConfirmBean.DividerItem());
        }
        if (!TextUtils.isEmpty(contractOrderPlace.K())) {
            OrderConfirmBean.ListItem listItem9 = new OrderConfirmBean.ListItem();
            listItem9.setKey(context2.getString(R.string.n_contract_confirm_dialog_take_profit_trigger_price));
            if (X) {
                str3 = "≥ " + contractOrderPlace.K() + " " + futureContractInfo.getQuoteCurrency();
            } else {
                str3 = "≤ " + contractOrderPlace.K() + " " + futureContractInfo.getQuoteCurrency();
            }
            listItem9.setValue(str3);
            arrayList2.add(listItem9);
            OrderConfirmBean.ListItem listItem10 = new OrderConfirmBean.ListItem();
            listItem10.setKey(context2.getString(R.string.contract_order_dialog_order_price_title));
            if ("limit".equals(contractOrderPlace.J()) || TextUtils.isEmpty(contractOrderPlace.J())) {
                listItem10.setValue(contractOrderPlace.H() + " " + futureContractInfo.getQuoteCurrency());
            } else {
                listItem10.setValue(contractOrderPlace.I());
            }
            arrayList2.add(listItem10);
        }
        if (!TextUtils.isEmpty(contractOrderPlace.E())) {
            OrderConfirmBean.ListItem listItem11 = new OrderConfirmBean.ListItem();
            listItem11.setKey(context2.getString(R.string.n_contract_confirm_dialog_stop_loss_trigger_price));
            if (X) {
                str2 = "≤ " + contractOrderPlace.E() + " " + futureContractInfo.getQuoteCurrency();
            } else {
                str2 = "≥ " + contractOrderPlace.E() + " " + futureContractInfo.getQuoteCurrency();
            }
            listItem11.setValue(str2);
            arrayList2.add(listItem11);
            OrderConfirmBean.ListItem listItem12 = new OrderConfirmBean.ListItem();
            listItem12.setKey(context2.getString(R.string.contract_order_dialog_order_price_title));
            if ("limit".equals(contractOrderPlace.D()) || TextUtils.isEmpty(contractOrderPlace.D())) {
                listItem12.setValue(contractOrderPlace.B() + " " + futureContractInfo.getQuoteCurrency());
            } else {
                listItem12.setValue(contractOrderPlace.C());
            }
            arrayList2.add(listItem12);
        }
        if (z12) {
            arrayList2.add(new OrderConfirmBean.DividerItem());
            PriceProtectionItem priceProtectionItem = new PriceProtectionItem();
            priceProtectionItem.setSymbol(futureContractInfo.getSymbol());
            priceProtectionItem.setContractCode(futureContractInfo.getContractCode());
            priceProtectionItem.setContractShortType(futureContractInfo.getContractShortType());
            priceProtectionItem.setTradeType(tradeType);
            arrayList2.add(priceProtectionItem);
        }
        OrderConfirmBean orderConfirmBean = new OrderConfirmBean();
        orderConfirmBean.setList(arrayList2);
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
        this.f76964l = vh2;
        vh2.show(((FragmentActivity) context2).getSupportFragmentManager(), "OrderConfirmBottomSheetDialogFragment");
        g.i("confirm_order_close_pop_expose", (HashMap) null);
        p0(contractOrderPlace, true);
    }

    public void w(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, Context context) {
        int t11 = contractOrderPlace.t();
        if (m(t11)) {
            Z().z0(false);
            if (p0.b()) {
                v0(contractOrderPlace, context, futureContractInfo, new p(this), new m(this, context, contractOrderPlace, futureContractInfo));
                return;
            }
            q0(context, contractOrderPlace, futureContractInfo, new t(this, contractOrderPlace, futureContractInfo));
        } else if (t11 == 1) {
            Z().z0(false);
            if (p0.c()) {
                v0(contractOrderPlace, context, futureContractInfo, new l(this), new x(this, context, contractOrderPlace, futureContractInfo));
                return;
            }
            q0(context, contractOrderPlace, futureContractInfo, new v(this, contractOrderPlace, futureContractInfo));
        } else if (t11 != 5) {
        } else {
            if (p0.c()) {
                v0(contractOrderPlace, context, futureContractInfo, new q(this), new n(this, context, contractOrderPlace, futureContractInfo));
                return;
            }
            q0(context, contractOrderPlace, futureContractInfo, new r(this, contractOrderPlace, futureContractInfo));
        }
    }

    public Observable<LinearSwapOrderInsertRspInfo> w0(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        boolean z11;
        ContractOrderPlace contractOrderPlace2 = contractOrderPlace;
        if (contractOrderPlace.Q() != 1) {
            contractOrderPlace2.B0("");
        }
        if (contractOrderPlace.z() == 100) {
            contractOrderPlace2.m0(1);
        } else {
            contractOrderPlace2.m0(0);
        }
        if (SPUtil.j()) {
            z11 = pk.e.a().c();
        } else {
            z11 = contractOrderPlace.c0();
        }
        boolean z12 = z11;
        if (contractOrderPlace.q() == 2) {
            return h8.a.a().G(futureContractInfo.getContractCode(), contractOrderPlace.w(), contractOrderPlace.y(), contractOrderPlace.W(), contractOrderPlace.l(), contractOrderPlace.r(), contractOrderPlace.o(), contractOrderPlace.i(), contractOrderPlace.K(), contractOrderPlace.H(), contractOrderPlace.J(), contractOrderPlace.L(), contractOrderPlace.E(), contractOrderPlace.B(), contractOrderPlace.D(), contractOrderPlace.F(), contractOrderPlace.M(), z12, contractOrderPlace.b0(), contractOrderPlace.V(), contractOrderPlace.u()).b().delay(300, TimeUnit.MILLISECONDS);
        }
        return h8.a.a().V(futureContractInfo.getContractCode(), contractOrderPlace.w(), contractOrderPlace.y(), contractOrderPlace.W(), contractOrderPlace.l(), contractOrderPlace.r(), contractOrderPlace.o(), contractOrderPlace.i(), contractOrderPlace.K(), contractOrderPlace.H(), contractOrderPlace.J(), contractOrderPlace.L(), contractOrderPlace.E(), contractOrderPlace.B(), contractOrderPlace.D(), contractOrderPlace.F(), contractOrderPlace.M(), z12, contractOrderPlace.b0(), contractOrderPlace.V(), contractOrderPlace.u()).b().delay(300, TimeUnit.MILLISECONDS);
    }

    public final void x0(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, Context context, String str) {
        TradeType tradeType = TradeType.LINEAR_SWAP;
        if (e.G(tradeType)) {
            String w11 = contractOrderPlace.w();
            String contractFace = futureContractInfo.getContractFace();
            String quoteCurrency = futureContractInfo.getQuoteCurrency();
            BigDecimal multiply = m.a(contractFace).multiply(m.a(w11));
            if (e.H(tradeType)) {
                multiply = multiply.divide(m.a(contractOrderPlace.o()), RoundingMode.UP);
            }
            String I = m.I(multiply, 4);
            HuobiToastUtil.l(context, String.format(context.getString(R.string.contract_trade_lowest_amount), new Object[]{I, quoteCurrency}));
            return;
        }
        BigDecimal a11 = m.a(futureContractInfo.getContractFace());
        HuobiToastUtil.l(context, String.format(context.getString(R.string.contract_trade_lowest_amount), new Object[]{m.F(a11.toPlainString(), FuturePrecisionUtil.s(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), (String) null)), str}));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y0(com.huobi.contract.entity.ContractOrderPlace r18) {
        /*
            r17 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "service_line"
            java.lang.String r2 = "usdt_contract"
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
            java.lang.String r15 = " USDT"
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
            r0.p0(r1, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ym.z.y0(com.huobi.contract.entity.ContractOrderPlace):void");
    }

    public class b extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public boolean f76968b = false;

        /* renamed from: c  reason: collision with root package name */
        public ContractOrderPlace f76969c;

        public b() {
        }

        public void onAfter() {
            super.onAfter();
            z.this.Z().dismissProgressDialog();
            z.this.Z().z0(true);
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
                z.this.Z().t1(aPIStatusErrorException.getErrMsg());
            } else if (KycLimitCodeUtils.b(aPIStatusErrorException.getErrCode())) {
                z.this.Z().q(aPIStatusErrorException.getErrMsg());
            } else {
                String errCode = aPIStatusErrorException.getErrCode();
                errCode.hashCode();
                char c11 = 65535;
                boolean z11 = true;
                switch (errCode.hashCode()) {
                    case 1507708:
                        if (errCode.equals("1096")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case 1512229:
                        if (errCode.equals("1501")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case 1516072:
                        if (errCode.equals("1900")) {
                            c11 = 2;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        if (this.f76968b) {
                            HuobiToastUtil.k(BaseApplication.b(), R.string.n_trail_fund_above_60_toast);
                            return;
                        }
                        break;
                    case 1:
                        z.this.Z().b1();
                        return;
                    case 2:
                        break;
                    default:
                        if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                            HuobiToastUtil.l(BaseApplication.b(), aPIStatusErrorException.getErrMsg());
                            return;
                        }
                        return;
                }
                String errMsg = aPIStatusErrorException.getErrMsg();
                ContractOrderPlace contractOrderPlace = this.f76969c;
                if (contractOrderPlace == null || !contractOrderPlace.Z()) {
                    z11 = false;
                }
                FutureOrderErrorHelper.c(errMsg, z11);
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            z.this.Z().c1(false);
            z.this.Z().u0(false, false);
            z.this.Z().w0(true, true);
            z.this.Z().t0();
            HuobiToastUtil.t(j.c(), R.string.string_order_op_ok);
            s6.a.b(j.c()).c(R.raw.order_success);
            ContractOrderPlace contractOrderPlace = this.f76969c;
            if (contractOrderPlace != null && (1 == contractOrderPlace.Q() || 8 == this.f76969c.Q())) {
                d.g().p();
            }
            EventBus.d().k(new ContractAssetAndOrderUpdateEvent());
        }

        public void onStart() {
            super.onStart();
            z.this.Z().showProgressDialog();
            z.this.Z().z0(false);
        }

        public b(ContractOrderPlace contractOrderPlace) {
            boolean z11 = false;
            this.f76968b = contractOrderPlace.q() != 2 ? true : z11;
            this.f76969c = contractOrderPlace;
        }
    }
}
