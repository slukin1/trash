package com.huobi.otc.ui;

import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.webview.HBWebView;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.dialog.bean.MenuItemBean;
import com.hbg.lib.widgets.dialog.dialogfragment.BottomMenuNewDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.otc.adapter.OtcChatMenuAdapter;
import com.huobi.otc.adapter.OtcChatMenuItemType;
import com.huobi.otc.bean.OtcChatContent;
import com.huobi.otc.bean.OtcChatContentList;
import com.huobi.otc.bean.OtcOrderBean;
import com.huobi.otc.bean.OtcOrderDetailInfo;
import com.huobi.otc.bean.OtcOrderTradeInstructionStatus;
import com.huobi.otc.bean.VoiceInfo;
import com.huobi.otc.enums.OtcReceiveOrderAdsType;
import com.huobi.otc.event.OtcActivityOrderEvent;
import com.huobi.otc.persenter.OtcLiteChatPresenter;
import com.huobi.otc.persenter.a;
import com.huobi.otc.widget.OtcActiveView;
import com.huobi.otc.widget.OtcConstraintLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jp.l;
import jp.v1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import sp.a2;
import sp.b2;
import sp.c2;
import sp.d1;
import sp.e1;
import sp.f1;
import sp.g1;
import sp.h1;
import sp.i1;
import sp.j1;
import sp.k1;
import sp.l1;
import sp.m1;
import sp.n1;
import sp.o1;
import sp.p1;
import sp.q1;
import sp.r1;
import sp.s1;
import sp.t1;
import sp.u1;
import sp.w1;
import sp.x1;
import sp.y1;
import sp.z1;
import vp.c1;

public class OtcLiteChatActivity extends BaseActivity<OtcLiteChatPresenter, OtcLiteChatPresenter.s> implements OtcLiteChatPresenter.s, EasyPermissions.PermissionCallbacks {

    /* renamed from: b0  reason: collision with root package name */
    public static List<OtcChatContentList.OtcChatDetailContent> f79461b0 = new ArrayList();
    public TextView A;
    public ImageView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public ConstraintLayout F;
    public LinearLayout G;
    public TextView H;
    public TextView I;
    public TextView J;
    public View K;
    public View L;
    public OtcOrderDetailInfo M;
    public int N = -1;
    public String O;
    public boolean P = true;
    public BottomMenuNewDialogFragment Q = null;
    public MenuItemBean.a R = null;
    public int S = CellBase.GROUP_ID_END_USER;
    public VoiceInfo T;
    public OtcActiveView U;
    public HBDialogFragment V;
    public boolean W = false;
    public List<String> X = new ArrayList();
    public OtcChatContentList.OtcChatDetailContent Y;
    public HBDialogFragment Z;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f79462a0 = false;

    /* renamed from: b  reason: collision with root package name */
    public TextView f79463b;

    /* renamed from: c  reason: collision with root package name */
    public GridView f79464c;

    /* renamed from: d  reason: collision with root package name */
    public OtcChatMenuAdapter f79465d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f79466e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f79467f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f79468g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f79469h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f79470i;

    /* renamed from: j  reason: collision with root package name */
    public SmartRefreshLayout f79471j;

    /* renamed from: k  reason: collision with root package name */
    public SmartRefreshHeader f79472k;

    /* renamed from: l  reason: collision with root package name */
    public LoadingLayout f79473l;

    /* renamed from: m  reason: collision with root package name */
    public EditText f79474m;

    /* renamed from: n  reason: collision with root package name */
    public ImageView f79475n;

    /* renamed from: o  reason: collision with root package name */
    public Subscription f79476o;

    /* renamed from: p  reason: collision with root package name */
    public long f79477p;

    /* renamed from: q  reason: collision with root package name */
    public InputMethodManager f79478q;

    /* renamed from: r  reason: collision with root package name */
    public RelativeLayout f79479r;

    /* renamed from: s  reason: collision with root package name */
    public OtcConstraintLayout f79480s;

    /* renamed from: t  reason: collision with root package name */
    public RelativeLayout f79481t;

    /* renamed from: u  reason: collision with root package name */
    public ImageView f79482u;

    /* renamed from: v  reason: collision with root package name */
    public FrameLayout f79483v;

    /* renamed from: w  reason: collision with root package name */
    public Toolbar f79484w;

    /* renamed from: x  reason: collision with root package name */
    public c1 f79485x;

    /* renamed from: y  reason: collision with root package name */
    public NumberFormat f79486y = new DecimalFormat("00");

    /* renamed from: z  reason: collision with root package name */
    public LinearLayout f79487z;

    public class a implements HBWebView.d {
        public a() {
        }

        public void onError(int i11, String str) {
            OtcLiteChatActivity.this.Mi();
        }
    }

    public class b implements OtcConstraintLayout.a {
        public b() {
        }

        public void a(float f11, float f12) {
            if (OtcLiteChatActivity.this.f79464c.getVisibility() == 0) {
                OtcLiteChatActivity.this.f79464c.setVisibility(8);
            } else {
                OtcLiteChatActivity.this.f79478q.hideSoftInputFromWindow(OtcLiteChatActivity.this.f79474m.getWindowToken(), 0);
            }
        }
    }

