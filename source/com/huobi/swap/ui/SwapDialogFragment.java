package com.huobi.swap.ui;

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
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.response.MarketDepthResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.lib.network.swap.core.util.SwapDepthType;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.view.HorizontalTradeAmountPercentEdittext;
import com.huobi.view.TradePriceEditext;
import com.huobi.view.keyboard.HuobiBottomDialogKeyboardHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.List;
import m9.t;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import qs.d0;
import rx.Observable;
import ts.g0;
import u6.g;
import us.i;

public class SwapDialogFragment extends BaseDialogFragment {
    public int A;
    public TextView B;
    public HuobiBottomDialogKeyboardHelper C;
    public BigDecimal D;
    public int E;
    public int F = 0;
    public String G;
    public MarketDepthListener H = new d();

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f81585b;

    /* renamed from: c  reason: collision with root package name */
    public TradePriceEditext f81586c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f81587d;

    /* renamed from: e  reason: collision with root package name */
    public HorizontalTradeAmountPercentEdittext f81588e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f81589f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f81590g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f81591h;

    /* renamed from: i  reason: collision with root package name */
    public View f81592i;

    /* renamed from: j  reason: collision with root package name */
    public View f81593j;

    /* renamed from: k  reason: collision with root package name */
    public LoadingView f81594k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f81595l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f81596m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f81597n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f81598o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f81599p;

    /* renamed from: q  reason: collision with root package name */
    public CheckBox f81600q;

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f81601r;

    /* renamed from: s  reason: collision with root package name */
    public SwapCurrencyInfo f81602s;

    /* renamed from: t  reason: collision with root package name */
    public SwapPosition f81603t;

    /* renamed from: u  reason: collision with root package name */
    public String f81604u;

    /* renamed from: v  reason: collision with root package name */
    public String f81605v;

    /* renamed from: w  reason: collision with root package name */
    public d0 f81606w;

    /* renamed from: x  reason: collision with root package name */
    public double f81607x;

    /* renamed from: y  reason: collision with root package name */
    public double f81608y;

