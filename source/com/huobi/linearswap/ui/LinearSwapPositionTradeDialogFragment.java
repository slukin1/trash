package com.huobi.linearswap.ui;

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
import cn.e0;
import cn.f0;
import cn.g0;
import cn.h0;
import cn.i0;
import cn.j0;
import cn.k0;
import cn.k2;
import cn.l0;
import cn.m0;
import cn.o0;
import cn.q0;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.PixelUtils;
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
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.TransparentListPopupDialog;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.hbg.lib.widgets.dialog.bean.FutureInsideConfirmItem;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.utils.KycLimitCodeUtils;
import com.huobi.feature.util.FutureOrderErrorHelper;
import com.huobi.feature.util.KycAndHasTradeDialogUtils;
import com.huobi.utils.n0;
import com.huobi.view.ContractTradeAmountPercentEdittext;
import com.huobi.view.TradePriceEditext;
import com.huobi.view.keyboard.HuobiBottomDialogKeyboardHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.Observable;
import tg.r;
import ym.z;

public class LinearSwapPositionTradeDialogFragment extends BaseDialogFragment implements CommonPopListItem.a {
    public ImageView A;
    public TextView B;
    public View C;
    public View D;
    public int E;
    public int F;
    public FutureContractInfo G;
    public LinearSwapPosition H;
    public String I;
    public String J;
    public z K;
    public double L;
    public double M;
    public i N;
    public HuobiBottomDialogKeyboardHelper O;
    public int P;
    public BigDecimal Q;
    public BigDecimal R;
    public int S;
    public int T = 0;
    public String U;
    public ImageView V;
    public TextView W;
    public View X;
    public TransparentListPopupDialog Y = new TransparentListPopupDialog();
    public ViewGroup Z;

    /* renamed from: a0  reason: collision with root package name */
    public int f75255a0;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f75256b;

    /* renamed from: b0  reason: collision with root package name */
    public int f75257b0 = 0;

    /* renamed from: c  reason: collision with root package name */
    public TextView f75258c;

    /* renamed from: c0  reason: collision with root package name */
    public BigDecimal f75259c0;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f75260d;

    /* renamed from: d0  reason: collision with root package name */
    public String f75261d0 = "";

    /* renamed from: e  reason: collision with root package name */
    public TradePriceEditext f75262e;

    /* renamed from: e0  reason: collision with root package name */
    public MarketDepthListener f75263e0 = new h();

    /* renamed from: f  reason: collision with root package name */
    public TextView f75264f;

    /* renamed from: g  reason: collision with root package name */
    public ContractTradeAmountPercentEdittext f75265g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f75266h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f75267i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f75268j;

    /* renamed from: k  reason: collision with root package name */
    public View f75269k;

    /* renamed from: l  reason: collision with root package name */
    public View f75270l;

    /* renamed from: m  reason: collision with root package name */
    public View f75271m;

    /* renamed from: n  reason: collision with root package name */
    public LoadingView f75272n;

    /* renamed from: o  reason: collision with root package name */
    public View f75273o;

    /* renamed from: p  reason: collision with root package name */
    public View f75274p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f75275q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f75276r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f75277s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f75278t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f75279u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f75280v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f75281w;

    /* renamed from: x  reason: collision with root package name */
    public View f75282x;

    /* renamed from: y  reason: collision with root package name */
    public EasyRecyclerView f75283y;

    /* renamed from: z  reason: collision with root package name */
    public View f75284z;

