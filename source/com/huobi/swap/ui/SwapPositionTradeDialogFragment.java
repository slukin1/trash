package com.huobi.swap.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import bj.p0;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.PixelUtils;
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
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.network.swap.core.util.SwapDepthType;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.TransparentListPopupDialog;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.hbg.lib.widgets.dialog.bean.FutureInsideConfirmItem;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.swap.bean.SwapPositionItem;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.utils.n0;
import com.huobi.view.ContractTradeAmountPercentEdittext;
import com.huobi.view.TradePriceEditext;
import com.huobi.view.keyboard.HuobiBottomDialogKeyboardHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import qs.d0;
import rx.Observable;
import ts.a0;
import ts.b0;
import ts.c0;
import ts.e0;
import ts.f0;
import ts.g0;
import ts.v;
import ts.w;
import ts.x;
import ts.y;
import ts.z;

public class SwapPositionTradeDialogFragment extends BaseDialogFragment implements CommonPopListItem.a {
    public ImageView A;
    public TextView B;
    public View C;
    public View D;
    public int E;
    public int F;
    public SwapCurrencyInfo G;
    public SwapPosition H;
    public String I;
    public String J;
    public d0 K;
    public double L;
    public double M;
    public i N;
    public HuobiBottomDialogKeyboardHelper O;
    public BigDecimal P;
    public int Q;
    public int R = 0;
    public String S;
    public ImageView T;
    public TextView U;
    public View V;
    public TransparentListPopupDialog W = new TransparentListPopupDialog();
    public ViewGroup X;
    public int Y;
    public int Z = 0;

    /* renamed from: a0  reason: collision with root package name */
    public BigDecimal f81675a0;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f81676b;

    /* renamed from: b0  reason: collision with root package name */
    public String f81677b0 = "";

    /* renamed from: c  reason: collision with root package name */
    public TextView f81678c;

    /* renamed from: c0  reason: collision with root package name */
    public MarketDepthListener f81679c0 = new h();

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f81680d;

    /* renamed from: e  reason: collision with root package name */
    public TradePriceEditext f81681e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f81682f;

    /* renamed from: g  reason: collision with root package name */
    public ContractTradeAmountPercentEdittext f81683g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f81684h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f81685i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f81686j;

    /* renamed from: k  reason: collision with root package name */
    public View f81687k;

    /* renamed from: l  reason: collision with root package name */
    public View f81688l;

    /* renamed from: m  reason: collision with root package name */
    public View f81689m;

    /* renamed from: n  reason: collision with root package name */
    public LoadingView f81690n;

    /* renamed from: o  reason: collision with root package name */
    public View f81691o;

    /* renamed from: p  reason: collision with root package name */
    public View f81692p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f81693q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f81694r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f81695s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f81696t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f81697u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f81698v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f81699w;

    /* renamed from: x  reason: collision with root package name */
    public View f81700x;

    /* renamed from: y  reason: collision with root package name */
    public EasyRecyclerView f81701y;

    /* renamed from: z  reason: collision with root package name */
    public View f81702z;

    public class a implements BaseDialogFragment.c {
        public a() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            SwapPositionTradeDialogFragment.this.T.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            SwapPositionTradeDialogFragment.this.T.setImageResource(R.drawable.trade_arrow_up);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SwapPositionTradeDialogFragment.this.W.showAsDropDown(SwapPositionTradeDialogFragment.this.getActivity().getSupportFragmentManager(), SwapPositionTradeDialogFragment.this.X);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommonPopListItem f81705b;

        public c(CommonPopListItem commonPopListItem) {
            this.f81705b = commonPopListItem;
        }

        public void run() {
            SwapPositionTradeDialogFragment.this.V6(this.f81705b);
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        public void onFocusChange(View view, boolean z11) {
            if (z11) {
                SwapPositionTradeDialogFragment.this.O.showKeyboard(SwapPositionTradeDialogFragment.this.f81684h);
            }
        }
    }

    public class e implements TextWatcher {
        public e() {
        }

