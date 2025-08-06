package com.huobi.contract.ui;

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
import bj.d1;
import bj.n0;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.util.ContractDepthType;
import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.response.MarketDepthResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.view.HorizontalTradeAmountPercentEdittext;
import com.huobi.view.TradePriceEditext;
import com.huobi.view.keyboard.HuobiBottomDialogKeyboardHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.h;
import dj.k;
import dj.l;
import i6.i;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.Observable;
import u6.g;

public class ContractDialogFragment extends BaseDialogFragment {
    public TextView A;
    public HuobiBottomDialogKeyboardHelper B;
    public BigDecimal C;
    public int D;
    public int E = 0;
    public String F;
    public MarketDepthListener G = new d();

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f43206b;

    /* renamed from: c  reason: collision with root package name */
    public TradePriceEditext f43207c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f43208d;

    /* renamed from: e  reason: collision with root package name */
    public HorizontalTradeAmountPercentEdittext f43209e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f43210f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f43211g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f43212h;

    /* renamed from: i  reason: collision with root package name */
    public View f43213i;

    /* renamed from: j  reason: collision with root package name */
    public View f43214j;

    /* renamed from: k  reason: collision with root package name */
    public LoadingView f43215k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f43216l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f43217m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f43218n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f43219o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f43220p;

    /* renamed from: q  reason: collision with root package name */
    public CheckBox f43221q;

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f43222r;

    /* renamed from: s  reason: collision with root package name */
    public ContractCurrencyInfo f43223s;

    /* renamed from: t  reason: collision with root package name */
    public ContractPosition f43224t;

    /* renamed from: u  reason: collision with root package name */
    public String f43225u;

    /* renamed from: v  reason: collision with root package name */
    public d1 f43226v;

    /* renamed from: w  reason: collision with root package name */
    public double f43227w;

    /* renamed from: x  reason: collision with root package name */
    public double f43228x;

    /* renamed from: y  reason: collision with root package name */
    public e f43229y;

    /* renamed from: z  reason: collision with root package name */
    public int f43230z;

    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        public void onFocusChange(View view, boolean z11) {
            if (z11) {
                ContractDialogFragment.this.B.showKeyboard(ContractDialogFragment.this.f43210f);
            }
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            if (ContractDialogFragment.this.getActivity() != null) {
                ContractDialogFragment contractDialogFragment = ContractDialogFragment.this;
                contractDialogFragment.Mh(contractDialogFragment.f43210f, editable, false);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
            if (ContractDialogFragment.this.getActivity() != null) {
                ContractDialogFragment contractDialogFragment = ContractDialogFragment.this;
                contractDialogFragment.Kh(contractDialogFragment.f43211g, editable, false);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class d extends MarketDepthListener {
        public d() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            BigDecimal bigDecimal;
            if (marketDepthResponse != null && ContractDialogFragment.this.f43223s != null && marketDepthResponse.getSymbol().equals(ContractDialogFragment.this.f43223s.getContractShortType())) {
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                ContractDialogFragment.this.ei(asks, 1);
                ContractDialogFragment.this.ei(bids, 0);
                if (ContractDialogFragment.this.w2()) {
                    bigDecimal = m.a(String.valueOf(ContractDialogFragment.this.f43228x));
                } else {
                    bigDecimal = m.a(String.valueOf(ContractDialogFragment.this.f43227w));
                }
                if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    ContractDialogFragment.this.f43210f.setText("");
                } else {
                    ContractDialogFragment.this.f43210f.setText(m.q(bigDecimal, ej.f.p(ContractDialogFragment.this.f43224t.getContractCode())));
                }
                ContractDialogFragment.this.f43210f.setSelection(ContractDialogFragment.this.f43210f.getText().length());
                q7.a.a().B(false, ContractDialogFragment.this.f43223s.getContractShortType(), ContractDepthType.STEP6, ContractDialogFragment.this.G);
            }
        }
    }

    public interface e {
        void a();
    }

    public class f extends EasySubscriber<Object> {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                ContractDialogFragment.this.dismiss();
            }
        }

        public f() {
        }

        public void onAfter() {
            super.onAfter();
            ContractDialogFragment.this.f43214j.setVisibility(8);
            ContractDialogFragment.this.f43215k.d();
            ContractDialogFragment.this.f43213i.setEnabled(true);
        }

