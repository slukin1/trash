package com.huobi.account.ui;

import android.content.Intent;
import android.view.View;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.ChannelUtils;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.huobi.store.AppConfigManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import tg.r;

public class BrushGuideGAActivity extends EmptyMVPActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public View f41131b;

    /* renamed from: c  reason: collision with root package name */
    public View f41132c;

    public int getContentView() {
        return R.layout.activity_brush_guide_ga;
    }

    public void initView() {
        this.f41131b = this.viewFinder.b(R.id.btn_download);
        this.f41132c = this.viewFinder.b(R.id.btn_action);
        this.f41131b.setOnClickListener(this);
        this.f41132c.setOnClickListener(this);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        String str;
        int id2 = view.getId();
        if (id2 != R.id.btn_action) {
            if (id2 == R.id.btn_download) {
                if (ChannelUtils.d()) {
                    str = AppConfigManager.l(MgtConfigNumber.GA_DOWNLOAD_LINK_URL.number, "googleJumpUrl", "https://play.google.com/store/apps/details?id=com.google.android.apps.authenticator2");
                } else {
                    str = AppConfigManager.l(MgtConfigNumber.GA_DOWNLOAD_LINK_URL.number, "androidJumpUrl", "https://play.google.com/store/apps/details?id=com.google.android.apps.authenticator2");
                }
                HBBaseWebActivity.showWebView(this, str, "", "", false);
            }
        } else if (getIntent().getBooleanExtra("JUMP_LOGIN_GA_BIND_PAGE", r.x().F0())) {
            Intent intent = new Intent(this, SecurityLinkActivity.class);
            intent.putExtra("LINK_TYPE_KEY", 3);
            startActivity(intent);
        } else {
            Intent intent2 = new Intent(this, BrushSetGAActivity.class);
            if (!(getIntent() == null || getIntent().getExtras() == null)) {
                intent2.putExtras(getIntent().getExtras());
            }
            startActivity(intent2);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
