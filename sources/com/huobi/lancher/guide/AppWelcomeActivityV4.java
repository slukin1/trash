package com.huobi.lancher.guide;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.SpanUtils;
import com.blankj.utilcode.util.h;
import com.blankj.utilcode.util.v;
import com.blankj.utilcode.util.x;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.compliance.ComplianceUtil;
import com.huobi.index.ui.widget.HBIndicatorView;
import com.huobi.login.v2.ui.UserRegisterActivityV2;
import com.huobi.login.v3.ui.UserRegisterActivityV3;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gj.e;
import gs.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pro.huobi.R;
import wm.c;
import wm.d;
import wn.c0;

@Route(path = "/guide/index")
public class AppWelcomeActivityV4 extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public ViewPager2 f74922b;

    /* renamed from: c  reason: collision with root package name */
    public HBIndicatorView f74923c;

    /* renamed from: d  reason: collision with root package name */
    public GuidePageAdapter f74924d;

    /* renamed from: e  reason: collision with root package name */
    public long f74925e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    public View f74926f;

    /* renamed from: g  reason: collision with root package name */
    public View f74927g;

    public class a implements ComplianceUtil.c {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(HBDialogFragment hBDialogFragment) {
            AppWelcomeActivityV4.this.finishAffinity();
        }

        public void a() {
        }

        public void onSuccess(String str) {
            if (!TextUtils.isEmpty(str)) {
                if ("76".equals(str) || "126".equals(str) || "168".equals(str) || "163".equals(str) || "42".equals(str)) {
                    AppWelcomeActivityV4 appWelcomeActivityV4 = AppWelcomeActivityV4.this;
                    DialogUtils.X(appWelcomeActivityV4, appWelcomeActivityV4.getString(R.string.warning), AppWelcomeActivityV4.this.getString(R.string.country_policy), (String) null, AppWelcomeActivityV4.this.getString(R.string.exit), new d(this));
                }
            }
        }
    }

    public class b extends ViewPager2.OnPageChangeCallback {
        public b() {
        }

        public void onPageSelected(int i11) {
            boolean l11 = SP.l("App_first_setup_show_" + i11, true);
            if (l11) {
                SP.y("App_first_setup_show_" + i11, false);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("popup_id", Integer.valueOf(i11 + 1));
            hashMap.put("is_first_show", l11 ? "是" : "否");
            g.i("App_first_setup_show", hashMap);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        ConfigPreferences.k("config_username", "config_first_V10", 0);
        startActivity(e.c(this));
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oh(int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("popup_id", Integer.valueOf(i11 + 1));
        hashMap.put("runningTime", Long.valueOf(System.currentTimeMillis() - this.f74925e));
        g.i("App_first_setup_skip", hashMap);
        startActivity(e.c(this));
        finish();
        ConfigPreferences.k("config_username", "config_welcomes_show", 0);
        ConfigPreferences.k("config_username", "config_first_V10", 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ph(View view) {
        Class cls;
        int currentItem = this.f74922b.getCurrentItem();
        HashMap hashMap = new HashMap();
        hashMap.put("popup_id", Integer.valueOf(currentItem + 1));
        hashMap.put("runningTime", Long.valueOf(System.currentTimeMillis() - this.f74925e));
        g.i("App_launch_register_click", hashMap);
        if (c0.h()) {
            cls = UserRegisterActivityV3.class;
        } else {
            cls = UserRegisterActivityV2.class;
        }
        Intent intent = new Intent(this, cls);
        intent.putExtra("register_type", "register_email");
        startActivities(new Intent[]{e.c(this), intent});
        finish();
        ConfigPreferences.k("config_username", "config_welcomes_show", 0);
        ConfigPreferences.k("config_username", "config_first_V10", 0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Og() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new wm.e(R.drawable.guide_step1, R.string.n_new_user_guide_page_1_title, gg(R.string.n_new_user_guide_page_1_content)));
        arrayList.add(new wm.e(R.drawable.guide_step2, R.string.n_new_user_guide_page_2_title, new SpanUtils().a(gg(R.string.n_new_user_guide_page_2_content1)).a("\n").a(gg(R.string.n_new_user_guide_page_2_content2)).a("\n").a(gg(R.string.n_new_user_guide_page_2_content3)).d()));
        arrayList.add(new wm.e(R.drawable.guide_step3, R.string.n_new_user_guide_page_3_title, gg(R.string.n_new_user_guide_page_3_content)));
        arrayList.add(new wm.e(R.drawable.guide_step4, R.string.n_new_user_guide_page_4_title, gg(R.string.n_new_user_guide_page_4_content)));
        this.f74924d.setData(arrayList);
    }

    public final void Pg() {
        this.f74922b = (ViewPager2) this.viewFinder.b(R.id.guide_view_pager);
        GuidePageAdapter guidePageAdapter = new GuidePageAdapter();
        this.f74924d = guidePageAdapter;
        guidePageAdapter.f(new c(this));
        this.viewFinder.b(R.id.guide_btn_register_now).setOnClickListener(new wm.a(this));
        this.f74922b.registerOnPageChangeCallback(new b());
        this.f74922b.setAdapter(this.f74924d);
    }

    public final void Qg() {
        HBIndicatorView hBIndicatorView = (HBIndicatorView) this.viewFinder.b(R.id.guide_view_pager_indicator);
        this.f74923c = hBIndicatorView;
        hBIndicatorView.k(h.a(R.color.color_d0d6d9), h.a(R.color.color_12B298));
        this.f74923c.n((float) v.a(8.0f), (float) v.a(14.0f));
        this.f74923c.m((float) v.a(3.0f));
        this.f74923c.l((float) v.a(2.0f));
        this.f74923c.j(3);
        this.f74923c.i(2);
        this.f74923c.setOrientation(0);
        this.f74923c.setupWithViewPager(this.f74922b);
    }

    public final void fg() {
        ComplianceUtil.g(new a());
    }

    public int getContentView() {
        return R.layout.activity_welcome_4;
    }

    public final SpannableStringBuilder gg(int i11) {
        String b11 = x.b(i11);
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("(?<=【)[^】]+").matcher(b11);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        String[] split = b11.replace("【", "】").split("】");
        SpanUtils spanUtils = new SpanUtils();
        for (String str : split) {
            spanUtils.a(str);
            if (arrayList.contains(str)) {
                spanUtils.g(h.a(R.color.color_12B298)).e();
            }
        }
        return spanUtils.d();
    }

    public void initView() {
        super.initView();
        this.f74926f = findViewById(R.id.welcome_guide_view);
        this.f74927g = findViewById(R.id.welcome_guide_update_v10_view);
        findViewById(R.id.welcome_guide_update_v10_btn).setOnClickListener(new wm.b(this));
        if (getIntent().getIntExtra("App_launch_type", 1) == 0) {
            this.f74926f.setVisibility(0);
            this.f74927g.setVisibility(8);
            setStatusBarColor(getResources().getColor(R.color.color_new_user_guide_bg));
        } else {
            this.f74926f.setVisibility(8);
            this.f74927g.setVisibility(0);
            setStatusBarColor(getResources().getColor(R.color.KBaseColorContentBackground));
            ConfigPreferences.k("config_username", "config_first_V10", 0);
        }
        Pg();
        Og();
        Qg();
        fg();
    }

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.blankj.utilcode.util.e.c(this, false);
        g.i("App_launch_view", (HashMap) null);
    }
}
