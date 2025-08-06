package com.hbg.lib.core.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.zxing.WriterException;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.R$dimen;
import com.hbg.lib.core.R$id;
import com.hbg.lib.core.R$layout;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.utils.ImageUtils;
import com.luck.picture.lib.config.SelectMimeType;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import i6.k;
import java.io.File;
import u6.m;
import u6.n;
import u6.o;
import u6.p;

public class ScreenshotShareActivity extends BaseActivity {

    /* renamed from: b  reason: collision with root package name */
    public String f68574b;

    /* renamed from: c  reason: collision with root package name */
    public String f68575c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f68576d;

    /* renamed from: e  reason: collision with root package name */
    public View f68577e;

    /* renamed from: f  reason: collision with root package name */
    public float f68578f;

    /* renamed from: g  reason: collision with root package name */
    public String f68579g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f68580h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f68581i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f68582j;

    /* renamed from: k  reason: collision with root package name */
    public ViewGroup f68583k;

    /* renamed from: l  reason: collision with root package name */
    public ViewGroup f68584l;

    /* renamed from: m  reason: collision with root package name */
    public ViewGroup f68585m;

    /* renamed from: n  reason: collision with root package name */
    public ViewGroup f68586n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f68587o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f68588p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f68589q;

    /* renamed from: r  reason: collision with root package name */
    public ShareStatus f68590r;

    public enum ShareStatus {
        SHARE_START,
        SHARE_STOP
    }

    public class a implements tx.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f68591a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f68592b;

        public a(View view, String str) {
            this.f68591a = view;
            this.f68592b = str;
        }

        public void a(String str, View view) {
        }

        public void b(String str, View view, FailReason failReason) {
        }

        public void c(String str, View view, Bitmap bitmap) {
            Bitmap b11 = ImageUtils.b(this.f68591a);
            ScreenshotShareActivity screenshotShareActivity = ScreenshotShareActivity.this;
            String qh2 = screenshotShareActivity.qh(screenshotShareActivity, b11);
            String unused = ScreenshotShareActivity.this.f68579g = "";
            if (this.f68592b.equalsIgnoreCase("save")) {
                HuobiToastUtil.s(R$string.save_success);
                ScreenshotShareActivity.this.finish();
            } else if (this.f68592b.equalsIgnoreCase("share")) {
                ScreenshotShareActivity.this.rh(qh2);
            }
        }

        public void d(String str, View view) {
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        Pg("save");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        Pg("share");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void oh(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public boolean Og() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public void Pg(String str) {
        View inflate = LayoutInflater.from(this).inflate(R$layout.layout_screenshot_share, getParentLayout(), false);
        TextView textView = (TextView) inflate.findViewById(R$id.share_img_subtitle);
        if (!TextUtils.isEmpty(this.f68574b)) {
            textView.setText(this.f68574b);
        }
        try {
            ((ImageView) inflate.findViewById(R$id.share_img_qrcode)).setImageBitmap(ImageUtils.c(Qg(), (int) this.f68578f));
        } catch (WriterException e11) {
            e11.printStackTrace();
        }
        int statusBarHeight = BaseActivity.getStatusBarHeight(this);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.pine_image);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.setMargins(0, -statusBarHeight, 0, 0);
        imageView.setLayoutParams(layoutParams);
        b.c().k(imageView, this.f68579g, -1, new a(inflate, str));
    }

    public final String Qg() {
        String curLanguageUrlLowerCase = AppLanguageHelper.getInstance().getCurLanguageUrlLowerCase();
        return "https://www.huobi.com/" + curLanguageUrlLowerCase;
    }

    public void addEvent() {
        ph();
        this.f68581i.setOnClickListener(new n(this));
        this.f68583k.setOnClickListener(new m(this));
        this.f68584l.setOnClickListener(new p(this));
        this.f68585m.setOnClickListener(new o(this));
    }

    public boolean canFullScreen() {
        return true;
    }

    public ActivityPresenter createPresenter() {
        return new EmptyActPresenter();
    }

    public int getContentView() {
        getWindow().addFlags(8192);
        return R$layout.activity_screenshot_main_share;
    }

    public h6.a getUI() {
        return this;
    }

    public void initView() {
        k.o("ScreenShotActivity", "initView");
        this.f68582j = (ImageView) this.viewFinder.b(R$id.screen_shot_iv);
        this.f68576d = (ImageView) this.viewFinder.b(R$id.share_img_qrcode);
        this.f68577e = this.viewFinder.b(R$id.share_img_root);
        this.f68580h = (ImageView) this.viewFinder.b(R$id.id_screen_share_iv);
        this.f68581i = (ImageView) this.viewFinder.b(R$id.screenshot_share_close);
        this.f68583k = (ViewGroup) this.viewFinder.b(R$id.root_container);
        this.f68584l = (ViewGroup) this.viewFinder.b(R$id.id_screen_save_vg);
        this.f68585m = (ViewGroup) this.viewFinder.b(R$id.id_screen_share_vg);
        this.f68587o = (TextView) this.viewFinder.b(R$id.id_screen_save_tv);
        this.f68588p = (TextView) this.viewFinder.b(R$id.id_screen_share_tv);
        this.f68586n = (ViewGroup) this.viewFinder.b(R$id.share_container);
        this.f68587o.setText(getResources().getString(R$string.n_share_save_image));
        this.f68588p.setText(getResources().getString(R$string.n_share_sys_share));
        this.f68579g = getIntent().getStringExtra("screenshot");
        this.f68574b = getIntent().getStringExtra(MessengerShareContentUtility.SUBTITLE);
        this.f68575c = getIntent().getStringExtra("url");
        this.f68589q = getIntent().getBooleanExtra("sharebar", false);
        String str = this.f68579g;
        if (str == null || str.isEmpty()) {
            finish();
        }
        String str2 = this.f68574b;
        if (str2 == null || str2.isEmpty()) {
            this.f68574b = getResources().getString(R$string.n_share_default_ten_year);
        }
        String str3 = this.f68575c;
        if (str3 == null || str3.isEmpty()) {
            this.f68575c = Qg();
        }
        this.f68578f = getResources().getDimension(R$dimen.dimen_67);
        if (!this.f68589q) {
            this.f68590r = ShareStatus.SHARE_START;
            this.f68586n.setVisibility(4);
            Pg("share");
        }
    }

    public void onCreate(Bundle bundle) {
        k.o("ScreenShotActivity", "onCreate");
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
        }
    }

