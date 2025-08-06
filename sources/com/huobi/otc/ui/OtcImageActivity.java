package com.huobi.otc.ui;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.persenter.OtcImagePersenter;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import g6.b;
import i6.i;
import sp.a1;
import sp.b1;
import sp.z0;

public class OtcImageActivity extends BaseActivity<OtcImagePersenter, OtcImagePersenter.a> implements OtcImagePersenter.a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f79451b;

    /* renamed from: c  reason: collision with root package name */
    public String f79452c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f79453d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f79454e;

    /* renamed from: f  reason: collision with root package name */
    public b f79455f;

    /* renamed from: g  reason: collision with root package name */
    public Toolbar f79456g;

    /* renamed from: h  reason: collision with root package name */
    public CoordinatorLayout f79457h;

    /* renamed from: i  reason: collision with root package name */
    public int f79458i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f79459j = new b1(this);

    public class a implements tx.a {
        public a() {
        }

        public void a(String str, View view) {
            OtcImageActivity.this.showProgressDialog();
            OtcImageActivity.this.f79454e.setClickable(false);
        }

        public void b(String str, View view, FailReason failReason) {
            OtcImageActivity.this.f79454e.setClickable(false);
            OtcImageActivity.this.Og();
            HuobiToastUtil.m(OtcImageActivity.this.getString(R$string.otc_order_image_down_failed_text));
        }

        public void c(String str, View view, Bitmap bitmap) {
            OtcImageActivity.this.Og();
            OtcImageActivity.this.f79454e.setClickable(true);
        }

        public void d(String str, View view) {
            OtcImageActivity.this.Og();
            HuobiToastUtil.m(OtcImageActivity.this.getString(R$string.otc_order_image_down_failed_text));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Qg(HBDialogFragment hBDialogFragment) {
        oh();
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        ((OtcImagePersenter) getPresenter()).R(this.f79453d.getDrawable(), this.f79458i == 3);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Og() {
        i.b().g(this.f79459j, 200);
    }

    /* renamed from: Pg */
    public OtcImagePersenter.a getUI() {
        return this;
    }

    public void X7() {
        new DialogUtils.b.d(this).C0(getString(R$string.otc_order_detail_open_wechat)).P0(getString(R$string.otc_order_detail_open_confirm)).s0(getString(R$string.global_string_cancel)).Q0(new a1(this)).N0(ad.b.f3517a).j0().show(getSupportFragmentManager(), "");
    }

    public void addEvent() {
        this.f79454e.setOnClickListener(new z0(this));
    }

    public int getContentView() {
        return R$layout.activity_otc_image;
    }

    /* renamed from: gg */
    public OtcImagePersenter createPresenter() {
        return new OtcImagePersenter();
    }

    public void initView() {
        TextView textView = (TextView) this.viewFinder.b(R$id.otc_imageshow_title_tv);
        this.f79451b = textView;
        textView.setText(getString(R$string.otc_imageshow_qrcode_text));
        this.f79453d = (ImageView) this.viewFinder.b(R$id.otc_imageshow_iv);
        this.f79454e = (ImageView) this.viewFinder.b(R$id.otc_downimage_iv);
        this.f79452c = getIntent().getStringExtra(MessengerShareContentUtility.IMAGE_URL);
        this.f79458i = getIntent().getIntExtra("pay_method", 0);
        b c11 = b.c();
        this.f79455f = c11;
        c11.k(this.f79453d, this.f79452c, -1, new a());
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R$id.toolbar);
        this.f79456g = toolbar;
        setToolBar(toolbar, "", true);
        this.f79457h = (CoordinatorLayout) this.viewFinder.b(R$id.otc_img_coord);
    }

    @SuppressLint({"WrongConstant"})
    public void oh() {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, "com.tencent.mm.ui.LauncherUI"));
            intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
            intent.setFlags(335544320);
            intent.setAction("android.intent.action.VIEW");
            startActivity(intent);
        } catch (Exception unused) {
            OtcModuleConfig.b().p();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        i.b().h(this.f79459j);
    }
}