    public class a implements BaseDialogFragment.c {
        public a() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            LinearSwapPositionTradeDialogFragment.this.V.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            LinearSwapPositionTradeDialogFragment.this.V.setImageResource(R.drawable.trade_arrow_up);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (LinearSwapPositionTradeDialogFragment.this.V.getVisibility() == 0) {
                LinearSwapPositionTradeDialogFragment.this.Y.showAsDropDown(LinearSwapPositionTradeDialogFragment.this.getActivity().getSupportFragmentManager(), LinearSwapPositionTradeDialogFragment.this.Z);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommonPopListItem f75287b;

        public c(CommonPopListItem commonPopListItem) {
            this.f75287b = commonPopListItem;
        }

        public void run() {
            LinearSwapPositionTradeDialogFragment.this.V6(this.f75287b);
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        public void onFocusChange(View view, boolean z11) {
            if (z11) {
                LinearSwapPositionTradeDialogFragment.this.O.showKeyboard(LinearSwapPositionTradeDialogFragment.this.f75266h);
            }
        }
    }

    public class e implements TextWatcher {
        public e() {
        }

        public void afterTextChanged(Editable editable) {
            if (LinearSwapPositionTradeDialogFragment.this.getActivity() != null) {
                LinearSwapPositionTradeDialogFragment linearSwapPositionTradeDialogFragment = LinearSwapPositionTradeDialogFragment.this;
                linearSwapPositionTradeDialogFragment.hi(linearSwapPositionTradeDialogFragment.f75266h, editable, false);
                if (LinearSwapPositionTradeDialogFragment.this.f75257b0 == 0) {
                    LinearSwapPositionTradeDialogFragment linearSwapPositionTradeDialogFragment2 = LinearSwapPositionTradeDialogFragment.this;
                    String unused = linearSwapPositionTradeDialogFragment2.f75261d0 = linearSwapPositionTradeDialogFragment2.f75266h.getText().toString();
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
            if (LinearSwapPositionTradeDialogFragment.this.getActivity() != null) {
                LinearSwapPositionTradeDialogFragment linearSwapPositionTradeDialogFragment = LinearSwapPositionTradeDialogFragment.this;
                linearSwapPositionTradeDialogFragment.fi(linearSwapPositionTradeDialogFragment.f75267i, editable, false);
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
            if (LinearSwapPositionTradeDialogFragment.this.F == 0 || LinearSwapPositionTradeDialogFragment.this.F == LinearSwapPositionTradeDialogFragment.this.E) {
                LinearSwapPositionTradeDialogFragment linearSwapPositionTradeDialogFragment = LinearSwapPositionTradeDialogFragment.this;
                int unused = linearSwapPositionTradeDialogFragment.F = linearSwapPositionTradeDialogFragment.f75282x.getHeight();
            }
            LinearSwapPositionTradeDialogFragment linearSwapPositionTradeDialogFragment2 = LinearSwapPositionTradeDialogFragment.this;
            linearSwapPositionTradeDialogFragment2.Ai(linearSwapPositionTradeDialogFragment2.f75284z, LinearSwapPositionTradeDialogFragment.this.f75282x);
        }
    }

    public class h extends MarketDepthListener {
        public h() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            BigDecimal bigDecimal;
            if (marketDepthResponse != null && LinearSwapPositionTradeDialogFragment.this.G != null && marketDepthResponse.getSymbol().equals(LinearSwapPositionTradeDialogFragment.this.G.getContractShortType())) {
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                LinearSwapPositionTradeDialogFragment.this.Ki(asks, 1);
                LinearSwapPositionTradeDialogFragment.this.Ki(bids, 0);
                if (LinearSwapPositionTradeDialogFragment.this.w2()) {
                    bigDecimal = m.a(String.valueOf(LinearSwapPositionTradeDialogFragment.this.M));
                } else {
                    bigDecimal = m.a(String.valueOf(LinearSwapPositionTradeDialogFragment.this.L));
                }
                BigDecimal unused = LinearSwapPositionTradeDialogFragment.this.f75259c0 = bigDecimal;
                LinearSwapPositionTradeDialogFragment.this.Ei(bigDecimal);
                LinearSwapPositionTradeDialogFragment.this.f75266h.setSelection(LinearSwapPositionTradeDialogFragment.this.f75266h.getText().length());
                h8.a.a().e0(false, LinearSwapPositionTradeDialogFragment.this.G.getContractShortType(), LinearSwapDepthType.STEP6, LinearSwapPositionTradeDialogFragment.this.f75263e0);
            }
        }
    }

    public interface i {
        void a();
    }

    public class j extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public boolean f75294b;

        /* renamed from: c  reason: collision with root package name */
        public ContractOrderPlace f75295c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                LinearSwapPositionTradeDialogFragment.this.dismiss();
            }
        }

        public j(ContractOrderPlace contractOrderPlace) {
            this.f75294b = contractOrderPlace.q() != 2;
            this.f75295c = contractOrderPlace;
        }

        public void onAfter() {
            super.onAfter();
            LinearSwapPositionTradeDialogFragment.this.f75271m.setVisibility(8);
            LinearSwapPositionTradeDialogFragment.this.f75272n.d();
            LinearSwapPositionTradeDialogFragment.this.f75269k.setEnabled(true);
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
                LinearSwapPositionTradeDialogFragment.this.t1(aPIStatusErrorException.getErrMsg());
            } else if (KycLimitCodeUtils.b(aPIStatusErrorException.getErrCode())) {
                LinearSwapPositionTradeDialogFragment.this.q(aPIStatusErrorException.getErrMsg());
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
                        if (this.f75294b) {
                            HuobiToastUtil.k(BaseApplication.b(), R.string.n_trail_fund_above_60_toast);
                            return;
                        }
                        break;
                    case 1:
                        LinearSwapPositionTradeDialogFragment.this.b1();
                        return;
                    case 2:
                        break;
                    default:
                        if (TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                            HuobiToastUtil.k(bh.j.c(), R.string.string_order_op_fail);
                            return;
                        } else {
                            HuobiToastUtil.l(bh.j.c(), aPIStatusErrorException.getErrMsg());
                            return;
                        }
                }
                String errMsg = aPIStatusErrorException.getErrMsg();
                ContractOrderPlace contractOrderPlace = this.f75295c;
                if (contractOrderPlace == null || !contractOrderPlace.Z()) {
                    z11 = false;
                }
                FutureOrderErrorHelper.c(errMsg, z11);
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
            LinearSwapPositionTradeDialogFragment.this.f75271m.setVisibility(0);
            LinearSwapPositionTradeDialogFragment.this.f75269k.setEnabled(false);
            LinearSwapPositionTradeDialogFragment.this.f75272n.c();
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
        String charSequence = this.f75266h.getHint() == null ? str : this.f75266h.getHint().toString();
        if (this.f75267i.getHint() != null) {
            str = this.f75267i.getHint().toString();
        }
        Hi(charSequence, str, this.f75266h.getText().toString(), this.f75267i.getText().toString(), 2, this.f75255a0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void pi(View view, boolean z11) {
        this.f75262e.setBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_5_radius_bg : R.drawable.custom_edittext_normal_5_radius_bg);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void qi(View view, boolean z11) {
        this.f75265g.setEditAreaBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_5_radius_bg : R.drawable.custom_edittext_normal_5_radius_bg);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ri(View view) {
        this.A.setVisibility(8);
        this.B.setVisibility(8);
        this.f75270l.setVisibility(0);
        this.f75258c.setVisibility(0);
        zi(this.f75282x, this.f75284z);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void si(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "hold_list");
        gs.g.j("flat", "usdt_contract", "confirm", hashMap);
        ContractOrderPlace contractOrderPlace = (ContractOrderPlace) view.getTag(R.id.item_data);
        oi(contractOrderPlace).subscribe(new j(contractOrderPlace));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ti(int i11) {
        Ii(i11);
        this.f75267i.clearFocus();
        Bf();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ui() {
        this.E = this.C.getHeight();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vi(RelativeLayout.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.C.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wi(RelativeLayout.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.C.setLayoutParams(layoutParams);
    }

    public final void Ai(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "translationX", new float[]{(float) this.T, 0.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, (float) (-this.T)});
        ofFloat2.setInterpolator(new LinearInterpolator());
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.E, this.F});
        ofInt.addUpdateListener(new i0(this, (RelativeLayout.LayoutParams) this.C.getLayoutParams()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofInt);
        animatorSet.setDuration(270);
        animatorSet.start();
    }

    public final void Bf() {
        this.f75266h.clearFocus();
        this.f75267i.clearFocus();
    }

    public final void Bi(LinearSwapPosition linearSwapPosition) {
        if (linearSwapPosition != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(getString(R.string.contract_trade_position_close));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.global_main_text_color)), 0, spannableStringBuilder.length(), 33);
            this.f75258c.setText(spannableStringBuilder.append(" ").append(a7.e.k(getContext(), linearSwapPosition.getSymbol(), this.G.getQuoteCurrency(), linearSwapPosition.getDirection(), linearSwapPosition.getLeverRate(), ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText), this.P, linearSwapPosition.getContractType())));
        }
    }

