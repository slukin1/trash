package com.huobi.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.f;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ChannelUtils;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.o;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.utils.l;
import com.huobi.app.AbstractCommonListActivity;
import com.huobi.entity.UpdateResponse;
import com.huobi.utils.UpgradeUtil;
import com.huobi.utils.d1;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import eh.h;
import hr.d;
import i6.k;
import java.util.List;
import pro.huobi.R;
import u6.g;
import xg.j;

@Route(path = "/app/about")
public class AppConfigAboutUsActivity extends AbstractCommonListActivity implements d.a {

    /* renamed from: g  reason: collision with root package name */
    public boolean f42032g;

    /* renamed from: h  reason: collision with root package name */
    public String f42033h = "";

    /* renamed from: i  reason: collision with root package name */
    public h.b f42034i;

    /* renamed from: j  reason: collision with root package name */
    public int f42035j = 1;

    /* renamed from: k  reason: collision with root package name */
    public boolean f42036k = false;

    public class a implements h.b {
        public a() {
        }

        public void a(int i11) {
            AppConfigAboutUsActivity.this.Eh();
        }

        public void b(int i11, String str) {
            AppConfigAboutUsActivity.this.Eh();
        }
    }

    public class b extends EasySubscriber<UpdateResponse> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(UpdateResponse updateResponse) {
            super.onNext(updateResponse);
            boolean unused = AppConfigAboutUsActivity.this.f42036k = true;
            String downloadurl = updateResponse.getDownloadurl();
            if (updateResponse.getVersion_code() <= 105400) {
                UpgradeUtil.d((String) null);
            } else {
                UpgradeUtil.d(downloadurl);
                if (!(updateResponse.getMd5() == null || updateResponse.getDirect_downloadurl() == null)) {
                    h.q().k(updateResponse);
                }
            }
            if (updateResponse.getService_check() > 0 || !"upgrade".equals(updateResponse.getMsgtype()) || !UpgradeUtil.c()) {
                HuobiToastUtil.s(R.string.app_upgrade_already);
            } else if ("GooglePlayAndroid".equals(ChannelUtils.b())) {
                k.f("AppConfigAboutUsActivity", "CHANNEL_GOOGLE");
                AppConfigAboutUsActivity.this.Rh();
            } else {
                AppConfigAboutUsActivity.this.Eh();
                h.z(AppConfigAboutUsActivity.this, updateResponse);
            }
        }

        public void onAfter() {
            super.onAfter();
            AppConfigAboutUsActivity.this.dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            k.f("AppConfigAboutUsActivity", "doCheckVersion onError2 " + AppConfigAboutUsActivity.this.f42036k);
            if (!AppConfigAboutUsActivity.this.f42036k) {
                boolean unused = AppConfigAboutUsActivity.this.f42036k = true;
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            k.f("AppConfigAboutUsActivity", "doCheckVersion onFailed " + AppConfigAboutUsActivity.this.f42036k);
            if (!AppConfigAboutUsActivity.this.f42036k) {
                boolean unused = AppConfigAboutUsActivity.this.f42036k = true;
            }
        }

        public void onStart() {
            super.onStart();
            AppConfigAboutUsActivity.this.showProgressDialog();
            k.f("AppConfigAboutUsActivity", "doCheckVersion onStart");
        }
    }