        public void afterTextChanged(Editable editable) {
            if (SwapPositionTradeDialogFragment.this.getActivity() != null) {
                SwapPositionTradeDialogFragment swapPositionTradeDialogFragment = SwapPositionTradeDialogFragment.this;
                swapPositionTradeDialogFragment.ei(swapPositionTradeDialogFragment.f81684h, editable, false);
                if (SwapPositionTradeDialogFragment.this.Z == 0) {
                    SwapPositionTradeDialogFragment swapPositionTradeDialogFragment2 = SwapPositionTradeDialogFragment.this;
                    String unused = swapPositionTradeDialogFragment2.f81677b0 = swapPositionTradeDialogFragment2.f81684h.getText().toString();
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class f implements TextWatcher {
        public f() {
        }

        public void afterTextChanged(Editable editable) {
            if (SwapPositionTradeDialogFragment.this.getActivity() != null) {
                SwapPositionTradeDialogFragment swapPositionTradeDialogFragment = SwapPositionTradeDialogFragment.this;
                swapPositionTradeDialogFragment.ci(swapPositionTradeDialogFragment.f81685i, editable, false);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            if (SwapPositionTradeDialogFragment.this.F == 0 || SwapPositionTradeDialogFragment.this.F == SwapPositionTradeDialogFragment.this.E) {
                SwapPositionTradeDialogFragment swapPositionTradeDialogFragment = SwapPositionTradeDialogFragment.this;
                int unused = swapPositionTradeDialogFragment.F = swapPositionTradeDialogFragment.f81700x.getHeight();
            }
            SwapPositionTradeDialogFragment swapPositionTradeDialogFragment2 = SwapPositionTradeDialogFragment.this;
            swapPositionTradeDialogFragment2.vi(swapPositionTradeDialogFragment2.f81702z, SwapPositionTradeDialogFragment.this.f81700x);
        }
    }

    public class h extends MarketDepthListener {
        public h() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            BigDecimal bigDecimal;
            if (marketDepthResponse != null && SwapPositionTradeDialogFragment.this.G != null && marketDepthResponse.getSymbol().equals(SwapPositionTradeDialogFragment.this.G.getContractShortType())) {
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                SwapPositionTradeDialogFragment.this.Fi(asks, 1);
                SwapPositionTradeDialogFragment.this.Fi(bids, 0);
                if (SwapPositionTradeDialogFragment.this.w2()) {
                    bigDecimal = m.a(String.valueOf(SwapPositionTradeDialogFragment.this.M));
                } else {
                    bigDecimal = m.a(String.valueOf(SwapPositionTradeDialogFragment.this.L));
                }
                BigDecimal unused = SwapPositionTradeDialogFragment.this.f81675a0 = bigDecimal;
                SwapPositionTradeDialogFragment.this.yi(bigDecimal);
                l9.a.a().F(false, SwapPositionTradeDialogFragment.this.G.getContractShortType(), SwapDepthType.STEP6, SwapPositionTradeDialogFragment.this.f81679c0);
            }
        }
    }

    public interface i {
        void a();
    }

    public class j extends EasySubscriber<Object> {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                SwapPositionTradeDialogFragment.this.dismiss();
            }
        }

        public j() {
        }

        public void onAfter() {
            super.onAfter();
            SwapPositionTradeDialogFragment.this.f81689m.setVisibility(8);
            SwapPositionTradeDialogFragment.this.f81690n.d();
            SwapPositionTradeDialogFragment.this.f81687k.setEnabled(true);
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
                HuobiToastUtil.k(bh.j.c(), R.string.string_order_op_fail);
            } else {
                HuobiToastUtil.l(bh.j.c(), aPIStatusErrorException.getErrMsg());
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            HuobiToastUtil.t(bh.j.c(), R.string.string_order_op_ok);
            s6.a.b(bh.j.c()).c(R.raw.order_success);
            EventBus.d().k(new ContractAssetAndOrderUpdateEvent());
            i6.i.b().g(new a(), 10);
        }

        public void onStart() {
            super.onStart();
            SwapPositionTradeDialogFragment.this.f81689m.setVisibility(0);
            SwapPositionTradeDialogFragment.this.f81687k.setEnabled(false);
            SwapPositionTradeDialogFragment.this.f81690n.c();
        }

        public /* synthetic */ j(SwapPositionTradeDialogFragment swapPositionTradeDialogFragment, a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        this.O.hideKeyboard();
        String str = "";
        String charSequence = this.f81684h.getHint() == null ? str : this.f81684h.getHint().toString();
        if (this.f81685i.getHint() != null) {
            str = this.f81685i.getHint().toString();
        }
        Bi(charSequence, str, this.f81684h.getText().toString(), this.f81685i.getText().toString(), 2, this.Y);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void mi(View view, boolean z11) {
        this.f81681e.setBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_5_radius_bg : R.drawable.custom_edittext_normal_5_radius_bg);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ni(View view, boolean z11) {
        this.f81683g.setEditAreaBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_5_radius_bg : R.drawable.custom_edittext_normal_5_radius_bg);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void oi(View view) {
        this.A.setVisibility(8);
        this.B.setVisibility(8);
        this.f81688l.setVisibility(0);
        this.f81678c.setVisibility(0);
        ui(this.f81700x, this.f81702z);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void pi(View view) {
        ki((ContractOrderPlace) view.getTag(R.id.item_data)).subscribe(new j(this, (a) null));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void qi(int i11) {
        Ci(i11);
        this.f81685i.clearFocus();
        Bf();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ri() {
        this.E = this.C.getHeight();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void si(RelativeLayout.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.C.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ti(RelativeLayout.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.C.setLayoutParams(layoutParams);
    }

    public final void Ai(ContractOrderPlace contractOrderPlace) {
        if (!contractOrderPlace.Y()) {
            return;
        }
        if (p0.b()) {
            zi(contractOrderPlace);
        } else {
            ki(contractOrderPlace).subscribe(new j(this, (a) null));
        }
    }

    public final void Bf() {
        this.f81684h.clearFocus();
        this.f81685i.clearFocus();
    }

    public void Bi(String str, String str2, String str3, String str4, int i11, int i12) {
        if (i12 != 1) {
            if (w2()) {
                str3 = BigDecimal.valueOf(this.M).toPlainString();
            } else {
                str3 = BigDecimal.valueOf(this.L).toPlainString();
            }
        }
        if (i12 == 1 && !hi(str3)) {
            HuobiToastUtil.l(bh.j.c(), String.format(bh.j.c().getString(R.string.input_unknow_text), new Object[]{str}));
        } else if (this.f81683g.getAmountType() != 0 || gi(str4)) {
            ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
            contractOrderPlace.N0(this.I);
            contractOrderPlace.B0(str3);
            contractOrderPlace.d0(str4);
            contractOrderPlace.h0(w2());
            contractOrderPlace.A0(i11);
            contractOrderPlace.X0(i12);
            contractOrderPlace.g0(this.f81683g.getAmountType());
            contractOrderPlace.E0(this.Q);
            if (w2()) {
                contractOrderPlace.W0(getString(R.string.contract_trade_buy_flat_empty));
            } else {
                contractOrderPlace.W0(getString(R.string.contract_trade_sell_flat_more));
            }
            SwapPosition swapPosition = this.H;
            if (swapPosition != null) {
                contractOrderPlace.s0(swapPosition.getLeverRate());
            }
            contractOrderPlace.x0(getString(R.string.contract_trade_position_close_quick));
            if (this.G != null) {
                Ai(this.K.x(getContext(), contractOrderPlace, this.G));
            }
        } else {
            HuobiToastUtil.l(bh.j.c(), String.format(bh.j.c().getString(R.string.input_unknow_text), new Object[]{str2}));
        }
    }

    public final void Ci(int i11) {
        String str;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        if (this.f81683g.getAmountType() != 0) {
            this.Q = i11;
            BigDecimal li2 = li();
            BigDecimal bigDecimal3 = this.P;
            if (bigDecimal3 == null || bigDecimal3.compareTo(BigDecimal.ZERO) == 0) {
                this.S = "0";
                EditText editText = this.f81685i;
                editText.setText(i11 + "%");
                return;
            }
            TradeType tradeType = TradeType.SWAP;
            if (a7.e.E(tradeType)) {
                BigDecimal divide = this.P.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                if (divide.compareTo(BigDecimal.ONE) >= 0 || divide.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal2 = divide.setScale(us.i.b(this.I), 1);
                } else {
                    bigDecimal2 = BigDecimal.ONE;
                }
                str = m.a(FutureUnitUtil.d(bigDecimal2.toPlainString(), li2.toPlainString(), this.G.getContractFace(), tradeType)).setScale(us.i.c(this.I), 1).toPlainString();
                this.S = bigDecimal2.toPlainString();
            } else {
                BigDecimal divide2 = this.P.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                if (divide2.compareTo(BigDecimal.ONE) >= 0 || divide2.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal = divide2.setScale(us.i.b(this.I), 1);
                } else {
                    bigDecimal = BigDecimal.ONE;
                }
                String plainString = bigDecimal.toPlainString();
                this.S = bigDecimal.toPlainString();
                str = plainString;
            }
            if (TextUtils.isEmpty(str) || m.a(str).compareTo(BigDecimal.ZERO) == 0) {
                EditText editText2 = this.f81685i;
                editText2.setText(i11 + "%");
                return;
            }
            EditText editText3 = this.f81685i;
            editText3.setText(i11 + "%(≈ " + str + ")");
        }
    }

    public final void Di(String str, int i11) {
        if (!TextUtils.isEmpty(str)) {
            this.f81682f.setText(str);
        }
        this.f81682f.setVisibility(i11);
    }

    public final void Ei(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        BigDecimal bigDecimal5;
        boolean E2 = a7.e.E(TradeType.SWAP);
        SwapPosition swapPosition = this.H;
        if (swapPosition == null) {
            bigDecimal3 = BigDecimal.ZERO;
        } else {
            bigDecimal3 = m.a(swapPosition.getAvailable());
        }
        this.P = bigDecimal3;
        if (!E2) {
            if (this.H == null) {
                bigDecimal4 = BigDecimal.ZERO;
            } else {
                bigDecimal4 = new BigDecimal(this.H.getAvailable());
            }
            BigDecimal scale = bigDecimal4.setScale(us.i.b(this.I), 1);
            Di(String.format(getActivity().getString(R.string.n_contract_trade_close_margin_available), new Object[]{scale.toPlainString(), getActivity().getString(R.string.contract_market_vol_sheet)}), 0);
        } else if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            Di("", 8);
        } else {
            if (this.H == null) {
                bigDecimal5 = BigDecimal.ZERO;
            } else {
                bigDecimal5 = new BigDecimal(this.H.getAvailable()).multiply(bigDecimal2).divide(bigDecimal, us.i.c(this.I), 1);
            }
            Di(String.format(getActivity().getString(R.string.n_contract_trade_close_margin_available), new Object[]{bigDecimal5.toPlainString(), this.I}), 0);
        }
    }

    public final void Fi(List<Double[]> list, int i11) {
        if (list == null || list.isEmpty()) {
            if (i11 == 0) {
                this.L = 0.0d;
            } else {
                this.M = 0.0d;
            }
        } else if (i11 == 0) {
            this.L = list.get(0)[0].doubleValue();
        } else {
            this.M = list.get(0)[0].doubleValue();
        }
    }

    public void Gi(SwapPositionItem swapPositionItem) {
        xi(swapPositionItem);
        Hi();
    }

    public final void Hi() {
        int m11 = us.i.m(this.I);
        BigDecimal scale = m.a(this.H.getCostOpen()).setScale(m11, 1);
        BigDecimal scale2 = m.a(this.H.getLastPrice()).setScale(m11, 1);
        this.f81675a0 = scale2;
        if (this.Z == 1) {
            yi(scale2);
        }
        this.f81697u.setText(scale.toPlainString());
        this.f81698v.setText(scale2.toPlainString());
        this.f81699w.setText(n0.a(getContext(), us.i.s(this.I), m.a(this.H.getProfitRate()).multiply(m.f68179a).toPlainString()));
        fi();
    }

    public void V6(CommonPopListItem commonPopListItem) {
        this.Z = commonPopListItem.getType();
        this.W.dismiss();
        this.U.setText(commonPopListItem.getText());
        int i11 = this.Z;
        if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4) {
            if (i11 == 1) {
                this.Y = 8;
            } else if (i11 == 2) {
                this.Y = 3;
            } else if (i11 == 3) {
                this.Y = 4;
            } else if (i11 == 4) {
                this.Y = 5;
            }
            this.f81680d.setVisibility(8);
            this.V.setVisibility(0);
            this.O.hideKeyboard();
            yi(this.f81675a0);
            return;
        }
        this.Y = 1;
        this.f81680d.setVisibility(0);
        this.V.setVisibility(8);
        this.f81684h.setText(this.f81677b0);
        EditText editText = this.f81684h;
        editText.setSelection(editText.getText().length());
    }

    public void addEvent(r rVar) {
        this.f81681e.setOnEditTextFocusChangeListener(new f0(this));
        this.f81683g.setOnEditTextFocusChangeListener(new e0(this));
        this.f81688l.setOnClickListener(new y(this));
        this.f81684h.addTextChangedListener(new e());
        this.f81685i.addTextChangedListener(new f());
        this.f81687k.setOnClickListener(new b0(this));
        this.A.setOnClickListener(new a0(this));
        this.D.setOnClickListener(new z(this));
        this.f81683g.initProgressListener(new ts.d0(this));
    }

    public void afterInit() {
        wi(this.H);
        d2(us.i.m(this.I));
        if (this.G != null) {
            l9.a.a().F(true, this.G.getContractShortType(), SwapDepthType.STEP6, this.f81679c0);
        }
    }

    public void ci(EditText editText, Editable editable, boolean z11) {
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_regular));
            this.S = editText.getText().toString();
            fi();
            return;
        }
        editText.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_medium));
        String str = null;
        TradeType tradeType = TradeType.SWAP;
        if (a7.e.E(tradeType)) {
            if (this.f81683g.getAmountType() == 0) {
                str = m.b(editable, 10, us.i.k(this.I));
            }
            if (str != null) {
                editText.setText(str);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else {
            if (this.f81683g.getAmountType() == 0) {
                if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
                    str = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
                } else {
                    str = m.b(editable, 10, us.i.l(this.I));
                }
            }
            if (str != null) {
                editText.setText(str);
                editText.setSelection(editText.getText().length());
                return;
            }
        }
        if (this.f81683g.getAmountType() == 0) {
            String obj = editText.getText().toString();
            if (a7.e.E(tradeType)) {
                this.S = FutureUnitUtil.e(obj, this.H.getLastPrice(), this.G.getContractFace(), tradeType, 0);
            } else {
                this.S = obj;
            }
        }
        fi();
    }

    public void d2(int i11) {
        this.f81681e.setLength(i11);
    }

    public void di(boolean z11) {
        BigDecimal bigDecimal;
        BigDecimal li2 = li();
        SwapCurrencyInfo swapCurrencyInfo = this.G;
        if (swapCurrencyInfo == null) {
            bigDecimal = BigDecimal.ZERO;
        } else {
            bigDecimal = m.a(swapCurrencyInfo.getContractFace());
        }
        Ei(li2, bigDecimal);
        if (z11) {
            hi(this.f81684h.getText().toString());
        }
        if (!TextUtils.isEmpty(this.f81685i.getText())) {
            Ci(this.Q);
        }
        fi();
    }

    public void dismiss() {
        i iVar = this.N;
        if (iVar != null) {
            iVar.a();
        }
        super.dismiss();
    }

    public void ei(EditText editText, Editable editable, boolean z11) {
        if (editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        String b11 = m.b(editable, 10, us.i.m(this.I));
        if (b11 != null) {
            editText.setText(b11);
            editText.setSelection(editText.getText().length());
            return;
        }
        di(z11);
    }

    public final void fi() {
        if (TextUtils.isEmpty(this.f81684h.getText()) || TextUtils.isEmpty(this.f81685i.getText())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("-- " + this.H.getSymbol());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.baseColorSecondaryText)), 0, spannableStringBuilder.length(), 33);
            this.f81693q.setText(spannableStringBuilder);
        } else if ("buy".equalsIgnoreCase(this.H.getDirection())) {
            this.f81693q.setText(a7.b.e(a7.b.a(this.H.getCostOpen(), this.f81684h.getText().toString(), this.G.getContractFace(), this.S, "--", TradeType.SWAP), us.i.e(this.I), this.H.getSymbol(), getContext()));
        } else {
            this.f81693q.setText(a7.b.e(a7.b.c(this.H.getCostOpen(), this.f81684h.getText().toString(), this.G.getContractFace(), this.S, "--", TradeType.SWAP), us.i.e(this.I), this.H.getSymbol(), getContext()));
        }
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.dialog_contract_position_trade;
    }

