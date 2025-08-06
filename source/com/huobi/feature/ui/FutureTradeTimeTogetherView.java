package com.huobi.feature.ui;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import cn.k2;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FeatureTradeTimeInfo;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCurrentOrderInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.dialog.CommonListPopupDialog;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractCalmPeriodInfo;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.entity.ContractOrderTimingRequestData;
import com.huobi.contract.ui.ContractGearsTradePriceEditText;
import com.huobi.feature.util.ContractCalmPeriodHelper;
import com.huobi.feature.util.FutureEarnestMoneyUtils;
import com.huobi.linearswap.bean.ContractLastPriceEvent;
import com.huobi.linearswap.bean.ContractPositionEvent;
import com.huobi.view.seekbar.MultiColorSeekBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.k4;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;
import nk.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pk.a0;
import pk.x;
import pk.y;
import pro.huobi.R;
import tg.r;
import ym.z;

public class FutureTradeTimeTogetherView extends FrameLayout implements a.C0579a {
    public TextView A;
    public View B;
    public View C;
    public TextView D;
    public TextView E;
    public TradeType F;
    public String G;
    public FeatureTradeTimeInfo H;
    public String I;
    public String J;
    public ViewGroup K;
    public TextView L;
    public ViewGroup M;
    public TextView N;
    public int O;
    public String P;
    public String Q;
    public int R;
    public FutureContractInfo S;
    public z T;
    public double U;
    public double V;
    public double W;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f44733a0;

    /* renamed from: b  reason: collision with root package name */
    public Context f44734b;

    /* renamed from: b0  reason: collision with root package name */
    public int f44735b0;

    /* renamed from: c  reason: collision with root package name */
    public final CommonListPopupDialog f44736c;

    /* renamed from: c0  reason: collision with root package name */
    public String f44737c0;

    /* renamed from: d  reason: collision with root package name */
    public View f44738d;

    /* renamed from: d0  reason: collision with root package name */
    public BigDecimal f44739d0;

    /* renamed from: e  reason: collision with root package name */
    public TextView f44740e;

    /* renamed from: e0  reason: collision with root package name */
    public BigDecimal f44741e0;

    /* renamed from: f  reason: collision with root package name */
    public ContractGearsTradePriceEditText f44742f;

    /* renamed from: f0  reason: collision with root package name */
    public String f44743f0;

    /* renamed from: g  reason: collision with root package name */
    public ContractGearsTradePriceEditText f44744g;

    /* renamed from: g0  reason: collision with root package name */
    public String f44745g0;

    /* renamed from: h  reason: collision with root package name */
    public ContractGearsTradePriceEditText f44746h;

    /* renamed from: h0  reason: collision with root package name */
    public LinearSwapAccountInfo f44747h0;

    /* renamed from: i  reason: collision with root package name */
    public ContractGearsTradePriceEditText f44748i;

    /* renamed from: i0  reason: collision with root package name */
    public LinearSwapPosition f44749i0;

    /* renamed from: j  reason: collision with root package name */
    public ContractGearsTradePriceEditText f44750j;

    /* renamed from: j0  reason: collision with root package name */
    public nk.a f44751j0;

    /* renamed from: k  reason: collision with root package name */
    public EditText f44752k;

    /* renamed from: k0  reason: collision with root package name */
    public a.C0579a f44753k0;

    /* renamed from: l  reason: collision with root package name */
    public EditText f44754l;

    /* renamed from: l0  reason: collision with root package name */
    public String f44755l0;

    /* renamed from: m  reason: collision with root package name */
    public EditText f44756m;

    /* renamed from: m0  reason: collision with root package name */
    public String f44757m0;

    /* renamed from: n  reason: collision with root package name */
    public EditText f44758n;

    /* renamed from: n0  reason: collision with root package name */
    public String f44759n0;

    /* renamed from: o  reason: collision with root package name */
    public EditText f44760o;

    /* renamed from: p  reason: collision with root package name */
    public FragmentActivity f44761p;

    /* renamed from: q  reason: collision with root package name */
    public int f44762q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f44763r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f44764s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f44765t;

    /* renamed from: t0  reason: collision with root package name */
    public String f44766t0;

    /* renamed from: u  reason: collision with root package name */
    public TextView f44767u;

    /* renamed from: u0  reason: collision with root package name */
    public String f44768u0;

    /* renamed from: v  reason: collision with root package name */
    public View f44769v;

    /* renamed from: v0  reason: collision with root package name */
    public View f44770v0;

    /* renamed from: w  reason: collision with root package name */
    public View f44771w;

    /* renamed from: w0  reason: collision with root package name */
    public final CommonPopListItem.a f44772w0;

    /* renamed from: x  reason: collision with root package name */
    public MultiColorSeekBar f44773x;

    /* renamed from: y  reason: collision with root package name */
    public int f44774y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f44775z;

    public class a implements MultiColorSeekBar.OnProgressChangedListener {
        public a() {
        }

        public void getProgressOnActionUp(MultiColorSeekBar multiColorSeekBar, int i11, float f11) {
        }

        public void getProgressOnFinally(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
        }

        public void onProgressChanged(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
            if (z11) {
                FutureTradeTimeTogetherView.this.H(i11);
            }
        }
    }

