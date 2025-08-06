package com.huobi.linearswap.ordertutorial.ui;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import bh.j;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOrderInsertRspInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.feature.util.FutureOrderErrorHelper;
import i6.k;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import pk.e;
import pro.huobi.R;
import rx.Observable;
import u6.g;
import zm.b;
import zm.c;

public class OpenOrderDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f74982b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f74983c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f74984d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f74985e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f74986f;

    public class a extends EasySubscriber<LinearSwapOrderInsertRspInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContractOrderPlace f74987b;

        public a(ContractOrderPlace contractOrderPlace) {
            this.f74987b = contractOrderPlace;
        }

        /* renamed from: a */
        public void onNext(LinearSwapOrderInsertRspInfo linearSwapOrderInsertRspInfo) {
            super.onNext(linearSwapOrderInsertRspInfo);
            OpenOrderDialogFragment.this.dismiss();
            OpenOrderDialogFragment.this.Ch().N();
            ((OrderTutorialActivity) OpenOrderDialogFragment.this.getActivity()).S4(3);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String errCode = aPIStatusErrorException.getErrCode();
            errCode.hashCode();
            if (errCode.equals("1900")) {
                String errMsg = aPIStatusErrorException.getErrMsg();
                ContractOrderPlace contractOrderPlace = this.f74987b;
                FutureOrderErrorHelper.c(errMsg, contractOrderPlace != null && contractOrderPlace.Z());
            } else if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                HuobiToastUtil.l(BaseApplication.b(), aPIStatusErrorException.getErrMsg());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Dh(Void voidR) {
        Ih(xh());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Eh(Void voidR) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Fh(Void voidR) {
        dismiss();
    }

    public ContractOrderPlace Ah(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        contractOrderPlace.q0(Bh(futureContractInfo));
        ContractOrderPlace Gh = Gh(contractOrderPlace);
        boolean X = Gh.X();
        if (Gh.n() != 0.0d) {
            Gh.o0(Gh.n());
        } else if (X) {
            if (Gh.A() != 0.0d) {
                Gh.o0(Gh.A());
            }
        } else if (Gh.f() != 0.0d) {
            Gh.o0(Gh.f());
        }
        String w11 = Gh.w();
        String b11 = Gh.b();
        ContractOrderPlace contractOrderPlace2 = Gh;
        yh(contractOrderPlace2, m.a(b11), m.a(w11), futureContractInfo, getContext());
        zh(Gh);
        return Gh;
    }

    public String Bh(FutureContractInfo futureContractInfo) {
        return i8.m.b().c(futureContractInfo.getContractCode());
    }

    public final an.a Ch() {
        return ((OrderTutorialActivity) getActivity()).ph();
    }

    public ContractOrderPlace Gh(ContractOrderPlace contractOrderPlace) {
        int Q = contractOrderPlace.Q();
        String w11 = contractOrderPlace.w();
        if (contractOrderPlace.t() == 1) {
            if (Q != 1) {
                w11 = contractOrderPlace.S();
            }
        } else if (Q != 1) {
            w11 = contractOrderPlace.n() != 0.0d ? BigDecimal.valueOf(contractOrderPlace.n()).toPlainString() : contractOrderPlace.f() != 0.0d ? BigDecimal.valueOf(contractOrderPlace.f()).toPlainString() : m.a(contractOrderPlace.m()).toPlainString();
        }
        contractOrderPlace.B0(w11);
        return contractOrderPlace;
    }

    public Observable<LinearSwapOrderInsertRspInfo> Hh(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        ContractOrderPlace contractOrderPlace2 = contractOrderPlace;
        if (contractOrderPlace.Q() != 1) {
            contractOrderPlace2.B0("");
        }
        boolean z11 = false;
        if (contractOrderPlace.z() == 100) {
            contractOrderPlace2.m0(1);
        } else {
            contractOrderPlace2.m0(0);
        }
        if (SPUtil.j()) {
            z11 = e.a().c();
        }
        return h8.a.a().V(futureContractInfo.getContractCode(), contractOrderPlace.w(), contractOrderPlace.y(), contractOrderPlace.W(), contractOrderPlace.l(), contractOrderPlace.r(), contractOrderPlace.o(), contractOrderPlace.i(), contractOrderPlace.K(), contractOrderPlace.H(), contractOrderPlace.J(), contractOrderPlace.L(), contractOrderPlace.E(), contractOrderPlace.B(), contractOrderPlace.D(), contractOrderPlace.F(), contractOrderPlace.M(), z11, false, 0, contractOrderPlace.u()).b().delay(300, TimeUnit.MILLISECONDS);
    }

    public void Ih(ContractOrderPlace contractOrderPlace) {
        BigDecimal bigDecimal;
        k.o("ACTION-LINEAR_SWAP", "u本位全仓永续合约下单点击-合约下单引导");
        String S = contractOrderPlace.S();
        contractOrderPlace.X();
        contractOrderPlace.Q();
        String w11 = contractOrderPlace.w();
        int t11 = contractOrderPlace.t();
        m.a(w11);
        BigDecimal a11 = m.a(S);
        if (t11 != 1 || a11.compareTo(BigDecimal.ZERO) > 0) {
            m.a(contractOrderPlace.h());
            if (contractOrderPlace.e() == 0) {
                bigDecimal = m.a(contractOrderPlace.b());
            } else {
                bigDecimal = m.a(String.valueOf(contractOrderPlace.z()));
            }
            if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{contractOrderPlace.c()}));
                return;
            }
            an.a Ch = Ch();
            String symbol = Ch.H().getSymbol();
            FutureContractInfo H = Ch.H();
            contractOrderPlace.N0(symbol);
            contractOrderPlace.s0(Ch.h());
            contractOrderPlace.r0(Ch.l());
            contractOrderPlace.i0(Ch.E());
            contractOrderPlace.G0(Ch.A());
            contractOrderPlace.v0(1);
            ContractOrderPlace Ah = Ah(contractOrderPlace, H);
            if (Ah.Y()) {
                Jh(Ah, H, getContext());
                return;
            }
            return;
        }
        HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{contractOrderPlace.R()}));
    }

    public void Jh(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, Context context) {
        Hh(contractOrderPlace, futureContractInfo).compose(RxJavaHelper.t((g) null)).subscribe(new a(contractOrderPlace));
    }

    public void addEvent(r rVar) {
        Observable<Void> a11 = dw.a.a(this.f74986f);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new zm.a(this));
        dw.a.a(rVar.b(R.id.space)).throttleFirst(1, timeUnit).subscribe(new b(this));
        dw.a.a(rVar.b(R.id.iv_close)).throttleFirst(1, timeUnit).subscribe(new c(this));
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R.layout.dialog_order_tutorial_open_order;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f74982b = (TextView) rVar.b(R.id.tv_title);
        this.f74983c = (TextView) rVar.b(R.id.tv_contract_name);
        this.f74984d = (TextView) rVar.b(R.id.tv_contract_amount);
        this.f74985e = (TextView) rVar.b(R.id.tv_contract_bond);
        this.f74986f = (TextView) rVar.b(R.id.tv_next);
    }

    public boolean isTransparent() {
        return false;
    }

    public void onResume() {
        super.onResume();
        an.a Ch = Ch();
        FutureContractInfo H = Ch.H();
        boolean m11 = Ch.m();
        String D = Ch.D();
        String n11 = Ch.n();
        String quoteCurrency = H.getQuoteCurrency();
        String symbol = H.getSymbol();
        String o11 = a7.e.o(getContext(), symbol, quoteCurrency, Ch.H().getContractCode(), Ch.H().getContractType());
        TextView textView = this.f74982b;
        int i11 = R.string.n_contract_trade_open_more;
        textView.setText(m11 ? R.string.n_contract_trade_open_more : R.string.n_contract_trade_open_low);
        TextView textView2 = this.f74986f;
        if (!m11) {
            i11 = R.string.n_contract_trade_open_low;
        }
        textView2.setText(i11);
        boolean z11 = w.l() == m11;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(getResources().getColor(z11 ? R.color.base_down_color : R.color.base_up_color));
        gradientDrawable.setCornerRadius((float) PixelUtils.a(4.0f));
        this.f74986f.setBackgroundDrawable(gradientDrawable);
        this.f74983c.setText(o11);
        this.f74984d.setText(AppUtil.b(D, symbol));
        this.f74985e.setText(AppUtil.b(m.m(n11, 4), quoteCurrency));
    }

    public final boolean wh(Context context, String str, BigDecimal bigDecimal, FutureContractInfo futureContractInfo, BigDecimal bigDecimal2) {
        if (bigDecimal.compareTo(BigDecimal.ONE) >= 0 || bigDecimal2.compareTo(BigDecimal.ZERO) == 0) {
            return false;
        }
        BigDecimal a11 = m.a(futureContractInfo.getContractFace());
        HuobiToastUtil.l(context, String.format(context.getString(R.string.contract_trade_lowest_amount), new Object[]{m.F(a11.toPlainString(), FuturePrecisionUtil.s(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), (String) null)), str}));
        return true;
    }

    public final ContractOrderPlace xh() {
        an.a Ch = Ch();
        boolean m11 = Ch.m();
        String n11 = Ch.n();
        FutureContractInfo H = Ch.H();
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.B0("");
        contractOrderPlace.d0(n11);
        contractOrderPlace.h0(m11);
        contractOrderPlace.A0(0);
        contractOrderPlace.X0(5);
        contractOrderPlace.g0(0);
        contractOrderPlace.y0(4);
        contractOrderPlace.Z0("");
        contractOrderPlace.Y0("");
        contractOrderPlace.e0(getString(R.string.n_exchange_order_list_amount));
        contractOrderPlace.C0("");
        contractOrderPlace.W0("");
        contractOrderPlace.x0("");
        contractOrderPlace.E0(0);
        contractOrderPlace.j0("");
        contractOrderPlace.U0("");
        contractOrderPlace.k0("");
        contractOrderPlace.V0(5);
        if (H != null) {
            contractOrderPlace.n0(H.getContractType());
        }
        return contractOrderPlace;
    }

    public void yh(ContractOrderPlace contractOrderPlace, BigDecimal bigDecimal, BigDecimal bigDecimal2, FutureContractInfo futureContractInfo, Context context) {
        String b11 = contractOrderPlace.b();
        int v11 = contractOrderPlace.v();
        contractOrderPlace.e();
        String G = contractOrderPlace.G();
        BigDecimal bigDecimal3 = BigDecimal.ZERO;
        if (v11 == 0) {
            BigDecimal scale = m.a(FutureUnitUtil.e(bigDecimal.toPlainString(), contractOrderPlace.w(), futureContractInfo.getContractFace(), TradeType.LINEAR_SWAP, FuturePrecisionUtil.g(G))).setScale(FuturePrecisionUtil.B(), 1);
            if (wh(context, G, scale, futureContractInfo, bigDecimal2)) {
                contractOrderPlace.l0(false);
            }
            b11 = scale.toPlainString();
        }
        contractOrderPlace.c1(b11);
        if (m.a(contractOrderPlace.w()).compareTo(BigDecimal.ZERO) == 0) {
            HuobiToastUtil.j(R.string.n_can_not_get_price);
            contractOrderPlace.l0(false);
        }
    }

    public ContractOrderPlace zh(ContractOrderPlace contractOrderPlace) {
        int Q = contractOrderPlace.Q();
        int O = contractOrderPlace.O();
        int v11 = contractOrderPlace.v();
        if (contractOrderPlace.X()) {
            contractOrderPlace.p0("buy");
        } else {
            contractOrderPlace.p0("sell");
        }
        if (v11 == 0) {
            contractOrderPlace.w0("open");
        } else if (v11 == 1) {
            contractOrderPlace.w0("close");
        } else {
            contractOrderPlace.w0("close");
        }
        if (2 == contractOrderPlace.t()) {
            contractOrderPlace.D0("post_only");
        } else if (4 == contractOrderPlace.t()) {
            if (Q == 1) {
                contractOrderPlace.D0("fok");
            } else if (Q == 6) {
                contractOrderPlace.D0("lightning_fok");
            } else if (Q == 2) {
                contractOrderPlace.D0("opponent_fok");
            } else if (Q == 3) {
                contractOrderPlace.D0("optimal_5_fok");
            } else if (Q == 4) {
                contractOrderPlace.D0("optimal_10_fok");
            } else if (Q == 5) {
                contractOrderPlace.D0("optimal_20_fok");
            }
        } else if (3 == contractOrderPlace.t()) {
            if (Q == 1) {
                contractOrderPlace.D0("ioc");
            } else if (Q == 6) {
                contractOrderPlace.D0("lightning_ioc");
            } else if (Q == 2) {
                contractOrderPlace.D0("opponent_ioc");
            } else if (Q == 3) {
                contractOrderPlace.D0("optimal_5_ioc");
            } else if (Q == 4) {
                contractOrderPlace.D0("optimal_10_ioc");
            } else if (Q == 5) {
                contractOrderPlace.D0("optimal_20_ioc");
            }
        } else if (5 == contractOrderPlace.t()) {
            if (O == 7) {
                contractOrderPlace.D0("formula_price");
            } else if (O == 3) {
                contractOrderPlace.D0("optimal_5");
            } else if (O == 4) {
                contractOrderPlace.D0("optimal_10");
            } else if (O == 5) {
                contractOrderPlace.D0("optimal_20");
            }
        } else if (Q == 1) {
            contractOrderPlace.D0("limit");
        } else if (Q == 6) {
            contractOrderPlace.D0("lightning");
        } else if (Q == 2) {
            contractOrderPlace.D0("opponent");
        } else if (Q == 3) {
            contractOrderPlace.D0("optimal_5");
        } else if (Q == 4) {
            contractOrderPlace.D0("optimal_10");
        } else if (Q == 5) {
            contractOrderPlace.D0("optimal_20");
        }
        if (1 == contractOrderPlace.t()) {
            if (m.a(contractOrderPlace.S()).compareTo(BigDecimal.valueOf(contractOrderPlace.k())) >= 0) {
                contractOrderPlace.a1("ge");
            } else {
                contractOrderPlace.a1("le");
            }
        }
        return contractOrderPlace;
    }
}
