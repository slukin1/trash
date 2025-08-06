package com.huobi.appupgrade.ui;

import android.content.Intent;
import android.net.Uri;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ChannelUtils;
import com.hbg.lib.core.util.o;
import com.hbg.lib.widgets.AutoSizeTextView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.appupgrade.helper.AppUpgradeDownloadHelper;
import com.huobi.appupgrade.presenter.AppUpgradePresenter;
import com.huobi.entity.UpdateResponse;
import com.huobi.login.controller.KillProcessProxy;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import eh.h;
import i6.d;
import i6.k;
import i6.l;
import i6.n;
import pro.huobi.R;
import so.b;

public class AppUpgradeActivity extends BaseActivity<AppUpgradePresenter, AppUpgradePresenter.a> implements AppUpgradePresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public AppUpgradePresenter f42204b;

    /* renamed from: c  reason: collision with root package name */
    public UpdateResponse f42205c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42206d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42207e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42208f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42209g;

    /* renamed from: h  reason: collision with root package name */
    public Button f42210h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f42211i;

    /* renamed from: j  reason: collision with root package name */
    public ProgressBar f42212j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f42213k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f42214l;

    /* renamed from: m  reason: collision with root package name */
    public AutoSizeTextView f42215m;

    /* renamed from: n  reason: collision with root package name */
    public RelativeLayout f42216n;

    /* renamed from: o  reason: collision with root package name */
    public h.b f42217o;

    public class a implements h.b {
        public a() {
        }

        public void a(int i11) {
            AppUpgradeActivity.this.qh(i11);
        }

        public void b(int i11, String str) {
            AppUpgradeActivity.this.ph(i11, str);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qg(View view) {
        if (!NetworkStatus.c(this)) {
            HuobiToastUtil.k(this, R.string.server_error);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (ChannelUtils.d()) {
            oh();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            Zf(true);
            b.d(this);
            this.f42204b.Q(this.f42205c);
            if (!this.f42206d) {
                HuobiToastUtil.s(R.string.upgrade_later);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Og() {
        this.f42217o = new a();
        h.q().j(this.f42217o);
    }

    public final void Pg() {
        if (h.q().s()) {
            this.f42210h.setVisibility(8);
            Zf(true);
            qh(h.q().r());
        }
    }

    public final void Zf(boolean z11) {
        if (z11) {
            this.f42210h.setVisibility(8);
            this.f42208f.setVisibility(0);
            this.f42212j.setVisibility(0);
        } else {
            if (this.f42206d) {
                this.f42213k.setVisibility(8);
            } else {
                this.f42213k.setVisibility(0);
            }
            this.f42208f.setVisibility(8);
            this.f42212j.setVisibility(8);
        }
        this.f42212j.setProgress(0);
    }

    public void addEvent() {
        this.f42213k.setClickable(true);
        this.f42213k.setOnClickListener(new fh.b(this));
        this.f42210h.setOnClickListener(new fh.a(this));
    }

    public boolean canFullScreen() {
        return false;
    }

    /* renamed from: fg */
    public AppUpgradePresenter createPresenter() {
        AppUpgradePresenter appUpgradePresenter = new AppUpgradePresenter();
        this.f42204b = appUpgradePresenter;
        return appUpgradePresenter;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public int getContentView() {
        return R.layout.activity_appupgrade;
    }

    /* renamed from: gg */
    public AppUpgradePresenter.a getUI() {
        return this;
    }

    public final void initData() {
        UpdateResponse updateResponse = this.f42205c;
        if (updateResponse != null) {
            this.f42207e.setText(updateResponse.getContent());
            this.f42209g.setText(this.f42205c.getVersion());
        }
    }

    public void initView() {
        UpdateResponse updateResponse = (UpdateResponse) getIntent().getSerializableExtra("MSG");
        this.f42205c = updateResponse;
        if (updateResponse != null) {
            boolean z11 = updateResponse.getForce_upgrade() == 1;
            this.f42206d = z11;
            setFinishOnTouchOutside(!z11);
        }
        AutoSizeTextView autoSizeTextView = (AutoSizeTextView) findViewById(R.id.tv_title);
        this.f42215m = autoSizeTextView;
        autoSizeTextView.setMinTextSize(getResources().getDimension(R.dimen.global_text_size_16));
        this.f42209g = (TextView) findViewById(R.id.tv_version_name);
        this.f42210h = (Button) findViewById(R.id.force_upgrade);
        this.f42216n = (RelativeLayout) findViewById(R.id.tv_update_layout);
        TextView textView = (TextView) findViewById(R.id.tv_introduce);
        this.f42207e = textView;
        textView.setMaxHeight((int) getResources().getDimension(R.dimen.dimen_340));
        this.f42207e.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.f42213k = (ImageView) findViewById(R.id.tv_cancel);
        this.f42214l = (ImageView) findViewById(R.id.tv_title_bg);
        this.f42208f = (TextView) findViewById(R.id.tv_download_note);
        this.f42211i = (TextView) findViewById(R.id.tv_download_speed);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_download);
        this.f42212j = progressBar;
        progressBar.setMax(100);
        this.f42212j.setProgress(0);
        if (this.f42206d) {
            this.f42213k.setVisibility(8);
        } else {
            this.f42213k.setVisibility(0);
        }
        if (l.n(this)) {
            this.f42210h.setText(getString(R.string.n_update_wifi));
        } else {
            this.f42210h.setText(getString(R.string.n_update_now));
        }
        if (((int) this.f42215m.getPaint().measureText(this.f42215m.getText().toString())) >= ((int) getResources().getDimension(R.dimen.dimen_150))) {
            int g11 = ((int) (((double) n.g(this)) * 0.8611111111111112d)) - ((int) getResources().getDimension(R.dimen.dimen_150));
            ViewGroup.LayoutParams layoutParams = this.f42214l.getLayoutParams();
            layoutParams.width = g11 - ((int) getResources().getDimension(R.dimen.dimen_32));
            this.f42214l.setLayoutParams(layoutParams);
        }
        initData();
        Og();
        Pg();
    }

    public final void oh() {
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

    public void onBackPressed() {
        if (this.f42206d) {
            this.f42204b.R();
            KillProcessProxy.c(this);
            return;
        }
        super.onBackPressed();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f42204b = null;
        h.q().A(this.f42217o);
    }

    public void ph(int i11, String str) {
        if (this.f42206d) {
            Zf(false);
        } else if (!isFinishing()) {
            finish();
        }
    }

    public void qh(int i11) {
        d.c("upDateDownloadProgress", "upDateDownloadProgress percent=" + i11);
        TextView textView = this.f42208f;
        textView.setText(getString(R.string.upgrade_downloading) + i11 + "%");
        this.f42212j.setProgress(i11);
        this.f42211i.setVisibility(0);
        this.f42211i.setText(AppUpgradeDownloadHelper.f42191c);
    }
}
