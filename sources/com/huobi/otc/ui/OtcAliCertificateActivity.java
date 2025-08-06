package com.huobi.otc.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.module.otc.R$layout;
import com.huobi.lite.kyc.aliface.AbstractAliCertificateResult;
import com.huobi.lite.kyc.aliface.AliFaceCertificate;
import com.huobi.lite.kyc.aliface.a;
import com.huobi.lite.kyc.presenter.LiteVerifiedPresenter;
import com.luck.picture.lib.permissions.PermissionConfig;
import java.util.List;

public class OtcAliCertificateActivity extends BaseActivity<LiteVerifiedPresenter, LiteVerifiedPresenter.c> implements EasyPermissions.PermissionCallbacks, LiteVerifiedPresenter.c {

    /* renamed from: b  reason: collision with root package name */
    public int f79281b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f79282c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f79283d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f79284e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f79285f;

    public class a extends AbstractAliCertificateResult {
        public a() {
        }

        public void a() {
        }
    }

    public static void gg(Context context, boolean z11, boolean z12) {
        Intent intent = new Intent(context, OtcAliCertificateActivity.class);
        intent.putExtra("OtcAliCertificateActivity.isTrading", z12);
        intent.putExtra("OtcAliCertificateActivity.isRisk", z11);
        context.startActivity(intent);
    }

    public boolean Ha() {
        return true;
    }

    public void Kf(String str) {
        this.f79282c = str;
    }

    public void Xc(String str) {
        this.f79283d = str;
        fg();
    }

    /* renamed from: Xf */
    public LiteVerifiedPresenter createPresenter() {
        return new LiteVerifiedPresenter();
    }

    /* renamed from: Yf */
    public LiteVerifiedPresenter.c getUI() {
        return this;
    }

    public final void Zf() {
        new a.b(this).m(this.f79283d).j(new AliFaceCertificate()).l(new a()).e().a();
    }

    public void addEvent() {
    }

    @AfterPermissionGranted(123)
    public void fg() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        this.f79281b = strArr.length;
        if (EasyPermissions.hasPermissions(this, strArr)) {
            Zf();
        } else {
            EasyPermissions.requestPermissions(this, 123, strArr);
        }
    }

    public int getContentView() {
        return R$layout.activity_ali_certificate_layout;
    }

    public void initView() {
        this.f79284e = getIntent().getBooleanExtra("OtcAliCertificateActivity.isTrading", false);
        this.f79285f = getIntent().getBooleanExtra("OtcAliCertificateActivity.isRisk", false);
    }

    public void ma(int i11, String str) {
        OtcCertificationResultActivity.Og(this, this.f79285f, 1048578, str, this.f79284e);
        finish();
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setFlags(512, 512);
        }
        super.onCreate(bundle);
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        finish();
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        int i12 = this.f79281b - 1;
        this.f79281b = i12;
        if (i12 == 0) {
            Zf();
        }
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        EasyPermissions.onRequestPermissionsResult(i11, strArr, iArr, this);
    }
}