    public int getGravity() {
        return 80;
    }

    public boolean gi(String str) {
        return m.a(str).compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean hi(String str) {
        return m.a(str).compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean ic(CommonPopListItem commonPopListItem) {
        return this.Z == commonPopListItem.getType();
    }

    public String ii() {
        SwapPosition swapPosition = this.H;
        if (swapPosition == null) {
            return null;
        }
        return swapPosition.getContractCode();
    }

    public void initView(r rVar) {
        rVar.b(R.id.dialog_contract_bg).setOnClickListener(new c0(this));
        this.R = PixelUtils.g();
        this.f81676b = (LinearLayout) rVar.b(R.id.ll_root);
        this.f81678c = (TextView) rVar.b(R.id.dialog_contract_name_tv);
        this.f81680d = (ViewGroup) rVar.b(R.id.dialog_contract_price_root);
        TradePriceEditext tradePriceEditext = (TradePriceEditext) rVar.b(R.id.dialog_contract_price_et);
        this.f81681e = tradePriceEditext;
        TradeType tradeType = TradeType.SWAP;
        tradePriceEditext.setTradeType(tradeType);
        this.f81688l = rVar.b(R.id.dialog_cancel_iv);
        this.f81684h = this.f81681e.getEditText();
        ContractTradeAmountPercentEdittext contractTradeAmountPercentEdittext = (ContractTradeAmountPercentEdittext) rVar.b(R.id.dialog_contract_amount_et);
        this.f81683g = contractTradeAmountPercentEdittext;
        contractTradeAmountPercentEdittext.setTradeType(tradeType);
        if (a7.e.E(tradeType)) {
            this.f81683g.setLabel(this.I);
        } else {
            this.f81683g.setLabel((int) R.string.contract_trade_unit_sheet);
        }
        this.f81685i = this.f81683g.getEditText();
        this.f81682f = (TextView) rVar.b(R.id.dialog_contract_position_tv);
        this.f81686j = (TextView) rVar.b(R.id.dialog_position_trade_tv);
        this.f81687k = rVar.b(R.id.dialog_position_trade);
        this.f81689m = rVar.b(R.id.dialog_loading);
        LoadingView loadingView = (LoadingView) rVar.b(R.id.loading_dialog_loading_view);
        this.f81690n = loadingView;
        loadingView.setLottieAnimationRes(R.raw.nd_middle_bg);
        this.K = new d0((g0) null);
        this.f81694r = (TextView) rVar.b(R.id.open_price_label_tv);
        this.f81695s = (TextView) rVar.b(R.id.last_price_label_tv);
        this.f81696t = (TextView) rVar.b(R.id.profit_rate_label_tv);
        this.f81697u = (TextView) rVar.b(R.id.open_price_value_tv);
        this.f81698v = (TextView) rVar.b(R.id.last_price_value_tv);
        this.f81699w = (TextView) rVar.b(R.id.profit_rate_value_tv);
        this.f81691o = rVar.b(R.id.price_profit_container);
        this.f81692p = rVar.b(R.id.estimate_profit_container);
        this.f81693q = (TextView) rVar.b(R.id.estimate_profit_value_tv);
        this.f81701y = (EasyRecyclerView) rVar.b(R.id.confirm_rv);
        View b11 = rVar.b(R.id.confirm_container);
        this.f81700x = b11;
        b11.setVisibility(0);
        this.f81700x.setTranslationX((float) this.R);
        this.f81702z = rVar.b(R.id.position_input_container);
        this.B = (TextView) rVar.b(R.id.dialog_center_title_tv);
        this.A = (ImageView) rVar.b(R.id.dialog_back_iv);
        this.C = rVar.b(R.id.content_container);
        this.D = rVar.b(R.id.confirm_btn_container);
        this.f81694r.setText(R.string.contarct_position_cost_open_label);
        this.f81695s.setText(getResources().getString(R.string.index_price_text, new Object[]{getResources().getString(R.string.usd_en_uppercase)}));
        this.X = (ViewGroup) rVar.b(R.id.fl_position_price_type_container);
        this.T = (ImageView) rVar.b(R.id.iv_price_type_menu);
        this.U = (TextView) rVar.b(R.id.tv_price_type_menu);
        this.V = rVar.b(R.id.tv_direct_market_price);
        ArrayList arrayList = new ArrayList();
        CommonPopListItem commonPopListItem = new CommonPopListItem(0, getResources().getString(R.string.n_contract_order_type_limit), this);
        arrayList.add(commonPopListItem);
        arrayList.add(new CommonPopListItem(1, getResources().getString(R.string.n_exchange_order_list_market), this));
        arrayList.add(new CommonPopListItem(2, getResources().getString(R.string.n_contract_trade_optimal_five), this));
        arrayList.add(new CommonPopListItem(3, getResources().getString(R.string.n_contract_trade_optimal_ten), this));
        arrayList.add(new CommonPopListItem(4, getResources().getString(R.string.n_contract_trade_optimal_twenty), this));
        this.W.setData(arrayList);
        this.W.setFollowViewWidth(true);
        this.W.setDialogFragmentListener(new a());
        this.X.setOnClickListener(new b());
        this.U.post(new c(commonPopListItem));
        Hi();
        HuobiBottomDialogKeyboardHelper huobiBottomDialogKeyboardHelper = new HuobiBottomDialogKeyboardHelper();
        this.O = huobiBottomDialogKeyboardHelper;
        huobiBottomDialogKeyboardHelper.attach(getActivity(), this.f81676b).registerInput(this.f81684h, this.f81685i);
        this.f81684h.setOnFocusChangeListener(new d());
        this.f81683g.setKeyboardHelper(this.O);
        if (!(this.H == null || this.G == null)) {
            d0 d0Var = this.K;
            d0Var.W(this.G.getContractCode() + this.H.getDirection(), this.H);
        }
        i6.i.b().f(new w(this));
    }

    public boolean isTransparent() {
        return false;
    }

    public String ji() {
        SwapPosition swapPosition = this.H;
        if (swapPosition == null) {
            return null;
        }
        return swapPosition.getDirection();
    }

    public final Observable<Object> ki(ContractOrderPlace contractOrderPlace) {
        return this.K.Y(contractOrderPlace, this.G).compose(RxJavaHelper.t((u6.g) null));
    }

    public final BigDecimal li() {
        return m.a(this.f81684h.getText().toString());
    }

    public final void ui(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "translationX", new float[]{(float) (-this.R), 0.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, (float) this.R});
        ofFloat2.setInterpolator(new LinearInterpolator());
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.F, this.E});
        ofInt.addUpdateListener(new x(this, (RelativeLayout.LayoutParams) this.C.getLayoutParams()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofInt);
        animatorSet.setDuration(270);
        animatorSet.start();
    }

