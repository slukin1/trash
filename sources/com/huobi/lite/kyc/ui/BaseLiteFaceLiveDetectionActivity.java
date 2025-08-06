package com.huobi.lite.kyc.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.lite.kyc.presenter.LiteVerifiedPresenter;
import com.huobi.otc.ui.OtcCertificationResultActivity;
import com.luck.picture.lib.permissions.PermissionConfig;
import dw.a;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BaseLiteFaceLiveDetectionActivity extends BaseActivity<LiteVerifiedPresenter, LiteVerifiedPresenter.c> implements LiteVerifiedPresenter.c, EasyPermissions.PermissionCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public String f75390b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f75391c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f75392d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f75393e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f75394f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f75395g;

    /* renamed from: h  reason: collision with root package name */
    public int f75396h = 0;

    public static void Og(Activity activity, String str, String str2, String str3, boolean z11) {
        gg(activity, str, str2, str3, "", z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fg(Void voidR) {
        String str = this.f75392d;
        if (str == null || str.isEmpty()) {
            ((LiteVerifiedPresenter) getPresenter()).U(this.f75390b, this.f75391c);
        } else {
            Qg();
        }
    }

    public static void gg(Activity activity, String str, String str2, String str3, String str4, boolean z11) {
        Intent intent = new Intent(activity, LiteAliDetectionActivity.class);
        intent.putExtra("LiteLiveDetectionActivity.identityName", str);
        intent.putExtra("LiteLiveDetectionActivity.identityNumber", str2);
        intent.putExtra("LiteLiveDetectionActivity.mToken", str3);
        intent.putExtra("LiteLiveDetectionActivity.mBizId", str4);
        intent.putExtra("LiteLiveDetectionActivity.isTrading", z11);
        activity.startActivity(intent);
    }

    public boolean Ha() {
        return false;
    }

    public void Kf(String str) {
        this.f75393e = str;
    }

    public abstract void Pg(String str, String str2);

    @AfterPermissionGranted(123)
    public void Qg() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        this.f75396h = strArr.length;
        if (EasyPermissions.hasPermissions(this, strArr)) {
            Pg(this.f75392d, this.f75393e);
        } else {
            EasyPermissions.requestPermissions(this, 123, strArr);
        }
    }

    public void Xc(String str) {
        this.f75392d = str;
        Qg();
    }

    /* renamed from: Yf */
    public LiteVerifiedPresenter createPresenter() {
        return new LiteVerifiedPresenter();
    }

    /* renamed from: Zf */
    public LiteVerifiedPresenter.c getUI() {
        return this;
    }

    public void addEvent() {
        a.a(this.f75395g).throttleFirst(1, TimeUnit.SECONDS).subscribe(new in.a(this));
    }

    public int getContentView() {
        return R$layout.lite_activity_live_detection;
    }

    public void initView() {
        this.f75390b = getIntent().getStringExtra("LiteLiveDetectionActivity.identityName");
        this.f75391c = getIntent().getStringExtra("LiteLiveDetectionActivity.identityNumber");
        this.f75392d = getIntent().getStringExtra("LiteLiveDetectionActivity.mToken");
        this.f75393e = getIntent().getStringExtra("LiteLiveDetectionActivity.mBizId");
        this.f75394f = getIntent().getBooleanExtra("LiteLiveDetectionActivity.isTrading", false);
        if (this.f75390b == null) {
            this.f75390b = "";
        }
        String str = "*";
        if (this.f75390b.length() != 1) {
            if (this.f75390b.length() > 1) {
                str = str + this.f75390b.substring(1);
            } else {
                str = "";
            }
        }
        ((TextView) this.viewFinder.b(R$id.lite_fisk_begin_tv)).setText(String.format(getString(R$string.lite_risk_begin_hint), new Object[]{str}));
        this.f75395g = (TextView) this.viewFinder.b(R$id.risk_begin_tv);
        setToolBar((Toolbar) this.viewFinder.b(R$id.toolbar), "", true);
    }

    public void ma(int i11, String str) {
        OtcCertificationResultActivity.Og(this, false, 1048578, str, this.f75394f);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == 17) {
            this.f75392d = "";
            this.f75395g.performClick();
        } else if (i12 == 18) {
            this.f75392d = "";
        }
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, list)) {
            new AppSettingsDialog.Builder((Activity) this, getString(R$string.currency_deposit_permission_camera_write_external_storage_apply)).setPositiveButton(getString(R$string.currency_deposit_go_to_settings)).setNegativeButton(getString(R$string.n_otc_new_otc_cancel), (DialogInterface.OnClickListener) null).setRequestCode(126).build().show();
        }
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        int i12 = this.f75396h - 1;
        this.f75396h = i12;
        if (i12 == 0) {
            Pg(this.f75392d, this.f75393e);
        }
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        EasyPermissions.onRequestPermissionsResult(i11, strArr, iArr, this);
    }
}
