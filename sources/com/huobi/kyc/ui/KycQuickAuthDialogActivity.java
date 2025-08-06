package com.huobi.kyc.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.network.newkyc.bean.KycCountryInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.account.ability.KycGetColorAbility;
import com.huobi.account.ability.KycGetFlagUrlAbility;
import com.huobi.account.ability.KycGetTextAbility;
import com.huobi.account.ability.KycSelectBirthdayAbility;
import com.huobi.account.ability.KycSelectNationalityAbility;
import com.huobi.utils.GsonHelper;
import com.huobi.utils.StatusBarUtils;
import com.huobi.utils.a0;
import com.huochat.community.util.ToastTool;
import dw.a;
import e6.g;
import f6.c;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rj.b;
import sn.f;
import um.p;
import um.q;
import um.r;
import um.s;
import um.t;
import um.u;
import um.v;
import um.w;
import um.x;
import um.y;

@Route(path = "/account/kycQuickAuth")
public class KycQuickAuthDialogActivity extends EmptyMVPActivity {

    /* renamed from: h  reason: collision with root package name */
    public static final String f74902h = "KycQuickAuthDialogActivity";

    /* renamed from: b  reason: collision with root package name */
    public b f74903b;

    /* renamed from: c  reason: collision with root package name */
    public String f74904c = "0";

    /* renamed from: d  reason: collision with root package name */
    public View f74905d;

    /* renamed from: e  reason: collision with root package name */
    public View f74906e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayoutCompat f74907f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayoutCompat f74908g;

    /* access modifiers changed from: private */
    public /* synthetic */ void Ah(Void voidR) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rh(ImageView imageView, String str, int i11) {
        if (str != null) {
            if (str.startsWith("http")) {
                c.a().f(imageView, str, i11);
            } else {
                imageView.setImageDrawable(g.v().s(getResources(), str));
            }
        }
    }

    public static /* synthetic */ void sh(Object obj) {
        if (obj != null) {
            String str = a0.j() + f.s() + obj;
            Log.d(f74902h, "H5 url: " + str);
            BaseModuleConfig.a().k0(str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void th(Object obj) {
        setResult(-1, new Intent().putExtra("changeToDmcPage", Boolean.valueOf(this.f74903b.e("changeToDmcPage"))));
        finish();
    }

    public static /* synthetic */ void uh(Object obj) {
        if (obj instanceof String) {
            ToastTool.showShort((String) obj);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vh(Object obj) {
        if (obj == null || !(obj instanceof Boolean)) {
            return;
        }
        if (((Boolean) obj).booleanValue()) {
            showProgressDialog();
        } else {
            dismissProgressDialog();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wh(Object obj) {
        if (obj != null && (obj instanceof Integer)) {
            qh(((Integer) obj).intValue());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh(HBDialogFragment hBDialogFragment) {
        this.f74904c = "1";
        b bVar = this.f74903b;
        bVar.I("initQuickKycData(" + this.f74904c + ")");
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh(Object obj) {
        DialogUtils.b0(this, getResources().getString(R.string.allow_access_dialog_title), getResources().getString(R.string.n_kyc_quick_nationality_not_support_meta), "", getResources().getString(R.string.cancel), getResources().getString(R.string.n_dialog_ok), q.f60846a, new p(this));
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.activity_bottom_out);
    }

    public int getContentView() {
        return R.layout.kyc_quick_auth_dialog;
    }

    public void initExtra() {
        super.initExtra();
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("authType");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.f74904c = stringExtra;
            }
        }
    }

    public void initView() {
        super.initView();
        this.f74907f = (LinearLayoutCompat) findViewById(R.id.dialogRoot);
        this.f74908g = (LinearLayoutCompat) findViewById(R.id.llResult);
        b bVar = new b(this, "kycquickauth");
        this.f74903b = bVar;
        bVar.t("kycSelectBirthday", KycSelectBirthdayAbility.class);
        this.f74903b.t("kycSelectNationality", KycSelectNationalityAbility.class);
        this.f74903b.t("kycGetText", KycGetTextAbility.class);
        this.f74903b.t("kycGetFlagUrl", KycGetFlagUrlAbility.class);
        this.f74903b.t("kycGetColor", KycGetColorAbility.class);
        this.f74903b.J(new r(this));
        this.f74903b.H();
        this.f74903b.v("openKycAuthPage", x.f60853a);
        this.f74903b.v("kycCloseView", new v(this));
        this.f74903b.v("showKycAuthToast", y.f60854a);
        this.f74903b.v("showKycAuthLoading", new u(this));
        this.f74903b.v("kycChangedView", new w(this));
        this.f74903b.v("showKycAuthAlert", new t(this));
        b bVar2 = this.f74903b;
        bVar2.I("initQuickKycData(" + this.f74904c + ")");
        a.a(findViewById(R.id.topLayout)).throttleFirst(1, TimeUnit.SECONDS).subscribe(new s(this));
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 999) {
            String str = "setCountryInfo('" + GsonHelper.a().toJson((Object) (KycCountryInfo) intent.getSerializableExtra("country_info")) + "')";
            Log.d(f74902h, "onActivityResult: " + str);
            this.f74903b.I(str);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        b bVar = this.f74903b;
        if (bVar != null) {
            bVar.B();
        }
    }

    public void onPause() {
        super.onPause();
    }

    public final void qh(int i11) {
        if (i11 == 0) {
            if (this.f74905d == null) {
                View E = this.f74903b.E("kyc_quick_auth_dialog.xml", this, false, (JSONObject) null);
                this.f74905d = E;
                this.f74907f.addView(E);
            }
            initStatus();
            findViewById(R.id.llResult).setVisibility(8);
            findViewById(R.id.llInput).setVisibility(0);
            this.f74905d.setVisibility(0);
            View view = this.f74906e;
            if (view != null) {
                view.setVisibility(8);
            }
        } else if (i11 == 1) {
            if (this.f74906e == null) {
                View E2 = this.f74903b.E("kyc_quick_auth_pass_dialog.xml", this, false, (JSONObject) null);
                this.f74906e = E2;
                this.f74908g.addView(E2);
            }
            StatusBarUtils.g(this, Color.parseColor("#50000000"));
            this.f74906e.setVisibility(0);
            findViewById(R.id.llResult).setVisibility(0);
            if (this.f74905d == null) {
                findViewById(R.id.llInput).setVisibility(8);
            }
        }
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
