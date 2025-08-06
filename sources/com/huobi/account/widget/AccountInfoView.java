package com.huobi.account.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.CommunityData;
import com.hbg.lib.network.hbg.core.bean.MedalUserInfo;
import com.hbg.lib.network.hbg.core.bean.MyPrimeInfo;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.RedPoint.AbsRedPointNodeImp;
import com.huobi.account.bean.AccountKycInfo;
import com.huobi.coupon.bean.Coupon;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.a0;
import com.huobi.utils.k0;
import com.huobi.view.roundview.RoundTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rn.c;
import rx.Observable;
import sn.f;
import sn.w;
import tg.r;
import wg.b;
import wg.d;
import wg.e;
import wg.h;
import wg.i;
import wg.j;
import wg.k;
import wg.l;
import wg.m;
import wg.n;

public class AccountInfoView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public Activity f41874b;

    /* renamed from: c  reason: collision with root package name */
    public AccountKycInfo f41875c;

    /* renamed from: d  reason: collision with root package name */
    public NftHexagonView f41876d;

    /* renamed from: e  reason: collision with root package name */
    public LottieAnimationView f41877e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f41878f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f41879g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f41880h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f41881i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f41882j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f41883k;

    /* renamed from: l  reason: collision with root package name */
    public View f41884l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f41885m;

    /* renamed from: n  reason: collision with root package name */
    public ImageView f41886n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f41887o;

    /* renamed from: p  reason: collision with root package name */
    public ViewGroup f41888p;

    /* renamed from: q  reason: collision with root package name */
    public ViewGroup f41889q;

    /* renamed from: r  reason: collision with root package name */
    public ImageView f41890r;

    /* renamed from: s  reason: collision with root package name */
    public ImageView f41891s;

    /* renamed from: t  reason: collision with root package name */
    public ImageView f41892t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f41893u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f41894v;

    /* renamed from: w  reason: collision with root package name */
    public RoundTextView f41895w;

    /* renamed from: x  reason: collision with root package name */
    public String f41896x;

    /* renamed from: y  reason: collision with root package name */
    public LinearLayout f41897y;

    /* renamed from: z  reason: collision with root package name */
    public AbsRedPointNodeImp f41898z;

    public class a extends AbsRedPointNodeImp {
        public a() {
        }

        public boolean a() {
            return AccountInfoView.this.f41895w.getVisibility() == 0;
        }

        public int b() {
            return 0;
        }
    }

    public AccountInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void C(View view) {
        if (view.getId() == R.id.dynamic_container) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "moment");
            g.i("Element_Me_click", hashMap);
            b2.a.d().a("/content/PersonalCenter").withString("uidUnique", r.x().K()).navigation();
        } else if (view.getId() == R.id.focus_container) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("type", "follows");
            g.i("Element_Me_click", hashMap2);
            b2.a.d().a("/content/UserFollowList").withString("uidUnique", r.x().K()).withString("isSelf", "1").navigation();
        } else if (view.getId() == R.id.fans_container) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("type", "fans");
            g.i("Element_Me_click", hashMap3);
            b2.a.d().a("/content/FansFollowList").withString("uidUnique", r.x().K()).withString("isSelf", "1").navigation();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void E(View view) {
        g.i("achievement_Me_click", (HashMap) null);
        HBBaseWebActivity.showWebView(getContext(), BaseModuleConfig.a().k("welfare/?taskType=MedalWall"), "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(Throwable th2) {
        this.f41877e.setVisibility(8);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void G(UnifyKycInfo unifyKycInfo, View view) {
        String entranceUrl = unifyKycInfo.getEntranceUrl();
        if (!entranceUrl.startsWith("http") && !entranceUrl.startsWith("holigeit")) {
            entranceUrl = a0.j() + entranceUrl;
        }
        zn.a.d().v(Uri.parse(entranceUrl)).a().c();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void setKycAuthProcessing(boolean z11) {
        this.f41889q.setBackgroundResource(R.drawable.kyc_status_bg);
        if (z11) {
            this.f41890r.setImageResource(R.drawable.icon_accout_kyc_process);
            this.f41890r.setVisibility(0);
        } else {
            this.f41890r.setVisibility(8);
        }
        this.f41893u.setTextColor(getResources().getColor(R.color.baseColorPrimaryText070));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(Void voidR) {
        H();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(Void voidR) {
        H();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(Void voidR) {
        I();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(Void voidR) {
        c.i().d(this.f41874b, o(k0.a(getContext())));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(Void voidR) {
        if (r.x().F0()) {
            String J = r.x().J();
            ((ClipboardManager) this.f41874b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(J, J));
            HuobiToastUtil.t(this.f41874b, R.string.account_uic_already_copy);
            return;
        }
        c.i().d(this.f41874b, (kn.a) null);
    }

    public final void H() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "image");
        g.i("Element_Me_click", hashMap);
        if (r.x().F0()) {
            b2.a.d().a("/content/PersonalCenter").withString("uidUnique", r.x().K()).navigation();
        } else if (this.f41874b != null) {
            c.i().d(this.f41874b, o(k0.a(getContext())));
        }
    }

    public final void I() {
        if (r.x().F0()) {
            if (!r.x().X()) {
                AccountKycInfo accountKycInfo = this.f41875c;
                if (accountKycInfo == null) {
                    getContext().startActivity(f.q(getContext(), Coupon.SPOT, "1"));
                    p();
                } else if (accountKycInfo.j()) {
                    b2.a.d().a("/account/institutionKyc").navigation();
                } else {
                    getContext().startActivity(f.q(getContext(), Coupon.SPOT, "1"));
                    p();
                }
            } else {
                return;
            }
        } else if (this.f41874b != null) {
            c.i().d(this.f41874b, o(k0.a(getContext())));
        }
        g.i("peason_identity_general_click", (HashMap) null);
        g.i("Authentication_Me_click", (HashMap) null);
    }

    public final void J() {
        this.f41889q.setBackgroundResource(R.drawable.kyc_status_bg);
        this.f41890r.setVisibility(8);
        this.f41893u.setTextColor(getResources().getColor(R.color.kyc_auth_fail));
    }

    public final void K() {
        this.f41889q.setBackgroundResource(R.drawable.kyc_status_bg);
        this.f41890r.setVisibility(8);
        this.f41893u.setTextColor(getResources().getColor(R.color.baseColorPrimaryText070));
    }

    public void L(MedalUserInfo medalUserInfo) {
        if (medalUserInfo == null || medalUserInfo.getMedalWearList() == null || medalUserInfo.getMedalWearList().isEmpty()) {
            this.f41897y.setVisibility(8);
            return;
        }
        this.f41897y.setVisibility(0);
        this.f41897y.removeAllViews();
        for (int i11 = 0; i11 < Math.min(medalUserInfo.getMedalWearList().size(), 3); i11++) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_account_achievement, this.f41897y, false);
            this.f41897y.addView(inflate);
            f6.c.a().e((ImageView) inflate.findViewById(R.id.img), medalUserInfo.getMedalWearList().get(i11).getImageUrl());
        }
    }

    public final void M() {
        String d11 = com.huobi.main.helper.f.c().d();
        if (TextUtils.isEmpty(d11) || !d11.startsWith("http")) {
            this.f41877e.cancelAnimation();
            this.f41877e.setVisibility(8);
            this.f41896x = null;
            AccountKycInfo accountKycInfo = this.f41875c;
            if (accountKycInfo == null || TextUtils.isEmpty(accountKycInfo.b())) {
                this.f41876d.g((String) null, false);
            } else {
                this.f41876d.g(this.f41875c.b(), false);
            }
        } else {
            this.f41876d.g(d11, true);
            String e11 = com.huobi.main.helper.f.c().e();
            if (!TextUtils.equals(e11, this.f41896x)) {
                this.f41896x = e11;
                if (!TextUtils.isEmpty(e11)) {
                    this.f41877e.setVisibility(0);
                    this.f41877e.setAnimationFromUrl(e11);
                    this.f41877e.setRepeatCount(-1);
                    this.f41877e.playAnimation();
                    return;
                }
                this.f41877e.cancelAnimation();
                this.f41877e.setVisibility(8);
            }
        }
    }

    public void N(CommunityData communityData) {
        String str;
        String str2;
        String str3 = "--";
        if (communityData != null) {
            TextView textView = this.f41881i;
            if (TextUtils.isEmpty(communityData.getDynamicNum())) {
                str = str3;
            } else {
                str = communityData.getDynamicNum();
            }
            textView.setText(str);
            TextView textView2 = this.f41882j;
            if (TextUtils.isEmpty(communityData.getFocusNum())) {
                str2 = str3;
            } else {
                str2 = communityData.getFocusNum();
            }
            textView2.setText(str2);
            TextView textView3 = this.f41883k;
            if (!TextUtils.isEmpty(communityData.getFansNum())) {
                str3 = communityData.getFansNum();
            }
            textView3.setText(str3);
            return;
        }
        this.f41881i.setText(str3);
        this.f41882j.setText(str3);
        this.f41883k.setText(str3);
    }

    public void O(UnifyKycInfo unifyKycInfo) {
        if (unifyKycInfo == null || TextUtils.isEmpty(unifyKycInfo.getEntranceName())) {
            this.f41884l.setVisibility(8);
            this.f41885m.setImageDrawable((Drawable) null);
            this.f41887o.setText("");
            this.f41884l.setOnClickListener((View.OnClickListener) null);
            return;
        }
        this.f41884l.setVisibility(0);
        this.f41887o.setText(unifyKycInfo.getEntranceName());
        if (TextUtils.isEmpty(unifyKycInfo.getEntranceCountryId())) {
            this.f41885m.setVisibility(8);
        } else {
            this.f41885m.setVisibility(0);
            f6.c.a().l(getContext(), w.e(unifyKycInfo.getEntranceCountryId()), this.f41885m, NightHelper.e().g() ? R.drawable.flag_default_night : R.drawable.flag_default);
        }
        if (TextUtils.isEmpty(unifyKycInfo.getEntranceUrl())) {
            this.f41886n.setVisibility(8);
            this.f41884l.setOnClickListener((View.OnClickListener) null);
            return;
        }
        this.f41886n.setVisibility(0);
        this.f41884l.setOnClickListener(new b(unifyKycInfo));
    }

    public void P(MyPrimeInfo myPrimeInfo) {
        if (myPrimeInfo == null) {
            this.f41880h.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f41883k.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f41882j.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f41881i.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            if (this.f41893u.getCurrentTextColor() == getResources().getColor(R.color.baseTextColor)) {
                this.f41893u.setTextColor(getResources().getColor(R.color.baseColorPrimaryText070));
            }
            this.f41887o.setTextColor(getResources().getColor(R.color.baseColorPrimaryText070));
            this.f41894v.setBackgroundResource(R.drawable.account_uid_bg);
            this.f41894v.setTextColor(getResources().getColor(R.color.baseColorSecondaryTextNew));
            this.f41894v.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.lite_account_copy_new, 0);
            return;
        }
        this.f41880h.setTextColor(getResources().getColor(R.color.baseTextColor));
        this.f41883k.setTextColor(getResources().getColor(R.color.baseTextColor));
        this.f41882j.setTextColor(getResources().getColor(R.color.baseTextColor));
        this.f41881i.setTextColor(getResources().getColor(R.color.baseTextColor));
        if (myPrimeInfo.getLevel() > 6) {
            this.f41887o.setTextColor(getResources().getColor(R.color.baseTextColor));
            this.f41893u.setTextColor(getResources().getColor(R.color.baseTextColor));
        }
        this.f41894v.setBackgroundResource(R.drawable.account_uid_bg_dark);
        this.f41894v.setTextColor(getResources().getColor(R.color.color_808799));
        this.f41894v.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.lite_account_copy_new_dark, 0);
    }

    public final void Q(AccountKycInfo accountKycInfo) {
        this.f41880h.setText(accountKycInfo.g());
        int i11 = 8;
        this.f41892t.setVisibility(8);
        this.f41891s.setVisibility(8);
        this.f41895w.setVisibility(8);
        this.f41894v.setText(accountKycInfo.h());
        if (accountKycInfo.j()) {
            g.i("PV_Authentication_Card_Me_view", (HashMap) null);
            ViewGroup viewGroup = this.f41888p;
            if (accountKycInfo.i()) {
                i11 = 0;
            }
            viewGroup.setVisibility(i11);
            this.f41893u.setText(accountKycInfo.d());
            if (accountKycInfo.c() == 1) {
                setKycAuthProcessing(true);
            } else if (accountKycInfo.c() == 3) {
                K();
            } else {
                J();
            }
        } else if (!TextUtils.isEmpty(accountKycInfo.d())) {
            this.f41888p.setVisibility(accountKycInfo.i() ? 0 : 8);
            g.i("PV_Authentication_Card_Me_view", (HashMap) null);
            this.f41893u.setText(accountKycInfo.d());
            if (accountKycInfo.f() == null) {
                int e11 = accountKycInfo.e();
                if (e11 == 3) {
                    J();
                } else if (e11 == 1) {
                    setKycAuthProcessing(true);
                } else {
                    setKycAuthProcessing(false);
                    t();
                }
            } else {
                this.f41889q.setBackground((Drawable) null);
                this.f41890r.setVisibility(8);
                this.f41892t.setVisibility(0);
                this.f41891s.setVisibility(0);
                f6.c.a().l(getContext(), w.e(String.valueOf(r.x().A())), this.f41891s, NightHelper.e().g() ? R.drawable.flag_default_night : R.drawable.flag_default);
            }
        } else {
            this.f41888p.setVisibility(8);
        }
    }

    public final void R() {
        M();
        if (!r.x().F0() || this.f41875c == null) {
            this.f41878f.setVisibility(0);
            this.f41879g.setVisibility(8);
            return;
        }
        this.f41878f.setVisibility(8);
        this.f41879g.setVisibility(0);
        Q(this.f41875c);
    }

    public final JumpTarget o(Intent intent) {
        JumpTarget jumpTarget = new JumpTarget(intent, (Intent) null);
        jumpTarget.setExpandData("LOGIN_FROM_PERSONAL_CENTER");
        return jumpTarget;
    }

    public final void p() {
        SP.r(r.x().J() + "_unAuth_red_dot_last_time", System.currentTimeMillis());
        this.f41895w.setVisibility(8);
        this.f41898z.c();
    }

    public final void q(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.layout_me_account_info, this, true);
        if (context instanceof Activity) {
            this.f41874b = (Activity) context;
        }
        u();
        r();
        R();
    }

    public final void r() {
        Observable<Void> a11 = dw.a.a(this.f41876d);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new d(this));
        dw.a.a(this.f41879g).throttleFirst(1, timeUnit).subscribe(new m(this));
        dw.a.a(this.f41888p).throttleFirst(1, timeUnit).subscribe(new e(this));
        dw.a.a(this.f41878f).throttleFirst(1, timeUnit).subscribe(new n(this));
        dw.a.a(this.f41894v).throttleFirst(1, timeUnit).subscribe(new wg.c(this));
        this.f41898z = new a();
        com.hbg.module.huobi.im.RedPoint.b.a().b().f(this.f41898z);
    }

    public final void s(i6.r rVar) {
        this.f41881i = (TextView) rVar.b(R.id.tv_dynamic_num);
        this.f41882j = (TextView) rVar.b(R.id.tv_focus_num);
        this.f41883k = (TextView) rVar.b(R.id.tv_fans_num);
        wg.g gVar = wg.g.f61247b;
        Observable<Void> a11 = dw.a.a(rVar.b(R.id.dynamic_container));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new l(gVar, rVar));
        dw.a.a(rVar.b(R.id.focus_container)).throttleFirst(1, timeUnit).subscribe(new j(gVar, rVar));
        dw.a.a(rVar.b(R.id.fans_container)).throttleFirst(1, timeUnit).subscribe(new k(gVar, rVar));
    }

    public void setAccountKycInfo(AccountKycInfo accountKycInfo) {
        this.f41875c = accountKycInfo;
        post(new i(this));
    }

    public final void t() {
        long g11 = SP.g(r.x().J() + "_unAuth_red_dot_init_time", 0);
        if (g11 == 0) {
            this.f41895w.setVisibility(0);
            SP.r(r.x().J() + "_unAuth_red_dot_init_time", System.currentTimeMillis());
        } else {
            long g12 = SP.g(r.x().J() + "_unAuth_red_dot_last_time", 0);
            if (System.currentTimeMillis() - g11 < Period.WEEK_MILLS && System.currentTimeMillis() - g12 > Period.DAY_MILLS) {
                this.f41895w.setVisibility(0);
            }
        }
        AbsRedPointNodeImp absRedPointNodeImp = this.f41898z;
        if (absRedPointNodeImp != null) {
            absRedPointNodeImp.c();
        }
    }

    public final void u() {
        i6.r rVar = new i6.r((View) this);
        this.f41876d = (NftHexagonView) rVar.b(R.id.iv_account_avatar);
        this.f41877e = (LottieAnimationView) rVar.b(R.id.lottie_account_avatar_frame);
        this.f41878f = (ViewGroup) rVar.b(R.id.ll_info_unlogin);
        this.f41879g = (ViewGroup) rVar.b(R.id.ll_info_logged);
        this.f41880h = (TextView) rVar.b(R.id.tv_nick);
        this.f41884l = rVar.b(R.id.dominica_kyc_container);
        this.f41885m = (ImageView) rVar.b(R.id.iv_dmc_flag);
        this.f41887o = (TextView) rVar.b(R.id.tv_dmc_desc);
        this.f41886n = (ImageView) rVar.b(R.id.iv_dmc_arrow);
        this.f41888p = (ViewGroup) rVar.b(R.id.vg_kyc_container);
        this.f41889q = (ViewGroup) rVar.b(R.id.llyt_kyc_status);
        this.f41890r = (ImageView) rVar.b(R.id.iv_kyc_status);
        this.f41891s = (ImageView) rVar.b(R.id.iv_kyc_national_flag);
        this.f41892t = (ImageView) rVar.b(R.id.iv_kyc_arrow);
        this.f41893u = (TextView) rVar.b(R.id.tv_kyc_status);
        this.f41895w = (RoundTextView) rVar.b(R.id.rtvRedDot);
        s(rVar);
        this.f41894v = (TextView) rVar.b(R.id.uid);
        LinearLayout linearLayout = (LinearLayout) rVar.b(R.id.achievement);
        this.f41897y = linearLayout;
        linearLayout.setOnClickListener(new wg.f(this));
        this.f41877e.setFailureListener(new h(this));
    }

    public AccountInfoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41896x = null;
        q(context);
    }
}
