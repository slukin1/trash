package com.huobi.finance.ui;

import al.w0;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.IntegrationDetailSubmitResult;
import com.hbg.lib.network.hbg.core.bean.IntegrationNoticeInfo;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.MarqueeView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.input.PointLengthFilter;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.ui.HelpCenterActivity;
import com.huobi.account.ui.SecuritySetActivity;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragment;
import com.huobi.account.ui.SecurityStrategyControllerAdapter;
import com.huobi.finance.bean.ChainItem;
import com.huobi.finance.bean.LimitDescription;
import com.huobi.finance.bean.PreWithdrawData;
import com.huobi.finance.bean.VirtualAddressInfo;
import com.huobi.finance.bean.WithdrawInfo;
import com.huobi.finance.bean.WithdrawQuotaDetails;
import com.huobi.finance.bean.WithdrawTypeItem;
import com.huobi.finance.presenter.UnifyWithdrawPresenter;
import com.huobi.finance.utils.DepositWithdrawHelper;
import com.huobi.kyc.bean.FlutterKycConfig;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.points.activity.MyPointsNewActivity;
import com.huobi.utils.c1;
import com.huobi.utils.e1;
import com.huobi.utils.v0;
import com.huobi.view.bottompopfragmentmenu.BottomAgreementFragment;
import com.huobi.view.button.StatusButton;
import com.huobi.view.rv.GridDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.i;
import i6.m;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import pro.huobi.R;
import tg.r;
import u6.g;

@Route(path = "/balance/withdraw")
public class UnifyWithdrawActivity extends BaseActivity<UnifyWithdrawPresenter, UnifyWithdrawPresenter.l> implements UnifyWithdrawPresenter.l, View.OnFocusChangeListener {
    public NestedScrollView A;
    public boolean B;
    public ViewTreeObserver.OnGlobalLayoutListener C;
    public boolean D;
    public View E;
    public View F;
    public LinearLayout G;
    public int H;
    public PointLengthFilter I;
    public int J;
    public BigDecimal K;
    public TextView L;
    public TextView M;
    public View N;
    public TextView O;
    public EasyRecyclerView<ChainItem> P;
    public View Q;
    public View R;
    public View S;
    public View T;
    public View U;
    public View V;
    public EasyRecyclerView<WithdrawTypeItem> W;
    public View X;
    public View Y;
    public String Z;

    /* renamed from: a0  reason: collision with root package name */
    public InputFilter.LengthFilter f46932a0;

    /* renamed from: b  reason: collision with root package name */
    public Toolbar f46933b;

    /* renamed from: b0  reason: collision with root package name */
    public LinearLayout f46934b0;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f46935c;

    /* renamed from: c0  reason: collision with root package name */
    public LinearLayout f46936c0;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46937d;

    /* renamed from: d0  reason: collision with root package name */
    public MarqueeView f46938d0;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46939e;

    /* renamed from: e0  reason: collision with root package name */
    public TextView f46940e0;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46941f;

    /* renamed from: f0  reason: collision with root package name */
    public boolean f46942f0;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46943g;

    /* renamed from: g0  reason: collision with root package name */
    public View f46944g0;

    /* renamed from: h  reason: collision with root package name */
    public EditText f46945h;

    /* renamed from: h0  reason: collision with root package name */
    public TextView f46946h0;

    /* renamed from: i  reason: collision with root package name */
    public EditText f46947i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f46948j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f46949k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f46950l;

    /* renamed from: m  reason: collision with root package name */
    public View f46951m;

    /* renamed from: n  reason: collision with root package name */
    public View f46952n;

    /* renamed from: o  reason: collision with root package name */
    public String f46953o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f46954p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f46955q;

    /* renamed from: r  reason: collision with root package name */
    public LoadingLayout f46956r;

    /* renamed from: s  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f46957s = new SecurityStrategyBottomMenuFragment();

    /* renamed from: t  reason: collision with root package name */
    public View f46958t;

    /* renamed from: u  reason: collision with root package name */
    public LinearLayout f46959u;

    /* renamed from: v  reason: collision with root package name */
    public EditText f46960v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f46961w;

    /* renamed from: x  reason: collision with root package name */
    public f f46962x;

    /* renamed from: y  reason: collision with root package name */
    public CoordinatorLayout f46963y;

