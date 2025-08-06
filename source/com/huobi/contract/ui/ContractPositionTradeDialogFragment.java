package com.huobi.contract.ui;

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
import bj.d1;
import bj.p0;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.PixelUtils;
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
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.TransparentListPopupDialog;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.hbg.lib.widgets.dialog.bean.FutureInsideConfirmItem;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.utils.n0;
import com.huobi.view.ContractTradeAmountPercentEdittext;
import com.huobi.view.TradePriceEditext;
import com.huobi.view.keyboard.HuobiBottomDialogKeyboardHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.b0;
import dj.c0;
import dj.d0;
import dj.e0;
import dj.f0;
import dj.g0;
import dj.h0;
import dj.i0;
import dj.j0;
import dj.k0;
import dj.l0;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.Observable;

public class ContractPositionTradeDialogFragment extends BaseDialogFragment implements CommonPopListItem.a {
    public ImageView A;
    public TextView B;
    public View C;
    public View D;
    public int E;
    public int F;
    public ContractCurrencyInfo G;
    public ContractPosition H;
    public String I;
    public d1 J;
    public double K;
    public double L;
    public i M;
    public HuobiBottomDialogKeyboardHelper N;
    public BigDecimal O;
    public int P;
    public int Q = 0;
    public String R;
    public ImageView S;
    public TextView T;
    public View U;
    public TransparentListPopupDialog V = new TransparentListPopupDialog();
    public ViewGroup W;
    public int X;
    public int Y = 0;
    public BigDecimal Z;

    /* renamed from: a0  reason: collision with root package name */
    public String f43310a0 = "";

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f43311b;

    /* renamed from: b0  reason: collision with root package name */
    public MarketDepthListener f43312b0 = new h();

    /* renamed from: c  reason: collision with root package name */
    public TextView f43313c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f43314d;

    /* renamed from: e  reason: collision with root package name */
    public TradePriceEditext f43315e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f43316f;

    /* renamed from: g  reason: collision with root package name */
    public ContractTradeAmountPercentEdittext f43317g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f43318h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f43319i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f43320j;

    /* renamed from: k  reason: collision with root package name */
    public View f43321k;

    /* renamed from: l  reason: collision with root package name */
    public View f43322l;

    /* renamed from: m  reason: collision with root package name */
    public View f43323m;

    /* renamed from: n  reason: collision with root package name */
    public LoadingView f43324n;

    /* renamed from: o  reason: collision with root package name */
    public View f43325o;

    /* renamed from: p  reason: collision with root package name */
    public View f43326p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f43327q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f43328r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f43329s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f43330t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f43331u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f43332v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f43333w;

    /* renamed from: x  reason: collision with root package name */
    public View f43334x;

    /* renamed from: y  reason: collision with root package name */
    public EasyRecyclerView f43335y;

    /* renamed from: z  reason: collision with root package name */
    public View f43336z;

    public class a implements BaseDialogFragment.c {
        public a() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            ContractPositionTradeDialogFragment.this.S.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            ContractPositionTradeDialogFragment.this.S.setImageResource(R.drawable.trade_arrow_up);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ContractPositionTradeDialogFragment.this.V.showAsDropDown(ContractPositionTradeDialogFragment.this.getActivity().getSupportFragmentManager(), ContractPositionTradeDialogFragment.this.W);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommonPopListItem f43339b;

        public c(CommonPopListItem commonPopListItem) {
            this.f43339b = commonPopListItem;
        }

        public void run() {
            ContractPositionTradeDialogFragment.this.V6(this.f43339b);
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        public void onFocusChange(View view, boolean z11) {
            if (z11) {
                ContractPositionTradeDialogFragment.this.N.showKeyboard(ContractPositionTradeDialogFragment.this.f43318h);
            }
        }
    }

    public class e implements TextWatcher {
        public e() {
        }

