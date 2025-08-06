package com.huobi.feature.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.contract.R$color;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.contract.R$style;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.network.swap.core.bean.LeverRate;
import com.hbg.lib.widgets.ProgressButton;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.contract.ContractModuleConfig;
import com.huobi.view.keyboard.CustomBoardView;
import com.huobi.view.seekbar.LeverDialogSeekBar;
import com.huobi.view.seekbar.MultiColorSeekBar;
import com.huobi.view.seekbar.MultiConfigBuilder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import m9.z;
import pk.a3;
import pk.b3;
import pk.c3;
import pk.d3;
import pk.e3;
import pk.f3;
import pk.g3;
import pk.q2;
import pk.r2;
import pk.s2;
import pk.t2;
import pk.u2;
import pk.v2;
import pk.w2;
import pk.x2;
import pk.y2;
import pk.z2;
import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class LeverSelectDialogFragment extends BaseDialogFragment implements ViewTreeObserver.OnGlobalLayoutListener {
    public float A;
    public float B;
    public int C;
    public final CompositeSubscription D = new CompositeSubscription();
    public boolean E;
    public boolean F;
    public TextView G;
    public String H;
    public Runnable I = new t2(this);
    public int J;

    /* renamed from: b  reason: collision with root package name */
    public TextView f44974b;

    /* renamed from: c  reason: collision with root package name */
    public View f44975c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressButton f44976d;

    /* renamed from: e  reason: collision with root package name */
    public View f44977e;

    /* renamed from: f  reason: collision with root package name */
    public View f44978f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44979g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44980h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f44981i;

    /* renamed from: j  reason: collision with root package name */
    public EditText f44982j;

    /* renamed from: k  reason: collision with root package name */
    public LeverDialogSeekBar f44983k;

    /* renamed from: l  reason: collision with root package name */
    public List<String> f44984l;

    /* renamed from: m  reason: collision with root package name */
    public String f44985m;

    /* renamed from: n  reason: collision with root package name */
    public String f44986n;

    /* renamed from: o  reason: collision with root package name */
    public String f44987o;

    /* renamed from: p  reason: collision with root package name */
    public String f44988p;

    /* renamed from: q  reason: collision with root package name */
    public String f44989q;

    /* renamed from: r  reason: collision with root package name */
    public TradeType f44990r;

    /* renamed from: s  reason: collision with root package name */
    public int f44991s = 2;

    /* renamed from: t  reason: collision with root package name */
    public h f44992t;

    /* renamed from: u  reason: collision with root package name */
    public DecelerateInterpolator f44993u = new DecelerateInterpolator();

    /* renamed from: v  reason: collision with root package name */
    public int f44994v;

    /* renamed from: w  reason: collision with root package name */
    public CustomBoardView f44995w;

    /* renamed from: x  reason: collision with root package name */
    public ImageView f44996x;

    /* renamed from: y  reason: collision with root package name */
    public ImageView f44997y;

    /* renamed from: z  reason: collision with root package name */
    public View f44998z;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            i6.d.d("onProgressChanged afterTextChanged s:" + editable.toString());
            LeverSelectDialogFragment.this.pi();
            if (LeverSelectDialogFragment.this.f44982j.hasFocus()) {
                HashMap hashMap = new HashMap();
                hashMap.put("business_category", "lever_adjust");
                if (LeverSelectDialogFragment.this.f44990r == TradeType.LINEAR_SWAP) {
                    hashMap.put("type", "usdt_contract");
                } else {
                    hashMap.put("type", "coin_contract");
                }
                hashMap.put("button_name", "manual_input");
                hashMap.put("margin_type", SPUtil.j() ? "usdt_multiple" : "usdt_single");
                BaseModuleConfig.a().w("appclick_contracts", hashMap);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            i6.d.d("onProgressChanged onTextChanged s:" + charSequence + " start:" + i11 + " before:" + i12);
        }
    }

    public class b implements MultiColorSeekBar.OnProgressChangedListener {
        public b() {
        }

        public void getProgressOnActionUp(MultiColorSeekBar multiColorSeekBar, int i11, float f11) {
            i6.d.d("onProgressChanged getProgressOnActionUp  progress:" + i11 + " progressFloat:" + f11 + " mMax:" + LeverSelectDialogFragment.this.B);
            boolean unused = LeverSelectDialogFragment.this.E = false;
            i6.i.b().h(LeverSelectDialogFragment.this.I);
            i6.i.b().g(LeverSelectDialogFragment.this.I, 0);
            if (LeverSelectDialogFragment.this.Yh()) {
                LeverSelectDialogFragment.this.f44983k.setProgress((float) i11);
            }
            LeverSelectDialogFragment.this.Ci();
        }

        public void getProgressOnFinally(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
        }

        public void onProgressChanged(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
            boolean unused = LeverSelectDialogFragment.this.E = z11;
            if (z11 && LeverSelectDialogFragment.this.C != i11) {
                i6.d.d("onProgressChanged fromUser:" + z11 + " progress:" + i11 + " progressFloat:" + f11);
                LeverSelectDialogFragment.this.f44982j.setText(String.valueOf(i11));
                LeverSelectDialogFragment.this.f44982j.setSelection(LeverSelectDialogFragment.this.f44982j.getText().length());
            }
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationEnd(Animator animator) {
            LeverSelectDialogFragment.this.f44977e.setVisibility(LeverSelectDialogFragment.this.C > 5 ? 0 : 8);
        }
    }

    public class d extends BaseSubscriber<List<LevelAvailableMarginInfo>> {
        public d() {
        }

        public void onNext(List<LevelAvailableMarginInfo> list) {
            super.onNext(list);
            LeverSelectDialogFragment.this.qi();
        }
    }

    public class e extends EasySubscriber<LeverRate> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45003b;

        public class a extends EasySubscriber<Object> {
            public a() {
            }

            public void onError2(Throwable th2) {
                super.onError2(th2);
                LeverSelectDialogFragment.this.f44976d.a();
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                super.onFailed(aPIStatusErrorException);
                LeverSelectDialogFragment.this.f44976d.a();
            }

            public void onNext(Object obj) {
                super.onNext(obj);
                z.f().g(false).compose(RxJavaHelper.t((u6.g) null)).subscribe(new BaseSubscriber());
                LeverSelectDialogFragment.this.oi();
            }
        }

        public e(String str) {
            this.f45003b = str;
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void d(View view) {
            LeverSelectDialogFragment.this.f44976d.a();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Observable e(String str, Object obj) {
            return l9.a.a().K(LeverSelectDialogFragment.this.f44985m, str).b();
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void f(String str, View view) {
            l9.a.a().agreeHighLever().b().flatMap(new g3(this, str)).compose(RxJavaHelper.t((u6.g) null)).subscribe(new a());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* renamed from: g */
        public void onNext(LeverRate leverRate) {
            super.onNext(leverRate);
            LeverSelectDialogFragment.this.oi();
        }

        public void onError2(Throwable th2) {
            LeverSelectDialogFragment.this.f44976d.a();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (!"1233".equals(aPIStatusErrorException.getErrCode()) || BaseModuleConfig.a().c()) {
                if (BaseModuleConfig.a().c() && aPIStatusErrorException.getErrCode().equals(EasySubscriber.ERROR_CODE_1451)) {
                    LeverSelectDialogFragment.this.Bi(true);
                } else if (BaseModuleConfig.a().c() || !aPIStatusErrorException.getErrCode().equals(EasySubscriber.ERROR_CODE_1450)) {
                    super.onFailed(aPIStatusErrorException);
                } else {
                    LeverSelectDialogFragment.this.Bi(false);
                }
                LeverSelectDialogFragment.this.f44976d.a();
                return;
            }
            us.e.a(LeverSelectDialogFragment.this.getContext(), new e3(this), new f3(this, this.f45003b));
        }
    }

    public class f extends BaseSubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f45006b;

        public f(View view) {
            this.f45006b = view;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            unsubscribe();
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            if (!this.f45006b.isLongClickable() || !this.f45006b.isPressed()) {
                unsubscribe();
            } else {
                LeverSelectDialogFragment.this.Di(this.f45006b);
            }
        }
    }

    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45008a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f45008a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f45008a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f45008a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.feature.ui.LeverSelectDialogFragment.g.<clinit>():void");
        }
    }

    public interface h {
        void N0();

        Observable<List<LevelAvailableMarginInfo>> O0(TradeType tradeType, String str, int i11);

        void P0(String str);

        String[] Q0(String str, LevelAvailableMarginInfo levelAvailableMarginInfo);

        boolean R0(LeverSelectDialogFragment leverSelectDialogFragment, String str);
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            LeverSelectDialogFragment.this.Di(view);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class j implements View.OnLongClickListener {
        public j() {
        }

        public boolean onLongClick(View view) {
            LeverSelectDialogFragment.this.D.add(LeverSelectDialogFragment.this.ci(view));
            return false;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ei(View view) {
        this.f44982j.requestFocus();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fi(View view, boolean z11) {
        if (z11) {
            this.f44995w.showKeyBoardLayout(this.f44982j, 1);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void gi(View view) {
        h hVar = this.f44992t;
        if (hVar != null) {
            hVar.N0();
            doDismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void hi(ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.f44978f.getLayoutParams();
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f44978f.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ii(ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.f44978f.getLayoutParams();
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f44978f.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ji(View view) {
        ContractModuleConfig.a().j(getActivity());
        doDismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
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
        this.f44976d.c();
        ni(this.f44988p);
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "lever_adjust");
        if (this.f44990r == TradeType.LINEAR_SWAP) {
            hashMap.put("type", "usdt_contract");
        } else {
            hashMap.put("type", "coin_contract");
        }
        hashMap.put("button_name", "confirm");
        hashMap.put("margin_type", SPUtil.j() ? "usdt_multiple" : "usdt_single");
        BaseModuleConfig.a().w("appclick_contracts", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        ri(this.C, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void li(HBDialogFragment hBDialogFragment) {
        HBBaseWebActivity.showWebView(getActivity(), this.f44989q, "", "", true);
    }

    public void Ai(String str) {
        this.H = str;
    }

    public void Bi(boolean z11) {
        String str;
        String str2;
        if (z11) {
            str = getString(R$string.n_contract_unsupport_current_level_child_account);
        } else {
            str = getString(R$string.n_contract_unsupport_current_level);
        }
        if (z11) {
            str2 = "";
        } else {
            str2 = getString(R$string.n_contract_view_risk_level);
        }
        new DialogUtils.b.d(getActivity()).c1(getString(R$string.lite_market_info_price_notice_title)).C0(str).R0(str2).U0(new r2(this)).S0(Integer.valueOf(getResources().getColor(R$color.baseColorLightBubble))).T0(true).q0(false).P0(getString(R$string.voice_call_success_i_know)).Q0(s2.f53140a).k0().show(getChildFragmentManager(), "");
    }

    public final void Ci() {
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "lever_adjust");
        if (this.f44990r == TradeType.LINEAR_SWAP) {
            hashMap.put("type", "usdt_contract");
        } else {
            hashMap.put("type", "coin_contract");
        }
        hashMap.put("button_name", "slide");
        hashMap.put("margin_type", SPUtil.j() ? "usdt_multiple" : "usdt_single");
        BaseModuleConfig.a().w("appclick_contracts", hashMap);
    }

    public final void Di(View view) {
        if (view == this.f44996x) {
            this.C++;
            Wh();
            this.f44982j.setText(String.valueOf(this.C));
            EditText editText = this.f44982j;
            editText.setSelection(editText.getText().length());
        } else if (view == this.f44997y) {
            this.C--;
            Wh();
            this.f44982j.setText(String.valueOf(this.C));
            EditText editText2 = this.f44982j;
            editText2.setSelection(editText2.getText().length());
        }
    }

    public final boolean Wh() {
        int i11 = this.C;
        float f11 = this.A;
        if (((float) i11) < f11) {
            this.C = (int) f11;
            return true;
        }
        float f12 = this.B;
        if (((float) i11) <= f12) {
            return false;
        }
        this.C = (int) f12;
        return true;
    }

    public final boolean Xh(String str) {
        if (str.charAt(0) != '0') {
            int i11 = this.C;
            float f11 = this.A;
            if (((float) i11) < f11) {
                this.C = (int) f11;
            } else {
                float f12 = this.B;
                if (((float) i11) <= f12) {
                    return false;
                }
                this.C = (int) f12;
            }
        } else if (str.length() <= 1) {
            return false;
        }
        return true;
    }

    public final boolean Yh() {
        return this.B <= 10.0f;
    }

    public void Zh() {
        ProgressButton progressButton = this.f44976d;
        if (progressButton != null) {
            progressButton.a();
        }
    }

    public void addEvent(r rVar) {
        rVar.b(R$id.dialog_contract_bg).setOnClickListener(new y2(this));
        this.f44998z.setOnClickListener(c3.f53066b);
        this.f44998z.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.f44975c.setOnClickListener(new a3(this));
        this.f44976d.setOnClickListener(new x2(this));
        rVar.b(R$id.input_et_parent).setOnClickListener(new w2(this));
        this.f44982j.setOnFocusChangeListener(new d3(this));
        this.f44982j.addTextChangedListener(new a());
        this.f44983k.setOnProgressChangedListener(new b());
        this.f44996x.setOnClickListener(new i());
        this.f44997y.setOnClickListener(new i());
        this.f44996x.setOnLongClickListener(new j());
        this.f44997y.setOnLongClickListener(new j());
        ai();
        this.G.setOnClickListener(new b3(this));
    }

    public void afterInit() {
        h hVar;
        yi((String) null);
        String str = this.f44985m;
        int i11 = g.f45008a[this.f44990r.ordinal()];
        if (i11 == 1) {
            str = this.f44986n;
        } else if (i11 == 2) {
            str = this.f44986n;
        }
        this.f44982j.setText(String.valueOf(this.C));
        EditText editText = this.f44982j;
        editText.setSelection(editText.getText().length());
        if (!this.F && (hVar = this.f44992t) != null && this.H == null) {
            hVar.O0(this.f44990r, str, this.f44991s).compose(RxJavaHelper.t((u6.g) null)).subscribe(new d());
        }
    }

    public final void ai() {
        Context context = getContext();
        if (context != null) {
            MultiConfigBuilder colorConfig = this.f44983k.getConfigBuilder().min(this.A).max(this.B).setDanger(this.B + 0.1f).colorConfig(context, NightHelper.e().g(), true);
            if (Yh()) {
                colorConfig.sectionCount((int) (this.B - 1.0f));
                colorConfig.animDuration(0);
            } else {
                colorConfig.sectionCount(5);
            }
            colorConfig.build();
        }
    }

    public void bc(String str) {
        this.f44985m = str;
    }

    public String bi() {
        return this.f44986n;
    }

    public final Subscription ci(View view) {
        return Observable.interval(0, 100, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t((u6.g) null)).subscribe(new f(view));
    }

    /* renamed from: di */
    public final void ki() {
        if (this.f44994v == 0) {
            this.f44994v = this.f44977e.getHeight();
        }
        if (this.C > 5) {
            this.f44977e.setVisibility(0);
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f44978f.getHeight(), this.f44994v});
            ofInt.setDuration(300);
            ofInt.setInterpolator(this.f44993u);
            ofInt.addUpdateListener(new q2(this));
            ofInt.start();
            View view = this.f44977e;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{view.getAlpha(), 1.0f});
            ofFloat.setDuration(300).setInterpolator(this.f44993u);
            ofFloat.start();
            return;
        }
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{this.f44978f.getHeight(), 0});
        ofInt2.setDuration(300);
        ofInt2.setInterpolator(this.f44993u);
        ofInt2.addUpdateListener(new v2(this));
        ofInt2.addListener(new c());
        ofInt2.start();
        View view2 = this.f44977e;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "alpha", new float[]{view2.getAlpha(), 0.0f});
        ofFloat2.setDuration(300).setInterpolator(this.f44993u);
        ofFloat2.start();
    }

    public void dismiss() {
        ProgressButton progressButton = this.f44976d;
        if (progressButton != null) {
            progressButton.a();
        }
        this.D.clear();
        View view = this.f44998z;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        super.dismiss();
    }

    public int getAnimationStyle() {
        return R$style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R$layout.dialog_lever_select;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f44974b = (TextView) rVar.b(R$id.symbol_tv);
        this.f44975c = rVar.b(R$id.iv_close);
        this.f44976d = (ProgressButton) rVar.b(R$id.confirm_btn);
        this.f44979g = (TextView) rVar.b(R$id.id_lever_select_available_margin);
        this.f44980h = (TextView) rVar.b(R$id.id_lever_select_duo);
        this.f44981i = (TextView) rVar.b(R$id.id_lever_select_kong);
        this.f44977e = rVar.b(R$id.high_lever_hint_parent);
        this.f44978f = rVar.b(R$id.confirm_btn_space);
        this.f44977e.post(new u2(this));
        rVar.b(R$id.iv_select_level_guide).setOnClickListener(new z2(this));
        this.f44998z = rVar.b(R$id.dialog_contract_content_root);
        this.f44982j = (EditText) rVar.b(R$id.input_et);
        this.f44996x = (ImageView) rVar.b(R$id.trade_add_iv);
        this.f44997y = (ImageView) rVar.b(R$id.trade_reduce_iv);
        this.f44995w = (CustomBoardView) rVar.b(R$id.boardView);
        this.f44983k = (LeverDialogSeekBar) rVar.b(R$id.contract_seekbar_new);
        this.G = (TextView) rVar.b(R$id.tv_margin_level_info);
        if (this.F) {
            rVar.b(R$id.lever_select_viewgroup).setVisibility(8);
        }
    }

    public boolean isTransparent() {
        return false;
    }

    public void ni(String str) {
        h hVar = this.f44992t;
        if (hVar == null || !hVar.R0(this, str)) {
            l9.a.a().K(this.f44985m, str).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new e(str));
        }
    }

    public String o0() {
        return this.f44985m;
    }

    public void oi() {
        h hVar = this.f44992t;
        if (hVar != null) {
            hVar.P0(this.f44988p);
        }
        this.f44976d.a();
        dismiss();
    }

    public void onBackPressed() {
        CustomBoardView customBoardView = this.f44995w;
        if (customBoardView == null || !customBoardView.isShown()) {
            super.onBackPressed();
        } else {
            this.f44995w.hideKeyboardLayout();
        }
    }

    public void onGlobalLayout() {
        if (this.f44983k != null && this.J != this.f44998z.getHeight()) {
            this.J = this.f44998z.getHeight();
            this.f44983k.correctOffsetWhenContainerOnScrolling();
        }
    }

    public void onPause() {
        ProgressButton progressButton = this.f44976d;
        if (progressButton != null) {
            progressButton.a();
        }
        super.onPause();
    }

    public void onResume() {
        CustomBoardView customBoardView;
        super.onResume();
        if (this.f44982j != null && (customBoardView = this.f44995w) != null && customBoardView.isShown()) {
            this.f44982j.requestFocus();
        }
    }

    public final void pi() {
        String trim = this.f44982j.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            this.C = 0;
            this.f44982j.setText(String.valueOf(0));
            EditText editText = this.f44982j;
            editText.setSelection(editText.getText().length());
        } else {
            try {
                this.C = Integer.parseInt(trim);
                if (Xh(trim)) {
                    this.f44982j.setText(String.valueOf(this.C));
                    EditText editText2 = this.f44982j;
                    editText2.setSelection(editText2.getText().length());
                }
            } catch (Throwable unused) {
            }
        }
        ri(this.C, true);
    }

    public final void qi() {
        int i11;
        int i12;
        boolean z11;
        if (!this.F) {
            String str = this.f44985m;
            int i13 = g.f45008a[this.f44990r.ordinal()];
            if (i13 == 1) {
                str = this.f44986n;
            } else if (i13 == 2) {
                str = this.f44986n;
            }
            LevelAvailableMarginInfo levelAvailableMarginInfo = null;
            String str2 = this.H;
            if (str2 != null) {
                levelAvailableMarginInfo = new LevelAvailableMarginInfo();
                levelAvailableMarginInfo.setLevel(this.f44988p);
                levelAvailableMarginInfo.setAvailableMargin(this.H);
            } else {
                List<LevelAvailableMarginInfo> b11 = uc.b.b(this.f44990r, str, this.f44991s);
                if (b11 != null) {
                    Iterator<LevelAvailableMarginInfo> it2 = b11.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        LevelAvailableMarginInfo next = it2.next();
                        if (next.getLevel().equalsIgnoreCase(this.f44988p)) {
                            levelAvailableMarginInfo = next;
                            str2 = next.getAvailableMargin();
                            break;
                        }
                    }
                }
                str2 = "--";
            }
            String str3 = this.f44985m;
            int i14 = g.f45008a[this.f44990r.ordinal()];
            if (i14 == 1) {
                i12 = us.i.a(this.f44985m);
                i11 = us.i.u(this.f44985m);
            } else if (i14 != 2) {
                i12 = ej.f.n(this.f44985m);
                i11 = ej.f.j(this.f44985m);
            } else {
                i11 = LinearSwapCurrencyInfoController.l().o(this.f44986n, 2);
                str3 = StringUtils.i("usdt");
                i12 = LinearSwapCurrencyInfoController.l().e(this.f44986n, 2);
            }
            BigDecimal bigDecimal = BigDecimal.ZERO;
            if (!"--".equalsIgnoreCase(str2)) {
                bigDecimal = m.a(str2);
                str2 = m.q(bigDecimal, i11);
                z11 = true;
            } else {
                z11 = false;
            }
            this.f44979g.setText(str2 + " " + str3);
            if (z11) {
                if (this.f44992t != null) {
                    String[] strArr = new String[2];
                    if (bigDecimal.compareTo(BigDecimal.ZERO) < 0) {
                        strArr[0] = m.m("0", i12);
                        strArr[1] = m.m("0", i12);
                    } else {
                        strArr = this.f44992t.Q0(this.f44988p, levelAvailableMarginInfo);
                    }
                    if (a7.e.E(this.f44990r)) {
                        this.f44980h.setText(strArr[0] + " " + this.f44985m);
                        this.f44981i.setText(strArr[1] + " " + this.f44985m);
                    } else if (a7.e.G(this.f44990r)) {
                        TextView textView = this.f44980h;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(strArr[0]);
                        sb2.append(" ");
                        Locale locale = Locale.US;
                        sb2.append("usdt".toUpperCase(locale));
                        textView.setText(sb2.toString());
                        this.f44981i.setText(strArr[1] + " " + "usdt".toUpperCase(locale));
                    } else {
                        String string = getResources().getString(R$string.contract_order_dialog_count);
                        TextView textView2 = this.f44980h;
                        Locale locale2 = Locale.US;
                        textView2.setText(String.format(locale2, string, new Object[]{m.m(strArr[0], 0)}));
                        this.f44981i.setText(String.format(locale2, string, new Object[]{m.m(strArr[1], 0)}));
                    }
                }
            } else if (a7.e.E(this.f44990r)) {
                this.f44980h.setText("-- " + this.f44985m);
                this.f44981i.setText("-- " + this.f44985m);
            } else if (a7.e.G(this.f44990r)) {
                TextView textView3 = this.f44980h;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("-- ");
                Locale locale3 = Locale.US;
                sb3.append("usdt".toUpperCase(locale3));
                textView3.setText(sb3.toString());
                this.f44981i.setText("-- " + "usdt".toUpperCase(locale3));
            } else {
                String string2 = getResources().getString(R$string.contract_order_dialog_count);
                TextView textView4 = this.f44980h;
                Locale locale4 = Locale.US;
                textView4.setText(String.format(locale4, string2, new Object[]{"--"}));
                this.f44981i.setText(String.format(locale4, string2, new Object[]{"--"}));
            }
        }
    }

    public final void ri(int i11, boolean z11) {
        i6.i.b().h(this.I);
        boolean z12 = false;
        if (!this.E) {
            i6.i.b().g(this.I, z11 ? 200 : 0);
        }
        yi(this.C + "X");
        ProgressButton progressButton = this.f44976d;
        if (this.C > 0) {
            z12 = true;
        }
        progressButton.setEnabled(z12);
        this.f44988p = String.valueOf(i11);
        if (this.f44983k.getProgress() != i11) {
            this.f44983k.setProgress((float) i11);
        }
        qi();
    }

    public void setTradeType(TradeType tradeType) {
        this.f44990r = tradeType;
    }

    public void si(String str) {
        this.f44986n = str;
    }

    public void tc(List<String> list) {
        this.f44984l = list;
        if (list != null && list.size() > 0) {
            this.A = Float.parseFloat(this.f44984l.get(0));
            List<String> list2 = this.f44984l;
            this.B = Float.parseFloat(list2.get(list2.size() - 1));
            if (this.f44983k != null) {
                ai();
            }
        }
    }

    public void ti(String str) {
        List<String> list = this.f44984l;
        if (list != null) {
            try {
                if (list.indexOf(str) >= 0) {
                    this.C = Integer.parseInt(str);
                } else {
                    this.C = Integer.parseInt(this.f44984l.get(0));
                }
                if (this.f44982j != null) {
                    ri(this.C, false);
                    this.f44982j.setText(String.valueOf(this.C));
                    EditText editText = this.f44982j;
                    editText.setSelection(editText.getText().length());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void ui(boolean z11) {
        this.F = z11;
    }

    public void vi(h hVar) {
        this.f44992t = hVar;
    }

    public void wi(int i11) {
        this.f44991s = i11;
    }

    public void xi(String str) {
        this.f44987o = str;
    }

    public final void yi(String str) {
        if (this.f44987o != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f44987o);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (str != null) {
                spannableStringBuilder2.append(str);
            }
            this.f44974b.setText(spannableStringBuilder.append(" ").append(spannableStringBuilder2));
        }
    }

    public void zi(String str) {
        this.f44989q = str;
    }
}
