package com.huobi.otc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import bp.e;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.otc.core.bean.OtcFAQBean;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$raw;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.UserSecuritySetData;
import com.huobi.otc.persenter.OtcFAQPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dp.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.lucode.hackware.magicindicator.R$id;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import rx.Observable;
import rx.functions.Action1;
import sp.v0;
import sp.w0;
import sp.x0;
import sp.y0;

public class OtcFAQActivity extends BaseActivity<OtcFAQPresenter, OtcFAQPresenter.c> implements OtcFAQPresenter.c, o.d {

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f79411b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f79412c;

    /* renamed from: d  reason: collision with root package name */
    public CommonSwitchButton f79413d;

    /* renamed from: e  reason: collision with root package name */
    public CommonTextListIndicator f79414e;

    /* renamed from: f  reason: collision with root package name */
    public View f79415f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f79416g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f79417h;

    /* renamed from: i  reason: collision with root package name */
    public o f79418i;

    /* renamed from: j  reason: collision with root package name */
    public List<String> f79419j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public HashMap<String, String> f79420k = new HashMap<>();

    /* renamed from: l  reason: collision with root package name */
    public View f79421l;

    /* renamed from: m  reason: collision with root package name */
    public SafeLottieView f79422m;

    /* renamed from: n  reason: collision with root package name */
    public ImageView f79423n;

    /* renamed from: o  reason: collision with root package name */
    public HorizontalScrollView f79424o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f79425p = true;

    /* renamed from: q  reason: collision with root package name */
    public DecelerateInterpolator f79426q = new DecelerateInterpolator();

    public class a implements CommonTextListIndicator.b {
        public a() {
        }

        public void a(int i11, View view) {
        }