    /* renamed from: z  reason: collision with root package name */
    public e f81609z;

    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        public void onFocusChange(View view, boolean z11) {
            if (z11) {
                SwapDialogFragment.this.C.showKeyboard(SwapDialogFragment.this.f81589f);
            }
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            if (SwapDialogFragment.this.getActivity() != null) {
                SwapDialogFragment swapDialogFragment = SwapDialogFragment.this;
                swapDialogFragment.Mh(swapDialogFragment.f81589f, editable, false);
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
            if (SwapDialogFragment.this.getActivity() != null) {
                SwapDialogFragment swapDialogFragment = SwapDialogFragment.this;
                swapDialogFragment.Kh(swapDialogFragment.f81590g, editable, false);
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
            if (marketDepthResponse != null && SwapDialogFragment.this.f81602s != null && marketDepthResponse.getSymbol().equals(SwapDialogFragment.this.f81602s.getContractShortType())) {
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                SwapDialogFragment.this.ei(asks, 1);
                SwapDialogFragment.this.ei(bids, 0);
                if (SwapDialogFragment.this.w2()) {
                    bigDecimal = m.a(String.valueOf(SwapDialogFragment.this.f81608y));
                } else {
                    bigDecimal = m.a(String.valueOf(SwapDialogFragment.this.f81607x));
                }
                if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    SwapDialogFragment.this.f81589f.setText("");
                } else {
                    SwapDialogFragment.this.f81589f.setText(m.q(bigDecimal, i.m(SwapDialogFragment.this.f81604u)));
                }
                SwapDialogFragment.this.f81589f.setSelection(SwapDialogFragment.this.f81589f.getText().length());
                l9.a.a().F(false, SwapDialogFragment.this.f81602s.getContractShortType(), SwapDepthType.STEP6, SwapDialogFragment.this.H);
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
                SwapDialogFragment.this.dismiss();
            }
        }

        public f() {
        }

        public void onAfter() {
            super.onAfter();
            SwapDialogFragment.this.f81593j.setVisibility(8);
            SwapDialogFragment.this.f81594k.d();
            SwapDialogFragment.this.f81592i.setEnabled(true);
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
            if (SwapDialogFragment.this.Uh()) {
                HuobiToastUtil.t(j.c(), R.string.contract_trade_lightning_successful_submit);
            } else {
                HuobiToastUtil.t(j.c(), R.string.string_order_op_ok);
            }
            s6.a.b(j.c()).c(R.raw.order_success);
            EventBus.d().k(new ContractAssetAndOrderUpdateEvent());
            i6.i.b().g(new a(), 10);
        }

        public void onStart() {
            super.onStart();
            SwapDialogFragment.this.f81593j.setVisibility(0);
            SwapDialogFragment.this.f81592i.setEnabled(false);
            SwapDialogFragment.this.f81594k.c();
        }

        public /* synthetic */ f(SwapDialogFragment swapDialogFragment, a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vh(View view, boolean z11) {
        this.f81586c.setBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_5_radius_bg : R.drawable.custom_edittext_normal_5_radius_bg);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wh(View view, boolean z11) {
        this.f81588e.setBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_5_radius_bg : R.drawable.custom_edittext_normal_5_radius_bg);
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
            this.f81590g.setText("");
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
        this.C.hideKeyboard();
        String str = "";
        String charSequence = this.f81589f.getHint() == null ? str : this.f81589f.getHint().toString();
        if (this.f81590g.getHint() != null) {
            str = this.f81590g.getHint().toString();
        }
        ai(charSequence, str, this.f81589f.getText().toString(), this.f81590g.getText().toString(), 2, Uh() ? 6 : 1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Bf() {
        this.f81589f.clearFocus();
        this.f81590g.clearFocus();
    }

    public void Kh(EditText editText, Editable editable, boolean z11) {
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_regular));
            this.G = editText.getText().toString();
            Nh();
            return;
        }
        editText.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_medium));
        String str = null;
        if (a7.e.E(TradeType.SWAP)) {
            if (this.f81588e.getAmountType() == 0) {
                str = m.b(editable, 10, i.k(this.f81604u));
            }
            if (str != null) {
                editText.setText(str);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else {
            if (this.f81588e.getAmountType() == 0) {
                if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
                    str = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
                } else {
                    str = m.b(editable, 10, i.l(this.f81604u));
                }
            }
            if (str != null) {
                editText.setText(str);
                editText.setSelection(editText.getText().length());
                return;
            }
        }
        if (this.f81588e.getAmountType() == 0) {
            this.G = editText.getText().toString();
        }
        Nh();
    }

    public void Lh(boolean z11) {
        BigDecimal bigDecimal;
        BigDecimal Th = Th();
        SwapCurrencyInfo swapCurrencyInfo = this.f81602s;
        if (swapCurrencyInfo == null) {
            bigDecimal = BigDecimal.ZERO;
        } else {
            bigDecimal = m.a(swapCurrencyInfo.getContractFace());
        }
        di(Th, bigDecimal);
        if (z11) {
            Ph(this.f81589f.getText().toString());
        }
        if (!TextUtils.isEmpty(this.f81590g.getText())) {
            bi(this.E);
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
            String b11 = m.b(editable, 10, i.m(this.f81604u));
            if (b11 != null) {
                editText.setText(b11);
                editText.setSelection(editText.getText().length());
                return;
            }
        }
        Lh(z11);
    }

    public final void Nh() {
        if (TextUtils.isEmpty(this.f81589f.getText()) || TextUtils.isEmpty(this.f81590g.getText())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("-- " + this.f81603t.getSymbol());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.baseColorSecondaryText)), 0, spannableStringBuilder.length(), 33);
        } else if ("buy".equalsIgnoreCase(this.f81603t.getDirection())) {
            a7.b.a(this.f81603t.getCostOpen(), this.f81589f.getText().toString(), this.f81602s.getContractFace(), this.G, "--", TradeType.SWAP);
        } else {
            a7.b.c(this.f81603t.getCostOpen(), this.f81589f.getText().toString(), this.f81602s.getContractFace(), this.G, "--", TradeType.SWAP);
        }
    }

    public boolean Oh(String str) {
        return m.a(str).compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean Ph(String str) {
        return m.a(str).compareTo(BigDecimal.ZERO) > 0;
    }

    public String Qh(String str) {
        return (TextUtils.isEmpty(str) || InstructionFileId.DOT.equals(str) || "usd".equals(LegalCurrencyConfigUtil.y())) ? "" : LegalCurrencyConfigUtil.B(str);
    }

    public final String Rh() {
        String str;
        SwapPosition swapPosition = this.f81603t;
        if (swapPosition == null) {
            str = null;
        } else {
            str = swapPosition.getLastPrice();
        }
        if (str == null) {
            str = t.b().c(this.f81605v);
        }
        return m.a(str).toPlainString();
    }

    public final Observable<Object> Sh(ContractOrderPlace contractOrderPlace) {
        if (Uh()) {
            return this.f81606w.R(contractOrderPlace, this.f81602s).compose(RxJavaHelper.t((g) null));
        }
        return this.f81606w.Y(contractOrderPlace, this.f81602s).compose(RxJavaHelper.t((g) null));
    }

    public final BigDecimal Th() {
        return m.a(this.f81589f.getText().toString());
    }

    public boolean Uh() {
        return this.A == 1;
    }

    public final void Yh(SwapPosition swapPosition) {
        if (swapPosition != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(getString(Uh() ? R.string.contract_trade_position_close_quick : R.string.contract_trade_position_close));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.global_main_text_color)), 0, spannableStringBuilder.length(), 33);
            this.f81596m.setText(spannableStringBuilder.append("").append(us.j.e(swapPosition.getSymbol(), swapPosition.getDirection(), swapPosition.getLeverRate(), getContext())));
        }
    }

    public final void Zh(ContractOrderPlace contractOrderPlace) {
        if (contractOrderPlace.Y()) {
            Sh(contractOrderPlace).subscribe(new f(this, (a) null));
        }
    }

    public void addEvent(r rVar) {
        this.f81586c.setOnEditTextFocusChangeListener(new ts.f(this));
        this.f81588e.setOnEditTextFocusChangeListener(new ts.e(this));
        this.f81588e.setAmountCallback(new ts.d(this));
        this.f81595l.setOnClickListener(new ts.b(this));
        this.f81589f.addTextChangedListener(new b());
        this.f81590g.addTextChangedListener(new c());
        this.f81601r.setOnClickListener(new ts.c(this));
    }

    public void afterInit() {
        Yh(this.f81603t);
        d2(i.m(this.f81604u));
        if (Uh()) {
            this.f81589f.setText(m.m(Rh(), i.m(this.f81604u)));
            this.f81588e.setAmountType(4);
        } else if (this.f81602s != null) {
            l9.a.a().F(true, this.f81602s.getContractShortType(), SwapDepthType.STEP6, this.H);
        }
    }

    public void ai(String str, String str2, String str3, String str4, int i11, int i12) {
        ContractOrderPlace contractOrderPlace;
        if (i12 != 1) {
            if (Uh()) {
                str3 = Rh();
            } else if (w2()) {
                str3 = BigDecimal.valueOf(this.f81608y).toPlainString();
            } else {
                str3 = BigDecimal.valueOf(this.f81607x).toPlainString();
            }
        }
        if (i12 == 1 && !Ph(str3)) {
            HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{str}));
        } else if (this.f81588e.getAmountType() != 0 || Oh(str4)) {
            ContractOrderPlace contractOrderPlace2 = new ContractOrderPlace();
            contractOrderPlace2.N0(this.f81604u);
            contractOrderPlace2.B0(str3);
            contractOrderPlace2.d0(str4);
            contractOrderPlace2.h0(w2());
            contractOrderPlace2.A0(i11);
            contractOrderPlace2.X0(i12);
            contractOrderPlace2.g0(this.f81588e.getAmountType());
            contractOrderPlace2.E0(this.E);
            if (w2()) {
                contractOrderPlace2.W0(getString(R.string.contract_trade_buy_flat_empty));
            } else {
                contractOrderPlace2.W0(getString(R.string.contract_trade_sell_flat_more));
            }
            SwapPosition swapPosition = this.f81603t;
            if (swapPosition != null) {
                contractOrderPlace2.s0(swapPosition.getLeverRate());
            }
            contractOrderPlace2.x0(getString(R.string.contract_trade_position_close_quick));
            if (this.f81602s != null) {
                if (Uh()) {
                    contractOrderPlace = this.f81606w.v(getActivity(), contractOrderPlace2, this.f81602s);
                } else {
                    contractOrderPlace = this.f81606w.x(getContext(), contractOrderPlace2, this.f81602s);
                }
                Zh(contractOrderPlace);
            }
        } else {
            HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{str2}));
        }
    }

    public final void bi(int i11) {
        String str;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        if (this.f81588e.getAmountType() != 0) {
            this.E = i11;
            BigDecimal Th = Th();
            BigDecimal bigDecimal3 = this.D;
            if (bigDecimal3 == null || bigDecimal3.compareTo(BigDecimal.ZERO) == 0) {
                this.G = "0";
                EditText editText = this.f81590g;
                editText.setText(i11 + "%");
                return;
            }
            TradeType tradeType = TradeType.SWAP;
            if (a7.e.E(tradeType)) {
                BigDecimal divide = this.D.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                if (divide.compareTo(BigDecimal.ONE) >= 0 || divide.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal2 = divide.setScale(i.b(this.f81604u), 1);
                } else {
                    bigDecimal2 = BigDecimal.ONE;
                }
                str = m.a(FutureUnitUtil.d(bigDecimal2.toPlainString(), Th.toPlainString(), this.f81602s.getContractFace(), tradeType)).setScale(i.c(this.f81604u), 1).toPlainString();
                this.G = bigDecimal2.toPlainString();
            } else {
                BigDecimal divide2 = this.D.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                if (divide2.compareTo(BigDecimal.ONE) >= 0 || divide2.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal = divide2.setScale(i.b(this.f81604u), 1);
                } else {
                    bigDecimal = BigDecimal.ONE;
                }
                String plainString = bigDecimal.toPlainString();
                this.G = bigDecimal.toPlainString();
                str = plainString;
            }
            if (TextUtils.isEmpty(str) || m.a(str).compareTo(BigDecimal.ZERO) == 0) {
                EditText editText2 = this.f81590g;
                editText2.setText(i11 + "%");
                return;
            }
            EditText editText3 = this.f81590g;
            editText3.setText(i11 + "%(≈ " + str + ")");
        }
    }

    public final void ci(String str, int i11) {
        if (!TextUtils.isEmpty(str)) {
            this.f81587d.setText(str);
        }
        this.f81587d.setVisibility(i11);
    }

    public void d2(int i11) {
        this.f81586c.setLength(i11);
    }

    public final void di(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        BigDecimal bigDecimal5;
        boolean E2 = a7.e.E(TradeType.SWAP);
        SwapPosition swapPosition = this.f81603t;
        if (swapPosition == null) {
            bigDecimal3 = BigDecimal.ZERO;
        } else {
            bigDecimal3 = m.a(swapPosition.getAvailable());
        }
        this.D = bigDecimal3;
        if (!E2) {
            if (this.f81603t == null) {
                bigDecimal4 = BigDecimal.ZERO;
            } else {
                bigDecimal4 = new BigDecimal(this.f81603t.getAvailable());
            }
            BigDecimal scale = bigDecimal4.setScale(i.b(this.f81604u), 1);
            ci(String.format(getActivity().getString(R.string.n_contract_trade_close_margin_available), new Object[]{scale.toPlainString(), getActivity().getString(R.string.contract_market_vol_sheet)}), 8);
        } else if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            ci("", 8);
        } else {
            if (this.f81603t == null) {
                bigDecimal5 = BigDecimal.ZERO;
            } else {
                bigDecimal5 = new BigDecimal(this.f81603t.getAvailable()).multiply(bigDecimal2).divide(bigDecimal, i.c(this.f81604u), 1);
            }
            ci(String.format(getActivity().getString(R.string.n_contract_trade_close_margin_available), new Object[]{bigDecimal5.toPlainString(), this.f81604u}), 8);
        }
    }

    public void dismiss() {
        e eVar = this.f81609z;
        if (eVar != null) {
            eVar.a();
        }
        super.dismiss();
    }

    public final void ei(List<Double[]> list, int i11) {
        if (list == null || list.isEmpty()) {
            if (i11 == 0) {
                this.f81607x = 0.0d;
            } else {
                this.f81608y = 0.0d;
            }
        } else if (i11 == 0) {
            this.f81607x = list.get(0)[0].doubleValue();
        } else {
            this.f81608y = list.get(0)[0].doubleValue();
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
        int m11 = i.m(this.f81604u);
        m.a(this.f81603t.getCostOpen()).setScale(m11, 1);
        m.a(this.f81603t.getLastPrice()).setScale(m11, 1);
        i.s(this.f81604u);
        m.a(this.f81603t.getProfitRate()).multiply(m.f68179a).toPlainString();
        Nh();
    }

    public void initView(r rVar) {
        this.f81585b = (LinearLayout) rVar.b(R.id.ll_root);
        TradePriceEditext tradePriceEditext = (TradePriceEditext) rVar.b(R.id.dialog_contract_price_et);
        this.f81586c = tradePriceEditext;
        TradeType tradeType = TradeType.SWAP;
        tradePriceEditext.setTradeType(tradeType);
        this.B = (TextView) rVar.b(R.id.dialog_contract_price_hint_et);
        this.f81589f = this.f81586c.getEditText();
        HorizontalTradeAmountPercentEdittext horizontalTradeAmountPercentEdittext = (HorizontalTradeAmountPercentEdittext) rVar.b(R.id.dialog_contract_amount_et);
        this.f81588e = horizontalTradeAmountPercentEdittext;
        horizontalTradeAmountPercentEdittext.setTradeType(tradeType);
        if (a7.e.E(tradeType)) {
            this.f81588e.setLabel(this.f81604u);
        } else {
            this.f81588e.setLabel((int) R.string.contract_trade_unit_sheet);
        }
        this.f81590g = this.f81588e.getEditText();
        this.f81591h = (TextView) rVar.b(R.id.dialog_position_trade_tv);
        this.f81592i = rVar.b(R.id.dialog_position_trade);
        this.f81593j = rVar.b(R.id.dialog_loading);
        LoadingView loadingView = (LoadingView) rVar.b(R.id.loading_dialog_loading_view);
        this.f81594k = loadingView;
        loadingView.setLottieAnimationRes(R.raw.nd_middle_bg);
        this.f81606w = new d0((g0) null);
        this.f81595l = rVar.c(R.id.iv_close);
        this.f81596m = (TextView) rVar.b(R.id.tv_contract);
        this.f81597n = (TextView) rVar.b(R.id.tv_times);
        this.f81598o = (TextView) rVar.b(R.id.tv_hint);
        this.f81599p = (TextView) rVar.b(R.id.tv_hint_desc);
        this.f81600q = (CheckBox) rVar.b(R.id.agreement_cb);
        this.f81601r = (LinearLayout) rVar.b(R.id.dialog_position_trade);
        this.f81587d = (TextView) rVar.b(R.id.dialog_contract_position_tv);
        TradePriceEditext tradePriceEditext2 = (TradePriceEditext) rVar.b(R.id.dialog_contract_price_et);
        this.f81586c = tradePriceEditext2;
        tradePriceEditext2.setTradeType(TradeType.CONTRACT);
        this.B = (TextView) rVar.b(R.id.dialog_contract_price_hint_et);
        gi();
        this.C = new HuobiBottomDialogKeyboardHelper();
        this.f81589f.setOnFocusChangeListener(new a());
        this.f81588e.setKeyboardHelper(this.C);
        if (!(this.f81603t == null || this.f81602s == null)) {
            d0 d0Var = this.f81606w;
            d0Var.W(this.f81602s.getContractCode() + this.f81603t.getDirection(), this.f81603t);
        }
        this.f81598o.setText(getResources().getString(R.string.n_contract_trade_lightning_alert_confirm_content));
        this.f81599p.setText(getResources().getString(R.string.n_contract_trade_lightning_alert_confirm_note));
    }

    public boolean isTransparent() {
        return false;
    }

    public final boolean w2() {
        SwapPosition swapPosition = this.f81603t;
        return swapPosition == null || !"buy".equalsIgnoreCase(swapPosition.getDirection());
    }
}