        public void onError2(Throwable th2) {
            if (!NetworkStatus.c(BaseApplication.b())) {
                HuobiToastUtil.j(R.string.n_no_network);
            } else {
                HuobiToastUtil.k(BaseApplication.b(), R.string.string_order_op_fail);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            aPIStatusErrorException.getErrCode().hashCode();
            if (TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                HuobiToastUtil.k(j.c(), R.string.string_order_op_fail);
            } else {
                HuobiToastUtil.l(j.c(), aPIStatusErrorException.getErrMsg());
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            if (ContractDialogFragment.this.Uh()) {
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
            ContractDialogFragment.this.f43214j.setVisibility(0);
            ContractDialogFragment.this.f43213i.setEnabled(false);
            ContractDialogFragment.this.f43215k.c();
        }

        public /* synthetic */ f(ContractDialogFragment contractDialogFragment, a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vh(View view, boolean z11) {
        this.f43207c.setBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_5_radius_bg : R.drawable.custom_edittext_normal_5_radius_bg);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wh(View view, boolean z11) {
        this.f43209e.setBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_5_radius_bg : R.drawable.custom_edittext_normal_5_radius_bg);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xh(int i11) {
        if (i11 == 1) {
            bi(10);
            Bf();
        } else if (i11 == 2) {
            bi(20);
            Bf();
        } else if (i11 == 3) {
            bi(50);
            Bf();
        } else if (i11 != 4) {
            this.f43211g.setText("");
        } else {
            bi(100);
            Bf();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        this.B.hideKeyboard();
        Bf();
        String str = "";
        String charSequence = this.f43210f.getHint() == null ? str : this.f43210f.getHint().toString();
        if (this.f43211g.getHint() != null) {
            str = this.f43211g.getHint().toString();
        }
        ai(charSequence, str, this.f43210f.getText().toString(), this.f43211g.getText().toString(), 2, Uh() ? 6 : 1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Bf() {
        this.f43210f.clearFocus();
        this.f43211g.clearFocus();
    }

    public void Kh(EditText editText, Editable editable, boolean z11) {
        if (editable == null || editable.length() == 0) {
            this.F = editText.getText().toString();
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
            Nh();
            return;
        }
        editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        String str = null;
        if (a7.e.E(TradeType.CONTRACT)) {
            if (this.f43209e.getAmountType() == 0) {
                str = m.b(editable, 10, ej.f.n(this.f43224t.getContractCode()));
            }
            if (str != null) {
                editText.setText(str);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else {
            if (this.f43209e.getAmountType() == 0) {
                if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
                    str = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
                } else {
                    str = m.b(editable, 10, ej.f.g(this.f43225u));
                }
            }
            if (str != null) {
                editText.setText(str);
                editText.setSelection(editText.getText().length());
                return;
            }
        }
        if (this.f43209e.getAmountType() == 0) {
            this.F = editText.getText().toString();
        }
        Nh();
    }

    public void Lh(boolean z11) {
        BigDecimal bigDecimal;
        BigDecimal Th = Th();
        ContractCurrencyInfo contractCurrencyInfo = this.f43223s;
        if (contractCurrencyInfo == null) {
            bigDecimal = BigDecimal.ZERO;
        } else {
            bigDecimal = m.a(contractCurrencyInfo.getContractFace());
        }
        di(Th, bigDecimal);
        if (z11) {
            Ph(this.f43210f.getText().toString());
        }
        if (!TextUtils.isEmpty(this.f43211g.getText())) {
            bi(this.D);
        }
        Nh();
    }

    public void Mh(EditText editText, Editable editable, boolean z11) {
        if (!Uh()) {
            fi(Qh(editable.toString()));
            if (editable.length() == 0) {
                editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
            } else {
                editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
            }
            String b11 = m.b(editable, 10, ej.f.p(this.f43224t.getContractCode()));
            if (b11 != null) {
                editText.setText(b11);
                editText.setSelection(editText.getText().length());
                return;
            }
        }
        Lh(z11);
    }

    public final void Nh() {
        if (TextUtils.isEmpty(this.f43210f.getText()) || TextUtils.isEmpty(this.f43211g.getText())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("-- " + this.f43224t.getSymbol());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.baseColorSecondaryText)), 0, spannableStringBuilder.length(), 33);
        } else if ("buy".equalsIgnoreCase(this.f43224t.getDirection())) {
            a7.b.a(this.f43224t.getCostOpen(), this.f43210f.getText().toString(), this.f43223s.getContractFace(), this.F, "--", TradeType.CONTRACT);
        } else {
            a7.b.c(this.f43224t.getCostOpen(), this.f43210f.getText().toString(), this.f43223s.getContractFace(), this.F, "--", TradeType.CONTRACT);
        }
    }

    public boolean Oh(String str) {
        return m.a(str).compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean Ph(String str) {
        return m.a(str).compareTo(BigDecimal.ZERO) > 0;
    }

    public String Qh(String str) {
        return (TextUtils.isEmpty(str) || InstructionFileId.DOT.equals(str) || TextUtils.equals(LegalCurrencyConfigUtil.y(), "usd")) ? "" : LegalCurrencyConfigUtil.B(str);
    }

    public final String Rh() {
        String str;
        ContractPosition contractPosition = this.f43224t;
        if (contractPosition == null) {
            str = null;
        } else {
            str = contractPosition.getLastPrice();
        }
        if (str == null) {
            str = n0.b().c(this.f43225u);
        }
        return m.a(str).toPlainString();
    }

    public final Observable<Object> Sh(ContractOrderPlace contractOrderPlace) {
        if (Uh()) {
            return this.f43226v.M(contractOrderPlace, this.f43223s).compose(RxJavaHelper.t((g) null));
        }
        return this.f43226v.q(contractOrderPlace, this.f43223s).compose(RxJavaHelper.t((g) null));
    }

    public final BigDecimal Th() {
        return m.a(this.f43210f.getText().toString());
    }

    public boolean Uh() {
        return this.f43230z == 1;
    }

    public final void Yh(ContractPosition contractPosition) {
        if (contractPosition != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(getString(Uh() ? R.string.contract_trade_position_close_quick : R.string.contract_trade_position_close));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.global_main_text_color)), 0, spannableStringBuilder.length(), 33);
            this.f43217m.setText(spannableStringBuilder.append("").append(ej.g.m(contractPosition.getSymbol(), contractPosition.getDirection(), contractPosition.getContractCode(), contractPosition.getLeverRate(), contractPosition.getContractCurrencyInfo().getContractShortType(), getActivity())));
        }
    }

    public final void Zh(ContractOrderPlace contractOrderPlace) {
        if (contractOrderPlace.Y()) {
            Sh(contractOrderPlace).subscribe(new f(this, (a) null));
        }
    }

    public void addEvent(r rVar) {
        this.f43207c.setOnEditTextFocusChangeListener(new k(this));
        this.f43209e.setOnEditTextFocusChangeListener(new l(this));
        this.f43209e.setAmountCallback(new dj.j(this));
        this.f43216l.setOnClickListener(new dj.i(this));
        this.f43210f.addTextChangedListener(new b());
        this.f43211g.addTextChangedListener(new c());
        this.f43222r.setOnClickListener(new h(this));
    }

    public void afterInit() {
        Yh(this.f43224t);
        d2(ej.f.p(this.f43224t.getContractCode()));
        if (Uh()) {
            this.f43210f.setText(m.m(Rh(), ej.f.p(this.f43224t.getContractCode())));
            this.f43209e.setAmountType(4);
        } else if (this.f43223s != null) {
            q7.a.a().B(true, this.f43223s.getContractShortType(), ContractDepthType.STEP6, this.G);
        }
    }

    public void ai(String str, String str2, String str3, String str4, int i11, int i12) {
        ContractOrderPlace contractOrderPlace;
        if (i12 != 1) {
            if (Uh()) {
                str3 = Rh();
            } else if (w2()) {
                str3 = BigDecimal.valueOf(this.f43228x).toPlainString();
            } else {
                str3 = BigDecimal.valueOf(this.f43227w).toPlainString();
            }
        }
        if (i12 == 1 && !Ph(str3)) {
            HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{str}));
        } else if (this.f43209e.getAmountType() != 0 || Oh(str4)) {
            ContractOrderPlace contractOrderPlace2 = new ContractOrderPlace();
            contractOrderPlace2.N0(this.f43225u);
            contractOrderPlace2.B0(str3);
            contractOrderPlace2.d0(str4);
            contractOrderPlace2.h0(w2());
            contractOrderPlace2.A0(i11);
            contractOrderPlace2.X0(i12);
            contractOrderPlace2.g0(this.f43209e.getAmountType());
            contractOrderPlace2.E0(this.D);
            if (w2()) {
                contractOrderPlace2.W0(getString(R.string.contract_trade_buy_flat_empty));
            } else {
                contractOrderPlace2.W0(getString(R.string.contract_trade_sell_flat_more));
            }
            ContractPosition contractPosition = this.f43224t;
            if (contractPosition != null) {
                contractOrderPlace2.s0(contractPosition.getLeverRate());
            }
            contractOrderPlace2.x0(getString(R.string.contract_trade_position_close_quick));
            if (Uh()) {
                contractOrderPlace = this.f43226v.P(getActivity(), contractOrderPlace2, this.f43223s);
            } else {
                contractOrderPlace = this.f43226v.N(getActivity(), contractOrderPlace2, this.f43223s);
            }
            Zh(contractOrderPlace);
        } else {
            HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{str2}));
        }
    }

    public final void bi(int i11) {
        String str;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        if (this.f43209e.getAmountType() != 0) {
            this.D = i11;
            BigDecimal Th = Th();
            BigDecimal bigDecimal3 = this.C;
            if (bigDecimal3 == null || bigDecimal3.compareTo(BigDecimal.ZERO) == 0) {
                this.F = "0";
                EditText editText = this.f43211g;
                editText.setText(i11 + "%");
                return;
            }
            TradeType tradeType = TradeType.CONTRACT;
            if (a7.e.E(tradeType)) {
                BigDecimal divide = this.C.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                if (divide.compareTo(BigDecimal.ONE) >= 0 || divide.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal2 = divide.setScale(ej.f.t(this.f43225u), 1);
                } else {
                    bigDecimal2 = BigDecimal.ONE;
                }
                str = m.a(FutureUnitUtil.d(bigDecimal2.toPlainString(), Th.toPlainString(), this.f43223s.getContractFace(), tradeType)).setScale(ej.f.n(this.f43223s.getContractCode()), 1).toPlainString();
                this.F = bigDecimal2.toPlainString();
            } else {
                BigDecimal divide2 = this.C.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                if (divide2.compareTo(BigDecimal.ONE) >= 0 || divide2.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal = divide2.setScale(ej.f.t(this.f43225u), 1);
                } else {
                    bigDecimal = BigDecimal.ONE;
                }
                String plainString = bigDecimal.toPlainString();
                this.F = bigDecimal.toPlainString();
                str = plainString;
            }
            if (TextUtils.isEmpty(str) || m.a(str).compareTo(BigDecimal.ZERO) == 0) {
                EditText editText2 = this.f43211g;
                editText2.setText(i11 + "%");
                return;
            }
            EditText editText3 = this.f43211g;
            editText3.setText(i11 + "%(≈ " + str + ")");
        }
    }

    public final void ci(String str, int i11) {
        if (!TextUtils.isEmpty(str)) {
            this.f43208d.setText(str);
        }
        this.f43208d.setVisibility(i11);
    }

    public void d2(int i11) {
        this.f43207c.setLength(i11);
    }

    public final void di(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        BigDecimal bigDecimal5;
        boolean E2 = a7.e.E(TradeType.CONTRACT);
        ContractPosition contractPosition = this.f43224t;
        if (contractPosition == null) {
            bigDecimal3 = BigDecimal.ZERO;
        } else {
            bigDecimal3 = m.a(contractPosition.getAvailable());
        }
        this.C = bigDecimal3;
        if (!E2) {
            if (this.f43224t == null) {
                bigDecimal4 = BigDecimal.ZERO;
            } else {
                bigDecimal4 = new BigDecimal(this.f43224t.getAvailable());
            }
            BigDecimal scale = bigDecimal4.setScale(ej.f.c(this.f43225u), 1);
            ci(String.format(getActivity().getString(R.string.n_contract_trade_close_margin_available), new Object[]{scale.toPlainString(), getActivity().getString(R.string.contract_market_vol_sheet)}), 8);
        } else if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            ci("", 8);
        } else {
            if (this.f43224t == null) {
                bigDecimal5 = BigDecimal.ZERO;
            } else {
                bigDecimal5 = new BigDecimal(this.f43224t.getAvailable()).multiply(bigDecimal2).divide(bigDecimal, ej.f.n(this.f43224t.getContractCode()), 1);
            }
            ci(String.format(getActivity().getString(R.string.n_contract_trade_close_margin_available), new Object[]{bigDecimal5.toPlainString(), this.f43225u}), 8);
        }
    }

    public void dismiss() {
        e eVar = this.f43229y;
        if (eVar != null) {
            eVar.a();
        }
        super.dismiss();
    }

    public final void ei(List<Double[]> list, int i11) {
        if (list == null || list.isEmpty()) {
            if (i11 == 0) {
                this.f43227w = 0.0d;
            } else {
                this.f43228x = 0.0d;
            }
        } else if (i11 == 0) {
            this.f43227w = list.get(0)[0].doubleValue();
        } else {
            this.f43228x = list.get(0)[0].doubleValue();
        }
    }

    public void fi(String str) {
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.dialog_contract_trade;
    }

    public int getGravity() {
        return 17;
    }

    public final void gi() {
        int p11 = ej.f.p(this.f43224t.getContractCode());
        m.a(this.f43224t.getCostOpen()).setScale(p11, 1);
        m.a(this.f43224t.getLastPrice()).setScale(p11, 1);
        ej.f.i(this.f43224t.getSymbol());
        m.a(this.f43224t.getProfitRate()).multiply(m.f68179a).toPlainString();
        Nh();
    }

    public void initView(r rVar) {
        this.f43206b = (LinearLayout) rVar.b(R.id.ll_root);
        TradePriceEditext tradePriceEditext = (TradePriceEditext) rVar.b(R.id.dialog_contract_price_et);
        this.f43207c = tradePriceEditext;
        TradeType tradeType = TradeType.CONTRACT;
        tradePriceEditext.setTradeType(tradeType);
        this.A = (TextView) rVar.b(R.id.dialog_contract_price_hint_et);
        this.f43210f = this.f43207c.getEditText();
        HorizontalTradeAmountPercentEdittext horizontalTradeAmountPercentEdittext = (HorizontalTradeAmountPercentEdittext) rVar.b(R.id.dialog_contract_amount_et);
        this.f43209e = horizontalTradeAmountPercentEdittext;
        horizontalTradeAmountPercentEdittext.setTradeType(tradeType);
        if (a7.e.E(tradeType)) {
            this.f43209e.setLabel(this.f43225u);
        } else {
            this.f43209e.setLabel((int) R.string.contract_trade_unit_sheet);
        }
        this.f43211g = this.f43209e.getEditText();
        this.f43208d = (TextView) rVar.b(R.id.dialog_contract_position_tv);
        this.f43212h = (TextView) rVar.b(R.id.dialog_position_trade_tv);
        this.f43213i = rVar.b(R.id.dialog_position_trade);
        this.f43214j = rVar.b(R.id.dialog_loading);
        this.f43216l = rVar.c(R.id.iv_close);
        this.f43217m = (TextView) rVar.b(R.id.tv_contract);
        this.f43218n = (TextView) rVar.b(R.id.tv_times);
        this.f43219o = (TextView) rVar.b(R.id.tv_hint);
        this.f43220p = (TextView) rVar.b(R.id.tv_hint_desc);
        this.f43221q = (CheckBox) rVar.b(R.id.agreement_cb);
        this.f43222r = (LinearLayout) rVar.b(R.id.dialog_position_trade);
        gi();
        LoadingView loadingView = (LoadingView) rVar.b(R.id.loading_dialog_loading_view);
        this.f43215k = loadingView;
        loadingView.setLottieAnimationRes(R.raw.nd_middle_bg);
        this.f43226v = new d1((dj.n0) null);
        this.B = new HuobiBottomDialogKeyboardHelper();
        this.f43210f.setOnFocusChangeListener(new a());
        this.f43209e.setKeyboardHelper(this.B);
        if (!(this.f43224t == null || this.f43223s == null)) {
            d1 d1Var = this.f43226v;
            d1Var.T(this.f43223s.getContractCode() + this.f43224t.getDirection(), this.f43224t);
        }
        this.f43219o.setText(getResources().getString(R.string.n_contract_trade_lightning_alert_confirm_content));
        this.f43220p.setText(getResources().getString(R.string.n_contract_trade_lightning_alert_confirm_note));
    }

    public boolean isTransparent() {
        return false;
    }

    public final boolean w2() {
        ContractPosition contractPosition = this.f43224t;
        return contractPosition == null || !"buy".equalsIgnoreCase(contractPosition.getDirection());
    }
}