    public void Ci(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
        LinearSwapPosition e11 = linearSwapPositionOrderItem.e();
        this.H = e11;
        if (e11 != null) {
            this.G = linearSwapPositionOrderItem.d();
            this.I = this.H.getSymbol();
            this.J = this.H.getContractCode();
        }
    }

    public void Di(int i11) {
        this.P = i11;
    }

    public final void Ei(BigDecimal bigDecimal) {
        if (this.G != null) {
            if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                this.f75266h.setText("");
            } else {
                this.f75266h.setText(m.q(bigDecimal, FuturePrecisionUtil.y(this.G.getContractCode(), this.G.getContractShortType(), this.G.getOptionCode())));
            }
            EditText editText = this.f75266h;
            editText.setSelection(editText.getText().length());
        }
    }

    public final void Fi(ContractOrderPlace contractOrderPlace) {
        String str;
        String str2;
        BigDecimal a11 = m.a(contractOrderPlace.w());
        int Q2 = contractOrderPlace.Q();
        if (Q2 == 1) {
            str = String.format(getActivity().getString(R.string.two_label_with_space), new Object[]{a11.toPlainString(), this.G.getQuoteCurrency()});
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
        futureInsideConfirmItem2.g(a7.e.m(getContext(), this.G.getSymbol(), this.G.getQuoteCurrency(), this.G.getContractCode(), this.G.getContractType(), this.P));
        arrayList.add(futureInsideConfirmItem2);
        FutureInsideConfirmItem futureInsideConfirmItem3 = new FutureInsideConfirmItem();
        futureInsideConfirmItem3.f(getActivity().getString(R.string.contract_order_dialog_order_price_title));
        futureInsideConfirmItem3.g(str);
        arrayList.add(futureInsideConfirmItem3);
        FutureInsideConfirmItem futureInsideConfirmItem4 = new FutureInsideConfirmItem();
        futureInsideConfirmItem4.f(getActivity().getString(R.string.contract_order_dialog_amout_title));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.K.h());
        if (a7.e.G(TradeType.LINEAR_SWAP)) {
            str2 = "usdt".toUpperCase(Locale.US);
        } else {
            str2 = this.G.getSymbol();
        }
        sb2.append(str2);
        futureInsideConfirmItem4.g(sb2.toString());
        arrayList.add(futureInsideConfirmItem4);
        this.f75283y.setData(arrayList);
        this.A.setVisibility(0);
        this.B.setVisibility(0);
        this.f75270l.setVisibility(8);
        this.f75258c.setVisibility(8);
        this.D.setTag(R.id.item_data, contractOrderPlace);
        this.C.post(new g());
    }