    public void onRestart() {
        k.o("ScreenShotActivity", "onRestart");
        super.onRestart();
        this.f68590r = ShareStatus.SHARE_STOP;
    }

    public void onResume() {
        k.o("ScreenShotActivity", "onResume");
        super.onResume();
        if (this.f68590r == ShareStatus.SHARE_START) {
            this.f68590r = ShareStatus.SHARE_STOP;
        } else {
            finish();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        k.o("ScreenShotActivity", "onSaveInstanceState");
        super.onSaveInstanceState(bundle);
        bundle.putString("screenshot", this.f68579g);
    }

    public void ph() {
        String str = this.f68579g;
        if (str != null && !str.isEmpty()) {
            b.c().h(this.f68582j, this.f68579g);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0096 A[SYNTHETIC, Splitter:B:26:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a5 A[SYNTHETIC, Splitter:B:32:0x00a5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String qh(android.content.Context r8, android.graphics.Bitmap r9) {
        /*
            r7 = this;
            java.lang.String r0 = "ScreenShotActivity"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = android.os.Environment.DIRECTORY_DCIM
            java.io.File r2 = android.os.Environment.getExternalStoragePublicDirectory(r2)
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            r1.append(r2)
            java.lang.String r2 = "Camera"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r1 = r2.exists()
            if (r1 != 0) goto L_0x002c
            r2.mkdir()
        L_0x002c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Huobi_Deposit_"
            r1.append(r3)
            long r3 = com.hbg.lib.common.utils.DateTimeUtils.v()
            r1.append(r3)
            java.lang.String r3 = ".jpg"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.io.File r3 = new java.io.File
            r3.<init>(r2, r1)
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x008b, all -> 0x0089 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x008b, all -> 0x0089 }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x0087 }
            r5 = 90
            boolean r9 = r9.compress(r4, r5, r2)     // Catch:{ IOException -> 0x0087 }
            r2.flush()     // Catch:{ IOException -> 0x0087 }
            r2.close()     // Catch:{ IOException -> 0x0087 }
            android.net.Uri r4 = android.net.Uri.fromFile(r3)     // Catch:{ IOException -> 0x0087 }
            android.content.Intent r5 = new android.content.Intent     // Catch:{ IOException -> 0x0087 }
            java.lang.String r6 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            r5.<init>(r6, r4)     // Catch:{ IOException -> 0x0087 }
            r8.sendBroadcast(r5)     // Catch:{ IOException -> 0x0087 }
            if (r9 == 0) goto L_0x0080
            java.lang.String r8 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x0087 }
            r2.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007f
        L_0x0077:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            i6.k.f(r0, r9)
        L_0x007f:
            return r8
        L_0x0080:
            r2.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x00a2
        L_0x0084:
            r8 = move-exception
            r1 = r2
            goto L_0x00a3
        L_0x0087:
            r8 = move-exception
            goto L_0x008d
        L_0x0089:
            r8 = move-exception
            goto L_0x00a3
        L_0x008b:
            r8 = move-exception
            r2 = r1
        L_0x008d:
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x0084 }
            i6.k.f(r0, r8)     // Catch:{ all -> 0x0084 }
            if (r2 == 0) goto L_0x00a2
            r2.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x00a2
        L_0x009a:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()
            i6.k.f(r0, r8)
        L_0x00a2:
            return r1
        L_0x00a3:
            if (r1 == 0) goto L_0x00b1
            r1.close()     // Catch:{ IOException -> 0x00a9 }
            goto L_0x00b1
        L_0x00a9:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            i6.k.f(r0, r9)
        L_0x00b1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.core.ui.ScreenshotShareActivity.qh(android.content.Context, android.graphics.Bitmap):java.lang.String");
    }

    public void rh(String str) {
        Uri uri;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(str);
                    if (file.exists()) {
                        if (Og()) {
                            uri = FileProvider.getUriForFile(this, GlobalAppConfig.a() + ".fileprovider", new File(str));
                        } else {
                            uri = Uri.fromFile(file);
                        }
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setType(SelectMimeType.SYSTEM_IMAGE);
                        intent.putExtra("android.intent.extra.STREAM", uri);
                        startActivity(Intent.createChooser(intent, "share"));
                    }
                }
            } catch (NullPointerException e11) {
                k.f("ScreenShotActivity", e11.getMessage());
            }
        }
    }
}