    /* renamed from: z  reason: collision with root package name */
    public EditText f46964z;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            UnifyWithdrawActivity.this.f46958t.setEnabled(UnifyWithdrawActivity.this.Fi());
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            BigDecimal bigDecimal;
            String str;
            String str2;
            if (charSequence == null || TextUtils.isEmpty(charSequence.toString())) {
                charSequence = "0";
            }
            if (InstructionFileId.DOT.equals(charSequence.toString())) {
                UnifyWithdrawActivity.this.f46945h.setText("");
                if (UnifyWithdrawActivity.this.K != null) {
                    String unused = UnifyWithdrawActivity.this.f46953o = m.m("0", 8);
                    UnifyWithdrawActivity.this.f46947i.setText(UnifyWithdrawActivity.this.f46953o);
                    return;
                }
                return;
            }
            BigDecimal bigDecimal2 = new BigDecimal(charSequence.toString());
            if (UnifyWithdrawActivity.this.K != null) {
                UnifyWithdrawActivity unifyWithdrawActivity = UnifyWithdrawActivity.this;
                String unused2 = unifyWithdrawActivity.f46953o = m.q(bigDecimal2.multiply(unifyWithdrawActivity.K), 8);
                if (TextUtils.isEmpty(UnifyWithdrawActivity.this.f46953o)) {
                    str2 = "0";
                } else {
                    str2 = UnifyWithdrawActivity.this.f46953o;
                }
                bigDecimal = new BigDecimal(str2);
                UnifyWithdrawActivity.this.f46947i.setText(UnifyWithdrawActivity.this.f46953o);
            } else {
                if (TextUtils.isEmpty(UnifyWithdrawActivity.this.f46953o)) {
                    str = "0";
                } else {
                    str = UnifyWithdrawActivity.this.f46953o;
                }
                bigDecimal = new BigDecimal(str);
            }
            BigDecimal subtract = bigDecimal2.subtract(bigDecimal);
            if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
                UnifyWithdrawActivity.this.f46955q.setText(m.m("0", UnifyWithdrawActivity.this.J));
            } else {
                UnifyWithdrawActivity.this.f46955q.setText(m.q(subtract, UnifyWithdrawActivity.this.J));
            }
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            UnifyWithdrawActivity.this.f46958t.setEnabled(UnifyWithdrawActivity.this.Fi());
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            BigDecimal bigDecimal;
            BigDecimal bigDecimal2;
            if (charSequence != null && UnifyWithdrawActivity.this.f46961w) {
                if (InstructionFileId.DOT.equals(charSequence.toString())) {
                    UnifyWithdrawActivity.this.f46947i.setText("");
                    return;
                }
                if (TextUtils.isEmpty(charSequence.toString())) {
                    bigDecimal = BigDecimal.ZERO;
                } else {
                    bigDecimal = new BigDecimal(charSequence.toString().trim());
                }
                String unused = UnifyWithdrawActivity.this.f46953o = bigDecimal.toPlainString();
                String trim = UnifyWithdrawActivity.this.f46945h.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    bigDecimal2 = BigDecimal.ZERO;
                } else {
                    bigDecimal2 = new BigDecimal(trim);
                }
                BigDecimal subtract = bigDecimal2.subtract(bigDecimal);
                if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
                    TextView ji2 = UnifyWithdrawActivity.this.f46955q;
                    UnifyWithdrawActivity unifyWithdrawActivity = UnifyWithdrawActivity.this;
                    ji2.setText(unifyWithdrawActivity.tj(BigDecimal.ZERO, ((UnifyWithdrawPresenter) unifyWithdrawActivity.getPresenter()).W0()));
                    return;
                }
                TextView ji3 = UnifyWithdrawActivity.this.f46955q;
                UnifyWithdrawActivity unifyWithdrawActivity2 = UnifyWithdrawActivity.this;
                ji3.setText(unifyWithdrawActivity2.tj(subtract, ((UnifyWithdrawPresenter) unifyWithdrawActivity2.getPresenter()).W0()));
            }
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
            UnifyWithdrawActivity.this.f46958t.setEnabled(UnifyWithdrawActivity.this.Fi());
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class d extends BaseSubscriber<IntegrationDetailSubmitResult> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46970b;

        public d(String str) {
            this.f46970b = str;
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void c(IntegrationDetailSubmitResult integrationDetailSubmitResult, View view) {
            UnifyWithdrawActivity.this.zi(String.valueOf(integrationDetailSubmitResult.getPointAmount()), true);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void d(IntegrationDetailSubmitResult integrationDetailSubmitResult, String str, View view) {
            UnifyWithdrawActivity.this.zi(String.valueOf(integrationDetailSubmitResult.getPointAmount()), false);
            w0.g().d();
            UnifyWithdrawActivity.this.pj(str, "NO_RISK");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* renamed from: e */
        public void onNext(IntegrationDetailSubmitResult integrationDetailSubmitResult) {
            UnifyWithdrawActivity.this.getUI().dismissProgressDialog();
            if (integrationDetailSubmitResult.isDetain()) {
                String string = UnifyWithdrawActivity.this.getResources().getString(R.string.n_withdraw_stop_send_card);
                String format = String.format(string, new Object[]{integrationDetailSubmitResult.getPointAmount() + "U"});
                String format2 = String.format(UnifyWithdrawActivity.this.getResources().getString(R.string.n_withdraw_stop_time), new Object[]{" 05:00 "});
                w0 g11 = w0.g();
                UnifyWithdrawActivity unifyWithdrawActivity = UnifyWithdrawActivity.this;
                g11.o(unifyWithdrawActivity, format, format2, unifyWithdrawActivity.getResources().getString(R.string.n_withdraw_stop_giveup_withdraw), new jb(this, integrationDetailSubmitResult), UnifyWithdrawActivity.this.getResources().getString(R.string.n_withdraw_stop_continue_withdraw), new kb(this, integrationDetailSubmitResult, this.f46970b));
                w0.g().k(true);
                UnifyWithdrawActivity.this.qj(300);
                return;
            }
            UnifyWithdrawActivity.this.pj(this.f46970b, "NO_RISK");
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            UnifyWithdrawActivity.this.getUI().dismissProgressDialog();
            UnifyWithdrawActivity.this.pj(this.f46970b, "NO_RISK");
        }
    }

    public class e extends BaseSubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f46972b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46973c;

        public e(boolean z11, String str) {
            this.f46972b = z11;
            this.f46973c = str;
        }

        public void onError(Throwable th2) {
            if (this.f46972b) {
                super.onError(th2);
                w0.g().d();
                HuobiToastUtil.k(BaseApplication.b(), R.string.server_error);
            }
        }

        public void onNext(Object obj) {
            if (this.f46972b) {
                UnifyWithdrawActivity.this.Ai(this.f46973c);
            }
        }
    }

    public class f extends Dialog {

        /* renamed from: b  reason: collision with root package name */
        public int f46975b;

        /* renamed from: c  reason: collision with root package name */
        public View f46976c;

        public f(Context context) {
            super(context);
        }

        public void a(int i11) {
            this.f46975b = i11;
        }

        public void b() {
            UnifyWithdrawActivity.this.hj(this, this.f46976c, this.f46975b);
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            getWindow().requestFeature(1);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_withdraw_limit2, (ViewGroup) null);
            this.f46976c = inflate;
            setContentView(inflate);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
            b();
        }
    }

    public static void Di(Activity activity, String str, TradeType tradeType) {
        Intent intent = new Intent(activity, WithdrawActivity.class);
        if (str != null) {
            intent.putExtra("coin", str.toLowerCase(Locale.US));
        }
        if (tradeType != null) {
            intent.putExtra("TradeType", tradeType);
        }
        if (!r.x().F0()) {
            rn.c.i().d(activity, new JumpTarget(intent, (Intent) null));
        } else if (r.x().X()) {
            HuobiToastUtil.j(R.string.sub_account_not_support_withdraw);
        } else {
            activity.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gi() {
        Rect rect = new Rect();
        this.f46963y.getWindowVisibleDisplayFrame(rect);
        if (this.f46963y.getRootView().getHeight() - (rect.bottom - rect.top) > 500) {
            jj();
        } else {
            ij();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Hi(View view) {
        HBBaseWebActivity.showWebView(this, e1.b(c1.z(), "/detail/360000105962"), "", getResources().getString(R.string.head_return), false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ii(View view) {
        ((UnifyWithdrawPresenter) getPresenter()).J0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ji(View view) {
        sn.f.i0(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ boolean Ki(MenuItem menuItem) {
        CurrencyHistoryActivity.oh(this, ((UnifyWithdrawPresenter) getPresenter()).T0(), "2");
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return true;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Li(View view) {
        oi(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Mi(View view) {
        A(true);
        ((UnifyWithdrawPresenter) getPresenter()).Q1(true);
        ((UnifyWithdrawPresenter) getPresenter()).b2();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ni(View view) {
        if (((UnifyWithdrawPresenter) getPresenter()).Z0() != null) {
            if (((UnifyWithdrawPresenter) getPresenter()).i1()) {
                HuobiToastUtil.j(R.string.withdraw_can_not_select_common_address);
            } else {
                Intent intent = new Intent(this, ManagerVirtualAddressActivity.class);
                intent.putExtra("select_address", false);
                intent.putExtra("coin_type", ((UnifyWithdrawPresenter) getPresenter()).T0());
                intent.putExtra("chain", DepositWithdrawHelper.a(((UnifyWithdrawPresenter) getPresenter()).S0()));
                intent.putExtra("coin_address", this.f46960v.getText().toString().trim());
                startActivityForResult(intent, 201);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Oi(View view) {
        ((UnifyWithdrawPresenter) getPresenter()).d2();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Pi(View view) {
        Ci();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Qi(View view) {
        w0.g().d();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ri() {
        this.H = this.G.getHeight();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Si() {
        Rect rect = new Rect();
        this.f46952n.getHitRect(rect);
        rect.left -= 300;
        rect.top -= 300;
        rect.right += 300;
        rect.bottom += 300;
        ((View) this.f46952n.getParent()).setTouchDelegate(new TouchDelegate(rect, this.f46952n));
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Ti(f fVar, View view) {
        fVar.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ui(int i11, View view) {
        if (i11 == 1) {
            rj(this);
        } else if (i11 == 2) {
            sj(this);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vi() {
        this.A.smoothScrollBy(0, this.H + PixelUtils.a(5.0f));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wi() {
        ((UnifyWithdrawPresenter) getPresenter()).I0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xi(HBDialogFragment hBDialogFragment) {
        Ei();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yi(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aj(HBDialogFragment hBDialogFragment) {
        oi(true);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bj(boolean z11) {
        this.f46942f0 = z11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void cj(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        new v0(this, "900004337406").d();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void dj(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ConfigPreferences.n("user_config", "config_withdraw_chain_hrc20_tips_no_more", this.f46942f0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ej(View view) {
        ((UnifyWithdrawPresenter) getPresenter()).W1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void fj(IntegrationNoticeInfo integrationNoticeInfo, View view) {
        kj(integrationNoticeInfo.getPath(), integrationNoticeInfo.getType());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gj(Integer num) {
        qj(Integer.valueOf(num.intValue() - 1));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        CurrencySearchActivity.lj(this, "2", true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        if (((UnifyWithdrawPresenter) getPresenter()).Z0() != null) {
            this.f46945h.setText(m.m(String.valueOf(((UnifyWithdrawPresenter) getPresenter()).Z0().b()), this.J));
            EditText editText = this.f46945h;
            editText.setSelection(editText.getText().length());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        ((UnifyWithdrawPresenter) getPresenter()).a2();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void A(boolean z11) {
        ViewUtil.m(this.f46956r, false);
        if (z11) {
            showProgressDialog();
        } else {
            dismissProgressDialog();
        }
    }

    public final void Ai(String str) {
        w0.g().e();
        w0 g11 = w0.g();
        String string = getResources().getString(R.string.n_withdraw_stop_receive_success);
        String string2 = getResources().getString(R.string.n_withdraw_stop_accepted_tips);
        g11.o(this, string, String.format(string2, new Object[]{str + "U"}), getResources().getString(R.string.n_withdraw_stop_look), new ga(this), getResources().getString(R.string.n_withdraw_stop_cancel), la.f47225b);
    }

    /* renamed from: Bi */
    public UnifyWithdrawPresenter.l getUI() {
        return this;
    }

    public void C(final Pair<UserSecurityInfoData, SecurityStrategySet> pair) {
        this.f46957s.Ci(new SecurityStrategyControllerAdapter() {

            /* renamed from: com.huobi.finance.ui.UnifyWithdrawActivity$7$Params */
            public class Params implements Serializable {
                private String amount;
                private String chain;
                private String currency;

                public Params() {
                }

                public String getAmount() {
                    return this.amount;
                }

                public String getChain() {
                    return this.chain;
                }

                public String getCurrency() {
                    return this.currency;
                }

                public void setAmount(String str) {
                    this.amount = str;
                }

                public void setChain(String str) {
                    this.chain = str;
                }

                public void setCurrency(String str) {
                    this.currency = str;
                }
            }

            public boolean C() {
                return ((SecurityStrategySet) pair.second).getSetting().isVerify_phone();
            }

            public final String Z() {
                return "VERIFY_SETTING_POLICY_WITHDRAW";
            }

            public void i(String str, String str2, String str3, String str4) {
                super.i(str, str2, str3, str4);
                String ci2 = UnifyWithdrawActivity.this.vi();
                String str5 = str;
                String str6 = str2;
                String str7 = str3;
                String str8 = str4;
                ((UnifyWithdrawPresenter) UnifyWithdrawActivity.this.getPresenter()).c2((SecurityStrategySet) pair.second, Z(), str5, str6, str7, str8, UnifyWithdrawActivity.this.f46955q.getText().toString(), UnifyWithdrawActivity.this.ti(), UnifyWithdrawActivity.this.ui(), ci2);
            }

            public String n() {
                return ((UserSecurityInfoData) pair.first).getEmail();
            }

            public String o() {
                return ((UserSecurityInfoData) pair.first).getPhone();
            }

            public Map<String, Object> p() {
                MapParamsBuilder a11 = MapParamsBuilder.c().a("use_type", Z());
                Params params = new Params();
                if (UnifyWithdrawActivity.this.getPresenter() != null) {
                    params.setCurrency(((UnifyWithdrawPresenter) UnifyWithdrawActivity.this.getPresenter()).T0());
                }
                if (!(UnifyWithdrawActivity.this.f46945h == null || UnifyWithdrawActivity.this.f46945h.getText() == null)) {
                    params.setAmount(UnifyWithdrawActivity.this.f46945h.getText().toString().trim());
                }
                if (((UnifyWithdrawPresenter) UnifyWithdrawActivity.this.getPresenter()).S0() != null) {
                    params.setChain(((UnifyWithdrawPresenter) UnifyWithdrawActivity.this.getPresenter()).S0().getChain());
                }
                a11.a("params", params);
                return a11.b();
            }

            public Map<String, Object> s() {
                MapParamsBuilder a11 = MapParamsBuilder.c().a("use_type", Z()).a("voice", Boolean.FALSE);
                Params params = new Params();
                if (UnifyWithdrawActivity.this.getPresenter() != null) {
                    params.setCurrency(((UnifyWithdrawPresenter) UnifyWithdrawActivity.this.getPresenter()).T0());
                }
                if (!(UnifyWithdrawActivity.this.f46945h == null || UnifyWithdrawActivity.this.f46945h.getText() == null)) {
                    params.setAmount(UnifyWithdrawActivity.this.f46945h.getText().toString().trim());
                }
                if (((UnifyWithdrawPresenter) UnifyWithdrawActivity.this.getPresenter()).S0() != null) {
                    params.setChain(((UnifyWithdrawPresenter) UnifyWithdrawActivity.this.getPresenter()).S0().getChain());
                }
                a11.a("params", params);
                return a11.b();
            }

            public boolean x() {
                return ((SecurityStrategySet) pair.second).getSetting().isVerify_email();
            }

            public boolean y() {
                return ((SecurityStrategySet) pair.second).getSetting().isVerify_ga();
            }

            public boolean z() {
                return ((SecurityStrategySet) pair.second).getSetting().isVerifyPassword();
            }
        });
        this.f46957s.show(getSupportFragmentManager(), "BottomMenuFragment");
    }

    public final void Ci() {
        Intent intent = new Intent(this, MyPointsNewActivity.class);
        intent.putExtra("EXTRA_MY_POINT_BACK_TO_HOME", true);
        startActivity(intent);
    }

    public final void Ei() {
        startActivity(new Intent(this, HelpCenterActivity.class));
    }

    public final boolean Fi() {
        if (TextUtils.isEmpty(this.f46960v.getText().toString().trim()) || TextUtils.isEmpty(this.f46945h.getText().toString().trim())) {
            return false;
        }
        if (!this.f46961w || !TextUtils.isEmpty(this.f46947i.getText().toString().trim())) {
            return true;
        }
        return false;
    }

    public void I5(String str) {
        is.a.i("4059", is.a.d());
        pj(str, "RISK_EXIST");
    }

    public void Ie() {
        new z0(this, new wa(this)).u();
    }

    public void J5() {
        new DialogUtils.b.d(this).c1(getString(R.string.allow_access_dialog_title)).C0(getString(R.string.n_withdraw_close_tip)).R0(getString(R.string.n_withdraw_help_center)).T0(true).S0(Integer.valueOf(ContextCompat.getColor(this, R.color.baseColorMajorTheme100))).P0(getString(R.string.allow_access_dialog_positive_btn)).q0(false).U0(new ra(this)).Q0(new pa(this)).j0().show(getSupportFragmentManager(), "");
    }

    public void K3(List<ChainItem> list) {
        if (list == null || list.size() <= 1) {
            View view = this.Q;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.Q;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        EasyRecyclerView<ChainItem> easyRecyclerView = this.P;
        if (easyRecyclerView != null) {
            easyRecyclerView.setData(list);
        }
    }

    public void K6(IntegrationNoticeInfo integrationNoticeInfo) {
        if (!TextUtils.isEmpty(integrationNoticeInfo.getContent())) {
            this.f46938d0.setText(integrationNoticeInfo.getContent());
            this.f46936c0.setOnClickListener(new ka(this, integrationNoticeInfo));
            this.f46936c0.setVisibility(0);
            return;
        }
        this.f46936c0.setVisibility(8);
    }

    public EditText M8() {
        return this.f46947i;
    }

    public void T(long j11) {
        startActivity(UnifyRiskActivity.Ch(this, j11, 0));
    }

    public void T6(String str) {
        is.a.i("4088", is.a.d());
        new hc(this).i();
    }

    public void X(String str, boolean z11) {
        if (z11) {
            Intent intent = new Intent(this, WithdrawQuickReviewActivity.class);
            intent.putExtra("WITHDRAW_ADDRESS_ID", str);
            startActivity(intent);
            finish();
        } else {
            HuobiToastUtil.s(R.string.withdraw_success);
            finish();
        }
        gs.e.b().a("PM_WITHDRAW", true, (Map<String, Object>) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0369  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0382  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0397  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x03a7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x03b7  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x03cb  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x03e0  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x03e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Z9(java.lang.String r13, com.huobi.finance.bean.WithdrawInfo r14) {
        /*
            r12 = this;
            android.view.View r0 = r12.f46944g0
            r1 = 0
            com.hbg.lib.common.utils.ViewUtil.m(r0, r1)
            android.widget.LinearLayout r0 = r12.G
            r2 = 1
            com.hbg.lib.common.utils.ViewUtil.m(r0, r2)
            com.huobi.finance.ui.UnifyWithdrawActivity$f r0 = r12.f46962x
            if (r0 == 0) goto L_0x001f
            boolean r0 = r0.isShowing()
            if (r0 == 0) goto L_0x001f
            com.hbg.lib.common.mvp.ActivityPresenter r0 = r12.getPresenter()
            com.huobi.finance.presenter.UnifyWithdrawPresenter r0 = (com.huobi.finance.presenter.UnifyWithdrawPresenter) r0
            r0.a2()
        L_0x001f:
            com.hbg.lib.widgets.input.PointLengthFilter r0 = r12.I
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.PRO
            int r13 = com.hbg.lib.data.symbol.PrecisionUtil.a(r3, r13)
            r0.a(r13)
            com.hbg.lib.common.mvp.ActivityPresenter r13 = r12.getPresenter()
            com.huobi.finance.presenter.UnifyWithdrawPresenter r13 = (com.huobi.finance.presenter.UnifyWithdrawPresenter) r13
            java.lang.String r13 = r13.W0()
            com.hbg.lib.common.mvp.ActivityPresenter r0 = r12.getPresenter()
            com.huobi.finance.presenter.UnifyWithdrawPresenter r0 = (com.huobi.finance.presenter.UnifyWithdrawPresenter) r0
            int r0 = r0.d1()
            r12.J = r0
            java.lang.String r0 = r14.b()
            r12.Z = r0
            android.widget.TextView r3 = r12.f46937d
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r6 = "0"
            if (r0 == 0) goto L_0x0055
            r0 = r6
            goto L_0x0057
        L_0x0055:
            java.lang.String r0 = r12.Z
        L_0x0057:
            int r7 = r12.J
            java.lang.String r0 = i6.m.m(r0, r7)
            r5[r1] = r0
            r5[r2] = r13
            java.lang.String r0 = "%s %s"
            java.lang.String r0 = java.lang.String.format(r0, r5)
            r3.setText(r0)
            com.hbg.lib.common.mvp.ActivityPresenter r0 = r12.getPresenter()
            com.huobi.finance.presenter.UnifyWithdrawPresenter r0 = (com.huobi.finance.presenter.UnifyWithdrawPresenter) r0
            java.lang.String r0 = r0.Y0()
            java.lang.String r3 = "\n"
            java.lang.String r5 = ""
            if (r0 != 0) goto L_0x007c
            r0 = r5
            goto L_0x008c
        L_0x007c:
            com.hbg.lib.common.mvp.ActivityPresenter r0 = r12.getPresenter()
            com.huobi.finance.presenter.UnifyWithdrawPresenter r0 = (com.huobi.finance.presenter.UnifyWithdrawPresenter) r0
            java.lang.String r0 = r0.Y0()
            java.lang.String r7 = "!>_<!"
            java.lang.String r0 = r0.replaceAll(r7, r3)
        L_0x008c:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 != 0) goto L_0x0119
            android.widget.TextView r7 = r12.f46941f
            com.hbg.lib.common.utils.ViewUtil.m(r7, r2)
            android.content.res.Resources r7 = r12.getResources()
            r8 = 2132025435(0x7f14205b, float:1.9689374E38)
            java.lang.String r7 = r7.getString(r8)
            android.content.res.Resources r8 = r12.getResources()
            r9 = 2132025432(0x7f142058, float:1.9689368E38)
            java.lang.String r8 = r8.getString(r9)
            android.text.SpannableStringBuilder r9 = new android.text.SpannableStringBuilder
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            r10.append(r8)
            r10.append(r3)
            r10.append(r0)
            java.lang.String r0 = r10.toString()
            r9.<init>(r0)
            android.content.res.Resources r0 = r12.getResources()
            r3 = 2131100128(0x7f0601e0, float:1.7812629E38)
            int r0 = r0.getColor(r3)
            com.huobi.finance.ui.UnifyWithdrawActivity$6 r3 = new com.huobi.finance.ui.UnifyWithdrawActivity$6
            r3.<init>(r8, r0)
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            android.content.res.Resources r10 = r12.getResources()
            r11 = 2131099907(0x7f060103, float:1.781218E38)
            int r10 = r10.getColor(r11)
            r0.<init>(r10)
            int r10 = r7.length()
            r11 = 17
            r9.setSpan(r0, r1, r10, r11)
            int r0 = r7.length()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            r10.append(r8)
            java.lang.String r7 = r10.toString()
            int r7 = r7.length()
            r9.setSpan(r3, r0, r7, r11)
            android.widget.TextView r0 = r12.f46941f
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()
            r0.setMovementMethod(r3)
            android.widget.TextView r0 = r12.f46941f
            r0.setText(r9)
            goto L_0x011e
        L_0x0119:
            android.widget.TextView r0 = r12.f46941f
            com.hbg.lib.common.utils.ViewUtil.m(r0, r1)
        L_0x011e:
            android.widget.TextView r0 = r12.f46943g
            r0.setText(r13)
            android.widget.TextView r0 = r12.f46954p
            r0.setText(r13)
            com.hbg.lib.common.mvp.ActivityPresenter r0 = r12.getPresenter()
            com.huobi.finance.presenter.UnifyWithdrawPresenter r0 = (com.huobi.finance.presenter.UnifyWithdrawPresenter) r0
            java.lang.String r0 = r0.b1()
            android.widget.EditText r3 = r12.f46945h
            r7 = 2132027626(0x7f1428ea, float:1.9693818E38)
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r8[r1] = r0
            java.lang.String r0 = r12.getString(r7, r8)
            r3.setHint(r0)
            com.hbg.lib.widgets.input.PointLengthFilter r0 = r12.I
            int r3 = r12.J
            r0.a(r3)
            com.huobi.finance.bean.PreWithdrawData r0 = r14.e()
            java.lang.String r0 = r0.g()
            com.huobi.finance.bean.PreWithdrawData r3 = r14.e()
            java.lang.String r3 = r3.f()
            int r7 = r12.J
            java.lang.String r0 = i6.m.m(r0, r7)
            int r7 = r12.J
            java.lang.String r3 = i6.m.m(r3, r7)
            com.huobi.finance.bean.PreWithdrawData r7 = r14.e()
            java.lang.String r7 = r7.c()
            android.widget.TextView r8 = r12.f46950l
            r8.setText(r13)
            java.lang.String r8 = "proportion"
            boolean r8 = r8.equals(r7)
            r9 = 0
            r10 = 8
            if (r8 == 0) goto L_0x01c4
            com.huobi.finance.bean.PreWithdrawData r0 = r14.e()
            java.lang.String r0 = r0.a()
            java.math.BigDecimal r0 = i6.m.a(r0)
            r12.K = r0
            android.widget.TextView r0 = r12.f46949k
            r0.setVisibility(r1)
            android.widget.TextView r0 = r12.f46949k
            r3 = 2132027615(0x7f1428df, float:1.9693796E38)
            java.lang.String r3 = r12.getString(r3)
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.math.BigDecimal r7 = r12.K
            java.lang.String r7 = i6.m.P(r7)
            r4[r1] = r7
            java.lang.String r3 = java.lang.String.format(r3, r4)
            r0.setText(r3)
            java.lang.String r0 = i6.m.m(r6, r10)
            r12.f46953o = r0
            android.widget.EditText r0 = r12.f46947i
            r0.setEnabled(r1)
            android.widget.EditText r0 = r12.f46947i
            java.lang.String r3 = r12.f46953o
            r0.setText(r3)
            r12.f46961w = r1
            android.widget.TextView r0 = r12.M
            r0.setVisibility(r10)
            goto L_0x0231
        L_0x01c4:
            java.lang.String r8 = "range"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x0201
            r12.K = r9
            android.widget.TextView r7 = r12.f46949k
            r7.setVisibility(r10)
            com.huobi.finance.bean.PreWithdrawData r7 = r14.e()
            java.lang.String r7 = r7.a()
            r12.f46953o = r7
            r7 = 2132027620(0x7f1428e4, float:1.9693806E38)
            r8 = 3
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r1] = r0
            r8[r2] = r3
            r8[r4] = r13
            java.lang.String r0 = r12.getString(r7, r8)
            android.widget.EditText r3 = r12.f46947i
            r3.setEnabled(r2)
            android.widget.EditText r3 = r12.f46947i
            java.lang.String r4 = r12.f46953o
            r3.setText(r4)
            r12.f46961w = r2
            android.widget.TextView r3 = r12.M
            r3.setVisibility(r1)
            goto L_0x0232
        L_0x0201:
            r12.K = r9
            android.widget.TextView r0 = r12.f46949k
            r0.setVisibility(r10)
            com.huobi.finance.bean.PreWithdrawData r0 = r14.e()
            java.lang.String r0 = r0.a()
            r12.f46953o = r0
            android.widget.EditText r0 = r12.f46947i
            r0.setEnabled(r1)
            com.huobi.finance.bean.PreWithdrawData r0 = r14.e()
            java.lang.String r0 = r0.a()
            int r3 = r12.J
            java.lang.String r0 = i6.m.m(r0, r3)
            android.widget.EditText r3 = r12.f46947i
            r3.setText(r0)
            r12.f46961w = r1
            android.widget.TextView r0 = r12.M
            r0.setVisibility(r10)
        L_0x0231:
            r0 = r5
        L_0x0232:
            com.hbg.lib.common.mvp.ActivityPresenter r3 = r12.getPresenter()
            com.huobi.finance.presenter.UnifyWithdrawPresenter r3 = (com.huobi.finance.presenter.UnifyWithdrawPresenter) r3
            com.huobi.finance.bean.WithdrawTypeItem$WithdrawType r3 = r3.V0()
            com.huobi.finance.bean.WithdrawTypeItem$WithdrawType r4 = com.huobi.finance.bean.WithdrawTypeItem.WithdrawType.EOS
            if (r3 != r4) goto L_0x0242
            r3 = r2
            goto L_0x0243
        L_0x0242:
            r3 = r1
        L_0x0243:
            com.hbg.lib.common.mvp.ActivityPresenter r4 = r12.getPresenter()
            com.huobi.finance.presenter.UnifyWithdrawPresenter r4 = (com.huobi.finance.presenter.UnifyWithdrawPresenter) r4
            com.huobi.finance.bean.WithdrawTypeItem$WithdrawType r4 = r4.V0()
            com.huobi.finance.bean.WithdrawTypeItem$WithdrawType r7 = com.huobi.finance.bean.WithdrawTypeItem.WithdrawType.HUO_PAY
            if (r4 != r7) goto L_0x0253
            r4 = r2
            goto L_0x0254
        L_0x0253:
            r4 = r1
        L_0x0254:
            if (r3 != 0) goto L_0x025b
            if (r4 == 0) goto L_0x0259
            goto L_0x025b
        L_0x0259:
            r3 = r1
            goto L_0x025c
        L_0x025b:
            r3 = r2
        L_0x025c:
            android.view.View r4 = r12.E
            r4.setVisibility(r1)
            android.view.View r4 = r12.X
            r4.setVisibility(r1)
            android.view.View r4 = r12.F
            r4.setVisibility(r1)
            if (r3 == 0) goto L_0x029c
            r12.K = r9
            android.widget.TextView r4 = r12.f46949k
            r4.setVisibility(r10)
            r12.f46953o = r6
            android.widget.EditText r4 = r12.f46947i
            r4.setEnabled(r1)
            int r4 = r12.J
            java.lang.String r4 = i6.m.m(r6, r4)
            android.widget.EditText r7 = r12.f46947i
            r7.setText(r4)
            r12.f46961w = r1
            android.widget.TextView r4 = r12.M
            r4.setVisibility(r10)
            android.view.View r4 = r12.F
            r4.setVisibility(r10)
            android.view.View r4 = r12.E
            r4.setVisibility(r10)
            android.view.View r4 = r12.X
            r4.setVisibility(r10)
        L_0x029c:
            android.widget.TextView r4 = r12.M
            r4.setText(r0)
            android.widget.TextView r0 = r12.f46948j
            r4 = 2132027614(0x7f1428de, float:1.9693794E38)
            java.lang.String r4 = r12.getString(r4)
            r0.setText(r4)
            android.widget.TextView r0 = r12.f46955q
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x02be
            goto L_0x02cc
        L_0x02be:
            android.widget.TextView r0 = r12.f46955q
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = r0.trim()
        L_0x02cc:
            android.widget.TextView r0 = r12.f46955q
            java.lang.String r4 = java.lang.String.valueOf(r6)
            int r6 = r12.J
            java.lang.String r4 = i6.m.m(r4, r6)
            r0.setText(r4)
            com.hbg.lib.common.mvp.ActivityPresenter r0 = r12.getPresenter()
            com.huobi.finance.presenter.UnifyWithdrawPresenter r0 = (com.huobi.finance.presenter.UnifyWithdrawPresenter) r0
            boolean r0 = r0.j1()
            r12.B = r0
            android.widget.LinearLayout r4 = r12.f46959u
            if (r0 == 0) goto L_0x02ed
            r0 = r1
            goto L_0x02ee
        L_0x02ed:
            r0 = r10
        L_0x02ee:
            r4.setVisibility(r0)
            com.huobi.finance.bean.PreWithdrawData r14 = r14.e()
            java.lang.Integer r14 = r14.b()
            int r14 = r14.intValue()
            if (r14 != r2) goto L_0x0331
            android.widget.TextView r14 = r12.L
            r14.setVisibility(r1)
            java.util.Locale r14 = java.util.Locale.ENGLISH
            java.lang.String r14 = r14.toString()
            java.lang.String r0 = "user_config"
            java.lang.String r2 = "config_app_language"
            java.lang.String r14 = com.hbg.lib.core.util.ConfigPreferences.e(r0, r2, r14)
            java.util.Locale r0 = java.util.Locale.SIMPLIFIED_CHINESE
            java.lang.String r0 = r0.toString()
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x032b
            android.widget.TextView r14 = r12.L
            r0 = 2132027605(0x7f1428d5, float:1.9693776E38)
            java.lang.String r0 = r12.getString(r0)
            r14.setText(r0)
            goto L_0x0336
        L_0x032b:
            android.widget.TextView r14 = r12.L
            r14.setText(r5)
            goto L_0x0336
        L_0x0331:
            android.widget.TextView r14 = r12.L
            r14.setVisibility(r10)
        L_0x0336:
            android.widget.TextView r14 = r12.O
            r14.setText(r13)
            android.widget.TextView r13 = r12.f46946h0
            d7.k r14 = d7.k.C()
            com.hbg.lib.common.mvp.ActivityPresenter r0 = r12.getPresenter()
            com.huobi.finance.presenter.UnifyWithdrawPresenter r0 = (com.huobi.finance.presenter.UnifyWithdrawPresenter) r0
            java.lang.String r0 = r0.T0()
            java.lang.String r14 = r14.B(r0)
            r13.setText(r14)
            android.widget.EditText r13 = r12.f46945h
            r13.setText(r5)
            android.widget.EditText r13 = r12.f46960v
            if (r3 == 0) goto L_0x035d
            r14 = r5
            goto L_0x0364
        L_0x035d:
            r14 = 2132027613(0x7f1428dd, float:1.9693792E38)
            java.lang.String r14 = r12.getString(r14)
        L_0x0364:
            r13.setHint(r14)
            if (r3 == 0) goto L_0x036e
            java.lang.String r13 = r12.xi()
            goto L_0x036f
        L_0x036e:
            r13 = r5
        L_0x036f:
            android.widget.EditText r14 = r12.f46960v
            r14.setText(r13)
            android.widget.EditText r14 = r12.f46960v
            android.content.res.Resources r0 = r12.getResources()
            r2 = 2131099916(0x7f06010c, float:1.7812199E38)
            r4 = 2131100806(0x7f060486, float:1.7814004E38)
            if (r3 == 0) goto L_0x0384
            r6 = r2
            goto L_0x0385
        L_0x0384:
            r6 = r4
        L_0x0385:
            int r0 = r0.getColor(r6)
            r14.setTextColor(r0)
            android.widget.EditText r14 = r12.f46960v
            r0 = r3 ^ 1
            r14.setEnabled(r0)
            android.widget.EditText r14 = r12.f46964z
            if (r3 == 0) goto L_0x0399
            r0 = r5
            goto L_0x03a0
        L_0x0399:
            r0 = 2132027616(0x7f1428e0, float:1.9693798E38)
            java.lang.String r0 = r12.getString(r0)
        L_0x03a0:
            r14.setHint(r0)
            android.widget.EditText r14 = r12.f46964z
            if (r3 == 0) goto L_0x03ab
            java.lang.String r5 = r12.wi()
        L_0x03ab:
            r14.setText(r5)
            android.widget.EditText r14 = r12.f46964z
            android.content.res.Resources r0 = r12.getResources()
            if (r3 == 0) goto L_0x03b7
            goto L_0x03b8
        L_0x03b7:
            r2 = r4
        L_0x03b8:
            int r0 = r0.getColor(r2)
            r14.setTextColor(r0)
            android.widget.EditText r14 = r12.f46964z
            r0 = r3 ^ 1
            r14.setEnabled(r0)
            android.view.View r14 = r12.Y
            if (r3 == 0) goto L_0x03cb
            goto L_0x03cc
        L_0x03cb:
            r10 = r1
        L_0x03cc:
            r14.setVisibility(r10)
            r12.A(r1)
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x03e4
            android.widget.EditText r13 = r12.f46960v
            boolean r13 = r13.hasFocus()
            if (r13 != 0) goto L_0x03e4
            r12.mj()
            goto L_0x03e7
        L_0x03e4:
            r12.qi()
        L_0x03e7:
            r12.oj()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.ui.UnifyWithdrawActivity.Z9(java.lang.String, com.huobi.finance.bean.WithdrawInfo):void");
    }

    public void addEvent() {
        this.f46960v.setOnFocusChangeListener(this);
        this.f46947i.setOnFocusChangeListener(this);
        this.f46945h.setOnFocusChangeListener(this);
        this.f46964z.setOnFocusChangeListener(this);
        this.N.setOnClickListener(new ha(this));
        this.f46951m.setOnClickListener(new eb(this));
        this.f46952n.setOnClickListener(new fb(this));
        this.f46933b.setOnMenuItemClickListener(new na(this));
        this.f46945h.addTextChangedListener(new a());
        this.f46947i.addTextChangedListener(new b());
        this.f46960v.addTextChangedListener(new c());
        this.f46958t.setOnClickListener(new hb(this));
        this.f46956r.setOnRetryClickListener(new gb(this));
        this.F.setOnClickListener(new bb(this));
        this.E.setOnClickListener(new ib(this));
        this.C = new ma(this);
        this.f46963y.getViewTreeObserver().addOnGlobalLayoutListener(this.C);
        this.L.setOnClickListener(new qa(this));
        this.f46939e.setOnClickListener(new ia(this));
        this.f46934b0.setOnClickListener(new db(this));
    }

    public boolean canFullScreen() {
        return false;
    }

    public void e6(String str) {
        getUI().showProgressDialog();
        is.a.i("4058", is.a.d());
        v7.b.a().W(((UnifyWithdrawPresenter) getPresenter()).T0(), str).b().compose(RxJavaHelper.t((g) null)).subscribe(new d(str));
    }

    public void ea(int i11, boolean z11) {
        uj(i11);
        if (i11 == 10 && !z11) {
            HuobiToastUtil.j(R.string.withdraw_point_maximum);
        }
    }

    public void f5() {
        new BottomAgreementFragment.Builder().setTitle(getString(R.string.n_withdraw_huo_pay_auth_title)).setSubTitle(getString(R.string.n_withdraw_huo_pay_auth_sub_title)).setBody(getString(R.string.n_withdraw_huo_pay_auth_body)).setConfirmLabel(getString(R.string.n_withdraw_huo_pay_auth_confirm)).setOnConfirmListener(new cb(this)).show(this);
    }

    public int getContentView() {
        return R.layout.activity_unify_withdraw;
    }

    public void h9(List<WithdrawTypeItem> list) {
        this.V.setVisibility(list.size() > 1 ? 0 : 8);
        this.W.setData(list);
    }

    public final void hj(f fVar, View view, int i11) {
        ri(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_limit_verification);
        TextView textView = (TextView) view.findViewById(R.id.tv_limit_verification);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_limit_safe);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_limit_safe);
        StatusButton statusButton = (StatusButton) view.findViewById(R.id.btn_know);
        StatusButton statusButton2 = (StatusButton) view.findViewById(R.id.btn_action);
        int i12 = 2;
        if (i11 != 1) {
            if (i11 == 2) {
                imageView.setImageResource(R.drawable.common_marquee_selected_gray);
                textView.setTextColor(ContextCompat.getColor(this, R.color.global_secondary_text_color));
                imageView2.setImageResource(R.drawable.marquee_selected);
                textView2.setTextColor(ContextCompat.getColor(this, R.color.global_jump_btn_color));
                statusButton2.setButtonText((int) R.string.withdraw_action_3);
            } else if (i11 == 3 || i11 == 4 || i11 == 5) {
                imageView.setImageResource(R.drawable.common_marquee_selected_gray);
                textView.setTextColor(ContextCompat.getColor(this, R.color.global_secondary_text_color));
                imageView2.setImageResource(R.drawable.common_marquee_selected_gray);
                textView2.setTextColor(ContextCompat.getColor(this, R.color.global_secondary_text_color));
                statusButton2.setButtonText((int) R.string.withdraw_action_2);
            } else {
                imageView.setImageResource(R.drawable.marquee_selected);
                textView.setTextColor(ContextCompat.getColor(this, R.color.global_jump_btn_color));
                imageView2.setImageResource(R.drawable.marquee_selected);
                textView2.setTextColor(ContextCompat.getColor(this, R.color.global_jump_btn_color));
                statusButton2.setVisibility(8);
                i12 = 0;
            }
            statusButton.setOnClickListener(new fa(fVar));
            statusButton2.setOnClickListener(new ja(this, i12));
        }
        imageView.setImageResource(R.drawable.marquee_selected);
        textView.setTextColor(ContextCompat.getColor(this, R.color.global_jump_btn_color));
        imageView2.setImageResource(R.drawable.common_marquee_selected_gray);
        textView2.setTextColor(ContextCompat.getColor(this, R.color.global_secondary_text_color));
        statusButton2.setButtonText((int) R.string.withdraw_action_2);
        i12 = 1;
        statusButton.setOnClickListener(new fa(fVar));
        statusButton2.setOnClickListener(new ja(this, i12));
    }

    public final void ij() {
        this.D = false;
    }

    public void initView() {
        this.f46933b = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f46935c = (AppBarLayout) this.viewFinder.b(R.id.appbar_layout);
        setToolBar(this.f46933b, getResources().getString(R.string.balance_detail_withdraw), true);
        this.f46937d = (TextView) this.viewFinder.b(R.id.tv_available);
        this.f46939e = (TextView) this.viewFinder.b(R.id.tv_apply_more);
        this.Q = this.viewFinder.b(R.id.withdraw_chain_root);
        this.V = this.viewFinder.b(R.id.withdraw_type_root);
        this.f46941f = (TextView) this.viewFinder.b(R.id.tv_withdraw_desc);
        this.f46943g = (TextView) this.viewFinder.b(R.id.tv_currency);
        this.f46950l = (TextView) this.viewFinder.b(R.id.tv_fee_currency);
        this.f46945h = (EditText) this.viewFinder.b(R.id.withdraw_edit_amount);
        this.f46947i = (EditText) this.viewFinder.b(R.id.withdraw_fee_edit);
        this.f46948j = (TextView) this.viewFinder.b(R.id.tv_fee_title);
        this.f46949k = (TextView) this.viewFinder.b(R.id.tv_fee_prop);
        this.f46951m = this.viewFinder.b(R.id.tv_all);
        this.f46952n = this.viewFinder.b(R.id.iv_withdraw_ask);
        this.f46955q = (TextView) this.viewFinder.b(R.id.tv_receive_amount);
        this.f46954p = (TextView) this.viewFinder.b(R.id.tv_receive_amount_currency);
        this.f46958t = this.viewFinder.b(R.id.btn_action);
        this.f46959u = (LinearLayout) this.viewFinder.b(R.id.ll_tag_area);
        EditText editText = (EditText) this.viewFinder.b(R.id.withdraw_address_edit_amount);
        this.f46960v = editText;
        editText.clearFocus();
        this.f46964z = (EditText) this.viewFinder.b(R.id.withdraw_tag_edit);
        this.f46963y = (CoordinatorLayout) this.viewFinder.b(R.id.root);
        this.A = (NestedScrollView) this.viewFinder.b(R.id.nsv);
        this.E = this.viewFinder.b(R.id.tv_scan);
        this.X = this.viewFinder.b(R.id.divider_scan_select);
        this.F = this.viewFinder.b(R.id.tv_select);
        this.G = (LinearLayout) this.viewFinder.b(R.id.ll_withdraw_area);
        this.f46956r = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.f46944g0 = this.viewFinder.b(R.id.loading_mask);
        this.f46956r.setEmptyView(LayoutInflater.from(this).inflate(R.layout.withdraw_no_open_view, (ViewGroup) null));
        this.G.post(new ya(this));
        this.I = new PointLengthFilter();
        InputFilter.LengthFilter lengthFilter = new InputFilter.LengthFilter(20);
        this.f46932a0 = lengthFilter;
        this.f46945h.setFilters(new InputFilter[]{this.I, lengthFilter});
        this.f46947i.setFilters(new InputFilter[]{this.I, this.f46932a0});
        this.f46952n.post(new za(this));
        this.L = (TextView) this.viewFinder.b(R.id.withdraw_fee_tip_tv);
        this.M = (TextView) this.viewFinder.b(R.id.withdraw_fee_between_tv);
        this.N = this.viewFinder.b(R.id.currency_select_root);
        this.O = (TextView) this.viewFinder.b(R.id.currency_title);
        this.f46946h0 = (TextView) this.viewFinder.b(R.id.currency_title_full_name);
        gs.e.b().c("PM_WITHDRAW");
        LinearLayout linearLayout = (LinearLayout) this.viewFinder.b(R.id.available_amount_ll);
        EasyRecyclerView<ChainItem> easyRecyclerView = (EasyRecyclerView) this.viewFinder.b(R.id.withdraw_chain_list);
        this.P = easyRecyclerView;
        easyRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        this.P.addItemDecoration(new GridDividerItemDecoration(ContextCompat.getDrawable(this, R.color.baseColorContentBackground), PixelUtils.a(10.0f)));
        EasyRecyclerView<WithdrawTypeItem> easyRecyclerView2 = (EasyRecyclerView) this.viewFinder.b(R.id.withdraw_type_list);
        this.W = easyRecyclerView2;
        easyRecyclerView2.setLayoutManager(new GridLayoutManager(this, 4));
        this.W.addItemDecoration(new GridDividerItemDecoration(ContextCompat.getDrawable(this, R.color.baseColorContentBackground), PixelUtils.a(10.0f)));
        this.R = this.viewFinder.b(R.id.v_tag_divider);
        this.S = this.viewFinder.b(R.id.v_amount_divider);
        this.U = this.viewFinder.b(R.id.v_fee_divider);
        this.T = this.viewFinder.b(R.id.v_address_divider);
        this.Y = this.viewFinder.b(R.id.tv_tag_subtitle);
        this.f46934b0 = (LinearLayout) this.viewFinder.b(R.id.linear_layout_withdraw_address_notice);
        this.f46936c0 = (LinearLayout) this.viewFinder.b(R.id.linear_layout_withdraw_notice);
        this.f46938d0 = (MarqueeView) this.viewFinder.b(R.id.text_view_withdraw_notice);
        this.f46940e0 = (TextView) this.viewFinder.b(R.id.text_view_withdraw_address_notice);
        this.f46938d0.setRate(getResources().getDimension(R.dimen.dimen_36));
        this.f46938d0.setTextMarginLeft(getResources().getDimensionPixelOffset(R.dimen.dimen_10));
        this.f46938d0.setTextSpace(getResources().getDimension(R.dimen.dimen_170));
        this.f46938d0.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.global_text_size_12));
        this.f46938d0.setTextColor(ContextCompat.getColor(this, R.color.baseColorMajorTheme100));
    }

    public final void jj() {
        if (!this.D) {
            if (this.f46960v.hasFocus()) {
                this.f46935c.setExpanded(false);
            }
            if (this.f46960v.hasFocus() || this.f46945h.hasFocus() || this.f46947i.hasFocus() || this.f46964z.hasFocus()) {
                this.f46935c.setExpanded(false);
                this.A.postDelayed(new xa(this), 150);
            }
            this.D = true;
        }
    }

    public final void kj(String str, int i11) {
        if (!TextUtils.isEmpty(str)) {
            if (i11 == 1) {
                str = e1.b(c1.z(), str);
            }
            HBBaseWebActivity.showWebView(this, str, "", getResources().getString(R.string.head_return), false);
        }
    }

    public final boolean lj(ChainInfo chainInfo) {
        String chain;
        if (chainInfo == null || (chain = chainInfo.getChain()) == null || (!chain.toLowerCase().startsWith("hrc20") && !chain.toLowerCase().startsWith("ht2"))) {
            return false;
        }
        return !ConfigPreferences.c("user_config", "config_withdraw_chain_hrc20_tips_no_more", false);
    }

    public final void mj() {
        ViewUtil.m(this.f46934b0, ((UnifyWithdrawPresenter) getPresenter()).V0() == WithdrawTypeItem.WithdrawType.NORMAL);
    }

    public final void nj() {
        DialogUtils.c0(this, String.format(getString(R.string.withdraw_empty_tag_confirm), new Object[]{((UnifyWithdrawPresenter) getPresenter()).W0()}), "", getString(R.string.security_google_cancel), getString(R.string.setting_sign_out_confirm), va.f47367a, new sa(this));
    }

    public final void oi(boolean z11) {
        if (!ViewUtil.c(1000)) {
            String trim = this.f46960v.getText().toString().trim();
            String b12 = ((UnifyWithdrawPresenter) getPresenter()).b1();
            if (TextUtils.isEmpty(trim)) {
                HuobiToastUtil.j(R.string.withdraw_point_address);
                return;
            }
            String trim2 = this.f46945h.getText().toString().trim();
            if (TextUtils.isEmpty(trim2) || m.a(trim2).compareTo(BigDecimal.ZERO) == 0) {
                HuobiToastUtil.j(R.string.withdraw_point_amount);
                return;
            }
            String str = this.Z;
            if (str != null && m.a(str).compareTo(m.a(trim2)) < 0) {
                HuobiToastUtil.j(R.string.available_not_enough);
            } else if (m.a(trim2).compareTo(m.a(b12)) < 0) {
                HuobiToastUtil.j(R.string.n_withdraw_less_than_min);
            } else if (this.f46961w && TextUtils.isEmpty(this.f46947i.getText().toString().trim())) {
                HuobiToastUtil.j(R.string.withdraw_point_fee);
            } else if (((UnifyWithdrawPresenter) getPresenter()).j1() && TextUtils.isEmpty(this.f46964z.getText().toString().trim()) && !z11) {
                nj();
            } else if (((UnifyWithdrawPresenter) getPresenter()).h2(trim2, false) == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put(InnerShareParams.ADDRESS, ti());
                hashMap.put("amount", this.f46955q.getText().toString().trim());
                hashMap.put("fee", vi());
                String ui2 = ui();
                if (!TextUtils.isEmpty(ui2)) {
                    hashMap.put("addr-tag", ui2);
                }
                ((UnifyWithdrawPresenter) getPresenter()).M0(hashMap);
            }
        }
    }

    public final void oj() {
        if (lj(((UnifyWithdrawPresenter) getPresenter()).S0())) {
            new DialogUtils.b.d(this).c1(getString(R.string.n_withdraw_chain_tips)).x0(true).C0(getString(R.string.n_withdraw_chain_hrc20_tips_content_2)).y0(getString(R.string.n_do_not_prompt_next_time)).v0(new oa(this)).q0(false).T0(true).S0(Integer.valueOf(getResources().getColor(R.color.dialog_confirm_text_color))).R0(getString(R.string.n_withdraw_chain_hrc20_notice)).U0(new ua(this)).P0(getResources().getString(R.string.dialog_minamount_hint_confrm_btn)).Q0(new ta(this)).k0().show(getSupportFragmentManager(), "");
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1) {
            if (i11 == 200 && intent != null) {
                String stringExtra = intent.getStringExtra("result_string");
                this.f46960v.setText(stringExtra);
                if (TextUtils.isEmpty(stringExtra) || this.f46960v.hasFocus()) {
                    qi();
                } else {
                    mj();
                }
            }
            if (i11 == 201 && intent != null) {
                VirtualAddressInfo virtualAddressInfo = (VirtualAddressInfo) intent.getSerializableExtra("select_withdraw_address");
                this.f46960v.setText(virtualAddressInfo.getAddress());
                if (TextUtils.isEmpty(virtualAddressInfo.getAddress()) || this.f46960v.hasFocus()) {
                    qi();
                } else {
                    mj();
                }
                if (this.B) {
                    this.f46964z.setText(virtualAddressInfo.getTag());
                }
            } else if (i11 == 202) {
                finish();
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_currency_detail_record, menu);
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f46963y.getViewTreeObserver().removeGlobalOnLayoutListener(this.C);
    }

    public void onFocusChange(View view, boolean z11) {
        EditText editText;
        EditText editText2;
        if (view != null) {
            View view2 = null;
            switch (view.getId()) {
                case R.id.withdraw_address_edit_amount:
                    view2 = this.T;
                    if (z11 || (editText2 = this.f46960v) == null || editText2.getText() == null || TextUtils.isEmpty(this.f46960v.getText())) {
                        if (!z11 && (editText = this.f46960v) != null && editText.getText() != null && TextUtils.isEmpty(this.f46960v.getText())) {
                            qi();
                            break;
                        }
                    } else {
                        mj();
                        break;
                    }
                    break;
                case R.id.withdraw_edit_amount:
                    view2 = this.S;
                    break;
                case R.id.withdraw_fee_edit:
                    EditText editText3 = this.f46947i;
                    if (editText3 != null && editText3.isEnabled()) {
                        view2 = this.U;
                        break;
                    }
                case R.id.withdraw_tag_edit:
                    view2 = this.R;
                    break;
            }
            if (view2 == null) {
                return;
            }
            if (z11) {
                view2.setBackgroundColor(getResources().getColor(R.color.global_button_end_color));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.global_divider_color));
            }
        }
    }

    public void onRestart() {
        super.onRestart();
        ((UnifyWithdrawPresenter) getPresenter()).V1();
    }

    public void onResume() {
        super.onResume();
    }

    /* renamed from: pi */
    public UnifyWithdrawPresenter createPresenter() {
        return new UnifyWithdrawPresenter();
    }

    public final void pj(String str, String str2) {
        w0.g().k(false);
        WithdrawInfoConfirmActivity.yh(this, 202, ((UnifyWithdrawPresenter) getPresenter()).T0(), str, ti(), str2, ((UnifyWithdrawPresenter) getPresenter()).V0(), ((UnifyWithdrawPresenter) getPresenter()).S0(), vi(), ui(), this.f46955q.getText().toString());
    }

    public final void qi() {
        this.f46934b0.setVisibility(8);
    }

    public final void qj(Integer num) {
        if (num.intValue() <= 0) {
            w0.g().d();
        } else if (w0.g().f()) {
            int intValue = num.intValue() - 1;
            i.b().g(new ab(this, num), 1000);
            w0.g().l(String.format(getResources().getString(R.string.n_withdraw_stop_time), new Object[]{" " + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(intValue / 60)}) + ":" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(intValue % 60)}) + " "}));
        }
    }

    public final void ri(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_single_limit_size);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_day_limit_size);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_day_limit_size_label);
        TextView textView4 = (TextView) view.findViewById(R.id.tv_total_limit_size);
        TextView textView5 = (TextView) view.findViewById(R.id.tv_total_limit_size_label);
        TextView textView6 = (TextView) view.findViewById(R.id.tv_single_available_size);
        TextView textView7 = (TextView) view.findViewById(R.id.tv_day_available_size);
        TextView textView8 = (TextView) view.findViewById(R.id.tv_day_available_size_label);
        TextView textView9 = (TextView) view.findViewById(R.id.tv_total_limit_available_size);
        TextView textView10 = (TextView) view.findViewById(R.id.tv_total_limit_available_size_label);
        PreWithdrawData e11 = ((UnifyWithdrawPresenter) getPresenter()).Z0().e();
        WithdrawQuotaDetails h11 = e11.h();
        if (h11 == null) {
            LimitDescription e12 = e11.e();
            if (e12 != null) {
                h11 = e12.a();
            } else {
                h11 = new WithdrawQuotaDetails();
            }
        }
        textView.setText(si(h11.getSingleAmount()));
        textView6.setText(si(h11.getSingleAmount()));
        boolean z11 = m.a(h11.getTotal24hAmount()).compareTo(m.a("-1")) != 0;
        ViewUtil.m(textView2, !z11);
        ViewUtil.m(textView3, !z11);
        ViewUtil.m(textView7, !z11);
        ViewUtil.m(textView8, !z11);
        ViewUtil.m(textView4, z11);
        ViewUtil.m(textView5, z11);
        ViewUtil.m(textView9, z11);
        ViewUtil.m(textView10, z11);
        if (z11) {
            textView4.setText(si(h11.getTotal24hAmount()));
            textView9.setText(si(h11.getTotal24hLeft()));
            return;
        }
        textView2.setText(si(h11.getChain24hAmount()));
        textView7.setText(si(h11.getChain24hLeft()));
    }

    public final void rj(Activity activity) {
        if (!NetworkStatus.c(activity)) {
            HuobiToastUtil.j(R.string.server_error);
            return;
        }
        ((UnifyWithdrawPresenter) getPresenter()).N0();
        activity.startActivity(new Intent(activity, SecuritySetActivity.class));
    }

    public void s8(String str) {
        this.O.setText(str);
        this.f46946h0.setText(k.C().B(((UnifyWithdrawPresenter) getPresenter()).T0()));
    }

    public final String si(String str) {
        try {
            if (Integer.parseInt(str) == -1) {
                return getString(R.string.n_unlimited);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return m.m(str, 4);
    }

    public final void sj(Activity activity) {
        if (!NetworkStatus.c(activity)) {
            HuobiToastUtil.j(R.string.server_error);
            return;
        }
        ((UnifyWithdrawPresenter) getPresenter()).N0();
        FlutterKycConfig flutterKycConfig = new FlutterKycConfig();
        flutterKycConfig.setPhone(r.x().F());
        flutterKycConfig.setEmail(r.x().u());
        b2.a.d().a("/account/kyc").withSerializable("flag_kyc_config", flutterKycConfig).navigation();
    }

    public final String ti() {
        WithdrawTypeItem.WithdrawType V0 = ((UnifyWithdrawPresenter) getPresenter()).V0();
        WithdrawInfo Z0 = ((UnifyWithdrawPresenter) getPresenter()).Z0();
        if (V0 == WithdrawTypeItem.WithdrawType.EOS) {
            return Z0.c().getAddress();
        }
        if (V0 == WithdrawTypeItem.WithdrawType.HUO_PAY) {
            return Z0.d().getAddress();
        }
        return this.f46960v.getText().toString().trim();
    }

    public final String tj(BigDecimal bigDecimal, String str) {
        return m.q(bigDecimal, PrecisionUtil.a(TradeType.PRO, str));
    }

    public void u4() {
        yf(2);
        DialogUtils.X(this, getString(R.string.n_balance_withdraw_risk_apply_submitted), getString(R.string.n_balance_withdraw_risk_apply_tip), (String) null, getString(R.string.n_known), ad.b.f3517a);
    }

    public final String ui() {
        WithdrawTypeItem.WithdrawType V0 = ((UnifyWithdrawPresenter) getPresenter()).V0();
        WithdrawInfo Z0 = ((UnifyWithdrawPresenter) getPresenter()).Z0();
        if (V0 == WithdrawTypeItem.WithdrawType.EOS) {
            return Z0.c().getTag();
        }
        if (V0 == WithdrawTypeItem.WithdrawType.HUO_PAY) {
            return Z0.d().getAddressTag();
        }
        return this.f46964z.getText().toString().trim();
    }

    public final void uj(int i11) {
        if (this.f46962x == null) {
            this.f46962x = new f(this);
        }
        this.f46962x.a(i11);
        if (!this.f46962x.isShowing()) {
            this.f46962x.show();
        }
        this.f46962x.b();
    }

    public final String vi() {
        if (this.f46961w) {
            return this.f46947i.getText().toString().trim();
        }
        return this.f46953o;
    }

    public final String wi() {
        WithdrawTypeItem.WithdrawType V0 = ((UnifyWithdrawPresenter) getPresenter()).V0();
        WithdrawInfo Z0 = ((UnifyWithdrawPresenter) getPresenter()).Z0();
        if (V0 == WithdrawTypeItem.WithdrawType.EOS) {
            return Z0.c().getTag();
        }
        if (V0 == WithdrawTypeItem.WithdrawType.HUO_PAY) {
            return Z0.d().getAddressTag();
        }
        return null;
    }

    public final String xi() {
        return yi(((UnifyWithdrawPresenter) getPresenter()).V0());
    }

    public void y(boolean z11) {
        SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f46957s;
        if (securityStrategyBottomMenuFragment != null) {
            securityStrategyBottomMenuFragment.Bi(z11);
        }
    }

    public void ye(boolean z11) {
        ViewUtil.m(this.f46956r, true);
        dismissProgressDialog();
        if (z11) {
            this.A.setVisibility(4);
            this.f46956r.i();
            return;
        }
        this.f46956r.k();
    }

    public void yf(int i11) {
        if (i11 == 1) {
            this.f46939e.setEnabled(true);
            this.f46939e.setText(R.string.n_balance_withdraw_risk_apply);
            this.f46939e.setTextColor(ContextCompat.getColor(this, R.color.baseColorMajorTheme100));
            ViewUtil.m(this.f46939e, true);
        } else if (i11 != 2) {
            ViewUtil.m(this.f46939e, false);
        } else {
            this.f46939e.setEnabled(false);
            this.f46939e.setText(R.string.n_balance_withdraw_risk_apply_processing);
            this.f46939e.setTextColor(ContextCompat.getColor(this, R.color.baseColorThreeLevelText));
            ViewUtil.m(this.f46939e, true);
        }
    }

    public final String yi(WithdrawTypeItem.WithdrawType withdrawType) {
        WithdrawInfo Z0 = ((UnifyWithdrawPresenter) getPresenter()).Z0();
        if (withdrawType == WithdrawTypeItem.WithdrawType.EOS) {
            return getString(R.string.n_inner_withdraw_address, new Object[]{Z0.c().getUid()});
        } else if (withdrawType != WithdrawTypeItem.WithdrawType.HUO_PAY) {
            return null;
        } else {
            return getString(R.string.n_withdraw_huo_pay_title) + String.format(Locale.US, "(MOBILE: %s)", new Object[]{r.x().F()});
        }
    }

    public final void zi(String str, boolean z11) {
        w0.g().k(false);
        w0.g().m();
        v7.b.a().C0(z11).b().compose(RxJavaHelper.t((g) null)).subscribe(new e(z11, str));
    }
}
