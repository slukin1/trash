package com.huobi.linearswap.ui;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import bh.j;
import cn.f;
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
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.linear.swap.core.util.LinearSwapDepthType;
import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.response.MarketDepthResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.utils.KycLimitCodeUtils;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.util.FutureOrderErrorHelper;
import com.huobi.feature.util.KycAndHasTradeDialogUtils;
import com.huobi.view.HorizontalTradeAmountPercentEdittext;
import com.huobi.view.TradePriceEditext;
import com.huobi.view.keyboard.HuobiBottomDialogKeyboardHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.Observable;
import u6.g;
import ym.z;

public class LinearSwapDialogFragment extends BaseDialogFragment {
    public BigDecimal A;
    public BigDecimal B;
    public int C;
    public String D;
    public MarketDepthListener E = new c();

    /* renamed from: b  reason: collision with root package name */
    public TradePriceEditext f75144b;

    /* renamed from: c  reason: collision with root package name */
    public HorizontalTradeAmountPercentEdittext f75145c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f75146d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f75147e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f75148f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f75149g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f75150h;

    /* renamed from: i  reason: collision with root package name */
    public CheckBox f75151i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f75152j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f75153k;

    /* renamed from: l  reason: collision with root package name */
    public FutureContractInfo f75154l;

    /* renamed from: m  reason: collision with root package name */
    public LinearSwapPosition f75155m;

    /* renamed from: n  reason: collision with root package name */
    public String f75156n;

    /* renamed from: o  reason: collision with root package name */
    public String f75157o;

    /* renamed from: p  reason: collision with root package name */
    public z f75158p;

    /* renamed from: q  reason: collision with root package name */
    public double f75159q;

    /* renamed from: r  reason: collision with root package name */
    public double f75160r;

    /* renamed from: s  reason: collision with root package name */
    public d f75161s;

    /* renamed from: t  reason: collision with root package name */
    public int f75162t;

    /* renamed from: u  reason: collision with root package name */
    public EditText f75163u;

    /* renamed from: v  reason: collision with root package name */
    public EditText f75164v;

    /* renamed from: w  reason: collision with root package name */
    public HuobiBottomDialogKeyboardHelper f75165w;

    /* renamed from: x  reason: collision with root package name */
    public View f75166x;

    /* renamed from: y  reason: collision with root package name */
    public LoadingView f75167y;

    /* renamed from: z  reason: collision with root package name */
    public int f75168z;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            if (LinearSwapDialogFragment.this.getActivity() != null) {
                LinearSwapDialogFragment linearSwapDialogFragment = LinearSwapDialogFragment.this;
                linearSwapDialogFragment.Lh(linearSwapDialogFragment.f75163u, editable, false);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            if (LinearSwapDialogFragment.this.getActivity() != null) {
                LinearSwapDialogFragment linearSwapDialogFragment = LinearSwapDialogFragment.this;
                linearSwapDialogFragment.Jh(linearSwapDialogFragment.f75164v, editable, false);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class c extends MarketDepthListener {
        public c() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            BigDecimal bigDecimal;
            if (marketDepthResponse != null && LinearSwapDialogFragment.this.f75154l != null && marketDepthResponse.getSymbol().equals(LinearSwapDialogFragment.this.f75154l.getContractShortType())) {
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                LinearSwapDialogFragment.this.bi(asks, 1);
                LinearSwapDialogFragment.this.bi(bids, 0);
                if (LinearSwapDialogFragment.this.w2()) {
                    bigDecimal = m.a(String.valueOf(LinearSwapDialogFragment.this.f75160r));
                } else {
                    bigDecimal = m.a(String.valueOf(LinearSwapDialogFragment.this.f75159q));
                }
                if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    LinearSwapDialogFragment.this.f75163u.setText("");
                } else {
                    LinearSwapDialogFragment.this.f75163u.setText(m.q(bigDecimal, FuturePrecisionUtil.y(LinearSwapDialogFragment.this.f75154l.getContractCode(), LinearSwapDialogFragment.this.f75154l.getContractShortType(), LinearSwapDialogFragment.this.f75154l.getOptionCode())));
                }
                LinearSwapDialogFragment.this.f75163u.setSelection(LinearSwapDialogFragment.this.f75163u.getText().length());
                h8.a.a().e0(false, LinearSwapDialogFragment.this.f75154l.getContractShortType(), LinearSwapDepthType.STEP6, LinearSwapDialogFragment.this.E);
            }
        }
    }