    public final void Gi(ContractOrderPlace contractOrderPlace) {
        if (!contractOrderPlace.Y()) {
            return;
        }
        if (p0.b()) {
            Fi(contractOrderPlace);
        } else {
            oi(contractOrderPlace).subscribe(new j(contractOrderPlace));
        }
    }

    public void Hi(String str, String str2, String str3, String str4, int i11, int i12) {
        if (i12 != 1) {
            if (w2()) {
                str3 = BigDecimal.valueOf(this.M).toPlainString();
            } else {
                str3 = BigDecimal.valueOf(this.L).toPlainString();
            }
        }
        if (i12 == 1 && !ki(str3)) {
            HuobiToastUtil.l(bh.j.c(), String.format(bh.j.c().getString(R.string.input_unknow_text), new Object[]{str}));
        } else if (this.f75265g.getAmountType() != 0 || ji(str4)) {
            ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
            contractOrderPlace.N0(this.I);
            contractOrderPlace.B0(str3);
            contractOrderPlace.d0(str4);
            contractOrderPlace.h0(w2());
            contractOrderPlace.A0(i11);
            contractOrderPlace.X0(i12);
            contractOrderPlace.r0(m.a(this.H.getLastPrice()).doubleValue());
            contractOrderPlace.i0(this.L);
            contractOrderPlace.G0(this.M);
            contractOrderPlace.g0(this.f75265g.getAmountType());
            contractOrderPlace.v0(this.P);
            contractOrderPlace.E0(this.S);
            LinearSwapPosition linearSwapPosition = this.H;
            if (linearSwapPosition != null) {
                contractOrderPlace.s0(linearSwapPosition.getLeverRate());
            }
            if (w2()) {
                contractOrderPlace.W0(getString(R.string.contract_trade_buy_flat_empty));
            } else {
                contractOrderPlace.W0(getString(R.string.contract_trade_sell_flat_more));
            }
            contractOrderPlace.x0(getString(R.string.contract_trade_position_close_quick));
            ContractOrderPlace e11 = this.K.e(getActivity(), contractOrderPlace, this.G);
            if (this.G != null) {
                Gi(e11);
            }
        } else {
            HuobiToastUtil.l(bh.j.c(), String.format(bh.j.c().getString(R.string.input_unknow_text), new Object[]{str2}));
        }
    }