    public class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 == 0) {
                if (OtcLiteChatActivity.this.P) {
                    boolean unused = OtcLiteChatActivity.this.P = false;
                }
                ((OtcLiteChatPresenter) OtcLiteChatActivity.this.getPresenter()).E0();
                ((OtcLiteChatPresenter) OtcLiteChatActivity.this.getPresenter()).I0();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            if (!OtcLiteChatActivity.this.P) {
                ((OtcLiteChatPresenter) OtcLiteChatActivity.this.getPresenter()).E0();
            }
            if (!recyclerView.canScrollVertically(1) || !recyclerView.canScrollVertically(-1)) {
                if (OtcLiteChatActivity.this.P) {
                    boolean unused = OtcLiteChatActivity.this.P = false;
                }
                ((OtcLiteChatPresenter) OtcLiteChatActivity.this.getPresenter()).E0();
                ((OtcLiteChatPresenter) OtcLiteChatActivity.this.getPresenter()).I0();
            }
        }
    }

    public class d implements ny.d {
        public d() {
        }

        public void P8(ky.j jVar) {
        }

        public void bf(ky.j jVar) {
            ((OtcLiteChatPresenter) OtcLiteChatActivity.this.getPresenter()).q1(true);
        }
    }

    public class e implements DialogUtils.b.f {
        public e() {
        }

        public void a(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            HBDialogFragment unused = OtcLiteChatActivity.this.Z = null;
            Intent g11 = OtcModuleConfig.b().g(OtcLiteChatActivity.this, "");
            g11.putExtra("from_otc_trade_set", true);
            OtcLiteChatActivity.this.startActivity(g11);
        }
    }

    public class f implements Animation.AnimationListener {
        public f() {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            OtcLiteChatActivity.this.Pi(true);
        }
    }

    public class g implements Animation.AnimationListener {
        public g() {
        }

        public void onAnimationEnd(Animation animation) {
            if (OtcLiteChatActivity.this.F != null) {
                OtcLiteChatActivity.this.F.setVisibility(8);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            OtcLiteChatActivity.this.Pi(false);
        }
    }

    public class h implements ValueAnimator.AnimatorUpdateListener {
        public h() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (OtcLiteChatActivity.this.f79473l != null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) OtcLiteChatActivity.this.f79473l.getLayoutParams();
                marginLayoutParams.topMargin = intValue;
                OtcLiteChatActivity.this.f79473l.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public class i extends BaseSubscriber<Long> {
        public i() {
        }

        public void onNext(Long l11) {
            if (l11.longValue() == 0) {
                OtcLiteChatActivity.this.f79476o.unsubscribe();
                ((OtcLiteChatPresenter) OtcLiteChatActivity.this.getPresenter()).r1(false);
                OtcLiteChatActivity.this.f79466e.setVisibility(4);
                OtcLiteChatActivity.this.f79468g.setTextColor(OtcLiteChatActivity.this.getResources().getColor(R$color.baseColorPrimaryText));
                OtcLiteChatActivity.this.f79469h.setImageResource(R$drawable.otc_payment_right_icon);
                OtcLiteChatActivity.this.f79468g.setText(R$string.otc_order_lite_detail_unpaid_time_out);
            }
            String str = String.valueOf(OtcLiteChatActivity.this.f79486y.format(l11.longValue() / 60)) + ":" + String.valueOf(OtcLiteChatActivity.this.f79486y.format(l11.longValue() % 60));
            if (OtcLiteChatActivity.this.N == 201) {
                OtcLiteChatActivity.this.f79466e.setText(String.format("%s %s", new Object[]{OtcLiteChatActivity.this.getString(R$string.n_otc_order_detail_auto_agree_countdown), str}));
                return;
            }
            OtcLiteChatActivity.this.f79466e.setText(OtcLiteChatActivity.this.getString(R$string.n_otc_payment_countdown) + " " + str);
        }
    }

    public class j implements OtcActiveView.c {
        public j() {
        }

        public void onClose(String str) {
            if (!TextUtils.isEmpty(str)) {
                BaseModuleConfig.a().k0(str);
            }
            OtcLiteChatActivity.this.Mi();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ai(DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        finish();
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Bi(DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Di(OtcOrderDetailInfo otcOrderDetailInfo, Void voidR) {
        v1.a().g(this, otcOrderDetailInfo.getOrder().getId(), false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ei(OtcOrderDetailInfo otcOrderDetailInfo, Void voidR) {
        OtcModuleConfig.a().d0(this, otcOrderDetailInfo.getOrder().getId(), "", "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Fi(OtcOrderDetailInfo otcOrderDetailInfo, Void voidR) {
        OtcModuleConfig.a().d0(this, otcOrderDetailInfo.getOrder().getId(), "", "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gi(OtcOrderDetailInfo otcOrderDetailInfo, Void voidR) {
        v1.a().g(this, otcOrderDetailInfo.getOrder().getId(), false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hi(OtcOrderDetailInfo otcOrderDetailInfo, Void voidR) {
        v1.a().g(this, otcOrderDetailInfo.getOrder().getId(), false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ii(HBDialogFragment hBDialogFragment) {
        this.V.dismiss();
        this.V = null;
        ((OtcLiteChatPresenter) getPresenter()).H0(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ji(HBDialogFragment hBDialogFragment) {
        this.V.dismiss();
        this.V = null;
        ((OtcLiteChatPresenter) getPresenter()).H0(true);
    }

    public static RectF ei(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + view.getWidth()), (float) (iArr[1] + view.getHeight()));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ki(View view) {
        if (this.f79481t.isShown()) {
            Qi(getResources().getString(R$string.n_otc_chat_sending_back));
        } else {
            finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        Ni();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void li(Void voidR) {
        this.f79464c.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ni(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ((OtcLiteChatPresenter) getPresenter()).s1();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void oi(AdapterView adapterView, View view, int i11, long j11) {
        if (j11 == ((long) OtcChatMenuItemType.camera.value)) {
            ((OtcLiteChatPresenter) getPresenter()).G0();
        } else if (j11 == ((long) OtcChatMenuItemType.photo.value)) {
            ((OtcLiteChatPresenter) getPresenter()).p1();
        } else if (j11 == ((long) OtcChatMenuItemType.voiceCall.value)) {
            ((OtcLiteChatPresenter) getPresenter()).X0(true);
        } else if (j11 == ((long) OtcChatMenuItemType.pdf.value)) {
            ((OtcLiteChatPresenter) getPresenter()).o1();
        } else if (j11 == ((long) OtcChatMenuItemType.transConfirm.value)) {
            DialogUtils.b0(this, getResources().getString(R$string.n_otc_use_tip), getResources().getString(R$string.n_otc_chat_mk_request_tip), "", getResources().getString(R$string.n_otc_new_otc_cancel), getResources().getString(R$string.n_otc_chat_mk_request_send), g1.f26018a, new f1(this));
        }
        SensorsDataAutoTrackHelper.trackListView(adapterView, view, i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void pi(Void voidR) {
        this.f79485x.s(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void qi(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        if (i14 < i18 && this.f79464c.getVisibility() == 8) {
            ((OtcLiteChatPresenter) getPresenter()).Y0();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ri(View view) {
        if (this.M != null) {
            ((OtcLiteChatPresenter) getPresenter()).q1(false);
        } else {
            ((OtcLiteChatPresenter) getPresenter()).r1(true);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void si(View view) {
        if (this.M != null) {
            v1.a().e(this, this.M.getOtcOrder().getId(), -1);
            finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ti(Void voidR) {
        OtcOrderDetailInfo otcOrderDetailInfo = this.M;
        if (otcOrderDetailInfo != null && otcOrderDetailInfo.getOtherInfo() != null) {
            OtcModuleConfig.b().K(this, Long.valueOf(this.M.getOtherInfo().getUid()));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ui(Void voidR) {
        this.L.setVisibility(8);
        String S0 = ((OtcLiteChatPresenter) getPresenter()).S0();
        if (!this.X.contains(S0)) {
            this.X.add(S0);
        }
        ((OtcLiteChatPresenter) getPresenter()).y1(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vi(Void voidR) {
        this.L.setVisibility(8);
        if (!f79461b0.contains(this.Y)) {
            f79461b0.add(this.Y);
        }
        ((OtcLiteChatPresenter) getPresenter()).y1(false);
        ((OtcLiteChatPresenter) getPresenter()).X0(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wi() {
        if (isAlive()) {
            this.f79464c.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xi(View view, boolean z11) {
        if (z11) {
            this.f79464c.setVisibility(8);
            ((OtcLiteChatPresenter) getPresenter()).Y0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean yi(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            return false;
        }
        if (TextUtils.isEmpty(this.f79474m.getText().toString().trim())) {
            HuobiToastUtil.m(getString(R$string.n_otc_chat_input_remind));
            return true;
        }
        ((OtcLiteChatPresenter) getPresenter()).B1(this.f79474m.getText().toString());
        this.f79474m.setText("");
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zi(a.j jVar, a.j jVar2, View view, MenuItemBean menuItemBean, int i11) {
        if (i11 == 0) {
            jVar.a();
        } else if (i11 == 1) {
            jVar2.a();
        }
        this.Q.dismiss();
    }

    public void Ae(boolean z11) {
        this.K.setVisibility(0);
        this.K.setBackgroundResource(z11 ? R$drawable.shape_ad_header_circle_bg : R$drawable.shape_ad_header_circle_off_bg);
    }

    public void H3(String str, OtcOrderDetailInfo otcOrderDetailInfo, int i11) {
        this.f79463b.setText(str);
        if (otcOrderDetailInfo != null) {
            this.M = otcOrderDetailInfo;
            if (otcOrderDetailInfo.getOrder() != null) {
                this.f79485x.F(this.M.getOrder().getId());
                if (!this.M.getOrder().isSeller()) {
                    this.f79485x.w(this);
                }
            }
            this.f79477p = otcOrderDetailInfo.getOtherInfo().getUid();
            OtcOrderBean otcOrder = otcOrderDetailInfo.getOtcOrder();
            if (otcOrder != null) {
                String j11 = l.j(otcOrder.getAmount(), m.U(otcOrder.getAmount()));
                this.f79467f.setText(String.format("%s %s", new Object[]{va.b.m(otcOrder.getCurrency()), j11}));
                this.E.setBackgroundResource(R$drawable.otc_ads_deposit_bg);
                cg(otcOrderDetailInfo);
            }
        }
    }

    public void Jg(boolean z11) {
        if (!z11 && this.Z == null) {
            ConfigPreferences.m("user_config", "com.c2c.unbindPhone.tips." + OtcModuleConfig.a().getUid() + "_" + ((OtcLiteChatPresenter) getPresenter()).S0(), "true");
            String string = getString(R$string.allow_access_dialog_title);
            String format = String.format(getResources().getString(R$string.n_desc_add_phone_number_for_appeal), new Object[]{((OtcLiteChatPresenter) getPresenter()).T0()});
            this.Z = DialogUtils.W(this, string, format, (String) null, "+" + getResources().getString(R$string.n_title_add_phone_number), true, new e());
        }
    }

    public void Ki(String str, String str2, long j11) {
        OtcLiteChatPresenter otcLiteChatPresenter = (OtcLiteChatPresenter) getPresenter();
        if (otcLiteChatPresenter != null) {
            otcLiteChatPresenter.n1(str, str2, j11);
        }
    }

    public void L9(List<Long> list) {
        List c11 = ((v9.a) this.f79470i.getAdapter()).c();
        if (c11 != null && !c11.isEmpty()) {
            for (int i11 = 0; i11 < c11.size(); i11++) {
                Object obj = c11.get(i11);
                if (obj instanceof OtcChatContent) {
                    OtcChatContentList.OtcChatDetailContent otcChatContent = ((OtcChatContent) obj).getOtcChatContent();
                    if (!((OtcLiteChatPresenter) getPresenter()).b1(otcChatContent)) {
                        Iterator<Long> it2 = list.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (it2.next().equals(Long.valueOf(otcChatContent.getId()))) {
                                    otcChatContent.setReadState(1);
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public final void Li(OtcOrderBean otcOrderBean) {
        if (this.N == 0 && this.F.getVisibility() == 8) {
            this.F.setVisibility(0);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
            translateAnimation.setDuration(270);
            translateAnimation.setInterpolator(new FastOutSlowInInterpolator());
            translateAnimation.setAnimationListener(new f());
            this.F.startAnimation(translateAnimation);
        } else if (this.N != 0 && this.F.getVisibility() == 0) {
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(240);
            translateAnimation2.setInterpolator(new FastOutSlowInInterpolator());
            translateAnimation2.setAnimationListener(new g());
            this.F.startAnimation(translateAnimation2);
        }
    }

    public final void Mi() {
        FrameLayout frameLayout;
        if (this.U != null && (frameLayout = this.f79483v) != null && frameLayout.getChildCount() > 1) {
            this.f79483v.removeView(this.U);
            this.U = null;
        }
    }

    public void Ni() {
        ((OtcLiteChatPresenter) getPresenter()).Y0();
        if (this.f79464c.getVisibility() == 0) {
            this.f79464c.setVisibility(8);
            this.f79474m.requestFocus();
            this.f79478q.showSoftInput(this.f79474m, 0);
            return;
        }
        this.f79478q.hideSoftInputFromWindow(this.f79474m.getWindowToken(), 0);
        this.f79464c.setVisibility(0);
    }

    public void Oi(String str, String str2, a.j jVar, a.j jVar2) {
        if (this.Q == null) {
            this.Q = new BottomMenuNewDialogFragment();
            this.R = new h1(this, jVar, jVar2);
            ArrayList arrayList = new ArrayList();
            MenuItemBean.MenuItemStyle menuItemStyle = MenuItemBean.MenuItemStyle.STRESS;
            arrayList.add(new MenuItemBean("", str, menuItemStyle, this.R));
            arrayList.add(new MenuItemBean("", str2, menuItemStyle, this.R));
            this.Q.vh(arrayList);
        }
        this.Q.show(getSupportFragmentManager(), "ContactListFragment");
    }

    public final void Pi(boolean z11) {
        int measuredHeight = this.F.getMeasuredHeight();
        int[] iArr = new int[2];
        iArr[0] = z11 ? 0 : measuredHeight;
        if (!z11) {
            measuredHeight = 0;
        }
        iArr[1] = measuredHeight;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        ofInt.setDuration(270);
        ofInt.setInterpolator(new FastOutSlowInInterpolator());
        ofInt.addUpdateListener(new h());
        ofInt.start();
    }

    public void Q2(boolean z11) {
        if (z11 && !this.f79481t.isShown()) {
            this.f79481t.setVisibility(0);
        } else if (!z11 && this.f79481t.isShown()) {
            this.f79481t.setVisibility(8);
        }
    }

    public final void Qi(String str) {
        new AlertDialog.a(this).setMessage((CharSequence) str).setPositiveButton(R$string.n_otc_chat_confirm, (DialogInterface.OnClickListener) new sp.c1(this)).setNegativeButton(R$string.n_otc_chat_cancel, (DialogInterface.OnClickListener) n1.f26056b).create().show();
    }

    public void R9(OtcChatContentList.OtcChatDetailContent otcChatDetailContent) {
        OtcOrderDetailInfo otcOrderDetailInfo;
        this.Y = otcChatDetailContent;
        if (!((OtcLiteChatPresenter) getPresenter()).c1() || this.X.contains(((OtcLiteChatPresenter) getPresenter()).S0()) || (otcOrderDetailInfo = this.M) == null) {
            this.L.setVisibility(8);
            return;
        }
        int status = otcOrderDetailInfo.getOtcOrder().getStatus();
        this.N = status;
        if (status == 2 || status == 3 || !this.f79465d.a(OtcChatMenuItemType.voiceCall.value) || f79461b0.contains(otcChatDetailContent)) {
            this.L.setVisibility(8);
        } else {
            this.L.setVisibility(0);
        }
    }

    public final void Ri(long j11) {
        Subscription subscription = this.f79476o;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f79476o = null;
        }
        if (j11 <= 0) {
            this.f79466e.setVisibility(4);
            this.f79468g.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
            this.f79469h.setImageResource(R$drawable.otc_payment_right_icon);
            this.f79468g.setText(R$string.otc_order_lite_detail_unpaid_time_out);
            return;
        }
        this.f79476o = Observable.interval(0, 1, TimeUnit.SECONDS).take((int) (1 + j11)).map(new u1(j11)).observeOn(AndroidSchedulers.mainThread()).subscribe(new i());
    }

    public void W2() {
        this.f79475n.setImageResource(R$drawable.otc_chat_more_icon);
        this.f79464c.setVisibility(8);
    }

    public void X0() {
        if (this.f79471j.M()) {
            this.f79471j.finishRefresh();
        }
    }

    public RecyclerView Y0() {
        return this.f79470i;
    }

    public void addEvent() {
        this.f79484w.setNavigationOnClickListener(new y1(this));
        Observable<Void> a11 = dw.a.a(this.f79482u);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new o1(this));
        this.f79475n.setOnClickListener(new w1(this));
        this.f79470i.addOnLayoutChangeListener(new a2(this));
        ji();
        initRefreshLayout();
        this.f79473l.setOnRetryClickListener(new sp.v1(this));
        this.E.setOnClickListener(new x1(this));
        dw.a.a(this.f79463b).throttleFirst(1, timeUnit).subscribe(new l1(this));
        dw.a.a(this.I).throttleFirst(1, timeUnit).subscribe(new m1(this));
        dw.a.a(this.J).throttleFirst(1, timeUnit).subscribe(new k1(this));
        dw.a.a(this.f79474m).throttleFirst(1, timeUnit).subscribe(new j1(this));
        this.f79464c.setOnItemClickListener(new b2(this));
    }

    public boolean canFullScreen() {
        return false;
    }

    public void cg(OtcOrderDetailInfo otcOrderDetailInfo) {
        OtcChatContentList.OtcChatDetailContent otcChatDetailContent;
        if (otcOrderDetailInfo != null && otcOrderDetailInfo.getOtcOrder() != null) {
            LinearLayout linearLayout = this.f79487z;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            OtcOrderBean otcOrder = otcOrderDetailInfo.getOtcOrder();
            this.N = otcOrder.getStatus();
            if (otcOrderDetailInfo.isInNegotiation()) {
                this.N = 201;
            }
            if (this.N != 0) {
                Observable<Void> a11 = dw.a.a(this.f79468g);
                TimeUnit timeUnit = TimeUnit.SECONDS;
                a11.throttleFirst(1, timeUnit).subscribe(new r1(this, otcOrderDetailInfo));
                dw.a.a(this.f79469h).throttleFirst(1, timeUnit).subscribe(new q1(this, otcOrderDetailInfo));
            } else if (otcOrderDetailInfo.getOtcOrder().isSeller()) {
                dw.a.a(this.f79468g).throttleFirst(1, TimeUnit.SECONDS).subscribe(new p1(this, otcOrderDetailInfo));
            } else {
                Observable<Void> a12 = dw.a.a(this.f79468g);
                TimeUnit timeUnit2 = TimeUnit.SECONDS;
                a12.throttleFirst(1, timeUnit2).subscribe(new s1(this, otcOrderDetailInfo));
                dw.a.a(this.f79469h).throttleFirst(1, timeUnit2).subscribe(new t1(this, otcOrderDetailInfo));
            }
            if (this.N == 0) {
                this.f79468g.setTextColor(getResources().getColor(R$color.baseColorMajorTheme100));
                this.f79469h.setImageResource(R$drawable.otc_chat_right_arrow_icon);
            } else {
                this.f79468g.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
                this.f79469h.setImageResource(R$drawable.otc_payment_right_icon);
            }
            HBDialogFragment hBDialogFragment = this.Z;
            if (!(hBDialogFragment == null || !hBDialogFragment.th() || this.N == 4)) {
                this.Z.dismiss();
                this.Z = null;
            }
            int i11 = this.N;
            boolean z11 = true;
            if (i11 == 0) {
                this.f79466e.setVisibility(0);
                Ri(otcOrder.getCancelCountDown());
                if (!otcOrder.isSeller()) {
                    this.f79468g.setText(getResources().getString(R$string.n_otc_lite_order_detail_go_pay));
                } else {
                    this.f79468g.setText(getResources().getString(R$string.n_otc_trade_order_status_not_pay_sell_show));
                }
                this.f79469h.setVisibility(0);
            } else if (i11 == 1) {
                this.f79466e.setVisibility(4);
                if (otcOrder.isSeller()) {
                    this.f79468g.setText(getResources().getString(R$string.n_otc_trade_order_status_pay_sell_show));
                } else {
                    this.f79468g.setText(getResources().getString(R$string.n_otc_trade_order_status_pay_buy_show));
                }
            } else if (i11 == 2) {
                this.f79468g.setText(getResources().getString(R$string.n_otc_trade_order_status_cancel));
                this.f79466e.setVisibility(4);
            } else if (i11 == 3) {
                this.f79468g.setText(getResources().getString(R$string.n_otc_trade_order_status_finshed));
                this.f79466e.setVisibility(4);
            } else if (i11 == 4) {
                this.f79466e.setVisibility(4);
                this.f79468g.setText(getResources().getString(R$string.n_otc_trade_order_status_appeal));
                if (!otcOrderDetailInfo.getAppeal().isCancle()) {
                    if (!TextUtils.equals(ConfigPreferences.d("user_config", "com.c2c.unbindPhone.tips." + OtcModuleConfig.a().getUid() + "_" + ((OtcLiteChatPresenter) getPresenter()).S0()), "true") && this.Z == null) {
                        ((OtcLiteChatPresenter) getPresenter()).F0();
                    } else {
                        return;
                    }
                }
            } else if (i11 == 100) {
                this.f79466e.setVisibility(4);
                this.f79468g.setText(getResources().getString(R$string.quote_expired));
            } else if (i11 != 201) {
                switch (i11) {
                    case 108:
                        this.f79466e.setVisibility(0);
                        Ri(otcOrder.getCancelCountDown());
                        this.f79468g.setText(getString(R$string.n_otc_await_receive_order));
                        if (otcOrderDetailInfo.isTaker()) {
                            this.f79487z.setVisibility(0);
                            this.A.setText(R$string.n_otc_await_accept_order_taker_chat_hint);
                            this.f79487z.setBackgroundResource(R$color.baseColorMajorTheme006);
                            this.B.setImageResource(R$drawable.noticebar_icon_conventional);
                            this.A.setTextColor(v1.b());
                            break;
                        }
                        break;
                    case 109:
                        this.f79466e.setVisibility(4);
                        this.f79468g.setText(getString(R$string.n_otc_receive_order_cancel));
                        break;
                    case 110:
                        this.f79466e.setVisibility(4);
                        this.f79468g.setText(getString(R$string.n_otc_receive_order_refuse));
                        break;
                }
            } else {
                this.f79468g.setText(getResources().getString(R$string.n_otc_order_detail_consult_ing));
                this.f79466e.setVisibility(0);
                Ri((long) otcOrder.getConsultCancelCountDown().intValue());
            }
            if (otcOrderDetailInfo.isTaker() && TextUtils.equals(otcOrder.getAcceptStatus(), OtcReceiveOrderAdsType.RECEIVE_ORDER.getValue()) && this.F != null) {
                Li(otcOrder);
            }
            if (this.S != this.N) {
                ((OtcLiteChatPresenter) getPresenter()).X0(false);
            }
            int i12 = this.N;
            this.S = i12;
            if (i12 != 0 || otcOrderDetailInfo.getOrderTag() == null || otcOrderDetailInfo.getOrderTag().getNegotiationStatus() == null || otcOrderDetailInfo.getOrderTag().getNegotiationStatus().intValue() != 1) {
                HBDialogFragment hBDialogFragment2 = this.V;
                if (hBDialogFragment2 != null && hBDialogFragment2.th()) {
                    this.V.dismiss();
                    this.V = null;
                }
            } else if (this.V == null) {
                this.V = DialogUtils.b0(this, getResources().getString(R$string.n_otc_chat_order_cancel_confirm_title), getResources().getString(R$string.n_otc_chat_order_cancel_confirm_subtitle), "", getResources().getString(R$string.points_transfer_reject), getResources().getString(R$string.btn_string_agree), new e1(this), new d1(this));
            }
            if (otcOrderDetailInfo.isTaker()) {
                boolean z12 = otcOrderDetailInfo.getTradeInstructionStatus() != null && otcOrderDetailInfo.getOtcOrder().getTradeMode() == 5 && otcOrderDetailInfo.getOtcOrder().getTradeType() == 0 && otcOrderDetailInfo.getOtcOrder().getStatus() == 0 && otcOrderDetailInfo.getTradeInstructionStatus().equals(OtcOrderTradeInstructionStatus.waitConfirm.value) && otcOrderDetailInfo.getOrderTag().getNegotiationStatus().intValue() != 1;
                if (z12 && !this.W) {
                    ViewGroup viewGroup = (ViewGroup) findViewById(R$id.fl_chat_root).getParent();
                    int i13 = R$id.ad_quick_edit_container;
                    FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(i13);
                    if (frameLayout == null) {
                        frameLayout = new FrameLayout(this);
                        frameLayout.setId(i13);
                        viewGroup.addView(frameLayout);
                    }
                    OtcModuleConfig.b().c(this, ((OtcLiteChatPresenter) getPresenter()).S0(), i13, "OtcOrderTransConfirmFlutterFragemnt");
                    frameLayout.setVisibility(0);
                    this.W = true;
                } else if (!z12 && this.W) {
                    ii(false);
                    this.W = false;
                }
            } else {
                if (((OtcLiteChatPresenter) getPresenter()).f79071s == null || otcOrderDetailInfo.getTradeInstructionStatus() == null || !((OtcLiteChatPresenter) getPresenter()).f79071s.getMerchantType().equals("BRAND") || otcOrderDetailInfo.getOtcOrder().getTradeMode() != 5 || otcOrderDetailInfo.getOtcOrder().getTradeType() != 1 || otcOrderDetailInfo.getOtcOrder().getStatus() != 0 || otcOrderDetailInfo.getTradeInstructionStatus().equals(OtcOrderTradeInstructionStatus.confirmed.value)) {
                    z11 = false;
                }
                this.f79465d.b(OtcChatMenuItemType.transConfirm.value, z11);
            }
            if (!this.X.contains(((OtcLiteChatPresenter) getPresenter()).S0()) && (otcChatDetailContent = this.Y) != null) {
                R9(otcChatDetailContent);
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean contains = ei(this.f79470i).contains(motionEvent.getRawX(), motionEvent.getRawY());
        this.f79462a0 = contains;
        if (contains) {
            this.f79478q.hideSoftInputFromWindow(this.f79474m.getWindowToken(), 0);
            this.f79474m.clearFocus();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public LoadingLayout f6() {
        return this.f79473l;
    }

    public void f8(boolean z11) {
        if (z11) {
            this.f79482u.setVisibility(0);
        } else {
            this.f79482u.setVisibility(4);
        }
    }

    /* renamed from: fi */
    public OtcLiteChatPresenter createPresenter() {
        return new OtcLiteChatPresenter();
    }

    public void finish() {
        super.finish();
        if (getPresenter() != null && ((OtcLiteChatPresenter) getPresenter()).d1()) {
            v1.a().g(this, ((OtcLiteChatPresenter) getPresenter()).S0(), false);
        }
    }

    public void g5(VoiceInfo voiceInfo, boolean z11) {
        this.T = voiceInfo;
        if (voiceInfo == null || !voiceInfo.isVoice() || TextUtils.isEmpty(voiceInfo.getReceiveTxUserid()) || voiceInfo.getSingleVoiceTime() <= 0 || voiceInfo.getTotalVoiceCount() <= 0) {
            this.f79465d.b(OtcChatMenuItemType.voiceCall.value, false);
            this.L.setVisibility(8);
            return;
        }
        this.f79465d.b(OtcChatMenuItemType.voiceCall.value, true);
        if (z11) {
            OtcModuleConfig.a().w(this, ((OtcLiteChatPresenter) getPresenter()).S0(), this.T);
            W2();
        }
    }

    public int getContentView() {
        return R$layout.activity_otc_lite_chat;
    }

    public String gi(String str) {
        String format = String.format("userAgent=%s&version=%s&deviceId=%s&locale=%s&appversion=%s&isnight=%s", new Object[]{StringUtils.b("M:huobiapp:phone:android"), StringUtils.b(String.valueOf(GlobalAppConfig.c())), StringUtils.b(PhoneUtils.e()), StringUtils.b(p.b()), StringUtils.b(String.valueOf(GlobalAppConfig.c())), StringUtils.b(String.valueOf(NightHelper.e().g() ? 1 : 0))});
        if (str.contains("?")) {
            return str + ContainerUtils.FIELD_DELIMITER + format;
        }
        return str + "?" + format;
    }

    /* renamed from: hi */
    public OtcLiteChatPresenter.s getUI() {
        return this;
    }

    public void ii(boolean z11) {
        Fragment m02 = getSupportFragmentManager().m0("OtcOrderTransConfirmFlutterFragemnt");
        if (m02 != null) {
            getSupportFragmentManager().q().s(m02).k();
        }
        findViewById(R$id.ad_quick_edit_container).setVisibility(8);
        if (z11) {
            ((OtcLiteChatPresenter) getPresenter()).r1(true);
        }
    }

    public final void initRefreshLayout() {
        this.f79471j.g(false);
        this.f79471j.e0(new d());
        this.f79472k = new SmartRefreshHeader(this);
        this.f79472k.b(DateTimeUtils.h(DateTimeUtils.v(), "MM-dd HH:mm:ss"));
        this.f79471j.j0(this.f79472k);
    }

    public void initView() {
        this.f79483v = (FrameLayout) this.viewFinder.b(R$id.fl_chat_root);
        this.f79484w = (Toolbar) this.viewFinder.b(R$id.toolbar);
        this.f79463b = (TextView) this.viewFinder.b(R$id.otc_chat_dealer_name);
        this.f79482u = (ImageView) this.viewFinder.b(R$id.otc_lite_order_call_img);
        this.f79466e = (TextView) this.viewFinder.b(R$id.otc_chat_countdown);
        this.f79467f = (TextView) this.viewFinder.b(R$id.otc_chat_amount);
        this.f79470i = (RecyclerView) this.viewFinder.b(R$id.otc_chat_content_rv);
        this.f79471j = (SmartRefreshLayout) this.viewFinder.b(R$id.otc_chat_refresh_layout);
        this.f79474m = (EditText) this.viewFinder.b(R$id.otc_chat_input);
        this.f79468g = (TextView) this.viewFinder.b(R$id.otc_chat_order_status);
        this.f79469h = (ImageView) this.viewFinder.b(R$id.iv_payment_status_arrow);
        this.f79475n = (ImageView) this.viewFinder.b(R$id.otc_chat_input_image);
        this.f79464c = (GridView) this.viewFinder.b(R$id.otc_chat_menus);
        this.f79473l = (LoadingLayout) this.viewFinder.b(R$id.otc_chat_loading_layout);
        this.f79481t = (RelativeLayout) this.viewFinder.b(R$id.tc_chat_layout_loading);
        this.f79487z = (LinearLayout) this.viewFinder.b(R$id.id_top_hint_ll);
        this.A = (TextView) this.viewFinder.b(R$id.id_top_hint_tv);
        this.B = (ImageView) this.viewFinder.b(R$id.id_top_hint_iv);
        this.C = (TextView) this.viewFinder.b(R$id.id_payed_title_tv);
        this.D = (TextView) this.viewFinder.b(R$id.id_payed_desc_tv);
        this.E = (TextView) this.viewFinder.b(R$id.id_to_pay_page_tv);
        this.F = (ConstraintLayout) this.viewFinder.b(R$id.id_payed_desc_root);
        this.G = (LinearLayout) this.viewFinder.b(R$id.otc_chat_top_tip_ll);
        this.H = (TextView) this.viewFinder.b(R$id.otc_chat_top_tip);
        this.K = this.viewFinder.b(R$id.view_online_status);
        this.L = this.viewFinder.b(R$id.ll_pop_root);
        this.I = (TextView) this.viewFinder.b(R$id.tv_pop_voice_cancel);
        this.J = (TextView) this.viewFinder.b(R$id.tv_pop_voice_call);
        this.f79464c.setVisibility(8);
        OtcChatMenuAdapter otcChatMenuAdapter = new OtcChatMenuAdapter();
        this.f79465d = otcChatMenuAdapter;
        this.f79464c.setAdapter(otcChatMenuAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        linearLayoutManager.setOrientation(1);
        this.f79470i.setLayoutManager(linearLayoutManager);
        this.f79478q = (InputMethodManager) getSystemService("input_method");
        this.f79479r = (RelativeLayout) this.viewFinder.b(R$id.otc_chat_rl_root);
        OtcConstraintLayout otcConstraintLayout = (OtcConstraintLayout) this.viewFinder.b(R$id.ocl_touch_view);
        this.f79480s = otcConstraintLayout;
        otcConstraintLayout.setOnTouchDownCallBack(new b());
        this.f79474m.setHorizontallyScrolling(true);
        this.f79474m.setGravity(16);
        this.f79474m.setSingleLine(true);
        this.f79474m.setMaxHeight(PixelUtils.a(100.0f));
        this.f79474m.setMinHeight(PixelUtils.a(40.0f));
        this.f79474m.setImeOptions(4);
        this.f79474m.setOnEditorActionListener(new c2(this));
        this.f79485x = new c1(this, this, getSupportFragmentManager());
        this.C.setText(getString(R$string.n_otc_chat_buyer_receive_wait_pay_remind_title));
        this.D.setText(getString(R$string.n_otc_chat_buyer_receive_wait_pay_remind_content));
        this.E.setText(getString(R$string.n_otc_chat_buyer_receive_wait_pay_remind_button));
        this.f79470i.addOnScrollListener(new c());
        setToolBar(this.f79484w, "", true);
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public final void ji() {
        this.f79474m.setOnFocusChangeListener(new z1(this));
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onActivityEvent(OtcActivityOrderEvent otcActivityOrderEvent) {
        FrameLayout frameLayout;
        if ((oa.a.g().b() instanceof OtcLiteChatActivity) && otcActivityOrderEvent != null && !TextUtils.isEmpty(otcActivityOrderEvent.getHbgContentUrl()) && (frameLayout = this.f79483v) != null && frameLayout.getChildCount() == 1) {
            this.U = new OtcActiveView(this);
            String hbgContentUrl = otcActivityOrderEvent.getHbgContentUrl();
            if (hbgContentUrl.indexOf("/") == 0) {
                hbgContentUrl = hbgContentUrl.substring(1);
            }
            this.U.setUrl(gi(BaseModuleConfig.a().k(hbgContentUrl)));
            this.U.setCallback(new j());
            this.U.setLoadErrorListener(new a());
            this.U.D();
            this.f79483v.addView(this.U, new ViewGroup.LayoutParams(-1, -1));
            this.f79478q.hideSoftInputFromWindow(this.f79474m.getWindowToken(), 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.M = (OtcOrderDetailInfo) getIntent().getSerializableExtra("otcOrder");
        String stringExtra = getIntent().getStringExtra("message");
        this.O = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            ((OtcLiteChatPresenter) getPresenter()).B1(this.O);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.f79476o;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f79476o = null;
        }
        try {
            SoftInputUtils.g(this, this.f79474m);
        } catch (Exception unused) {
        }
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i11, keyEvent);
        }
        if (this.f79481t.isShown()) {
            Qi(getResources().getString(R$string.n_otc_chat_sending_back));
            return true;
        }
        finish();
        return true;
    }

    public void onPause() {
        super.onPause();
        Mi();
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        OtcLiteChatPresenter otcLiteChatPresenter = (OtcLiteChatPresenter) getPresenter();
        if (otcLiteChatPresenter != null) {
            otcLiteChatPresenter.onPermissionsDenied(i11, list);
        }
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        OtcLiteChatPresenter otcLiteChatPresenter = (OtcLiteChatPresenter) getPresenter();
        if (otcLiteChatPresenter != null) {
            otcLiteChatPresenter.onPermissionsGranted(i11, list);
        }
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        EasyPermissions.onRequestPermissionsResult(i11, strArr, iArr, this);
    }

    public SmartRefreshLayout t2() {
        return this.f79471j;
    }

    public void tg(String str) {
        if (TextUtils.isEmpty(str)) {
            this.G.setVisibility(8);
        } else {
            this.G.setVisibility(0);
        }
        this.H.setText(str);
    }

    public void x5() {
        this.f79464c.postDelayed(new i1(this), 50);
    }

    public void zb() {
    }
}