        public void afterTextChanged(Editable editable) {
            if (ContractPositionTradeDialogFragment.this.getActivity() != null) {
                ContractPositionTradeDialogFragment contractPositionTradeDialogFragment = ContractPositionTradeDialogFragment.this;
                contractPositionTradeDialogFragment.ei(contractPositionTradeDialogFragment.f43318h, editable, false);
                if (ContractPositionTradeDialogFragment.this.Y == 0) {
                    ContractPositionTradeDialogFragment contractPositionTradeDialogFragment2 = ContractPositionTradeDialogFragment.this;
                    String unused = contractPositionTradeDialogFragment2.f43310a0 = contractPositionTradeDialogFragment2.f43318h.getText().toString();
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
            if (ContractPositionTradeDialogFragment.this.getActivity() != null) {
                ContractPositionTradeDialogFragment contractPositionTradeDialogFragment = ContractPositionTradeDialogFragment.this;
                contractPositionTradeDialogFragment.ci(contractPositionTradeDialogFragment.f43319i, editable, false);
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
            if (ContractPositionTradeDialogFragment.this.F == 0 || ContractPositionTradeDialogFragment.this.F == ContractPositionTradeDialogFragment.this.E) {
                ContractPositionTradeDialogFragment contractPositionTradeDialogFragment = ContractPositionTradeDialogFragment.this;
                int unused = contractPositionTradeDialogFragment.F = contractPositionTradeDialogFragment.f43334x.getHeight();
            }
            ContractPositionTradeDialogFragment contractPositionTradeDialogFragment2 = ContractPositionTradeDialogFragment.this;
            contractPositionTradeDialogFragment2.vi(contractPositionTradeDialogFragment2.f43336z, ContractPositionTradeDialogFragment.this.f43334x);
        }
    }

    public class h extends MarketDepthListener {
        public h() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            BigDecimal bigDecimal;
            if (marketDepthResponse != null && ContractPositionTradeDialogFragment.this.G != null && marketDepthResponse.getSymbol().equals(ContractPositionTradeDialogFragment.this.G.getContractShortType())) {
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                ContractPositionTradeDialogFragment.this.Fi(asks, 1);
                ContractPositionTradeDialogFragment.this.Fi(bids, 0);
                if (ContractPositionTradeDialogFragment.this.w2()) {
                    bigDecimal = m.a(String.valueOf(ContractPositionTradeDialogFragment.this.L));
                } else {
                    bigDecimal = m.a(String.valueOf(ContractPositionTradeDialogFragment.this.K));
                }
                BigDecimal unused = ContractPositionTradeDialogFragment.this.Z = bigDecimal;
                ContractPositionTradeDialogFragment.this.yi(bigDecimal);
                q7.a.a().B(false, ContractPositionTradeDialogFragment.this.G.getContractShortType(), ContractDepthType.STEP6, ContractPositionTradeDialogFragment.this.f43312b0);
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
                ContractPositionTradeDialogFragment.this.dismiss();
            }
        }

        public j() {
        }

        public void onAfter() {
            super.onAfter();
            ContractPositionTradeDialogFragment.this.f43323m.setVisibility(8);
            ContractPositionTradeDialogFragment.this.f43324n.d();
            ContractPositionTradeDialogFragment.this.f43321k.setEnabled(true);
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
            ContractPositionTradeDialogFragment.this.f43323m.setVisibility(0);
            ContractPositionTradeDialogFragment.this.f43321k.setEnabled(false);
            ContractPositionTradeDialogFragment.this.f43324n.c();
        }

        public /* synthetic */ j(ContractPositionTradeDialogFragment contractPositionTradeDialogFragment, a aVar) {
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
        this.N.hideKeyboard();
        Bf();
        String str = "";
        String charSequence = this.f43318h.getHint() == null ? str : this.f43318h.getHint().toString();
        if (this.f43319i.getHint() != null) {
            str = this.f43319i.getHint().toString();
        }
        Bi(charSequence, str, this.f43318h.getText().toString(), this.f43319i.getText().toString(), 2, this.X);
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
        this.f43315e.setBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_5_radius_bg : R.drawable.custom_edittext_normal_5_radius_bg);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ni(View view, boolean z11) {
        this.f43317g.setEditAreaBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_5_radius_bg : R.drawable.custom_edittext_normal_5_radius_bg);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void oi(View view) {
        this.A.setVisibility(8);
        this.B.setVisibility(8);
        this.f43322l.setVisibility(0);
        this.f43313c.setVisibility(0);
        ui(this.f43334x, this.f43336z);
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
        this.f43319i.clearFocus();
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
        this.f43318h.clearFocus();
        this.f43319i.clearFocus();
    }

    public void Bi(String str, String str2, String str3, String str4, int i11, int i12) {
        if (i12 != 1) {
            if (w2()) {
                str3 = BigDecimal.valueOf(this.L).toPlainString();
            } else {
                str3 = BigDecimal.valueOf(this.K).toPlainString();
            }
        }
        if (i12 == 1 && !hi(str3)) {
            HuobiToastUtil.l(bh.j.c(), String.format(bh.j.c().getString(R.string.input_unknow_text), new Object[]{str}));
        } else if (this.f43317g.getAmountType() != 0 || gi(str4)) {
            ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
            contractOrderPlace.N0(this.I);
            contractOrderPlace.B0(str3);
            contractOrderPlace.d0(str4);
            contractOrderPlace.h0(w2());
            contractOrderPlace.A0(i11);
            contractOrderPlace.X0(i12);
            contractOrderPlace.g0(this.f43317g.getAmountType());
            contractOrderPlace.E0(this.P);
            if (w2()) {
                contractOrderPlace.W0(getString(R.string.contract_trade_buy_flat_empty));
            } else {
                contractOrderPlace.W0(getString(R.string.contract_trade_sell_flat_more));
            }
            ContractPosition contractPosition = this.H;
            if (contractPosition != null) {
                contractOrderPlace.s0(contractPosition.getLeverRate());
            }
            contractOrderPlace.x0(getString(R.string.contract_trade_position_close_quick));
            Ai(this.J.N(getActivity(), contractOrderPlace, this.G));
        } else {
            HuobiToastUtil.l(bh.j.c(), String.format(bh.j.c().getString(R.string.input_unknow_text), new Object[]{str2}));
        }
    }

    public final void Ci(int i11) {
        String str;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        if (this.f43317g.getAmountType() != 0) {
            this.P = i11;
            BigDecimal li2 = li();
            BigDecimal bigDecimal3 = this.O;
            if (bigDecimal3 == null || bigDecimal3.compareTo(BigDecimal.ZERO) == 0) {
                this.R = "0";
                EditText editText = this.f43319i;
                editText.setText(i11 + "%");
                return;
            }
            TradeType tradeType = TradeType.CONTRACT;
            if (a7.e.E(tradeType)) {
                BigDecimal divide = this.O.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                if (divide.compareTo(BigDecimal.ONE) >= 0 || divide.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal2 = divide.setScale(ej.f.t(this.I), 1);
                } else {
                    bigDecimal2 = BigDecimal.ONE;
                }
                str = m.a(FutureUnitUtil.d(bigDecimal2.toPlainString(), li2.toPlainString(), this.G.getContractFace(), tradeType)).setScale(ej.f.n(this.G.getContractCode()), 1).toPlainString();
                this.R = bigDecimal2.toPlainString();
            } else {
                BigDecimal divide2 = this.O.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                if (divide2.compareTo(BigDecimal.ONE) >= 0 || divide2.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal = divide2.setScale(ej.f.t(this.I), 1);
                } else {
                    bigDecimal = BigDecimal.ONE;
                }
                String plainString = bigDecimal.toPlainString();
                this.R = bigDecimal.toPlainString();
                str = plainString;
            }
            if (TextUtils.isEmpty(str) || m.a(str).compareTo(BigDecimal.ZERO) == 0) {
                EditText editText2 = this.f43319i;
                editText2.setText(i11 + "%");
                return;
            }
            EditText editText3 = this.f43319i;
            editText3.setText(i11 + "%(≈ " + str + ")");
        }
    }

    public final void Di(String str, int i11) {
        if (!TextUtils.isEmpty(str)) {
            this.f43316f.setText(str);
        }
        this.f43316f.setVisibility(i11);
    }

    public final void Ei(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        BigDecimal bigDecimal5;
        boolean E2 = a7.e.E(TradeType.CONTRACT);
        ContractPosition contractPosition = this.H;
        if (contractPosition == null) {
            bigDecimal3 = BigDecimal.ZERO;
        } else {
            bigDecimal3 = m.a(contractPosition.getAvailable());
        }
        this.O = bigDecimal3;
        if (!E2) {
            if (this.H == null) {
                bigDecimal4 = BigDecimal.ZERO;
            } else {
                bigDecimal4 = new BigDecimal(this.H.getAvailable());
            }
            BigDecimal scale = bigDecimal4.setScale(ej.f.c(this.I), 1);
            Di(String.format(getActivity().getString(R.string.n_contract_trade_close_margin_available), new Object[]{scale.toPlainString(), getActivity().getString(R.string.contract_market_vol_sheet)}), 0);
        } else if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            Di("", 8);
        } else {
            if (this.H == null) {
                bigDecimal5 = BigDecimal.ZERO;
            } else {
                bigDecimal5 = new BigDecimal(this.H.getAvailable()).multiply(bigDecimal2).divide(bigDecimal, ej.f.n(this.H.getContractCode()), 1);
            }
            Di(String.format(getActivity().getString(R.string.n_contract_trade_close_margin_available), new Object[]{bigDecimal5.toPlainString(), this.I}), 0);
        }
    }

    public final void Fi(List<Double[]> list, int i11) {
        if (list == null || list.isEmpty()) {
            if (i11 == 0) {
                this.K = 0.0d;
            } else {
                this.L = 0.0d;
            }
        } else if (i11 == 0) {
            this.K = list.get(0)[0].doubleValue();
        } else {
            this.L = list.get(0)[0].doubleValue();
        }
    }

    public void Gi(ContractPosition contractPosition) {
        xi(contractPosition);
        Hi();
    }

    public final void Hi() {
        int p11 = ej.f.p(this.H.getContractCode());
        BigDecimal scale = m.a(this.H.getCostOpen()).setScale(p11, 1);
        BigDecimal scale2 = m.a(this.H.getLastPrice()).setScale(p11, 1);
        this.Z = scale2;
        if (this.Y == 1) {
            yi(scale2);
        }
        this.f43331u.setText(scale.toPlainString());
        this.f43332v.setText(scale2.toPlainString());
        this.f43333w.setText(n0.a(getContext(), ej.f.i(this.H.getSymbol()), m.a(this.H.getProfitRate()).multiply(m.f68179a).toPlainString()));
        fi();
    }

    public void V6(CommonPopListItem commonPopListItem) {
        this.Y = commonPopListItem.getType();
        this.V.dismiss();
        this.T.setText(commonPopListItem.getText());
        int i11 = this.Y;
        if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4) {
            if (i11 == 1) {
                this.X = 8;
            } else if (i11 == 2) {
                this.X = 3;
            } else if (i11 == 3) {
                this.X = 4;
            } else if (i11 == 4) {
                this.X = 5;
            }
            this.f43314d.setVisibility(8);
            this.U.setVisibility(0);
            this.N.hideKeyboard();
            yi(this.Z);
            return;
        }
        this.X = 1;
        this.f43314d.setVisibility(0);
        this.U.setVisibility(8);
        this.f43318h.setText(this.f43310a0);
        EditText editText = this.f43318h;
        editText.setSelection(editText.getText().length());
    }