        public void onItemClick(int i11) {
            try {
                OtcFAQActivity.this.f79412c.setCurrentItem(i11);
                HashMap hashMap = new HashMap();
                hashMap.put("menu_index", Integer.valueOf(i11));
                hashMap.put("menu_title", OtcFAQActivity.this.f79419j.get(i11));
                hashMap.put("menu_code", OtcFAQActivity.this.f79420k.get(OtcFAQActivity.this.f79419j.get(i11)));
                uf.c.b().i("click_related_menu", hashMap);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class b implements Action1<Void> {
        public b() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            if (OtcFAQActivity.this.f79416g) {
                OtcFAQActivity.this.N6(false);
                OtcModuleConfig.a().b("6181", MapParamsBuilder.c().a("type", "open").b());
                return;
            }
            o unused = OtcFAQActivity.this.f79418i = new o(OtcFAQActivity.this);
            OtcFAQActivity.this.f79418i.o(new y0(OtcFAQActivity.this));
            OtcFAQActivity.this.f79418i.show();
            OtcModuleConfig.a().b("6181", MapParamsBuilder.c().a("type", "close").b());
            OtcModuleConfig.a().m("6186", "1005397", (String) null, (Map<String, Object>) null);
        }
    }

    public class c implements Action1<Void> {
        public c() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            OtcFAQActivity.this.startActivity(OtcModuleConfig.a().N(OtcFAQActivity.this));
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            OtcFAQActivity.this.getPresenter().V();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wh(Void voidR) {
        HorizontalScrollView horizontalScrollView = this.f79424o;
        if (horizontalScrollView != null) {
            horizontalScrollView.smoothScrollTo(Integer.MAX_VALUE, 0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xh(View view, int i11, int i12, int i13, int i14) {
        if (((view.getScrollX() + view.getWidth()) - view.getPaddingLeft()) - view.getPaddingRight() == this.f79424o.getChildAt(0).getWidth()) {
            rh();
        } else {
            qh();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh() {
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) this.f79414e.findViewById(R$id.scroll_view);
        this.f79424o = horizontalScrollView;
        if (horizontalScrollView != null && Build.VERSION.SDK_INT >= 23) {
            horizontalScrollView.setOnScrollChangeListener(new v0(this));
        }
    }

    public static void zh(Activity activity) {
        activity.startActivity(new Intent(activity, OtcFAQActivity.class));
    }

    public void Ah(int i11) {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().clearFlags(67108864);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, i11));
        }
    }

    public void D7(String str, boolean z11, String str2) {
    }

    public void N6(boolean z11) {
        if (this.f79413d != null) {
            this.f79416g = z11;
            ConfigPreferences.n("otc_config", "otc_faq_float_close", z11);
            this.f79413d.setChecked(!z11);
        }
    }

    public void addEvent() {
        Observable<Void> a11 = dw.a.a(this.f79415f);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new b());
        dw.a.a(this.f79417h).throttleFirst(300, timeUnit).subscribe(new c());
        this.f79411b.setOnRetryClickListener(new d());
        dw.a.a(this.f79423n).throttleFirst(1, TimeUnit.SECONDS).subscribe(new x0(this));
    }

    public boolean canFullScreen() {
        return Build.VERSION.SDK_INT < 21;
    }

    /* renamed from: f2 */
    public OtcFAQPresenter getPresenter() {
        return (OtcFAQPresenter) super.getPresenter();
    }

    public int getContentView() {
        return R$layout.activity_otc_faq;
    }

    public ViewGroup getParentLayout() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        return linearLayout;
    }

    public final void initData() {
        this.f79416g = ConfigPreferences.b("otc_config", "otc_faq_float_close");
    }

    public void initView() {
        initData();
        setToolBar((Toolbar) this.viewFinder.b(com.hbg.module.otc.R$id.toolbar), "", true);
        this.f79411b = (LoadingLayout) this.viewFinder.b(com.hbg.module.otc.R$id.ll_loading);
        this.f79412c = (ViewPager) this.viewFinder.b(com.hbg.module.otc.R$id.view_pager);
        this.f79413d = (CommonSwitchButton) this.viewFinder.b(com.hbg.module.otc.R$id.csb_faq_help);
        this.f79417h = (TextView) this.viewFinder.b(com.hbg.module.otc.R$id.tv_faq_customer);
        this.f79413d.setChecked(!this.f79416g);
        this.f79414e = (CommonTextListIndicator) this.viewFinder.b(com.hbg.module.otc.R$id.tab_otc_faq);
        this.f79415f = this.viewFinder.b(com.hbg.module.otc.R$id.ll_faq_help);
        this.f79421l = this.viewFinder.b(com.hbg.module.otc.R$id.cl_faq_center);
        this.f79422m = (SafeLottieView) this.viewFinder.b(com.hbg.module.otc.R$id.slv_left);
        this.f79423n = (ImageView) this.viewFinder.b(com.hbg.module.otc.R$id.iv_prompt_arrow);
        if (NightHelper.e().g()) {
            this.f79422m.setAnimation(R$raw.faq_dialog_huobao_night);
        }
        this.f79422m.setRepeatCount(2);
        this.f79422m.resumeAnimation();
        vh(this.f79414e);
    }

    public boolean isLightStatusBar() {
        return false;
    }

    public void n4(String str) {
        this.f79411b.k();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Ah(R$color.baseColorContentBackground);
        changeStatusBarTextColor(!NightHelper.e().g());
    }

    /* renamed from: ph */
    public OtcFAQPresenter createPresenter() {
        OtcFAQPresenter otcFAQPresenter = new OtcFAQPresenter();
        otcFAQPresenter.c0("landingHome");
        return otcFAQPresenter;
    }

    public final void qh() {
        if (!this.f79425p) {
            this.f79425p = true;
            this.f79423n.animate().setInterpolator(this.f79426q).setDuration(300).translationX(0.0f).alpha(1.0f);
        }
    }

    public void rf(List<OtcFAQBean> list) {
        this.f79419j.clear();
        for (OtcFAQBean next : list) {
            this.f79419j.add(next.getTitle());
            this.f79420k.put(next.getTitle(), next.getCode());
        }
        this.f79414e.setDataList(this.f79419j);
        this.f79412c.setAdapter(uh(list));
        this.f79411b.g();
        this.f79414e.post(new w0(this));
    }

    public final void rh() {
        if (this.f79425p) {
            this.f79425p = false;
            this.f79423n.animate().setInterpolator(this.f79426q).setDuration(300).translationX((float) this.f79423n.getWidth()).alpha(0.0f);
        }
    }

    public void sh(String str, int i11) {
        getPresenter().S(str, i11);
    }

    /* renamed from: th */
    public OtcFAQPresenter.c getUI() {
        return this;
    }

    public final e uh(List<OtcFAQBean> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(OtcFAQFragment.class);
        ArrayList arrayList2 = new ArrayList();
        for (OtcFAQBean putSerializable : list) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_faq_data_bean", putSerializable);
            arrayList2.add(bundle);
        }
        e eVar = new e(getSupportFragmentManager());
        eVar.a(arrayList, this.f79419j, arrayList2);
        return eVar;
    }

    public final void vh(CommonTextListIndicator commonTextListIndicator) {
        commonTextListIndicator.setIndicatorColor(getResources().getColor(R$color.baseColorMajorTheme100));
        commonTextListIndicator.setIndicatorLineWidth(UIUtil.a(this, 16.0d));
        commonTextListIndicator.setCapitalTitle(false);
        commonTextListIndicator.setGravity(48);
        commonTextListIndicator.x(2, UIUtil.a(this, 12.0d));
        commonTextListIndicator.setTitleViewNormalColor(getResources().getColor(R$color.baseColorSecondaryTextNew));
        commonTextListIndicator.setTitleViewSelectColor(getResources().getColor(R$color.baseColorPrimaryText));
        commonTextListIndicator.setCallback(new a());
        ViewPagerHelper.a(this.f79414e, this.f79412c);
    }

    public void w6(UserSecuritySetData userSecuritySetData) {
        if (userSecuritySetData == null || userSecuritySetData.getUserVO() == null) {
            HuobiToastUtil.g(R$string.otc_retry_later);
        } else if (userSecuritySetData.getUserVO().isIsTradeBind()) {
            OtcModuleConfig.b().z(this, new Intent());
        } else if (userSecuritySetData.getUserVO().isVerifyWayHaveSet()) {
            nb.c.j(this, false);
        } else {
            startActivity(new Intent(this, OtcTradeSettingActivity.class));
        }
    }
}