    public interface d {
        void a();
    }

    public class e extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public boolean f75172b;

        /* renamed from: c  reason: collision with root package name */
        public ContractOrderPlace f75173c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                LinearSwapDialogFragment.this.dismiss();
            }
        }

        public e(ContractOrderPlace contractOrderPlace) {
            this.f75172b = !LinearSwapDialogFragment.this.Sh() && contractOrderPlace.q() != 2;
            this.f75173c = contractOrderPlace;
        }

        public void onAfter() {
            super.onAfter();
            LinearSwapDialogFragment.this.f75166x.setVisibility(8);
            LinearSwapDialogFragment.this.f75167y.d();
            LinearSwapDialogFragment.this.f75152j.setEnabled(true);
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
                LinearSwapDialogFragment.this.t1(aPIStatusErrorException.getErrMsg());
            } else if (KycLimitCodeUtils.b(aPIStatusErrorException.getErrCode())) {
                LinearSwapDialogFragment.this.q(aPIStatusErrorException.getErrMsg());
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
                        if (this.f75172b) {
                            HuobiToastUtil.k(BaseApplication.b(), R.string.n_trail_fund_above_60_toast);
                            return;
                        }
                        break;
                    case 1:
                        LinearSwapDialogFragment.this.b1();
                        return;
                    case 2:
                        break;
                    default:
                        if (TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                            HuobiToastUtil.k(j.c(), R.string.string_order_op_fail);
                            return;
                        } else {
                            HuobiToastUtil.l(j.c(), aPIStatusErrorException.getErrMsg());
                            return;
                        }
                }
                String errMsg = aPIStatusErrorException.getErrMsg();
                ContractOrderPlace contractOrderPlace = this.f75173c;
                if (contractOrderPlace == null || !contractOrderPlace.Z()) {
                    z11 = false;
                }
                FutureOrderErrorHelper.c(errMsg, z11);
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            if (LinearSwapDialogFragment.this.Sh()) {
                HuobiToastUtil.t(j.c(), R.string.contract_trade_lightning_successful_submit);
            } else {
                HuobiToastUtil.t(j.c(), R.string.string_order_op_ok);
            }
            s6.a.b(j.c()).c(R.raw.order_success);
            EventBus.d().k(new ContractAssetAndOrderUpdateEvent());
            i.b().g(new a(), 10);
        }

        public void onStart() {
            super.onStart();
            LinearSwapDialogFragment.this.f75166x.setVisibility(0);
            LinearSwapDialogFragment.this.f75152j.setEnabled(false);
            LinearSwapDialogFragment.this.f75167y.c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Th(int i11) {
        if (i11 == 1) {
            Zh(10);
            Bf();
        } else if (i11 == 2) {
            Zh(20);
            Bf();
        } else if (i11 == 3) {
            Zh(50);
            Bf();
        } else if (i11 != 4) {
            this.f75164v.setText("");
        } else {
            Zh(100);
            Bf();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        this.f75165w.hideKeyboard();
        String str = "";
        String charSequence = this.f75163u.getHint() == null ? str : this.f75163u.getHint().toString();
        if (this.f75164v.getHint() != null) {
            str = this.f75164v.getHint().toString();
        }
        Yh(charSequence, str, this.f75163u.getText().toString(), this.f75164v.getText().toString(), 2, Sh() ? 6 : 1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Bf() {
        this.f75163u.clearFocus();
        this.f75164v.clearFocus();
    }

    public void Jh(EditText editText, Editable editable, boolean z11) {
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
            this.D = editText.getText().toString();
            Mh();
            return;
        }
        editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        String str = null;
        if (a7.e.E(TradeType.LINEAR_SWAP)) {
            if (this.f75145c.getAmountType() == 0) {
                str = m.b(editable, 10, FuturePrecisionUtil.s(this.f75154l.getContractCode(), this.f75154l.getContractShortType(), this.f75154l.getOptionCode()));
            }
            if (str != null) {
                editText.setText(str);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else {
            if (this.f75145c.getAmountType() == 0) {
                if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
                    str = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
                } else {
                    str = m.b(editable, 10, FuturePrecisionUtil.B());
                }
            }
            if (str != null) {
                editText.setText(str);
                editText.setSelection(editText.getText().length());
                return;
            }
        }
        if (this.f75145c.getAmountType() == 0) {
            this.D = editText.getText().toString();
        }
        Mh();
    }

    public void Kh(boolean z11) {
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.X0(Sh() ? 6 : 1);
        contractOrderPlace.B0(this.f75163u.getText().toString());
        contractOrderPlace.y0(0);
        contractOrderPlace.i0(this.f75159q);
        contractOrderPlace.G0(this.f75160r);
        contractOrderPlace.r0(m.a(this.f75155m.getLastPrice()).doubleValue());
        contractOrderPlace.h0(w2());
        contractOrderPlace.A0(2);
        contractOrderPlace.N0(this.f75156n);
        contractOrderPlace.v0(this.f75168z);
        contractOrderPlace.E0(this.C);
        ai(this.f75158p.s(contractOrderPlace));
        if (z11) {
            Oh(this.f75163u.getText().toString());
        }
        if (!TextUtils.isEmpty(this.f75164v.getText())) {
            Zh(this.C);
        }
        Mh();
    }

    public void Lh(EditText editText, Editable editable, boolean z11) {
        if (!Sh()) {
            ci(Ph(editable.toString()));
            if (editable.length() == 0) {
                editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
            } else {
                editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
            }
            String b11 = m.b(editable, 10, FuturePrecisionUtil.y(this.f75154l.getContractCode(), this.f75154l.getContractShortType(), this.f75154l.getOptionCode()));
            if (b11 != null) {
                editText.setText(b11);
                editText.setSelection(editText.getText().length());
                return;
            }
        }
        Kh(z11);
    }

    public final void Mh() {
        if (TextUtils.isEmpty(this.f75163u.getText()) || TextUtils.isEmpty(this.f75164v.getText())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("-- " + this.f75155m.getMarginAsset());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.baseColorSecondaryText)), 0, spannableStringBuilder.length(), 33);
        } else if ("buy".equalsIgnoreCase(this.f75155m.getDirection())) {
            a7.b.a(this.f75155m.getCostOpen(), this.f75163u.getText().toString(), this.f75154l.getContractFace(), this.D, "--", TradeType.LINEAR_SWAP);
        } else {
            a7.b.c(this.f75155m.getCostOpen(), this.f75163u.getText().toString(), this.f75154l.getContractFace(), this.D, "--", TradeType.LINEAR_SWAP);
        }
    }

    public boolean Nh(String str) {
        return m.a(str).compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean Oh(String str) {
        return m.a(str).compareTo(BigDecimal.ZERO) > 0;
    }

    public String Ph(String str) {
        return (TextUtils.isEmpty(str) || InstructionFileId.DOT.equals(str) || "usd".equals(LegalCurrencyConfigUtil.y())) ? "" : LegalCurrencyConfigUtil.B(str);
    }

    public final String Qh() {
        String str;
        LinearSwapPosition linearSwapPosition = this.f75155m;
        if (linearSwapPosition == null) {
            str = null;
        } else {
            str = linearSwapPosition.getLastPrice();
        }
        if (str == null) {
            return i8.m.b().c(this.f75157o);
        }
        return m.a(str).toPlainString();
    }

    public final Observable<Object> Rh(ContractOrderPlace contractOrderPlace) {
        if (Sh()) {
            return this.f75158p.o0(contractOrderPlace, this.f75154l).compose(RxJavaHelper.t((g) null));
        }
        return this.f75158p.w0(contractOrderPlace, this.f75154l).compose(RxJavaHelper.t((g) null));
    }

    public boolean Sh() {
        return this.f75162t == 1;
    }

    public final void Wh(LinearSwapPosition linearSwapPosition) {
        if (linearSwapPosition != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            boolean z11 = false;
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.global_main_text_color)), 0, spannableStringBuilder.length(), 33);
            this.f75147e.setText(spannableStringBuilder.append("").append(a7.e.k(getContext(), linearSwapPosition.getSymbol(), this.f75154l.getQuoteCurrency(), linearSwapPosition.getDirection(), linearSwapPosition.getLeverRate(), ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText), this.f75168z, linearSwapPosition.getContractType())));
            if (this.f75168z == 1) {
                z11 = true;
            }
            if (pk.e.a().b(z11, z11 ? "USDT" : linearSwapPosition.getContractCode())) {
                if (z11) {
                    this.f75149g.setText(getResources().getString(R.string.n_contract_trade_lightning_alert_super_margin_single_side));
                } else {
                    this.f75149g.setText(getResources().getString(R.string.n_contract_trade_lightning_alert_margin_margin_single_side));
                }
            } else if (z11) {
                this.f75149g.setText(getResources().getString(R.string.n_contract_trade_lightning_alert_super_margin_dual_side));
            } else {
                this.f75149g.setText(getResources().getString(R.string.n_contract_trade_lightning_alert_margin_margin_dual_side));
            }
        }
    }

    public final void Xh(ContractOrderPlace contractOrderPlace) {
        Rh(contractOrderPlace).subscribe(new e(contractOrderPlace));
    }

    public void Yh(String str, String str2, String str3, String str4, int i11, int i12) {
        if (i12 != 1) {
            if (Sh()) {
                str3 = Qh();
            } else if (w2()) {
                str3 = BigDecimal.valueOf(this.f75160r).toPlainString();
            } else {
                str3 = BigDecimal.valueOf(this.f75159q).toPlainString();
            }
        }
        if (i12 == 1 && !Oh(str3)) {
            HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{str}));
        } else if (this.f75145c.getAmountType() != 0 || Nh(str4)) {
            ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
            contractOrderPlace.N0(this.f75156n);
            contractOrderPlace.B0(str3);
            contractOrderPlace.d0(str4);
            contractOrderPlace.h0(w2());
            contractOrderPlace.A0(i11);
            contractOrderPlace.X0(i12);
            contractOrderPlace.r0(m.a(this.f75155m.getLastPrice()).doubleValue());
            contractOrderPlace.i0(this.f75159q);
            contractOrderPlace.G0(this.f75160r);
            contractOrderPlace.g0(this.f75145c.getAmountType());
            contractOrderPlace.v0(this.f75168z);
            contractOrderPlace.E0(this.C);
            LinearSwapPosition linearSwapPosition = this.f75155m;
            if (linearSwapPosition != null) {
                contractOrderPlace.s0(linearSwapPosition.getLeverRate());
            }
            if (w2()) {
                contractOrderPlace.W0(getString(R.string.contract_trade_buy_flat_empty));
            } else {
                contractOrderPlace.W0(getString(R.string.contract_trade_sell_flat_more));
            }
            contractOrderPlace.x0(getString(R.string.contract_trade_position_close_quick));
            ContractOrderPlace e11 = this.f75158p.e(getActivity(), contractOrderPlace, this.f75154l);
            if (this.f75154l != null) {
                Xh(e11);
                HashMap hashMap = new HashMap();
                hashMap.put("module_name", "hold_list");
                gs.g.j("market_price_flat", "usdt_contract", "confirm", hashMap);
            }
        } else {
            HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{str2}));
        }
    }

    public final void Zh(int i11) {
        BigDecimal bigDecimal;
        String str;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        if (this.f75145c.getAmountType() != 0) {
            ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
            contractOrderPlace.X0(Sh() ? 6 : 1);
            contractOrderPlace.B0(this.f75163u.getText().toString());
            contractOrderPlace.y0(0);
            contractOrderPlace.i0(this.f75159q);
            contractOrderPlace.G0(this.f75160r);
            contractOrderPlace.r0(m.a(this.f75155m.getLastPrice()).doubleValue());
            contractOrderPlace.h0(w2());
            contractOrderPlace.A0(2);
            contractOrderPlace.N0(this.f75156n);
            contractOrderPlace.v0(this.f75168z);
            contractOrderPlace.E0(this.C);
            ContractOrderPlace s11 = this.f75158p.s(contractOrderPlace);
            this.C = i11;
            if (w2()) {
                bigDecimal = this.A;
            } else {
                bigDecimal = this.B;
            }
            if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                this.D = "0";
                EditText editText = this.f75164v;
                editText.setText(i11 + "%");
                return;
            }
            TradeType tradeType = TradeType.LINEAR_SWAP;
            if (a7.e.E(tradeType)) {
                BigDecimal divide = bigDecimal.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                if (divide.compareTo(BigDecimal.ONE) >= 0 || divide.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal4 = divide.setScale(FuturePrecisionUtil.B(), 1);
                } else {
                    bigDecimal4 = BigDecimal.ONE;
                }
                str = m.m(FutureUnitUtil.d(bigDecimal4.toPlainString(), s11.w(), this.f75154l.getContractFace(), tradeType), FuturePrecisionUtil.s(this.f75154l.getContractCode(), this.f75154l.getContractShortType(), this.f75154l.getOptionCode()));
                this.D = bigDecimal4.toPlainString();
            } else if (a7.e.G(tradeType)) {
                BigDecimal divide2 = bigDecimal.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                if (divide2.compareTo(BigDecimal.ONE) >= 0 || divide2.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal3 = divide2.setScale(FuturePrecisionUtil.B(), 1);
                } else {
                    bigDecimal3 = BigDecimal.ONE;
                }
                str = m.m(FutureUnitUtil.d(bigDecimal3.toPlainString(), s11.w(), this.f75154l.getContractFace(), tradeType), FuturePrecisionUtil.g(this.f75156n));
                this.D = bigDecimal3.toPlainString();
            } else {
                BigDecimal divide3 = bigDecimal.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                if (divide3.compareTo(BigDecimal.ONE) >= 0 || divide3.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal2 = divide3.setScale(FuturePrecisionUtil.B(), 1);
                } else {
                    bigDecimal2 = BigDecimal.ONE;
                }
                String plainString = bigDecimal2.toPlainString();
                this.D = bigDecimal2.toPlainString();
                str = plainString;
            }
            if (TextUtils.isEmpty(str) || m.a(str).compareTo(BigDecimal.ZERO) == 0) {
                EditText editText2 = this.f75164v;
                editText2.setText(i11 + "%");
                return;
            }
            EditText editText3 = this.f75164v;
            editText3.setText(i11 + "%(≈ " + str + ")");
        }
    }

    public void addEvent(r rVar) {
        this.f75145c.setAmountCallback(new cn.g(this));
        this.f75163u.addTextChangedListener(new a());
        this.f75164v.addTextChangedListener(new b());
        this.f75146d.setOnClickListener(new cn.d(this));
        this.f75152j.setOnClickListener(new cn.c(this));
    }

    public void afterInit() {
        Wh(this.f75155m);
        FutureContractInfo futureContractInfo = this.f75154l;
        if (futureContractInfo != null) {
            d2(FuturePrecisionUtil.y(futureContractInfo.getContractCode(), this.f75154l.getContractShortType(), this.f75154l.getOptionCode()));
        }
        if (Sh()) {
            this.f75163u.setText(m.m(Qh(), FuturePrecisionUtil.y(this.f75154l.getContractCode(), this.f75154l.getContractShortType(), this.f75154l.getOptionCode())));
            this.f75145c.setAmountType(4);
        } else if (this.f75154l != null) {
            h8.a.a().e0(true, this.f75154l.getContractCode(), LinearSwapDepthType.STEP6, this.E);
        }
    }

    public final void ai(ContractOrderPlace contractOrderPlace) {
        String str;
        String str2;
        String plainString;
        String plainString2;
        int v11 = contractOrderPlace.v();
        if (tg.r.x().F0()) {
            TradeType tradeType = TradeType.LINEAR_SWAP;
            if (a7.e.E(tradeType)) {
                if (v11 == 0) {
                    this.f75158p.d(contractOrderPlace, this.f75154l);
                    this.f75158p.b(contractOrderPlace, this.f75154l);
                } else {
                    this.f75158p.c(contractOrderPlace, this.f75154l);
                    this.f75158p.a(contractOrderPlace, this.f75154l);
                }
                if (this.f75158p.g() == null) {
                    str = "";
                } else {
                    str = this.f75158p.g().setScale(FuturePrecisionUtil.s(this.f75154l.getContractCode(), this.f75154l.getContractShortType(), this.f75154l.getOptionCode()), 1).toPlainString();
                }
                if (this.f75158p.k() != null) {
                    str2 = this.f75158p.k().setScale(FuturePrecisionUtil.s(this.f75154l.getContractCode(), this.f75154l.getContractShortType(), this.f75154l.getOptionCode()), 1).toPlainString();
                }
            } else if (a7.e.G(tradeType)) {
                if (v11 == 0) {
                    this.f75158p.d(contractOrderPlace, this.f75154l);
                    this.f75158p.b(contractOrderPlace, this.f75154l);
                } else {
                    this.f75158p.c(contractOrderPlace, this.f75154l);
                    this.f75158p.a(contractOrderPlace, this.f75154l);
                }
                if (this.f75158p.g() == null) {
                    plainString2 = "";
                } else {
                    plainString2 = this.f75158p.g().setScale(FuturePrecisionUtil.g(this.f75156n)).toPlainString();
                }
                if (this.f75158p.k() != null) {
                    str2 = this.f75158p.k().setScale(FuturePrecisionUtil.g(this.f75156n)).toPlainString();
                }
            } else {
                if (v11 == 0) {
                    this.f75158p.d(contractOrderPlace, this.f75154l);
                } else {
                    this.f75158p.c(contractOrderPlace, this.f75154l);
                }
                if (this.f75158p.i() == null) {
                    plainString = "";
                } else {
                    plainString = this.f75158p.i().toPlainString();
                }
                if (this.f75158p.j() != null) {
                    str2 = this.f75158p.j().toPlainString();
                }
            }
            str2 = "";
        } else {
            str = "";
            str2 = str;
        }
        if (this.f75158p.i() == null) {
            this.A = BigDecimal.ZERO;
        } else {
            this.A = this.f75158p.i();
        }
        if (this.f75158p.j() == null) {
            this.B = BigDecimal.ZERO;
        } else {
            this.B = this.f75158p.j();
        }
        TradeType tradeType2 = TradeType.LINEAR_SWAP;
        boolean E2 = a7.e.E(tradeType2);
        boolean G = a7.e.G(tradeType2);
        if (E2) {
            if (w2()) {
                if (TextUtils.isEmpty(str)) {
                    this.f75153k.setText("");
                    return;
                }
                this.f75153k.setText(String.format(getContext().getString(R.string.n_contract_trade_close_margin_available), new Object[]{str, this.f75156n}));
            } else if (TextUtils.isEmpty(str2)) {
                this.f75153k.setText("");
            } else {
                this.f75153k.setText(String.format(getContext().getString(R.string.n_contract_trade_close_margin_available), new Object[]{str2, this.f75156n}));
            }
        } else if (G) {
            if (w2()) {
                if (TextUtils.isEmpty(str)) {
                    this.f75153k.setText("");
                    return;
                }
                this.f75153k.setText(String.format(getContext().getString(R.string.n_contract_trade_close_margin_available), new Object[]{str, "usdt".toUpperCase(Locale.US)}));
            } else if (TextUtils.isEmpty(str2)) {
                this.f75153k.setText("");
            } else {
                this.f75153k.setText(String.format(getContext().getString(R.string.n_contract_trade_close_margin_available), new Object[]{str2, "usdt".toUpperCase(Locale.US)}));
            }
        } else if (w2()) {
            if (TextUtils.isEmpty(str)) {
                this.f75153k.setText("");
                return;
            }
            this.f75153k.setText(String.format(getContext().getString(R.string.n_contract_trade_close_margin_available), new Object[]{str, getContext().getString(R.string.contract_market_vol_sheet)}));
        } else if (TextUtils.isEmpty(str2)) {
            this.f75153k.setText("");
        } else {
            this.f75153k.setText(String.format(getContext().getString(R.string.n_contract_trade_close_margin_available), new Object[]{str2, getContext().getString(R.string.contract_market_vol_sheet)}));
        }
    }

    public final void b1() {
        KycAndHasTradeDialogUtils.m(getContext());
    }

    public final void bi(List<Double[]> list, int i11) {
        if (list == null || list.isEmpty()) {
            if (i11 == 0) {
                this.f75159q = 0.0d;
            } else {
                this.f75160r = 0.0d;
            }
        } else if (i11 == 0) {
            this.f75159q = list.get(0)[0].doubleValue();
        } else {
            this.f75160r = list.get(0)[0].doubleValue();
        }
    }

    public void ci(String str) {
    }

    public void d2(int i11) {
        this.f75144b.setLength(i11);
    }

    public final void di() {
        FuturePrecisionUtil.y(this.f75154l.getContractCode(), this.f75154l.getContractShortType(), this.f75154l.getOptionCode());
        Mh();
    }

    public void dismiss() {
        d dVar = this.f75161s;
        if (dVar != null) {
            dVar.a();
        }
        super.dismiss();
    }

    public int getContentViewResId() {
        return R.layout.dialog_contract_trade;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f75146d = rVar.c(R.id.iv_close);
        this.f75147e = (TextView) rVar.b(R.id.tv_contract);
        this.f75148f = (TextView) rVar.b(R.id.tv_times);
        this.f75149g = (TextView) rVar.b(R.id.tv_hint);
        this.f75150h = (TextView) rVar.b(R.id.tv_hint_desc);
        this.f75151i = (CheckBox) rVar.b(R.id.agreement_cb);
        this.f75152j = (LinearLayout) rVar.b(R.id.dialog_position_trade);
        this.f75153k = (TextView) rVar.b(R.id.dialog_contract_position_tv);
        TradePriceEditext tradePriceEditext = (TradePriceEditext) rVar.b(R.id.dialog_contract_price_et);
        this.f75144b = tradePriceEditext;
        tradePriceEditext.setTradeType(TradeType.CONTRACT);
        this.f75163u = this.f75144b.getEditText();
        this.f75166x = rVar.b(R.id.dialog_loading);
        this.f75167y = (LoadingView) rVar.b(R.id.loading_dialog_loading_view);
        HorizontalTradeAmountPercentEdittext horizontalTradeAmountPercentEdittext = (HorizontalTradeAmountPercentEdittext) rVar.b(R.id.dialog_contract_amount_et);
        this.f75145c = horizontalTradeAmountPercentEdittext;
        horizontalTradeAmountPercentEdittext.setTradeType(TradeType.SWAP);
        this.f75164v = this.f75145c.getEditText();
        TradeType tradeType = TradeType.LINEAR_SWAP;
        if (a7.e.E(tradeType)) {
            this.f75145c.setLabel(this.f75156n);
        } else if (a7.e.G(tradeType)) {
            this.f75145c.setLabel("usdt".toUpperCase(Locale.US));
        } else {
            this.f75145c.setLabel((int) R.string.contract_trade_unit_sheet);
        }
        this.f75149g.setText(getResources().getString(R.string.n_contract_trade_lightning_alert_confirm_content));
        this.f75150h.setText(getResources().getString(R.string.n_contract_trade_lightning_alert_confirm_note));
        this.f75158p = new z((k2) null);
        this.f75165w = new HuobiBottomDialogKeyboardHelper();
        if (!(this.f75155m == null || this.f75154l == null)) {
            z zVar = this.f75158p;
            zVar.u0(this.f75154l.getContractCode() + "_" + this.f75155m.getMarginMode() + this.f75155m.getDirection(), this.f75155m);
        }
        di();
        FutureContractInfo futureContractInfo = this.f75154l;
        if (futureContractInfo != null) {
            this.f75144b.setLabel(futureContractInfo.getQuoteCurrency());
        }
    }

    public boolean isTransparent() {
        return false;
    }

    public void q(String str) {
        KycAndHasTradeDialogUtils.l(getContext(), str, cn.e.f13131a);
    }

    public void t1(String str) {
        KycAndHasTradeDialogUtils.n(getContext(), str, f.f13137a);
    }

    public final boolean w2() {
        LinearSwapPosition linearSwapPosition = this.f75155m;
        return linearSwapPosition == null || !"buy".equalsIgnoreCase(linearSwapPosition.getDirection());
    }
}
