package com.huobi.otc.ui;

import android.content.DialogInterface;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$anim;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.OtcOrderBean;
import com.huobi.otc.bean.OtcOrderDetailInfo;
import com.huobi.otc.persenter.OtcChatPresenter;
import com.huobi.otc.widget.AvatarImageView;
import com.huobi.otc.widget.IndicatorPotView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import ky.j;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import sp.i0;
import sp.j0;
import sp.k0;
import sp.l0;
import sp.m0;
import sp.n0;
import sp.o0;
import sp.p0;
import sp.q0;
import sp.r0;
import sp.s0;
import sp.t0;
import sp.u0;

public class OtcChatActivity extends BaseActivity<OtcChatPresenter, OtcChatPresenter.i> implements OtcChatPresenter.i {
    public NumberFormat A = new DecimalFormat("00");
    public boolean B = false;

    /* renamed from: b  reason: collision with root package name */
    public AvatarImageView f79382b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f79383c;

    /* renamed from: d  reason: collision with root package name */
    public IndicatorPotView f79384d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f79385e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f79386f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f79387g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f79388h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f79389i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f79390j;

    /* renamed from: k  reason: collision with root package name */
    public View f79391k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f79392l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f79393m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f79394n;

    /* renamed from: o  reason: collision with root package name */
    public RecyclerView f79395o;

    /* renamed from: p  reason: collision with root package name */
    public SmartRefreshLayout f79396p;

    /* renamed from: q  reason: collision with root package name */
    public SmartRefreshHeader f79397q;

    /* renamed from: r  reason: collision with root package name */
    public LoadingLayout f79398r;

    /* renamed from: s  reason: collision with root package name */
    public EditText f79399s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f79400t;

    /* renamed from: u  reason: collision with root package name */
    public Subscription f79401u;

    /* renamed from: v  reason: collision with root package name */
    public long f79402v;

    /* renamed from: w  reason: collision with root package name */
    public InputMethodManager f79403w;

    /* renamed from: x  reason: collision with root package name */
    public RelativeLayout f79404x;