    public final void Ii(int i11) {
        BigDecimal bigDecimal;
        String str;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        if (this.f75265g.getAmountType() != 0) {
            ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
            contractOrderPlace.X0(1);
            contractOrderPlace.B0(this.f75266h.getText().toString());
            contractOrderPlace.y0(0);
            contractOrderPlace.i0(this.L);
            contractOrderPlace.G0(this.M);
            contractOrderPlace.r0(m.a(this.H.getLastPrice()).doubleValue());
            contractOrderPlace.h0(w2());
            contractOrderPlace.A0(2);
            contractOrderPlace.N0(this.I);
            contractOrderPlace.v0(this.P);
            contractOrderPlace.E0(this.S);
            ContractOrderPlace s11 = this.K.s(contractOrderPlace);
            this.S = i11;
            if (w2()) {
                bigDecimal = this.Q;
            } else {
                bigDecimal = this.R;
            }
            if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                this.U = "0";
                EditText editText = this.f75267i;
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
                str = m.m(FutureUnitUtil.d(bigDecimal4.toPlainString(), s11.w(), this.G.getContractFace(), tradeType), FuturePrecisionUtil.s(this.G.getContractCode(), this.G.getContractShortType(), this.G.getOptionCode()));
                this.U = bigDecimal4.toPlainString();
            } else if (a7.e.G(tradeType)) {
                BigDecimal divide2 = bigDecimal.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                if (divide2.compareTo(BigDecimal.ONE) >= 0 || divide2.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal3 = divide2.setScale(FuturePrecisionUtil.B(), 1);
                } else {
                    bigDecimal3 = BigDecimal.ONE;
                }
                str = m.m(FutureUnitUtil.d(bigDecimal3.toPlainString(), s11.w(), this.G.getContractFace(), tradeType), FuturePrecisionUtil.g(this.I));
                this.U = bigDecimal3.toPlainString();
            } else {
                BigDecimal divide3 = bigDecimal.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                if (divide3.compareTo(BigDecimal.ONE) >= 0 || divide3.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal2 = divide3.setScale(FuturePrecisionUtil.B(), 1);
                } else {
                    bigDecimal2 = BigDecimal.ONE;
                }
                String plainString = bigDecimal2.toPlainString();
                this.U = bigDecimal2.toPlainString();
                str = plainString;
            }
            if (TextUtils.isEmpty(str) || m.a(str).compareTo(BigDecimal.ZERO) == 0) {
                EditText editText2 = this.f75267i;
                editText2.setText(i11 + "%");
                return;
            }
            EditText editText3 = this.f75267i;
            editText3.setText(i11 + "%(≈ " + str + ")");
        }
    }

    public final void Ji(ContractOrderPlace contractOrderPlace) {
        String str;
        String str2;
        String plainString;
        String plainString2;
        int v11 = contractOrderPlace.v();
        if (r.x().F0()) {
            TradeType tradeType = TradeType.LINEAR_SWAP;
            if (a7.e.E(tradeType)) {
                if (v11 == 0) {
                    this.K.d(contractOrderPlace, this.G);
                    this.K.b(contractOrderPlace, this.G);
                } else {
                    this.K.c(contractOrderPlace, this.G);
                    this.K.a(contractOrderPlace, this.G);
                }
                if (this.K.g() == null) {
                    str = "";
                } else {
                    str = this.K.g().setScale(FuturePrecisionUtil.s(this.G.getContractCode(), this.G.getContractShortType(), this.G.getOptionCode()), 1).toPlainString();
                }
                if (this.K.k() != null) {
                    str2 = this.K.k().setScale(FuturePrecisionUtil.s(this.G.getContractCode(), this.G.getContractShortType(), this.G.getOptionCode()), 1).toPlainString();
                }
            } else if (a7.e.G(tradeType)) {
                if (v11 == 0) {
                    this.K.d(contractOrderPlace, this.G);
                    this.K.b(contractOrderPlace, this.G);
                } else {
                    this.K.c(contractOrderPlace, this.G);
                    this.K.a(contractOrderPlace, this.G);
                }
                if (this.K.g() == null) {
                    plainString2 = "";
                } else {
                    plainString2 = this.K.g().setScale(FuturePrecisionUtil.g(this.I)).toPlainString();
                }
                if (this.K.k() != null) {
                    str2 = this.K.k().setScale(FuturePrecisionUtil.g(this.I)).toPlainString();
                }
            } else {
                if (v11 == 0) {
                    this.K.d(contractOrderPlace, this.G);
                } else {
                    this.K.c(contractOrderPlace, this.G);
                }
                if (this.K.i() == null) {
                    plainString = "";
                } else {
                    plainString = this.K.i().toPlainString();
                }
                if (this.K.j() != null) {
                    str2 = this.K.j().toPlainString();
                }
            }
            str2 = "";
        } else {
            str = "";
            str2 = str;
        }
        if (this.K.i() == null) {
            this.Q = BigDecimal.ZERO;
        } else {
            this.Q = this.K.i();
        }
        if (this.K.j() == null) {
            this.R = BigDecimal.ZERO;
        } else {
            this.R = this.K.j();
        }
        TradeType tradeType2 = TradeType.LINEAR_SWAP;
        boolean E2 = a7.e.E(tradeType2);
        boolean G2 = a7.e.G(tradeType2);
        if (E2) {
            if (w2()) {
                if (TextUtils.isEmpty(str)) {
                    this.f75264f.setText("");
                    return;
                }
                this.f75264f.setText(String.format(getContext().getString(R.string.n_contract_trade_close_margin_available), new Object[]{str, this.I}));
            } else if (TextUtils.isEmpty(str2)) {
                this.f75264f.setText("");
            } else {
                this.f75264f.setText(String.format(getContext().getString(R.string.n_contract_trade_close_margin_available), new Object[]{str2, this.I}));
            }
        } else if (G2) {
            if (w2()) {
                if (TextUtils.isEmpty(str)) {
                    this.f75264f.setText("");
                    return;
                }
                this.f75264f.setText(String.format(getContext().getString(R.string.n_contract_trade_close_margin_available), new Object[]{str, "usdt".toUpperCase(Locale.US)}));
            } else if (TextUtils.isEmpty(str2)) {
                this.f75264f.setText("");
            } else {
                this.f75264f.setText(String.format(getContext().getString(R.string.n_contract_trade_close_margin_available), new Object[]{str2, "usdt".toUpperCase(Locale.US)}));
            }
        } else if (w2()) {
            if (TextUtils.isEmpty(str)) {
                this.f75264f.setText("");
                return;
            }
            this.f75264f.setText(String.format(getContext().getString(R.string.n_contract_trade_close_margin_available), new Object[]{str, getContext().getString(R.string.contract_market_vol_sheet)}));
        } else if (TextUtils.isEmpty(str2)) {
            this.f75264f.setText("");
        } else {
            this.f75264f.setText(String.format(getContext().getString(R.string.n_contract_trade_close_margin_available), new Object[]{str2, getContext().getString(R.string.contract_market_vol_sheet)}));
        }
    }

    public final void Ki(List<Double[]> list, int i11) {
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

    public void Li(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
        Ci(linearSwapPositionOrderItem);
        Mi();
    }

    public final void Mi() {
        int y11 = FuturePrecisionUtil.y(this.G.getContractCode(), this.G.getContractShortType(), this.G.getOptionCode());
        BigDecimal scale = m.a(this.H.getAvgCostPrice()).setScale(y11, 1);
        BigDecimal scale2 = m.a(this.H.getPositionPrice()).setScale(y11, 1);
        this.f75259c0 = scale2;
        int i11 = this.f75257b0;
        if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4) {
            Ei(scale2);
        } else if (TextUtils.isEmpty(this.f75266h.getText().toString())) {
            Ei(this.f75259c0);
        }
        this.f75279u.setText(scale.toPlainString());
        this.f75280v.setText(scale2.toPlainString());
        this.f75281w.setText(n0.a(getContext(), FuturePrecisionUtil.q(this.I), m.a(this.H.getProfitRate()).multiply(m.f68179a).toPlainString()));
        ii();
    }

    public void V6(CommonPopListItem commonPopListItem) {
        this.f75257b0 = commonPopListItem.getType();
        this.Y.dismiss();
        this.W.setText(commonPopListItem.getText());
        int i11 = this.f75257b0;
        if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4) {
            if (i11 == 1) {
                this.f75255a0 = 8;
            } else if (i11 == 2) {
                this.f75255a0 = 3;
            } else if (i11 == 3) {
                this.f75255a0 = 4;
            } else if (i11 == 4) {
                this.f75255a0 = 5;
            }
            this.f75260d.setVisibility(8);
            this.X.setVisibility(0);
            this.O.hideKeyboard();
            Ei(this.f75259c0);
            return;
        }
        this.f75255a0 = 1;
        this.f75260d.setVisibility(0);
        this.X.setVisibility(8);
        this.f75266h.setText(this.f75261d0);
        EditText editText = this.f75266h;
        editText.setSelection(editText.getText().length());
    }

    public void addEvent(i6.r rVar) {
        this.f75262e.setOnEditTextFocusChangeListener(new g0(this));
        this.f75265g.setOnEditTextFocusChangeListener(new f0(this));
        this.f75270l.setOnClickListener(new k0(this));
        this.f75266h.addTextChangedListener(new e());
        this.f75267i.addTextChangedListener(new f());
        this.f75269k.setOnClickListener(new j0(this));
        this.A.setOnClickListener(new cn.n0(this));
        this.D.setOnClickListener(new m0(this));
        this.f75265g.initProgressListener(new q0(this));
    }

    public void afterInit() {
        Bi(this.H);
        FutureContractInfo futureContractInfo = this.G;
        if (futureContractInfo != null) {
            d2(FuturePrecisionUtil.y(futureContractInfo.getContractCode(), this.G.getContractShortType(), this.G.getOptionCode()));
        }
        if (this.G != null) {
            h8.a.a().e0(true, this.G.getContractCode(), LinearSwapDepthType.STEP6, this.f75263e0);
        }
    }

    public final void b1() {
        KycAndHasTradeDialogUtils.m(getContext());
    }

    public void d2(int i11) {
        this.f75262e.setLength(i11);
    }

    public void dismiss() {
        i iVar = this.N;
        if (iVar != null) {
            iVar.a();
        }
        super.dismiss();
    }

    public void fi(EditText editText, Editable editable, boolean z11) {
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
            this.U = editText.getText().toString();
            ii();
            return;
        }
        editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        String str = null;
        TradeType tradeType = TradeType.LINEAR_SWAP;
        if (a7.e.E(tradeType)) {
            if (this.f75265g.getAmountType() == 0) {
                str = m.b(editable, 10, FuturePrecisionUtil.s(this.G.getContractCode(), this.G.getContractShortType(), this.G.getOptionCode()));
            }
            if (str != null) {
                editText.setText(str);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else {
            if (this.f75265g.getAmountType() == 0) {
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
        if (this.f75265g.getAmountType() == 0) {
            this.U = FutureUnitUtil.e(editText.getText().toString(), this.H.getLastPrice(), this.G.getContractFace(), tradeType, 0);
        }
        ii();
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

    public void gi(boolean z11) {
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.X0(1);
        contractOrderPlace.B0(this.f75266h.getText().toString());
        contractOrderPlace.y0(0);
        contractOrderPlace.i0(this.L);
        contractOrderPlace.G0(this.M);
        contractOrderPlace.r0(m.a(this.H.getLastPrice()).doubleValue());
        contractOrderPlace.h0(w2());
        contractOrderPlace.A0(2);
        contractOrderPlace.N0(this.I);
        contractOrderPlace.v0(this.P);
        contractOrderPlace.E0(this.S);
        Ji(this.K.s(contractOrderPlace));
        if (z11) {
            ki(this.f75266h.getText().toString());
        }
        if (!TextUtils.isEmpty(this.f75267i.getText())) {
            Ii(this.S);
        }
        ii();
    }

    public void hi(EditText editText, Editable editable, boolean z11) {
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        String b11 = m.b(editable, 10, FuturePrecisionUtil.y(this.G.getContractCode(), this.G.getContractShortType(), this.G.getOptionCode()));
        if (b11 != null) {
            editText.setText(b11);
            editText.setSelection(editText.getText().length());
            return;
        }
        gi(z11);
    }

    public boolean ic(CommonPopListItem commonPopListItem) {
        return this.f75257b0 == commonPopListItem.getType();
    }

    public final void ii() {
        if (TextUtils.isEmpty(this.f75266h.getText()) || TextUtils.isEmpty(this.f75267i.getText())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("-- " + this.H.getMarginAsset());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.baseColorSecondaryText)), 0, spannableStringBuilder.length(), 33);
            this.f75275q.setText(spannableStringBuilder);
            return;
        }
        int w11 = FuturePrecisionUtil.w(this.G.getContractCode(), this.G.getContractShortType(), this.G.getOptionCode());
        if ("buy".equalsIgnoreCase(this.H.getDirection())) {
            this.f75275q.setText(a7.b.e(a7.b.a(this.H.getAvgCostPrice(), this.f75266h.getText().toString(), this.G.getContractFace(), this.U, "--", TradeType.LINEAR_SWAP), w11, this.H.getMarginAsset(), getContext()));
            return;
        }
        this.f75275q.setText(a7.b.e(a7.b.c(this.H.getAvgCostPrice(), this.f75266h.getText().toString(), this.G.getContractFace(), this.U, "--", TradeType.LINEAR_SWAP), w11, this.H.getMarginAsset(), getContext()));
    }

    public void initView(i6.r rVar) {
        rVar.b(R.id.dialog_contract_bg).setOnClickListener(new l0(this));
        this.T = PixelUtils.g();
        this.f75256b = (LinearLayout) rVar.b(R.id.ll_root);
        this.f75258c = (TextView) rVar.b(R.id.dialog_contract_name_tv);
        this.f75260d = (ViewGroup) rVar.b(R.id.dialog_contract_price_root);
        TradePriceEditext tradePriceEditext = (TradePriceEditext) rVar.b(R.id.dialog_contract_price_et);
        this.f75262e = tradePriceEditext;
        tradePriceEditext.setTradeType(TradeType.CONTRACT);
        this.f75270l = rVar.b(R.id.dialog_cancel_iv);
        this.f75266h = this.f75262e.getEditText();
        ContractTradeAmountPercentEdittext contractTradeAmountPercentEdittext = (ContractTradeAmountPercentEdittext) rVar.b(R.id.dialog_contract_amount_et);
        this.f75265g = contractTradeAmountPercentEdittext;
        contractTradeAmountPercentEdittext.setTradeType(TradeType.SWAP);
        TradeType tradeType = TradeType.LINEAR_SWAP;
        if (a7.e.E(tradeType)) {
            this.f75265g.setLabel(this.I);
        } else if (a7.e.G(tradeType)) {
            this.f75265g.setLabel("usdt".toUpperCase(Locale.US));
        }
        this.f75267i = this.f75265g.getEditText();
        this.f75264f = (TextView) rVar.b(R.id.dialog_contract_position_tv);
        this.f75268j = (TextView) rVar.b(R.id.dialog_position_trade_tv);
        this.f75269k = rVar.b(R.id.dialog_position_trade);
        this.f75271m = rVar.b(R.id.dialog_loading);
        LoadingView loadingView = (LoadingView) rVar.b(R.id.loading_dialog_loading_view);
        this.f75272n = loadingView;
        loadingView.setLottieAnimationRes(R.raw.nd_middle_bg);
        this.K = new z((k2) null);
        this.f75276r = (TextView) rVar.b(R.id.open_price_label_tv);
        this.f75277s = (TextView) rVar.b(R.id.last_price_label_tv);
        this.f75278t = (TextView) rVar.b(R.id.profit_rate_label_tv);
        this.f75279u = (TextView) rVar.b(R.id.open_price_value_tv);
        this.f75280v = (TextView) rVar.b(R.id.last_price_value_tv);
        this.f75281w = (TextView) rVar.b(R.id.profit_rate_value_tv);
        this.f75273o = rVar.b(R.id.price_profit_container);
        this.f75274p = rVar.b(R.id.estimate_profit_container);
        this.f75275q = (TextView) rVar.b(R.id.estimate_profit_value_tv);
        this.f75283y = (EasyRecyclerView) rVar.b(R.id.confirm_rv);
        View b11 = rVar.b(R.id.confirm_container);
        this.f75282x = b11;
        b11.setVisibility(0);
        this.f75282x.setTranslationX((float) this.T);
        this.f75284z = rVar.b(R.id.position_input_container);
        this.B = (TextView) rVar.b(R.id.dialog_center_title_tv);
        this.A = (ImageView) rVar.b(R.id.dialog_back_iv);
        this.C = rVar.b(R.id.content_container);
        this.D = rVar.b(R.id.confirm_btn_container);
        TextView textView = this.f75276r;
        Locale locale = Locale.ENGLISH;
        textView.setText(String.format(locale, getContext().getString(R.string.n_linear_swap_open_price), new Object[]{this.G.getQuoteCurrency()}));
        this.f75277s.setText(String.format(locale, getContext().getString(R.string.n_contract_last_price_unit), new Object[]{this.G.getQuoteCurrency()}));
        this.Z = (ViewGroup) rVar.b(R.id.fl_position_price_type_container);
        this.V = (ImageView) rVar.b(R.id.iv_price_type_menu);
        this.W = (TextView) rVar.b(R.id.tv_price_type_menu);
        this.X = rVar.b(R.id.tv_direct_market_price);
        ArrayList arrayList = new ArrayList();
        CommonPopListItem commonPopListItem = new CommonPopListItem(0, getResources().getString(R.string.n_contract_order_type_limit), this);
        arrayList.add(commonPopListItem);
        arrayList.add(new CommonPopListItem(1, getResources().getString(R.string.n_exchange_order_list_market), this));
        arrayList.add(new CommonPopListItem(2, getResources().getString(R.string.n_contract_trade_optimal_five), this));
        arrayList.add(new CommonPopListItem(3, getResources().getString(R.string.n_contract_trade_optimal_ten), this));
        arrayList.add(new CommonPopListItem(4, getResources().getString(R.string.n_contract_trade_optimal_twenty), this));
        this.Y.setData(arrayList);
        this.Y.setFollowViewWidth(true);
        this.Y.setDialogFragmentListener(new a());
        this.Z.setOnClickListener(new b());
        this.W.post(new c(commonPopListItem));
        Mi();
        HuobiBottomDialogKeyboardHelper huobiBottomDialogKeyboardHelper = new HuobiBottomDialogKeyboardHelper();
        this.O = huobiBottomDialogKeyboardHelper;
        huobiBottomDialogKeyboardHelper.attach(getActivity(), this.f75256b).registerInput(this.f75266h, this.f75267i);
        this.f75266h.setOnFocusChangeListener(new d());
        this.f75265g.setKeyboardHelper(this.O);
        if (!(this.H == null || this.G == null)) {
            z zVar = this.K;
            zVar.u0(this.G.getContractCode() + "_" + this.H.getMarginMode() + this.H.getDirection(), this.H);
        }
        FutureContractInfo futureContractInfo = this.G;
        if (futureContractInfo != null) {
            this.f75262e.setLabel(futureContractInfo.getQuoteCurrency());
        }
        i6.i.b().f(new h0(this));
    }

    public boolean isTransparent() {
        return false;
    }

    public boolean ji(String str) {
        return m.a(str).compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean ki(String str) {
        return m.a(str).compareTo(BigDecimal.ZERO) > 0;
    }

    public String li() {
        LinearSwapPosition linearSwapPosition = this.H;
        if (linearSwapPosition == null) {
            return null;
        }
        return linearSwapPosition.getContractCode();
    }

    public String mi() {
        LinearSwapPosition linearSwapPosition = this.H;
        if (linearSwapPosition == null) {
            return null;
        }
        return linearSwapPosition.getDirection();
    }

    public int ni() {
        return this.P;
    }

    public final Observable<Object> oi(ContractOrderPlace contractOrderPlace) {
        return this.K.w0(contractOrderPlace, this.G).compose(RxJavaHelper.t((u6.g) null));
    }

    public void q(String str) {
        KycAndHasTradeDialogUtils.l(getContext(), str, cn.p0.f13181a);
    }

    public void t1(String str) {
        KycAndHasTradeDialogUtils.n(getContext(), str, o0.f13176a);
    }

    public final boolean w2() {
        LinearSwapPosition linearSwapPosition = this.H;
        return linearSwapPosition == null || !"buy".equalsIgnoreCase(linearSwapPosition.getDirection());
    }

    public final void zi(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "translationX", new float[]{(float) (-this.T), 0.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, (float) this.T});
        ofFloat2.setInterpolator(new LinearInterpolator());
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.F, this.E});
        ofInt.addUpdateListener(new e0(this, (RelativeLayout.LayoutParams) this.C.getLayoutParams()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofInt);
        animatorSet.setDuration(270);
        animatorSet.start();
    }
}
