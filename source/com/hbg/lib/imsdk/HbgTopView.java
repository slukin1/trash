package com.hbg.lib.imsdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.HbgDialogConfigInfo;
import com.hbg.lib.network.hbg.core.bean.HbgDialogItem;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import e7.g;
import e7.t;
import e7.u;
import e7.v;
import e7.w;
import e7.x;
import i6.k;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class HbgTopView extends ConstraintLayout {

    /* renamed from: b  reason: collision with root package name */
    public boolean f69153b;

    /* renamed from: c  reason: collision with root package name */
    public HbgDialogItem f69154c;

    /* renamed from: d  reason: collision with root package name */
    public UpSlideView f69155d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f69156e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f69157f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f69158g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f69159h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f69160i;

    /* renamed from: j  reason: collision with root package name */
    public c f69161j;

    /* renamed from: k  reason: collision with root package name */
    public int f69162k;

    /* renamed from: l  reason: collision with root package name */
    public int f69163l;

    /* renamed from: m  reason: collision with root package name */
    public long f69164m;

    /* renamed from: n  reason: collision with root package name */
    public HbgDialogConfigInfo f69165n;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 0.0f);
        }
    }

    public class b extends BaseSubscriber<Long> {
        public b() {
        }

        public void onNext(Long l11) {
            if (HbgTopView.this.f69161j != null) {
                HbgTopView.this.f69161j.a(HbgTopView.this.f69164m);
                HbgTopView.this.q();
            }
        }
    }

    public interface c {
        void a(long j11);

        void onDismiss();
    }

    public HbgTopView(Activity activity) {
        this(activity, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s() {
        g.a(this.f69165n);
        c cVar = this.f69161j;
        if (cVar != null) {
            cVar.a(this.f69164m);
            q();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void t(View view) {
        y();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void u(View view) {
        y();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void w(View view) {
        y();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void x(View view) {
        g.a(this.f69165n);
        c cVar = this.f69161j;
        if (cVar != null) {
            cVar.a(this.f69164m);
            q();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void A(HbgDialogConfigInfo hbgDialogConfigInfo, HbgDialogItem hbgDialogItem) {
        this.f69165n = hbgDialogConfigInfo;
        this.f69164m = hbgDialogConfigInfo.dialogId;
        this.f69154c = hbgDialogItem;
        C();
    }

    public void B() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.height = -2;
        layoutParams.gravity = 48;
        layoutParams.flags = 8;
        layoutParams.format = 1;
        layoutParams.windowAnimations = R$style.DialogTopTranslatorAnimation;
        layoutParams.width = getStandardWindowWidth();
        try {
            ((WindowManager) getContext().getSystemService("window")).addView(this, layoutParams);
            g7.a.a(this);
        } catch (Exception e11) {
            k.f("EXCEPTION", "add top view:" + e11.toString());
        }
    }

    public final void C() {
        HbgDialogItem hbgDialogItem = this.f69154c;
        boolean z11 = true;
        boolean z12 = false;
        if (hbgDialogItem != null) {
            if (!TextUtils.isEmpty(hbgDialogItem.icon)) {
                ViewUtil.m(this.f69156e, true);
                g6.b.c().i(this.f69156e, this.f69154c.icon, R$drawable.icon_hbg_dialog_top_default_image);
            } else {
                ViewUtil.m(this.f69156e, false);
            }
            if (!TextUtils.isEmpty(this.f69154c.showTitle)) {
                ViewUtil.m(this.f69157f, true);
                this.f69157f.setText(this.f69154c.showTitle);
                this.f69157f.setTextColor(Color.parseColor(this.f69153b ? "#F0F1F4" : "#212D43"));
            } else {
                ViewUtil.m(this.f69157f, false);
            }
            if (!TextUtils.isEmpty(this.f69154c.showText)) {
                ViewUtil.m(this.f69158g, true);
                this.f69158g.setText(this.f69154c.showText);
                this.f69158g.setTextColor(Color.parseColor(this.f69153b ? "#808799" : "#6B788E"));
            } else {
                ViewUtil.m(this.f69158g, false);
            }
            if (!TextUtils.isEmpty(this.f69154c.buttonText)) {
                ViewUtil.m(this.f69159h, true);
                this.f69159h.setText(this.f69154c.buttonText);
            } else {
                ViewUtil.m(this.f69159h, false);
            }
            if (TextUtils.isEmpty(this.f69154c.showCloseButton) || !"1".equals(this.f69154c.showCloseButton)) {
                ViewUtil.m(this.f69160i, false);
            } else {
                ViewUtil.m(this.f69160i, true);
                z12 = true;
            }
            z11 = true ^ z12;
        } else {
            ViewUtil.m(this.f69156e, false);
            ViewUtil.m(this.f69157f, false);
            ViewUtil.m(this.f69158g, false);
            ViewUtil.m(this.f69159h, false);
            ViewUtil.m(this.f69160i, true);
        }
        if (z11) {
            HbgDialogConfigInfo hbgDialogConfigInfo = this.f69165n;
            Observable.timer((hbgDialogConfigInfo == null || hbgDialogConfigInfo.businessId != 9) ? 5000 : 10000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b());
        }
        g.c(this.f69165n);
    }

    public long getDialogId() {
        return this.f69164m;
    }

    public int getStandardWindowWidth() {
        return PixelUtils.g() - 24;
    }

    public void q() {
        try {
            ((WindowManager) getContext().getSystemService("window")).removeView(this);
        } catch (Exception e11) {
            k.f("EXCEPTION", "remove top view:" + e11.toString());
        }
        c cVar = this.f69161j;
        if (cVar != null) {
            cVar.onDismiss();
        }
    }

    public void r(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.hb_im_top_dialog, this);
        this.f69155d = (UpSlideView) inflate.findViewById(R$id.clyt_im_top_root);
        this.f69156e = (ImageView) inflate.findViewById(R$id.iv_im_top_left_icon);
        this.f69157f = (TextView) inflate.findViewById(R$id.tv_im_top_title);
        this.f69158g = (TextView) inflate.findViewById(R$id.tv_im_top_subtitle);
        this.f69159h = (TextView) inflate.findViewById(R$id.tv_im_top_right_check);
        this.f69160i = (ImageView) inflate.findViewById(R$id.iv_im_top_right_close);
        this.f69155d.setBackgroundColor(Color.parseColor(this.f69153b ? "#212632" : "#FFFFFF"));
        this.f69155d.setGestureCallback(new x(this));
        if (Build.VERSION.SDK_INT >= 28) {
            this.f69155d.setElevation(10.0f);
            this.f69155d.setTranslationZ(10.0f);
            this.f69155d.setClipToOutline(true);
            this.f69155d.setOutlineSpotShadowColor(this.f69153b ? this.f69163l : this.f69162k);
            this.f69155d.setOutlineAmbientShadowColor(this.f69153b ? this.f69163l : this.f69162k);
            this.f69155d.setOutlineProvider(new a());
        }
        this.f69156e.setOnClickListener(new u(this));
        inflate.findViewById(R$id.llyt_im_top_text).setOnClickListener(new t(this));
        this.f69159h.setOnClickListener(new w(this));
        this.f69160i.setOnClickListener(new v(this));
    }

    public void setCallback(c cVar) {
        this.f69161j = cVar;
    }

    public final void y() {
        String str = this.f69154c.url;
        c cVar = this.f69161j;
        if (cVar != null) {
            cVar.a(this.f69164m);
            q();
        }
        if (TextUtils.isEmpty(str) || !str.contains("holigeit")) {
            HBBaseWebActivity.showWebView(getContext(), str, "", "", false);
        } else {
            BaseModuleConfig.a().k0(str);
        }
        g.b(this.f69165n);
    }

    public HbgTopView(Activity activity, AttributeSet attributeSet) {
        this(activity, attributeSet, 0);
    }

    public HbgTopView(Activity activity, AttributeSet attributeSet, int i11) {
        super(activity, attributeSet, i11);
        this.f69153b = NightHelper.e().g();
        this.f69162k = Color.parseColor("#4D000000");
        this.f69163l = Color.parseColor("#1A000000");
        this.f69164m = -1;
        r(activity);
    }
}