    public void addEvent(r rVar) {
        this.f43315e.setOnEditTextFocusChangeListener(new l0(this));
        this.f43317g.setOnEditTextFocusChangeListener(new k0(this));
        this.f43322l.setOnClickListener(new e0(this));
        this.f43318h.addTextChangedListener(new e());
        this.f43319i.addTextChangedListener(new f());
        this.f43321k.setOnClickListener(new f0(this));
        this.A.setOnClickListener(new h0(this));
        this.D.setOnClickListener(new g0(this));
        this.f43317g.initProgressListener(new j0(this));
    }

    public void afterInit() {
        wi(this.H);
        d2(ej.f.p(this.H.getContractCode()));
        if (this.G != null) {
            q7.a.a().B(true, this.G.getContractShortType(), ContractDepthType.STEP6, this.f43312b0);
        }
    }

    public void ci(EditText editText, Editable editable, boolean z11) {
        if (editable == null || editable.length() == 0) {
            this.R = editText.getText().toString();
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
            fi();
            return;
        }
        editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        String str = null;
        TradeType tradeType = TradeType.CONTRACT;
        if (a7.e.E(tradeType)) {
            if (this.f43317g.getAmountType() == 0) {
                str = m.b(editable, 10, ej.f.n(this.H.getContractCode()));
            }
            if (str != null) {
                editText.setText(str);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else {
            if (this.f43317g.getAmountType() == 0) {
                if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
                    str = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
                } else {
                    str = m.b(editable, 10, ej.f.g(this.I));
                }
            }
            if (str != null) {
                editText.setText(str);
                editText.setSelection(editText.getText().length());
                return;
            }
        }
        if (this.f43317g.getAmountType() == 0) {
            String obj = editText.getText().toString();
            if (a7.e.E(tradeType)) {
                this.R = FutureUnitUtil.e(obj, this.H.getLastPrice(), this.G.getContractFace(), tradeType, 0);
            } else {
                this.R = obj;
            }
        }
        fi();
    }

    public void d2(int i11) {
        this.f43315e.setLength(i11);
    }

    public void di(boolean z11) {
        BigDecimal bigDecimal;
        BigDecimal li2 = li();
        ContractCurrencyInfo contractCurrencyInfo = this.G;
        if (contractCurrencyInfo == null) {
            bigDecimal = BigDecimal.ZERO;
        } else {
            bigDecimal = m.a(contractCurrencyInfo.getContractFace());
        }
        Ei(li2, bigDecimal);
        if (z11) {
            hi(this.f43318h.getText().toString());
        }
        if (!TextUtils.isEmpty(this.f43319i.getText())) {
            Ci(this.P);
        }
        fi();
    }

    public void dismiss() {
        i iVar = this.M;
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
        String b11 = m.b(editable, 10, ej.f.p(this.H.getContractCode()));
        if (b11 != null) {
            editText.setText(b11);
            editText.setSelection(editText.getText().length());
            return;
        }
        di(z11);
    }

    public final void fi() {
        if (TextUtils.isEmpty(this.f43318h.getText()) || TextUtils.isEmpty(this.f43319i.getText())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("-- " + this.H.getSymbol());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.baseColorSecondaryText)), 0, spannableStringBuilder.length(), 33);
            this.f43327q.setText(spannableStringBuilder);
        } else if ("buy".equalsIgnoreCase(this.H.getDirection())) {
            this.f43327q.setText(a7.b.e(a7.b.a(this.H.getCostOpen(), this.f43318h.getText().toString(), this.G.getContractFace(), this.R, "--", TradeType.CONTRACT), ej.f.n(this.H.getContractCode()), this.H.getSymbol(), getContext()));
        } else {
            this.f43327q.setText(a7.b.e(a7.b.c(this.H.getCostOpen(), this.f43318h.getText().toString(), this.G.getContractFace(), this.R, "--", TradeType.CONTRACT), ej.f.n(this.H.getContractCode()), this.H.getSymbol(), getContext()));
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
        return this.Y == commonPopListItem.getType();
    }

