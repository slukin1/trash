package com.huobi.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import bh.j;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.t;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.p;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.b;
import com.huobi.apm.TimeMonitorManager;
import com.huobi.app.rms.HBRMSManager;
import com.huobi.app.rms.bean.HBRMSResourceInfoModel;
import com.huobi.app.rms.bean.HBRMSResourceType;
import com.huobi.app.util.StartAppUtil;
import com.huobi.domain.DomainSwitcher;
import com.huobi.google.GooglePlayUtil;
import com.huobi.index.trace.IndexLifeCycleStep;
import com.huobi.index.trace.IndexLifeCycleTracer;
import com.huobi.main.bean.RemoteSkinBean;
import com.huobi.utils.HomeHelper;
import com.xiaomi.mipush.sdk.Constants;
import gj.e;
import i6.d;
import i6.i;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import pro.huobi.R;
import xg.t0;
import xg.u0;
import xg.v0;
import xg.w0;
import xm.c;

@Route(path = "/Launch/index")
public class StartFlashActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public Intent f42111b;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f42112b;

        public a(View view) {
            this.f42112b = view;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            StartFlashActivity.this.ph();
            TimeMonitorManager.a().b("splash_consume").a("splash_consume", Constants.ACCEPT_TIME_SEPARATOR_SERVER, true);
        }

        public void onGlobalLayout() {
            this.f42112b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            i.b().f(new w0(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Qg() {
        d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " StartFlashActivity testDomain start                      ");
        qh();
        d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " StartFlashActivity testDomain end                      ");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oh() {
        StartAppUtil.b(new t0(this));
    }

    /* renamed from: Og */
    public final void Pg() {
        if (PhoneUtils.x()) {
            HuobiToastUtil.k(j.c().getApplicationContext(), R.string.root_hint);
        }
    }

    public void attachBaseContext(Context context) {
        d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " StartFlashActivity attachBaseContext start              ");
        super.attachBaseContext(context);
        d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " StartFlashActivity attachBaseContext end              ");
    }

    public int getContentView() {
        return R.layout.app_start_flash_view_no_anim;
    }

    public ViewGroup getParentLayout() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        return linearLayout;
    }

    public final boolean gg(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z11 = false;
        boolean z12 = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"qemu.hw.mainkeys"});
            if (!"1".equals(str)) {
                z11 = "0".equals(str) ? true : z12;
            }
            return z11;
        } catch (Exception e11) {
            d.f("底部导航", e11);
            return z12;
        }
    }

    public void initView() {
        super.initView();
        RemoteSkinBean remoteSkinBean = null;
        try {
            List<HBRMSResourceInfoModel> K = HBRMSManager.z().K(HBRMSResourceType.Skin);
            if (!b.w(K)) {
                StringBuilder sb2 = new StringBuilder();
                File file = new File(K.get(0).getResourcePath() + "/config.json");
                if (file.exists()) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb2.append(readLine);
                        sb2.append("\n");
                    }
                    remoteSkinBean = (RemoteSkinBean) rd.d.f23353a.b(sb2.toString(), RemoteSkinBean.class);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        ImageView imageView = (ImageView) findViewById(R.id.ivBg);
        ImageView imageView2 = (ImageView) findViewById(R.id.splash_logo);
        ImageView imageView3 = (ImageView) findViewById(R.id.ivBottomLogo);
        if (remoteSkinBean != null && remoteSkinBean.getLaunch() != null) {
            RemoteSkinBean.RemoteLaunchBean launch = remoteSkinBean.getLaunch();
            imageView2.setVisibility(8);
            if (p.h(this) || p.i(this)) {
                imageView.setImageDrawable(com.huobi.main.helper.a.c().e(getResources(), launch.getCn().getBackground().getImage()));
                imageView3.setImageDrawable(com.huobi.main.helper.a.c().e(getResources(), launch.getCn().getLogo().getImage()));
                return;
            }
            imageView.setImageDrawable(com.huobi.main.helper.a.c().e(getResources(), launch.getOther().getBackground().getImage()));
            imageView3.setImageDrawable(com.huobi.main.helper.a.c().e(getResources(), launch.getOther().getLogo().getImage()));
        } else if (p.h(this)) {
            imageView2.setImageResource(R.drawable.splash_logo_cn);
        } else if (p.i(this)) {
            imageView2.setImageResource(R.drawable.splash_logo_hk);
        }
    }

    public boolean isLightStatusBar() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("Step_Launch_td", Long.valueOf(System.currentTimeMillis() - StartAppUtil.f42185c));
        hashMap.put("Step_Launch_ts", Long.valueOf(System.currentTimeMillis()));
        ah.a.c().g("appStartTime", hashMap);
        StartAppUtil.f42186d = System.currentTimeMillis();
        IndexLifeCycleTracer.c().f(IndexLifeCycleStep.AppLaunch);
        d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " StartFlashActivity onCreate start                      ");
        TimeMonitorManager.a().b("splash_consume").c();
        c.d(false);
        super.onCreate(bundle);
        Uri data = getIntent().getData();
        if (data != null) {
            Set<String> e11 = t.a("h5_huobi_url_whitelist").e("h5_huobi_url_whitelist", (Set<String>) null);
            if (e11 != null && !e11.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(e11);
                HbgRouter.l(arrayList);
            }
            zn.a.d().v(data).a();
        }
        if (getIntent() == null || (getIntent().getFlags() & 4194304) == 0) {
            GooglePlayUtil.a(this, false);
            setStatusBarColor(getResources().getColor(R.color.splash_bg_color));
            fs.a.c().a().execute(new u0(this));
            View findViewById = findViewById(16908290);
            findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new a(findViewById));
            d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " StartFlashActivity onCreate end                      ");
            return;
        }
        finish();
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 == 4) {
            return false;
        }
        return super.onKeyDown(i11, keyEvent);
    }

    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            return super.onKeyUp(i11, keyEvent);
        }
        finish();
        return false;
    }

    public void onResume() {
        d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " StartFlashActivity onResume start");
        super.onResume();
        this.f42111b = e.c(this);
        fs.a.c().a().execute(new v0(this));
        d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " StartFlashActivity onResume end                      ");
    }

    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= 19 && gg(this)) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.splash_bg_color));
            getWindow().getDecorView().setSystemUiVisibility(1024);
        }
    }

    public final void ph() {
        int g11 = ConfigPreferences.g("config_username", "config_welcomes_show", 1);
        int g12 = ConfigPreferences.g("config_username", "config_first_V10", 1);
        if (g11 != 1 && g12 == 1) {
            ConfigPreferences.k("config_username", "config_first_update_v10_user", 1);
        }
        if (g11 == 1 || (g12 == 1 && HomeHelper.j())) {
            Intent d11 = e.b().d(this);
            d11.putExtra("will_return", false);
            if (g11 == 1) {
                d11.putExtra("App_launch_type", 0);
            } else {
                d11.putExtra("App_launch_type", 1);
            }
            startActivity(d11);
            ConfigPreferences.k("config_username", "config_welcomes_show", 0);
            ConfigPreferences.k("config_username", "config_first_V10", 0);
        } else if (e.b().f()) {
            ConfigPreferences.k("user_config", "app_exit", 0);
            startActivity(this.f42111b);
        } else {
            e.b().e(this);
        }
        overridePendingTransition(R.anim.splash_alpha_in, R.anim.splash_alpha_out);
        finish();
    }

    public final void qh() {
        DomainSwitcher.A().V0();
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
