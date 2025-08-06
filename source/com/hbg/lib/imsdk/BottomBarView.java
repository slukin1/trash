package com.hbg.lib.imsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.HbgDialogConfigInfo;
import com.hbg.lib.network.hbg.core.bean.HbgDialogItem;
import com.hbg.module.huobi.im.imsignal.ImSdkModuleConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import e7.e;
import f6.c;
import h7.b;
import i6.d;
import i6.i;
import i6.n;
import i6.r;
import java.util.HashMap;

public class BottomBarView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f69092b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f69093c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f69094d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f69095e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f69096f;

    /* renamed from: g  reason: collision with root package name */
    public View f69097g;

    /* renamed from: h  reason: collision with root package name */
    public View f69098h;

    /* renamed from: i  reason: collision with root package name */
    public HbgDialogWebView f69099i;

    /* renamed from: j  reason: collision with root package name */
    public HbgDialogConfigInfo f69100j;

    /* renamed from: k  reason: collision with root package name */
    public HbgDialogItem f69101k;

    /* renamed from: l  reason: collision with root package name */
    public HbgDialogItem f69102l;

    /* renamed from: m  reason: collision with root package name */
    public e f69103m;

    /* renamed from: n  reason: collision with root package name */
    public long f69104n;

    /* renamed from: o  reason: collision with root package name */
    public e f69105o;

    /* renamed from: p  reason: collision with root package name */
    public long f69106p;

    public class a implements b.a {
        public a() {
        }

        public void a(String str, int i11) {
            if (BottomBarView.this.f69105o != null) {
                BottomBarView.this.f69105o.a(str, BottomBarView.this.f69106p, i11);
            }
            if (BottomBarView.this.r() && BottomBarView.this.f69097g.getVisibility() == 0) {
                ViewUtil.m(BottomBarView.this.f69096f, false);
                ViewUtil.m(BottomBarView.this.f69098h, false);
            } else if (BottomBarView.this.f69105o != null) {
                BottomBarView.this.f69105o.onDismiss();
            }
            HbgDialogItem unused = BottomBarView.this.f69102l = null;
        }

        public void onShow() {
        }
    }

    public BottomBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m(Context context, View view) {
        HashMap hashMap = new HashMap();
        HbgDialogConfigInfo hbgDialogConfigInfo = this.f69100j;
        if (hbgDialogConfigInfo != null) {
            hashMap.put("popup_id", Long.valueOf(hbgDialogConfigInfo.dialogId));
            hashMap.put("popup_name", this.f69100j.remark);
            hashMap.put("element_type", Integer.valueOf(this.f69100j.positionType));
            hashMap.put("business_category", this.f69100j.businessCategory);
            hashMap.put("updateStrategy", Integer.valueOf(this.f69100j.updateStrategy));
            hashMap.put("recomBaseInfo", this.f69100j.recomBaseInfo);
        }
        BaseModuleConfig.a().w("Ads_feature_click", hashMap);
        String str = this.f69101k.url;
        if (TextUtils.isEmpty(str) || !str.contains("holigeit")) {
            HBBaseWebActivity.showWebView(context, str, (String) null, (String) null, false);
        } else {
            BaseModuleConfig.a().k0(str);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(View view) {
        e eVar = this.f69103m;
        if (eVar != null) {
            eVar.a((String) null, this.f69104n, 0);
        }
        HashMap hashMap = new HashMap();
        HbgDialogConfigInfo hbgDialogConfigInfo = this.f69100j;
        if (hbgDialogConfigInfo != null) {
            hashMap.put("popup_id", Long.valueOf(hbgDialogConfigInfo.dialogId));
            hashMap.put("popup_name", this.f69100j.remark);
            hashMap.put("element_type", Integer.valueOf(this.f69100j.positionType));
            hashMap.put("business_category", this.f69100j.businessCategory);
            hashMap.put("updateStrategy", Integer.valueOf(this.f69100j.updateStrategy));
            hashMap.put("recomBaseInfo", this.f69100j.recomBaseInfo);
        }
        BaseModuleConfig.a().w("Ads_feature_close", hashMap);
        if (!q() || this.f69096f.getVisibility() != 0) {
            e eVar2 = this.f69103m;
            if (eVar2 != null) {
                eVar2.onDismiss();
            }
        } else {
            ViewUtil.m(this.f69097g, false);
            ViewUtil.m(this.f69098h, false);
        }
        this.f69101k = null;
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getLocationY() {
        int d11 = HbgDialogManager.A().z().d();
        d.c("BottomBarDialogFragment", "mainTab height = " + d11);
        return d11 + PixelUtils.a(4.0f);
    }

    public void l(Context context) {
        r rVar = new r(LayoutInflater.from(context).inflate(R$layout.dialog_bottom_bar, this));
        this.f69092b = (ImageView) rVar.b(R$id.iv_icon);
        this.f69093c = (TextView) rVar.b(R$id.tv_text);
        this.f69094d = (TextView) rVar.b(R$id.tv_btn);
        this.f69095e = (TextView) rVar.b(R$id.tv_close);
        this.f69098h = rVar.b(R$id.divider);
        this.f69096f = (FrameLayout) rVar.b(R$id.web_view_container);
        this.f69097g = rVar.b(R$id.native_container);
        rVar.b(R$id.ll_jump).setOnClickListener(new e7.b(this, context));
        this.f69095e.setOnClickListener(new e7.a(this));
    }

    public final boolean q() {
        HbgDialogItem hbgDialogItem = this.f69102l;
        return hbgDialogItem != null && !TextUtils.isEmpty(hbgDialogItem.url);
    }

    public final boolean r() {
        HbgDialogItem hbgDialogItem = this.f69101k;
        return hbgDialogItem != null && !TextUtils.isEmpty(hbgDialogItem.showText);
    }

    /* renamed from: s */
    public final void p() {
        if (getContext() != null && q()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f69096f.getLayoutParams();
            int g11 = n.g(getContext());
            PixelUtils.a(20.0f);
            layoutParams.height = (int) ((((float) g11) * 8.0f) / 71.0f);
            this.f69096f.setLayoutParams(layoutParams);
            HbgDialogWebView hbgDialogWebView = new HbgDialogWebView(getContext());
            this.f69099i = hbgDialogWebView;
            hbgDialogWebView.setBackgroundColor(getResources().getColor(R$color.transparent));
            this.f69099i.setHorizontalScrollBarEnabled(false);
            this.f69099i.setVerticalScrollBarEnabled(false);
            ImSdkModuleConfig.a().b(this.f69099i);
            HbgDialogWebView hbgDialogWebView2 = this.f69099i;
            hbgDialogWebView2.addJavascriptInterface(new b(hbgDialogWebView2, new a()), "hbWallet");
            this.f69096f.addView(this.f69099i, -1, -1);
        }
        ViewUtil.m(this.f69097g, r());
        ViewUtil.m(this.f69096f, q());
        ViewUtil.m(this.f69098h, q() && r());
        if (this.f69101k != null) {
            c.a().f(this.f69092b, this.f69101k.icon, R$drawable.default_icon);
            this.f69093c.setText(this.f69101k.showText);
            if (TextUtils.isEmpty(this.f69101k.url) || TextUtils.isEmpty(this.f69101k.buttonText)) {
                this.f69094d.setVisibility(8);
            } else {
                this.f69094d.setVisibility(0);
            }
            this.f69094d.setText(this.f69101k.buttonText);
            boolean equals = "1".equals(this.f69101k.showCloseButton);
            ViewUtil.m(this.f69095e, equals);
            if (!equals) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f69094d.getLayoutParams();
                layoutParams2.rightMargin = PixelUtils.a(8.0f);
                this.f69094d.setLayoutParams(layoutParams2);
            }
        }
        HbgDialogItem hbgDialogItem = this.f69102l;
        if (hbgDialogItem != null) {
            String str = hbgDialogItem.url;
            if (!TextUtils.isEmpty(str)) {
                String k11 = HbgDialogManager.A().z().k(str);
                HbgDialogWebView hbgDialogWebView3 = this.f69099i;
                String w11 = StringUtils.w(k11);
                hbgDialogWebView3.loadUrl(w11);
                SensorsDataAutoTrackHelper.loadUrl2(hbgDialogWebView3, w11);
            }
        }
    }

    public void setCallback(e eVar) {
        this.f69103m = eVar;
    }

    public void setConfigInfo(HbgDialogConfigInfo hbgDialogConfigInfo) {
        this.f69100j = hbgDialogConfigInfo;
    }

    public void setH5DialogCallback(e eVar) {
        this.f69105o = eVar;
    }

    public void setH5DialogId(long j11) {
        this.f69106p = j11;
    }

    public void setH5DialogItem(HbgDialogItem hbgDialogItem) {
        this.f69102l = hbgDialogItem;
        i.b().f(new e7.d(this));
    }

    public void setNativeDialogId(long j11) {
        this.f69104n = j11;
    }

    public void setNativeDialogItem(HbgDialogItem hbgDialogItem) {
        this.f69101k = hbgDialogItem;
        i.b().f(new e7.c(this));
    }

    public BottomBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomBarView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        l(context);
    }
}