    public String ii() {
        ContractPosition contractPosition = this.H;
        if (contractPosition == null) {
            return null;
        }
        return contractPosition.getContractCode();
    }

    public void initView(r rVar) {
        rVar.b(R.id.dialog_contract_bg).setOnClickListener(new i0(this));
        this.Q = PixelUtils.g();
        this.f43311b = (LinearLayout) rVar.b(R.id.ll_root);
        this.f43313c = (TextView) rVar.b(R.id.dialog_contract_name_tv);
        this.f43314d = (ViewGroup) rVar.b(R.id.dialog_contract_price_root);
        TradePriceEditext tradePriceEditext = (TradePriceEditext) rVar.b(R.id.dialog_contract_price_et);
        this.f43315e = tradePriceEditext;
        TradeType tradeType = TradeType.CONTRACT;
        tradePriceEditext.setTradeType(tradeType);
        this.f43322l = rVar.b(R.id.dialog_cancel_iv);
        this.f43318h = this.f43315e.getEditText();
        ContractTradeAmountPercentEdittext contractTradeAmountPercentEdittext = (ContractTradeAmountPercentEdittext) rVar.b(R.id.dialog_contract_amount_et);
        this.f43317g = contractTradeAmountPercentEdittext;
        contractTradeAmountPercentEdittext.setTradeType(tradeType);
        if (a7.e.E(tradeType)) {
            this.f43317g.setLabel(this.I);
        } else {
            this.f43317g.setLabel((int) R.string.contract_trade_unit_sheet);
        }
        this.f43319i = this.f43317g.getEditText();
        this.f43316f = (TextView) rVar.b(R.id.dialog_contract_position_tv);
        this.f43320j = (TextView) rVar.b(R.id.dialog_position_trade_tv);
        this.f43321k = rVar.b(R.id.dialog_position_trade);
        this.f43323m = rVar.b(R.id.dialog_loading);
        this.f43328r = (TextView) rVar.b(R.id.open_price_label_tv);
        this.f43329s = (TextView) rVar.b(R.id.last_price_label_tv);
        this.f43330t = (TextView) rVar.b(R.id.profit_rate_label_tv);
        this.f43331u = (TextView) rVar.b(R.id.open_price_value_tv);
        this.f43332v = (TextView) rVar.b(R.id.last_price_value_tv);
        this.f43333w = (TextView) rVar.b(R.id.profit_rate_value_tv);
        this.f43325o = rVar.b(R.id.price_profit_container);
        this.f43326p = rVar.b(R.id.estimate_profit_container);
        this.f43327q = (TextView) rVar.b(R.id.estimate_profit_value_tv);
        this.f43335y = (EasyRecyclerView) rVar.b(R.id.confirm_rv);
        View b11 = rVar.b(R.id.confirm_container);
        this.f43334x = b11;
        b11.setVisibility(0);
        this.f43334x.setTranslationX((float) this.Q);
        this.f43336z = rVar.b(R.id.position_input_container);
        this.B = (TextView) rVar.b(R.id.dialog_center_title_tv);
        this.A = (ImageView) rVar.b(R.id.dialog_back_iv);
        this.C = rVar.b(R.id.content_container);
        this.D = rVar.b(R.id.confirm_btn_container);
        this.f43328r.setText(R.string.contarct_position_cost_open_label);
        this.f43329s.setText(getResources().getString(R.string.index_price_text, new Object[]{getResources().getString(R.string.usd_en_uppercase)}));
        this.W = (ViewGroup) rVar.b(R.id.fl_position_price_type_container);
        this.S = (ImageView) rVar.b(R.id.iv_price_type_menu);
        this.T = (TextView) rVar.b(R.id.tv_price_type_menu);
        this.U = rVar.b(R.id.tv_direct_market_price);
        ArrayList arrayList = new ArrayList();
        CommonPopListItem commonPopListItem = new CommonPopListItem(0, getResources().getString(R.string.n_contract_order_type_limit), this);
        arrayList.add(commonPopListItem);
        arrayList.add(new CommonPopListItem(1, getResources().getString(R.string.n_exchange_order_list_market), this));
        arrayList.add(new CommonPopListItem(2, getResources().getString(R.string.n_contract_trade_optimal_five), this));
        arrayList.add(new CommonPopListItem(3, getResources().getString(R.string.n_contract_trade_optimal_ten), this));
        arrayList.add(new CommonPopListItem(4, getResources().getString(R.string.n_contract_trade_optimal_twenty), this));
        this.V.setData(arrayList);
        this.V.setFollowViewWidth(true);
        this.V.setDialogFragmentListener(new a());
        this.W.setOnClickListener(new b());
        this.T.post(new c(commonPopListItem));
        Hi();
        LoadingView loadingView = (LoadingView) rVar.b(R.id.loading_dialog_loading_view);
        this.f43324n = loadingView;
        loadingView.setLottieAnimationRes(R.raw.nd_middle_bg);
        this.J = new d1((dj.n0) null);
        HuobiBottomDialogKeyboardHelper huobiBottomDialogKeyboardHelper = new HuobiBottomDialogKeyboardHelper();
        this.N = huobiBottomDialogKeyboardHelper;
        huobiBottomDialogKeyboardHelper.attach(getActivity(), this.f43311b).registerInput(this.f43318h, this.f43319i);
        this.f43318h.setOnFocusChangeListener(new d());
        this.f43317g.setKeyboardHelper(this.N);
        if (!(this.H == null || this.G == null)) {
            d1 d1Var = this.J;
            d1Var.T(this.G.getContractCode() + this.H.getDirection(), this.H);
        }
        i6.i.b().f(new c0(this));
    }