    public class b implements CommonPopListItem.a {
        public b() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            FutureTradeTimeTogetherView.this.f44740e.setText(commonPopListItem.getText());
            int unused = FutureTradeTimeTogetherView.this.f44762q = commonPopListItem.getType();
            if (FutureTradeTimeTogetherView.this.f44762q == 0) {
                FutureTradeTimeTogetherView.this.f44742f.setHintText(FutureTradeTimeTogetherView.this.f44766t0);
                FutureTradeTimeTogetherView.this.f44752k.setText("");
                FutureTradeTimeTogetherView.this.f44742f.setLabel("usdt".toUpperCase(Locale.US));
            } else if (FutureTradeTimeTogetherView.this.f44762q == 1) {
                FutureTradeTimeTogetherView.this.f44742f.setHintText(FutureTradeTimeTogetherView.this.f44768u0);
                FutureTradeTimeTogetherView.this.f44752k.setText("");
                FutureTradeTimeTogetherView.this.f44742f.setLabel("%");
            }
            FutureTradeTimeTogetherView.this.f44736c.dismiss();
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return false;
        }
    }

    public class c implements k4 {
        public c() {
        }

        public void onFocusChange(View view, boolean z11) {
            FutureTradeTimeTogetherView futureTradeTimeTogetherView = FutureTradeTimeTogetherView.this;
            futureTradeTimeTogetherView.c0(futureTradeTimeTogetherView.f44742f, z11);
        }
    }

    public class d implements k4 {
        public d() {
        }

        public void onFocusChange(View view, boolean z11) {
            FutureTradeTimeTogetherView futureTradeTimeTogetherView = FutureTradeTimeTogetherView.this;
            futureTradeTimeTogetherView.c0(futureTradeTimeTogetherView.f44744g, z11);
        }
    }

    public class e implements k4 {
        public e() {
        }

        public void onFocusChange(View view, boolean z11) {
            FutureTradeTimeTogetherView futureTradeTimeTogetherView = FutureTradeTimeTogetherView.this;
            futureTradeTimeTogetherView.c0(futureTradeTimeTogetherView.f44744g, z11);
        }
    }

    public class f implements k4 {
        public f() {
        }

        public void onFocusChange(View view, boolean z11) {
            FutureTradeTimeTogetherView futureTradeTimeTogetherView = FutureTradeTimeTogetherView.this;
            futureTradeTimeTogetherView.c0(futureTradeTimeTogetherView.f44748i, z11);
            if (z11) {
                FutureTradeTimeTogetherView futureTradeTimeTogetherView2 = FutureTradeTimeTogetherView.this;
                futureTradeTimeTogetherView2.k0(futureTradeTimeTogetherView2.f44758n.getText().toString());
                return;
            }
            FutureTradeTimeTogetherView.this.K.setVisibility(8);
        }
    }

    public class g implements k4 {
        public g() {
        }

        public void onFocusChange(View view, boolean z11) {
            FutureTradeTimeTogetherView futureTradeTimeTogetherView = FutureTradeTimeTogetherView.this;
            futureTradeTimeTogetherView.c0(futureTradeTimeTogetherView.f44750j, z11);
            if (z11) {
                FutureTradeTimeTogetherView.this.setProgress(0);
                if (FutureTradeTimeTogetherView.this.O == 5) {
                    FutureTradeTimeTogetherView.this.f44760o.setText("");
                }
                int unused = FutureTradeTimeTogetherView.this.O = 0;
                FutureTradeTimeTogetherView futureTradeTimeTogetherView2 = FutureTradeTimeTogetherView.this;
                futureTradeTimeTogetherView2.l0(futureTradeTimeTogetherView2.f44760o.getText().toString());
                return;
            }
            FutureTradeTimeTogetherView.this.M.setVisibility(8);
        }
    }

    public class h implements TextWatcher {
        public h() {
        }

        public void afterTextChanged(Editable editable) {
            if (FutureTradeTimeTogetherView.this.f44762q == 0) {
                String b11 = FutureTradeTimeTogetherView.this.H != null ? m.b(editable, 10, FuturePrecisionUtil.y(FutureTradeTimeTogetherView.this.S.getContractCode(), FutureTradeTimeTogetherView.this.S.getContractShortType(), FutureTradeTimeTogetherView.this.S.getOptionCode())) : null;
                if (b11 != null) {
                    FutureTradeTimeTogetherView futureTradeTimeTogetherView = FutureTradeTimeTogetherView.this;
                    futureTradeTimeTogetherView.j0(futureTradeTimeTogetherView.f44752k, b11);
                    return;
                }
                return;
            }
            String b12 = m.b(editable, 10, 2);
            if (b12 != null) {
                FutureTradeTimeTogetherView futureTradeTimeTogetherView2 = FutureTradeTimeTogetherView.this;
                futureTradeTimeTogetherView2.j0(futureTradeTimeTogetherView2.f44752k, b12);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class i implements TextWatcher {
        public i() {
        }

        public void afterTextChanged(Editable editable) {
            String b11;
            if (FutureTradeTimeTogetherView.this.H != null && (b11 = m.b(editable, 10, FuturePrecisionUtil.y(FutureTradeTimeTogetherView.this.S.getContractCode(), FutureTradeTimeTogetherView.this.S.getContractShortType(), FutureTradeTimeTogetherView.this.S.getOptionCode()))) != null) {
                FutureTradeTimeTogetherView futureTradeTimeTogetherView = FutureTradeTimeTogetherView.this;
                futureTradeTimeTogetherView.j0(futureTradeTimeTogetherView.f44754l, b11);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class j implements TextWatcher {
        public j() {
        }

        public void afterTextChanged(Editable editable) {
            String K;
            if ((a7.e.E(FutureTradeTimeTogetherView.this.F) || a7.e.G(FutureTradeTimeTogetherView.this.F)) && (K = FutureTradeTimeTogetherView.this.K(editable)) != null) {
                FutureTradeTimeTogetherView futureTradeTimeTogetherView = FutureTradeTimeTogetherView.this;
                futureTradeTimeTogetherView.j0(futureTradeTimeTogetherView.f44758n, K);
            } else if (a7.e.G(FutureTradeTimeTogetherView.this.F)) {
                FutureTradeTimeTogetherView.this.k0(editable.toString());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class k implements TextWatcher {
        public k() {
        }

        public void afterTextChanged(Editable editable) {
            String K;
            if (editable.length() == 0) {
                int unused = FutureTradeTimeTogetherView.this.O = 0;
            }
            String obj = editable.toString();
            if (FutureTradeTimeTogetherView.this.O == 0) {
                if (FutureTradeTimeTogetherView.this.f44774y == 0) {
                    String unused2 = FutureTradeTimeTogetherView.this.P = obj;
                } else {
                    String unused3 = FutureTradeTimeTogetherView.this.Q = obj;
                }
            }
            if (editable.length() == 0) {
                FutureTradeTimeTogetherView.this.f44760o.setTypeface(ResourcesCompat.h(FutureTradeTimeTogetherView.this.getContext(), R.font.roboto_regular));
                FutureTradeTimeTogetherView.this.a0();
            } else {
                FutureTradeTimeTogetherView.this.f44760o.setTypeface(ResourcesCompat.h(FutureTradeTimeTogetherView.this.getContext(), R.font.roboto_medium));
            }
            String str = null;
            if (!a7.e.E(FutureTradeTimeTogetherView.this.F) && !a7.e.G(FutureTradeTimeTogetherView.this.F)) {
                if (FutureTradeTimeTogetherView.this.O == 0) {
                    if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
                        str = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
                    } else {
                        str = m.b(editable, 10, FuturePrecisionUtil.B());
                    }
                }
                if (str != null) {
                    FutureTradeTimeTogetherView futureTradeTimeTogetherView = FutureTradeTimeTogetherView.this;
                    futureTradeTimeTogetherView.j0(futureTradeTimeTogetherView.f44760o, str);
                    return;
                }
            } else if (FutureTradeTimeTogetherView.this.O == 0 && (K = FutureTradeTimeTogetherView.this.K(editable)) != null) {
                FutureTradeTimeTogetherView futureTradeTimeTogetherView2 = FutureTradeTimeTogetherView.this;
                futureTradeTimeTogetherView2.j0(futureTradeTimeTogetherView2.f44760o, K);
                return;
            }
            FutureTradeTimeTogetherView.this.a0();
            if (a7.e.G(FutureTradeTimeTogetherView.this.F)) {
                FutureTradeTimeTogetherView.this.l0(editable.toString());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public FutureTradeTimeTogetherView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V() {
        this.f44736c.showAsDropDown(this.f44761p.getSupportFragmentManager(), this.f44738d);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void W(View view) {
        O();
        this.f44738d.postDelayed(new a0(this), 300);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void X(View view) {
        if (ContractCalmPeriodHelper.d()) {
            ContractCalmPeriodHelper.h(getResources());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (this.f44774y == 1 && this.f44739d0.compareTo(BigDecimal.ZERO) <= 0) {
            Context context = this.f44734b;
            HuobiToastUtil.l(context, context.getString(R.string.contract_trade_close_available_not_enough));
        } else if (this.f44774y == 1 && this.O == 0 && m.a(this.f44760o.getText().toString()).compareTo(this.f44739d0) > 0) {
            Context context2 = this.f44734b;
            HuobiToastUtil.l(context2, context2.getString(R.string.contract_trade_close_available_not_enough));
        } else if (this.f44774y == 0 && this.f44739d0.compareTo(BigDecimal.ZERO) <= 0) {
            Context context3 = this.f44734b;
            HuobiToastUtil.l(context3, context3.getString(R.string.n_contract_trade_available_not_enough));
        } else if (this.f44774y == 0 && this.O == 0 && m.a(this.f44760o.getText().toString()).compareTo(this.f44739d0) > 0) {
            Context context4 = this.f44734b;
            HuobiToastUtil.l(context4, context4.getString(R.string.n_contract_trade_available_not_enough));
        } else if (!this.f44751j0.b(true, this.f44752k.getText().toString(), String.valueOf(this.W), this.f44762q) && !this.f44751j0.f(this.f44754l) && !this.f44751j0.c(this.f44756m.getText().toString())) {
            BigDecimal bigDecimal = new BigDecimal(this.W);
            BigDecimal a11 = m.a(this.f44758n.getText().toString());
            if (this.O == 5) {
                BigDecimal divide = new BigDecimal(this.f44773x.getProgress()).multiply(this.f44739d0).divide(m.f68179a, 32, 1);
                if (!this.f44751j0.a(a11, divide)) {
                    int i11 = this.f44774y;
                    if (i11 == 0) {
                        if (!this.f44751j0.d(a11, i11, bigDecimal, this.F, this.S)) {
                            if (!this.f44751j0.d(divide, this.f44774y, bigDecimal, this.F, this.S)) {
                                this.f44751j0.l(N(true));
                            }
                        }
                    } else {
                        this.f44751j0.l(N(true));
                    }
                }
            } else {
                BigDecimal a12 = m.a(this.f44760o.getText().toString());
                if (!this.f44751j0.a(a11, a12)) {
                    int i12 = this.f44774y;
                    if (i12 == 0) {
                        if (!this.f44751j0.d(a11, i12, bigDecimal, this.F, this.S)) {
                            if (!this.f44751j0.d(a12, this.f44774y, bigDecimal, this.F, this.S)) {
                                this.f44751j0.l(N(true));
                            }
                        }
                    } else {
                        this.f44751j0.l(N(true));
                    }
                }
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Y(View view) {
        if (ContractCalmPeriodHelper.d()) {
            ContractCalmPeriodHelper.h(getResources());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (this.f44774y == 1 && this.f44741e0.compareTo(BigDecimal.ZERO) <= 0) {
            Context context = this.f44734b;
            HuobiToastUtil.l(context, context.getString(R.string.contract_trade_close_available_not_enough));
        } else if (this.f44774y == 1 && this.O == 0 && m.a(this.f44760o.getText().toString()).compareTo(this.f44741e0) > 0) {
            Context context2 = this.f44734b;
            HuobiToastUtil.l(context2, context2.getString(R.string.contract_trade_close_available_not_enough));
        } else if (this.f44774y == 0 && this.f44741e0.compareTo(BigDecimal.ZERO) <= 0) {
            Context context3 = this.f44734b;
            HuobiToastUtil.l(context3, context3.getString(R.string.n_contract_trade_available_not_enough));
        } else if (this.f44774y == 0 && this.O == 0 && m.a(this.f44760o.getText().toString()).compareTo(this.f44741e0) > 0) {
            Context context4 = this.f44734b;
            HuobiToastUtil.l(context4, context4.getString(R.string.n_contract_trade_available_not_enough));
        } else if (!this.f44751j0.b(true, this.f44752k.getText().toString(), String.valueOf(this.W), this.f44762q)) {
            BigDecimal a11 = m.a(this.f44758n.getText().toString());
            BigDecimal bigDecimal = new BigDecimal(this.W);
            if (!this.f44751j0.f(this.f44754l) && !this.f44751j0.c(this.f44756m.getText().toString())) {
                if (this.O == 5) {
                    BigDecimal divide = new BigDecimal(this.f44773x.getProgress()).multiply(this.f44741e0).divide(m.f68179a, 32, 1);
                    if (!this.f44751j0.a(a11, divide)) {
                        int i11 = this.f44774y;
                        if (i11 == 0) {
                            if (!this.f44751j0.d(a11, i11, bigDecimal, this.F, this.S)) {
                                if (!this.f44751j0.d(divide, this.f44774y, bigDecimal, this.F, this.S)) {
                                    this.f44751j0.l(N(false));
                                }
                            }
                        } else {
                            this.f44751j0.l(N(false));
                        }
                    }
                } else {
                    BigDecimal a12 = m.a(this.f44760o.getText().toString());
                    if (!this.f44751j0.a(a11, a12)) {
                        int i12 = this.f44774y;
                        if (i12 == 0) {
                            if (!this.f44751j0.d(a11, i12, bigDecimal, this.F, this.S)) {
                                if (!this.f44751j0.d(a12, this.f44774y, bigDecimal, this.F, this.S)) {
                                    this.f44751j0.l(N(false));
                                }
                            }
                        } else {
                            this.f44751j0.l(N(false));
                        }
                    }
                }
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private boolean getPositionModeSingle() {
        String str;
        if (SPUtil.j()) {
            return pk.e.a().c();
        }
        pk.e a11 = pk.e.a();
        int i11 = this.f44735b0;
        boolean z11 = i11 == 1;
        if (i11 == 1) {
            str = this.f44734b.getString(R.string.string_usdt);
        } else {
            str = this.S.getContractCode();
        }
        return a11.b(z11, str);
    }

    public final void H(int i11) {
        this.R = i11;
        L();
        this.O = 5;
        n0(i11, this.f44774y);
        if (this.f44774y == 0) {
            this.P = null;
        } else {
            this.Q = null;
        }
        a0();
    }

    public String I(boolean z11) {
        try {
            FutureEarnestMoneyUtils f11 = FutureEarnestMoneyUtils.f();
            f11.i(this.f44734b).t(getVolume()).s(a7.e.G(this.F)).h(a7.e.E(this.F)).r(this.F).l(this.f44737c0).u(this.G).k(this.S.getContractFace()).o(4).g(BigDecimal.valueOf(this.U).toPlainString()).j(String.valueOf(this.W)).m(BigDecimal.valueOf(this.W).toPlainString()).p(BigDecimal.valueOf(this.V).toPlainString());
            return f11.b(z11, this.O == 5);
        } catch (FutureEarnestMoneyUtils.ZeroErr e11) {
            e11.printStackTrace();
            return getBondZeroDefault();
        }
    }

    public final void J() {
        if (ContractCalmPeriodHelper.d()) {
            this.f44769v.setBackgroundResource(R.drawable.common_un_enable_radius_selector);
            this.f44771w.setBackgroundResource(R.drawable.common_un_enable_radius_selector);
        } else {
            View view = this.f44769v;
            boolean l11 = w.l();
            int i11 = R.drawable.trade_btn_sell_selector;
            view.setBackgroundResource(l11 ? R.drawable.trade_btn_sell_selector : R.drawable.trade_btn_buy_selector);
            View view2 = this.f44771w;
            if (w.l()) {
                i11 = R.drawable.trade_btn_buy_selector;
            }
            view2.setBackgroundResource(i11);
        }
        this.f44773x.getConfigBuilder().colorConfig(getContext(), NightHelper.e().g(), this.f44774y == 0).build();
    }

    public String K(Editable editable) {
        FutureContractInfo futureContractInfo = this.S;
        if (futureContractInfo == null) {
            return null;
        }
        TradeType tradeType = this.F;
        if (tradeType == TradeType.OPTION) {
            return m.b(editable, 10, FuturePrecisionUtil.s(futureContractInfo.getContractCode(), this.S.getContractShortType(), this.S.getOptionCode()));
        }
        if (tradeType != TradeType.LINEAR_SWAP) {
            return m.b(editable, 10, FuturePrecisionUtil.w(futureContractInfo.getContractCode(), this.S.getContractShortType(), this.S.getOptionCode()));
        }
        if (a7.e.G(tradeType)) {
            return m.b(editable, 10, FuturePrecisionUtil.g(this.G));
        }
        return m.b(editable, 10, FuturePrecisionUtil.s(this.S.getContractCode(), this.S.getContractShortType(), this.S.getOptionCode()));
    }

    public void L() {
        this.f44760o.clearFocus();
        this.f44758n.clearFocus();
        this.f44752k.clearFocus();
        this.f44754l.clearFocus();
        this.f44756m.clearFocus();
    }

    public final ContractOrderPlace M() {
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.X0(1);
        contractOrderPlace.B0(String.valueOf(this.W));
        contractOrderPlace.y0(0);
        contractOrderPlace.Z0(String.valueOf(this.W));
        contractOrderPlace.i0(this.U);
        contractOrderPlace.G0(this.V);
        contractOrderPlace.r0(this.W);
        contractOrderPlace.h0(this.f44733a0);
        contractOrderPlace.A0(this.f44774y);
        contractOrderPlace.N0(this.G);
        contractOrderPlace.s0(this.f44737c0);
        contractOrderPlace.v0(this.f44735b0);
        return this.T.s(contractOrderPlace);
    }

    public ContractOrderTimingRequestData N(boolean z11) {
        int i11;
        String str;
        ContractOrderTimingRequestData contractOrderTimingRequestData = new ContractOrderTimingRequestData();
        contractOrderTimingRequestData.setSymbol(this.S.getSymbol());
        contractOrderTimingRequestData.setQuoteCurrency(this.S.getQuoteCurrency());
        contractOrderTimingRequestData.setContractCode(this.S.getContractCode());
        contractOrderTimingRequestData.setContractType(this.S.getContractType());
        contractOrderTimingRequestData.setMarginMode(this.f44735b0 == 1 ? FutureContractInfo.MARGIN_CROSS : FutureContractInfo.MARGIN_ISOLATED);
        contractOrderTimingRequestData.setDirection(z11 ? "buy" : "sell");
        if (getPositionModeSingle()) {
            contractOrderTimingRequestData.setOffset(LinearSwapCurrentOrderInfo.ORDER_OFFSET_SINGLE_SIDE);
        } else if (this.f44774y == 0) {
            contractOrderTimingRequestData.setOffset("open");
        } else {
            contractOrderTimingRequestData.setOffset("close");
        }
        contractOrderTimingRequestData.setLevelRate(m.a(this.f44737c0).intValue());
        if (this.f44762q == 0) {
            contractOrderTimingRequestData.setPriceIntervalMode(0);
            contractOrderTimingRequestData.setPriceInterval(m.a(this.f44752k.getText().toString()).doubleValue());
        } else {
            contractOrderTimingRequestData.setPriceIntervalMode(1);
            contractOrderTimingRequestData.setPriceInterval(m.a(this.f44752k.getText().toString()).divide(m.a("100")).doubleValue());
        }
        contractOrderTimingRequestData.setPriceLimit(m.a(this.f44754l.getText().toString()).doubleValue());
        contractOrderTimingRequestData.setTimeInterval(m.a(this.f44756m.getText().toString()).intValue());
        BigDecimal h11 = this.f44751j0.h(this.f44758n.getText().toString(), String.valueOf(this.W), this.S);
        contractOrderTimingRequestData.setCanTrade(!this.f44751j0.e(h11, String.valueOf(this.W), this.S));
        contractOrderTimingRequestData.setUnitVolume(h11.intValue());
        contractOrderTimingRequestData.setDisplayUnitVolume(this.f44758n.getText().toString());
        if (this.O == 5) {
            if (a7.e.G(this.F)) {
                i11 = FuturePrecisionUtil.g(this.G);
            } else {
                i11 = FuturePrecisionUtil.s(this.S.getContractCode(), this.S.getContractShortType(), this.S.getOptionCode());
            }
            if (z11) {
                if (this.f44774y == 0) {
                    str = this.f44745g0;
                    contractOrderTimingRequestData.setVolume(this.f44751j0.h(new BigDecimal(this.f44773x.getProgress()).multiply(this.f44739d0).divide(m.f68179a, i11, 1).toPlainString(), String.valueOf(this.W), this.S).intValue());
                } else {
                    str = new BigDecimal(this.f44773x.getProgress()).multiply(this.f44739d0).divide(m.f68179a, i11, 1).toPlainString();
                    contractOrderTimingRequestData.setVolume(this.f44751j0.h(str, String.valueOf(this.W), this.S).intValue());
                }
            } else if (this.f44774y == 0) {
                str = this.f44745g0;
                contractOrderTimingRequestData.setVolume(this.f44751j0.h(new BigDecimal(this.f44773x.getProgress()).multiply(this.f44741e0).divide(m.f68179a, i11, 1).toPlainString(), String.valueOf(this.W), this.S).intValue());
            } else {
                str = new BigDecimal(this.f44773x.getProgress()).multiply(this.f44741e0).divide(m.f68179a, i11, 1).toPlainString();
                contractOrderTimingRequestData.setVolume(this.f44751j0.h(str, String.valueOf(this.W), this.S).intValue());
            }
            contractOrderTimingRequestData.setDisplayTotalVolume(str);
        } else {
            contractOrderTimingRequestData.setVolume(this.f44751j0.h(this.f44760o.getText().toString(), String.valueOf(this.W), this.S).intValue());
            contractOrderTimingRequestData.setDisplayTotalVolume(this.f44760o.getText().toString());
        }
        contractOrderTimingRequestData.setDisplayUnitName(this.f44755l0);
        return contractOrderTimingRequestData;
    }

    public final void O() {
        Activity b11 = oa.a.g().b();
        if (SoftInputUtils.h(b11)) {
            SoftInputUtils.g(b11, this.f44770v0);
        }
    }

    public final void P(Context context, AttributeSet attributeSet) {
        this.f44734b = context;
        U(LayoutInflater.from(context).inflate(R.layout.feature_timing_order, this, true));
        T();
        S();
    }

    public final void Q() {
        z zVar = new z((k2) null);
        this.T = zVar;
        this.f44751j0 = new nk.a(zVar, this);
    }

    public final void R() {
        this.f44766t0 = this.f44751j0.g(this.f44734b.getString(R.string.n_exchange_timing_taker_open_distance), 15);
        this.f44768u0 = this.f44751j0.g(this.f44734b.getString(R.string.n_exchange_timing_taker_price_range_ratio), 15);
        this.f44742f.setHintText(this.f44766t0);
    }

    public final void S() {
        this.f44738d.setOnClickListener(new y(this));
        this.f44742f.setOnEditTextFocusChangeListener(new c());
        this.f44744g.setOnEditTextFocusChangeListener(new d());
        this.f44746h.setOnEditTextFocusChangeListener(new e());
        this.f44748i.setOnEditTextFocusChangeListener(new f());
        this.f44750j.setOnEditTextFocusChangeListener(new g());
        this.f44752k.addTextChangedListener(new h());
        this.f44754l.addTextChangedListener(new i());
        this.f44758n.addTextChangedListener(new j());
        this.f44760o.addTextChangedListener(new k());
        this.f44773x.setOnProgressChangedListener(new a());
        this.f44769v.setOnClickListener(new x(this));
        this.f44771w.setOnClickListener(new pk.z(this));
    }

    public final void T() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CommonPopListItem(0, this.f44734b.getString(R.string.n_exchange_timing_price_range), this.f44772w0));
        arrayList.add(new CommonPopListItem(1, this.f44734b.getString(R.string.n_exchange_timing_ratio), this.f44772w0));
        this.f44736c.setData(arrayList);
        this.f44736c.setFollowViewWidth(true);
    }

    public final void U(View view) {
        this.f44770v0 = view.findViewById(R.id.ll_trade_option);
        this.f44738d = view.findViewById(R.id.ll_timing_taker_selector);
        this.f44740e = (TextView) view.findViewById(R.id.tv_timing_taker_selector_value);
        this.f44742f = (ContractGearsTradePriceEditText) view.findViewById(R.id.cgtp_edt_timing_taker_condition);
        this.f44744g = (ContractGearsTradePriceEditText) view.findViewById(R.id.cgtp_edt_timing_taker_price_limit);
        this.f44746h = (ContractGearsTradePriceEditText) view.findViewById(R.id.cgtp_edt_timing_interval);
        this.f44748i = (ContractGearsTradePriceEditText) view.findViewById(R.id.cgtp_edt_timing_single_amount);
        this.f44750j = (ContractGearsTradePriceEditText) view.findViewById(R.id.cgtp_edt_timing_total_amount);
        this.K = (ViewGroup) view.findViewById(R.id.contract_price_convert_container);
        this.L = (TextView) view.findViewById(R.id.contract_price_convert_tv);
        this.M = (ViewGroup) view.findViewById(R.id.contract_price_convert_total);
        this.N = (TextView) view.findViewById(R.id.contract_price_convert_total_tv);
        this.f44752k = this.f44742f.getEditText();
        this.f44754l = this.f44744g.getEditText();
        this.f44756m = this.f44746h.getEditText();
        this.f44758n = this.f44748i.getEditText();
        this.f44760o = this.f44750j.getEditText();
        this.f44756m.setInputType(2);
        ((TextView) view.findViewById(R.id.tv_step_one)).setText(String.format("%s%s", new Object[]{"1. ", this.f44734b.getString(R.string.n_exchange_timing_taker_price_range)}));
        ((TextView) view.findViewById(R.id.tv_step_two)).setText(String.format("%s%s", new Object[]{"2. ", this.f44734b.getString(R.string.n_exchange_timing_order_interval_setting)}));
        ((TextView) view.findViewById(R.id.tv_step_three)).setText(String.format("%s%s", new Object[]{"3. ", this.f44734b.getString(R.string.n_exchange_timing_maker_amount_setting)}));
        this.f44742f.setLabel(this.f44734b.getString(R.string.string_usdt));
        this.f44744g.setLabel(this.f44734b.getString(R.string.string_usdt));
        this.f44746h.setLabel(this.f44734b.getString(R.string.n_exchange_timing_second));
        this.f44763r = (TextView) view.findViewById(R.id.long_value_tv);
        this.f44764s = (TextView) view.findViewById(R.id.short_value_tv);
        this.f44765t = (TextView) view.findViewById(R.id.long_value_tv1);
        this.f44767u = (TextView) view.findViewById(R.id.short_value_tv1);
        this.f44769v = view.findViewById(R.id.trade_long_ll);
        this.f44771w = view.findViewById(R.id.trade_short_ll);
        this.f44773x = (MultiColorSeekBar) view.findViewById(R.id.contract_seekbar_new);
        this.f44775z = (TextView) view.findViewById(R.id.trade_long_confirm_btn);
        this.A = (TextView) view.findViewById(R.id.trade_short_confirm_btn);
        this.B = view.findViewById(R.id.ll_bond);
        this.C = view.findViewById(R.id.ll_bond2);
        this.D = (TextView) view.findViewById(R.id.tv_bond);
        this.E = (TextView) view.findViewById(R.id.tv_bond2);
        Q();
        R();
        EventBus.d().p(this);
    }

    public void Z() {
        EventBus.d().r(this);
    }

    public final void a0() {
        this.D.setText(I(true));
        this.E.setText(I(false));
    }

    public void b0(String str, String str2) {
        if (ContractCalmPeriodHelper.d()) {
            this.A.setText(R.string.n_contract_calm_period_name);
            this.f44775z.setText(R.string.n_contract_calm_period_name);
            return;
        }
        this.f44775z.setText(str);
        this.A.setText(str2);
    }

    public final void c0(View view, boolean z11) {
        if (z11) {
            view.setBackgroundResource(R.drawable.custom_edittext_blue_focused_bg);
        } else {
            view.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        }
    }

    public void close() {
        a.C0579a aVar = this.f44753k0;
        if (aVar != null) {
            aVar.close();
        }
    }

    public final void d0(int i11, String str, String str2) {
        this.f44763r.setText(getResources().getString(i11));
        TextView textView = this.f44765t;
        textView.setText(str + str2);
        a0();
    }

    public final void e0(int i11, String str, String str2) {
        this.f44764s.setText(getResources().getString(i11));
        TextView textView = this.f44767u;
        textView.setText(str + str2);
        a0();
    }

    public final void f0(String str, String str2) {
        this.f44763r.setText(this.f44734b.getString(R.string.n_contract_contract_open_long));
        TextView textView = this.f44765t;
        textView.setText(str + str2);
        a0();
    }

    public void g0(String str, String str2) {
        if (this.f44774y == 1) {
            this.f44760o.setText(str);
        } else if (!this.f44760o.getText().toString().equals(str2)) {
            this.f44760o.setText(str2);
        }
    }

    public String getBondZeroDefault() {
        return BigDecimal.ZERO.setScale(4, 4).toPlainString() + getResources().getString(R.string.points_pack_usdt);
    }

    public String getVolume() {
        String obj = this.f44760o.getText().toString();
        if (this.O != 5) {
            return obj;
        }
        LinearSwapAccountInfo linearSwapAccountInfo = this.f44747h0;
        if (linearSwapAccountInfo != null) {
            return m.a(linearSwapAccountInfo.getMarginAvailable()).multiply(BigDecimal.valueOf((long) this.R)).divide(BigDecimal.valueOf(100), 4, 4).toPlainString();
        }
        return null;
    }

    public void h0(String str, String str2) {
        boolean E2 = a7.e.E(this.F);
        boolean G2 = a7.e.G(this.F);
        if (E2 || G2) {
            int i11 = this.f44774y;
            if (i11 == 0) {
                if (G2) {
                    if (TextUtils.isEmpty(str)) {
                        f0("--", "usdt".toUpperCase(Locale.US));
                    } else {
                        f0(str, "usdt".toUpperCase(Locale.US));
                    }
                    if (TextUtils.isEmpty(str2)) {
                        e0(R.string.n_contract_contract_open_short, "--", "usdt".toUpperCase(Locale.US));
                    } else {
                        e0(R.string.n_contract_contract_open_short, str2, "usdt".toUpperCase(Locale.US));
                    }
                } else {
                    if (TextUtils.isEmpty(str)) {
                        d0(R.string.n_contract_contract_open_long, "--", this.G);
                    } else {
                        d0(R.string.n_contract_contract_open_long, str, this.G);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        e0(R.string.n_contract_contract_open_short, "--", this.G);
                    } else {
                        e0(R.string.n_contract_contract_open_short, str2, this.G);
                    }
                }
            } else if (i11 != 1) {
            } else {
                if (G2) {
                    if (TextUtils.isEmpty(str)) {
                        d0(R.string.n_contract_trade_can_close_short, "--", "usdt".toUpperCase(Locale.US));
                    } else {
                        d0(R.string.n_contract_trade_can_close_short, str, "usdt".toUpperCase(Locale.US));
                    }
                    if (TextUtils.isEmpty(str2)) {
                        e0(R.string.n_contract_trade_can_close_long, "--", "usdt".toUpperCase(Locale.US));
                    } else {
                        e0(R.string.n_contract_trade_can_close_long, str2, "usdt".toUpperCase(Locale.US));
                    }
                } else {
                    if (TextUtils.isEmpty(str)) {
                        d0(R.string.n_contract_trade_can_close_short, "--", this.G);
                    } else {
                        d0(R.string.n_contract_trade_can_close_short, str, this.G);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        e0(R.string.n_contract_trade_can_close_long, "--", this.G);
                    } else {
                        e0(R.string.n_contract_trade_can_close_long, str2, this.G);
                    }
                }
            }
        } else {
            int i12 = this.f44774y;
            if (i12 == 0) {
                if (TextUtils.isEmpty(str)) {
                    f0("--", getResources().getString(R.string.contract_trade_unit_sheet));
                } else {
                    f0(str, getResources().getString(R.string.contract_trade_unit_sheet));
                }
                if (TextUtils.isEmpty(str2)) {
                    e0(R.string.n_contract_contract_open_short, "--", getResources().getString(R.string.contract_trade_unit_sheet));
                } else {
                    e0(R.string.n_contract_contract_open_short, str2, getResources().getString(R.string.contract_trade_unit_sheet));
                }
            } else if (i12 == 1) {
                if (TextUtils.isEmpty(str)) {
                    d0(R.string.n_contract_trade_can_close_short, "--", this.f44734b.getString(R.string.n_contract_vol_sheet));
                } else {
                    d0(R.string.n_contract_trade_can_close_short, str, this.f44734b.getString(R.string.n_contract_vol_sheet));
                }
                if (TextUtils.isEmpty(str2)) {
                    e0(R.string.n_contract_trade_can_close_long, "--", this.f44734b.getString(R.string.n_contract_vol_sheet));
                } else {
                    e0(R.string.n_contract_trade_can_close_long, str2, this.f44734b.getString(R.string.n_contract_vol_sheet));
                }
            }
        }
    }

    public final void i0() {
        if (this.f44774y == 0) {
            ViewUtil.m(this.B, true);
            ViewUtil.m(this.C, true);
            return;
        }
        ViewUtil.m(this.B, false);
        ViewUtil.m(this.C, false);
    }

    public void j0(EditText editText, String str) {
        editText.setText(str);
        editText.setSelection(editText.getText().length());
    }

    public final void k0(String str) {
        if (TextUtils.isEmpty(str) || BigDecimal.ZERO.compareTo(new BigDecimal(str)) == 0) {
            this.K.setVisibility(8);
            return;
        }
        String V2 = this.T.V(str, this.G, this.W, this.S);
        this.L.setText(AppUtil.b(String.format(this.f44734b.getString(R.string.balance_total_cny), new Object[]{V2}), this.G.toUpperCase(Locale.US)));
        this.K.setVisibility(0);
    }

    public final void l0(String str) {
        if (!mz.f.f(str)) {
            this.M.setVisibility(8);
        } else if (TextUtils.isEmpty(str) || BigDecimal.ZERO.compareTo(new BigDecimal(str)) == 0) {
            this.M.setVisibility(8);
        } else {
            String V2 = this.T.V(str, this.G, this.W, this.S);
            this.N.setText(AppUtil.b(String.format(this.f44734b.getString(R.string.balance_total_cny), new Object[]{V2}), this.G.toUpperCase(Locale.US)));
            this.M.setVisibility(0);
        }
    }

    public final void m0(ContractOrderPlace contractOrderPlace) {
        String str;
        String str2;
        String plainString;
        String plainString2;
        int v11 = contractOrderPlace.v();
        contractOrderPlace.B0(String.valueOf(contractOrderPlace.n()));
        String str3 = "";
        if (r.x().F0()) {
            if (a7.e.E(this.F)) {
                if (v11 == 0) {
                    this.T.d(contractOrderPlace, this.S);
                    this.T.b(contractOrderPlace, this.S);
                } else {
                    this.T.c(contractOrderPlace, this.S);
                    this.T.a(contractOrderPlace, this.S);
                }
                if (this.T.g() == null) {
                    str2 = str3;
                } else {
                    str2 = this.T.g().setScale(FuturePrecisionUtil.s(this.S.getContractCode(), this.S.getContractShortType(), this.S.getOptionCode()), 1).toPlainString();
                }
                if (this.T.k() != null) {
                    str3 = this.T.k().setScale(FuturePrecisionUtil.s(this.S.getContractCode(), this.S.getContractShortType(), this.S.getOptionCode()), 1).toPlainString();
                }
            } else if (a7.e.G(this.F)) {
                if (v11 == 0) {
                    this.T.d(contractOrderPlace, this.S);
                    this.T.b(contractOrderPlace, this.S);
                } else {
                    this.T.c(contractOrderPlace, this.S);
                    this.T.a(contractOrderPlace, this.S);
                }
                if (this.T.g() == null) {
                    plainString2 = str3;
                } else {
                    plainString2 = this.T.g().setScale(FuturePrecisionUtil.g(this.S.getSymbol()), 1).toPlainString();
                }
                if (this.T.k() != null) {
                    str3 = this.T.k().setScale(FuturePrecisionUtil.g(this.S.getSymbol()), 1).toPlainString();
                }
            } else {
                if (v11 == 0) {
                    this.T.d(contractOrderPlace, this.S);
                } else {
                    this.T.c(contractOrderPlace, this.S);
                }
                if (this.T.i() == null) {
                    plainString = str3;
                } else {
                    plainString = this.T.i().toPlainString();
                }
                if (this.T.j() != null) {
                    str3 = this.T.j().toPlainString();
                }
            }
            String str4 = str3;
            str3 = str2;
            str = str4;
        } else {
            str = str3;
        }
        this.f44739d0 = m.a(str3);
        this.f44741e0 = m.a(str);
        h0(str3, str);
    }

    public void n0(int i11, int i12) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        this.f44757m0 = "";
        this.f44759n0 = "";
        if (this.O != 0) {
            BigDecimal a11 = m.a(M().w());
            if (r.x().F0()) {
                if (a7.e.E(this.F) || a7.e.G(this.F)) {
                    if (i12 == 0) {
                        if (this.T.i() == null) {
                            this.f44757m0 = "";
                        } else {
                            BigDecimal divide = this.T.i().multiply(m.a(String.valueOf(i11))).divide(m.f68179a, FuturePrecisionUtil.B(), 1);
                            this.f44743f0 = divide.toPlainString();
                            this.f44757m0 = m.m(FutureUnitUtil.d(divide.toPlainString(), a11.toPlainString(), this.S.getContractFace(), this.F), FuturePrecisionUtil.s(this.S.getContractCode(), this.S.getContractShortType(), this.S.getOptionCode()));
                        }
                        if (this.T.j() == null) {
                            this.f44759n0 = "";
                        } else {
                            BigDecimal divide2 = this.T.j().multiply(m.a(String.valueOf(i11))).divide(m.f68179a, FuturePrecisionUtil.B(), 1);
                            this.f44743f0 = divide2.toPlainString();
                            this.f44759n0 = m.m(FutureUnitUtil.d(divide2.toPlainString(), a11.toPlainString(), this.S.getContractFace(), this.F), FuturePrecisionUtil.s(this.S.getContractCode(), this.S.getContractShortType(), this.S.getOptionCode()));
                        }
                    } else if (i12 == 1 || i12 == 2) {
                        if (this.T.i() == null) {
                            this.f44757m0 = "";
                        } else {
                            BigDecimal divide3 = this.T.i().multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                            if (divide3.compareTo(BigDecimal.ONE) >= 0 || divide3.compareTo(BigDecimal.ZERO) <= 0) {
                                bigDecimal2 = divide3.setScale(FuturePrecisionUtil.B(), 1);
                            } else {
                                bigDecimal2 = BigDecimal.ONE;
                            }
                            this.f44757m0 = m.m(FutureUnitUtil.d(bigDecimal2.toPlainString(), a11.toPlainString(), this.S.getContractFace(), this.F), FuturePrecisionUtil.s(this.S.getContractCode(), this.S.getContractShortType(), this.S.getOptionCode()));
                            this.f44743f0 = bigDecimal2.toPlainString();
                        }
                        if (this.T.j() == null) {
                            this.f44759n0 = "";
                        } else {
                            BigDecimal divide4 = this.T.j().multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                            if (divide4.compareTo(BigDecimal.ONE) >= 0 || divide4.compareTo(BigDecimal.ZERO) <= 0) {
                                bigDecimal = divide4.setScale(FuturePrecisionUtil.B(), 1);
                            } else {
                                bigDecimal = BigDecimal.ONE;
                            }
                            this.f44759n0 = m.m(FutureUnitUtil.d(bigDecimal.toPlainString(), a11.toPlainString(), this.S.getContractFace(), this.F), FuturePrecisionUtil.s(this.S.getContractCode(), this.S.getContractShortType(), this.S.getOptionCode()));
                            this.f44743f0 = bigDecimal.toPlainString();
                        }
                    }
                } else if (i12 == 0) {
                    if (this.T.i() == null) {
                        this.f44757m0 = "";
                    } else {
                        String plainString = this.T.i().multiply(new BigDecimal(i11)).divide(m.f68179a, FuturePrecisionUtil.B(), 1).toPlainString();
                        this.f44757m0 = plainString;
                        this.f44743f0 = plainString;
                    }
                    if (this.T.j() == null) {
                        this.f44759n0 = "";
                    } else {
                        String plainString2 = this.T.j().multiply(new BigDecimal(i11)).divide(m.f68179a, FuturePrecisionUtil.B(), 1).toPlainString();
                        this.f44759n0 = plainString2;
                        this.f44743f0 = plainString2;
                    }
                } else if (i12 == 1 || i12 == 2) {
                    if (this.T.i() == null) {
                        this.f44757m0 = "";
                    } else {
                        BigDecimal divide5 = this.T.i().multiply(new BigDecimal(i11)).divide(m.f68179a, 32, 1);
                        if (divide5.compareTo(BigDecimal.ONE) >= 0 || divide5.compareTo(BigDecimal.ZERO) <= 0) {
                            bigDecimal4 = divide5.setScale(FuturePrecisionUtil.B(), 1);
                        } else {
                            bigDecimal4 = BigDecimal.ONE;
                        }
                        String plainString3 = bigDecimal4.toPlainString();
                        this.f44757m0 = plainString3;
                        this.f44743f0 = plainString3;
                    }
                    if (this.T.j() == null) {
                        this.f44759n0 = "";
                    } else {
                        BigDecimal divide6 = this.T.j().multiply(new BigDecimal(i11)).divide(m.f68179a, 32, 1);
                        if (divide6.compareTo(BigDecimal.ONE) >= 0 || divide6.compareTo(BigDecimal.ZERO) <= 0) {
                            bigDecimal3 = divide6.setScale(FuturePrecisionUtil.B(), 1);
                        } else {
                            bigDecimal3 = BigDecimal.ONE;
                        }
                        String plainString4 = bigDecimal3.toPlainString();
                        this.f44759n0 = plainString4;
                        this.f44743f0 = plainString4;
                    }
                }
            }
            if (this.f44733a0) {
                String str = this.f44757m0;
                this.f44745g0 = str;
                if (TextUtils.isEmpty(str) || m.a(this.f44757m0).compareTo(BigDecimal.ZERO) == 0) {
                    g0(i11 + "%", i11 + "%");
                    return;
                }
                g0(i11 + "%", i11 + "%(≈ " + this.f44757m0 + ")");
                return;
            }
            String str2 = this.f44759n0;
            this.f44745g0 = str2;
            if (TextUtils.isEmpty(str2) || m.a(this.f44759n0).compareTo(BigDecimal.ZERO) == 0) {
                g0(i11 + "%", i11 + "%");
                return;
            }
            g0(i11 + "%", i11 + "%(≈ " + this.f44759n0 + ")");
        }
    }

    public final void o0() {
        if (a7.e.G(this.F)) {
            this.f44748i.setLabel(this.f44734b.getString(R.string.string_usdt));
            this.f44750j.setLabel(this.f44734b.getString(R.string.string_usdt));
            this.f44755l0 = this.f44734b.getString(R.string.string_usdt);
            return;
        }
        this.f44748i.setLabel(this.G);
        this.f44750j.setLabel(this.G);
        this.f44755l0 = this.G;
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onContractCalmPeriodInfoChange(ContractCalmPeriodInfo contractCalmPeriodInfo) {
        J();
        b0(this.I, this.J);
    }

    public final void p0() {
        o0();
        i0();
        J();
        b0(this.I, this.J);
    }

    public void setActivity(FragmentActivity fragmentActivity) {
        this.f44761p = fragmentActivity;
        this.f44751j0.j(fragmentActivity);
    }

    public void setBalance(AccountBalanceInfoV5 accountBalanceInfoV5) {
        z zVar = this.T;
        if (zVar != null) {
            zVar.t0(accountBalanceInfoV5);
        }
    }

    public void setFeatureTradeTimeInfo(FeatureTradeTimeInfo featureTradeTimeInfo) {
        this.H = featureTradeTimeInfo;
        this.F = featureTradeTimeInfo.getTradeType();
        this.f44774y = featureTradeTimeInfo.getPositionType();
        this.I = featureTradeTimeInfo.getLongConfirmText();
        this.J = featureTradeTimeInfo.getShortConfirmText();
        this.S = featureTradeTimeInfo.getLinearSwapCurrencyInfo();
        this.U = featureTradeTimeInfo.getBuyFirstPrice();
        this.V = featureTradeTimeInfo.getSellFirstPrice();
        this.W = featureTradeTimeInfo.getLastPriceNew();
        this.f44733a0 = featureTradeTimeInfo.isBuy();
        this.f44735b0 = featureTradeTimeInfo.getMarginMode();
        this.f44737c0 = featureTradeTimeInfo.getLevelRate();
        this.f44747h0 = featureTradeTimeInfo.getLinearSwapAccountInfo();
        String symbol = TextUtils.isEmpty(featureTradeTimeInfo.getSymbol()) ? "--" : featureTradeTimeInfo.getSymbol();
        this.G = symbol;
        this.T.s0(symbol, this.f44747h0);
        m0(M());
        p0();
        a0();
    }

    public void setProgress(int i11) {
        this.f44773x.setProgress((float) i11);
    }

    public void setTradeTimeUI(a.C0579a aVar) {
        this.f44753k0 = aVar;
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    public void updateCurrentPosition(ContractPositionEvent contractPositionEvent) {
        this.f44749i0 = contractPositionEvent.getContractPosition();
        z zVar = this.T;
        zVar.u0(this.f44749i0.getContractCode() + "_" + this.f44749i0.getMarginMode() + this.f44749i0.getDirection(), this.f44749i0);
        if (!TextUtils.isEmpty(this.H.getSymbol())) {
            setFeatureTradeTimeInfo(this.H);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    public void updateLastPrice(ContractLastPriceEvent contractLastPriceEvent) {
        this.H.setLastPriceNew(this.W);
        this.H.setBuyFirstPrice(contractLastPriceEvent.getBuyFirstPrice());
        this.H.setSellFirstPrice(contractLastPriceEvent.getSellFirstPrice());
        this.H.setLinearSwapAccountInfo(contractLastPriceEvent.getLinearSwapAccountInfo());
        if (!TextUtils.isEmpty(this.H.getSymbol())) {
            setFeatureTradeTimeInfo(this.H);
        }
    }

    public FutureTradeTimeTogetherView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f44736c = new CommonListPopupDialog();
        this.f44762q = 0;
        this.F = TradeType.LINEAR_SWAP;
        this.G = "--";
        this.O = 0;
        BigDecimal bigDecimal = BigDecimal.ZERO;
        this.f44739d0 = bigDecimal;
        this.f44741e0 = bigDecimal;
        this.f44755l0 = "";
        this.f44766t0 = "";
        this.f44768u0 = "";
        this.f44772w0 = new b();
        P(context, attributeSet);
    }
}