    public static void Sh(Context context) {
        HbgRouter.h(context, "/app/about");
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        int i11 = this.f42035j;
        if (i11 < 5) {
            this.f42035j = i11 + 1;
        } else {
            this.f42035j = 1;
            String r11 = PhoneUtils.r();
            f.a(r11);
            Toast.makeText(this, "设备ID已复制到剪切板：" + r11, 1).show();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Bh() {
    }

    public void Ch() {
    }

    public String D(int i11) {
        switch (i11) {
            case 2:
                return Ph();
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
                return "";
            default:
                return null;
        }
    }

    public boolean E8(int i11, View view) {
        return false;
    }

    public final void Oh() {
        h.B().compose(RxJavaHelper.t((g) null)).subscribe(new b());
    }

    public final String Ph() {
        if (h.q().s()) {
            return getString(R.string.upgrade_downloading) + h.q().r() + "%";
        } else if (!this.f42032g) {
            return getString(R.string.n_user_center_latest_version);
        } else {
            return String.format(getString(R.string.n_user_center_touch_update), new Object[]{this.f42033h});
        }
    }

    public String Qg() {
        return getString(R.string.share_this_app);
    }

    public final void Qh() {
        UpdateResponse o11;
        boolean c11 = UpgradeUtil.c();
        this.f42032g = c11;
        if (c11 && (o11 = h.q().o()) != null) {
            this.f42033h = o11.getVersion();
        }
    }

    public final void Rh() {
        String a11 = o.a();
        String b11 = o.b();
        k.f("AppConfigAboutUsActivity", "googlePlayPackage = " + a11);
        k.f("AppConfigAboutUsActivity", "googlePlayUrl = " + b11);
        String packageName = getPackageName();
        if (packageName != null) {
            try {
                k.f("AppConfigAboutUsActivity", "打开googlePlay");
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
                intent.setPackage(a11);
                intent.addFlags(268435456);
                startActivity(intent);
            } catch (Exception e11) {
                k.j("AppConfigAboutUsActivity", e11);
                k.f("AppConfigAboutUsActivity", "打开googlePlay网址");
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(b11 + "?id=" + packageName));
                intent2.addFlags(268435456);
                startActivity(intent2);
            }
        }
    }

    public String a(int i11) {
        switch (i11) {
            case 2:
                return getString(R.string.n_user_center_update);
            case 3:
                return getString(R.string.setting_privacy_policy);
            case 4:
                return getString(R.string.setting_user_agreement);
            case 5:
                return getString(R.string.n_me_about_feedback_start);
            case 6:
                return getString(R.string.default_user_agreement);
            case 7:
                return getString(R.string.turkey_user_agreement);
            case 8:
                return getString(R.string.turkey_kvkk);
            case 9:
                return getString(R.string.n_global_licensed_businesses);
            case 10:
                return getString(R.string.n_review_give_me_good_review);
            default:
                return null;
        }
    }

    public int getContentView() {
        return R.layout.activity_about;
    }

    public void initView() {
        super.initView();
        ((TextView) this.viewFinder.b(R.id.tv_version_title)).setText(String.format(getString(R.string.n_user_center_version), new Object[]{"10.54.0"}));
        this.f42034i = new a();
        h.q().j(this.f42034i);
        ((ImageView) this.viewFinder.b(R.id.iv_me_logo)).setOnClickListener(new j(this));
    }

    public String oh() {
        return getString(R.string.n_user_center_about);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Qh();
    }

    public void onDestroy() {
        super.onDestroy();
        h.q().A(this.f42034i);
    }

    public void onItemClick(int i11) {
        switch (i11) {
            case 2:
                Oh();
                return;
            case 3:
                sn.f.b0(this);
                return;
            case 4:
            case 6:
                sn.f.g0(this);
                return;
            case 5:
                sn.f.S(this);
                return;
            case 7:
                HBBaseWebActivity.showWebView(this, d1.p(), "", "", false);
                return;
            case 8:
                HBBaseWebActivity.showWebView(this, d1.o(), "", "", false);
                return;
            case 9:
                HBBaseWebActivity.showWebView(this, d1.i(), "", "", false, false);
                return;
            case 10:
                l.f(this);
                return;
            default:
                return;
        }
    }

    public void ph() {
    }

    public List<s9.a> qh(List<s9.a> list) {
        list.add(new d(2, this));
        list.add(new d(3, this));
        list.add(new d(4, this));
        list.add(new d(9, this));
        list.add(new d(5, this));
        if (ChannelUtils.d()) {
            list.add(new d(10, this));
        }
        return list;
    }

    public boolean th() {
        return false;
    }

    public boolean uh() {
        return false;
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public boolean v8(int i11) {
        return i11 == 2 && !h.q().s() && this.f42032g;
    }
}