    public boolean isTransparent() {
        return false;
    }

    public String ji() {
        ContractPosition contractPosition = this.H;
        if (contractPosition == null) {
            return null;
        }
        return contractPosition.getDirection();
    }

    public final Observable<Object> ki(ContractOrderPlace contractOrderPlace) {
        return this.J.q(contractOrderPlace, this.G).compose(RxJavaHelper.t((u6.g) null));
    }

    public final BigDecimal li() {
        return m.a(this.f43318h.getText().toString());
    }

    public final void ui(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "translationX", new float[]{(float) (-this.Q), 0.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, (float) this.Q});
        ofFloat2.setInterpolator(new LinearInterpolator());
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.F, this.E});
        ofInt.addUpdateListener(new d0(this, (RelativeLayout.LayoutParams) this.C.getLayoutParams()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofInt);
        animatorSet.setDuration(270);
        animatorSet.start();
    }

    public final void vi(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "translationX", new float[]{(float) this.Q, 0.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, (float) (-this.Q)});
        ofFloat2.setInterpolator(new LinearInterpolator());
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.E, this.F});
        ofInt.addUpdateListener(new b0(this, (RelativeLayout.LayoutParams) this.C.getLayoutParams()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofInt);
        animatorSet.setDuration(270);
        animatorSet.start();
    }

    public final boolean w2() {
        ContractPosition contractPosition = this.H;
        return contractPosition == null || !"buy".equalsIgnoreCase(contractPosition.getDirection());
    }

    public final void wi(ContractPosition contractPosition) {
        if (contractPosition != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(getString(R.string.contract_trade_position_close));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.global_main_text_color)), 0, spannableStringBuilder.length(), 33);
            this.f43313c.setText(spannableStringBuilder.append(" ").append(ej.g.m(contractPosition.getSymbol(), contractPosition.getDirection(), contractPosition.getContractCode(), contractPosition.getLeverRate(), contractPosition.getContractCurrencyInfo().getContractShortType(), getActivity())));
        }
    }

    public void xi(ContractPosition contractPosition) {
        this.H = contractPosition;
        if (contractPosition != null) {
            this.G = contractPosition.getContractCurrencyInfo();
            this.I = contractPosition.getSymbol();
        }
    }

    public final void yi(BigDecimal bigDecimal) {
        if (this.H != null) {
            if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                this.f43318h.setText("");
            } else {
                this.f43318h.setText(m.q(bigDecimal, ej.f.p(this.H.getContractCode())));
            }
            EditText editText = this.f43318h;
            editText.setSelection(editText.getText().length());
        }
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
        futureInsideConfirmItem2.g(ej.g.d(this.G.getContractShortType(), this.G.getContractCode(), 2));
        arrayList.add(futureInsideConfirmItem2);
        FutureInsideConfirmItem futureInsideConfirmItem3 = new FutureInsideConfirmItem();
        futureInsideConfirmItem3.f(getActivity().getString(R.string.contract_order_dialog_order_price_title));
        futureInsideConfirmItem3.g(str);
        arrayList.add(futureInsideConfirmItem3);
        FutureInsideConfirmItem futureInsideConfirmItem4 = new FutureInsideConfirmItem();
        futureInsideConfirmItem4.f(getActivity().getString(R.string.contract_order_dialog_amout_title));
        futureInsideConfirmItem4.g(this.J.v() + this.G.getSymbol());
        arrayList.add(futureInsideConfirmItem4);
        this.f43335y.setData(arrayList);
        this.A.setVisibility(0);
        this.B.setVisibility(0);
        this.f43322l.setVisibility(8);
        this.f43313c.setVisibility(8);
        this.D.setTag(R.id.item_data, contractOrderPlace);
        this.C.post(new g());
    }
}
