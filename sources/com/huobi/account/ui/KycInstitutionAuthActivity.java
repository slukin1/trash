package com.huobi.account.ui;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.account.ability.KycGetTextAbility;
import com.huobi.account.ability.KycInstitutionAuthAbility;
import com.huobi.utils.a0;
import com.huochat.community.util.ToastTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import rj.b;

@Route(path = "/account/institutionKyc")
public class KycInstitutionAuthActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public b f41216b;

    /* renamed from: c  reason: collision with root package name */
    public LoadingLayout f41217c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41218d = true;

    public static /* synthetic */ void Og(Object obj) {
        if (obj != null) {
            ToastTool.showShort((String) obj);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Pg(Object obj) {
        if (obj == null) {
            return;
        }
        if (((Boolean) obj).booleanValue()) {
            this.f41217c.g();
        } else {
            this.f41217c.k();
        }
    }

    public static /* synthetic */ void gg(Object obj) {
        if (obj != null) {
            BaseModuleConfig.a().k0(a0.j() + obj);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        this.f41217c.p();
        this.f41216b.I("initInstData()");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void afterInit() {
        super.afterInit();
    }

    public int getContentView() {
        return R.layout.activity_institution_auth_kyc;
    }

    public void initView() {
        super.initView();
        LoadingLayout loadingLayout = (LoadingLayout) findViewById(R.id.loading_layout);
        this.f41217c = loadingLayout;
        loadingLayout.p();
        this.f41217c.setOnRetryClickListener(new d0(this));
        b bVar = new b(this, "authkyc");
        this.f41216b = bVar;
        bVar.t("kycCountryName", KycInstitutionAuthAbility.class);
        this.f41216b.t("kycGetText", KycGetTextAbility.class);
        this.f41216b.H();
        this.f41216b.v("openKycAuthPage", f0.f41678a);
        this.f41216b.v("showKycAuthToast", g0.f41686a);
        this.f41216b.v("loadFinished", new e0(this));
        ((NestedScrollView) findViewById(R.id.rankingListRoot)).addView(this.f41216b.E("institution_kyc.xml", this, false, (JSONObject) null));
    }

    public void onDestroy() {
        super.onDestroy();
        b bVar = this.f41216b;
        if (bVar != null) {
            bVar.B();
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.f41218d) {
            this.f41216b.I("initInstData()");
            this.f41217c.p();
            return;
        }
        this.f41218d = false;
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
