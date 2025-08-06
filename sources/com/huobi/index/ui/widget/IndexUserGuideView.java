package com.huobi.index.ui.widget;

import am.h;
import am.i;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.UserRegistryTransferGuide;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import jp.k0;
import kn.a;
import pro.huobi.R;
import rn.c;

public class IndexUserGuideView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public final int f74036b;

    /* renamed from: c  reason: collision with root package name */
    public final int f74037c;

    /* renamed from: d  reason: collision with root package name */
    public final int f74038d;

    /* renamed from: e  reason: collision with root package name */
    public final int f74039e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f74040f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f74041g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f74042h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f74043i;

    /* renamed from: j  reason: collision with root package name */
    public int f74044j;

    /* renamed from: k  reason: collision with root package name */
    public String f74045k;

    public IndexUserGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e(View view) {
        if (this.f74044j == 0) {
            c.i().d(getContext(), (a) null);
        } else if (getContext() instanceof Activity) {
            k0.k((Activity) getContext());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(View view) {
        if (!TextUtils.isEmpty(this.f74045k)) {
            HBBaseWebActivity.showWebView(getContext(), this.f74045k, (String) null, (String) null, false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void c() {
        setOnClickListener(new h(this));
        this.f74043i.setOnClickListener(new i(this));
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.index_user_guide_layout, this);
        this.f74040f = (TextView) findViewById(R.id.index_user_guide_title);
        this.f74041g = (TextView) findViewById(R.id.index_user_guide_content);
        this.f74042h = (TextView) findViewById(R.id.index_user_guide_login);
        this.f74043i = (TextView) findViewById(R.id.index_user_guide_html_address);
    }

    public void setData(UserRegistryTransferGuide userRegistryTransferGuide) {
        if (userRegistryTransferGuide != null) {
            this.f74044j = userRegistryTransferGuide.getTaskProgress();
            this.f74045k = userRegistryTransferGuide.getIntroductionUrl();
            this.f74040f.setText(StringUtils.f(userRegistryTransferGuide.getTitle(), '{', '}', getResources().getColor(R.color.baseColorHomeGuideForeText)));
            this.f74041g.setText(StringUtils.f(userRegistryTransferGuide.getSubTitle(), '{', '}', getResources().getColor(R.color.baseColorHomeGuideForeText)));
            if (this.f74044j == 0) {
                this.f74042h.setText(getResources().getString(R.string.n_home_login_register));
                this.f74043i.setVisibility(8);
                return;
            }
            this.f74042h.setText(getResources().getString(R.string.n_index_amount_immediately));
            this.f74043i.setVisibility(0);
        }
    }

    public IndexUserGuideView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f74036b = 0;
        this.f74037c = 1;
        this.f74038d = 2;
        this.f74039e = 3;
        d();
        c();
    }
}