    public final void vi(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "translationX", new float[]{(float) this.R, 0.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, (float) (-this.R)});
        ofFloat2.setInterpolator(new LinearInterpolator());
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.E, this.F});
        ofInt.addUpdateListener(new v(this, (RelativeLayout.LayoutParams) this.C.getLayoutParams()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofInt);
        animatorSet.setDuration(270);
        animatorSet.start();
    }

    public final boolean w2() {
        SwapPosition swapPosition = this.H;
        return swapPosition == null || !"buy".equalsIgnoreCase(swapPosition.getDirection());
    }

    public final void wi(SwapPosition swapPosition) {
        if (swapPosition != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(getString(R.string.contract_trade_position_close));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.global_main_text_color)), 0, spannableStringBuilder.length(), 33);
            this.f81678c.setText(spannableStringBuilder.append(" ").append(us.j.e(swapPosition.getSymbol(), swapPosition.getDirection(), swapPosition.getLeverRate(), getContext())));
        }
    }

    public void xi(SwapPositionItem swapPositionItem) {
        this.H = swapPositionItem.d();
        this.G = swapPositionItem.e();
        SwapPosition swapPosition = this.H;
        if (swapPosition != null) {
            this.I = swapPosition.getSymbol();
            this.J = this.H.getContractCode();
            if (this.G == null && !TextUtils.isEmpty(this.I)) {
                this.G = SwapCurrencyInfoController.k().h(this.I);
            }
        }
    }

    public final void yi(BigDecimal bigDecimal) {
        if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
            this.f81684h.setText("");
        } else {
            this.f81684h.setText(m.q(bigDecimal, us.i.m(this.I)));
        }
        EditText editText = this.f81684h;
        editText.setSelection(editText.getText().length());
    }

    public final void zi(ContractOrderPlace contractOrderPlace) {
        String str;
        BigDecimal a11 = m.a(contractOrderPlace.w());
        int Q2 = contractOrderPlace.Q();
        if (Q2 == 1) {
            str = String.format(getActivity().getString(R.string.contract_order_dialog_price), new Object[]{a11.toPlainString()});
        } else if (Q2 == 8) {
            str = getResources().getString(R.string.n_exchange_order_list_market);
        } else if (Q2 == 3) {
            str = getResources().getString(R.string.n_contract_trade_optimal_five);
        } else if (Q2 == 4) {
            str = getResources().getString(R.string.n_contract_trade_optimal_ten);
        } else if (Q2 == 5) {
            str = getResources().getString(R.string.n_contract_trade_optimal_twenty);
        } else {
            str = contractOrderPlace.s().toString();
        }
        ArrayList arrayList = new ArrayList();
        FutureInsideConfirmItem futureInsideConfirmItem = new FutureInsideConfirmItem();
        futureInsideConfirmItem.f(getActivity().getString(R.string.contract_order_dialog_exchange_title));
        futureInsideConfirmItem.g(contractOrderPlace.P());
        arrayList.add(futureInsideConfirmItem);
        FutureInsideConfirmItem futureInsideConfirmItem2 = new FutureInsideConfirmItem();
        futureInsideConfirmItem2.f(getActivity().getString(R.string.contract_order_dialog_kind_title));
        futureInsideConfirmItem2.g(us.j.f(this.G.getSymbol(), getContext()));
        arrayList.add(futureInsideConfirmItem2);
        FutureInsideConfirmItem futureInsideConfirmItem3 = new FutureInsideConfirmItem();
        futureInsideConfirmItem3.f(getActivity().getString(R.string.contract_order_dialog_order_price_title));
        futureInsideConfirmItem3.g(str);
        arrayList.add(futureInsideConfirmItem3);
        FutureInsideConfirmItem futureInsideConfirmItem4 = new FutureInsideConfirmItem();
        futureInsideConfirmItem4.f(getActivity().getString(R.string.contract_order_dialog_amout_title));
        futureInsideConfirmItem4.g(this.K.z() + this.G.getSymbol());
        arrayList.add(futureInsideConfirmItem4);
        this.f81701y.setData(arrayList);
        this.A.setVisibility(0);
        this.B.setVisibility(0);
        this.f81688l.setVisibility(8);
        this.f81678c.setVisibility(8);
        this.D.setTag(R.id.item_data, contractOrderPlace);
        this.C.post(new g());
    }
}