    /* renamed from: y  reason: collision with root package name */
    public RelativeLayout f79405y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f79406z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ((OtcChatPresenter) OtcChatActivity.this.getPresenter()).s0(OtcChatActivity.this.f79399s.getText().toString());
            OtcChatActivity.this.f79399s.setText("");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements ny.d {
        public b() {
        }

        public void P8(j jVar) {
        }

        public void bf(j jVar) {
            ((OtcChatPresenter) OtcChatActivity.this.getPresenter()).p0(true);
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
            OtcChatActivity.this.f79406z.setEnabled(editable != null && editable.length() > 0);
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class d extends BaseSubscriber<Long> {
        public d() {
        }

        public void onNext(Long l11) {
            if (l11.longValue() == 0) {
                OtcChatActivity.this.f79401u.unsubscribe();
                ((OtcChatPresenter) OtcChatActivity.this.getPresenter()).q0();
                OtcChatActivity.this.f79392l.setVisibility(4);
            }
            String valueOf = String.valueOf(OtcChatActivity.this.A.format(l11.longValue() / 60));
            String valueOf2 = String.valueOf(OtcChatActivity.this.A.format(l11.longValue() % 60));
            OtcChatActivity.this.f79392l.setText(String.format(OtcChatActivity.this.getResources().getString(R$string.otc_chat_countdown), new Object[]{valueOf, valueOf2}));
        }
    }

    public static RectF Bh(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + view.getWidth()), (float) (iArr[1] + view.getHeight()));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Gh(View view) {
        if (this.f79405y.isShown()) {
            Qh(getResources().getString(R$string.otc_chat_close_tip));
        } else {
            finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hh() {
        ((OtcChatPresenter) getPresenter()).j0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ih(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        if (i14 < i18) {
            this.f79395o.postDelayed(new k0(this), 100);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Jh(View view) {
        OtcModuleConfig.b().K(this, Long.valueOf(this.f79402v));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Kh(View view) {
        ((OtcChatPresenter) getPresenter()).p0(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Lh(View view, boolean z11) {
        if (z11) {
            Drawable drawable = ContextCompat.getDrawable(this, R$drawable.otc_chating);
            this.f79389i.setVisibility(8);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.f79400t.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            this.f79389i.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f79396p.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, getResources().getDimensionPixelOffset(R$dimen.dimen_55));
            this.f79396p.setLayoutParams(layoutParams);
            ((OtcChatPresenter) getPresenter()).j0();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Mh(DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        finish();
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Nh(DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.f79405y.isShown()) {
            Qh(getResources().getString(R$string.otc_chat_close_tip));
        } else {
            finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        Drawable drawable;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f79396p.getLayoutParams();
        if (this.f79389i.getVisibility() == 8) {
            drawable = ContextCompat.getDrawable(this, R$drawable.otc_keyboard);
            this.f79389i.setVisibility(0);
            this.f79403w.hideSoftInputFromWindow(this.f79399s.getWindowToken(), 0);
            this.f79399s.clearFocus();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, getResources().getDimensionPixelOffset(R$dimen.dimen_170));
        } else {
            drawable = ContextCompat.getDrawable(this, R$drawable.otc_chating);
            this.f79389i.setVisibility(8);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, getResources().getDimensionPixelOffset(R$dimen.dimen_55));
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.f79400t.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.f79396p.setLayoutParams(layoutParams);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        ((OtcChatPresenter) getPresenter()).c0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        ((OtcChatPresenter) getPresenter()).n0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Ch */
    public OtcChatPresenter createPresenter() {
        return new OtcChatPresenter();
    }

    /* renamed from: Dh */
    public OtcChatPresenter.i getUI() {
        return this;
    }

    public final void Eh() {
        this.f79399s.addTextChangedListener(new c());
        this.f79399s.setOnFocusChangeListener(new u0(this));
    }

    public void F4(boolean z11) {
        int i11;
        if (z11) {
            i11 = getResources().getColor(R$color.otc_avatar_on_line_color);
        } else {
            i11 = getResources().getColor(R$color.otc_avatar_off_line_color);
        }
        this.f79384d.setCenterColor(i11);
    }

    public void Fh(Window window) {
        if (window != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            window.setLayout(displayMetrics.widthPixels, window.getAttributes().height);
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 48;
            window.setAttributes(attributes);
        }
    }

    public void H3(String str, OtcOrderDetailInfo otcOrderDetailInfo, int i11) {
        int i12;
        int i13;
        OtcOrderBean otcOrder = otcOrderDetailInfo.getOtcOrder();
        up.d.b(this.f79393m, va.b.m(otcOrder.getCurrency()), m.h0(otcOrder.getAmount()));
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.CANADA);
        numberInstance.setRoundingMode(RoundingMode.FLOOR);
        numberInstance.setMaximumFractionDigits(10);
        String format = numberInstance.format(m.a(otcOrder.getAmount()));
        this.f79393m.setText(String.format("%s %s", new Object[]{va.b.m(otcOrder.getCurrency()), format}));
        this.f79383c.setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.f79382b.setText(str.substring(0, 1));
            AvatarImageView avatarImageView = this.f79382b;
            if (i11 != 3) {
                i12 = getResources().getColor(R$color.baseColorMajorTheme100);
            } else {
                i12 = getResources().getColor(R$color.otc_out_button_normal_color);
            }
            avatarImageView.setStartColor(i12);
            AvatarImageView avatarImageView2 = this.f79382b;
            if (i11 != 3) {
                i13 = getResources().getColor(R$color.baseColorMajorTheme100);
            } else {
                i13 = getResources().getColor(R$color.otc_out_button_normal_color);
            }
            avatarImageView2.setEndColor(i13);
        }
        Ph(i11);
        this.f79402v = otcOrderDetailInfo.getOtherInfo().getUid();
        Rd(otcOrder);
    }

    public final void Ph(int i11) {
        if (i11 == 2) {
            this.f79385e.setImageResource(R$drawable.otc_market_v_icon);
        } else if (i11 != 3) {
            this.f79385e.setImageResource(0);
        } else {
            this.f79385e.setImageResource(R$drawable.otc_market_crown_icon);
        }
    }

    public void Q2(boolean z11) {
        if (z11 && !this.f79405y.isShown()) {
            this.f79405y.setVisibility(0);
        } else if (!z11 && this.f79405y.isShown()) {
            this.f79405y.setVisibility(8);
        }
    }

    public final void Qh(String str) {
        new AlertDialog.a(this).setMessage((CharSequence) str).setPositiveButton(R$string.otc_chat_confirm, (DialogInterface.OnClickListener) new i0(this)).setNegativeButton(R$string.otc_chat_cancel, (DialogInterface.OnClickListener) m0.f26047b).create().show();
    }

    public void Rd(OtcOrderBean otcOrderBean) {
        int status = otcOrderBean.getStatus();
        if (status == 0) {
            this.f79394n.setText(getResources().getString(R$string.otc_order_status_unpay));
            this.f79392l.setVisibility(0);
            Rh(otcOrderBean);
        } else if (status == 1) {
            if (otcOrderBean.isSeller()) {
                this.f79394n.setText(getResources().getString(R$string.otc_order_status_sell_paid));
            } else {
                this.f79394n.setText(getResources().getString(R$string.otc_order_status_buy_paid));
            }
            this.f79392l.setVisibility(4);
        } else if (status == 2) {
            this.f79394n.setText(getResources().getString(R$string.otc_order_status_cancel));
            this.f79392l.setVisibility(4);
        } else if (status == 3) {
            this.f79394n.setText(getResources().getString(R$string.otc_order_status_finished));
            this.f79392l.setVisibility(4);
        } else if (status == 4) {
            this.f79394n.setText(getResources().getString(R$string.otc_order_status_appeal));
            this.f79392l.setVisibility(4);
        } else if (status == 100) {
            this.f79394n.setText(getResources().getString(R$string.quote_expired));
            this.f79392l.setVisibility(4);
        }
    }

    public final void Rh(OtcOrderBean otcOrderBean) {
        int payTerm = (int) (((long) (otcOrderBean.getPayTerm() * 60)) - ((otcOrderBean.getNow() - otcOrderBean.getGmtCreate()) / 1000));
        Subscription subscription = this.f79401u;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f79401u = null;
        }
        if (payTerm <= 0) {
            this.f79392l.setVisibility(4);
        } else {
            this.f79401u = Observable.interval(0, 1, TimeUnit.SECONDS).take(payTerm + 1).map(new l0(payTerm)).observeOn(AndroidSchedulers.mainThread()).subscribe(new d());
        }
    }

    public void W2() {
        this.f79389i.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f79396p.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, getResources().getDimensionPixelOffset(R$dimen.dimen_55));
        this.f79396p.setLayoutParams(layoutParams);
    }

    public void X0() {
        if (this.f79396p.M()) {
            this.f79396p.finishRefresh();
        }
    }

    public RecyclerView Y0() {
        return this.f79395o;
    }

    public void addEvent() {
        this.f79391k.setClickable(true);
        this.f79391k.setOnClickListener(new r0(this));
        this.f79386f.setClickable(true);
        this.f79386f.setOnClickListener(new s0(this));
        this.f79400t.setClickable(true);
        this.f79400t.setOnClickListener(new p0(this));
        this.f79387g.setClickable(true);
        this.f79387g.setOnClickListener(new n0(this));
        this.f79388h.setClickable(true);
        this.f79388h.setOnClickListener(new q0(this));
        this.f79395o.addOnLayoutChangeListener(new j0(this));
        Eh();
        initRefreshLayout();
        this.f79390j.setClickable(true);
        this.f79390j.setOnClickListener(new t0(this));
        this.f79398r.setOnRetryClickListener(new o0(this));
        this.f79406z.setOnClickListener(new a());
    }

    public boolean canFullScreen() {
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean contains = Bh(this.f79395o).contains(motionEvent.getRawX(), motionEvent.getRawY());
        this.B = contains;
        if (contains) {
            this.f79403w.hideSoftInputFromWindow(this.f79399s.getWindowToken(), 0);
            this.f79399s.clearFocus();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public LoadingLayout f6() {
        return this.f79398r;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R$anim.activity_anim_exit_from_bottom);
    }

    public int getContentView() {
        return R$layout.activity_otc_chat;
    }

    public final void initRefreshLayout() {
        this.f79396p.g(false);
        this.f79396p.e0(new b());
        this.f79397q = new SmartRefreshHeader(this);
        this.f79397q.b(DateTimeUtils.h(DateTimeUtils.v(), "MM-dd HH:mm:ss"));
        this.f79396p.j0(this.f79397q);
    }

    public void initView() {
        Fh(getWindow());
        this.f79382b = (AvatarImageView) this.viewFinder.b(R$id.otc_chat_dealer_logo);
        this.f79383c = (TextView) this.viewFinder.b(R$id.otc_chat_dealer_name);
        this.f79385e = (ImageView) this.viewFinder.b(R$id.otc_chat_dealer_sign);
        this.f79386f = (TextView) this.viewFinder.b(R$id.otc_chat_close);
        this.f79392l = (TextView) this.viewFinder.b(R$id.otc_chat_countdown);
        this.f79393m = (TextView) this.viewFinder.b(R$id.otc_chat_amount);
        this.f79395o = (RecyclerView) this.viewFinder.b(R$id.otc_chat_content_rv);
        this.f79396p = (SmartRefreshLayout) this.viewFinder.b(R$id.otc_chat_refresh_layout);
        this.f79399s = (EditText) this.viewFinder.b(R$id.otc_chat_input);
        this.f79394n = (TextView) this.viewFinder.b(R$id.otc_chat_order_status);
        this.f79400t = (TextView) this.viewFinder.b(R$id.otc_chat_input_image);
        this.f79384d = (IndicatorPotView) this.viewFinder.b(R$id.otc_chat_dealer_indicator);
        this.f79390j = (LinearLayout) this.viewFinder.b(R$id.otc_chat_dealer_layout);
        this.f79389i = (LinearLayout) this.viewFinder.b(R$id.otc_chat_photo_layout);
        this.f79391k = this.viewFinder.b(R$id.otc_chat_top_view);
        this.f79387g = (TextView) this.viewFinder.b(R$id.otc_chat_takephoto);
        this.f79388h = (TextView) this.viewFinder.b(R$id.otc_chat_photograph);
        this.f79398r = (LoadingLayout) this.viewFinder.b(R$id.otc_chat_loading_layout);
        this.f79405y = (RelativeLayout) this.viewFinder.b(R$id.tc_chat_layout_loading);
        this.f79406z = (TextView) this.viewFinder.b(R$id.send_txt);
        this.f79389i.setVisibility(8);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        linearLayoutManager.setOrientation(1);
        this.f79395o.setLayoutManager(linearLayoutManager);
        this.f79403w = (InputMethodManager) getSystemService("input_method");
        this.f79404x = (RelativeLayout) this.viewFinder.b(R$id.otc_chat_rl_root);
        this.f79399s.setInputType(131072);
        this.f79399s.setSingleLine(false);
        this.f79399s.setHorizontallyScrolling(false);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R$anim.activity_anim_enter_from_bottom, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.f79401u;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f79401u = null;
        }
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i11, keyEvent);
        }
        if (this.f79405y.isShown()) {
            Qh(getResources().getString(R$string.otc_chat_close_tip));
            return true;
        }
        finish();
        return true;
    }

    public SmartRefreshLayout t2() {
        return this.f79396p;
    }
}
